/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poabus.services;

import java.util.List;
import poabus.data.PoaBusContext;
import poabus.domain.IParadasService;
import poabus.domain.Parada;

/**
 *
 * @author henri
 */
public class ParadasService implements IParadasService {
    
    private final PoaBusContext _context;

    public ParadasService() {
        this._context = new PoaBusContext();
    }
       
    public List<Parada> getParadasNearLocation(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Parada> getAllParadas() {
        return _context.GetAllParadas();
    }  
    
}
