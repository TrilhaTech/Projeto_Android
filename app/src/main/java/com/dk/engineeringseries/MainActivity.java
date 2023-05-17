package com.dk.engineeringseries;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.dk.engineeringseries.Activities.SetsActivity;
import com.dk.engineeringseries.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    private EditText txtEmail, txtSenha;
    private  View btnEntrar;
    ActivityMainBinding binding;

    String[] mensagens = {"Preencha todos os campos!" , "Login realizado com sucesso!"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.teste);
        //setupCarousel();


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Questoes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("dado", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("erro", "Error getting documents.", task.getException());
                        }
                    }
                });

        getSupportActionBar().hide();
        IniciarComponentes();


        binding.btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.RED);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }else{
                    AutenticarUsuario(view);
                }

            }
        });

        binding.txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(in);
                finish();
            }
        });

    }

    private void AutenticarUsuario(View v) {
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this, SetsActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    String erro;
                    try {
                        throw task.getException();

                    }catch (Exception e){
                        erro = "Esse usuário não existe!";
                        txtSenha.setText("");
                    }
                    Snackbar snackbar = Snackbar.make(v, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.RED);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //USUARIO PERMANECE LOGADO AO FECHAR O APP
//        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();
//
//        if(usuarioAtual != null){
//            Intent intent = new Intent(MainActivity.this, SetsActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }

    private void IniciarComponentes() {
        txtEmail = findViewById(R.id.txtemailL);
        txtSenha = findViewById(R.id.txtSenhaL);

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