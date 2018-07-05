package eu.taigacraft.importer.permissions;

import java.util.List;
import java.util.function.Consumer;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import eu.taigacraft.importer.ImporterCallback;
import eu.taigacraft.importer.ImporterPlugin;

import static eu.taigacraft.importer.ImporterCallback.fromConsumer;

public interface PermissionsImporter {
	
	public static void register(final Plugin plugin, final PermissionsImporter importer) {
		if (plugin == null) return;
		if (importer == null) throw new IllegalArgumentException("Importer cannot be null");
		if (!(ImporterPlugin.permissionsImporters.containsKey(plugin.getName()))) {
			ImporterPlugin.permissionsImporters.put(plugin,importer);
			ImporterPlugin.getPlugin().logger.info("Registered PermissionsImporter from " + plugin.getName());
		}
	}
	
	public static PermissionsImporter get() {
		for (Plugin plugin : ImporterPlugin.permissionsImporters.keySet()) {
			if (plugin.isEnabled()) {
				ImporterPlugin.getPlugin().logger.info("Hooking into " + plugin.getName());
				return ImporterPlugin.permissionsImporters.get(plugin);
			}
		}
		return null;
	}
	
	public void getRank(OfflinePlayer player, ImporterCallback<String> callback);
	
	public default void getRank(OfflinePlayer player, Consumer<String> consumer) {
		getRank(player, fromConsumer(consumer, false));
	}
	
	public void getRanks(OfflinePlayer player, ImporterCallback<List<String>> callback);
	
	public default void getRanks(OfflinePlayer player, Consumer<List<String>> consumer) {
		getRanks(player, fromConsumer(consumer, false));
	}
	
	public void getPrefix(OfflinePlayer player, ImporterCallback<String> callback);
	
	public default void getPrefix(OfflinePlayer player, Consumer<String> consumer) {
		getPrefix(player, fromConsumer(consumer, false));
	}
	
	public void getPrefix(OfflinePlayer player, String worldname, ImporterCallback<String> callback);
	
	public default void getPrefix(OfflinePlayer player, String worldname, Consumer<String> consumer) {
		getPrefix(player, worldname, fromConsumer(consumer, false));
	}
	
	public void getPrefix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback);
	
	public default void getPrefix(OfflinePlayer player, String worldname, String ladder, Consumer<String> consumer) {
		getPrefix(player, worldname, ladder, fromConsumer(consumer, false));
	}
	
	public void getSuffix(OfflinePlayer player, ImporterCallback<String> callback);
	
	public default void getSuffix(OfflinePlayer player, Consumer<String> consumer) {
		getSuffix(player, fromConsumer(consumer, false));
	}
	
	public void getSuffix(OfflinePlayer player, String worldname, ImporterCallback<String> callback);
	
	public default void getSuffix(OfflinePlayer player, String worldname, Consumer<String> consumer) {
		getSuffix(player, worldname, fromConsumer(consumer, false));
	}
	
	public void getSuffix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback);
	
	public default void getSuffix(OfflinePlayer player, String worldname, String ladder, Consumer<String> consumer) {
		getSuffix(player, worldname, ladder, fromConsumer(consumer, false));
	}
	
	public void hasPermission(OfflinePlayer player, String permission, ImporterCallback<Boolean> callback);
	
	public default void hasPermission(OfflinePlayer player, String permission, Consumer<Boolean> consumer) {
		hasPermission(player, permission, fromConsumer(consumer, false));
	}
	
	public void hasPermission(OfflinePlayer player, String permission, String worldname, ImporterCallback<Boolean> callback);
	
	public default void hasPermission(OfflinePlayer player, String permission, String worldname, Consumer<Boolean> consumer) {
		hasPermission(player, permission, worldname, fromConsumer(consumer, false));
	}
	
}
