package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.subsytems.motor.Motor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {
    public static final double SHOOT_VELOCITY = 0.1; 
    public CANTalonFX shooterEncoder;
    public Motor shooterMotor;

    public Flywheel(String name, Motor shooterMotor, CANTalonFX shooterEncoder) {
        super();
        setName(name);
        this.shooterMotor = shooterMotor;
        this.shooterEncoder = shooterEncoder;
    }
}