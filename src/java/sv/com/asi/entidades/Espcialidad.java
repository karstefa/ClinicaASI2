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
@Table(name = "ESPCIALIDAD", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Espcialidad.findAll", query = "SELECT e FROM Espcialidad e"),
    @NamedQuery(name = "Espcialidad.findByIdEspecialidad", query = "SELECT e FROM Espcialidad e WHERE e.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "Espcialidad.findByActivo", query = "SELECT e FROM Espcialidad e WHERE e.activo = :activo"),
    @NamedQuery(name = "Espcialidad.findByUsuarioActualiza", query = "SELECT e FROM Espcialidad e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "Espcialidad.findByNombre", query = "SELECT e FROM Espcialidad e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Espcialidad.findByDescripcion", query = "SELECT e FROM Espcialidad e WHERE e.descripcion = :descripcion")})
public class Espcialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESPECIALIDAD", nullable = false)
    private Integer idEspecialidad;
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
    @Size(min = 1, max = 2000)
    @Column(name = "DESCRIPCION", nullable = false, length = 2000)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espcialidad")
    private List<EmpleadoEspecialidad> empleadoEspecialidadList;
    @JoinColumn(name = "ID_TIPO_CONSULTA", referencedColumnName = "ID_TIPO_CONSULTA", nullable = false)
    @ManyToOne(optional = false)
    private TipoConsulta idTipoConsulta;

    public Espcialidad() {
    }

    public Espcialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Espcialidad(Integer idEspecialidad, boolean activo, String usuarioActualiza, String nombre, String descripcion) {
        this.idEspecialidad = idEspecialidad;
        this.activo = activo;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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

    public List<EmpleadoEspecialidad> getEmpleadoEspecialidadList() {
        return empleadoEspecialidadList;
    }

    public void setEmpleadoEspecialidadList(List<EmpleadoEspecialidad> empleadoEspecialidadList) {
        this.empleadoEspecialidadList = empleadoEspecialidadList;
    }

    public TipoConsulta getIdTipoConsulta() {
        return idTipoConsulta;
    }

    public void setIdTipoConsulta(TipoConsulta idTipoConsulta) {
        this.idTipoConsulta = idTipoConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espcialidad)) {
            return false;
        }
        Espcialidad other = (Espcialidad) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Espcialidad[ idEspecialidad=" + idEspecialidad + " ]";
    }
    
}
