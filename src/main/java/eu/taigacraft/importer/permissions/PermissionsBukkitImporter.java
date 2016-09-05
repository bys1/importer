package eu.taigacraft.importer.permissions;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PermissionsBukkitImporter implements PermissionsImporter {
	
	private FileConfiguration pb = YamlConfiguration.loadConfiguration(new File("plugins/PermissionsBukkit/config.yml"));
	
	public String getRank(OfflinePlayer player) {
		return pb.getStringList("users." + player.getUniqueId().toString() + ".groups").get(0);
	}
	
	@Deprecated
	public String getPrefix(OfflinePlayer player) {
		return null;
	}
	
	@Deprecated
	public String getPrefix(OfflinePlayer player, String worldname) {
		return null;
	}
	
	@Deprecated
	public String getPrefix(OfflinePlayer player, String worldname, String ladder) {
		return null;
	}
	
	@Deprecated
	public String getSuffix(OfflinePlayer player) {
		return null;
	}
	
	@Deprecated
	public String getSuffix(OfflinePlayer player, String worldname) {
		return null;
	}
	
	@Deprecated
	public String getSuffix(OfflinePlayer player, String worldname, String ladder) {
		return null;
	}
	
	public Boolean hasPermission(OfflinePlayer player, String permission) {
		final String path = "groups." + getRank(player) + ".permissions." + permission;
		return pb.get(path) != null ? pb.getBoolean(path) : false;
	}
	
	public Boolean hasPermission(OfflinePlayer player, String permission, String worldname) {
		final String path = "groups." + getRank(player) + ".worlds." + worldname + ".permissions." + permission;
		return pb.get(path) != null ? pb.getBoolean(path) : false;
	}

}
