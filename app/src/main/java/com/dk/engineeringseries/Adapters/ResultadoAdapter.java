package com.dk.engineeringseries.Adapters;

import android.content.Context;
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

    Context context;
    private List<Resultado> result;

    public ResultadoAdapter(List<Resultado> a, Context c) {
        this.result = a;
        context = c;
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

        holder.getImgResult().setImageResource(resultado.getImgresult());

        String resul = resultado.getResultado();

        if(resul.equals("Desenvolvedor")){
            System.out.println("Entrou no if - dev");
            holder.getBtnTrilha1().setOnClickListener(view -> trilhaDev1(position));
            holder.getBtnTrilha2().setOnClickListener(view -> trilhaDev2(position));
            holder.getBtnTrilha3().setOnClickListener(view -> trilhaDev3(position));
        }else if(resul.equals("Redes")){
            System.out.println("Entrou no if - redes");
            holder.getBtnTrilha1().setOnClickListener(view -> trilhaRedes1(position));
            holder.getBtnTrilha2().setOnClickListener(view -> trilhaRedes2(position));
            holder.getBtnTrilha3().setOnClickListener(view -> trilhaRedes3(position));
        }else if(resul.equals("Gerenciador de projetos")){
            System.out.println("Entrou no if - geren");
            holder.getBtnTrilha1().setOnClickListener(view -> trilhaGeren1(position));
            holder.getBtnTrilha2().setOnClickListener(view -> trilhaGeren2(position));
            holder.getBtnTrilha3().setOnClickListener(view -> trilhaGeren3(position));
        }else if(resul.equals("Tester/QA")){
            System.out.println("Entrou no if - redes");
            holder.getBtnTrilha1().setOnClickListener(view -> trilhaQA1(position));
            holder.getBtnTrilha2().setOnClickListener(view -> trilhaQA2(position));
            holder.getBtnTrilha3().setOnClickListener(view -> trilhaQA3(position));
        }else if(resul.equals("Analísta de dados")){
            System.out.println("Entrou no if - redes");
            holder.getBtnTrilha1().setOnClickListener(view -> trilhaDados1(position));
            holder.getBtnTrilha2().setOnClickListener(view -> trilhaDados2(position));
            holder.getBtnTrilha3().setOnClickListener(view -> trilhaDados3(position));
        }

    }

    public void trilhaDev1(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=VKjFuX91G5Q&list=PL62G310vn6nFIsOCC0H-C2infYgwm8SWW");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaDev2(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=LnORjqZUMIQ&list=PLGxZ4Rq3BOBq0KXHsp5J3PxyFaBIXVs3r");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaDev3(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=sTX0UEplF54&list=PLHz_AreHm4dkI2ZdjTwZA4mPMxWTfNSpR");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    //-----------------------
    public void trilhaRedes1(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=vqrvOz1zSgY");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaRedes2(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=anFV6z8pEVU&list=PLAp37wMSBouBnNup2tD-mC36JT96vHBZy");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaRedes3(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=QkMbqL8QD9w&list=PLHz_AreHm4dkd4lr9G0Up-W-YaHYdTDuP");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    //-----------------------
    public void trilhaGeren1(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=InbOnXMAA7k&list=PLdbeMxdOH2IYmhapnvmjFj9Nqtok5obK8");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaGeren2(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=NR8yKbPdkMQ&list=PLh2Y_pKOa4Ud0ZaRJ613cGv7zZbCPcZTj");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaGeren3(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=efZlpew90Nk&list=PLH7xyLSXcm-T5qJql9QQwO3qxvAeDsdEd");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    //-----------------------
    public void trilhaQA1(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=tX3SKUaGL14&list=PL0nYAInGtru2yb7rJvqPkrVAkjjJnj_mW");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaQA2(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=cgVXcQpZHcI");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaQA3(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=eCmIALYTqPk");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    //-----------------------
    public void trilhaDados1(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=AX8TZr5_VZE&list=PLIHpLBNsiHE3BBSs-NflSvU9AQ35tzfHw");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaDados2(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=lqhSUt0_qMo&list=PLGhYxMiQR5_94q9EPq5DM3uZyjR1m6jRn");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }
    public void trilhaDados3(int position) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=DeAuVrhKw58&list=PL5TJqBvpXQv78JrStmN5qp6xoEBT_-3zO");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(i);    }

    @Override
    public int getItemCount() {
        return result == null ? 0 : result.size();    }
}
