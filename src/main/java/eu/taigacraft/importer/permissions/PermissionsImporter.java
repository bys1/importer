package eu.taigacraft.importer.permissions;

import java.io.File;

import org.bukkit.OfflinePlayer;

import eu.taigacraft.importer.ImporterPlugin;

public interface PermissionsImporter {
	
	public static PermissionsImporter register() {
		
		if (new File("plugins/PermissionsEx/permissions.yml").exists()) {
			ImporterPlugin.getPlugin().logger.info("Hooking into PermissionsEx");
			return new PermissionsExImporter();
		}
		
		if (new File("plugins/PowerPerms/config.yml").exists()) {
			ImporterPlugin.getPlugin().logger.info("Hooking into PowerPerms");
			return new PowerPermsImporter();
		}
		
		return null;
	}
	
	public String getRank(OfflinePlayer player);
	
	public String getPrefix(OfflinePlayer player);
	
	public String getPrefix(OfflinePlayer player, String worldname);
	
	public String getSuffix(OfflinePlayer player);
	
	public String getSuffix(OfflinePlayer player, String worldname);
	
	public boolean hasPermission(OfflinePlayer player, String permission);
	
	public boolean hasPermission(OfflinePlayer player, String permission, String worldname);
	
}
