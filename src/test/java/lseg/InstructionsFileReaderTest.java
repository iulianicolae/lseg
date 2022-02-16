package lseg;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class InstructionsFileReaderTest {
    @Test
    public void getInstruction_empty_ifEmptyString() {
        InstructionsFileReader instructionsFileReader = new InstructionsFileReader();
        Optional<Instruction> emptyInstruction = instructionsFileReader.getInstruction("");
        assertTrue(emptyInstruction.isEmpty());
    }

    @Test
    public void getInstruction_correct_ifFileLineIsOk() {
        InstructionsFileReader instructionsFileReader = new InstructionsFileReader();
        Optional<Instruction> instructionOptional = instructionsFileReader.getInstruction("turn on 268,631 through 735,814");
        assertTrue(instructionOptional.isPresent());
        Instruction instruction = instructionOptional.get();
        assertEquals(InstructionType.TURN_ON, instruction.instructionType);
        assertEquals(268, instruction.interval.start.x);
        assertEquals(631, instruction.interval.start.y);
        assertEquals(735, instruction.interval.end.x);
        assertEquals(814, instruction.interval.end.y);
    }

    @Test
    public void getInstructions_getAll_ifFileExists() throws IOException, URISyntaxException {
        InstructionsFileReader instructionsFileReader = new InstructionsFileReader();
        URL url = this.getClass()
                .getClassLoader()
                .getResource("coding_challenge_input.txt");
        List<Instruction> instructions = instructionsFileReader.getInstructions(url.toURI());
        assertFalse(instructions.isEmpty());
        assertEquals(20, instructions.size());
    }
}
