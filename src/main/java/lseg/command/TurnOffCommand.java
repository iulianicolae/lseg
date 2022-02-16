package lseg.command;

import lseg.model.Interval;
import lseg.LightsStatus;
import lseg.receiver.LightsReceiver;

public class TurnOffCommand implements Command {
    LightsReceiver lightsReceiver;

    public TurnOffCommand(LightsReceiver lightsReceiver) {
        this.lightsReceiver = lightsReceiver;
    }

    @Override
    public void execute(Interval interval, LightsStatus lightsStatus) {
        lightsReceiver.turnOff(interval, lightsStatus);
    }
}
