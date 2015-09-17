/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.controladores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.asi.entidades.OrdenLoteMedicamento;

/**
 *
 * @author rgluis
 */
@Stateless
public class OrdenLoteMedicamentoFacade extends AbstractFacade<OrdenLoteMedicamento> {
    @PersistenceContext(unitName = "ClinicaMedicaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenLoteMedicamentoFacade() {
        super(OrdenLoteMedicamento.class);
    }
    
}
