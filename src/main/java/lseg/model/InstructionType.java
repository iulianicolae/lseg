package lseg.model;

import lseg.command.Command;
import lseg.command.ToggleCommand;
import lseg.command.TurnOffCommand;
import lseg.command.TurnOnCommand;
import lseg.receiver.LightsReceiver;

public enum InstructionType implements IInstructionType {
    TURN_ON("turn on") {
        @Override
        public Command getCommand(LightsReceiver lightsReceiver) {
            return new TurnOnCommand(lightsReceiver);
        }
    },
    TURN_OFF("turn off") {
        @Override
        public Command getCommand(LightsReceiver lightsReceiver) {
            return new TurnOffCommand(lightsReceiver);
        }
    },
    TOGGLE("toggle") {
        @Override
        public Command getCommand(LightsReceiver lightsReceiver) {
            return new ToggleCommand(lightsReceiver);
        }
    };

    private final String label;

    InstructionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
