package com.dk.engineeringseries.Adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dk.engineeringseries.Modelss.Resultado;
import com.dk.engineeringseries.R;

import java.util.List;

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoHolder>{

    private List<Resultado> result;

    public ResultadoAdapter(List<Resultado> a) {
        this.result = a;
    }


    @NonNull
    @Override
    public ResultadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ResultadoHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_resultado, parent,
                                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadoHolder holder, int position) {
        Resultado resultado = result.get(position);
        holder.getTxtResult().setText(resultado.getResultado());
        holder.getTxtArea1().setText(resultado.getArea1());
        holder.getTxtArea2().setText(resultado.getArea2());
        holder.getTxtArea3().setText(resultado.getArea3());

        holder.getTxtDescArea1().setText(resultado.getDescArea1());
        holder.getTxtDescArea2().setText(resultado.getDescArea2());
        holder.getTxtDescArea3().setText(resultado.getDescArea3());

        holder.getImgTrilha1().setImageResource(resultado.getImgTrilha1());
        holder.getImgTrilha2().setImageResource(resultado.getImgTrilha2());
        holder.getImgTrilha3().setImageResource(resultado.getImgTrilha3());

        holder.getTxtTrilha1().setText(resultado.getTrilha1());
        holder.getTxtTrilha2().setText(resultado.getTrilha2());
        holder.getTxtTrilha3().setText(resultado.getTrilha3());

        holder.getTxtDescTrilha1().setText(resultado.getDescTrilha1());
        holder.getTxtDescTrilha2().setText(resultado.getDescTrilha2());
        holder.getTxtDescTrilha3().setText(resultado.getDescTrilha3());

        String resul = resultado.getResultado();

        if(resul.equals("Desenvolvedor")){
            System.out.println("Entrou no if");
            holder.getBtnTrilha1().setOnClickListener(view -> Toast.makeText( view.getContext(), "" +
                    resultado.getResultado(), Toast.LENGTH_SHORT).show());
        }


    }

    @Override
    public int getItemCount() {
        return result == null ? 0 : result.size();    }
}
