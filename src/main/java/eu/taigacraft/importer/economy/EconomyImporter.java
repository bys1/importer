package eu.taigacraft.importer.economy;

import org.bukkit.OfflinePlayer;

import eu.taigacraft.importer.ImporterPlugin;

public interface EconomyImporter {

	public static void register(String pluginName, EconomyImporter importer) {
		if (!(ImporterPlugin.economyImporters.containsKey(pluginName))) {
			ImporterPlugin.economyImporters.put(pluginName,importer);
			ImporterPlugin.getPlugin().logger.info("Registered EconomyImporter from " + pluginName);
		}
	}
	
	public static EconomyImporter get() {
		
		for (String pluginName : ImporterPlugin.economyImporters.keySet()
				.toArray(new String[ImporterPlugin.economyImporters.keySet().size()])) {
			if (ImporterPlugin.getPlugin().getServer().getPluginManager().getPlugin(pluginName) != null) {
				ImporterPlugin.getPlugin().logger.info("Hooking into " + pluginName);
				return ImporterPlugin.economyImporters.get(pluginName);
			}
		}
		
		return null;
	}
	
	public double getBalance(OfflinePlayer player);
	
}
