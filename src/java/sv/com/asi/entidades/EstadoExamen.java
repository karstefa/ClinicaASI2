/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ESTADO_EXAMEN", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EstadoExamen.findAll", query = "SELECT e FROM EstadoExamen e"),
    @NamedQuery(name = "EstadoExamen.findByIdEstadoExamen", query = "SELECT e FROM EstadoExamen e WHERE e.idEstadoExamen = :idEstadoExamen"),
    @NamedQuery(name = "EstadoExamen.findByUsuarioActualiza", query = "SELECT e FROM EstadoExamen e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "EstadoExamen.findByNombre", query = "SELECT e FROM EstadoExamen e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoExamen.findByActivo", query = "SELECT e FROM EstadoExamen e WHERE e.activo = :activo")})
public class EstadoExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_EXAMEN", nullable = false)
    private Integer idEstadoExamen;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoExamen")
    private List<ConsultaExamen> consultaExamenList;

    public EstadoExamen() {
    }

    public EstadoExamen(Integer idEstadoExamen) {
        this.idEstadoExamen = idEstadoExamen;
    }

    public EstadoExamen(Integer idEstadoExamen, String usuarioActualiza, String nombre, boolean activo) {
        this.idEstadoExamen = idEstadoExamen;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdEstadoExamen() {
        return idEstadoExamen;
    }

    public void setIdEstadoExamen(Integer idEstadoExamen) {
        this.idEstadoExamen = idEstadoExamen;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoExamen != null ? idEstadoExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoExamen)) {
            return false;
        }
        EstadoExamen other = (EstadoExamen) object;
        if ((this.idEstadoExamen == null && other.idEstadoExamen != null) || (this.idEstadoExamen != null && !this.idEstadoExamen.equals(other.idEstadoExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EstadoExamen[ idEstadoExamen=" + idEstadoExamen + " ]";
    }
    
}
