package com.example.calc.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "calc")
public class DataEntry {
    @PrimaryKey(autoGenerate = true)
    @NonNull

    private int id;
    private String data;

    @Ignore
    public DataEntry(String data)
    {
       this.data=data;
    }


    public DataEntry(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}


