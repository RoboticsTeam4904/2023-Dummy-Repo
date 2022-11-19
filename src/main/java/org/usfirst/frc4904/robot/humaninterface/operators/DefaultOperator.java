package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.RobotMap.HumanInput;
import org.usfirst.frc4904.robot.commands.FlywheelConstant;
import org.usfirst.frc4904.standard.humaninput.Operator;

import org.usfirst.frc4904.standard.commands.RunFor;
import org.usfirst.frc4904.standard.custom.controllers.CustomButton;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}
	public boolean toggle = false;
	public int is_b2_pressed = -1;

	@Override
	public void bindCommands() {
		final boolean b2_state = HumanInput.Operator.joystick.getRawButtonPressed(2);

		if (is_b2_pressed == -1){
			if (b2_state){
				is_b2_pressed = 1;
			}
		}
		if (is_b2_pressed == 0){
			if (!b2_state){
				is_b2_pressed = -1;
			}
		}
		
		if (is_b2_pressed == 1){
			if (this.toggle){
				RobotMap.Component.flywheel.shoot_velocity = 0.3;
				this.toggle = false;
			} else{
				RobotMap.Component.flywheel.shoot_velocity = 0.1;
				this.toggle = true;
			}
			is_b2_pressed = 0;
		}

		RobotMap.HumanInput.Operator.joystick.button1.whenPressed(
			new RunFor(new FlywheelConstant(RobotMap.Component.flywheel), 1)
		);
	}
}