package Functions;

public class LookingForMax {

    static double f(double x) {
        return 10. - x*x;
    }

    static double lookingForMax(double x1, double x2, final double epsilon) {
        while (Math.abs(x2 - x1) > epsilon) {
            double medianValue = f(( x1 + x2 )/2);
            if ( f(x1) < medianValue ) {
                x1 = ( x1 + x2 ) / 2;
            } else {
                x2 = ( x1 + x2 ) / 2;
            }
        }

        return f(x1);
    }


    public static void main(String[] args) {
        double a = LookingForMax.lookingForMax(-10., -1., 0.01);
        System.out.println(a);
    }

}
