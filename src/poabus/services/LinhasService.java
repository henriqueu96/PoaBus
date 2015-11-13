package poabus.services;

import java.util.ArrayList;
import java.util.List;
import poabus.data.PoaBusContext;
import poabus.domain.ILinhasService;
import poabus.domain.Linha;

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
    
}
