package org.aquapackrobotics.sw8s.states;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.aquapackrobotics.sw8s.trainingsim.SimWindow;

public class StrokeFiveState extends SimState {

    private SimWindow sim;
    public StrokeFiveState(ScheduledThreadPoolExecutor pool, SimWindow sim) {
        super(pool, sim);
        this.sim = sim;
    }

    @Override
    public void onEnter() {
        
    }

    @Override
    public boolean onPeriodic() {
        sim.setRobotSpeed(0, 1, 0);
        if (sim.getYPos() > 550.0) {
            sim.setRobotSpeed(0, 0, 0);
            return true;
        }
        return false;
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public State nextState() {
        return new StrokeSixState(pool, sim);
    }
    
}