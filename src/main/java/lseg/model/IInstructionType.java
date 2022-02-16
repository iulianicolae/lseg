package lseg.model;

import lseg.command.Command;
import lseg.receiver.LightsReceiver;

public interface IInstructionType {
    Command getCommand(LightsReceiver lightsReceiver);
}
