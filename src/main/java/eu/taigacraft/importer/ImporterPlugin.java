package eu.taigacraft.importer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import eu.taigacraft.importer.permissions.*;
import eu.taigacraft.importer.economy.*;

public final class ImporterPlugin extends JavaPlugin {
	
	public final Logger logger = getLogger();
	public final PluginDescriptionFile pdf = getDescription();
	private final PluginManager pm = getServer().getPluginManager();
	
	public static final Map<Plugin,PermissionsImporter> permissionsImporters = new HashMap<Plugin,PermissionsImporter>();
	public static final Map<Plugin,EconomyImporter> economyImporters = new HashMap<Plugin,EconomyImporter>();
	
	public final void onEnable() {
		registerImporters();
		logger.info(pdf.getName() + " v" + pdf.getVersion() + " has been enabled.");
	}
	
	public final void onDisable() {
		logger.info(pdf.getName() + " v" + pdf.getVersion() + " has been disabled.");
	}
	
	private final void registerImporters() {
		PermissionsImporter.register(pm.getPlugin("PermissionsEx"), new PermissionsExImporter());
		
		// Null checks to prevent ClassNotFoundExceptions
		if (pl("PermissionsBukkit")) PermissionsImporter.register(pm.getPlugin("PermissionsBukkit"), new PermissionsBukkitImporter());
		if (pl("LuckPerms")) PermissionsImporter.register(pm.getPlugin("LuckPerms"), new LuckPermsImporter());
	}
	
	private final boolean pl(final String name) {
		return pm.getPlugin(name) != null;
	}
	
	public static final ImporterPlugin getPlugin() {
		return ImporterPlugin.getPlugin(ImporterPlugin.class);
	}
	
}
