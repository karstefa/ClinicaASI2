/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "FACTURA", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByFechaHora", query = "SELECT f FROM Factura f WHERE f.fechaHora = :fechaHora"),
    @NamedQuery(name = "Factura.findByNombre", query = "SELECT f FROM Factura f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Factura.findByDireccion", query = "SELECT f FROM Factura f WHERE f.direccion = :direccion"),
    @NamedQuery(name = "Factura.findByValorDocumento", query = "SELECT f FROM Factura f WHERE f.valorDocumento = :valorDocumento"),
    @NamedQuery(name = "Factura.findByNumero", query = "SELECT f FROM Factura f WHERE f.numero = :numero"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total"),
    @NamedQuery(name = "Factura.findBySubTotal", query = "SELECT f FROM Factura f WHERE f.subTotal = :subTotal"),
    @NamedQuery(name = "Factura.findByDescuento", query = "SELECT f FROM Factura f WHERE f.descuento = :descuento")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FACTURA", nullable = false)
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HORA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "NOMBRE", nullable = false, length = 400)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DIRECCION", nullable = false, length = 500)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VALOR_DOCUMENTO", nullable = false, length = 50)
    private String valorDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO", nullable = false)
    private int numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL", nullable = false, precision = 9, scale = 2)
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_TOTAL", nullable = false, precision = 9, scale = 2)
    private BigDecimal subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO", nullable = false, precision = 9, scale = 2)
    private BigDecimal descuento;
    @JoinColumn(name = "ID_TIPO_PAGO", referencedColumnName = "ID_TIPO_PAGO", nullable = false)
    @ManyToOne(optional = false)
    private TipoPago idTipoPago;
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false)
    @ManyToOne(optional = false)
    private Documento idDocumento;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, Date fechaHora, String nombre, String direccion, String valorDocumento, int numero, BigDecimal total, BigDecimal subTotal, BigDecimal descuento) {
        this.idFactura = idFactura;
        this.fechaHora = fechaHora;
        this.nombre = nombre;
        this.direccion = direccion;
        this.valorDocumento = valorDocumento;
        this.numero = numero;
        this.total = total;
        this.subTotal = subTotal;
        this.descuento = descuento;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(String valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
