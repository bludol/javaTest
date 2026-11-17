package cz.vsb.fei.manufacture;


import java.util.List;

public enum Operation {
    CUTTING("Řezání", 2),
    SANDING("Broušení", 20),
    PAINTING("Natírání", 30),
    DRILLING("Vrtání", 5);

    private final String name;
    private final int duration;


    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    Operation(String operation, int duration) {
        this.name = operation;
        this.duration = duration;
    }
}
