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
				addSequential(new AutoDriveCommand(.5, 40));
				addSequential(new AutoTurnCommand(90, "left"));
				addSequential(new AutoDriveCommand(.5, 120));
				addSequential(new AutoTurnCommand(90, "right"));
				addSequential(new AutoDriveCommand(.5, 94));
				addSequential(new AutoTurnCommand(90, "right"));
				addSequential(new AutoDriveCommand(.5, 48));
				break;
			case "RIGHT":
				//Put right auto code here
				addSequential(new AutoDriveCommand(.5, 40));
				addSequential(new AutoTurnCommand(90, "right"));
				addSequential(new AutoDriveCommand(.5, 120));
				addSequential(new AutoTurnCommand(90, "left"));
				addSequential(new AutoDriveCommand(.5, 94));
				addSequential(new AutoTurnCommand(90, "left"));
				addSequential(new AutoDriveCommand(.5, 48));
				break;
			//add arm raise
			default:
				System.out.println("PARKER");
				addSequential(new AutoDriveCommand(.5, 40));
				addSequential(new ArmRaiseCommand(.5,12));
				addSequential(new IntakeCommand(1,25));
				break;
    	}
		addSequential(new AutoPneumaticsCommand(true));
	
    }
}
