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
         
    public ArrayList<Linha> GetAllLinhas() {
        return linhas;          
    }
    
    public Linha GetLinhaById(int id) {
        for(Linha lin : linhas){
            if(lin.getId() == id){ return lin; }
        }       
        return null;
    }
    
    public ArrayList<Parada> GetAllParadas() {
        return paradas;          
    }
    
    public Parada GetParadaById(int id) {
        for(Parada par : paradas){
            if(par.getId() == id){ return par; }
        }       
        return null;
    } 
}