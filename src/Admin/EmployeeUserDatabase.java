package Admin;

import Base.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class EmployeeUserDatabase extends Database<EmployeeUser> {

    public EmployeeUserDatabase(String filename) {
        super(filename);
        setRecords(new ArrayList<EmployeeUser>());
    }

    @Override
    public EmployeeUser createRecordFrom(String line) {
         String[] parts = line.split(",");

         if(parts.length != 5)
             return null;

         return new EmployeeUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }


    @Override
    public boolean contains(String key) {
        for(EmployeeUser user : returnAllRecords())
            if(user.getEmployeeId().equals(key))
                return true;
        return false;
    }

    @Override
    public EmployeeUser getRecord(String key) {
        for(EmployeeUser user : returnAllRecords())
            if(user.getEmployeeId().equals(key))
                return user;
        return null;
    }


    @Override
    public void saveToFile() {

        try{
            File file = new File(getFilename());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(EmployeeUser user : returnAllRecords())
            {
                String line = String.format("%s,%s,%s,%s,%s", user.getEmployeeId(), user.getName(), user.getEmail(), user.getAddress(), user.getPhoneNumber());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}
