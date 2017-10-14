package org.usfirst.frc.team2854.robot.commands;

import org.opencv.core.Mat;
import org.usfirst.frc.team2854.robot.MyGyro;
import org.usfirst.frc.team2854.robot.Robot;
import org.usfirst.frc.team2854.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Turn extends Command {

	private double angle;
	private DriveTrain drive;
	private double minTurnSpeed = .3, maxTurnSpeed = .6;
	private double minTurnAngle = 10, maxTurnAngle = 90;
	private double m = 0, b = 0;
	private double minAngleDiff = 5;
	private MyGyro gyro;
	
	
    public Turn(double angle) {
        requires(Robot.getSubSystems().get("Drive Train"));
        this.angle = angle * 2/3f;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive = (DriveTrain)Robot.getSubSystems().get("Drive Train");
    	gyro = Robot.gyro;	
    	gyro.init();
    	m = (maxTurnSpeed - minTurnSpeed) / (maxTurnAngle - minTurnAngle);
    	b = maxTurnSpeed - maxTurnAngle * m;
    }
    
    public double getSpeed(double angle) {
    	return (angle < minTurnAngle ? minTurnSpeed : (angle > maxTurnAngle ? maxTurnSpeed : (angle * m + b)));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("turn speed", getSpeed(gyro.getAngle()));

    	double angleDiff = Math.abs(gyro.getAngle() - angle);
    	SmartDashboard.putNumber("angle diff", angleDiff);
    if(angle < 0) {
		drive.drive(getSpeed(angleDiff), -getSpeed(angleDiff));
	} else {
		
		drive.drive(-getSpeed(angleDiff), getSpeed(angleDiff));
	}
    	
//    	if(angle < 0) {
//    		drive.drive(turnSpeed, -turnSpeed);
//    	} else {
//    		drive.drive(-turnSpeed, turnSpeed);
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(angle - gyro.getAngle())%360 < minAngleDiff;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Done");
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
