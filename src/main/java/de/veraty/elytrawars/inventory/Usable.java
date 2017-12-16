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
package de.veraty.elytrawars.inventory;

import de.veraty.elytrawars.user.User;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * An Usable is an item that can be used.
 *
 * @author merlin
 */
public interface Usable {

    /**
     * Called when the matching item is interacted on.
     *
     * @param user user
     * @param item item
     */
    void use(User user, PlayerInteractEvent item);

    /**
     * Gets whether the given item matches.
     *
     * @param user user
     * @param item item
     * @return
     */
    boolean matches(User user, ItemStack item);

    /**
     * Gets the item.
     *
     * @param user user
     * @return item
     */
    ItemStack getItem(User user);

}
