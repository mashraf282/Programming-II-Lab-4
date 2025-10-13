package Employee;

import Base.Database;

import java.util.ArrayList;

public class ProductDatabase extends Database {


    // Check pdf for constructor/setters/getters details
    // Check pdf for other method details
    // Initialize ArrayList with Product objects

    @Override
    public void readFromFile() {

    }

    @Override
    public Object createRecordFrom(String line) {
        return null;
    }

    @Override
    public ArrayList returnAllRecords() {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public Object getRecord(String key) {
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
