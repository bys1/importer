package eu.taigacraft.importer.permissions;

import java.util.List;

import org.bukkit.OfflinePlayer;

import eu.taigacraft.importer.ImporterPlugin;

public interface PermissionsImporter {
	
	public static void register(String pluginName, PermissionsImporter importer) {
		if (!(ImporterPlugin.permissionsImporters.containsKey(pluginName))) {
			ImporterPlugin.permissionsImporters.put(pluginName,importer);
			ImporterPlugin.getPlugin().logger.info("Registered PermissionsImporter from " + pluginName);
		}
	}
	
	public static PermissionsImporter get() {
		
		for (String pluginName : ImporterPlugin.permissionsImporters.keySet()
				.toArray(new String[ImporterPlugin.permissionsImporters.keySet().size()])) {
			if (ImporterPlugin.getPlugin().getServer().getPluginManager().getPlugin(pluginName) != null) {
				ImporterPlugin.getPlugin().logger.info("Hooking into " + pluginName);
				return ImporterPlugin.permissionsImporters.get(pluginName);
			}
		}
		
		return null;
	}
	
	public String getRank(OfflinePlayer player);
	
	public List<String> getRanks(OfflinePlayer player);
	
	public String getPrefix(OfflinePlayer player);
	
	public String getPrefix(OfflinePlayer player, String worldname);
	
	public String getPrefix(OfflinePlayer player, String worldname, String ladder);
	
	public String getSuffix(OfflinePlayer player);
	
	public String getSuffix(OfflinePlayer player, String worldname);
	
	public String getSuffix(OfflinePlayer player, String worldname, String ladder);
	
	public Boolean hasPermission(OfflinePlayer player, String permission);
	
	public Boolean hasPermission(OfflinePlayer player, String permission, String worldname);
	
	public void load(OfflinePlayer player);
	
	public void unload(OfflinePlayer player);
	
	public boolean isLoaded(OfflinePlayer player);
	
}
