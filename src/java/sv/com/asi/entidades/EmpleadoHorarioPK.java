/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rgluis
 */
@Embeddable
public class EmpleadoHorarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESPECIALIDAD", nullable = false)
    private int idEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO", nullable = false)
    private int idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HORARIO_ATENCION", nullable = false)
    private int idHorarioAtencion;

    public EmpleadoHorarioPK() {
    }

    public EmpleadoHorarioPK(int idEspecialidad, int idEmpleado, int idHorarioAtencion) {
        this.idEspecialidad = idEspecialidad;
        this.idEmpleado = idEmpleado;
        this.idHorarioAtencion = idHorarioAtencion;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdHorarioAtencion() {
        return idHorarioAtencion;
    }

    public void setIdHorarioAtencion(int idHorarioAtencion) {
        this.idHorarioAtencion = idHorarioAtencion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEspecialidad;
        hash += (int) idEmpleado;
        hash += (int) idHorarioAtencion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoHorarioPK)) {
            return false;
        }
        EmpleadoHorarioPK other = (EmpleadoHorarioPK) object;
        if (this.idEspecialidad != other.idEspecialidad) {
            return false;
        }
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (this.idHorarioAtencion != other.idHorarioAtencion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EmpleadoHorarioPK[ idEspecialidad=" + idEspecialidad + ", idEmpleado=" + idEmpleado + ", idHorarioAtencion=" + idHorarioAtencion + " ]";
    }
    
}
