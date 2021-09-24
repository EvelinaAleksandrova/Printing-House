package com.company;

public enum TypeOfPaper {
    PLAIN_PAPER(0.02),
    GLOSSY_PAPER(0.50),
    NEWSPAPER_PAPER(0.06);

    double priceForPaperType;

    TypeOfPaper(double priceForPaperType) {
        this.priceForPaperType = priceForPaperType;
    }

    public void setPriceForPaperType(double priceForPaperType) {
        this.priceForPaperType = priceForPaperType;
    }

    public double getPriceForPaperType() {
        return priceForPaperType;
    }

}
