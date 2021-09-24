package com.company;

public enum TypeOfSizeOfPages {
    A1(0.11),
    A2(0.06),
    A3(0.05),
    A4(0.07),
    A5(0.06);

    double priceForSizeOfPages;

    TypeOfSizeOfPages(double priceForSizeOfPages) {
        this.priceForSizeOfPages = priceForSizeOfPages;
    }

    public double getPriceForSizeOfPages() {
        return priceForSizeOfPages;
    }

    public void setPriceForSizeOfPages(double price) {
        this.priceForSizeOfPages = price;
    }
}
