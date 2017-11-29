package rr;
/*classe para definir informações sobre os processos. São elas: Tempo de chegada, Turnaround time, Burst Time e o seu tamanho.

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
public class RoundRobin {
    
    int [] temp;
    int [] tempTempoEspera;
    int commBT, k, tq;
    int[][] d;
    int btcache;
    
    void Iniciar( ){
        /*Calcula o tempo BT
        @return int BrustTime */
        for (int i = 0; i < d.length; i++) {
            int bt  = d[i][1];
            if( bt > 0){
                if( bt <= tq){
                    temp[i] = btcache+bt;
                    btcache = temp[i];
                    k += bt;
                    bt -= bt;
                    
                }
                else{
                    temp[i] = btcache+tq;
                    btcache = temp[i];
                    bt -= tq;
                    k += tq;
                }
                
                d[i][1] = bt;
                
            }
        }
        /*Esta chamada Busca a lista de processos e imprime na tela os tempos medio e e execução.
         @return int - Tempo utilizado de CPU por Processo, int - Tempo de espera */
    }
    
    private void Mostrar(List<CPU> ListaProcessamento) {
        float mediaTempoDeExecucaoTotal = 0;
        float mediaTempoEspera = 0;
        int c = 1;
        System.out.println("ID Processo | Tempo de execução total | Tempo de espera ");
        Object[] processamento = ListaProcessamento.toArray();
        for (int i : temp) {
            CPU processamento1 = (CPU) processamento[c-1];
            System.out.println( "    " + c + "       |     " + i +"           |   "+(i-processamento1.getTempoCPUProcesso()));
            System.out.println("----------------------------------------");
            mediaTempoDeExecucaoTotal += i;
            mediaTempoEspera += (i-processamento1.getTempoCPUProcesso());
            c++;
        }
        System.out.println("===============================================");
        System.out.println( "Média do tempo de espera = " + mediaTempoEspera/temp.length);
        System.out.println("===============================================");
        System.out.println( "Média do tempo de execução total = " + mediaTempoDeExecucaoTotal/temp.length);
        System.out.println("===============================================");
    }
    /*Essa função gerencia o uso de CPU através do contador dos quantuns
      @return int Tempo de quantum  de cada processo*/
    public void Executar(List<CPU> ListaProcessamento, int quantum) {
        
        int pcount = ListaProcessamento.size();
        d = new int[pcount][2];
        
        temp = new int[pcount];
        int count = 0;
        for(CPU processamento:ListaProcessamento){
            d[count][0] = count;
            
            int m = processamento.getTempoCPUProcesso();
            d[count][1] = m;
            
            commBT += m;
            count++;
        }
        
        tq = quantum;
        
    }
}
