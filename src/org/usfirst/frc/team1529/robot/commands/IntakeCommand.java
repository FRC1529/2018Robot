package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {
	private boolean isFinished;
	private double speed;
	private double time;
	private int Auto_counter = 0;
    public IntakeCommand(double s, double t) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kHandSubsystem);
    	speed = s;
    	time = t;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Auto_counter++;
    	
    	Robot.kHandSubsystem.LeftIntake.set(ControlMode.PercentOutput, speed);
    	Robot.kHandSubsystem.RightIntake.set(ControlMode.PercentOutput, -speed);
    	
    	if(Auto_counter >= time){
    		isFinished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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