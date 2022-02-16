package lseg.model;

public class Instruction {
    public InstructionType instructionType;
    public Interval interval;
    public String instructionStr;

    public Instruction(InstructionType instructionType, Interval interval) {
        this.instructionType = instructionType;
        this.interval = interval;
    }
}
