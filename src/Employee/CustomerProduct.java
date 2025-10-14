package Employee;

import Base.Information;

import java.time.LocalDate;

public class CustomerProduct extends Information {


    @Override
    public String lineRepresentation() {
        return "";
    }

    @Override
    public String getSearchKey() {
        return "";
    }

    private String customerSSN, productID;
    private LocalDate purchaseDate;
    private boolean paid;

    // Check pdf for constructor/setters/getters details
    // Check pdf for other method details

}
