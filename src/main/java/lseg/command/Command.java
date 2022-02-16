package lseg.command;

import lseg.Interval;
import lseg.LightsStatus;

public interface Command {
    void execute(Interval interval, LightsStatus lightsStatus);
}
