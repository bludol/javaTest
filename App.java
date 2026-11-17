package cz.vsb.fei;

import cz.vsb.fei.batteries.AppBattery;
import cz.vsb.fei.geom3d.AppGeom3D;
import cz.vsb.fei.manufacture.AppManufacture;

public class App {

    public static void main(String[] args) {
        AppBattery.mainApp(args);
        AppManufacture.mainApp(args);
        AppGeom3D.mainApp(args);

    }

}