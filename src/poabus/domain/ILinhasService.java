package poabus.domain;

import java.util.List;

public interface ILinhasService {
    List<Linha> getAllLinhas();
    List<Linha> getLinhasPassamParadas(List<Parada> paradas);
}
