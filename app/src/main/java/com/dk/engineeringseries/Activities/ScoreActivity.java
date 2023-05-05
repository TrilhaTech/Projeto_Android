package com.dk.engineeringseries.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dk.engineeringseries.ResultadoActivity;
import com.dk.engineeringseries.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    ActivityScoreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        int totalScore = getIntent().getIntExtra("total", 0);
        int correctAnsw = getIntent().getIntExtra("score", 0);


        int wrong = totalScore-correctAnsw;

        binding.results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ScoreActivity.this, ResultadoActivity.class);
                if(getIntent().hasExtra("dev")){
                    System.out.println("O maior é dev");
                    in.putExtra("dev", "dev");
                }
                else if(getIntent().hasExtra("redes")){
                    System.out.println("O maior é redes");
                    in.putExtra("redes", "redes");
                }
                else if(getIntent().hasExtra("geren")){
                    System.out.println("O maior é geren");
                    in.putExtra("geren", "geren");
                }
                else if(getIntent().hasExtra("testes")){
                    System.out.println("O maior é testes");
                    in.putExtra("testes", "testes");
                }
                else if(getIntent().hasExtra("dados")){
                    System.out.println("O maior é dados");
                    in.putExtra("dados", "dados");
                }
                startActivity(in);
                finish();
            }
        });

        binding.retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScoreActivity.this,SetsActivity.class);
                startActivity(intent);
                finish();

            }
        });


        binding.quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ScoreActivity.this);
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
        });


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(ScoreActivity.this,SetsActivity.class);
        startActivity(intent);
        finish();

    }
}