package eu.taigacraft.importer.permissions;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PermissionsExImporter implements PermissionsImporter {
	
	private FileConfiguration pex = YamlConfiguration.loadConfiguration(new File("plugins/PermissionsEx/permissions.yml"));
	
	public String getRank(OfflinePlayer player) {
		return pex.getStringList("users." + player.getUniqueId().toString() + ".group").get(0);
	}
	
	public String getPrefix(OfflinePlayer player) {
		return pex.getString("groups." + this.getRank(player) + ".options.prefix");
	}

	@Deprecated
	public String getPrefix(OfflinePlayer player, String worldname) {
		return getPrefix(player);
	}
	
	@Deprecated
	public String getPrefix(OfflinePlayer player, String worldname, String ladder) {
		return getPrefix(player,worldname);
	}
	
	public String getSuffix(OfflinePlayer player) {
		return pex.getString("groups." + this.getRank(player) + ".options.suffix");
	}

	@Deprecated
	public String getSuffix(OfflinePlayer player, String worldname) {
		return getSuffix(player);
	}
	
	@Deprecated
	public String getSuffix(OfflinePlayer player, String worldname, String ladder) {
		return getSuffix(player,worldname);
	}
	
	public boolean hasPermission(OfflinePlayer player, String permission) {
		return pex.getStringList("groups." + this.getRank(player) + ".permissions").contains(permission);
	}
	
	public boolean hasPermission(OfflinePlayer player, String permission, String worldname) {
		return pex.getStringList("groups." + this.getRank(player) + ".worlds." + worldname + ".permissions").contains(permission);
	}

}
