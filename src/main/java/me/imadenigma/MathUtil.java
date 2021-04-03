package me.imadenigma;

import java.awt.*;

public class MathUtil {

    public static double pointsToDeg(final Point centerPt, final Point targetPt) {

        final double theta = Math.atan2(
                targetPt.x - centerPt.x,
                targetPt.y - centerPt.y
        ) - Math.PI / 2.0 ;
        double angle = Math.toDegrees(theta);

        if (angle < 0) angle += 360;

        return angle;
    }

    public static double[] angleToCoor(final double angle, final double radius) {
        double x = 300 +  radius * Math.cos(angle);
        double y = 300 - radius * Math.sin(angle);
        return new double[] {x,y};
    }

}
