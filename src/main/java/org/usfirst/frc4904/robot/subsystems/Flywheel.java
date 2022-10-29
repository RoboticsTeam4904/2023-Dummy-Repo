package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {
    public static final double SHOOT_VELOCITY = 0.1;
    public CANTalonFX motorController;
    public Motor shooterMotor;

    public Flywheel(String name, Motor shooterMotor, CANTalonFX motorController) {
        super();
        setName(name);
        this.motorController = motorController;
        this.shooterMotor = shooterMotor;
    }
}