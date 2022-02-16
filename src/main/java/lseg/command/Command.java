package lseg.command;

import lseg.model.Interval;
import lseg.LightsStatus;

public interface Command {
    void execute(Interval interval, LightsStatus lightsStatus);
}
