package org.usfirst.frc.team1529.robot.commands;

import org.usfirst.frc.team1529.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {    

    public AutoDriveForward(String sM) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	//case (switchMode){
    		
    		addSequential(new GyroStraight(0, .5, 4000));
    		
    		/*addSequential(new GyroStraight(0, .4,3700));	
    		addSequential(new AutoTurnCommand(-80, "left"));
    		addSequential(new ArmRaiseCommand(15, -.75));
    		addSequential(new IntakeCommand(.5,1));*/
    		
    	
    	//if (sM == "LEFT"){
    	//}
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());0
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
