package org.usfirst.frc2813.HowDoWeDoThisAgain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDInterface;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;

public class PIDSpeedController implements SpeedController, PIDInterface {
	PIDController pid;
	SpeedController motor;
	private double maxSpeed;
	public PIDSpeedController(SpeedController output, PIDSource source, double maxSpeed, double Kp, double Ki, double Kd) {
		motor=output;
		this.maxSpeed=maxSpeed;
		source.setPIDSourceType(PIDSourceType.kRate);
		pid = new PIDController(Kp, Ki, Kd, source, output);
	}

	@Override
	public void pidWrite(double output) {
		throw new IllegalArgumentException("What on earth are you doing using a PIDSpeedController inside another PIDController!?");
	}

	@Override
	public void setPID(double p, double i, double d) {
		pid.setPID(p, i, d);
	}

	@Override
	public double getP() {
		return pid.getP();
	}

	@Override
	public double getI() {
		return pid.getI();
	}

	@Override
	public double getD() {
		return pid.getD();
	}

	@Override
	public void setSetpoint(double setpoint) {
		pid.setSetpoint(setpoint);
	}

	@Override
	public double getSetpoint() {
		return pid.getSetpoint();
	}

	@Override
	public double getError() {
		return pid.getError();
	}

	@Override
	public void enable() {
		pid.enable();
	}
	
	@Override
	public boolean isEnabled() {
		return pid.isEnabled();
	}

	@Override
	public void reset() {
		pid.reset();
	}

	@Override
	public double get() {
		// This returns the speed the motor is turning regardless of how fast
		// it was set() to go.
		return pid.get();
	}

	@Override
	public void set(double speed) {
		pid.setSetpoint(speed * maxSpeed);
		if(!pid.isEnabled() && speed != 0)
			pid.enable();
	}

	@Override
	public void setInverted(boolean isInverted) {
		motor.setInverted(isInverted);
	}

	@Override
	public boolean getInverted() {
		return motor.getInverted();
	}

	@Override
	public void disable() {
		pid.disable();
		motor.disable();
	}

	@Override
	public void stopMotor() {
		pid.reset();
		motor.stopMotor();
	}

}
