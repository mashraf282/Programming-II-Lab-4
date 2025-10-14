package Employee;

import Base.Database;

import java.util.ArrayList;

public class CustomerProductDatabase extends Database<CustomerProduct> {


    public CustomerProductDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<CustomerProduct>());
    }


    // Check pdf for constructor/setters/getters details
    // Check pdf for other method details (make sure to check parent class before overriding)
    // Initialize ArrayList with CustomerProduct objects

    @Override
    public void readFromFile() {

    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        return null;
    }

    @Override
    public ArrayList<CustomerProduct> returnAllRecords() {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public CustomerProduct getRecord(String key) {
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
