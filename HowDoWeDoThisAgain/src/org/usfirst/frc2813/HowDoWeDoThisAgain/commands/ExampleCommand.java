package org.usfirst.frc2813.HowDoWeDoThisAgain.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExampleCommand extends Command {

    public ExampleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    // The equivalent of what happens asynchronously when you call start()
    void pseudocodeForRun() {
    	initialize();
    	while(!isFinished())
    		execute();
    	end();
    }
}