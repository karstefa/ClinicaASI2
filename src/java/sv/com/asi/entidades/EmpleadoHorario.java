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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "EMPLEADO_HORARIO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EmpleadoHorario.findAll", query = "SELECT e FROM EmpleadoHorario e"),
    @NamedQuery(name = "EmpleadoHorario.findByIdEspecialidad", query = "SELECT e FROM EmpleadoHorario e WHERE e.empleadoHorarioPK.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "EmpleadoHorario.findByIdEmpleado", query = "SELECT e FROM EmpleadoHorario e WHERE e.empleadoHorarioPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "EmpleadoHorario.findByIdHorarioAtencion", query = "SELECT e FROM EmpleadoHorario e WHERE e.empleadoHorarioPK.idHorarioAtencion = :idHorarioAtencion"),
    @NamedQuery(name = "EmpleadoHorario.findByUsuarioActualiza", query = "SELECT e FROM EmpleadoHorario e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "EmpleadoHorario.findByActivo", query = "SELECT e FROM EmpleadoHorario e WHERE e.activo = :activo"),
    @NamedQuery(name = "EmpleadoHorario.findByCostoConsulta", query = "SELECT e FROM EmpleadoHorario e WHERE e.costoConsulta = :costoConsulta")})
public class EmpleadoHorario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoHorarioPK empleadoHorarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO_CONSULTA", nullable = false, precision = 12, scale = 2)
    private BigDecimal costoConsulta;
    @JoinColumn(name = "ID_HORARIO_ATENCION", referencedColumnName = "ID_HORARIO_ATENCION", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HorarioAtencion horarioAtencion;
    @JoinColumns({
        @JoinColumn(name = "ID_ESPECIALIDAD", referencedColumnName = "ID_ESPECIALIDAD", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EmpleadoEspecialidad empleadoEspecialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoHorario")
    private List<Consulta> consultaList;

    public EmpleadoHorario() {
    }

    public EmpleadoHorario(EmpleadoHorarioPK empleadoHorarioPK) {
        this.empleadoHorarioPK = empleadoHorarioPK;
    }

    public EmpleadoHorario(EmpleadoHorarioPK empleadoHorarioPK, String usuarioActualiza, boolean activo, BigDecimal costoConsulta) {
        this.empleadoHorarioPK = empleadoHorarioPK;
        this.usuarioActualiza = usuarioActualiza;
        this.activo = activo;
        this.costoConsulta = costoConsulta;
    }

    public EmpleadoHorario(int idEspecialidad, int idEmpleado, int idHorarioAtencion) {
        this.empleadoHorarioPK = new EmpleadoHorarioPK(idEspecialidad, idEmpleado, idHorarioAtencion);
    }

    public EmpleadoHorarioPK getEmpleadoHorarioPK() {
        return empleadoHorarioPK;
    }

    public void setEmpleadoHorarioPK(EmpleadoHorarioPK empleadoHorarioPK) {
        this.empleadoHorarioPK = empleadoHorarioPK;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(BigDecimal costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public HorarioAtencion getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(HorarioAtencion horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public EmpleadoEspecialidad getEmpleadoEspecialidad() {
        return empleadoEspecialidad;
    }

    public void setEmpleadoEspecialidad(EmpleadoEspecialidad empleadoEspecialidad) {
        this.empleadoEspecialidad = empleadoEspecialidad;
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
        hash += (empleadoHorarioPK != null ? empleadoHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoHorario)) {
            return false;
        }
        EmpleadoHorario other = (EmpleadoHorario) object;
        if ((this.empleadoHorarioPK == null && other.empleadoHorarioPK != null) || (this.empleadoHorarioPK != null && !this.empleadoHorarioPK.equals(other.empleadoHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EmpleadoHorario[ empleadoHorarioPK=" + empleadoHorarioPK + " ]";
    }
    
}
