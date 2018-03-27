package org.usfirst.frc.team1529.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMiddleCommandGroup extends CommandGroup {

    public AutoMiddleCommandGroup() {
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
        // arm.'
    	//addSequential(new AutoDriveCommand(.5, 144));
    	//addSequential(new AutoTurnCommand(75, "right"));
    	try{
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			//Put left auto code here
			addSequential(new AutoDriveCommand(.5, 40));
			addSequential(new AutoTurnCommand(90, "left"));
			addSequential(new AutoDriveCommand(.5, 120));
			addSequential(new AutoTurnCommand(90, "right"));
			addSequential(new AutoDriveCommand(.5, 94));
			addSequential(new AutoTurnCommand(90, "right"));
			addSequential(new AutoDriveCommand(.5, 48));
		} 
		else {
			//Put right auto code here
			addSequential(new AutoDriveCommand(.5, 40));
			addSequential(new AutoTurnCommand(90, "right"));
			addSequential(new AutoDriveCommand(.5, 120));
			addSequential(new AutoTurnCommand(90, "left"));
			addSequential(new AutoDriveCommand(.5, 94));
			addSequential(new AutoTurnCommand(90, "left"));
			addSequential(new AutoDriveCommand(.5, 48));
		}
		//add arm raise
		addSequential(new AutoPneumaticsCommand(true));
    	}
		catch(Exception e){
    		addSequential(new AutoDriveCommand(.5, 250));
    	}
    }
}
