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
@Table(name = "ESTADO_EMPLEADO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EstadoEmpleado.findAll", query = "SELECT e FROM EstadoEmpleado e"),
    @NamedQuery(name = "EstadoEmpleado.findByIdEstadoEmpleado", query = "SELECT e FROM EstadoEmpleado e WHERE e.idEstadoEmpleado = :idEstadoEmpleado"),
    @NamedQuery(name = "EstadoEmpleado.findByActivo", query = "SELECT e FROM EstadoEmpleado e WHERE e.activo = :activo"),
    @NamedQuery(name = "EstadoEmpleado.findByUsuarioActualiza", query = "SELECT e FROM EstadoEmpleado e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "EstadoEmpleado.findByDescripcion", query = "SELECT e FROM EstadoEmpleado e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoEmpleado.findByNombre", query = "SELECT e FROM EstadoEmpleado e WHERE e.nombre = :nombre")})
public class EstadoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_EMPLEADO", nullable = false)
    private Integer idEstadoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION", nullable = false, length = 300)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoEmpleado")
    private List<Empleado> empleadoList;

    public EstadoEmpleado() {
    }

    public EstadoEmpleado(Integer idEstadoEmpleado) {
        this.idEstadoEmpleado = idEstadoEmpleado;
    }

    public EstadoEmpleado(Integer idEstadoEmpleado, boolean activo, String usuarioActualiza, String descripcion, String nombre) {
        this.idEstadoEmpleado = idEstadoEmpleado;
        this.activo = activo;
        this.usuarioActualiza = usuarioActualiza;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getIdEstadoEmpleado() {
        return idEstadoEmpleado;
    }

    public void setIdEstadoEmpleado(Integer idEstadoEmpleado) {
        this.idEstadoEmpleado = idEstadoEmpleado;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoEmpleado != null ? idEstadoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEmpleado)) {
            return false;
        }
        EstadoEmpleado other = (EstadoEmpleado) object;
        if ((this.idEstadoEmpleado == null && other.idEstadoEmpleado != null) || (this.idEstadoEmpleado != null && !this.idEstadoEmpleado.equals(other.idEstadoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EstadoEmpleado[ idEstadoEmpleado=" + idEstadoEmpleado + " ]";
    }
    
}
