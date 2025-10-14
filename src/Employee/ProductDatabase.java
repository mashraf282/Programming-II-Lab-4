package Employee;

import Base.Database;

import java.util.ArrayList;

public class ProductDatabase extends Database<Product> {


    public ProductDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<Product>());
    }

    // Check pdf for constructor/setters/getters details
    // Check pdf for other method details (make sure to check parent class before overriding)
    // Initialize ArrayList with Product objects

    @Override
    public void readFromFile() {

    }

    @Override
    public Product createRecordFrom(String line) {
        return null;
    }

    @Override
    public ArrayList<Product> returnAllRecords() {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Product getRecord(String key) {
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
