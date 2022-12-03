package org.usfirst.frc4904.robot;

import edu.wpi.first.wpilibj2.command.Subsystem;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
	    public static final int xboxController = 1;
        }

        public static class CANMotor {
            public static final int FLYWHEEL_MOTOR = 8; // TODO: set port

        }

        public static class PWM {
        }

        public static class CAN {
        }

        public static class Pneumatics {
        }

        public static class Digital {
        }
    }

    public static class Metrics {
        public static class Chassis {
            public static final double TICKS_PER_REVOLUTION = -1; // TODO: CHANGE CONSTS
            public static final double DIAMETER_INCHES = -1;
            public static final double CIRCUMFERENCE_INCHES = Metrics.Chassis.DIAMETER_INCHES * Math.PI;
            public static final double TICKS_PER_INCH = Metrics.Chassis.TICKS_PER_REVOLUTION
                    / Metrics.Chassis.CIRCUMFERENCE_INCHES;
            public static final double DISTANCE_FRONT_BACK = -1;
            public static final double DISTANCE_SIDE_SIDE = -1;
            public static final double INCHES_PER_TICK = Metrics.Chassis.CIRCUMFERENCE_INCHES
                    / Metrics.Chassis.TICKS_PER_REVOLUTION;
        }
    }

    public static class PID {
        public static class Turret {
            public static final double P = 0; // TODO: TUNE (6e-5)
            public static final double I = 0; // 3E-8
            public static final double D = 0; // (2e-6)
            public static final double F = 0;
            // public static final double tolerance = -1;
            // public static final double dTolerance = -1;

        }
    }

    public static class Component {
        public static CANTalonFX flywheelMotor;
        public static CustomPIDController flywheelPID;
        public static CANTalonEncoder flywheelEncoder;
        public static Flywheel flywheel;

    }

    public static class Input {
    }

    public static class HumanInput {
        public static class Driver {
            public static CustomXbox xbox;
        }

        public static class Operator {
            public static CustomJoystick joystick;
        }
    }

    public RobotMap() {
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController); // Initialize xbox controller object
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick); // Initialize Joystick object

        Component.flywheelMotor = new CANTalonFX(Port.CANMotor.FLYWHEEL_MOTOR);
        Component.flywheelEncoder = new CANTalonEncoder(Component.flywheelMotor);
        Component.flywheelPID = new CustomPIDController(PID.Turret.P,
                PID.Turret.I, PID.Turret.D, PID.Turret.F,
                Component.flywheelEncoder);
        PositionSensorMotor flywheelPSM = new  PositionSensorMotor("Flywheel", Component.flywheelPID, Component.flywheelMotor);
        Component.flywheel = new Flywheel(flywheelPSM, Component.flywheelEncoder); // flywheel subsystem

    }
}
