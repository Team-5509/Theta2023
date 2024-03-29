// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final static double TICKSPERFOOT = 128 / (6.1 * Math.PI); // Math.PI/2 is wheel circumference(ft)
    // 128 ticks per PI/2 feet w/o reductions
    // 128/(6.1*Pi) ticks per 1 foot w/ low gear reductions
    private final static double FEETPERTICK = 1 / TICKSPERFOOT;
    private CANSparkMax firstLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax firstRightMotor = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax secondLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax secondRightMotor = new CANSparkMax(4, MotorType.kBrushless);
    private DifferentialDrive firstDifferentialDrive;
    private DifferentialDrive secondDifferentialDrive;

    /**
    *
    */
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        ResetEncoders();
        firstRightMotor.setInverted(true);
        secondRightMotor.setInverted(true);
        firstLeftMotor.setInverted(false);
        secondLeftMotor.setInverted(false);
        firstDifferentialDrive = new DifferentialDrive(firstLeftMotor, firstRightMotor);
        secondDifferentialDrive = new DifferentialDrive(secondLeftMotor, secondRightMotor);

        firstLeftMotor.setIdleMode(IdleMode.kCoast);
        secondLeftMotor.setIdleMode(IdleMode.kCoast);
        firstRightMotor.setIdleMode(IdleMode.kCoast);
        secondRightMotor.setIdleMode(IdleMode.kCoast);
    }

    public void ResetEncoders() {
        firstLeftMotor.getEncoder().setPosition(0);
        secondLeftMotor.getEncoder().setPosition(0);
        firstRightMotor.getEncoder().setPosition(0);
        secondRightMotor.getEncoder().setPosition(0);
    }

    @Override
    public void periodic() {
        double FLTicks = firstLeftMotor.getEncoder().getPosition();
        SmartDashboard.putNumber("FLTicks", FLTicks);
        // This method will be called once per scheduler run

        SmartDashboard.putNumber("id 1", firstLeftMotor.getBusVoltage());
        SmartDashboard.putNumber("id 2", secondLeftMotor.getBusVoltage());
        SmartDashboard.putNumber("id 3", firstRightMotor.getBusVoltage());
        SmartDashboard.putNumber("id 4", secondRightMotor.getBusVoltage());

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void driveTank(double leftSpeed, double rightSpeed) {
        firstDifferentialDrive.tankDrive(leftSpeed, rightSpeed);
        secondDifferentialDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public void driveArcade(double leftSpeed, double rotationSpeed) {
        firstDifferentialDrive.arcadeDrive(leftSpeed, rotationSpeed);
        secondDifferentialDrive.arcadeDrive(leftSpeed, rotationSpeed);
    }

    public void stop() {
        firstDifferentialDrive.tankDrive(0, 0);
        secondDifferentialDrive.tankDrive(0, 0);
    }

    public double distanceTraveledInFeet() {
        return firstLeftMotor.getEncoder().getPosition() * FEETPERTICK;
    }
}
