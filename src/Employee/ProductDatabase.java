package Employee;

import Base.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProductDatabase extends Database<Product> {


    public ProductDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<Product>());
    }

    @Override
    public Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length != 6) {
            return null;
        }
        String productID = parts[0];
        String productName = parts[1];
        String manufacturerName = parts[2];
        String supplierName = parts[3];
        int quantity = Integer.parseInt(parts[4]);
        float price = Float.parseFloat(parts[5]);

        return new Product(productID, productName, manufacturerName, supplierName, quantity, price);
    }

    @Override
    public boolean contains(String key) {
        for(Product p : returnAllRecords())
            if(p.getSearchKey().equals(key))
                return true;
        return false;
    }

    @Override
    public Product getRecord(String key) {
        for(Product p : returnAllRecords())
            if(p.getSearchKey().equals(key))
                return p;
        return null;
    }

    @Override
    public void saveToFile() {
        try {
            File file = new File(getFilename());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(Product p : returnAllRecords()) {
                String line = String.format("%s,%s,%s,%s,%d,%f",
                        p.getSearchKey(),
                        p.getProductName(),
                        p.getManufacturerName(),
                        p.getSupplierName(),
                        p.getQuantity(),
                        p.getPrice());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
