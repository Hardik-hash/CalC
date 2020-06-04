package com.example.calc.database;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.Stack;

@Dao
public interface DataDao {

    @Query("SELECT * FROM calc")
    List<DataEntry> loadAllData();

    @Insert
    void insertData(DataEntry dataEntry);

    @Delete
    void deleteData(DataEntry dataEntry);

    @Query("DELETE FROM calc")
    void deleteAll();
}
