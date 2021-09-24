package com.company;

public class ThreadPrintingMachine implements Runnable {
    private final PrintingMachine printingMachine;
    private final Company company;

    public ThreadPrintingMachine(PrintingMachine printingMachine, Company company) {
        this.printingMachine = printingMachine;
        this.company = company;
    }

    @Override
    public void run() {
        company.printing();
        if (company.printing() >= 0) {
        }
    }
}
