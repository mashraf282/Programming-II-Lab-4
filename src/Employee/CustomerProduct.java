package Employee;

import Base.Information;

import java.time.LocalDate;

public class CustomerProduct extends Information {

    private String customerSSN, productID;
    private LocalDate purchaseDate;
    private boolean paid;

    // Requested Constructor
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }

    // Extra Setters (not requested but useful)
    public void setCustomerSSN(String customerSSN) {
        this.customerSSN = customerSSN;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    // Requested methods (see pdf for details)
    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String lineRepresentation() {
        return "";
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String getSearchKey() {
        return "";
    }

}
