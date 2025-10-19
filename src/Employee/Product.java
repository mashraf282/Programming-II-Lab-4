package Employee;

import Base.Information;

public class Product extends Information {

    private String productID, productName, manufacturerName, supplierName;
    private int quantity;
    private float price;

    // Requested Constructor
    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    // Extra Setters and Getters (not requested but useful)

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Requested Methods (check pdf for details)
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public String lineRepresentation() {
        return this.productID + "," + this.productName + "," + this.manufacturerName + "," + this.supplierName + "," + this.quantity + "," + this.price;
    }

    @Override
    public String getSearchKey() {
        return this.productID;
    }

}
