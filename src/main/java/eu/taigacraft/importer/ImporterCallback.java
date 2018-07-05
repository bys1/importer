package eu.taigacraft.importer;

import java.util.function.Consumer;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

public abstract class ImporterCallback<T> {
	
	private static final ImporterPlugin plugin = ImporterPlugin.getPlugin(ImporterPlugin.class);
	private static final BukkitScheduler scheduler = plugin.getServer().getScheduler();
	
	protected final boolean async;
	
	public ImporterCallback() {
		this(false);
	}
	
	public ImporterCallback(final boolean async) {
		this.async = async;
	}
	
	public final void call(final T result) {
		if (async) scheduler.runTaskAsynchronously(plugin, () -> onCall(result));
		else {
			if (Bukkit.isPrimaryThread()) onCall(result);
			else scheduler.runTask(plugin, () -> onCall(result));
		}
	}
	
	protected abstract void onCall(final T result);
	
	public static final <T> ImporterCallback<T> fromConsumer(final Consumer<T> consumer, final boolean async) {
		return new ImporterCallback<T>(async) {
			public final void onCall(final T result) {
				consumer.accept(result);
			}
		};
	}
	
}
