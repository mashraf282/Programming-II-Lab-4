package Base;

import java.io.*;
import java.util.ArrayList;


public abstract class Database<T> {

    private ArrayList<T>records;
    private final String filename;

    public Database(String filename)
    {
        this.filename = filename;
    }

    public void setRecords(ArrayList<T>records) {
        this.records = records;
    }

    public String getFilename()
    {
        return this.filename;
    }


    public void readFromFile()
    {
        try{
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            T record;
            while((line =br.readLine()) != null)
            {
                record = (T) createRecordFrom(line);
                if(record != null)
                    records.add(record);
            }
            br.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public abstract T createRecordFrom(String line);

    public ArrayList<T>returnAllRecords()
    {
        return this.records;
    }

    public abstract boolean contains(String key);

    public abstract T getRecord(String key);

    public void insertRecord(T record)
    {
        records.add(record);
    }

    public void deleteRecord(String key)
    {
        records.remove(getRecord(key));
    }

    public abstract void saveToFile();



}
