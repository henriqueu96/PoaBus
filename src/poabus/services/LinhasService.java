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
        List<Linha> linhasTodas = _context.GetAllLinhas();
        List<Linha> linhasFinal = new ArrayList<Linha>();
        for(Linha l : linhasTodas){            
            if(l.getParadas().size() >= 1){
                linhasFinal.add(l);
            }
        }
        return linhasFinal;
    }

    public List<Linha> getLinhasPassamParadas(List<Parada> paradas) {     
        /*        
        List<Linha> linhasTodas = new ArrayList<Linha>();
        List<Linha> linhasFinal = new ArrayList<Linha>();
        
        //Adicionando TODAS paradas ao array
        for(Parada p : paradas){
            linhasTodas.addAll(p.getLinhas());
        }        
        
        // Para cada parada do array pegue o elemento.
        for(int i = 0; i < linhasTodas.size()-1; i++){            
            int cont = 0;
            Linha l = linhasTodas.get(i);
                // Para cada linha do array pegue o elemento e compare com o anterior
                for(int j = 0; j < linhasTodas.size()-1; j++){                    
                    Linha proximaLinha = linhasTodas.get(i+1);
                    
                    // Se os Id são iguais, icremente o contador do elemento em questão
                    if(l.getId() == proximaLinha.getId()){
                        cont++;                        
                    }
                }
             
            // Se o elemento tem o contador igual ao numero de paradas passado, então ele passa em todas as paradas.
            if(cont == paradas.size()){
                linhasFinal.add(l);
            }
        }                
        return linhasFinal;
        
        */
        return null;
    }
    
}
