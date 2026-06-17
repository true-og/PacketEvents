/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2022 retrooper and contributors
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

package com.github.retrooper.packetevents.util.updatechecker;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.PEVersion;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * PacketEvents update checker.
 *
 * @author retrooper
 * @since 1.6.9
 */
@ApiStatus.Internal
public class UpdateChecker {
    // Update checking is disabled in this build. No network calls are ever made.
    @ApiStatus.Internal
    public String checkLatestReleasedVersion() {
        return PacketEvents.getAPI().getVersion().toString();
    }

    /**
     * Update checking is disabled in this build. Always reports up-to-date
     * without performing any network request.
     */
    @ApiStatus.Internal
    public UpdateCheckerStatus checkForUpdate(@Nullable Consumer<PEVersion> latestVersionHolder) {
        if (latestVersionHolder != null) {
            latestVersionHolder.accept(PacketEvents.getAPI().getVersion());
        }
        return UpdateCheckerStatus.UP_TO_DATE;
    }

    @ApiStatus.Internal
    public UpdateCheckerStatus checkForUpdate() {
        return checkForUpdate(null);
    }

    @Deprecated @ApiStatus.Internal
    public void handleUpdateCheck(@Nullable Runnable updateCheckCallback) {
        // No-op: update checking disabled. Still invoke the callback so callers proceed.
        if (updateCheckCallback != null) {
            updateCheckCallback.run();
        }
    }

    @ApiStatus.Internal
    public void handleUpdateCheck(@Nullable BiConsumer<PEVersion, UpdateCheckerStatus> updateResultHolder) {
        // No-op: update checking disabled. Still invoke the callback so callers proceed.
        if (updateResultHolder != null) {
            updateResultHolder.accept(PacketEvents.getAPI().getVersion(), UpdateCheckerStatus.UP_TO_DATE);
        }
    }

    @ApiStatus.Internal
    public void handleUpdateCheck() {
       handleUpdateCheck((Runnable) null);
    }

    /**
     * Result of an update check.
     *
     * @author retrooper
     * @since 1.8
     */
    public enum UpdateCheckerStatus {
        /**
         * Your build is outdated, an update is available.
         */
        OUTDATED,
        /**
         * You are on a development build. Not on the latest stable release(not necessarily bad).
         */
        PRE_RELEASE,
        /**
         * Your build is up-to-date. Latest stable release.
         */
        UP_TO_DATE,
        /**
         * Failed to check for an update. There might be an issue with your connection.
         */
        FAILED
    }
}
