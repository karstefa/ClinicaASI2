/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "CONSULTA_EXAMEN", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "ConsultaExamen.findAll", query = "SELECT c FROM ConsultaExamen c"),
    @NamedQuery(name = "ConsultaExamen.findByIdConsultaExamen", query = "SELECT c FROM ConsultaExamen c WHERE c.idConsultaExamen = :idConsultaExamen"),
    @NamedQuery(name = "ConsultaExamen.findByFechaExamen", query = "SELECT c FROM ConsultaExamen c WHERE c.fechaExamen = :fechaExamen"),
    @NamedQuery(name = "ConsultaExamen.findByDescuento", query = "SELECT c FROM ConsultaExamen c WHERE c.descuento = :descuento"),
    @NamedQuery(name = "ConsultaExamen.findByPrecioExamen", query = "SELECT c FROM ConsultaExamen c WHERE c.precioExamen = :precioExamen")})
public class ConsultaExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONSULTA_EXAMEN", nullable = false)
    private Integer idConsultaExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_EXAMEN", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESCUENTO", nullable = false)
    private int descuento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_EXAMEN", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioExamen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "RESULTADO_EXAMEN", nullable = false, length = 2147483647)
    private String resultadoExamen;
    @JoinColumn(name = "ID_EXAMEN", referencedColumnName = "ID_EXAMEN", nullable = false)
    @ManyToOne(optional = false)
    private Examen idExamen;
    @JoinColumn(name = "ID_ESTADO_EXAMEN", referencedColumnName = "ID_ESTADO_EXAMEN", nullable = false)
    @ManyToOne(optional = false)
    private EstadoExamen idEstadoExamen;
    @JoinColumn(name = "ID_CONSULTA", referencedColumnName = "ID_CONSULTA", nullable = false)
    @ManyToOne(optional = false)
    private Consulta idConsulta;
    @OneToMany(mappedBy = "idConsultaExamen")
    private List<DetalleFactura> detalleFacturaList;

    public ConsultaExamen() {
    }

    public ConsultaExamen(Integer idConsultaExamen) {
        this.idConsultaExamen = idConsultaExamen;
    }

    public ConsultaExamen(Integer idConsultaExamen, Date fechaExamen, int descuento, BigDecimal precioExamen, String resultadoExamen) {
        this.idConsultaExamen = idConsultaExamen;
        this.fechaExamen = fechaExamen;
        this.descuento = descuento;
        this.precioExamen = precioExamen;
        this.resultadoExamen = resultadoExamen;
    }

    public Integer getIdConsultaExamen() {
        return idConsultaExamen;
    }

    public void setIdConsultaExamen(Integer idConsultaExamen) {
        this.idConsultaExamen = idConsultaExamen;
    }

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getPrecioExamen() {
        return precioExamen;
    }

    public void setPrecioExamen(BigDecimal precioExamen) {
        this.precioExamen = precioExamen;
    }

    public String getResultadoExamen() {
        return resultadoExamen;
    }

    public void setResultadoExamen(String resultadoExamen) {
        this.resultadoExamen = resultadoExamen;
    }

    public Examen getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Examen idExamen) {
        this.idExamen = idExamen;
    }

    public EstadoExamen getIdEstadoExamen() {
        return idEstadoExamen;
    }

    public void setIdEstadoExamen(EstadoExamen idEstadoExamen) {
        this.idEstadoExamen = idEstadoExamen;
    }

    public Consulta getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Consulta idConsulta) {
        this.idConsulta = idConsulta;
    }

    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultaExamen != null ? idConsultaExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaExamen)) {
            return false;
        }
        ConsultaExamen other = (ConsultaExamen) object;
        if ((this.idConsultaExamen == null && other.idConsultaExamen != null) || (this.idConsultaExamen != null && !this.idConsultaExamen.equals(other.idConsultaExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.ConsultaExamen[ idConsultaExamen=" + idConsultaExamen + " ]";
    }
    
}
