/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.veraty.elytrawars.game.countdown;

import de.veraty.elytrawars.util.Countdown;

/**
 *
 * @author merlin
 */
public final class IngameCountdown extends Countdown {

    public IngameCountdown() {
        super(Countdown.ASC, 60 * 10);
    }

    @Override
    protected void begin() {
        //TODO: Start Ingame.
    }

    @Override
    protected void tick(int seconds, int minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean finish() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
