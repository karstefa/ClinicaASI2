/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "DETALLE_FACTURA", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIdDetalleFactura", query = "SELECT d FROM DetalleFactura d WHERE d.idDetalleFactura = :idDetalleFactura"),
    @NamedQuery(name = "DetalleFactura.findByIdFactura", query = "SELECT d FROM DetalleFactura d WHERE d.idFactura = :idFactura"),
    @NamedQuery(name = "DetalleFactura.findByIdDetalleMedicamento", query = "SELECT d FROM DetalleFactura d WHERE d.idDetalleMedicamento = :idDetalleMedicamento"),
    @NamedQuery(name = "DetalleFactura.findByIdConsulta", query = "SELECT d FROM DetalleFactura d WHERE d.idConsulta = :idConsulta"),
    @NamedQuery(name = "DetalleFactura.findByPrecio", query = "SELECT d FROM DetalleFactura d WHERE d.precio = :precio"),
    @NamedQuery(name = "DetalleFactura.findByPorcentajeDescuento", query = "SELECT d FROM DetalleFactura d WHERE d.porcentajeDescuento = :porcentajeDescuento")})
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_FACTURA", nullable = false)
    private Integer idDetalleFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FACTURA", nullable = false)
    private int idFactura;
    @Column(name = "ID_DETALLE_MEDICAMENTO")
    private Integer idDetalleMedicamento;
    @Column(name = "ID_CONSULTA")
    private Integer idConsulta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO", nullable = false, precision = 9, scale = 2)
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PORCENTAJE_DESCUENTO", nullable = false)
    private int porcentajeDescuento;
    @JoinColumn(name = "ID_CONSULTA_EXAMEN", referencedColumnName = "ID_CONSULTA_EXAMEN")
    @ManyToOne
    private ConsultaExamen idConsultaExamen;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public DetalleFactura(Integer idDetalleFactura, int idFactura, BigDecimal precio, int porcentajeDescuento) {
        this.idDetalleFactura = idDetalleFactura;
        this.idFactura = idFactura;
        this.precio = precio;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdDetalleMedicamento() {
        return idDetalleMedicamento;
    }

    public void setIdDetalleMedicamento(Integer idDetalleMedicamento) {
        this.idDetalleMedicamento = idDetalleMedicamento;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public ConsultaExamen getIdConsultaExamen() {
        return idConsultaExamen;
    }

    public void setIdConsultaExamen(ConsultaExamen idConsultaExamen) {
        this.idConsultaExamen = idConsultaExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFactura != null ? idDetalleFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetalleFactura == null && other.idDetalleFactura != null) || (this.idDetalleFactura != null && !this.idDetalleFactura.equals(other.idDetalleFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.DetalleFactura[ idDetalleFactura=" + idDetalleFactura + " ]";
    }
    
}
