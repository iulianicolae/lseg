package lseg;

import lseg.*;
import lseg.receiver.LightsReceiver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LightshowTest {
    @Test
    public void executeInstruction_correctlyCounting_IfSympleSystem() {
        System.setProperty("lights_system", "simple");
        Lightshow lightshow = new Lightshow();
        LightsReceiver lightsReceiver = LightsReceiverFactory.getLightReceiver();
        LightsStatus lightsStatus = new LightsStatus();
        Interval interval = new Interval(new lseg.Coordinates(0, 0), new lseg.Coordinates(999, 999));
        Instruction turnOnInstruction = new Instruction(InstructionType.TURN_ON, interval);
        lightshow.executeInstruction(lightsReceiver, lightsStatus, turnOnInstruction);
        assertEquals(1000000, lightsStatus.counter);

        interval = new Interval(new lseg.Coordinates(499, 499), new lseg.Coordinates(500, 500));
        Instruction turnOffInstruction = new Instruction(InstructionType.TURN_OFF, interval);
        lightshow.executeInstruction(lightsReceiver, lightsStatus, turnOffInstruction);
        assertEquals(999996, lightsStatus.counter);

        interval = new Interval(new lseg.Coordinates(0, 499), new lseg.Coordinates(999, 500));
        Instruction toggleInstruction = new Instruction(InstructionType.TOGGLE, interval);
        lightshow.executeInstruction(lightsReceiver, lightsStatus, toggleInstruction);
        assertEquals(998004, lightsStatus.counter);
    }

    @Test
    public void executeInstruction_correctlyCounting_IfBrightnessSystem() {
        System.setProperty("lights_system", "brightness");
        Lightshow lightshow = new Lightshow();
        LightsReceiver lightsReceiver = LightsReceiverFactory.getLightReceiver();
        LightsStatus lightsStatus = new LightsStatus();
        Interval interval = new Interval(new lseg.Coordinates(0, 0), new lseg.Coordinates(999, 999));
        Instruction turnOnInstruction = new Instruction(InstructionType.TURN_ON, interval);
        lightshow.executeInstruction(lightsReceiver, lightsStatus, turnOnInstruction);

        interval = new Interval(new lseg.Coordinates(499, 499), new lseg.Coordinates(500, 500));
        Instruction turnOffInstruction = new Instruction(InstructionType.TURN_OFF, interval);
        lightshow.executeInstruction(lightsReceiver, lightsStatus, turnOffInstruction);

        interval = new Interval(new lseg.Coordinates(0, 499), new lseg.Coordinates(999, 500));
        Instruction toggleInstruction = new Instruction(InstructionType.TOGGLE, interval);
        lightshow.executeInstruction(lightsReceiver, lightsStatus, toggleInstruction);

        assertEquals(1003996, lightsStatus.counter);
    }

}
