// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

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
        public static final int rightFrontFalconID = 0; 
        public static final int rightBackFalconID = 1;
        public static final int leftFrontFalconID = 2; 
        public static final int leftBackFalconID = 3;
        
        //When using normal Joysticks
        // public static final int x_axis = 0;
        // public static final int y_axis = 1;

        //Logitech Controller
        public static final int forward_axis = 0;
        public static final int side_axis = 1;
        public static final int rotation_axis = 2;

        //Curve Function
        


    }

    public static class AccCurve{
        public static final int x = 0;
        public static final double exponent = 3;
        public static final double startPoint = 50;
        public static final double m = Math.pow(startPoint, (1/exponent))/startPoint;
        public static final double sub_amount = m*startPoint;
        public static final double add_amount = startPoint;
        
        //example of curve, this is actually implemented in the subsystem/command
        // public static final double accelCurve = (Math.pow((m*x-sub_amount), exponent)+add_amount); 
    }

    public static class OI_Constants{
        public static final int m_joystickID = 0;
        public static final int driveJoystickButtonID = 3;
    }
}
