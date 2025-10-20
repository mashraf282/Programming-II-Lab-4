package Admin;

import Base.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdminRole extends Role {

    private EmployeeUserDatabase database;

    // Requested Constructor
    public AdminRole() {
        this.database = new EmployeeUserDatabase("Employees.txt");
        this.database.readFromFile();
    }

    // Extra Setters and Getters (not requested but useful)
    public EmployeeUserDatabase getDatabase() {
        return database;
    }

    public void setDatabase(EmployeeUserDatabase database) {
        this.database = database;
    }

    // Requested methods
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) throws Exception {
        if(database.contains(employeeId)) {
            System.out.println("Employee already exists");
            return;
        }
        database.insertRecord(new EmployeeUser(employeeId, name, email, address, phoneNumber));
         System.out.println("Employee added successfully");
    }

    public void addEmployee(EmployeeUser user) {
        database.insertRecord(user);
    }

    public EmployeeUser[] getListOfEmployees() {
        return database.returnAllRecords().toArray(new EmployeeUser[0]);
    }

    public void removeEmployee(String key) {
        database.deleteRecord(key);
    }

    @Override
    public void logout() {
        database.saveToFile();
    }
}
