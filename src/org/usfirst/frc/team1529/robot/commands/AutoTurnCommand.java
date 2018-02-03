package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro; 
/**
 *
 */
public class AutoTurnCommand extends Command {
	boolean isFinished = false;
    public AutoTurnCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.kDriveTrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.kDriveTrainSubsystem.gyro.reset();
    Robot.kDriveTrainSubsystem.enc.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kDriveTrainSubsystem.gyro.getAngle();
    	Robot.kDriveTrainSubsystem.mydrive.tankDrive(.75, -.75);
		if (Robot.kDriveTrainSubsystem.gyro.getAngle() > 75){
			isFinished = true;
    }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveTrainSubsystem.stop();
    	Timer.delay(.25);
		Robot.kDriveTrainSubsystem.gyro.reset();
		Robot.kDriveTrainSubsystem.enc.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("INTERRUPTED AUTOTURN");
    }
}
