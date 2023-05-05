package com.dk.engineeringseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.dk.engineeringseries.Adapters.ResultadoAdapter;
import com.dk.engineeringseries.dataset.ResultadoDataset;

public class ResultadoActivity extends AppCompatActivity {

    private RecyclerView recyclerResult;
    private ResultadoAdapter resultadoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        //setupCarousel();

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
    private void listaDev() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista1());
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaRedes() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista2());
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaGeren() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista3());
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaTestes() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista4());
        recyclerResult.setAdapter(resultadoAdapter);
        recyclerResult.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }
    private void listaDados() {
        recyclerResult = (RecyclerView)findViewById(R.id.recyclerResultado);
        recyclerResult.setLayoutManager(new LinearLayoutManager(this));
        resultadoAdapter = new ResultadoAdapter(ResultadoDataset.getlista5());
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