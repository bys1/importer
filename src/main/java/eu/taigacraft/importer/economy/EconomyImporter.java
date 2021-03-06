package eu.taigacraft.importer.economy;

import java.util.function.Consumer;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import eu.taigacraft.importer.ImporterCallback;
import eu.taigacraft.importer.ImporterPlugin;

import static eu.taigacraft.importer.ImporterCallback.fromConsumer;

public interface EconomyImporter {

	public static void register(Plugin plugin, EconomyImporter importer) {
		if (plugin == null) return;
		if (importer == null) throw new IllegalArgumentException("Importer cannot be null");
		if (!(ImporterPlugin.economyImporters.containsKey(plugin))) {
			ImporterPlugin.economyImporters.put(plugin,importer);
			ImporterPlugin.getPlugin().logger.info("Registered EconomyImporter from " + plugin.getName());
		}
	}
	
	public static EconomyImporter get() {
		for (Plugin plugin : ImporterPlugin.economyImporters.keySet()) {
			if (plugin.isEnabled()) {
				ImporterPlugin.getPlugin().logger.info("Hooking into " + plugin.getName());
				return ImporterPlugin.economyImporters.get(plugin);
			}
		}
		return null;
	}
	
	public void getBalance(OfflinePlayer player, ImporterCallback<Double> callback);
	
	public default void getBalance(OfflinePlayer player, Consumer<Double> consumer) {
		getBalance(player, fromConsumer(consumer, false));
	}
	
}
