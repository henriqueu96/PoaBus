package poabus.domain;

import java.util.ArrayList;
import java.util.List;

public class Parada {
    private int id;
    private double longitude;
    private double latitude;
    List<Linha> linhas;

    public Parada() {
        this.linhas = new ArrayList<Linha>();
    }
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Linha> getLinhas() {
        return linhas;
    }
    
    public boolean hasLinha(Linha linha){
        for(Linha l : linhas){
            if(l == linha){
                return true;
            }
        }
        return false;
    }

    public void setLinhas(List<Linha> linhas) {
        this.linhas = linhas;
    }              

    @Override
    public String toString() {
        return "Parada{" + "id=" + id + '}';
    }
    
    
}
