package com.dk.engineeringseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

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
        //setContentView(binding.getRoot());
        setContentView(R.layout.teste);
        setupCarousel();

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

    private void setupCarousel() {
        Carousel carousel = (Carousel) findViewById(R.id.carousel);
        carousel.setAdapter(new Carousel.Adapter() {
            @Override
            public int count() {
                return 2;
            }

            @Override
            public void populate(View view, int index) {

            }

            @Override
            public void onNewItem(int index) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Você quer sair?");

        builder.setCancelable(false);

        builder.setPositiveButton("Sim", (DialogInterface.OnClickListener) (dialog, which) -> {

            finish();
        });

        builder.setNegativeButton("Não", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

}