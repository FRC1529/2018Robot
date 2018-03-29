package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro; 
/**
 *
 */
public class AutoTurnCommand extends Command {
	
	private boolean isFinished;
	private double turnAngle;
	private String direction;
	private double speed = .25;
	
    public AutoTurnCommand(double angle, String D) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.kDriveTrainSubsystem);
    	turnAngle = angle;
    	direction = D;
    	isFinished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.kDriveTrainSubsystem.gyro.reset();
    Robot.kDriveTrainSubsystem.enc.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kDriveTrainSubsystem.gyro.getAngle();
    	
    	if(direction == "right" ){
    		Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput, speed);
    		Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, speed);
    		
    		Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput, speed);
    		Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, speed);
    		if (Robot.kDriveTrainSubsystem.gyro.getAngle() > turnAngle){
    			isFinished = true;
    		}
    	}
    	else if (direction == "left" ){
    		Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput, -speed);
    		Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, -speed);
    		
    		Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput, -speed);
    		Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, -speed);
    		if (Robot.kDriveTrainSubsystem.gyro.getAngle() < turnAngle){
    			isFinished = true;
    		}
    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveTrainSubsystem.stop();
    	Timer.delay(0.5);
		Robot.kDriveTrainSubsystem.gyro.reset();
		Robot.kDriveTrainSubsystem.enc.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("INTERRUPTED AUTOTURN");
    }
}
