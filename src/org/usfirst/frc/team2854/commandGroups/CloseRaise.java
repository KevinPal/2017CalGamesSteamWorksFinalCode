package org.usfirst.frc.team2854.commandGroups;

import org.usfirst.frc.team2854.robot.commands.CloseGear;
import org.usfirst.frc.team2854.robot.commands.RaiseGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CloseRaise extends CommandGroup {

    public CloseRaise() {
       addSequential(new CloseGear());
       addSequential(new RaiseGear());
    }
}
