package poabus.domain;

import java.util.List;

public interface ILinhasService {
    List<Linha> getAllLinhas();
    List<Linha> getLinhasPassamParadas(List<Parada> paradas);

    public List<Linha> getTodasLinhasPassamParadas(List<Parada> paradasSelecionadas);

    public void addLinha(String linhaName, List<Parada> paradasDaLinha, char lotacao);

    public List<Linha> getAllLotacoes();
}
