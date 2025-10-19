package Employee;

import Base.Information;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        return this.customerSSN;
    }

    public String getProductID() {
        return this.productID;
    }

    public LocalDate getPurchaseDate() { return this.purchaseDate; }

    @Override
    public String lineRepresentation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateStr = this.getPurchaseDate().format(formatter);
        return this.customerSSN + "," + this.productID + "," + dateStr + "," + this.paid;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateStr = this.getPurchaseDate().format(formatter);
        return this.customerSSN + "," + this.productID + "," + dateStr;
    }

}
