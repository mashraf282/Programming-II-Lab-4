package Admin;

import Base.Database;

import java.util.ArrayList;

public class EmployeeUserDatabase extends Database<EmployeeUser> {

    public EmployeeUserDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<EmployeeUser>());
    }

    // Request methods (see pdf for details/the rest are in parent class)
    @Override
    public EmployeeUser createRecordFrom(String line) {
        return null;
    }


    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public EmployeeUser getRecord(String key) {
        return null;
    }


    @Override
    public void saveToFile() {

    }
}
