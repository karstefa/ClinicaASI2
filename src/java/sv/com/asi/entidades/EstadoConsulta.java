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
@Table(name = "ESTADO_CONSULTA", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EstadoConsulta.findAll", query = "SELECT e FROM EstadoConsulta e"),
    @NamedQuery(name = "EstadoConsulta.findByIdEstadoConsulta", query = "SELECT e FROM EstadoConsulta e WHERE e.idEstadoConsulta = :idEstadoConsulta"),
    @NamedQuery(name = "EstadoConsulta.findByActivo", query = "SELECT e FROM EstadoConsulta e WHERE e.activo = :activo"),
    @NamedQuery(name = "EstadoConsulta.findByNombre", query = "SELECT e FROM EstadoConsulta e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoConsulta.findByUsuarioActualiza", query = "SELECT e FROM EstadoConsulta e WHERE e.usuarioActualiza = :usuarioActualiza")})
public class EstadoConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_CONSULTA", nullable = false)
    private Integer idEstadoConsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoConsulta")
    private List<Consulta> consultaList;

    public EstadoConsulta() {
    }

    public EstadoConsulta(Integer idEstadoConsulta) {
        this.idEstadoConsulta = idEstadoConsulta;
    }

    public EstadoConsulta(Integer idEstadoConsulta, boolean activo, String nombre, String usuarioActualiza) {
        this.idEstadoConsulta = idEstadoConsulta;
        this.activo = activo;
        this.nombre = nombre;
        this.usuarioActualiza = usuarioActualiza;
    }

    public Integer getIdEstadoConsulta() {
        return idEstadoConsulta;
    }

    public void setIdEstadoConsulta(Integer idEstadoConsulta) {
        this.idEstadoConsulta = idEstadoConsulta;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoConsulta != null ? idEstadoConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConsulta)) {
            return false;
        }
        EstadoConsulta other = (EstadoConsulta) object;
        if ((this.idEstadoConsulta == null && other.idEstadoConsulta != null) || (this.idEstadoConsulta != null && !this.idEstadoConsulta.equals(other.idEstadoConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EstadoConsulta[ idEstadoConsulta=" + idEstadoConsulta + " ]";
    }
    
}
