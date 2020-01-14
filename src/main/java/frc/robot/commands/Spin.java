/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Spin extends CommandBase {
  /**
   * Creates a new Spin.
   */
  public Timer time;
  public Spin() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_spin);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if(time.get() < 0.25)
    { 
       Robot.m_spin.runMotor(0.25);
    }
    else
    {
      Robot.m_spin.runMotor(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(interrupted)
    {
      Robot.m_spin.runMotor(0);
    }

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}