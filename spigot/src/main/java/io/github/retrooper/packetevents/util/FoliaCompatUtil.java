package io.github.retrooper.packetevents.util;

import io.github.retrooper.packetevents.util.folia.FoliaScheduler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.function.Consumer;

/**
 * @deprecated This class has been moved to {@link FoliaScheduler}.
 */
@Deprecated
public class FoliaCompatUtil {
    private static final boolean folia = false;
    private static final BukkitScheduler bukkitScheduler = Bukkit.getScheduler();

    /**
     * @return Whether the server is running Folia
     * @deprecated This method has been moved to {@link FoliaScheduler#isFolia()}.
     */
    public static boolean isFolia() {
        return folia;
    }

    /**
     * Run a task async, either with Bukkit scheduler or using Java
     *
     * @param plugin Your plugin or PacketEvents
     * @param run    Runnable to run
     * @deprecated This method is deprecated, and it's recommended to use
     * {@link FoliaScheduler#getAsyncScheduler()} instead.
     */
    public static void runTaskAsync(Plugin plugin, Runnable run) {
        bukkitScheduler.runTaskAsynchronously(plugin, run);
    }

    /**
     * Run a task every global tick
     *
     * @param plugin Your plugin or PacketEvents
     * @param run    Consumer that accepts an object or null, for Folia or Paper/Spigot respectively
     * @param delay  Delay in ticks
     * @param period Period in ticks
     * @deprecated This method is deprecated, and it's recommended to use
     * {@link FoliaScheduler#getAsyncScheduler()} instead.
     */
    public static void runTaskTimerAsync(Plugin plugin, Consumer<Object> run, long delay, long period) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> run.accept(null), delay, period);
    }

    /**
     * Run a task on the next global tick
     *
     * @param plugin Your plugin or PacketEvents
     * @param run    Consumer that accepts an object or null, for Folia or Paper/Spigot respectively
     * @deprecated This method is deprecated, and it's recommended to use
     * {@link FoliaScheduler#getGlobalRegionScheduler()} or another suitable scheduler instead.
     */
    public static void runTask(Plugin plugin, Consumer<Object> run) {
        Bukkit.getScheduler().runTask(plugin, () -> run.accept(null));
    }


    /**
     * Run a task after the server has finished initializing.
     * Undefined behavior if called after the server has finished initializing.
     *
     * @param plugin Your plugin or PacketEvents
     * @param run    The task to run
     * @deprecated This method has been moved to {@link FoliaScheduler#runTaskOnInit(Plugin, Runnable)}.
     */
    public static void runTaskOnInit(Plugin plugin, Runnable run) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, run);
    }

    /**
     * Run a task for an entity on whatever thread the entity is on
     *
     * @param entity  The entity to run the task for
     * @param plugin  Your plugin or PacketEvents
     * @param run     The task to run
     * @param retired The task to run if entity is retired before the task is run
     * @param delay   Delay in ticks
     * @deprecated This method is deprecated, and it's recommended to use {@link FoliaScheduler#getEntityScheduler()}.
     */
    public static void runTaskForEntity(Entity entity, Plugin plugin, Runnable run, Runnable retired, long delay) {
        Bukkit.getScheduler().runTaskLater(plugin, run, delay);
    }
}
