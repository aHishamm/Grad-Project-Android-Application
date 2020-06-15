package com.example.project2application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarMenu extends AppCompatActivity {
        Button mAddCar, mViewCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_menu);

        mAddCar = findViewById(R.id.addCar);
        mViewCars = findViewById(R.id.viewCars);
        //setup the buttons
        mAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddCar.class));
            }
        });
        mViewCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CarLIST.class));
            }
        });
    }
}
