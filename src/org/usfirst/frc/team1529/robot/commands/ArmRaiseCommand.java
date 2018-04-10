package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmRaiseCommand extends Command {
		public static Timer raiseTimer;
		private double height;
		private double speed;
		private boolean isFinished;
		private double timeToPass;
    public ArmRaiseCommand(double s, double h) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArmSubsystem);
    	requires(Robot.kDriveTrainSubsystem);
    	height = h;
    	speed = s;
    	//raiseTimer.start();
    	
    	
    }
    public ArmRaiseCommand(double s, double h, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArmSubsystem);
    	requires(Robot.kDriveTrainSubsystem);
    	height = h;
    	speed = s;
    	raiseTimer = new Timer();
    	timeToPass = time;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	raiseTimer.start();
    	Robot.kArmSubsystem.Raise(height, speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if (){
//    		isFinished = true;
//    	}

    	
//    	System.out.println(Robot.kDriveTrainSubsystem.climbEnc.getDistance() );
//    	if (Robot.kDriveTrainSubsystem.climbEnc.getDistance() >= height){
//			isFinished = true;
//    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    
        return raiseTimer.hasPeriodPassed(timeToPass);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kArmSubsystem.ClimbMotor.set(ControlMode.PercentOutput, 0);
    	Robot.kArmSubsystem.ElevatorMotor.set(ControlMode.PercentOutput, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
