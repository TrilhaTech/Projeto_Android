package com.dk.engineeringseries;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dk.engineeringseries.Activities.SetsActivity;
import com.dk.engineeringseries.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        binding.subEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        binding.textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(in);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to ext?");

        builder.setCancelable(false);

        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

            finish();
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

}