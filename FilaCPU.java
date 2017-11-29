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



public abstract class FilaCPU {
    protected List<CPU> Processamento;
    protected ArrayList<CPU> FilaProcesso;
   
    public FilaCPU(List<CPU> processamento) {
        super();
        Processamento = processamento;
    }
    
    public abstract void run();
    // update current job by 1 tick
    // check if the job queue might need to be changed.
    // check for jobs to add to the queue
}