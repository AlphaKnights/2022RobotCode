package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class autoConstants{
        public static final int numOfCalls = 100;
    }

    public static class DriveTrainConstants{
        public static final int rightFrontFalconID = 1;
        public static final int rightBackFalconID = 4;
        public static final int leftFrontFalconID = 2; 
        public static final int leftBackFalconID = 3;

        //Logitech Controller - Ryan
        // public static final int forward_axis = 1;
        // public static final int side_axis = 0;
        // public static final int rotation_axis = 4;
        public static final int forward_axis = 1;
        public static final int side_axis = 4;
        public static final int rotation_axis = 0;
    }

    public static class AccelCurve{
        public static final int x = 0;
        public static final double sensitive = 0;
        public static final double exponent = 3;
        public static final double startPoint = 50;
        public static final double m = Math.pow(startPoint, (1/exponent))/startPoint;
        public static final double sub_amount = m*startPoint;
        public static final double add_amount = startPoint;
        // example of curve, this is actually implemented in the subsystem/command
        // public static final double accelCurve = (Math.pow((m*x-sub_amount), exponent)+add_amount); 
    }

    public static class ClimbingConstants{
        public static final int climbMotor = 12;
        public static final int armRotationMotor = 14;
        public static final int armElevationMotorLeft = 15;
        public static final int armElevationMotorRight = 16;
        public static final double armRotationSensitivity = 1;
        public static final double armHeightSensitivity = .75;
        public static final double climbSensitivity = 1;
        public static final double climbReleaseSensitivity = .75;
    }

    public static class OI_Constants{
        public static final int m_joystickID = 0;//Logitech Controller
        public static final int c_joystickID = 1;//Flight Joystick Climb
        public static final int i_joystickID = 2;//Flight Joystick Intake
    }

    public static class IntakeConstants{
        public static final int intakeMotorID = 7;
        public static final int intakeHeadMotorID = 6;
        public static final int intakeRotationMotorID = 10;
        public static final int maxRevolutions = 48;
        public static int location = 0;
    }
}

/** 
 *         Motor Name                                      ID
 * 
 * Front Right Drivetrain motor:                            1
 * Front Left Drivetrain motor:                             3
 * Back Right Drivetrain motor:                             2
 * Back Left Drivetrain motor:                              4
 * 
 * Altiude Climb Motor:                                     ???
 * Climb Tower Height Motor:                                14 & 20
 * 
 * Intake Motor:                                            6
 * Intake Leg Motor:                                        9
 * Intake Head Motor:                                       10
 * 
*/

/**
 *                  Button Mapping
 *       Button Use / Name                              Button ID
 * TBD                                                      0
 * TBD                                                      1
 * TBD                                                      2
 * TBD                                                      3
 * TBD                                                      4
 * TBD                                                      5
 * TBD                                                      6
 * TBD                                                      7
 * TBD                                                      8
 * TBD                                                      9
 * TBD                                                     10
 * TBD                                                     11
 * TBD                                                     12
 * 
 * 
 *                  Joystick Axis Uses
 *                       Logitech
 * Drive Forward                                            1  -  Left Joystick - Y
 * Drive Sideways                                           2  -  Left Joystick - X
 * Rotate                                                   3  -  Right Joystick - X
 * TBD                                                      4  -  Right Joystick - Y
 * TBD                                                      5  -  DPad - X
 * TBD                                                      6  -  DPad - Y
 * 
 *                   Flight Controller
 * TBD                                                      1  -  X Axis
 * TBD                                                      2  -  Y Axis
 * TBD                                                      3  -  Twist
 * TBD                                                      4  -  Power Slider
 * TBD                                                      5  -  Hat - X
 * TBD                                                      6  -  Hat - Y
 * 
 */