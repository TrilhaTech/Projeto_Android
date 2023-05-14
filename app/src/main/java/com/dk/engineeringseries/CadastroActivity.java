package com.dk.engineeringseries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.dk.engineeringseries.databinding.ActivityCadastroBinding;
import com.dk.engineeringseries.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CadastroActivity extends AppCompatActivity {

    ActivityCadastroBinding binding;
    private EditText txtNome, txtUsuario, txtEmail, txtSenha, txtConfirmarSenha;
    private  View btnCadastrar;
    String[] mensagens = {"Preencha todos os campos!" , "Usuário cadastrado com sucesso!", "As senhas não coincidem!"};
    String usuarioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        iniciarComponentes();

        binding.btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = txtNome.getText().toString();
                String usuario = txtUsuario.getText().toString();
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();
                String confirmarSenha = txtConfirmarSenha.getText().toString();

                if(nome.isEmpty() || usuario.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.RED);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
            }
                else if(!senha.equals(confirmarSenha)){
                    Snackbar snackbar = Snackbar.make(view, mensagens[2], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.RED);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    txtSenha.setText("");
                    txtConfirmarSenha.setText("");
                }
                else {
                    CadastrarUsuario(view);
                }
            }
        });

        binding.txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Login();
            }
        });
    }

    private void Login() {
        Intent in = new Intent(CadastroActivity.this, MainActivity.class);
        startActivity(in);
        finish();
    }

    private void CadastrarUsuario(View v) {
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    
                    SalvarDadosUsuario();

                    System.out.println("ENTROU - -------------------");
                    Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.GREEN);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();

                    txtNome.setText("");
                    txtUsuario.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");
                    txtConfirmarSenha.setText("");

                }else{
                    String erro;
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Senha inválida!";
                        txtSenha.setText("");
                        txtConfirmarSenha.setText("");
                    }catch (FirebaseAuthUserCollisionException e){
                        erro = "Essa conta já existe!";
                        txtEmail.setText("");
                        txtSenha.setText("");
                        txtConfirmarSenha.setText("");
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro = "E-mail inválido!";
                        txtEmail.setText("");
                        txtSenha.setText("");
                        txtConfirmarSenha.setText("");
                    }catch (Exception e){
                        erro = "Erro ao cadastrar usuário!";
                        txtNome.setText("");
                        txtUsuario.setText("");
                        txtEmail.setText("");
                        txtSenha.setText("");
                        txtConfirmarSenha.setText("");
                    }
                    Snackbar snackbar = Snackbar.make(v, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.RED);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }

    private void SalvarDadosUsuario() {
        String nome = txtNome.getText().toString();
        String usuario = txtUsuario.getText().toString();
        String email = txtEmail.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> usuarios = new HashMap<>();
        usuarios.put("nome", nome);
        usuarios.put("usuario", usuario);
        usuarios.put("email", email);

        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioId);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db", "Sucesso ao salvar os dados!");
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db", "Erro ao salvar os dados!" + e.toString());
                    }
                });
    }

    private void iniciarComponentes(){
        txtNome = findViewById(R.id.txtNomec);
        txtUsuario = findViewById(R.id.txtUsuarioc);
        txtEmail = findViewById(R.id.txtEmailc);
        txtSenha = findViewById(R.id.txtSenhac);
        txtConfirmarSenha = findViewById(R.id.txtConfirmarc);
    }
}