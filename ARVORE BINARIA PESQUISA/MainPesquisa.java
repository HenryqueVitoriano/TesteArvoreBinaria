import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPesquisa {
    public static void main(String[] args) throws FileNotFoundException {
        List<Long> tempoMedioTestes = new ArrayList<>();
//        //TESTE01
        long tempoTeste1 = calculaTempo("teste01.txt");
        tempoMedioTestes.add(tempoTeste1);
        System.out.println("TEMPO DO Teste 1: " + tempoTeste1 + " milisegundos \n");

//        //TESTE02
        long tempoTeste2 = calculaTempo("teste02.txt");
        tempoMedioTestes.add(tempoTeste2);
        System.out.println("TEMPO DO Teste 2: " + tempoTeste2 + " milisegundos \n");

//        //TESTE03
        long tempoTeste3 = calculaTempo("teste03.txt");
        tempoMedioTestes.add(tempoTeste3);
        System.out.println("TEMPO DO Teste 3: " + tempoTeste3 + " milisegundos \n");

//        //TESTE04
        long tempoTeste4 = calculaTempo("teste04.txt");
        tempoMedioTestes.add(tempoTeste4);
        System.out.println("TEMPO DO Teste 4: " + tempoTeste4 + " milisegundos \n");

//        //TESTE05
        long tempoTeste5 = calculaTempo("teste05.txt");
        tempoMedioTestes.add(tempoTeste5);
        System.out.println("TEMPO DO Teste 5: " + tempoTeste5 + " milisegundos \n");

//        //TESTE06
        long tempoTeste6 = calculaTempo("teste06.txt");
        tempoMedioTestes.add(tempoTeste6);
        System.out.println("TEMPO DO Teste 6: " + tempoTeste6 + " milisegundos \n");

//        //TESTE07
        long tempoTeste7 = calculaTempo("teste07.txt");
        tempoMedioTestes.add(tempoTeste7);
        System.out.println("TEMPO DO Teste 7: " + tempoTeste7 + " milisegundos \n");


        long tempoMedio = 0;
        for (long tempo: tempoMedioTestes){
            tempoMedio += tempo;
        }

        System.out.println("TEMPO MÉDIO DOS TESTES: " + tempoMedio / 7 + " MILISEGUNDOS");


    }

    public static Long calculaTempo(String URL) throws FileNotFoundException {
        BTree arvore = new BTree();
        StringBuilder url = new StringBuilder("E:\\Java Faculdade\\4º SEMESTRE\\ESTRUTURA DE DADOS\\EXERCICIOS_ LISTA 1\\InstrumentosDois\\");
        url.append(URL);
        String linha = "";

        File arquivo = new File(String.valueOf(url));
        Scanner sc =  new Scanner(arquivo);

        long tempoInicial =  System.nanoTime();
        long tempoMedio = 0;
        double contador = 0.0;

        try{
            while (sc.hasNext()){
                linha = sc.nextLine();

                long tempoInicialNo = System.nanoTime();
                arvore.add(Long.parseLong(linha));
                long tempoFinalNo = System.nanoTime();

                double aux = tempoFinalNo - tempoInicialNo;
                tempoMedio += (long) aux;
                contador++;

            }
        }catch (StackOverflowError error){
            System.out.println(URL  + " PAROU NA LINHA: " + linha);
        }


        long tempoFinal = System.nanoTime();
        double tempoMedioFinal = ((tempoMedio / contador));
        System.out.printf("TEMPO MEDIO POR NÓ: %.10f MILISEGUNDOS " , tempoMedioFinal / 1000000);
        System.out.println();

        long profundidade;

        try{
            profundidade = arvore.encontrarProfundidade(Long.parseLong(linha));
            System.out.println("PROFUNDIDADE MAXIMA: "  + profundidade);
        }catch (StackOverflowError error){
            System.out.println("NÃO FOI POSSIVEL ACHAR A PROFUNDIDADE " );
        }


        return (tempoFinal - tempoInicial) / 1000000;
    }

}