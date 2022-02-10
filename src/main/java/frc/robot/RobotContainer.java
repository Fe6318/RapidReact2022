// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.HangRobot;
import frc.robot.commands.RunIntake;
import frc.robot.commands.ShootBall;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hanger;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private static Joystick driver;
  private static Joystick operator;

  private static JoystickButton shoot2ptButton;
  private static JoystickButton shoot1ptButton;
  private static JoystickButton intakeUpButton;
  private static JoystickButton intakeDownButton;
  private static JoystickButton hangerUpButton;
  private static JoystickButton hangerDownButton;
  
  private final DriveTrain driveTrain;
  private final DefaultDrive defaultDrive;

  private final Intake intake;

  private final Shooter shooter;

  private final Hanger hanger;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driver = new Joystick(0);
    operator = new Joystick(1);

    shoot2ptButton = new JoystickButton(operator, Constants.shoot2ptButton);
    shoot1ptButton = new JoystickButton(operator, Constants.shoot1ptButton);
    intakeUpButton = new JoystickButton(operator, Constants.intakeUpButton);
    intakeDownButton = new JoystickButton(operator, Constants.intakeDownButton);
    hangerUpButton = new JoystickButton(operator, Constants.hangerUpButton);
    hangerDownButton = new JoystickButton(operator, Constants.hangerDownButton);

    driveTrain = new DriveTrain();
    defaultDrive = new DefaultDrive(driveTrain, driver);
    driveTrain.setDefaultCommand(defaultDrive);

    intake = new Intake();

    shooter = new Shooter();

    hanger = new Hanger();

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    shoot2ptButton.whenHeld(new ShootBall(shooter, 1));
    shoot1ptButton.whenHeld(new ShootBall(shooter, .5));

    intakeUpButton.whenHeld(new RunIntake(intake, .5));
    intakeDownButton.whenHeld(new RunIntake(intake, -.5));
    
    hangerUpButton.whenHeld(new HangRobot(hanger, true));
    hangerDownButton.whenHeld(new HangRobot(hanger, false));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }


}
