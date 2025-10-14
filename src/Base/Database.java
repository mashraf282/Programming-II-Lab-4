package Base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database<T> {

    private ArrayList<T>records;
    private final String filename;

    public Database(String filename)
    {
        this.filename = filename;
    }

    public ArrayList<T> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<T>records) {
        this.records = records;
    }

    public void readFromFile()
    {
        try{
            File file = new File(filename);
            Scanner fr = new Scanner(file);
            String line;
            T record;
            while(fr.hasNextLine())
            {
                line = fr.nextLine();
                record = (T) createRecordFrom(line);
                records.add(record);
            }
        }
        catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File not found: " + filename);
    }

    public abstract T createRecordFrom(String line);
    public abstract ArrayList<T>returnAllRecords();
    public abstract boolean contains(String key);
    public abstract T getRecord(String key);
    public abstract void insertRecord(Object record);
    public abstract void deleteRecord(String key);
    public abstract void saveToFile();

}
