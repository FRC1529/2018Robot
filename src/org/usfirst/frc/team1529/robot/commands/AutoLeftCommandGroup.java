package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftCommandGroup extends CommandGroup {

    public AutoLeftCommandGroup(String switchMode) {
      
		switch (switchMode){
			
			case "LEFT":
				addSequential(new AutoDriveCommand(.5,96));
				addSequential(new AutoTurnCommand(90, "right"));
				addSequential(new AutoPneumaticsCommand(true));
				addSequential(new ArmRaiseCommand(.5,67));
				addSequential(new IntakeCommand(1, 25));
				break;
			case "RIGHT":
				System.out.println("RIGHT MODE IN LEFT COMMAND");
				addSequential(new AutoDriveCommand(.5,96));
				addSequential(new AutoTurnCommand(90, "left"));
				addSequential(new AutoPneumaticsCommand(true));
				addSequential(new ArmRaiseCommand(.5,67));
				addSequential(new IntakeCommand(1, 25));
				break;
			
			default:
				addSequential(new AutoDriveCommand(.5,96));
				addSequential(new AutoTurnCommand(90, "left"));
				addSequential(new AutoPneumaticsCommand(true));
				addSequential(new ArmRaiseCommand(.5,67));
				addSequential(new IntakeCommand(1, 25));
				break;
			
			
		}
    }
}