package com.dk.engineeringseries.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dk.engineeringseries.Adapters.SetsAdapter;
import com.dk.engineeringseries.MainActivity;
import com.dk.engineeringseries.Modelss.SetsModel;
import com.dk.engineeringseries.R;
import com.dk.engineeringseries.databinding.ActivitySetsBinding;

import java.util.ArrayList;

public class SetsActivity extends AppCompatActivity {

    ActivitySetsBinding binding;
    ArrayList<SetsModel>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.setRecy.setLayoutManager(linearLayoutManager);

        list.add(new SetsModel("Começar"));

       // list.add(new SetsModel("SET-2070"));


        SetsAdapter adapter = new SetsAdapter(this,list);
        binding.setRecy.setAdapter(adapter);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SetsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(SetsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}