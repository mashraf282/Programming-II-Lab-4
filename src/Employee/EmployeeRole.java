package Employee;

import Base.Role;

import java.time.LocalDate;

public class EmployeeRole extends Role {

    private ProductDatabase productDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole()
    {
        this.productDatabase = new ProductDatabase("Products.txt");
        this.customerProductDatabase = new CustomerProductDatabase("CustomerProducts.txt");
    }

    // Extra Setters and Getters (not requested but useful)
    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }

    public void setProductDatabase(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public CustomerProductDatabase getCustomerProductDatabase() {
        return customerProductDatabase;
    }

    public void setCustomerProductDatabase(CustomerProductDatabase customerProductDatabase) {
        this.customerProductDatabase = customerProductDatabase;
    }

    // Requested methods (see pdf for details)
    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity) {

    }

    public Product[] getListOfProducts() {
        return null;
    }

    public CustomerProduct[] getListOfPurchasingOperations()
    {
        return null;
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        return false;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate)
    {
        return 0;
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate)
    {
        return false;
    }

    @Override
    public void logout() {

    }
}
