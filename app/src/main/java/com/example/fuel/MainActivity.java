package com.example.fuel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number,location;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
//        setSupportActionBar(toolbar);
        toolbar.setTitle("HomePage");



        number = (EditText)findViewById(R.id.car_number);
        location = (EditText)findViewById(R.id.location);
        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"searching for fuel station",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,StationsActivity.class));
                finish();
            }
        });
        
    }



}
