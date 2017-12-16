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
package de.veraty.elytrawars.game.arena;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

/**
 *
 * @author merlin
 */
@Getter
@Setter
@Data
public class Arena {

    private final String name, author;
    private final List<Location> spawns;
    private final int deathHeight;

    /**
     * Constructs an Arena.
     *
     * @param name name
     * @param author author
     * @param spawns spawns
     * @param deathHeight death height
     */
    public Arena(String name, String author, List<Location> spawns, int deathHeight) {
        this.author = author;
        this.name = name;
        this.spawns = spawns;
        this.deathHeight = deathHeight;
    }

    /**
     * Gets whether the location is outside of the arena.
     *
     * @param location location
     * @return outside?
     */
    public boolean outside(Location location) {
        return outside(location.getBlockY());
    }

    /**
     * Gets whether the y coord is outside of the arena.
     *
     * @param y y coord
     * @return outside?
     */
    public boolean outside(int y) {
        return y <= deathHeight;
    }

}
