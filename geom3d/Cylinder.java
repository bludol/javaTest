package cz.vsb.fei.geom3d;

public class Cylinder implements BodyWithBase{
    private double r;
    private double height;


    public Cylinder(double r, double height) {
        this.r = r;
        this.height = height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getSurfaceOfBase() {
        return Math.PI*r*r;
    }
}
