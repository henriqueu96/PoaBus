package poabus.services;

import java.util.ArrayList;
import java.util.List;
import poabus.data.PoaBusContext;
import poabus.domain.ILinhasService;
import poabus.domain.Linha;
import poabus.domain.Parada;

public class LinhasService implements ILinhasService {
    
    private final PoaBusContext _context;

    public LinhasService() {
        this._context = new PoaBusContext();
    }
           
    public List<Linha> getAllLinhas() {
        List<Linha> linhasTodas = _context.getAllLinhas();
        List<Linha> linhasFinal = new ArrayList<Linha>();
        for(Linha l : linhasTodas){            
            if(l.getParadas().size() >= 1){
                linhasFinal.add(l);
            }
        }
        return linhasFinal;
    }

    public List<Linha> getLinhasPassamParadas(List<Parada> paradas) {                     
        List<Linha> todasLinhas = new ArrayList<Linha>();
        List<Linha> finalLinhas = new ArrayList<Linha>();
                
        for(Parada p : paradas){            
            todasLinhas.addAll(p.getLinhas());
        }
        
        for(Linha l : todasLinhas){
            int cont = 0;
            for(Parada p : paradas){
                if(l.hasParada(p)){
                    cont++;
                }
            }
            if(cont == paradas.size()){
                if(!finalLinhas.contains(l)){                    
                    finalLinhas.add(l);
                }                
            }
        }                      
              
        return finalLinhas;
    }

    public List<Linha> getTodasLinhasPassamParadas(List<Parada> paradas) {
        List<Linha> linhasFinal = new ArrayList<Linha>();
        for(Parada p : paradas){
            for(Linha l : p.getLinhas()){
                if(!linhasFinal.contains(l)){
                    linhasFinal.add(l);
                }
            }            
        }        
        return linhasFinal;
    }           

    public void addLinha(String linhaName, List<Parada> paradasDaLinha, char lotacao) {
        Linha l = new Linha();
        l.setNome(linhaName);
        l.setTipo(lotacao);
        l.setParadas(paradasDaLinha);
        _context.addLinha(l);
    }

    public List<Linha> getAllLotacoes() {
        List<Linha> lotacoes = new ArrayList<Linha>();
        for(Linha l : _context.getAllLinhas()){
            if(l.getTipo() == 'L'){
                lotacoes.add(l);
            }
        }
        return lotacoes;
    }
}
