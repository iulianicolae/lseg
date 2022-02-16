package lseg;

import lseg.command.Command;
import lseg.model.Instruction;
import lseg.receiver.LightsReceiver;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class Lightshow {

    public void printNumberOfLightsPerInstruction(LightsReceiver lightsReceiver, LightsStatus lightsStatus, URI fileUri) throws IOException {
        InstructionsFileReader instructionsFileReader = new InstructionsFileReader();
        List<Instruction> instructions = instructionsFileReader.getInstructions(fileUri);
        for (Instruction instruction : instructions) {
            executeInstruction(lightsReceiver, lightsStatus, instruction);
            System.out.println(instruction.instructionStr + " - " + lightsStatus.counter);
        }
    }

    public void executeInstruction(LightsReceiver lightsReceiver, LightsStatus lightsStatus, Instruction instruction) {
        Command command = instruction.instructionType.getCommand(lightsReceiver);
        command.execute(instruction.interval, lightsStatus);

    }
}
