/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.util.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * Serializable Version of the {@linkplain org.bukkit.Location} Class.
 *
 * @author merlin
 */
@Getter
@AllArgsConstructor
@Data
public class SerializeLocation implements SerializeObject<Location> {

    private final String world;
    private final double x, y, z;
    private final float yaw, pitch;

    public SerializeLocation(Location location) {
        this(location.getWorld().getName(),
                location.getX(), location.getY(), location.getZ(),
                location.getYaw(), location.getPitch());
    }

    @Override
    public Location convert() {
        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

}
