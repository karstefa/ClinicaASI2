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
@Table(name = "TIPO_EMPLEADO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "TipoEmpleado.findAll", query = "SELECT t FROM TipoEmpleado t"),
    @NamedQuery(name = "TipoEmpleado.findByIdTipoEmpleado", query = "SELECT t FROM TipoEmpleado t WHERE t.idTipoEmpleado = :idTipoEmpleado"),
    @NamedQuery(name = "TipoEmpleado.findByActivo", query = "SELECT t FROM TipoEmpleado t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoEmpleado.findByUsuarioActualiza", query = "SELECT t FROM TipoEmpleado t WHERE t.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "TipoEmpleado.findByNombre", query = "SELECT t FROM TipoEmpleado t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoEmpleado.findByDescripcion", query = "SELECT t FROM TipoEmpleado t WHERE t.descripcion = :descripcion")})
public class TipoEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_EMPLEADO", nullable = false)
    private Integer idTipoEmpleado;
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
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION", nullable = false, length = 300)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpleado")
    private List<Empleado> empleadoList;

    public TipoEmpleado() {
    }

    public TipoEmpleado(Integer idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public TipoEmpleado(Integer idTipoEmpleado, boolean activo, String usuarioActualiza, String nombre, String descripcion) {
        this.idTipoEmpleado = idTipoEmpleado;
        this.activo = activo;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(Integer idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idTipoEmpleado != null ? idTipoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEmpleado)) {
            return false;
        }
        TipoEmpleado other = (TipoEmpleado) object;
        if ((this.idTipoEmpleado == null && other.idTipoEmpleado != null) || (this.idTipoEmpleado != null && !this.idTipoEmpleado.equals(other.idTipoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.TipoEmpleado[ idTipoEmpleado=" + idTipoEmpleado + " ]";
    }
    
}
