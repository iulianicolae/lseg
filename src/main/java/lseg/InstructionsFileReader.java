package lseg;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class InstructionsFileReader {

    public List<Instruction> getInstructions(URI fileUri) throws IOException {
        String fileContent = Files.readString(Path.of(fileUri));
        return fileContent.lines()
                .map(this::getInstruction)
                .filter(Optional::isPresent)
                .map(Optional::get).collect(toList());
    }

    public Optional<Instruction> getInstruction(String fileLine) {
        if (fileLine.isBlank()) {
            return Optional.empty();
        }
        Optional<InstructionType> instructionTypeOptional = findInstructionType(fileLine);
        if (instructionTypeOptional.isEmpty()) {
            return Optional.empty();
        }
        InstructionType instructionType = instructionTypeOptional.get();
        String fileLineWithoutInstructionType = fileLine.replace(instructionType.getLabel(), "");
        if (fileLineWithoutInstructionType.isBlank()) {
            return Optional.empty();
        }
        Instruction instruction = new Instruction(instructionType, getInterval(fileLineWithoutInstructionType));
        instruction.instructionStr = fileLine;
        return Optional.of(instruction);
    }

    private Interval getInterval(String fileLineWithoutInstructionType) {
        String[] intervalStr = fileLineWithoutInstructionType.split("through");
        String[] startCoordinatesStr = intervalStr[0].split(",");
        String[] endCoordinatesStr = intervalStr[1].split(",");
        Coordinates start = new Coordinates(Integer.parseInt(startCoordinatesStr[0].trim()), Integer.parseInt(startCoordinatesStr[1].trim()));
        Coordinates end = new Coordinates(Integer.parseInt(endCoordinatesStr[0].trim()), Integer.parseInt(endCoordinatesStr[1].trim()));
        return new Interval(start, end);
    }

    private Optional<InstructionType> findInstructionType(String fileLine) {
        return Arrays.stream(InstructionType.values()).filter(v -> fileLine.contains(v.getLabel())).findAny();
    }
}
