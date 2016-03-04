package Functions;

public class Interval {
    private double x1;
    private double x2;

    public Interval(double x1, double x2) {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1,x2);
    }

    public double length() {
        return Math.abs(x2 - x1);
    }

    public double medium_x() {
        return (x1+x2)/2;
    }

    public double getX2() {
        return x2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public String toString() {
        return "x1 = " + x1 + ", x2 = " + x2 + "\n";
    }

    public boolean isPointInside(double x) {
        return x > x1 && x < x2;
    }
}
