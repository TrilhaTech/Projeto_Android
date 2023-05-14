package com.dk.engineeringseries.dataset;

import com.dk.engineeringseries.Modelss.Resultado;
import com.dk.engineeringseries.R;

import java.util.ArrayList;
import java.util.List;

public class ResultadoDataset {
    private static List<Resultado> lista;

    public static List<Resultado> getlista1(){
        lista = new ArrayList<>(5);
        lista.add(new Resultado("Desenvolvedor",
                "Front-end", "O desenvolvedor front-end é responsável pelo desenvolvimento da interface com o usuário. Trata-se da parte visível de um site ou aplicação, com a qual as pessoas podem interagir, visando a usuabiliadade e design.",
                "Back-end", "O desenvolvedor back-end é responsável pelo desenvolvimento da estrutura interna de uma aplicação. É a parte que recebe as requisições dos usuários, faz a comunicação com o banco de dados e devolve as informações." ,
                "Full-stack", "O desenvolvedor full-stack é aquele que trabalha tanto com o front-end quanto com o back-end. Portanto, envolve o fluxo completo da aplicação, desde a conexão com o banco de dados até a criação da interface gráfica.",
                R.mipmap.devdojo, "Dev Dojo", "Essa trilha irá te ajudar no inicio da sua carreira como dev",
                R.mipmap.loiane, "Loiane Groner", "Essa trilha irá te ajudar com as principais estruturas básicas",
                R.mipmap.guarana, "Gustavo Guanabara", "Essa trilha irá te ajudar a se tornar Full-stack",
                R.mipmap.guarana));
        return lista;
    }
    public static List<Resultado> getlista2(){
        lista = new ArrayList<>(5);
        lista.add(new Resultado("Redes",
                "Segurança de Redes", "Esse profissional é responsável por desenvolver projeto e manutenção de segurança da rede, incluindo a de hardwares e softwares de servidores.",
                "Analista de Suporte", "Esse profissional é responsável pela instalação e configuração de programas de antivírus, que fornecem proteção contra possíveis ataques de hackers.Além disso, trabalha na criação e manutenção de backup." ,
                "Dirigente de Redes", "Esse profissional é responsável por implantar e monitorar a rede de computadores. Ele administra servidores e redes de dados em ambiente Data Center, além de poder trabalhar na configuração da estrutura de redes.",
                R.mipmap.glako, "Glauko Carvalho", "Essa trilha irá te ajudar com fundamentos sobre redes",
                R.mipmap.hardware, "Hardware Redes Brasil", "Essa trilha irá te ajudar com seu inicio na prática em redes",
                R.mipmap.guanabara2, "Gustavo Guanabara", "Essa trilha irá te ajudar com redes de computadores",
                R.mipmap.guanabara2));        return lista;
    }
    public static List<Resultado> getlista3(){
        lista = new ArrayList<>(5);
        lista.add(new Resultado("Gerenciador de projetos",
                "Product Owner", "O Product Owner representa os interesses de todos os envolvidos (Stakeholders), define as funcionalidades do produto e prioriza os itens de Product Backlog.",
                "Agile coach", "A pessoa que atua como Agile Coach ajuda a treinar pessoas e times corporativos para que se adequem às metodologias ágeis, além de garantir que haja resultados efetivos desses métodos." ,
                "Scrum Master", "O Scrum Master é o responsável por garantir que o Time Scrum se oriente pelos valores e práticas do Scrum, otimizando a entrega do trabalho.",
                R.mipmap.moxie, "Moxie - Especialistas em Jira", "Essa trilha irá te ajudar no inicio da sua carreira com gestão",
                R.mipmap.alura, "Alura", "Essa trilha irá te ajudar com metodologias de gestões",
                R.mipmap.andriele, "Andriele Ribeiro", "Essa trilha irá te ajudar com sua carreira em gestão",
                R.mipmap.andriele));        return lista;
    }
    public static List<Resultado> getlista4(){
        lista = new ArrayList<>(5);
        lista.add(new Resultado("Tester/QA",
                "Testes Manuais", "O testador manual é responsável pela elaboração de testes e mapeamento de possibilidades dentro do sistema e respostas esperadas, também é responsável por garantir que o comportamento esteja sendo entregue ao cliente final.",
                "Automação de Testes", "O testador que desenvolve testes automatizados em front-end utiliza os testes mapeados para criar cenários em pipeline para que a rotina de testes dentro do sistema seja mais frequente e efetiva, checando as funcionalidades básicas e logicas desenvolvidas no front-end." ,
                "Automação de Testes", "O testador que desenvolve testes automatizados de back-end, pode realizar testes de carga, também checa as funcionalidades permitidas pelo contrato e que são tratadas pelo back-end, tentando até mesmo fazer testes que envolvam quebrar o sistema para possíveis melhoras.",
                R.mipmap.qalizando, "QAlizando", "Essa trilha irá te ajudar no inicio da sua carreira como Tester",
                R.mipmap.dio, "DIO", "Essa trilha irá te ajudar a se desenvolver como Q.A",
                R.mipmap.fontetv, "Código Fonte TV", "Essa trilha irá te ajudar como se tornar um otimo analista",
                R.mipmap.fontetv));        return lista;
    }
    public static List<Resultado> getlista5(){
        lista = new ArrayList<>(5);
        lista.add(new Resultado("Analísta de dados",
                "Analísta de Dados", "O Analista de Dados, analisa os elementos com um olhar voltado para o presente, ou seja, para as soluções ou respostas que eles podem proporcionar.",
                "Cientista de Dados", "Os cientistas de dados projetam modelos e mecanismos de aprendizado utilizando técnicas matemáticas que visam encontrar soluções para os desafios do negócio." ,
                "Engenheiro de Dados", "É responsável por criar e manter a base de dados. São peças-chave para desenvolver algoritmos para transformar dados brutos em informações de qualidade.",
                R.mipmap.stack, "Stack", "Essa trilha irá te ajudar no inicio em Data Science",
                R.mipmap.analitica, "Carreira Analitica", "Essa trilha irá te ajudar com programação em dados",
                R.mipmap.dinamica, "Programação Dinâmica", "Essa trilha irá te ajudar com seus primeiros passos em dados",
                R.mipmap.dinamica));        return lista;
    }
}
