/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "CONSULTA_MEDICAMENTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "ConsultaMedicamento.findAll", query = "SELECT c FROM ConsultaMedicamento c"),
    @NamedQuery(name = "ConsultaMedicamento.findByIdConsulta", query = "SELECT c FROM ConsultaMedicamento c WHERE c.consultaMedicamentoPK.idConsulta = :idConsulta"),
    @NamedQuery(name = "ConsultaMedicamento.findByIdMedicamento", query = "SELECT c FROM ConsultaMedicamento c WHERE c.consultaMedicamentoPK.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "ConsultaMedicamento.findByCantidad", query = "SELECT c FROM ConsultaMedicamento c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "ConsultaMedicamento.findByValorFrecuencia", query = "SELECT c FROM ConsultaMedicamento c WHERE c.valorFrecuencia = :valorFrecuencia")})
public class ConsultaMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConsultaMedicamentoPK consultaMedicamentoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_FRECUENCIA", nullable = false)
    private int valorFrecuencia;
    @JoinColumn(name = "ID_MEDICAMENTO", referencedColumnName = "ID_MEDICAMENTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medicamento medicamento;
    @JoinColumn(name = "ID_FRECUENCIA", referencedColumnName = "ID_FRECUENCIA", nullable = false)
    @ManyToOne(optional = false)
    private Frecuencia idFrecuencia;
    @JoinColumn(name = "ID_CONSULTA", referencedColumnName = "ID_CONSULTA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Consulta consulta;

    public ConsultaMedicamento() {
    }

    public ConsultaMedicamento(ConsultaMedicamentoPK consultaMedicamentoPK) {
        this.consultaMedicamentoPK = consultaMedicamentoPK;
    }

    public ConsultaMedicamento(ConsultaMedicamentoPK consultaMedicamentoPK, int cantidad, int valorFrecuencia) {
        this.consultaMedicamentoPK = consultaMedicamentoPK;
        this.cantidad = cantidad;
        this.valorFrecuencia = valorFrecuencia;
    }

    public ConsultaMedicamento(int idConsulta, int idMedicamento) {
        this.consultaMedicamentoPK = new ConsultaMedicamentoPK(idConsulta, idMedicamento);
    }

    public ConsultaMedicamentoPK getConsultaMedicamentoPK() {
        return consultaMedicamentoPK;
    }

    public void setConsultaMedicamentoPK(ConsultaMedicamentoPK consultaMedicamentoPK) {
        this.consultaMedicamentoPK = consultaMedicamentoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorFrecuencia() {
        return valorFrecuencia;
    }

    public void setValorFrecuencia(int valorFrecuencia) {
        this.valorFrecuencia = valorFrecuencia;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Frecuencia getIdFrecuencia() {
        return idFrecuencia;
    }

    public void setIdFrecuencia(Frecuencia idFrecuencia) {
        this.idFrecuencia = idFrecuencia;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultaMedicamentoPK != null ? consultaMedicamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaMedicamento)) {
            return false;
        }
        ConsultaMedicamento other = (ConsultaMedicamento) object;
        if ((this.consultaMedicamentoPK == null && other.consultaMedicamentoPK != null) || (this.consultaMedicamentoPK != null && !this.consultaMedicamentoPK.equals(other.consultaMedicamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.ConsultaMedicamento[ consultaMedicamentoPK=" + consultaMedicamentoPK + " ]";
    }
    
}
