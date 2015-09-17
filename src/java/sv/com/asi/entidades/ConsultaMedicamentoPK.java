/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rgluis
 */
@Embeddable
public class ConsultaMedicamentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONSULTA", nullable = false)
    private int idConsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MEDICAMENTO", nullable = false)
    private int idMedicamento;

    public ConsultaMedicamentoPK() {
    }

    public ConsultaMedicamentoPK(int idConsulta, int idMedicamento) {
        this.idConsulta = idConsulta;
        this.idMedicamento = idMedicamento;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idConsulta;
        hash += (int) idMedicamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaMedicamentoPK)) {
            return false;
        }
        ConsultaMedicamentoPK other = (ConsultaMedicamentoPK) object;
        if (this.idConsulta != other.idConsulta) {
            return false;
        }
        if (this.idMedicamento != other.idMedicamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.ConsultaMedicamentoPK[ idConsulta=" + idConsulta + ", idMedicamento=" + idMedicamento + " ]";
    }
    
}
