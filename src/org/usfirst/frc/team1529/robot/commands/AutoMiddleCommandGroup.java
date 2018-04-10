package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */	
public class AutoMiddleCommandGroup extends CommandGroup {
	
    public AutoMiddleCommandGroup(String switchMode) {
    	addSequential(new AutoPneumaticsCommand(true));
		switch (switchMode){
			case "LEFT":
				//Put left auto code here
				addSequential(new AutoPneumaticsCommand(true));
				addSequential(new AutoDriveCommand(.5, 16, 3));
				addSequential(new AutoTurnCommand(-28,"left"));
				addSequential(new ArmRaiseCommand(1, 24, 1.5));
				
				addSequential(new AutoDriveCommand(.5, 80, 6));	
				addSequential(new AutoTurnCommand(20,"right"));
				//addSequential(new ArmRaiseCommand(28, -.75));
				addSequential(new IntakeCommand(1,1));
				addSequential(new AutoPneumaticsCommand(false));
				break;
			case "RIGHT":
				//Put right auto code here
				addSequential(new AutoPneumaticsCommand(true));
				addSequential(new AutoDriveCommand(.5, 14, 3));
				addSequential(new AutoTurnCommand(20,"right"));
				addSequential(new ArmRaiseCommand(1, 24, 1.5));
				addSequential(new AutoDriveCommand(.5, 80, 6));	
				addSequential(new AutoTurnCommand(-28,"left"));
				
				//addSequential(new AutoDriveCommand(0, .4, 400));
				//addSequential(new IntakeCommand(1,1));
				addSequential(new AutoPneumaticsCommand(false));
				break;
			//add arm raise
			default:
				System.out.println("PARKER");
				addSequential(new AutoDriveCommand(.5, 12));
				addSequential(new AutoTurnCommand(10,"right"));
				addSequential(new AutoDriveCommand(.5, 56, 5));
				//addSequential(new ArmRaiseCommand(.5,67));
				//addSequential(new IntakeCommand(1,1));
				
				break;
    	}
		
    }
}
