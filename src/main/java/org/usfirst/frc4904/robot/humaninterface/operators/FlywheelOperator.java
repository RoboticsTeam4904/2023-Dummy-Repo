package org.usfirst.frc4904.robot.humaninterface.operators;


import org.usfirst.frc4904.robot.Robot;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelConstant;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;

public class FlywheelOperator extends Operator {
	public FlywheelOperator() {
		super("FlywheelOperator");
	}

	public FlywheelOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Operator.joystick.button1.whenPressed(
			new RunFor(new FlywheelConstant(RobotMap.Component.flywheel),5));
	}
}