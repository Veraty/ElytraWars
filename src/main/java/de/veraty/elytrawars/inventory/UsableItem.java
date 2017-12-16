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
import org.bukkit.inventory.ItemStack;

/**
 * Usable ItemStack.
 *
 * @author merlin
 */
public abstract class UsableItem implements Usable {

    private final ItemStack itemStack;

    /**
     * Constructs an UsableItem.
     *
     * @param itemStack item
     */
    public UsableItem(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public boolean matches(User user, ItemStack item) {
        return item.getItemMeta().getDisplayName().equals(itemStack.getItemMeta().getDisplayName());
    }

    @Override
    public ItemStack getItem(User user) {
        return itemStack;
    }

}
