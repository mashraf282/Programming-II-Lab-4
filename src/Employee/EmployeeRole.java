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

    // Requested methods (see pdf for details)
    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
         if(!this.productDatabase.isUnique(productID)) {
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
        Product purchasedProduct;
            for(Product product : getListOfProducts())
                if(productID == product.productID)
                    purchasedProduct = product;

            if(purchasedProduct.getQuantity() < 1)
                return false;
            else
                purchasedProduct.setQuantity(getQuantity() - 1);

            return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate)
    {

        if(purchaseDate.isAfter(returnDate))
            return -1;

        boolean check = false;
        Product returnedProduct;
        for(Product product : getListOfProducts())
            if(product.getproductID().equalTo(productID)) {
                check = true;
                returnedProduct = product;
                break;
            }
        if(!check)
            return -1;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateStr = cp.getPurchaseDate().format(formatter);

        if(!customerProductDatabase.contains(customerSSN + "," + productID + "," + dateStr))
            return -1;

        if(returnDate.compareTo(purchaseDate) > 14)
            return -1;

        returnedProduct.setQuantity(returnedProduct.getQuantity()++);

        return returnedProduct.getPrice();

    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate)
    {
        for(Products product : getListOfProducts()){
            if(customerSSN.equalTo(product.getCusromerSSN) && purchaseDate.isEqual(product.getPurchaseDate){
                if(product.isPaid)
                    return false;
                else
                    product.setPaid = true;
            }
        }
    }

    @Override
    public void logout() {
        productDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}
