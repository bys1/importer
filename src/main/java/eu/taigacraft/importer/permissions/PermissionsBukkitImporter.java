package eu.taigacraft.importer.permissions;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import eu.taigacraft.importer.FakePlayer;
import eu.taigacraft.importer.ImporterCallback;

public class PermissionsBukkitImporter implements PermissionsImporter {
	
	private FileConfiguration pb = YamlConfiguration.loadConfiguration(new File("plugins/PermissionsBukkit/config.yml"));
	
	public void getRank(OfflinePlayer player, ImporterCallback<String> callback) {
		callback.call(getRanks(player).get(0));
	}
	
	public void getRanks(OfflinePlayer player, ImporterCallback<List<String>> callback) {
		callback.call(getRanks(player));
	}
	
	private final List<String> getRanks(OfflinePlayer player) {
		return pb.getStringList("users." + player.getUniqueId().toString() + ".groups");
	}
	
	@Deprecated
	public void getPrefix(OfflinePlayer player, ImporterCallback<String> callback) {
		callback.call(null);
	}
	
	@Deprecated
	public void getPrefix(OfflinePlayer player, String worldname, ImporterCallback<String> callback) {
		callback.call(null);
	}
	
	@Deprecated
	public void getPrefix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback) {
		callback.call(null);
	}
	
	@Deprecated
	public void getSuffix(OfflinePlayer player, ImporterCallback<String> callback) {
		callback.call(null);
	}
	
	@Deprecated
	public void getSuffix(OfflinePlayer player, String worldname, ImporterCallback<String> callback) {
		callback.call(null);
	}
	
	@Deprecated
	public void getSuffix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback) {
		callback.call(null);
	}
	
	public void hasPermission(OfflinePlayer player, String permission, ImporterCallback<Boolean> callback) {
		hasPermission(player, permission, null, callback);
	}
	
	public void hasPermission(OfflinePlayer player, String permission, String worldname, ImporterCallback<Boolean> callback) {
		try {
			final Method cpp = com.platymuus.bukkit.permissions.PermissionsPlugin.class.getDeclaredMethod("calculatePlayerPermissions",
					Player.class, String.class);
			@SuppressWarnings("unchecked")
			final Map<String,Boolean> permissions = (Map<String,Boolean>) cpp.invoke(new FakePlayer(player), worldname);
			if (permissions.containsKey(permission)) callback.call(permissions.get(permission));
			else callback.call(false);
		} catch (Exception e) {
			e.printStackTrace();
			callback.call(false);
		}
	}
	
}
