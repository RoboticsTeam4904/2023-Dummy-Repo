package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;

public class FlywheelConstant extends MotorConstant {

  /**
   * Spin up the shooter to a speed
   * 
   * @param speed  The speed to spin the shooter up to
   */

  public FlywheelConstant() {
    super(RobotMap.Component.flywheelMotor, Flywheel.SHOOT_VELOCITY);
  }

  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);

    LogKitten.wtf("wtf");
  }
}