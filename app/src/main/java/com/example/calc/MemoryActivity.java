package com.example.calc;

import android.os.Bundle;

import com.example.calc.database.AppDatabase;
import com.example.calc.database.DataDao;
import com.example.calc.database.DataEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MemoryActivity extends AppCompatActivity {

    private RecyclerView Data;
    private AppDatabase mDb;
    private DataListAdapter dataListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                         mDb.dataDao().deleteAll();

                    }
                });

            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Data = (RecyclerView) findViewById(R.id.recycle);
        Data.setLayoutManager(new LinearLayoutManager(this));
        dataListAdapter = new DataListAdapter(this);
        mDb = AppDatabase.getInstance(getApplicationContext());

        Data.setAdapter(dataListAdapter);
      retrieveData();
    }


    private void retrieveData() {
        final LiveData<List<DataEntry>> data = mDb.dataDao().loadAllData();
        // We will be able to simplify this once we learn more
        // about Android Architecture Components
        data.observe(this, new Observer<List<DataEntry>>() {
            @Override
            public void onChanged(List<DataEntry> dataEntries) {
                dataListAdapter.setData(dataEntries);
            }
        });
    }

}
