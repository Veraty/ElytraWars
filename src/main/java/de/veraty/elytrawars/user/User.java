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
package de.veraty.elytrawars.user;

import java.util.Map;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Color;
import org.bukkit.entity.Player;

/**
 * ForwardingPlayer that provides data and methods.
 *
 * @author merlin
 */
@Getter
@Setter
@Data
public final class User extends ForwardingPlayer {

    private static Map<UUID, User> instances;

    private final Player delegate;

    /*
     **************************************
     */
    private boolean alive;
    private int teamChoice;

    /*
     **************************************
     */
    protected User(Player player) {
        this.delegate = player;
        this.alive = true;
        this.teamChoice = -1;
    }

    @Override
    protected Player delegate() {
        return delegate;
    }

    /**
     * Glows the player in the given color.
     *
     * @param player player
     * @param color color
     */
    public void glow(Player player, Color color) {
    }

    /**
     * Removes the glow effect from the player.
     *
     * @param player player
     */
    public void unglow(Player player) {
    }

    /**
     * Gets an user instance or creates a new one.
     *
     * @param player player
     * @return instance
     */
    public static User getUser(Player player) {
        if (instances.containsKey(player.getUniqueId())) {
            return instances.get(player.getUniqueId());
        }

        User instance = new User(player);
        instances.put(player.getUniqueId(), instance);
        return instance;
    }

    /**
     * Gets an user instance.
     *
     * @param uuid uuid
     * @return instance
     */
    public static User getUser(UUID uuid) {
        return instances.get(uuid);
    }

}
