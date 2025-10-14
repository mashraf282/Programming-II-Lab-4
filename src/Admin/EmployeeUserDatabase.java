package Admin;

import Base.Database;

import java.util.ArrayList;

public class EmployeeUserDatabase extends Database<EmployeeUser> {

    public EmployeeUserDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<EmployeeUser>());
    }

    // Check pdf for constructor/setters/getters details
    // Check pdf for other method details (make sure to check parent class before overriding)
    // Initialize ArrayList with EmployeeUser objects

    @Override
    public void readFromFile() {

    }

    @Override
    public EmployeeUser createRecordFrom(String line) {
        return null;
    }

    @Override
    public ArrayList<EmployeeUser> returnAllRecords() {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public EmployeeUser getRecord(String key) {
        return null;
    }

    @Override
    public void insertRecord(Object record) {

    }

    @Override
    public void deleteRecord(String key) {

    }

    @Override
    public void saveToFile() {

    }
}
