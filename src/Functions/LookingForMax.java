package Functions;

import Functions.Interval;

public class LookingForMax {

    static double f(double x) {
        double moveRight = 0.7888;
        double delta = 0.0001;
        double valueToReturn = 2;

        if ( x> moveRight && x < moveRight + delta) {
            return valueToReturn;
        }

        if ( x > moveRight - delta && x <= moveRight ) {
            return valueToReturn - (x-moveRight)*(x-moveRight);
        }

        if ( x > 0.75 && x < 0.8 ) {
            return  valueToReturn / 2 - (x-moveRight)*(x-moveRight) ;
        }

        return 0;

    }

    static double lookingForMaxRecursively(Interval interval, final double epsilon) {
        while (interval.length() > epsilon) {
            double x1 = interval.getX1();
            double x2 = interval.getX2();
            double medium_x = interval.medium_x();
            double f_x1 = f( x1 );
            double f_x2 = f( x2 );
            double f_x_medium = f( interval.medium_x() );

            if ( f_x1 == f_x_medium && f_x2 == f_x_medium  || f_x1 == f_x2) {
                return Math.max( lookingForMaxRecursively(new Interval(x1, medium_x), epsilon),
                        lookingForMaxRecursively(new Interval(medium_x, x2), epsilon));
            }
            if ( f_x1 < f_x2 ) {
                interval.setX1(medium_x);
            } else {
                interval.setX2( medium_x);
            }
        }

        return f(interval.getX1());
    }

    static boolean isIncludeLocalMax(Interval interval) {
        return f(interval.getX1()) < f(interval.medium_x()) && f(interval.getX2()) < f(interval.medium_x());
    }

    static Interval localizeMax(Interval interval, final double epsilon) {
        boolean isNeedToGoDeeper = true;
        int divideToParts = 2;
        while (isNeedToGoDeeper) {
            double step = interval.length() / divideToParts;

            for (int i = 0; i < divideToParts-1; i++ ) {
                Interval currentInterval = new Interval(interval.getX1() + i* step, interval.getX1() + (i+1)*step);
                if ( isIncludeLocalMax( currentInterval )){
                    return currentInterval;
                }
            }
            if (step < epsilon) {
                isNeedToGoDeeper = false;
            } else {
                divideToParts *= 2;
            }
        }
        return interval;
    }


    static double lookingForMax(Interval interval, double epsilon) {
        Interval intervalWithMax = localizeMax(interval, epsilon);
        return lookingForMaxRecursively(intervalWithMax, epsilon);
    }


    public static void main(String[] args) {
        Interval interval = new Interval(-1.,1.);
        System.out.println(lookingForMax(interval, 0.000001));
    }

}
