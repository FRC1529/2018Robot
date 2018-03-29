package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleCommandGroup extends CommandGroup {

    public AutoMiddleCommandGroup(String switchMode) {
 
		switch (switchMode){
			case "LEFT":
				//Put left auto code here
				addSequential(new AutoDriveCommand(.5, 12));
				addSequential(new AutoTurnCommand(-10,"left"));
				addSequential(new AutoDriveCommand(.5, 56));
				addSequential(new IntakeCommand(1,1));
				break;
			case "RIGHT":
				//Put right auto code here
				addSequential(new AutoDriveCommand(.5, 12));
				addSequential(new AutoTurnCommand(8,"right"));
				addSequential(new AutoDriveCommand(.5, 56));
				addSequential(new IntakeCommand(1,1));
				break;
			//add arm raise
			default:
				System.out.println("PARKER");
				addSequential(new AutoDriveCommand(.5, 12));
				addSequential(new AutoTurnCommand(10,"right"));
				addSequential(new AutoDriveCommand(.5, 56));
				//addSequential(new IntakeCommand(1,1));
				break;
    	}
		addSequential(new AutoPneumaticsCommand(true));
	
    }
}
