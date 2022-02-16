package lseg.receiver;

import lseg.model.Interval;
import lseg.LightsStatus;

public class BrightnessReceiver implements LightsReceiver {

    @Override
    public void turnOn(Interval interval, LightsStatus lightsStatus) {
        for (int i = interval.start.x; i <= interval.end.x; i++) {
            for (int j = interval.start.y; j <= interval.end.y; j++) {
                lightsStatus.lights[i][j]++;
                lightsStatus.counter++;
            }
        }
    }

    @Override
    public void turnOff(Interval interval, LightsStatus lightsStatus) {
        for (int i = interval.start.x; i <= interval.end.x; i++) {
            for (int j = interval.start.y; j <= interval.end.y; j++) {
                if (lightsStatus.lights[i][j] > 0) {
                    lightsStatus.lights[i][j]--;
                    lightsStatus.counter--;
                }
            }
        }
    }

    @Override
    public void toggle(Interval interval, LightsStatus lightsStatus) {
        for (int i = interval.start.x; i <= interval.end.x; i++) {
            for (int j = interval.start.y; j <= interval.end.y; j++) {
                lightsStatus.lights[i][j] = lightsStatus.lights[i][j] + 2;
                lightsStatus.counter = lightsStatus.counter + 2;
            }
        }
    }
}
