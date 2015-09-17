/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "EMPLEADO_ESPECIALIDAD", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EmpleadoEspecialidad.findAll", query = "SELECT e FROM EmpleadoEspecialidad e"),
    @NamedQuery(name = "EmpleadoEspecialidad.findByIdEspecialidad", query = "SELECT e FROM EmpleadoEspecialidad e WHERE e.empleadoEspecialidadPK.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "EmpleadoEspecialidad.findByIdEmpleado", query = "SELECT e FROM EmpleadoEspecialidad e WHERE e.empleadoEspecialidadPK.idEmpleado = :idEmpleado")})
public class EmpleadoEspecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoEspecialidadPK empleadoEspecialidadPK;
    @JoinColumn(name = "ID_ESPECIALIDAD", referencedColumnName = "ID_ESPECIALIDAD", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Espcialidad espcialidad;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoEspecialidad")
    private List<EmpleadoHorario> empleadoHorarioList;

    public EmpleadoEspecialidad() {
    }

    public EmpleadoEspecialidad(EmpleadoEspecialidadPK empleadoEspecialidadPK) {
        this.empleadoEspecialidadPK = empleadoEspecialidadPK;
    }

    public EmpleadoEspecialidad(int idEspecialidad, int idEmpleado) {
        this.empleadoEspecialidadPK = new EmpleadoEspecialidadPK(idEspecialidad, idEmpleado);
    }

    public EmpleadoEspecialidadPK getEmpleadoEspecialidadPK() {
        return empleadoEspecialidadPK;
    }

    public void setEmpleadoEspecialidadPK(EmpleadoEspecialidadPK empleadoEspecialidadPK) {
        this.empleadoEspecialidadPK = empleadoEspecialidadPK;
    }

    public Espcialidad getEspcialidad() {
        return espcialidad;
    }

    public void setEspcialidad(Espcialidad espcialidad) {
        this.espcialidad = espcialidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<EmpleadoHorario> getEmpleadoHorarioList() {
        return empleadoHorarioList;
    }

    public void setEmpleadoHorarioList(List<EmpleadoHorario> empleadoHorarioList) {
        this.empleadoHorarioList = empleadoHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoEspecialidadPK != null ? empleadoEspecialidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoEspecialidad)) {
            return false;
        }
        EmpleadoEspecialidad other = (EmpleadoEspecialidad) object;
        if ((this.empleadoEspecialidadPK == null && other.empleadoEspecialidadPK != null) || (this.empleadoEspecialidadPK != null && !this.empleadoEspecialidadPK.equals(other.empleadoEspecialidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EmpleadoEspecialidad[ empleadoEspecialidadPK=" + empleadoEspecialidadPK + " ]";
    }
    
}
