package frc.robot;

import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.DriverControllerConstants;
import frc.robot.Constants.OperatorControllerConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.SwerveSubsytem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SwerveSubsytem swerveSubsytem = new SwerveSubsytem();
  private final Joystick driveController = new Joystick(DriverControllerConstants.kDriverControllerPort);
  private final XboxController m_OperatorController = new XboxController(OperatorControllerConstants.kOperatorControllerPort);

  public RobotContainer() {
    // set the swerveJoystickCmd to be the default command for the swerve chassis
    swerveSubsytem.setDefaultCommand(new SwerveJoystickCmd(swerveSubsytem,
    () -> driveController.getRawAxis(DriverControllerConstants.kDriverXAxis), // axis 0
    () -> driveController.getRawAxis(DriverControllerConstants.kDriverYAxis), // axis 1
    () -> driveController.getRawAxis(DriverControllerConstants.kDriverRotAxis), // axis 4
    () -> !driveController.getRawButton(DriverControllerConstants.kDriverFieldOrientedButtonIdx))); // By default the robot will operate in the fields reference frame
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(driveController, 2).onTrue(new InstantCommand(() -> swerveSubsytem.zeroHeading())); // use this button to reset the direction of the field's refernce frame

  }


  public Command getAutonomousCommand() {
    return null;
  }
}
