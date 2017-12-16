/*
 * Copyright (C) 2017 merlin
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
package de.veraty.elytrawars.util;

import de.veraty.elytrawars.ElytraWarsPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * A Countdown can count down.
 *
 * @author merlin
 */
public abstract class Countdown extends BukkitRunnable {

    public static final boolean DESC = false;
    public static final boolean ASC = true;

    private final int target;
    private final boolean direction;
    private int ticks;
    private boolean running;

    /**
     * Constructs a Countdown.
     *
     * @param direction direction
     * @param target target
     */
    public Countdown(final boolean direction, final int target) {
        this.direction = direction;
        this.target = target;
    }

    /**
     * Starts the countdown.
     */
    public void start() {
        this.runTaskTimerAsynchronously(ElytraWarsPlugin.getInstance(), 0, 20);
        this.running = false;
    }

    /**
     * Stops the countdown.
     */
    public void stop() {
        if (this.running) {
            this.cancel();
            this.running = false;
        }
    }

    @Override
    public void run() {
        if (direction) {
            if (ticks == 0) {
                begin();
            }

            if (ticks++ >= target) {
                if (finish()) {
                    cancel();
                    return;
                } else {
                    ticks = 0;
                }
            }

            tick(60 % ticks, (int) ticks / 60);
        } else {
            if (ticks == target) {
                begin();
            }

            if (ticks-- <= 0) {
                if (finish()) {
                    cancel();
                    return;
                } else {
                    ticks = target;
                }
            }

            tick(60 % target - 60 % ticks, (int) (target / 60) - (ticks / 60));
        }
    }

    protected abstract void tick(int seconds, int minutes);

    protected abstract void begin();

    protected abstract boolean finish();

}
