// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;

/** An example command that uses an example subsystem. */
public class FlywheelConstant extends MotorConstant {
  
  public FlywheelConstant(Flywheel flywheel) {
    
    super(flywheel.shooterMotor, Flywheel.SHOOT_VELOCITY);

  }

  }
}
