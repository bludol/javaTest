package cz.vsb.fei.geom3d;

public class Sphere implements Body3D{
    private double r;

    @Override
    public double getVolume() {
        return 4.0/3.0*Math.PI*r*r*r;
    }

    public Sphere(double r) {
        this.r = r;
    }
}
