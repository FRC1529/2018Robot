package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoPneumaticsCommand extends Command {

		private boolean isFinished;
		private boolean air;
		

    public AutoPneumaticsCommand(boolean a) {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.kHandSubsystem);
    	 air = a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	
    	if(air == true){
    		Robot.kHandSubsystem.Solenoid.set(DoubleSolenoid.Value.kForward);	
    		isFinished = true;
    	}
    	else if(air == false){
    		Robot.kHandSubsystem.Solenoid.set(DoubleSolenoid.Value.kReverse);
    		isFinished = true;
    		}
    }
    // Called repeatedly when this Command is scheduled to run
   // protected void execute() {
    	
    

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
