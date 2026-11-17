package cz.vsb.fei.manufacture;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManufacturingProcess {
    private String productName;
    private List<Operation> operations;

    public ManufacturingProcess(String producetName, Operation... operations) {
        this.productName = producetName;
        this.operations = new ArrayList<>(Arrays.asList(operations));

    }

    @Override
    public String toString() {
        return "ManufacturingProcess{" +
                "producetName='" + productName + '\'' +
                ", operations=" + operations +
                '}';
    }
}
