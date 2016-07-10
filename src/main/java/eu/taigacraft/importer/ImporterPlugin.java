package eu.taigacraft.importer;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class ImporterPlugin extends JavaPlugin {
	
	public final Logger logger = getLogger();
	public final PluginDescriptionFile pdf = getDescription();
	
	public final void onEnable() {
		logger.info(pdf.getName() + " v" + pdf.getVersion() + " has been enabled.");
	}
	
	public final void onDisable() {
		logger.info(pdf.getName() + " v" + pdf.getVersion() + " has been disabled.");
	}
	
	public static final ImporterPlugin getPlugin() {
		return ImporterPlugin.getPlugin(ImporterPlugin.class);
	}
	
}
