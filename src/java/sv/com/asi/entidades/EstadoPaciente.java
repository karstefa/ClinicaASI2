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
@Table(name = "ESTADO_PACIENTE", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EstadoPaciente.findAll", query = "SELECT e FROM EstadoPaciente e"),
    @NamedQuery(name = "EstadoPaciente.findByIdEstadoPaciente", query = "SELECT e FROM EstadoPaciente e WHERE e.idEstadoPaciente = :idEstadoPaciente"),
    @NamedQuery(name = "EstadoPaciente.findByActivo", query = "SELECT e FROM EstadoPaciente e WHERE e.activo = :activo"),
    @NamedQuery(name = "EstadoPaciente.findByUsuarioActualiza", query = "SELECT e FROM EstadoPaciente e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "EstadoPaciente.findByNombre", query = "SELECT e FROM EstadoPaciente e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoPaciente.findByDescripcion", query = "SELECT e FROM EstadoPaciente e WHERE e.descripcion = :descripcion")})
public class EstadoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_PACIENTE", nullable = false)
    private Integer idEstadoPaciente;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPaciente")
    private List<Paciente> pacienteList;

    public EstadoPaciente() {
    }

    public EstadoPaciente(Integer idEstadoPaciente) {
        this.idEstadoPaciente = idEstadoPaciente;
    }

    public EstadoPaciente(Integer idEstadoPaciente, boolean activo, String usuarioActualiza, String nombre, String descripcion) {
        this.idEstadoPaciente = idEstadoPaciente;
        this.activo = activo;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoPaciente() {
        return idEstadoPaciente;
    }

    public void setIdEstadoPaciente(Integer idEstadoPaciente) {
        this.idEstadoPaciente = idEstadoPaciente;
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

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPaciente != null ? idEstadoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPaciente)) {
            return false;
        }
        EstadoPaciente other = (EstadoPaciente) object;
        if ((this.idEstadoPaciente == null && other.idEstadoPaciente != null) || (this.idEstadoPaciente != null && !this.idEstadoPaciente.equals(other.idEstadoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EstadoPaciente[ idEstadoPaciente=" + idEstadoPaciente + " ]";
    }
    
}
