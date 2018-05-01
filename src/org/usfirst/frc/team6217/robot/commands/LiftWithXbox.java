package org.usfirst.frc.team6217.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6217.robot.Robot;
import org.usfirst.frc.team6217.robot.RobotMap;

/**
 *
 */
public class LiftWithXbox extends Command {
	public double lift1Direction;
	public double lift2Direction;
	public double lift1Down;
	public double lift2Down;
	
	public LiftWithXbox() {
        requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lift1Direction = RobotMap.LIFT_DIRECTION_STOP;
    	lift2Direction = RobotMap.LIFT_DIRECTION_STOP;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift1Direction = RobotMap.LIFT_DIRECTION_STOP;
    	lift2Direction = RobotMap.LIFT_DIRECTION_STOP;
    	lift1Down = Robot.oi.gameController.getRawAxis(RobotMap.LIFT_1_DOWN);
    	lift2Down = Robot.oi.gameController.getRawAxis(RobotMap.LIFT_2_DOWN);
    	
    	//Lift 1 Operation
    	if (Robot.oi.gameController.getRawButton(RobotMap.LIFT_1_UP)) {
    		lift1Direction = RobotMap.LIFT_DIRECTION_DOWN;
    	}
    	else if (Robot.oi.gameController.getRawButton(RobotMap.LIFT_1_FAST)) {
    		lift1Direction = RobotMap.LIFT_DIRECTION_FAST;
    	}
    	else if (lift1Down == RobotMap.TRIGGER_PERCENT_PRESS) {
    		lift1Direction = RobotMap.LIFT_DIRECTION_DOWN;
    	}
    	Robot.lift.OperateLift1(lift1Direction);
    	
    	//Lift 2 Operation
    	if (Robot.oi.gameController.getRawButton(RobotMap.LIFT_2_UP)) {
    		lift2Direction = RobotMap.LIFT_DIRECTION_UP;
    	}
    	else if (lift2Down == RobotMap.TRIGGER_PERCENT_PRESS) {
    		lift2Direction = RobotMap.LIFT_DIRECTION_DOWN;
    	}
    	Robot.lift.OperateLift2(lift2Direction);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.OperateLift1(RobotMap.LIFT_DIRECTION_DOWN);
    	Robot.lift.OperateLift2(RobotMap.LIFT_DIRECTION_DOWN);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
