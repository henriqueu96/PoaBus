package poabus.data;

import java.util.ArrayList;
import poabus.domain.Linha;
import poabus.domain.Parada;

public class PoaBusContext {    
    private final ArrayList<Parada> paradas;    
    private final ArrayList<Linha> linhas;
    
    public PoaBusContext(){
        paradas = new ArrayList<Parada>();
        linhas = new ArrayList<Linha>();
        LeitorDeArquivos.LerArquivos(paradas, linhas);
    }
         
    public ArrayList<Linha> getAllLinhas() {
        return linhas;          
    }
    
    public Linha getLinhaById(int id) {
        for(Linha lin : linhas){
            if(lin.getId() == id){ return lin; }
        }       
        return null;
    }
    
    public ArrayList<Parada> getAllParadas() {
        return paradas;          
    }
    
    public Parada getParadaById(int id) {
        for(Parada par : paradas){
            if(par.getId() == id){ return par; }
        }       
        return null;
    } 

    public void addLinha(Linha l) {
        linhas.add(l);
    }
}