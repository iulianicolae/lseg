package lseg.receiver;

import lseg.model.Interval;
import lseg.LightsStatus;

public interface LightsReceiver {

    void turnOn(Interval interval, LightsStatus lightsStatus);

    void turnOff(Interval interval, LightsStatus lightsStatus);

    void toggle(Interval interval, LightsStatus lightsStatus);
}
