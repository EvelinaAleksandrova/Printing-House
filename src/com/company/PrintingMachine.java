package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrintingMachine implements Serializable {
    private String name;
    private TypeOfColorPrinting typeOfColorPrinting;
    private Edition edition;
    private List<Edition> editionList;

    private int numberOfMaxPaperInsert;
    private int numberOfPaperPerMinute;

    public PrintingMachine(String name, TypeOfColorPrinting typeOfColorPrinting, int numberOfPaperPerMinute) {
        this.name = name;
        this.typeOfColorPrinting = typeOfColorPrinting;
        this.numberOfPaperPerMinute = numberOfPaperPerMinute;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMaxPaperInsert() {
        return numberOfMaxPaperInsert;
    }

    public void maxNumberOfPaperInsert(int numberOfMaxPaperInsert) throws PaperNotEnoughException {
        if (numberOfMaxPaperInsert != 2000) {
            throw new PaperNotEnoughException("You must insert maximum 2000 paper in printing machine!");
        } else if (numberOfMaxPaperInsert == 2000) {
            this.numberOfMaxPaperInsert = numberOfMaxPaperInsert;
        }
    }

}
