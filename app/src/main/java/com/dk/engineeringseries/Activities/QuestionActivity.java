package com.dk.engineeringseries.Activities;

import android.animation.Animator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dk.engineeringseries.MainActivity;
import com.dk.engineeringseries.Modelss.Contadores;
import com.dk.engineeringseries.Modelss.QuestionModel;
import com.dk.engineeringseries.R;
import com.dk.engineeringseries.databinding.ActivityQuestionBinding;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    ActivityQuestionBinding binding;
    private List<QuestionModel> list = new ArrayList<>();

    public int contDev, contRedes, contGeren, contTestes, contDados;

    private String[] dev = new String[]{"A - Desenvolvimento",
            "B - Desenvolvimento",
            "C - Desenvolvimento",
            "D - Desenvolvimento",
            "E - Desenvolvimento"};

    private String[] redes = new String[]{"A - REDES",
            "B - REDES",
            "C - REDES",
            "D - REDES",
            "E - REDES"};

    private String[] geren = new String[]{"A - GERENCIAMENTO DE PROJETOS",
            "B - GERENCIAMENTO DE PROJETOS",
            "C - GERENCIAMENTO DE PROJETOS",
            "D - GERENCIAMENTO DE PROJETOS",
            "E - GERENCIAMENTO DE PROJETOS"};

    private String[] testes = new String[]{"A - Testes",
            "B - Testes",
            "C - Testes",
            "D - Testes",
            "E - Testes"};

    private String[] dados = new String[]{"A - Análise de dados",
            "B - Análise de dados",
            "C - Análise de dados",
            "D - Análise de dados",
            "E - Análise de dados"};
    private int count = 0;
    private int position = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        String set = getIntent().getStringExtra("set");

        if (set.equals("Começar")){
            set2074();
        }

        for (int i = 0; i < 5; i++) {

            binding.optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswer((Button) view);
                }
            });
        }


        playAnimation(binding.question,0,list.get(position).getQuestion());

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.next.setEnabled(false);
                binding.next.setAlpha((float) 0.3);
                enableOption(true);
                position ++;
                if (position==list.size()){

                    Intent scoreInent = new Intent(QuestionActivity.this,ScoreActivity.class);
                    scoreInent.putExtra("score",score);
                    scoreInent.putExtra("total",list.size());
                    startActivity(scoreInent);
                    finish();
                    return;
                }
                count = 0;
                playAnimation(binding.question, 0, list.get(position).getQuestion());
            }
        });


    }

    private void set2074() {

        list.add(new QuestionModel("1.Questão 1", "A - REDES",
                "B - Desenvolvimento", "C - Análise de dados", "D - Testes", "E - GERENCIAMENTO DE PROJETOS", "B. "));
        list.add(new QuestionModel("2.Questão 2", "A - GERENCIAMENTO DE PROJETOS", "B - Testes",
                "C - Análise de dados", "D - REDES","E - Desenvolvimento",  ""));
        list.add(new QuestionModel("3.Questão 3", "A - REDES", "B - Desenvolvimento", "C - Testes",
                "D - GERENCIAMENTO DE PROJETOS","E - Análise de dados",  "A. "));
        list.add(new QuestionModel("4.Questão 4", "A - Análise de dados", "B - Desenvolvimento",
                "C - Testes", "D - GERENCIAMENTO DE PROJETOS","E - REDES",  ""));
        list.add(new QuestionModel("5.Questão 5", "A - Testes", "B - GERENCIAMENTO DE PROJETOS",
                "C - REDES", "D - Desenvolvimento","E - Análise de dados",  "B. "));
    }

    private void playAnimation(View view, int value, final String data) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                        if (value == 0 && count < 5) {
                            String option = "";
                            if (count == 0) {

                                option = list.get(position).getOptionA();
                            } else if (count == 1) {

                                option = list.get(position).getOptionB();
                            } else if (count == 2) {

                                option = list.get(position).getOptionC();

                            } else if (count == 3) {

                                option = list.get(position).getOptionD();

                            }else if (count == 4) {
                                option = list.get(position).getOptionE();
                            }

                            playAnimation(binding.optionContainer.getChildAt(count), 0, option);
                            count++;
                        }

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        if (value == 0) {

                            try {
                                ((TextView)view).setText(data);
                                binding.numberIndicator.setText(position+1+"/"+list.size());

                            } catch (Exception e) {
                                ((Button)view).setText(data);
                            }
                            view.setTag(data);
                            playAnimation(view, 1, data);
                        }
                    }
                    @Override
                    public void onAnimationCancel(Animator animator) {
                    }
                    @Override
                    public void onAnimationRepeat(Animator animator) {
                    }
                });

    }

    private void checkAnswer(Button selectedOption) {

        Contadores cont = new Contadores(contDev, contRedes, contGeren, contTestes, contDados);

        System.out.println("--------------------\n"+selectedOption.getText()+"\n--------------------");

        enableOption(false);

        binding.next.setEnabled(true);
        binding.next.setAlpha(1);

        selectedOption.setBackgroundResource(R.drawable.right_answ);

        for (String contar:dev) {
            if (contar.equals(selectedOption.getText())) {
                System.out.println("-----------DEV-------------");
                cont.somarDev();
            }
        }
        for (String contar:redes) {
            if(contar.equals(selectedOption.getText())){
                System.out.println("-----------REDES-------------");
                //contRedes++;
            }
        }

        for (String contar:geren) {
            if(contar.equals(selectedOption.getText())){
                System.out.println("-----------GERENCIAMENTO DE PROJETOS-------------");
              //  contGeren++;
            }
        }

        for (String contar:testes) {
            if(contar.equals(selectedOption.getText())){
                System.out.println("-----------TESTES-------------");
               // contTestes++;
            }
        }

        for (String contar:dados) {
            if(contar.equals(selectedOption.getText())){
                System.out.println("-----------ANÁLISE DE DADOS-------------");
                //contDados++;
            }
        }
        System.out.println("\nDEV = " + cont.getContDev());

//        System.out.println("\nDEV = " + contDev+"\n"
//                +"REDES = " + contRedes+"\n"
//                +"GEREN = " + contGeren+"\n"
//                +"TESTES = " + contTestes+"\n"
//                +"DADOS = " + contDados);

        //int f = Math.max(Math.max(Math.max(contDev,contRedes),Math.max(contGeren,contTestes)));

    }
    private void enableOption(boolean enable) {

        for (int i = 0; i < 5; i++) {

            binding.optionContainer.getChildAt(i).setEnabled(enable);

            if (enable){

                binding.optionContainer.getChildAt(i).setBackgroundResource(R.drawable.borda);
            }

        }

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
        builder.setMessage("Are you sure want to ext?");

        builder.setCancelable(false);

        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

            Intent intent = new Intent(QuestionActivity.this, SetsActivity.class);
            startActivity(intent);
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