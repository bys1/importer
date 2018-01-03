package eu.taigacraft.importer.permissions;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.OfflinePlayer;
import org.bukkit.scheduler.BukkitRunnable;

import eu.taigacraft.importer.ImporterCallback;
import eu.taigacraft.importer.ImporterPlugin;

import me.lucko.luckperms.LuckPerms;
import me.lucko.luckperms.api.Contexts;
import me.lucko.luckperms.api.LuckPermsApi;
import me.lucko.luckperms.api.Node;
import me.lucko.luckperms.api.User;
import me.lucko.luckperms.api.caching.MetaContexts;
import me.lucko.luckperms.api.caching.MetaData;
import me.lucko.luckperms.api.caching.PermissionData;
import me.lucko.luckperms.api.caching.UserData;
import me.lucko.luckperms.api.context.ContextManager;
import me.lucko.luckperms.api.context.ImmutableContextSet;
import me.lucko.luckperms.api.context.MutableContextSet;
import me.lucko.luckperms.api.metastacking.MetaStackDefinition;
import me.lucko.luckperms.api.metastacking.MetaStackFactory;

public class LuckPermsImporter implements PermissionsImporter {
	
	public void getRank(OfflinePlayer player, ImporterCallback<String> callback) {
		load(player.getUniqueId(), new ImporterCallback<Boolean>() {
			protected final void onCall(final Boolean loaded) {
				if (!loaded) {
					callback.call(null);
					return;
				}
				final User user = getApi().getUser(player.getUniqueId());
				callback.call(user.getPrimaryGroup());
			}
		});
	}
	
	public void getRanks(OfflinePlayer player, ImporterCallback<List<String>> callback) {
		load(player.getUniqueId(), new ImporterCallback<Boolean>() {
			protected final void onCall(final Boolean loaded) {
				if (!loaded) {
					callback.call(null);
					return;
				}
				final User user = getApi().getUser(player.getUniqueId());
				callback.call(user.getOwnNodes().stream().filter(Node::isGroupNode).map(Node::getGroupName)
						.collect(Collectors.toList()));
			}
		});
	}
	
	public void getPrefix(OfflinePlayer player, ImporterCallback<String> callback) {
		getPrefix(player, null, callback);
	}
	
	public void getPrefix(OfflinePlayer player, String worldname, ImporterCallback<String> callback) {
		getPrefix(player, worldname, null, callback);
	}
	
	public void getPrefix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback) {
		load(player.getUniqueId(), new ImporterCallback<Boolean>() {
			protected final void onCall(final Boolean loaded) {
				if (!loaded) {
					callback.call(null);
					return;
				}
				final MetaData meta = getMetaData(getApi().getUser(player.getUniqueId()), worldname, ladder);
				callback.call(meta.getPrefix());
			}
		});
	}
	
	public void getSuffix(OfflinePlayer player, ImporterCallback<String> callback) {
		getSuffix(player, null, callback);
	}
	
	public void getSuffix(OfflinePlayer player, String worldname, ImporterCallback<String> callback) {
		getSuffix(player, worldname, null, callback);
	}
	
	public void getSuffix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback) {
		load(player.getUniqueId(), new ImporterCallback<Boolean>() {
			protected final void onCall(final Boolean loaded) {
				if (!loaded) {
					callback.call(null);
					return;
				}
				final MetaData meta = getMetaData(getApi().getUser(player.getUniqueId()), worldname, ladder);
				callback.call(meta.getSuffix());
			}
		});
	}
	
	public void hasPermission(OfflinePlayer player, String permission, ImporterCallback<Boolean> callback) {
		hasPermission(player, permission, null, callback);
	}
	
	public void hasPermission(OfflinePlayer player, String permission, String worldname,
			ImporterCallback<Boolean> callback) {
		load(player.getUniqueId(), new ImporterCallback<Boolean>() {
			protected final void onCall(final Boolean loaded) {
				if (!loaded) {
					callback.call(false);
					return;
				}
				final PermissionData data = getPermissionData(getApi().getUser(player.getUniqueId()), worldname);
				callback.call(data.getPermissionValue(permission).asBoolean());
			}
		});
	}
	
	public void load(final UUID uuid, ImporterCallback<Boolean> callback) throws IllegalStateException {
		new BukkitRunnable() {
			public final void run() {
				final LuckPermsApi api = getApi();
				if (api.getUser(uuid) == null) api.getStorage().loadUser(uuid).join();
				callback.call(isLoaded(uuid));
			}
		}.runTaskAsynchronously(ImporterPlugin.getPlugin());
	}
	
	public boolean unload(final UUID uuid) {
		final User user = getApi().getUser(uuid);
		if (user == null) return false;
		getApi().cleanupUser(user);
		return true;
	}
	
	public boolean isLoaded(final UUID uuid) {
		return getApi().getUser(uuid) != null;
	}
	
	protected final LuckPermsApi getApi() throws IllegalStateException {
		return LuckPerms.getApi();
	}
	
	protected MetaData getMetaData(final User user, final String world, final String ladder) {
		final UserData cachedData = user.getCachedData();
		final Contexts contexts = getContexts(user, world);
		if (ladder == null) return cachedData.getMetaData(contexts);
		final MetaStackFactory stackFactory = getApi().getMetaStackFactory();
		final MetaStackDefinition definition = stackFactory.createDefinition(stackFactory.fromStrings(Collections
				.singletonList("highest_on_track_" + ladder)), "", "", "");
		return cachedData.getMetaData(MetaContexts.of(contexts, definition, definition));
	}
	
	protected PermissionData getPermissionData(final User user, final String world) {
		final UserData cachedData = user.getCachedData();
		return cachedData.getPermissionData(getContexts(user, world));
	}
	
	protected Contexts getContexts(final User user, final String world) {
		final ContextManager manager = getApi().getContextManager();
		final ImmutableContextSet set = manager.lookupApplicableContext(user).orElse(manager.getStaticContext());
		if (world == null) return manager.formContexts(set);
		final MutableContextSet mutableSet = set.mutableCopy();
		mutableSet.removeAll(Contexts.WORLD_KEY);
		mutableSet.add(Contexts.WORLD_KEY, world);
		return manager.formContexts(mutableSet.makeImmutable());
	}
	
}
