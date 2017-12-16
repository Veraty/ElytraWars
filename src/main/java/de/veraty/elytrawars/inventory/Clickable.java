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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * An Clickable is an inventory that can be clicked.
 *
 * @author merlin
 */
public interface Clickable {

    /**
     * Called when the matching inventory is clicked.
     *
     * @param user user
     * @param event event
     */
    void click(User user, InventoryClickEvent event);

    /**
     * Gets whether the given inventory matches.
     *
     * @param user user
     * @param inventory inventory
     * @return
     */
    boolean matches(User user, Inventory inventory);

    /**
     * Gets the inventory.
     *
     * @param user user
     * @return inventory
     */
    Inventory getInventory(User user);

}
