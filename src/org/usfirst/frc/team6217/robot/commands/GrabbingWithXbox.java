package org.usfirst.frc.team6217.robot.commands;

import org.usfirst.frc.team6217.robot.Robot;
import org.usfirst.frc.team6217.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabbingWithXbox extends Command {
	public double currentSpeed;
	public int currentDirection = 0;
	
	public GrabbingWithXbox() {
        requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentSpeed = 0;
    	currentDirection = RobotMap.GRABBER_STOP;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.gameController.getRawButton(RobotMap.GRABBER_IN_BUTTON)){
    		currentDirection = RobotMap.GRABBER_IN;
    		currentSpeed = .8;
    	}
    	else if (Robot.oi.gameController.getRawButton(RobotMap.GRABBER_OUT_BUTTON)){
    		currentDirection = RobotMap.GRABBER_OUT;
    		currentSpeed = .8;
    	}
    	else if (Robot.oi.gameController.getRawButton(RobotMap.GRABBER_SLOW_BUTTON)){
    		currentDirection = RobotMap.GRABBER_OUT;
    		currentSpeed = .5;
    	}
    	else if(Robot.oi.gameController.getRawButton(RobotMap.GRABBER_STOP_BUTTON)){
    		currentDirection = RobotMap.GRABBER_STOP;
    		currentSpeed = .8;
    	}
    	if (currentDirection == RobotMap.GRABBER_STOP){
    		if (Robot.oi.gameController.getRawAxis(RobotMap.GRABBER_LEFT_SIDE_AXIS) >= .25){
    			Robot.grabber.RunningLeftGrabber(RobotMap.GRABBER_IN, .8);
    		}
    		else if (Robot.oi.gameController.getRawAxis(RobotMap.GRABBER_LEFT_SIDE_AXIS) <= -.25){
    			Robot.grabber.RunningLeftGrabber(RobotMap.GRABBER_OUT, .8);
    		}
    		else {
    			Robot.grabber.RunningLeftGrabber(RobotMap.GRABBER_STOP, 0);
    		}

    		if (Robot.oi.gameController.getRawAxis(RobotMap.GRABBER_RIGHT_SIDE_AXIS) >= .25){
    			Robot.grabber.RunningRightGrabber(RobotMap.GRABBER_IN, .8);
    		}
    		else if (Robot.oi.gameController.getRawAxis(RobotMap.GRABBER_RIGHT_SIDE_AXIS) <= -.25){
    			Robot.grabber.RunningRightGrabber(RobotMap.GRABBER_OUT, .8);
    		}
    		else{
    			Robot.grabber.RunningRightGrabber(RobotMap.GRABBER_STOP, 0);
    		}
    	}
    	else {
    		Robot.grabber.RunningGrabber(currentDirection, currentSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.grabber.RunningGrabber(RobotMap.GRABBER_STOP, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
