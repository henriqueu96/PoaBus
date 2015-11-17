package poabus.services;

import java.util.ArrayList;
import java.util.List;
import poabus.data.PoaBusContext;
import poabus.domain.IParadasService;
import poabus.domain.Parada;

public class ParadasService implements IParadasService {

    private final PoaBusContext _context;

    public ParadasService() {
        this._context = new PoaBusContext();
    }

    public List<Parada> getAllParadas() {
        return _context.GetAllParadas();
    }

    public Parada getParadaNearLocation(double x, double y) {
        List<Parada> todasParadas = _context.GetAllParadas();
        Parada paradaProxima = null;
        double menor = Double.MAX_VALUE;
        for(Parada p : todasParadas){
            double valor = AlgoritmosGeograficos.haversine(y, x, p.getLatitude(), p.getLongitude());
            if(valor < menor){
                paradaProxima = p;
                menor = valor;
            }            
        }
        return paradaProxima;
    }

    public List<Parada> getParadasByRaio(double raio, double latitude, double longitude) {
        List<Parada> paradas = _context.GetAllParadas();
        List<Parada> resultado = new ArrayList<Parada>();
        for(Parada p : paradas){
            double distancia = AlgoritmosGeograficos.haversine(p.getLatitude(), p.getLongitude(), latitude, longitude);
            if(distancia <= raio){
                resultado.add(p);
            }                
        }
        return resultado;
    }
}
