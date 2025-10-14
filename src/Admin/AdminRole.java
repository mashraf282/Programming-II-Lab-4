package Admin;

import Base.Role;

public class AdminRole extends Role {

    private EmployeeUserDatabase database;

    public AdminRole(){
        this.database = new EmployeeUserDatabase("Employees.txt");
    }

    // Extra Setters and Getters (not requested but useful)
    public EmployeeUserDatabase getDatabase() {
        return database;
    }

    public void setDatabase(EmployeeUserDatabase database) {
        this.database = database;
    }

    // Requested methods (see pdf for details)
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {

    }

    public EmployeeUser[] getListOfEmployees() {
        return null;
    }

    public void removeEmployee(String key) {

    }

    @Override
    public void logout() {

    }
}
