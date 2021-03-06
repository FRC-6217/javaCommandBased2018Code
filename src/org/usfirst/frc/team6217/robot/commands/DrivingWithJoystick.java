package org.usfirst.frc.team6217.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import 	org.usfirst.frc.team6217.robot.RobotMap;
import org.usfirst.frc.team6217.robot.Robot;


/**
 *
 */
public class DrivingWithJoystick extends Command {
    public DrivingWithJoystick() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.arcadeDrive(Robot.oi.DriveStick.getRawAxis(0), Robot.oi.DriveStick.getRawAxis(1), Robot.oi.DriveStick.getRawAxis(2), Robot.oi.DriveStick.getRawAxis(RobotMap.GOVERNER_PORT), true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.arcadeDrive(0, 0, 0, 0, true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
