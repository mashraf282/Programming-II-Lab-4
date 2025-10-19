package Employee;

import Base.Role;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EmployeeRole extends Role {

    private ProductDatabase productDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole()
    {
        this.productDatabase = new ProductDatabase("Products.txt");
        this.customerProductDatabase = new CustomerProductDatabase("CustomerProducts.txt");
        productDatabase.readFromFile();
        customerProductDatabase.readFromFile();
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

    // Requested methods
    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
         if(productDatabase.contains(productID)) {
             System.out.println("Product already exists");
             return;
         }
         Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
         this.productDatabase.insertRecord(product);
    }

    public Product[] getListOfProducts() {
        return productDatabase.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() { return this.customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]); }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        Product purchasedProduct = null;
            for(Product product : getListOfProducts())
                if(productID.equals(product.getSearchKey()))
                    purchasedProduct = product;

            if(purchasedProduct == null)
                return false;

            if(purchasedProduct.getQuantity() < 1)
                return false;
            else
                purchasedProduct.setQuantity(purchasedProduct.getQuantity()-1);

            CustomerProduct cp = new CustomerProduct(customerSSN, productID, purchaseDate);
            this.customerProductDatabase.insertRecord(cp);

            return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate)
    {

        if(purchaseDate.isAfter(returnDate))
            return -1;

        boolean check = false;
        Product returnedProduct = null;
        CustomerProduct cproduct = null;
        for(CustomerProduct cp : getListOfPurchasingOperations())
            if(cp.getCustomerSSN().equals(customerSSN) && cp.getProductID().equals(productID)) {
                check = true;
                returnedProduct = this.productDatabase.getRecord(productID);
                cproduct = cp;
                break;
            }

        if(returnedProduct == null || !check)
            return -1;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateStr = cproduct.getPurchaseDate().format(formatter);

        if(!customerProductDatabase.contains(customerSSN + "," + productID + "," + dateStr))
            return -1;

        long daysBetween = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if(daysBetween > 14)
            return -1;

        returnedProduct.setQuantity(returnedProduct.getQuantity()+1);

        this.customerProductDatabase.deleteRecord(customerSSN + "," + productID + "," + dateStr);

        return returnedProduct.getPrice();

    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate)
    {
        for(CustomerProduct cp : getListOfPurchasingOperations())
            if(cp.getCustomerSSN().equals(customerSSN) && cp.getPurchaseDate().equals(purchaseDate)) {
                cp.setPaid(true);
                return true;
            }
        return false;
    }

    @Override
    public void logout() {
        productDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}
