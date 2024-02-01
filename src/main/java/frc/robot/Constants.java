package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public final class Constants {


  public static class ModuleConstants{
    //TODO: Check these values with the mechanical team first

    private static final double kWheelDiameterMeters = Units.inchesToMeters(4);
    private static final double kDriveMotorGearRatio = 1/8.14;
    private static final double kTurningMotorGearRatio = 1/12.8;
    public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
    public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
    public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
    public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;
    public static final double kPTurning = 0.5;

  }

  public static final class Sensors{
    public static final int EncoderPort = 1;
    public static final int GyroPort = 2;
    public static final int BeamBreakerPort = 3;
  }

  public static final class DriveConstants{
    //Distance between right and left wheels
    public static final double kTrackWidth = Units.inchesToMeters(21);
    //Distance between front and back wheels
    public static final double kWheelBase = Units.inchesToMeters(25.5);

    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
      new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
      new Translation2d(kWheelBase / 2, kTrackWidth / 2),
      new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
      new Translation2d(-kWheelBase / 2, kTrackWidth / 2)
    );

    // Driving motors ports
    public static final int kFrontLeftDriveMotorPort = 41;
    public static final int kBackLeftDriveMotorPort = 31;
    public static final int kFrontRightDriveMotorPort = 11;
    public static final int kBackRightDriveMotorPort = 21;
    
    // Turning motors ports
    public static final int kFrontLeftTurningMotorPort = 42;
    public static final int kBackLeftTurningMotorPort = 32;
    public static final int kFrontRightTurningMotorPort = 12;
    public static final int kBackRightTurningMotorPort = 22;

    // Reversed Turning Encoders booleans
    public static final boolean kFrontLeftTurningEncoderReversed = true;
    public static final boolean kBackLeftTurningEncoderReversed = true;
    public static final boolean kFrontRightTurningEncoderReversed = true;
    public static final boolean kBackRightTurningEncoderReversed = true;


    // Reversed Driving Encoders booleans
    public static final boolean kFrontLeftDriveEncoderReversed = true;
    public static final boolean kBackLeftDriveEncoderReversed = true;
    public static final boolean kFrontRightDriveEncoderReversed = false;
    public static final boolean kBackRightDriveEncoderReversed = false;



    // Absloute Encoders ports
    public static final int kFrontLeftDriveAbsoluteEncoderPort = 400;
    public static final int kBackLeftDriveAbsoluteEncoderPort = 30;
    public static final int kFrontRightDriveAbsoluteEncoderPort = 10;
    public static final int kBackRightDriveAbsoluteEncoderPort = 20;

    // Absloute Drive Encoder booleans
    public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = false;
    public static final boolean kBackLeftDriveAbsoluteEncoderReversed = false;
    public static final boolean kFrontRightDriveAbsoluteEncoderReversed = false;
    public static final boolean kBackRightDriveAbsoluteEncoderReversed = false;

    // Absolute Encoder Offset Radians
    public static final double kFrontLeftDriveAbsoluteEncoderOffsetRad = -0.254;
    public static final double kBackLeftDriveAbsoluteEncoderOffsetRad = -1.252;
    public static final double kFrontRightDriveAbsoluteEncoderOffsetRad = -1.816;
    public static final double kBackRightDriveAbsoluteEncoderOffsetRad = -4.811;

    // physical max speed
    public static final double kPhysicalMaxSpeedMetersPerSecond = 5;
    public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

    // SlewRateLimiter Related 
    public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 4;
    public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = //
            kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
    public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3;
    public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = DriveConstants.kPhysicalMaxSpeedMetersPerSecond / 4;
    public static final double kMaxAngularSpeedRadiansPerSecond = //
            DriveConstants.kPhysicalMaxAngularSpeedRadiansPerSecond / 10;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularAccelerationRadiansPerSecondSquared = Math.PI / 4;
    public static final double kPXController = 1.5;
    public static final double kPYController = 1.5;
    public static final double kPThetaController = 3;

    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = //
            new TrapezoidProfile.Constraints(
                    kMaxAngularSpeedRadiansPerSecond,
                    kMaxAngularAccelerationRadiansPerSecondSquared);
}

  public static class DriverControllerConstants {
    public static final int kDriverControllerPort = 0;

    public static final int kDriverYAxis = 1;
    public static final int kDriverXAxis = 0;
    public static final int kDriverRotAxis = 4;
    public static final int kDriverFieldOrientedButtonIdx = 1;

    public static final double kDeadband = 0.05;
  }

  public static class OperatorControllerConstants{
    public static final int kOperatorControllerPort = 1;

    public static final int kOperatorYAxis = 1;
    public static final int kOperatorXAxis = 0;  
  }
}
