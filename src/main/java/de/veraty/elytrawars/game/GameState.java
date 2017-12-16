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

import de.veraty.elytrawars.util.Countdown;
import lombok.Getter;

/**
 * The State of a game.
 *
 * @author merlin
 */
@Getter
public abstract class GameState {

    private final Countdown countdown;
    private final String name;

    public GameState(String name, Countdown countdown) {
        this.name = name;
        this.countdown = countdown;
    }

    /**
     * Initiates the state.
     *
     * @param game game
     */
    public void initiate(Game game) {

        if (game.getState() != null) {
            game.getState().getCountdown().stop();
        }

        game.setState(this);

        this.countdown.start();

        onInitiate();
    }

    protected abstract void onInitiate();

}
