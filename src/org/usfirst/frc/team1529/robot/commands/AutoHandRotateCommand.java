package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoHandRotateCommand extends Command {
	private Timer myTimer = new Timer();
	private boolean isFinished;
	private double speed;
	private double angle;

    public AutoHandRotateCommand(double s, double a) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kHandSubsystem);
    	
    	speed = s;
    	angle = a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//isFinished=false;
    	myTimer.start();
    	Robot.kHandSubsystem.HandRotate.set(ControlMode.PercentOutput, speed);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.kHandSubsystem.handEnc.getDistance() == angle){
    		isFinished = true;
    		System.out.println("We be jammin'!!!!!!!!!!!!!");
        	}

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return myTimer.hasPeriodPassed(angle);
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kHandSubsystem.HandRotate.set(ControlMode.PercentOutput, speed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
