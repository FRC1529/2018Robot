package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftCommandGroup extends CommandGroup {

    public AutoLeftCommandGroup() {
        Robot.kDriveTrainSubsystem.gyro.reset();
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//addSequential(new AutoDriveCommand(.5, 144));
    	//addSequential(new AutoTurnCommand(75, "right"));
    	
    	try{
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			//Put left auto code here
			/*addSequential(new AutoPneumaticsCommand(false));
			
			addSequential(new AutoHandRotateCommand(.25, 2));
			
			addSequential(new AutoDriveCommand(.5, 264));
			
			addParallel(new ArmRaiseCommand(.5,67));
			
			addSequential(new AutoTurnCommand(90, "right"));
			
			addSequential(new AutoDriveCommand(.5, 28));
			
			addSequential(new AutoPneumaticsCommand(true));
			
			addSequential(new AutoTurnCommand(90, "right"));
			
			addSequential(new AutoDriveCommand(.5, 72));
			
			addSequential(new AutoTurnCommand(90, "left"));	
			
			addSequential(new AutoDriveCommand(.5, 40));
			
			addSequential(new AutoTurnCommand(90, "right"));
			
			addParallel(new AutoPneumaticsCommand(true));
			
			addSequential(new AutoDriveCommand(.5, 8));
			
			addSequential(new AutoPneumaticsCommand(false));
			
			addSequential(new AutoTurnCommand(70, "left"));
			
			addSequential(new ArmRaiseCommand(-.5, 19));
			
			addSequential(new IntakeCommand(1, 25));*/
			
			addSequential(new AutoDriveCommand(.5,96));
			addSequential(new AutoTurnCommand(90, "right"));
			addSequential(new AutoPneumaticsCommand(true));
			addSequential(new ArmRaiseCommand(.5,67));
			addSequential(new IntakeCommand(1, 25));
			//addSequential(new AutoHandRotateCommand(.25,2));
			

		} 
		else {
			//Put right auto code here
			/*addSequential(new AutoPneumaticsCommand(false));
			
			addSequential(new AutoHandRotateCommand(.25, 2));
			
			addSequential(new AutoDriveCommand(.5, 192));
			
			addSequential(new AutoTurnCommand(90, "right"));
			
			addSequential(new AutoDriveCommand(.5, 188));
			
			addSequential(new AutoTurnCommand(90, "left"));
			
			addSequential(new AutoDriveCommand(.5, 52));
			
			addParallel(new ArmRaiseCommand(.5,67));
			
			addSequential(new IntakeCommand(.7, 30));

			addSequential(new AutoTurnCommand(180, "right"));
			
			addSequential(new AutoDriveCommand(.5, 52));	
			
			addSequential(new AutoTurnCommand(90, "right"));
			
			addSequential(new AutoDriveCommand(.5, 12));	
			
			addSequential(new AutoTurnCommand(90, "left"));
			
			addSequential(new AutoDriveCommand(.5, 16));	
			
			addParallel(new AutoPneumaticsCommand(false));
			
			addSequential(new AutoTurnCommand(70, "right"));	
			
			addSequential(new IntakeCommand(1, 25));
		}*/
			addSequential(new AutoDriveCommand(.5,96));
			addSequential(new AutoTurnCommand(90, "left"));
			addSequential(new AutoPneumaticsCommand(true));
			addSequential(new ArmRaiseCommand(.5,67));
			addSequential(new IntakeCommand(1, 25));
			
		}
    }
    	catch(Exception e){
    		addSequential(new AutoDriveCommand(.5,96));
			addSequential(new AutoTurnCommand(90, "left"));
			addSequential(new AutoPneumaticsCommand(true));
			addSequential(new ArmRaiseCommand(.5,67));
			addSequential(new IntakeCommand(1, 25));
			
    	}

    }
}