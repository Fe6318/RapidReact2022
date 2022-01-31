// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private PWMVictorSPX frontLeftMotor;
  private PWMVictorSPX backLeftMotor;
  private PWMVictorSPX frontRightMotor;
  private PWMVictorSPX backRightMotor;

  private MotorControllerGroup left;
  private MotorControllerGroup right;

  private DifferentialDrive drive;

  public DriveTrain() {
    frontLeftMotor = new PWMVictorSPX(Constants.frontLeftMotor);
    backLeftMotor = new PWMVictorSPX(Constants.backLeftMotor);
    frontRightMotor = new PWMVictorSPX(Constants.frontRightMotor);
    backRightMotor = new PWMVictorSPX(Constants.backRightMotor);

    left = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    right = new MotorControllerGroup(frontRightMotor, backRightMotor);

    drive = new DifferentialDrive(left, right);
  }

  public void drive(double x, double x2, double z){
    /*if(x == 0 && x2 > 0){
      drive.arcadeDrive(-x2, z);
    }
    else{
      drive.arcadeDrive(x, z);
    }*/
    drive.arcadeDrive(x - x2, z);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
