package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroStraight extends Command {
	private boolean isFinished;
	private double turnAngle;
	private double distance;
	private String direction;
	private double speed;
	private double Kp = 0.1;
	private long startTime;
	private double time;
	private Timer myTimer = null;
    public GyroStraight(int angle, double speed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kDriveTrainSubsystem);
    	turnAngle = angle;
    	//direction = D;
    	this.speed = -speed;
    	isFinished = false;
    	this.time = time;
    	myTimer = new Timer();
    	//distance = d;
    }

    public GyroStraight(int angle, double speed, double distance, double timeout){
    	requires(Robot.kDriveTrainSubsystem);
    	turnAngle = angle;
    	//direction = D;
    	this.speed = -speed;
    	isFinished = false;
    	this.time = timeout;
    	this.distance = distance;
    	myTimer = new Timer();
    }
    
    public GyroStraight(int angle, double speed, double distance, String FORDistanceLeaveBlank){
    	requires(Robot.kDriveTrainSubsystem);
    	turnAngle = angle;
    	//direction = D;
    	this.speed = -speed;
    	isFinished = false;
    	this.distance = distance;
    }
    

	// Called just before this Command runs the first time
    protected void initialize() {
        Robot.kDriveTrainSubsystem.gyro.reset();
        Robot.kDriveTrainSubsystem.enc.reset();
        startTime = System.currentTimeMillis();
        if (myTimer != null){
        	myTimer.start();
        }
    }
   
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    	Robot.kDriveTrainSubsystem.gyro.getAngle();
    		//double adjusted = speed+findError();
	    	Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput, -speed+findError());
	    	Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput, speed+findError());
	    	Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, -speed+findError());
	    	Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, speed+findError());
	    	
	    	if(Math.abs(Robot.kDriveTrainSubsystem.enc.getDistance()) > distance){
				isFinished = true;
			}
	    	if (myTimer != null && myTimer.hasPeriodPassed(this.time)){
	    		isFinished = true;
	    	}
    	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kDriveTrainSubsystem.FrontLeft.set(ControlMode.PercentOutput, 0);
    	Robot.kDriveTrainSubsystem.FrontRight.set(ControlMode.PercentOutput, 0);
    	Robot.kDriveTrainSubsystem.RearLeft.set(ControlMode.PercentOutput, 0);
    	Robot.kDriveTrainSubsystem.RearRight.set(ControlMode.PercentOutput, 0);
    	
    	Robot.kDriveTrainSubsystem.gyro.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double findError() {
    	return -Kp * (Robot.kDriveTrainSubsystem.gyro.getAngle() - turnAngle);
    }
}
