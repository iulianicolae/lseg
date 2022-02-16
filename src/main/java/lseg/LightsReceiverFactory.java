package lseg;

import lseg.receiver.BrightnessReceiver;
import lseg.receiver.LightsReceiver;
import lseg.receiver.SimpleReceiver;

public class LightsReceiverFactory {

    public static LightsReceiver getLightReceiver() {
        String lightsSystem = System.getProperty("lights_system");
        if ("simple".equals(lightsSystem)) {
            return new SimpleReceiver();
        } else if ("brightness".equals(lightsSystem)) {
            return new BrightnessReceiver();
        } else {
            throw new UnsupportedOperationException("This light system is not supported");
        }
    }
}
