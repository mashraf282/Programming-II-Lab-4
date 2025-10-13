package Employee;

import Base.Information;

public class Product extends Information {

    private String productID, productName, manufacturerName, supplierName;
    private int quantity;
    private float price;

    // Check pdf for constructor/setters/getters details
    // Check pdf for other method details


    @Override
    public String lineRepresentation() {
        return "";
    }

    @Override
    public String getSearchKey() {
        return "";
    }
}
