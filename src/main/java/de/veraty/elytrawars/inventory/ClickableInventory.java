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
import org.bukkit.inventory.Inventory;

/**
 * Clickable Inventory.
 *
 * @author merlin
 */
public abstract class ClickableInventory implements Clickable {

    private Inventory inventory;

    /**
     * Constructs a ClickableInventory.
     *
     * @param inventory inventory
     */
    public ClickableInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean matches(User user, Inventory inventory) {
        return inventory.getTitle().equals(this.inventory.getTitle());
    }

    @Override
    public Inventory getInventory(User user) {
        return inventory;
    }

}
