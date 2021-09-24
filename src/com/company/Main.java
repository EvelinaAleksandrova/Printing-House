package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //write in file
    public static void writeCompanyInFile(String nameOfCompany, Company company) {
        try (FileWriter fileWriter = new FileWriter(nameOfCompany, false)) {
            if (company != null) {
                fileWriter.append(company.toString()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read
    public static List<String> readCompanyFromFile(String nameOfCompany) {
        List<String> listOfCompanies = new ArrayList<>();
        try (FileReader fileReader = new FileReader(nameOfCompany)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfCompanies.add(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfCompanies;
    }

    public static void main(String[] args) throws PaperNotEnoughException {

        Edition book1 = new Edition("Zimni Vecheri - Hristo Smirnenski",
                160, TypeOfEdition.BOOK, TypeOfSizeOfPages.A4, TypeOfPaper.PLAIN_PAPER);
        Edition book2 = new Edition("Do Chikago I Nazad - Aleko Konstantinov",
                120, TypeOfEdition.BOOK, TypeOfSizeOfPages.A5, TypeOfPaper.PLAIN_PAPER);
        Edition poster1 = new Edition("Ariana Grande",
                1, TypeOfEdition.POSTER, TypeOfSizeOfPages.A1, TypeOfPaper.GLOSSY_PAPER);
        Edition newspaper1 = new Edition("CNN Newspaper",
                20, TypeOfEdition.NEWSPAPER, TypeOfSizeOfPages.A2, TypeOfPaper.NEWSPAPER_PAPER);

        List<Edition> editionList = new ArrayList<>();
        editionList.add(book1);
        editionList.add(book2);
        editionList.add(poster1);
        editionList.add(newspaper1);

        Employee manager1 = new Employee("Martin", TypeOfEmployee.MANAGER);
        Employee manager2 = new Employee("Mariya", TypeOfEmployee.MANAGER);
        Employee employee1 = new Employee("Viktor", TypeOfEmployee.OPERATOR_OF_PRINTING_MACHINE);
        Employee employee2 = new Employee("Daniela", TypeOfEmployee.OPERATOR_OF_PRINTING_MACHINE);
        Employee employee3 = new Employee("Borislava", TypeOfEmployee.OPERATOR_OF_PRINTING_MACHINE);
        Employee employee4 = new Employee("Stanislava", TypeOfEmployee.OPERATOR_OF_PRINTING_MACHINE);

        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(manager1);
        employeesList.add(manager2);
        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);
        employeesList.add(employee4);

        System.out.print("Enter how many times you want to print Editions - ");
        Scanner scanner = new Scanner(System.in);
        int numberOfEditionBuy = scanner.nextInt();

        Company company = new Company("Printing House", employeesList, 400.01,
                20.00, 100, numberOfEditionBuy, editionList,
                20,25.00);

        PrintingMachine printingMachine1 = new PrintingMachine("Thread-0", TypeOfColorPrinting.COLOR,200);
        PrintingMachine printingMachine2 = new PrintingMachine("Thread-1", TypeOfColorPrinting.COLOR,180);
        PrintingMachine printingMachine3 = new PrintingMachine("Thread-2", TypeOfColorPrinting.BLACK_WHITE,170);

        printingMachine1.maxNumberOfPaperInsert(2000);
        printingMachine2.maxNumberOfPaperInsert(2000);
        printingMachine3.maxNumberOfPaperInsert(2000);

        company.addPrintingMachinesToList(printingMachine1);
        company.addPrintingMachinesToList(printingMachine2);
        company.addPrintingMachinesToList(printingMachine3);


        System.out.println();
        company.printIncomeFromOneEdition();
        System.out.println();
        System.out.println();
        System.out.println("--------------------Income for all Editions--------------------");
        System.out.println(company.incomeFromAllEditions());
        System.out.println("--------------------Expense for Paper Pages--------------------");
        System.out.println(company.expenseForPaper());
        System.out.println("--------------------Expense for Salaries for Employees--------------------");
        System.out.println(company.expensesForSalariesForEmployees());
        System.out.println("--------------------Total Expenses for Paper and Salaries for Employees--------------------");
        System.out.println(company.ExpensesForPaperAndEmployees());
        System.out.println();
        System.out.println();

        //write in file
        String nameOfCompany = "Files" + File.separator + "Company.txt";
        writeCompanyInFile(nameOfCompany, company);

        //read from file
        System.out.println("--------------------INFORMATION FROM FILE---------------------");
        List<String> listOfCompanyFromFile = new ArrayList<>(readCompanyFromFile(nameOfCompany));
        System.out.println(listOfCompanyFromFile);
        System.out.println();
        System.out.println();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("======================================== START PRINTING =========================================");
        company.startPrintingMachines();
    }
}
