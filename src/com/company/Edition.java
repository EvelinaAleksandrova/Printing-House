package com.company;

import java.io.Serializable;

public class Edition implements Serializable {

    private String nameOfEdition;
    private int numberOfPages;
    private TypeOfEdition typeOfEdition;
    private TypeOfSizeOfPages typeOfSizeOfPages;
    private TypeOfPaper typeOfPaper;

    public Edition() {
    }

    public Edition(String nameOfEdition,
                   int numberOfPages,
                   TypeOfEdition typeOfEdition,
                   TypeOfSizeOfPages typeOfSizeOfPages,
                   TypeOfPaper typeOfPaper
    ) {
        this.nameOfEdition = nameOfEdition;
        this.numberOfPages = numberOfPages;
        this.typeOfEdition = typeOfEdition;
        this.typeOfSizeOfPages = typeOfSizeOfPages;
        this.typeOfPaper = typeOfPaper;

    }

    public String getNameOfEdition() {
        return nameOfEdition;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public TypeOfEdition getTypeOfEdition() {
        return typeOfEdition;
    }

    public TypeOfSizeOfPages getTypeOfSizeOfPages() {
        return typeOfSizeOfPages;
    }

    public TypeOfPaper getTypeOfPaper() {
        return typeOfPaper;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "nameOfEdition='" + nameOfEdition + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", typeOfEdition=" + typeOfEdition +
                ", typeOfSizeOfPages=" + typeOfSizeOfPages +
                ", typeOfPaper=" + typeOfPaper +
                '}';
    }
}
