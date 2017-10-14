package org.usfirst.frc.team2854.commandGroups;

import org.usfirst.frc.team2854.robot.commands.CloseGear;
import org.usfirst.frc.team2854.robot.commands.Delay;
import org.usfirst.frc.team2854.robot.commands.DriveStraight;
import org.usfirst.frc.team2854.robot.commands.DriveTimed;
import org.usfirst.frc.team2854.robot.commands.LowerGear;
import org.usfirst.frc.team2854.robot.commands.OpenGear;
import org.usfirst.frc.team2854.robot.commands.RaiseGear;
import org.usfirst.frc.team2854.robot.commands.Turn;
import org.usfirst.frc.team2854.robot.commands.doors.CloseBotDoor;
import org.usfirst.frc.team2854.robot.commands.doors.OpenBotDoor;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BallDumpAutoRed extends CommandGroup {

    public BallDumpAutoRed() {
    	addSequential(new CloseGear());
    	addSequential(new RaiseGear());
    	addSequential(new Turn(-30));
    	addSequential(new DriveStraight(107.67, true, .6));	
    	addSequential(new Delay(.5));
        addSequential(new Turn(120));
        addSequential(new DriveStraight(35, true, .6));
        addSequential(new Delay(1));
        addSequential(new OpenGear());
        addSequential(new LowerGear());
        addSequential(new DriveStraight(10, false, .6));
        addSequential(new Turn(17.583));
        addSequential(new DriveStraight(55.55, false, .6));
        addSequential(new Turn(200));
        addSequential(new DriveStraight(55.55, true, .6));
        addSequential(new Delay(.25));
        addSequential(new OpenBotDoor());

        for(int i = 0; i < 5; i++) {
        	addSequential(new DriveTimed(.1, 1));
        	addSequential(new DriveTimed(.1, -1));
        }
        
        addSequential(new Delay(1));
       // addSequential(new CloseBotDoor());
        
    }
}
