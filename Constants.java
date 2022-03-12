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
    public static class DriveTrainConstants{
        public static final int rightFrontFalconID = 1; 
        public static final int rightBackFalconID = 2;
        public static final int leftFrontFalconID = 3; 
        public static final int leftBackFalconID = 4;
        //When using normal Joysticks
        // public static final int x_axis = 0;
        // public static final int y_axis = 1;

        //Logitech Controller
        public static final int forward_axis = 0;
        public static final int side_axis = 1;
        public static final int rotation_axis = 4;
    }

    public static class AccelCurve{
        public static final int x = 0;
        public static final double exponent = 3;
        public static final double startPoint = 50;
        public static final double m = Math.pow(startPoint, (1/exponent))/startPoint;
        public static final double sub_amount = m*startPoint;
        public static final double add_amount = startPoint;
        //example of curve, this is actually implemented in the subsystem/command
        // public static final double accelCurve = (Math.pow((m*x-sub_amount), exponent)+add_amount); 
    }

    public static class ClimbingConstants{

        public static final int armRotationMotor;
        public static final int armElevationMotor;
        public static final int x_axis = 5;
        public static final int y_axis = 6;

        public static final double armRotationSensitivity = 1;
        public static final double armHeightSensitivity = 1;

        public static final int rotationRange = 696420;
        public static final int altitudeRange = 69429;
    }

    public static class OI_Constants{
        public static final int m_joystickID = 0;//Logitech Controller
        public static final int c_joystickID = 1;//Flight Joystick
        
        public static final int driveJoystickButtonID = 3;
    }
}

/** 
 *         Motor Name                                      ID
 * 
 * Front Right Drivetrain motor:                            0
 * Front Left Drivetrain motor:                             2
 * Back Right Drivetrain motor:                             1
 * Back Left Drivetrain motor:                              3
 * 
 * Altiude Climb Motor:                                     4
 * Climb Tower Height Motor:                                5
 * 
 * Intake Motor:                                            6
 * Intake Leg Motor:                                        7
 * Intake Head Motor:                                       8
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