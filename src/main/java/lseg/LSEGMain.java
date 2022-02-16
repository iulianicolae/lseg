package lseg;

import lseg.receiver.LightsReceiver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LSEGMain {

    public static void main(String[] args) throws URISyntaxException, IOException {
        LightsReceiver lightReceiver = LightsReceiverFactory.getLightReceiver();
        LightsStatus lightsStatus = new LightsStatus();
        Lightshow lightshow = new Lightshow();
        URL url = LSEGMain.class
                .getClassLoader()
                .getResource("coding_challenge_input.txt");
        lightshow.printNumberOfLightsPerInstruction(lightReceiver, lightsStatus, url.toURI());

    }


}
