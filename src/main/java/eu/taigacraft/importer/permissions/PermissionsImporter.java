package eu.taigacraft.importer.permissions;

import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import eu.taigacraft.importer.ImporterCallback;
import eu.taigacraft.importer.ImporterPlugin;

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
	
	public void getRanks(OfflinePlayer player, ImporterCallback<List<String>> callback);
	
	public void getPrefix(OfflinePlayer player, ImporterCallback<String> callback);
	
	public void getPrefix(OfflinePlayer player, String worldname, ImporterCallback<String> callback);
	
	public void getPrefix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback);
	
	public void getSuffix(OfflinePlayer player, ImporterCallback<String> callback);
	
	public void getSuffix(OfflinePlayer player, String worldname, ImporterCallback<String> callback);
	
	public void getSuffix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback);
	
	public void hasPermission(OfflinePlayer player, String permission, ImporterCallback<Boolean> callback);
	
	public void hasPermission(OfflinePlayer player, String permission, String worldname, ImporterCallback<Boolean> callback);
	
}
