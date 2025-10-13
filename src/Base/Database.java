package Base;

import java.util.ArrayList;

public abstract class Database {
    private ArrayList records;
    private String filename;

    public abstract void readFromFile();
    public abstract Object createRecordFrom(String line);
    public abstract ArrayList returnAllRecords();
    public abstract boolean contains(String key);
    public abstract Object getRecord(String key);
    public abstract void insertRecord(Object record);
    public abstract void deleteRecord(String key);
    public abstract void saveToFile();

}
