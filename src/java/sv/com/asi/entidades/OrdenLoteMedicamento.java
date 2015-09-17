/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "ORDEN_LOTE_MEDICAMENTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "OrdenLoteMedicamento.findAll", query = "SELECT o FROM OrdenLoteMedicamento o"),
    @NamedQuery(name = "OrdenLoteMedicamento.findByIdOrdenLoteMedicamento", query = "SELECT o FROM OrdenLoteMedicamento o WHERE o.idOrdenLoteMedicamento = :idOrdenLoteMedicamento"),
    @NamedQuery(name = "OrdenLoteMedicamento.findByCantidadSolicitar", query = "SELECT o FROM OrdenLoteMedicamento o WHERE o.cantidadSolicitar = :cantidadSolicitar")})
public class OrdenLoteMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEN_LOTE_MEDICAMENTO", nullable = false)
    private Integer idOrdenLoteMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "CANTIDAD_SOLICITAR", nullable = false, length = 9)
    private String cantidadSolicitar;
    @JoinColumn(name = "ID_MEDICAMENTO", referencedColumnName = "ID_MEDICAMENTO", nullable = false)
    @ManyToOne(optional = false)
    private Medicamento idMedicamento;
    @JoinColumn(name = "ID_ESTADO_ORDEN", referencedColumnName = "ID_ESTADO_ORDEN", nullable = false)
    @ManyToOne(optional = false)
    private EstadoOrden idEstadoOrden;

    public OrdenLoteMedicamento() {
    }

    public OrdenLoteMedicamento(Integer idOrdenLoteMedicamento) {
        this.idOrdenLoteMedicamento = idOrdenLoteMedicamento;
    }

    public OrdenLoteMedicamento(Integer idOrdenLoteMedicamento, String cantidadSolicitar) {
        this.idOrdenLoteMedicamento = idOrdenLoteMedicamento;
        this.cantidadSolicitar = cantidadSolicitar;
    }

    public Integer getIdOrdenLoteMedicamento() {
        return idOrdenLoteMedicamento;
    }

    public void setIdOrdenLoteMedicamento(Integer idOrdenLoteMedicamento) {
        this.idOrdenLoteMedicamento = idOrdenLoteMedicamento;
    }

    public String getCantidadSolicitar() {
        return cantidadSolicitar;
    }

    public void setCantidadSolicitar(String cantidadSolicitar) {
        this.cantidadSolicitar = cantidadSolicitar;
    }

    public Medicamento getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamento idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public EstadoOrden getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(EstadoOrden idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenLoteMedicamento != null ? idOrdenLoteMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenLoteMedicamento)) {
            return false;
        }
        OrdenLoteMedicamento other = (OrdenLoteMedicamento) object;
        if ((this.idOrdenLoteMedicamento == null && other.idOrdenLoteMedicamento != null) || (this.idOrdenLoteMedicamento != null && !this.idOrdenLoteMedicamento.equals(other.idOrdenLoteMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.OrdenLoteMedicamento[ idOrdenLoteMedicamento=" + idOrdenLoteMedicamento + " ]";
    }
    
}
