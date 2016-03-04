package Functions;

public class LookingForMax {

    static double f(double x) {
        if ( x < 0.8 && x> 0.75) {
            return 10. - (x-1)*(x-1);
        } else {
            return 0;
        }

    }

    static double lookingForMax(double x1, double x2, final double epsilon) {
        while (Math.abs(x2 - x1) > epsilon) {
            double medianValue = f(( x1 + x2 )/2);
            if ( f(x1) == medianValue && f(x2) == medianValue ) {
                return Math.max(lookingForMax(x1, (x1+x2)/2, epsilon), lookingForMax((x1+x2)/2, x2, epsilon));
            }
            if ( f(x1) < medianValue ) {
                x1 = ( x1 + x2 ) / 2;
            } else {
                x2 = ( x1 + x2 ) / 2;
            }
        }

        return f(x1);
    }


    public static void main(String[] args) {
        double a = LookingForMax.lookingForMax(-1., 1., 0.01);
        System.out.println(a);
    }

}
