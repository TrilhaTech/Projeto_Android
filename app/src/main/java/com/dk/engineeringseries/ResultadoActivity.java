package com.dk.engineeringseries;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.dk.engineeringseries.Adapters.ResultadoAdapter;
import com.dk.engineeringseries.dataset.ResultadoDataset;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class ResultadoActivity extends AppCompatActivity {

    private RecyclerView recyclerResult;
    private ResultadoAdapter resultadoAdapter;

    String usuarioId;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String usuarioName = null;

    Map<String, Object> usuarios = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        //setupCarousel();
        CadastrarArea();

        if (getIntent().hasExtra("dev")) {
            listaDev();
        }
        else if (getIntent().hasExtra("redes")) {
            listaRedes();
        }
        else if (getIntent().hasExtra("geren")) {
            listaGeren();
        }
        else if (getIntent().hasExtra("testes")) {
            listaTestes();
        }
        else if (getIntent().hasExtra("dados")) {
            listaDados();
        }
    }

    private void CadastrarArea() {
//        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();
//
//        DocumentReference documentReference2 = db.collection("Usuarios").document(usuarioId);
//        documentReference2.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                if(documentSnapshot != null){
//                    System.out.println("---------------------"+documentSnapshot.getString("usuario"));
//                    usuarioName = documentSnapshot.getString("usuario");
//                    System.out.println("---------------------"+usuarioName);
//                    usuarios.put("Usuário", usuarioName);
//                }
//            }
//        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = null;
        //String nome = null;
        String email = null;
        if (user != null) {
            uid = user.getUid();
            //nome = user.getDisplayName();
            email = user.getEmail();
        }

        String result = "";

        if (getIntent().hasExtra("dev")) {
            result = "Desenvolvedor";
        } else if (getIntent().hasExtra("redes")) {
            result = "Redes";
        } else if (getIntent().hasExtra("geren")) {
            result = "Gerenciador de projetos";
        } else if (getIntent().hasExtra("testes")) {
            result = "Testes/QA";
        } else if (getIntent().hasExtra("dados")) {
            result = "Analista de dados";
        }

        System.out.println("--------------------" + uid);
        //System.out.println("--------------------" + nome);
        System.out.println("--------------------" + email);
        System.out.println("--------------------" + result);

        usuarios.put("UID", uid);
        //usuarios.put("Nome", nome);
        usuarios.put("E-mail", email);
        usuarios.put("resultado", result);

        for (String keys : usuarios.keySet())
        {
            System.out.println(keys + ":"+ usuarios.get(keys));
        }
        System.out.println("----------USUARIO-----------"+usuarioName);


        usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Resultados").document(usuarioId);
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

    private void listaDev() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista1(),this);
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaRedes() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista2(),this);
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaGeren() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista3(),this);
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaTestes() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista4(),this);
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaDados() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista5(),this);
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

//    private void setupCarousel() {
//        Carousel carousel = (Carousel) findViewById(R.id.carousel);
//        carousel.setAdapter(new Carousel.Adapter() {
//            @Override
//            public int count() {
//                return 2;
//            }
//
//            @Override
//            public void populate(View view, int index) {
//
//            }
//
//            @Override
//            public void onNewItem(int index) {
//
//            }
//        });
//    }
}