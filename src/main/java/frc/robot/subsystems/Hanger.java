// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hanger extends SubsystemBase {

  public Talon leftMotor;
  public Talon rightMotor;

  /** Creates a new Hanger. */
  public Hanger() {
    leftMotor = new Talon(Constants.liftMotorLeft);
    rightMotor = new Talon(Constants.liftMotorRight);
  }

  public void lift(boolean up){
    if(up){
      leftMotor.set(.5);
      rightMotor.set(.5);
    }
    else{
      leftMotor.set(-1);
      rightMotor.set(-1);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
