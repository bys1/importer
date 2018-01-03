package eu.taigacraft.importer.permissions;

import java.io.File;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import eu.taigacraft.importer.ImporterCallback;

public class PermissionsExImporter implements PermissionsImporter {
	
	private FileConfiguration pex = YamlConfiguration.loadConfiguration(new File("plugins/PermissionsEx/permissions.yml"));
	
	public void getRank(OfflinePlayer player, ImporterCallback<String> callback) {
		callback.call(getRanks(player).get(0));
	}
	
	public void getRanks(OfflinePlayer player, ImporterCallback<List<String>> callback) {
		callback.call(getRanks(player));
	}
	
	private final List<String> getRanks(OfflinePlayer player) {
		return pex.getStringList("users." + player.getUniqueId().toString() + ".group");
	}
	
	public void getPrefix(OfflinePlayer player, ImporterCallback<String> callback) {
		callback.call(pex.getString("groups." + this.getRanks(player).get(0) + ".options.prefix"));
	}

	@Deprecated
	public void getPrefix(OfflinePlayer player, String worldname, ImporterCallback<String> callback) {
		getPrefix(player, callback);
	}
	
	@Deprecated
	public void getPrefix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback) {
		getPrefix(player, callback);
	}
	
	public void getSuffix(OfflinePlayer player, ImporterCallback<String> callback) {
		callback.call(pex.getString("groups." + this.getRanks(player).get(0) + ".options.suffix"));
	}

	@Deprecated
	public void getSuffix(OfflinePlayer player, String worldname, ImporterCallback<String> callback) {
		getSuffix(player, callback);
	}
	
	@Deprecated
	public void getSuffix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback) {
		getSuffix(player, callback);
	}
	
	public void hasPermission(OfflinePlayer player, String permission, ImporterCallback<Boolean> callback) {
		callback.call(pex.getStringList("groups." + this.getRanks(player).get(0) + ".permissions").contains(permission));
	}
	
	public void hasPermission(OfflinePlayer player, String permission, String worldname, ImporterCallback<Boolean> callback) {
		callback.call(pex.getStringList("groups." + this.getRanks(player).get(0) + ".worlds." + worldname + ".permissions")
				.contains(permission));
	}
	
}
