package com.example.mysqlitedatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText nameEditText, ageEditText, genderEditText;
    private Button addButton;
    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        nameEditText = findViewById(R.id.nameEditTextId);
        ageEditText = findViewById(R.id.ageEditTextId);
        genderEditText = findViewById(R.id.genderEditTextId);

        addButton = findViewById(R.id.addButtonId);
        addButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = genderEditText.getText().toString();

        if (v.getId() == R.id.addButtonId)
        {
           long rowId =  myDatabaseHelper.insertData(name,age,gender);

            if (rowId == -1) {
                Toast.makeText(this, "unsuccessful",
                        Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Row "+rowId+" is successfully inserted",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}