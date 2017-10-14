package org.usfirst.frc.team2854.commandGroups;

import org.usfirst.frc.team2854.robot.commands.CloseGear;
import org.usfirst.frc.team2854.robot.commands.Delay;
import org.usfirst.frc.team2854.robot.commands.DriveStraight;
import org.usfirst.frc.team2854.robot.commands.LowerGear;
import org.usfirst.frc.team2854.robot.commands.OpenGear;
import org.usfirst.frc.team2854.robot.commands.RaiseGear;
import org.usfirst.frc.team2854.robot.commands.Turn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SideBaseLineAutoRed extends CommandGroup {

    public SideBaseLineAutoRed() {
    	addSequential(new CloseGear());
    	addSequential(new RaiseGear());
    	addSequential(new Turn(30));
    	addSequential(new DriveStraight(107.67, true, .6));
    	addSequential(new Delay(1));
        addSequential(new Turn(-90));
        addSequential(new DriveStraight(25.25, true, .6));
        addSequential(new Delay(1));
        addSequential(new OpenGear());
        addSequential(new LowerGear());
        addSequential(new DriveStraight(3 * 12, false, .6));
        addSequential(new Turn(60));
        addSequential(new DriveStraight(4 * 12, true, .6));
       
       
    }
}
