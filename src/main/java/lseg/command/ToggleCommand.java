package lseg.command;

import lseg.model.Interval;
import lseg.LightsStatus;
import lseg.receiver.LightsReceiver;

public class ToggleCommand implements Command {
    LightsReceiver lightsReceiver;

    public ToggleCommand(LightsReceiver lightsReceiver) {
        this.lightsReceiver = lightsReceiver;
    }

    @Override
    public void execute(Interval interval, LightsStatus lightsStatus) {
        lightsReceiver.toggle(interval, lightsStatus);
    }
}
