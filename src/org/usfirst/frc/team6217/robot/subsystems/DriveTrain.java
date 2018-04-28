package org.usfirst.frc.team6217.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private int speedOfY =0;
	private int speedOfZ =0;
	private int speedOfX =0;
	
	public boolean signbit(double xSignbit) {
		if (xSignbit >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void driveTrain(float xDir,float yDir ,float zRotation ,double governer , boolean squaredInputs) {
    	int lastSpeedOfY = 0;
    	int lastSpeedOfX = 0;
    	int lastSpeedOfZ = 0;
    	
    	//Dead Zone
    	xDir = (float) (Math.abs(xDir) < 0.10 ? xDir : 0.0);
    	yDir = (float) (Math.abs(yDir) < 0.10 ? yDir : 0.0);
    	zRotation = (float) (Math.abs(zRotation) < 0.15 ? zRotation :0.0);
    	
	}
}

