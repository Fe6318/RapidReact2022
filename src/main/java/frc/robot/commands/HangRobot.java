// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hanger;

public class HangRobot extends CommandBase {

  public Hanger hanger;
  public boolean up;

  /** Creates a new HangRobot. */
  public HangRobot(Hanger hanger, boolean up) {
    this.hanger = hanger;
    this.up = up;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hanger);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hanger.lift(up, false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hanger.lift(up, true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}