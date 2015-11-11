/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poabus.domain;

import java.util.List;

/**
 *
 * @author henri
 */
public interface IParadasService {
    List<Parada> getParadasNearLocation(double x, double y);
    public List<Parada> getAllParadas();    
}
