package rr;
/*
Classe main para inicializar o código.

@author
Felipe Carvalho
Gabriel de Oliveira
Gabriel Oliveira Pimentel
Rafael Palomino
Lais Rodrigues
Vinicius Dias
Vitor Stegle

@version 1.0
@since release 1.0
*/ 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RR{
    
    public static void main(String[] args) {
        
        /*
        Objetos da classe "Scanner" que são criados para separar a entrada dos textos em blocos.
        @return String - leitura das linhas do arquivo*/
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        
        String NomeArquivo ;;
        int quantum=4;
        
        /*Nomedoarquivo = "arquivo.CSV"*/
        
        NomeArquivo = "Exercicio.CSV";
        
        
        NomeArquivo = sc.nextLine();
        
        if(args.length==3){
            quantum = new Integer(args[2]);
        }
        /*
        Chamada da classe "BufferedReader para abrir o arquivo .csv. O objeto "br" foi criado e apontado para null momentaneamente.
        */
        BufferedReader br = null;
        /*
        Estrutura de dados "try/catch" para carregar o arquivo .csv de algum lugar (no caso ele está localizado no desktop do usuário
        
        @return IdProcesso, TempoChegada e TempoCPU
        */
        try {
            
            String LinhaAtual;
            /*LocalDoArquivo*/
            br = new BufferedReader(new FileReader("%C:\\Users\\GabVal\\Desktop"+NomeArquivo));
            System.out.println("IdProcesso  TempoChegada  TempoCPU");
            
            List<CPU> ListaProcessamento = new ArrayList<CPU>();
            while ((LinhaAtual = br.readLine()) != null) {
                
                String a[] = LinhaAtual.split(",");
                int IdProcesso = new Integer(a[0]);
                int TempoChegada = new Integer(a[1]);
                int TempoCPU = new Integer(a[2]);
                
                CPU job = new CPU(IdProcesso,TempoChegada,TempoCPU);
                
                ListaProcessamento.add(job);
                
            System.out.println(IdProcesso+" "+ TempoChegada+" " + TempoCPU);
            }
            
                /*
            Novo objeto da classe "RoundRobin" que executa os processos na lista.
            @param ListaProcessamento - Começa a executar toda a lista de pronto (do primeiro para o último levando em conta o quantum).
            @param quantum - estupula o quantum do Round Robin.
            */
                RoundRobin roundRobin = new RoundRobin(); 
                roundRobin.Executar(ListaProcessamento,quantum);
                
            
            } catch (IOException e) {
            e.printStackTrace();
            } finally {
            try {
                if (br != null)br.close();
                } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }   
}

