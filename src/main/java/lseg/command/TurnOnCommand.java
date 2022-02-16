package lseg.command;

import lseg.model.Interval;
import lseg.LightsStatus;
import lseg.receiver.LightsReceiver;

public class TurnOnCommand implements Command {
    private LightsReceiver lightsReceiver;

    public TurnOnCommand(LightsReceiver lightsReceiver) {
        this.lightsReceiver = lightsReceiver;
    }

    @Override
    public void execute(Interval interval, LightsStatus lightsStatus) {
        lightsReceiver.turnOn(interval, lightsStatus);
    }
}
