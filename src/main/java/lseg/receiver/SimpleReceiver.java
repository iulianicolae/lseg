package lseg.receiver;

import lseg.Interval;
import lseg.LightsStatus;

public class SimpleReceiver implements LightsReceiver {
    @Override
    public void turnOn(Interval interval, LightsStatus lightsStatus) {
        for (int i = interval.start.x; i <= interval.end.x; i++) {
            for (int j = interval.start.y; j <= interval.end.y; j++) {
                if (lightsStatus.lights[i][j] == 0) {
                    lightsStatus.counter++;
                }
                lightsStatus.lights[i][j] = 1;
            }
        }
    }

    @Override
    public void turnOff(Interval interval, LightsStatus lightsStatus) {
        for (int i = interval.start.x; i <= interval.end.x; i++) {
            for (int j = interval.start.y; j <= interval.end.y; j++) {
                if (lightsStatus.lights[i][j] == 1) {
                    lightsStatus.counter--;
                }
                lightsStatus.lights[i][j] = 0;
            }
        }
    }

    @Override
    public void toggle(Interval interval, LightsStatus lightsStatus) {
        for (int i = interval.start.x; i <= interval.end.x; i++) {
            for (int j = interval.start.y; j <= interval.end.y; j++) {
                if (lightsStatus.lights[i][j] == 1) {
                    lightsStatus.counter--;
                    lightsStatus.lights[i][j] = 0;
                } else {
                    lightsStatus.counter++;
                    lightsStatus.lights[i][j] = 1;
                }
            }
        }
    }
}
