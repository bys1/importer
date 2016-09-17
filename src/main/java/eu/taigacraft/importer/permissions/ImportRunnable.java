package eu.taigacraft.importer.permissions;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class ImportRunnable implements Runnable {
	
	public abstract void run();
	
	public void load(Plugin plugin, OfflinePlayer player) {
		final ImportRunnable runnable = this;
		final PermissionsImporter importer = PermissionsImporter.get();
		new BukkitRunnable() {
			public void run() {
				importer.load(player);
				new BukkitRunnable() {
					public void run() {
						runnable.run();
					}
				}.runTask(plugin);
			}
		}.runTaskAsynchronously(plugin);
	}
	
}
