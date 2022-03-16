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
    
    public static double AccelCurve(double x) {
        // uses radians
        return (Math.abs(x) * (Math.sin(3.0 * Math.sqrt(Math.abs(7.0 * x))) + (2.0 * Math.abs(7.0 * x)))) / (15 * x);
    }
    
    public static class DriveTrainConstants{
        public static final int rightFrontFalconID = 0; 
        public static final int rightBackFalconID = 1;
        public static final int leftFrontFalconID = 2; 
        public static final int leftBackFalconID = 3;
    }
}
