package Employee;

import Base.Database;

import java.util.ArrayList;

public class CustomerProductDatabase extends Database<CustomerProduct> {

    public CustomerProductDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<CustomerProduct>());
    }

    // Requested methods (see pdf for details/the rest are in parent class)
    @Override
    public CustomerProduct createRecordFrom(String line) {
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
    public void saveToFile() {

    }
}
