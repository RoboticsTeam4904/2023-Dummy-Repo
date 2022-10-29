package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class FlywheelConstant extends MotorConstant {
    public FlywheelConstant(Flywheel flywheel) {
        super(flywheel.shooterMotor, Flywheel.SHOOT_VELOCITY);
    }
}