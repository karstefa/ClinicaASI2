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
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "EXAMEN", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByIdExamen", query = "SELECT e FROM Examen e WHERE e.idExamen = :idExamen"),
    @NamedQuery(name = "Examen.findByUsuarioActualiza", query = "SELECT e FROM Examen e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "Examen.findByNombre", query = "SELECT e FROM Examen e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Examen.findByCostoExamen", query = "SELECT e FROM Examen e WHERE e.costoExamen = :costoExamen"),
    @NamedQuery(name = "Examen.findByActivo", query = "SELECT e FROM Examen e WHERE e.activo = :activo")})
public class Examen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EXAMEN", nullable = false)
    private Integer idExamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO_EXAMEN", nullable = false, precision = 12, scale = 2)
    private BigDecimal costoExamen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExamen")
    private List<ConsultaExamen> consultaExamenList;
    @JoinColumn(name = "ID_TIPO_EXAMEN", referencedColumnName = "ID_TIPO_EXAMEN", nullable = false)
    @ManyToOne(optional = false)
    private TipoExamen idTipoExamen;

    public Examen() {
    }

    public Examen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public Examen(Integer idExamen, String usuarioActualiza, String nombre, BigDecimal costoExamen, boolean activo) {
        this.idExamen = idExamen;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
        this.costoExamen = costoExamen;
        this.activo = activo;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCostoExamen() {
        return costoExamen;
    }

    public void setCostoExamen(BigDecimal costoExamen) {
        this.costoExamen = costoExamen;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<ConsultaExamen> getConsultaExamenList() {
        return consultaExamenList;
    }

    public void setConsultaExamenList(List<ConsultaExamen> consultaExamenList) {
        this.consultaExamenList = consultaExamenList;
    }

    public TipoExamen getIdTipoExamen() {
        return idTipoExamen;
    }

    public void setIdTipoExamen(TipoExamen idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamen != null ? idExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idExamen == null && other.idExamen != null) || (this.idExamen != null && !this.idExamen.equals(other.idExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Examen[ idExamen=" + idExamen + " ]";
    }
    
}
