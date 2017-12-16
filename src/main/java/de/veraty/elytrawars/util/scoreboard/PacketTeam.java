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
package de.veraty.elytrawars.util.scoreboard;

import de.veraty.elytrawars.util.Sendable;
import lombok.Getter;

/**
 * Team of a PacketScoreboard.
 *
 * @author merlin
 */
@Getter
public class PacketTeam implements Sendable {

    private final PacketScoreboard scoreboard;
    private final String name;

    private String prefix;
    private String displayName;
    private String suffix;

    /**
     * Constructs a PacketTeam with a name only.
     *
     * @param scoreboard
     * @param name
     */
    public PacketTeam(PacketScoreboard scoreboard, String name) {
        this(scoreboard, name, name);
    }

    /**
     * Constructs a PacketTeam without suffix and prefix.
     *
     * @param scoreboard
     * @param name
     * @param displayName
     */
    public PacketTeam(PacketScoreboard scoreboard, String name, String displayName) {
        this(scoreboard, name, "", displayName, "");
    }

    /**
     * Constructs a PacketTeam.
     *
     * @param scoreboard scoreboard
     * @param name name
     * @param prefix prefix
     * @param displayName displayName
     * @param suffix suffix
     */
    public PacketTeam(PacketScoreboard scoreboard, String name, String prefix, String displayName, String suffix) {
        this.scoreboard = scoreboard;
        this.name = name;
        this.prefix = prefix;
        this.displayName = displayName;
        this.suffix = suffix;
    }

    @Override
    public void send(Object playerConnection) {

    }

}
