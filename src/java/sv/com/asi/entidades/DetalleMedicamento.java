/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "DETALLE_MEDICAMENTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "DetalleMedicamento.findAll", query = "SELECT d FROM DetalleMedicamento d"),
    @NamedQuery(name = "DetalleMedicamento.findByIdDetalleMedicamento", query = "SELECT d FROM DetalleMedicamento d WHERE d.idDetalleMedicamento = :idDetalleMedicamento"),
    @NamedQuery(name = "DetalleMedicamento.findByFechaRecepcion", query = "SELECT d FROM DetalleMedicamento d WHERE d.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "DetalleMedicamento.findByUsuarioActualiza", query = "SELECT d FROM DetalleMedicamento d WHERE d.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "DetalleMedicamento.findByFechaFabricacion", query = "SELECT d FROM DetalleMedicamento d WHERE d.fechaFabricacion = :fechaFabricacion"),
    @NamedQuery(name = "DetalleMedicamento.findByFechaVencimiento", query = "SELECT d FROM DetalleMedicamento d WHERE d.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "DetalleMedicamento.findByCodigo", query = "SELECT d FROM DetalleMedicamento d WHERE d.codigo = :codigo")})
public class DetalleMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_MEDICAMENTO", nullable = false)
    private Integer idDetalleMedicamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_RECEPCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FABRICACION", nullable = false)
    private long fechaFabricacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CODIGO", nullable = false, length = 100)
    private String codigo;
    @JoinColumn(name = "ID_LOTE_MEDICAMENTO", referencedColumnName = "ID_LOTE_MEDICAMENTO", nullable = false)
    @ManyToOne(optional = false)
    private LoteMedicamento idLoteMedicamento;
    @JoinColumn(name = "ID_ESTADO_DETALLE_MEDICAMENTO", referencedColumnName = "ID_ESTADO_DETALLE_MEDICAMENTO", nullable = false)
    @ManyToOne(optional = false)
    private EstadoDetalleMedicamento idEstadoDetalleMedicamento;

    public DetalleMedicamento() {
    }

    public DetalleMedicamento(Integer idDetalleMedicamento) {
        this.idDetalleMedicamento = idDetalleMedicamento;
    }

    public DetalleMedicamento(Integer idDetalleMedicamento, Date fechaRecepcion, String usuarioActualiza, long fechaFabricacion, Date fechaVencimiento, String codigo) {
        this.idDetalleMedicamento = idDetalleMedicamento;
        this.fechaRecepcion = fechaRecepcion;
        this.usuarioActualiza = usuarioActualiza;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.codigo = codigo;
    }

    public Integer getIdDetalleMedicamento() {
        return idDetalleMedicamento;
    }

    public void setIdDetalleMedicamento(Integer idDetalleMedicamento) {
        this.idDetalleMedicamento = idDetalleMedicamento;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public long getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(long fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LoteMedicamento getIdLoteMedicamento() {
        return idLoteMedicamento;
    }

    public void setIdLoteMedicamento(LoteMedicamento idLoteMedicamento) {
        this.idLoteMedicamento = idLoteMedicamento;
    }

    public EstadoDetalleMedicamento getIdEstadoDetalleMedicamento() {
        return idEstadoDetalleMedicamento;
    }

    public void setIdEstadoDetalleMedicamento(EstadoDetalleMedicamento idEstadoDetalleMedicamento) {
        this.idEstadoDetalleMedicamento = idEstadoDetalleMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleMedicamento != null ? idDetalleMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMedicamento)) {
            return false;
        }
        DetalleMedicamento other = (DetalleMedicamento) object;
        if ((this.idDetalleMedicamento == null && other.idDetalleMedicamento != null) || (this.idDetalleMedicamento != null && !this.idDetalleMedicamento.equals(other.idDetalleMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.DetalleMedicamento[ idDetalleMedicamento=" + idDetalleMedicamento + " ]";
    }
    
}
