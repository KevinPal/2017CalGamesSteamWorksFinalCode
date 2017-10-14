package org.usfirst.frc.team2854.commandGroups;

import org.usfirst.frc.team2854.robot.commands.LowerGear;
import org.usfirst.frc.team2854.robot.commands.OpenGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenLower extends CommandGroup {

    public OpenLower() {
        addSequential(new OpenGear());
        addSequential(new LowerGear());
    }
}
