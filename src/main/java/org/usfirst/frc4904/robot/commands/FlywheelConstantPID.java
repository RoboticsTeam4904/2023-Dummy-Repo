
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.motor.MotorPositionConstant;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FlywheelConstantPID extends MotorPositionConstant {
	public FlywheelConstantPID(double turretRadians) {
		// Restrain position set to be within one turret rotation, reverse to other side if needed
		// final double pos =;                    // encoder ticks

		super(flywheel.motor,  turretModulo(turretRadians)  // turret radians
		/ Flywheel.RADIANS_PER_REV                    // turret revs
		* Flywheel.MOTOR_REV_PER_TURRET_REV           // motor revs
		* Flywheel.TICKS_PER_REVM);
	}

	@Override
	public boolean isFinished() {
		if (RobotMap.Component.turret.turretEncoder.getFwdLimitSwitchClosed() == 1 || RobotMap.Component.turret.turretEncoder.getRevLimitSwitchClosed() == 1) {
			return true;
		}
		if(super.isFinished()) LogKitten.wtf("turret command end");
		return super.isFinished();
	}
	
	/// take a radian value and normalize to [-pi, pi]
	private static double turretModulo(double radians) {
		return (((radians + Math.PI) % (2*Math.PI)) + (2*Math.PI)) % (2*Math.PI) - Math.PI;
	}
}