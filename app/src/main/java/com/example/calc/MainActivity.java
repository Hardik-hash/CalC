package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calc.database.AppDatabase;
import com.example.calc.database.DataEntry;

public class MainActivity extends AppCompatActivity {

    private Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,mul,div,eql,mem,clr;
    private TextView result;
    private  Boolean ADDITION=false;
    private  Boolean SUBTRACTION=false;
    private Boolean MULTIPLICATION=false;
    private Boolean DIVISION=false;
    private double val1;
    private double val2;

    private AppDatabase mdb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       setupUI();

       one.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText() =="0") {
                   result.setText("1");
               }

               else
               {
                   result.setText(result.getText().toString() + "1");
               }
           }
       });

       two.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0") {
                    result.setText("2");
               }
               else
               {
                   result.setText(result.getText().toString() + "2");
               }
           }
       });

       three.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0")
               {
                  result.setText("3");
               }

               else {
                   result.setText(result.getText().toString() + "3");
               }
               }
       });

       four.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0")
               {
                 result.setText("4");
               }

               else
               {
               result.setText(result.getText().toString() + "4");
          }
           }
       });

       five.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0")
               {
                   result.setText("5");
               }

               else {
                   result.setText(result.getText().toString() + "5");
               }
           }
       });

       six.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0")
               {
                   result.setText("6");
               }

               else {
                   result.setText(result.getText().toString() + "6");
               }
           }
       });

       seven.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0")
               {
                   result.setText("7");
               }

               else {
                   result.setText(result.getText().toString() + "7");
               }
               }
       });

       eight.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0")
               {
                   result.setText("8");
               }

               else {
                   result.setText(result.getText().toString() + "8");
               }
               }
       });

       nine.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(result.getText()=="0")
               {
                   result.setText("9");
               }

               else {
                   result.setText(result.getText().toString() + "9");
               }
           }
       });


       zero.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                   result.setText(result.getText().toString() + "0");
           }
       });

       eql.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
          val2= Double.parseDouble(result.getText().toString());

          if(ADDITION==true)
          {
           result.setText(val1 + "+" + val2 +"=" + (val1 + val2) + "");
             ADDITION=false;
              final DataEntry dataEntry = new DataEntry(result.getText().toString());

              AppExecutors.getInstance().diskIO().execute(new Runnable() {
                  @Override
                  public void run() {
                      mdb.dataDao().insertData(dataEntry);
                  }
              });

             // mdb.dataDao().insertData(dataEntry);
            //  finish();

          }

          if(SUBTRACTION==true)
          {
              result.setText(val1 + "-" +val2 + "=" + (val1-val2) +"");
              SUBTRACTION=false;
              final DataEntry dataEntry = new DataEntry(result.getText().toString());

              AppExecutors.getInstance().diskIO().execute(new Runnable() {
                  @Override
                  public void run() {
                      mdb.dataDao().insertData(dataEntry);
                  }
              });


              //mdb.dataDao().insertData(dataEntry);
            //  finish();
          }

          if(MULTIPLICATION==true)
          {
              result.setText(val1 + "*" +val2 + "=" + (val1*val2) +"");
              MULTIPLICATION=false;
              final DataEntry dataEntry = new DataEntry(result.getText().toString());

              AppExecutors.getInstance().diskIO().execute(new Runnable() {
                  @Override
                  public void run() {
                      mdb.dataDao().insertData(dataEntry);
                  }
              });


              //mdb.dataDao().insertData(dataEntry);
            //  finish();
          }

          if(DIVISION==true)
          {
              result.setText(val1 + "/"  +val2 + "=" + (val1/val2)+"");
              DIVISION=false;
              final DataEntry dataEntry= new DataEntry(result.getText().toString());

              AppExecutors.getInstance().diskIO().execute(new Runnable() {
                  @Override
                  public void run() {
                      mdb.dataDao().insertData(dataEntry);
                  }
              });

              //mdb.dataDao().insertData(dataEntry);
            //  finish();
          }

           }



       });

       plus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             val1 = Double.parseDouble(result.getText().toString());
             ADDITION=true;
             result.setText("");

           }
       });

       minus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            val1 = Double.parseDouble(result.getText().toString());
            SUBTRACTION=true;
            result.setText("");
           }
       });

       mul.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               val1 = Double.parseDouble(result.getText().toString());
               MULTIPLICATION=true;
               result.setText("");

           }
       });

       div.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               val1= Double.parseDouble(result.getText().toString());
               DIVISION=true;
               result.setText("");
           }
       });

       mem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,MemoryActivity.class);
               startActivity(intent);


           }
       });

       clr.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                result.setText("0");

           }
       });


       mdb = AppDatabase.getInstance(getApplicationContext());
    }




    private void setupUI(){

        one= (Button)findViewById(R.id.btnone);
        two =(Button)findViewById(R.id.btntwo);
        three= (Button)findViewById(R.id.btnthree);
        four=(Button)findViewById(R.id.btnfor);
        five=(Button)findViewById(R.id.btnfiv);
        six=(Button)findViewById(R.id.btnsix);
        seven=(Button)findViewById(R.id.btnseven);
        eight=(Button)findViewById(R.id.btnegt);
        nine=(Button)findViewById(R.id.btnnin);
        zero=(Button)findViewById(R.id.btnzero);
        plus = (Button)findViewById(R.id.btnpls);
        minus=(Button)findViewById(R.id.btnmin);
        mul=(Button)findViewById(R.id.btnmul);
        div=(Button)findViewById(R.id.btndiv);
        eql=(Button)findViewById(R.id.btneql);
        mem=(Button)findViewById(R.id.btnm);
        clr=(Button)findViewById(R.id.btnclr);
        result=(TextView)findViewById(R.id.res);

    }

}
