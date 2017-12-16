/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.game.countdown;

import de.veraty.elytrawars.util.Countdown;
import org.bukkit.Bukkit;

/**
 *
 * @author merlin
 */
public final class WaitingCountdown extends Countdown {

    public WaitingCountdown() {
        super(Countdown.DESC, 60);
    }

    @Override
    protected void tick(int seconds, int minutes) {
    }

    @Override
    protected void begin() {
    }

    @Override
    protected boolean finish() {
        if (Bukkit.getOnlinePlayers().size() > 2) {
            return true;
        }
        return false;
    }

}
