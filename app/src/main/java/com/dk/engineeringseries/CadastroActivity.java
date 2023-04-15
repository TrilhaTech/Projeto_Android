package com.dk.engineeringseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dk.engineeringseries.databinding.ActivityCadastroBinding;
import com.dk.engineeringseries.databinding.ActivityMainBinding;

public class CadastroActivity extends AppCompatActivity {

    ActivityCadastroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
}