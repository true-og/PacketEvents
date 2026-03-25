/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2024 retrooper and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.retrooper.packetevents.util.folia;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a wrapper around Bukkit tasks.
 */
public class TaskWrapper {

    private final BukkitTask bukkitTask;

    /**
     * Constructs a new TaskWrapper around a BukkitTask.
     *
     * @param bukkitTask the BukkitTask to wrap
     */
    public TaskWrapper(@NotNull BukkitTask bukkitTask) {
        this.bukkitTask = bukkitTask;
    }

    public Plugin getOwner() {
        return bukkitTask.getOwner();
    }

    /**
     * Checks if the task is canceled.
     *
     * @return true if the task is canceled, false otherwise
     */
    public boolean isCancelled() {
        return bukkitTask.isCancelled();
    }

    /**
     * Cancels the task. If the task is running, it will be canceled.
     */
    public void cancel() {
        bukkitTask.cancel();
    }
}
