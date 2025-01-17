package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    EditText InputCity;
    Button AddButton;
    Button DeleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        cityList = findViewById(R.id.city_list);
        String[] cities = {"Edmonton", "Vancouver", "Toronto", "Ottawa"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        InputCity = findViewById(R.id.InputCity);
        AddButton = findViewById(R.id.Add);
        DeleteButton = findViewById(R.id.Delete);

        AddButton.setOnClickListener(v -> {
            String city = InputCity.getText().toString();

            dataList.add(city);
            cityAdapter.notifyDataSetChanged();
        });

        DeleteButton.setOnClickListener(v -> {
            String city = InputCity.getText().toString();

            dataList.remove(city);
            cityAdapter.notifyDataSetChanged();

        });
    }

}