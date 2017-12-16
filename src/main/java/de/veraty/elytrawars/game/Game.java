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
package de.veraty.elytrawars.game;

import com.google.common.base.Optional;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * The Game class handles the game states and resolves the winner.
 *
 * @author merlin
 */
@Getter
@Setter
public class Game {

    private GameState state;

    private final Set<Squad> squads;

    /**
     * Constructs a Game.
     *
     * @param squads amount of squads
     */
    public Game(int squads) {
        this.squads = new HashSet<>(squads);
    }

    /**
     * Creates the squads.
     *
     * @param squads squads
     */
    public void createSquads(Set<Squad> squads) {
        this.squads.clear();
        this.squads.addAll(squads);
    }

    /**
     * Resolves the winner.
     *
     * @return optional winner
     */
    public Optional<Squad> resolveWinner() {
        return Optional.absent();
    }

    /**
     * Initiates the State.
     *
     * @param state state
     */
    public void initiateState(GameState state) {
        state.initiate(this);
    }

}
