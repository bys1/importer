package eu.taigacraft.importer;

import org.bukkit.scheduler.BukkitRunnable;

public abstract class ImporterCallback<T> {
	
	private final boolean async;
	
	public ImporterCallback() {
		this(false);
	}
	
	public ImporterCallback(final boolean async) {
		this.async = async;
	}
	
	public final void call(final T result) {
		final BukkitRunnable runnable = new BukkitRunnable() {
			public void run() {
				onCall(result);
			}
		};
		final ImporterPlugin plugin = ImporterPlugin.getPlugin();
		if (async) runnable.runTaskAsynchronously(plugin);
		else runnable.runTask(plugin);
	}
	
	protected abstract void onCall(final T result);
	
}
