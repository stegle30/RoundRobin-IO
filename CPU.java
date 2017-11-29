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
public class CPU {
    private int id, DefinirTempo, TEMPOCPU, TempoRestanteCPU;
    
    private int TempoInicio = 0, TempoFinal = 0;
    
    /*Esta sessão executa os processos e determina os 
        tempos através dos seus métodos*/
    public int TempoTerminoProcesso;
    public int TempoChegadaProcesso;
    public int TempoEspera;
    public int TempoExeTotal;
    public int evento;
    private int TempoChegada,TempoCPUProcesso,IdProcesso;
   
    /*construtor da classe CPU inicializando os atributos.
    
    */ 
    public CPU(int id, int DefinirTempo, int TEMPOCPU, int evento) {
        super();
        this.id = id;
        this.DefinirTempo = DefinirTempo;
        this.TEMPOCPU = TEMPOCPU;
        this.TempoRestanteCPU = TEMPOCPU;
        this.evento = evento;
    }
    
    public CPU(int IdProcesso, int TempoChegada, int TempoCPU) {
        
        this.IdProcesso = IdProcesso;
        this.TempoChegada = TempoChegada;
        this.TempoCPUProcesso = TempoCPUProcesso;
        
    }
    /*
    Método para iniciar o contador de tempo do código
    @return int - IDprocesso, int - TempoFinal, int - Tempo do Processo, int Tempo de Chegada Processo*/
    public void start(int TempoSistema) {
        TempoInicio = TempoSistema;
    }
    
    public void tick(int sysTime) {
        TempoRestanteCPU --;
        if (TempoRestanteCPU <= 0){
            TempoFinal = sysTime;
        }
        
    }
    
    /*
    Métodos get e sets acessores dos atributos da classe "CPU".
    */
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getDefinirTempo() {
        return DefinirTempo;
    }
    
    public void setDefinirTempo(int DefinirTempo) {
        this.DefinirTempo = DefinirTempo;
    }
    
    public int getTEMPOCPU() {
        return TEMPOCPU;
    }
    
    public void setTEMPOCPU(int TEMPOCPU) {
        TEMPOCPU = TEMPOCPU;
    }
    
    public int getTempoRestanteCPU() {
        return TempoRestanteCPU;
    }
    
    public void setTempoRestanteCPU(int TempoRestanteCPU) {
        TempoRestanteCPU = TempoRestanteCPU;
    }
    
    public int getTempoInicio() {
        return TempoInicio;
    }
    
    public void setTempoInicio(int TempoInicio) {
        this.TempoInicio = TempoInicio;
    }
    
    public int getTempoFinal() {
        return TempoFinal;
    }
    
    public void setTempoFinal(int TempoFinal) {
        this.TempoFinal = TempoFinal;
    }
    
    public int getTempoChegada() {
        return TempoChegada;
    }
    
    public void setTempoChegada(int TempoChegada) {
        this.TempoChegada = TempoChegada;
    }
    
    public int getTempoCPUProcesso() {
        return TempoCPUProcesso;
    }
    
    public void setTempoCPUProcesso(int TempoCPU) {
        this.TempoCPUProcesso = TempoCPUProcesso;
    }
    
    public int getIdProcesso() {
        return IdProcesso;
    }
    
    public void setIdProcesso(int IdProcesso) {
        this.IdProcesso = IdProcesso;
    }
    
    
}    
