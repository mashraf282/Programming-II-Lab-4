package Employee;

import Base.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerProductDatabase extends Database<CustomerProduct> {

    public CustomerProductDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<CustomerProduct>());
    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4)
            return null;

        String customerSSN = parts[0];
        String productID = parts[1];
        LocalDate purchaseDate = LocalDate.parse(parts[2]);
        boolean paid = Boolean.parseBoolean(parts[3]);
        CustomerProduct cp = new CustomerProduct(customerSSN, productID, purchaseDate);
        cp.setPaid(paid);
        return cp;
    }

    @Override
    public boolean contains(String key) {
        for(CustomerProduct cp : returnAllRecords()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String dateStr = cp.getPurchaseDate().format(formatter);
            String tempKey = cp.getCustomerSSN() + "," + cp.getProductID() + "," + dateStr;
            if(tempKey.equals(key))
                return true;
        }
        return false;
    }

    @Override
    public CustomerProduct getRecord(String key) {
        for(CustomerProduct cp : returnAllRecords()) {
            String dateStr = cp.getPurchaseDate().toString();
            String year = dateStr.substring(0, 4);
            String month = dateStr.substring(5, 7);
            String day = dateStr.substring(8,10);
            dateStr = day + "-" + month + "-" + year;
            String tempKey = cp.getCustomerSSN() + "," + cp.getProductID() + "," + dateStr;
            if(tempKey.equals(key))
                return cp;
        }
        return null;
    }

    @Override
    public void saveToFile() {
        try{
            File file = new File(getFilename());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(CustomerProduct cp : returnAllRecords())
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String dateStr = cp.getPurchaseDate().format(formatter);
                String line = String.format("%s,%s,%s,%s", cp.getCustomerSSN(), cp.getProductID(), dateStr, cp.isPaid());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
