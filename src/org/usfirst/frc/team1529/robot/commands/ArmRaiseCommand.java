package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmRaiseCommand extends Command {
		public static Timer raiseTimer = new Timer();
		private double height;
		private double speed;
		private boolean isFinished;
    public ArmRaiseCommand(double s, double h) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArmSubsystem);
    	requires(Robot.kDriveTrainSubsystem);
    	height = h;
    	speed = s;
    	raiseTimer.start();
    	
    	Robot.kArmSubsystem.Raise(speed, height);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (raiseTimer.hasPeriodPassed(3)){
    		isFinished = true;
    	}

    	
    	System.out.println(Robot.kDriveTrainSubsystem.climbEnc.getDistance() );
    	if (Robot.kDriveTrainSubsystem.climbEnc.getDistance() >= height){
			isFinished = true;
    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Robot.kArmSubsystem.Stop();
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
   
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
