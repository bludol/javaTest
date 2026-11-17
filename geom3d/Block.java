package cz.vsb.fei.geom3d;

public class Block implements BodyWithBase{

    private double width;
    private double depth;
    private double height;

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getSurfaceOfBase() {
        return width*depth;
    }

    public Block(double width,double depth, double height) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
