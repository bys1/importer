package eu.taigacraft.importer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import eu.taigacraft.importer.permissions.*;
import eu.taigacraft.importer.economy.*;

public final class ImporterPlugin extends JavaPlugin {
	
	public final Logger logger = getLogger();
	public final PluginDescriptionFile pdf = getDescription();
	
	public static final Map<String,PermissionsImporter> permissionsImporters = new HashMap<String,PermissionsImporter>();
	public static final Map<String,EconomyImporter> economyImporters = new HashMap<String,EconomyImporter>();
	
	public final void onEnable() {
		registerImporters();
		logger.info(pdf.getName() + " v" + pdf.getVersion() + " has been enabled.");
	}
	
	public final void onDisable() {
		logger.info(pdf.getName() + " v" + pdf.getVersion() + " has been disabled.");
	}
	
	private final void registerImporters() {
		PermissionsImporter.register("PermissionsEx", new PermissionsExImporter());
		PermissionsImporter.register("PermissionsBukkit", new PermissionsBukkitImporter());
	}
	
	public static final ImporterPlugin getPlugin() {
		return ImporterPlugin.getPlugin(ImporterPlugin.class);
	}
	
}
