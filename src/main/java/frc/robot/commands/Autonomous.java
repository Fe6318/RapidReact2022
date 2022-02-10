// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Autonomous extends CommandBase {
  private Intake intake;
  private Shooter shooter;
  private DriveTrain drive;
  private Timer timer;

  /** Creates a new AutoShoot. */
  public Autonomous(Intake intake, Shooter shooter, DriveTrain drive) {

    this.intake = intake;
    this.shooter = shooter;
    this.drive = drive;
    timer = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.shootBall(1);
    timer.delay(2);
    intake.runIntake(.5);
    timer.delay(2);
    shooter.shootBall(0);
    intake.runIntake(0);
    drive.drive(-.25, 0, 0);
    timer.delay(4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    shooter.shootBall(0);
    intake.runIntake(0);
    drive.drive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() > 2){
      return true;
    }
    else return false;
  }
}
