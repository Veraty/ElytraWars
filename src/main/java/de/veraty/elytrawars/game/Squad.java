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

import de.veraty.elytrawars.user.User;
import de.veraty.elytrawars.util.GameColor;
import java.util.Set;
import java.util.function.Consumer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * A Squad has a list of members.
 *
 * @author merlin
 */
@Getter
@Setter
@Data
public class Squad {

    private final String name;
    private final GameColor color;
    private final Set<User> members;
    private int aliveMembers;

    /**
     * Constructs a Squad.
     *
     * @param name
     * @param color
     * @param members
     */
    public Squad(String name, GameColor color, Set<User> members) {
        this.name = name;
        this.color = color;
        this.members = members;
        this.aliveMembers = members.size();
    }

    /**
     * Executes the action for every member.
     *
     * @param consumer consumer
     */
    public void forEach(Consumer<User> consumer) {
        members.forEach(consumer);
    }

    /**
     * Executes the action for every alive member.
     *
     * @param consumer consumer
     */
    public void forEachAlive(Consumer<User> consumer) {
        members.forEach((user) -> {
            if (user.isAlive()) {
                consumer.accept(user);
            }
        });
    }

    public boolean isAlive() {
        return aliveMembers > 0;
    }

    /**
     * Updates the alive player amount.
     */
    public void updateAliveMembers() {
        this.aliveMembers = 0;

        forEachAlive(new Consumer<User>() {
            @Override
            public void accept(User alive) {
                aliveMembers++;
            }
        });
    }

}
