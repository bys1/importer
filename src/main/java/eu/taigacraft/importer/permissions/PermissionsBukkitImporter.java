package eu.taigacraft.importer.permissions;

import java.io.File;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PermissionsBukkitImporter implements PermissionsImporter {
	
	private FileConfiguration pb = YamlConfiguration.loadConfiguration(new File("plugins/PermissionsBukkit/config.yml"));
	
	public String getRank(OfflinePlayer player) {
		return getRanks(player).get(0);
	}
	
	public List<String> getRanks(OfflinePlayer player) {
		return pb.getStringList("users." + player.getUniqueId().toString() + ".groups");
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
	
	@Deprecated
	public void load(OfflinePlayer player) {}
	
	@Deprecated
	public void unload(OfflinePlayer player) {}
	
	@Deprecated
	public boolean isLoaded(OfflinePlayer player) {
		return false;
	}

}
