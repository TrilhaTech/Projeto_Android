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

    public int contDev = 1, contRedes = 1, contGeren = 1, contTestes = 1, contDados = 1;

    private String[] dev = new String[]{"C - Resolução/solução de problemas",
            "A - Tento acessar o sistema e solucionar o problema rapidamente",
            "B - Corajoso",
            "B - Jogar vídeo games",
            "D - intelij",
            "A - Lógica e Raciocínio",
            "D - Proponho a melhor solução",
            "C - Priorizo a entrega",
            "E - Prefere atividades práticas"};

    private String[] redes = new String[]{"D - Prefere atividades teóricas",
            "A - Internet/informação",
            "C - Pesquiso em vídeos/tutoriais alguma solução",
            "A - Estudioso",
            "C - Ficar nas redes sociais",
            "B - Cisco",
            "D - Comunicação",
            "E - Pesquiso recursos para a solução",
            "D - Busco ser eficiente "};

    private String[] geren = new String[]{"B - Liderança/organização",
            "E - Pergunto pra todos da casa se notaram alguma coisa ou conseguem ajudar",
            "D - Organizado",
            "E - Estar com as pessoas que eu gosto",
            "E - trello",
            "C - Networking",
            "C - Me comprometo a ajudar",
            "E - Programo melhor minha rotina",
            "C - Tento ajudar as pessoas"};

    private String[] testes = new String[]{"E - Segurança/analise",
            "D - Ligo pra assistência técnica",
            "C - Cuidadoso",
            "D - Organizar meus documentos/tarefas",
            "C - Cucumber",
            "E - Qualidade",
            "B - Busco os postos de melhoras para a resolução",
            "A - Priorizo a qualidade",
            "B - Organizo minhas tarefas"};

    private String[] dados = new String[]{"D - Dados/gráficos",
            "B - Tento descobrir o motivo e reporto",
            "E - Analítico",
            "A - Navego pela internet descobrindo novos aplicativos/sites",
            "A - Power BI",
            "B - Prevenção de riscos",
            "A - Analiso os pós e contras",
            "B - Não entro em pânico",
            "A - É um bom ouvinte"};
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
            questoes();
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
                    scoreInent.putExtra("total",list.size());

                    if(maiorPontuacao() == 1){
                        scoreInent.putExtra("dev", "dev");

                    }
                    else if(maiorPontuacao() == 2){
                        scoreInent.putExtra("redes", "redes");

                    }
                    else if(maiorPontuacao() == 3){
                        scoreInent.putExtra("geren", "geren");

                    }
                    else if(maiorPontuacao() == 4){
                        scoreInent.putExtra("testes", "testes");

                    }
                    else if(maiorPontuacao() == 5){
                        scoreInent.putExtra("dados", "dados");

                    }
                    startActivity(scoreInent);
                    finish();
                    return;
                }
                count = 0;
                playAnimation(binding.question, 0, list.get(position).getQuestion());
            }
        });


    }

    private void questoes() {

        list.add(new QuestionModel("1) Eu gosto de trabalhar com:",
                "A - Internet/informação",
                "B - Liderança/organização",
                "C - Resolução/solução de problemas",
                "D - Dados/gráficos",
                "E - Segurança/analise",
                ""));

        list.add(new QuestionModel("2) Quando minha internet cai, eu:",
                "A - Tento acessar o sistema e solucionar o problema rapidamente",
                "B - Tento descobrir o motivo e reporto",
                "C - Pesquiso em vídeos/tutoriais alguma solução",
                "D - Ligo pra assistência técnica",
                "E - Pergunto pra todos da casa se notaram alguma coisa ou conseguem ajudar",
                ""));

        list.add(new QuestionModel("3) As pessoas te definem como:",
                "A - Estudioso",
                "B - Corajoso",
                "C - Cuidadoso",
                "D - Organizado",
                "E - Analítico",
                ""));

        list.add(new QuestionModel("4) No meu tempo livre eu gosto de:",
                "A - Navego pela internet descobrindo novos aplicativos/sites",
                "B - Jogar vídeo games",
                "C - Ficar nas redes sociais",
                "D - Organizar meus documentos/tarefas",
                "E - Estar com as pessoas que eu gosto",
                ""));

        list.add(new QuestionModel("5) Qual a ferramenta que você tem maior facilidade de utilizar?",
                "A - Power BI",
                "B - Cisco",
                "C - Cucumber",
                "D - intelij",
                "E - trello",
                ""));

        list.add(new QuestionModel("6) O que você mais considera importante no mercado de trabalho?",
                "A - Lógica e Raciocínio",
                "B - Prevenção de riscos",
                "C - Networking",
                "D - Comunicação",
                "E - Qualidade",
                ""));

        list.add(new QuestionModel("7) Quando te pedem ajuda eu:",
                "A - Analiso os pós e contras",
                "B - Busco os postos de melhoras para a resolução",
                "C - Me comprometo a ajudar",
                "D - Proponho a melhor solução",
                "E - Pesquiso recursos para a solução",
                ""));

        list.add(new QuestionModel("8) Como você age sobre pressão:",
                "A - Priorizo a qualidade",
                "B - Não entro em pânico",
                "C - Priorizo a entrega",
                "D - Busco ser eficiente",
                "E - Programo melhor minha rotina",
                ""));

        list.add(new QuestionModel("9) Na sala de aula, você:",
                "A - É um bom ouvinte",
                "B - Organizo minhas tarefas",
                "C - Tento ajudar as pessoas",
                "D - Prefere atividades teóricas",
                "E - Prefere atividades práticas",
                ""));
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

        for (String contar1 : dev) {
            for (String contar2 : redes) {
                for (String contar3 : geren) {
                    for (String contar4 : testes) {
                        for (String contar5 : dados) {
                            if (contar1.equals(selectedOption.getText())) {
//                                System.out.println("-----------DEV-------------");
                                contDev++;
                            } else if (contar2.equals(selectedOption.getText())) {
//                                System.out.println("-----------REDES-------------");
                                contRedes++;
                            } else if (contar3.equals(selectedOption.getText())) {
//                                System.out.println("-----------GERENCIAMENTO DE PROJETOS-------------");
                                contGeren++;
                            } else if (contar4.equals(selectedOption.getText())) {
//                                System.out.println("-----------TESTES-------------");
                                contTestes++;
                            } else if (contar5.equals(selectedOption.getText())) {
//                                System.out.println("-----------ANÁLISE DE DADOS-------------");
                                contDados++;
                            }

                        }

                    }

                }
            }
        }

       System.out.println("\nDEV = " + contDev+"\n"
                +"REDES = " + contRedes+"\n"
                +"GEREN = " + contGeren+"\n"
                +"TESTES = " + contTestes+"\n"
                +"DADOS = " + contDados);

        if(maiorPontuacao() == 1){
            System.out.println("\nDev é o maior");
        }
        else if(maiorPontuacao() == 2){
            System.out.println("\nRedes é o maior");
        }
        else if(maiorPontuacao() == 3){
            System.out.println("\nGeren é o maior");
        }
        else if(maiorPontuacao() == 4){
            System.out.println("\nTestes é o maior");
        }
        else if(maiorPontuacao() == 5){
            System.out.println("\nDados é o maior");
        }

    }
    public int maiorPontuacao(){
        int maior = contDev;
        maior = Math.max(maior, contRedes);
        maior = Math.max(maior, contGeren);
        maior = Math.max(maior, contTestes);
        maior = Math.max(maior, contDados);

        if(maior == contRedes){
            return 2;
        } else if(maior == contGeren){
            return 3;
        }else if(maior == contTestes){
            return 4;
        }else if(maior == contDados){
            return 5;
        }
        return 1;
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
        builder.setMessage("Você quer sair?");

        builder.setCancelable(false);

        builder.setPositiveButton("Sim", (DialogInterface.OnClickListener) (dialog, which) -> {

            Intent intent = new Intent(QuestionActivity.this, SetsActivity.class);
            startActivity(intent);
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