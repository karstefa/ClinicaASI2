/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.controladores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.asi.entidades.HorarioAtencion;

/**
 *
 * @author rgluis
 */
@Stateless
public class HorarioAtencionFacade extends AbstractFacade<HorarioAtencion> {
    @PersistenceContext(unitName = "ClinicaMedicaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioAtencionFacade() {
        super(HorarioAtencion.class);
    }
    
}
