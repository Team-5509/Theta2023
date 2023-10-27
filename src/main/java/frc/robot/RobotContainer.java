// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.autons.Drive;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot
 * (including subsystems, commands, and button mappings) should be declared
 * here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  // The robot's subsystems
  public final GearShift m_gearShift = new GearShift();
  public final AirCompressor m_airCompressor = new AirCompressor();
  public final PnuematicClaw m_pnuematicClaw = new PnuematicClaw();
  public final Limelight m_limelight = new Limelight();
  public final ArmExtension m_armExtension = new ArmExtension();
  public final NavX m_navX = new NavX();
  public final FourBar m_fourBar = new FourBar();
  public final ClawWrist m_clawWrist = new ClawWrist();
  public final DriveTrain m_driveTrain = new DriveTrain();

  // Joysticks
  private final XboxController auxController = new XboxController(1);
  private final XboxController driverController = new XboxController(0);

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  private RobotContainer() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems

    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("DisplayInRange", new DisplayInRange(m_limelight));
    SmartDashboard.putData("HaloDrive", new HaloDrive(m_driveTrain));
    SmartDashboard.putData("CompressorOn", new CompressorOn(m_airCompressor));
    SmartDashboard.putData("DriveXFeet: Six", new DriveXFeet(6, m_driveTrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_gearShift.setDefaultCommand(new ShiftGear(false, m_gearShift));
    m_airCompressor.setDefaultCommand(new CompressorOn(m_airCompressor));
    m_pnuematicClaw.setDefaultCommand(new RunClaw(false, m_pnuematicClaw));
    m_armExtension.setDefaultCommand(new RunExtension(m_armExtension));
    m_fourBar.setDefaultCommand(new RunFourBar(m_fourBar));
    m_clawWrist.setDefaultCommand(new FlipWrist(m_clawWrist));
    m_driveTrain.setDefaultCommand(new HaloDrive(m_driveTrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("DriveXFeet", new DriveXFeet(0, m_driveTrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    m_chooser.addOption("Drive", new Drive(m_driveTrain));

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    // Create some buttons
    final JoystickButton buttonOpenClaw = new JoystickButton(auxController, XboxController.Button.kB.value);
    buttonOpenClaw
        .toggleOnTrue(new RunClaw(false, m_pnuematicClaw).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("ButtonOpenClaw", new RunClaw(false, m_pnuematicClaw));

    final JoystickButton buttonSiftGear = new JoystickButton(driverController, XboxController.Button.kLeftBumper.value);
    buttonSiftGear
        .toggleOnTrue(new ShiftGear(false, m_gearShift).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("ButtonSiftGear", new ShiftGear(false, m_gearShift));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public XboxController getdriverController() {
    return driverController;
  }

  public XboxController getauxController() {
    return auxController;
  }

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }

}
