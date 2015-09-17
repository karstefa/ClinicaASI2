/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.controladores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.asi.entidades.EstadoOrden;

/**
 *
 * @author rgluis
 */
@Stateless
public class EstadoOrdenFacade extends AbstractFacade<EstadoOrden> {
    @PersistenceContext(unitName = "ClinicaMedicaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoOrdenFacade() {
        super(EstadoOrden.class);
    }
    
}
