package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {
    private static double salaryForEmployee;
    private static double bonusPercentForManager;
    private final List<PrintingMachine> printingMachinesList;
    private final String nameOfCompany;
    private final double moneyLimit;
    private final int numberOfEditionBuy;
    private final double discountPercentForPrinting;
    private final int printingLimit;
    private final List<Employee> employeeList;
    private final List<Edition> editionList;
    private int numberOfEditionsToPrint;

    public Company(String nameOfCompany,
                   List<Employee> employeeList,
                   double salaryForEmployees,
                   double bonusPercentsForManager,
                   double moneyLimit,
                   int numberOfEditionBuy,
                   List<Edition> editionList, int printingLimit,
                   double discountPercentForPrinting) {
        salaryForEmployee = salaryForEmployees;
        this.nameOfCompany = nameOfCompany;
        bonusPercentForManager = bonusPercentsForManager;
        this.moneyLimit = moneyLimit;
        this.numberOfEditionBuy = numberOfEditionBuy;
        this.printingLimit = printingLimit;
        this.discountPercentForPrinting = discountPercentForPrinting;
        this.employeeList = employeeList;
        this.editionList = editionList;
        this.printingMachinesList = new ArrayList<>();
        numberOfEditionsToPrint = editionList.size() * getNumberOfEditionBuy();
    }

    public int getNumberOfEditionsToPrint() {
        return numberOfEditionsToPrint;
    }

    public int getNumberOfEditionBuy() {
        return this.numberOfEditionBuy;
    }

    public void addPrintingMachinesToList(PrintingMachine printingMachine) {
        this.printingMachinesList.add(printingMachine);
    }

    public void startPrintingMachines() {
        for (PrintingMachine printingMachine : this.printingMachinesList) {
            Thread thread = new Thread(new ThreadPrintingMachine(printingMachine, this));
            thread.start();
        }
    }

    public synchronized int printing() {
        for (Edition edition : editionList) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.numberOfEditionsToPrint >= 1) {

                System.out.println("Current number of edition to print = " + this.getNumberOfEditionsToPrint());

                this.numberOfEditionsToPrint -= 1;

                System.out.println(Thread.currentThread().getName() + " print edition - "
                        + edition.getNameOfEdition() + " print " + edition.getNumberOfPages() + " pages!");

                System.out.println("Editions left " + this.getNumberOfEditionsToPrint());
                System.out.println("=========================================================================================================");
            }

        }
        return this.numberOfEditionsToPrint;
    }


    public double expenseForPaper() {

        return printingMachinesList.size() * (2000 * 0.02);
    }

    public void printIncomeFromOneEdition() {
        System.out.println("--------------------Price For One Edition--------------------");
        for (Edition edition : editionList) {
            final double priceForOnePaper = edition.getTypeOfPaper().getPriceForPaperType() + edition.getTypeOfSizeOfPages().getPriceForSizeOfPages();
            final double priceForOneEdition = priceForOnePaper * edition.getNumberOfPages();

            System.out.printf("Name of edition - %s and price is %.2f lv. \n", edition.getNameOfEdition(), priceForOneEdition);
        }
    }

    public double incomeFromAllEditions() {
        double price = 0.0;
        for (Edition edition : editionList) {
            double priceForOnePaper = 0.0;
            double priceForOneEdition = 0.0;

            priceForOnePaper = edition.getTypeOfPaper().getPriceForPaperType() + edition.getTypeOfSizeOfPages().getPriceForSizeOfPages();
            priceForOneEdition = priceForOnePaper * edition.getNumberOfPages();
            priceForOneEdition = priceForOneEdition * getNumberOfEditionBuy();
            price = price + priceForOneEdition;
        }

        double discount = 0.0;
        if (this.numberOfEditionsToPrint >= this.printingLimit) {
            double percent = this.discountPercentForPrinting / 100;
            double sumForAllEditions = price;
            discount = (sumForAllEditions * percent);
        }

        price = price - discount;
        price = Math.round(price * 100.0) / 100.0;
        return price;
    }

    public double expensesForSalariesForEmployees() {
        double expensesForSalariesForEmployees = 0.0;
        for (Employee employee : employeeList) {
            double bonusForManager = 0.0;
            if (incomeFromAllEditions() > this.moneyLimit) {
                if (employee.getTypeOfEmployee() == (TypeOfEmployee.MANAGER)) {
                    bonusForManager = (salaryForEmployee * bonusPercentForManager) / 100;
                }
            }
            expensesForSalariesForEmployees = expensesForSalariesForEmployees + salaryForEmployee + bonusForManager;
        }
        expensesForSalariesForEmployees = Math.round(expensesForSalariesForEmployees * 100.0) / 100.0;
        return expensesForSalariesForEmployees;
    }

    public double ExpensesForPaperAndEmployees() {
        double price = expenseForPaper() + expensesForSalariesForEmployees();
        return price;
    }

    @Override
    public String toString() {
        return "Company{" +
                "nameOfCompany = '" + nameOfCompany + '\'' +
                " \nHow many times print editions = " + getNumberOfEditionBuy() +
                " \nIncome From All Editions = " + incomeFromAllEditions() +
                " \nExpenses For Paper Pages = " + expenseForPaper() +
                " \nExpenses For Salaries For Employees = " + expensesForSalariesForEmployees() +
                " \nExpenses For Paper And Employees = " + ExpensesForPaperAndEmployees() +
                " \nEditionList = " + editionList +
                '}';
    }
}
