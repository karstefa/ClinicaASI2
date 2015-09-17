/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "LOTE_MEDICAMENTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "LoteMedicamento.findAll", query = "SELECT l FROM LoteMedicamento l"),
    @NamedQuery(name = "LoteMedicamento.findByIdLoteMedicamento", query = "SELECT l FROM LoteMedicamento l WHERE l.idLoteMedicamento = :idLoteMedicamento"),
    @NamedQuery(name = "LoteMedicamento.findByPrecioCosto", query = "SELECT l FROM LoteMedicamento l WHERE l.precioCosto = :precioCosto"),
    @NamedQuery(name = "LoteMedicamento.findByPrecioVenta", query = "SELECT l FROM LoteMedicamento l WHERE l.precioVenta = :precioVenta"),
    @NamedQuery(name = "LoteMedicamento.findByCantidadBodega", query = "SELECT l FROM LoteMedicamento l WHERE l.cantidadBodega = :cantidadBodega"),
    @NamedQuery(name = "LoteMedicamento.findByCantidadRecibida", query = "SELECT l FROM LoteMedicamento l WHERE l.cantidadRecibida = :cantidadRecibida"),
    @NamedQuery(name = "LoteMedicamento.findByCatidadDefectuosa", query = "SELECT l FROM LoteMedicamento l WHERE l.catidadDefectuosa = :catidadDefectuosa"),
    @NamedQuery(name = "LoteMedicamento.findByCantidadSalida", query = "SELECT l FROM LoteMedicamento l WHERE l.cantidadSalida = :cantidadSalida")})
public class LoteMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LOTE_MEDICAMENTO", nullable = false)
    private Integer idLoteMedicamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_COSTO", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioCosto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_VENTA", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_BODEGA", nullable = false)
    private int cantidadBodega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_RECIBIDA", nullable = false)
    private int cantidadRecibida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATIDAD_DEFECTUOSA", nullable = false)
    private int catidadDefectuosa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_SALIDA", nullable = false)
    private int cantidadSalida;
    @JoinColumn(name = "ID_MEDICAMENTO", referencedColumnName = "ID_MEDICAMENTO", nullable = false)
    @ManyToOne(optional = false)
    private Medicamento idMedicamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLoteMedicamento")
    private List<DetalleMedicamento> detalleMedicamentoList;

    public LoteMedicamento() {
    }

    public LoteMedicamento(Integer idLoteMedicamento) {
        this.idLoteMedicamento = idLoteMedicamento;
    }

    public LoteMedicamento(Integer idLoteMedicamento, BigDecimal precioCosto, BigDecimal precioVenta, int cantidadBodega, int cantidadRecibida, int catidadDefectuosa, int cantidadSalida) {
        this.idLoteMedicamento = idLoteMedicamento;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadBodega = cantidadBodega;
        this.cantidadRecibida = cantidadRecibida;
        this.catidadDefectuosa = catidadDefectuosa;
        this.cantidadSalida = cantidadSalida;
    }

    public Integer getIdLoteMedicamento() {
        return idLoteMedicamento;
    }

    public void setIdLoteMedicamento(Integer idLoteMedicamento) {
        this.idLoteMedicamento = idLoteMedicamento;
    }

    public BigDecimal getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(BigDecimal precioCosto) {
        this.precioCosto = precioCosto;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public int getCantidadRecibida() {
        return cantidadRecibida;
    }

    public void setCantidadRecibida(int cantidadRecibida) {
        this.cantidadRecibida = cantidadRecibida;
    }

    public int getCatidadDefectuosa() {
        return catidadDefectuosa;
    }

    public void setCatidadDefectuosa(int catidadDefectuosa) {
        this.catidadDefectuosa = catidadDefectuosa;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public Medicamento getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamento idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public List<DetalleMedicamento> getDetalleMedicamentoList() {
        return detalleMedicamentoList;
    }

    public void setDetalleMedicamentoList(List<DetalleMedicamento> detalleMedicamentoList) {
        this.detalleMedicamentoList = detalleMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoteMedicamento != null ? idLoteMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoteMedicamento)) {
            return false;
        }
        LoteMedicamento other = (LoteMedicamento) object;
        if ((this.idLoteMedicamento == null && other.idLoteMedicamento != null) || (this.idLoteMedicamento != null && !this.idLoteMedicamento.equals(other.idLoteMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.LoteMedicamento[ idLoteMedicamento=" + idLoteMedicamento + " ]";
    }
    
}
