package Employee;

import Base.Database;

import java.util.ArrayList;

public class ProductDatabase extends Database<Product> {


    public ProductDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<Product>());
    }



    // Requested methods (see pdf for details/the rest are in parent class)
    @Override
    public Product createRecordFrom(String line) {
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
    public void saveToFile() {

    }
}
