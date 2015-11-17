package poabus.domain;

import java.util.ArrayList;
import java.util.List;

public class Linha {
    private int id;
    private String nome;
    private List<Parada> paradas;

    public Linha() {
        this.paradas = new ArrayList<Parada>();
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(List<Parada> paradas) {
        this.paradas = paradas;
    }
    
    public boolean hasParada(Parada parada){
        for(Parada p : paradas){
            if(p == parada){ return true; }
        }        
        return false;
    }

    @Override
    public String toString() {
        return nome;
    }            
}
