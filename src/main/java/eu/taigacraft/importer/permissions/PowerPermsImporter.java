package eu.taigacraft.importer.permissions;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PowerPermsImporter implements PermissionsImporter {
	
	private FileConfiguration pp = YamlConfiguration.loadConfiguration(new File("plugins/PowerPerms/config.yml"));
	
	public String getRank(OfflinePlayer player) {
		return pp.getString("players." + player.getUniqueId().toString() + ".rank");
	}
	
	public String getPrefix(OfflinePlayer player) {
		return pp.getString("ranks." + getRank(player) + ".global.prefix");
	}
	
	public String getPrefix(OfflinePlayer player, String worldname) {
		return pp.getString("ranks." + getRank(player) + ".worlds." + worldname + ".prefix");
	}
	
	public String getSuffix(OfflinePlayer player) {
		return pp.getString("ranks." + getRank(player) + ".global.suffix");
	}
	
	public String getSuffix(OfflinePlayer player, String worldname) {
		return pp.getString("ranks." + getRank(player) + ".worlds." + worldname + ".suffix");
	}
	
	public boolean hasPermission(OfflinePlayer player, String permission) {
		return pp.getStringList("ranks." + getRank(player) + ".global.permissions").contains(permission);
	}
	
	public boolean hasPermission(OfflinePlayer player, String permission, String worldname) {
		return pp.getStringList("ranks." + getRank(player) + ".worlds." + worldname + ".permissions").contains(permission);
	}

}
