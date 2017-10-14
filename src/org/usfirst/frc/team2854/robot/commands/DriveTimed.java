package org.usfirst.frc.team2854.robot.commands;

import org.usfirst.frc.team2854.robot.Robot;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class DriveTimed extends TimedCommand {
	
	private DriveTrain drive;
	private double speed;

    public DriveTimed(double timeout, double speed) {
        super(timeout);
        requires(Robot.getSubSystems().get("Drive Train"));
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive = (DriveTrain)Robot.getSubSystems().get("Drive Train");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.drive(speed, speed);
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
