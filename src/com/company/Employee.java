package com.company;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private TypeOfEmployee typeOfEmployee;
    private boolean isManager = false;


    public Employee(String name, TypeOfEmployee typeOfEmployee) {
        this.name = name;
        if (typeOfEmployee == typeOfEmployee.MANAGER) {
            isManager = true;
            this.typeOfEmployee = typeOfEmployee;
        } else {
            isManager = false;
            this.typeOfEmployee = typeOfEmployee;
        }
    }

    public boolean isManager() {
        return isManager;
    }

    public TypeOfEmployee getTypeOfEmployee() {
        return typeOfEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", typeOfEmployee=" + typeOfEmployee +
                ", isManager=" + isManager +
                '}';
    }
}
