/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "HORARIO_ATENCION", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "HorarioAtencion.findAll", query = "SELECT h FROM HorarioAtencion h"),
    @NamedQuery(name = "HorarioAtencion.findByIdHorarioAtencion", query = "SELECT h FROM HorarioAtencion h WHERE h.idHorarioAtencion = :idHorarioAtencion"),
    @NamedQuery(name = "HorarioAtencion.findByUsuarioActualiza", query = "SELECT h FROM HorarioAtencion h WHERE h.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "HorarioAtencion.findByActivo", query = "SELECT h FROM HorarioAtencion h WHERE h.activo = :activo"),
    @NamedQuery(name = "HorarioAtencion.findByDia", query = "SELECT h FROM HorarioAtencion h WHERE h.dia = :dia"),
    @NamedQuery(name = "HorarioAtencion.findByHoraInicio", query = "SELECT h FROM HorarioAtencion h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "HorarioAtencion.findByHoraFin", query = "SELECT h FROM HorarioAtencion h WHERE h.horaFin = :horaFin"),
    @NamedQuery(name = "HorarioAtencion.findByDescripcion", query = "SELECT h FROM HorarioAtencion h WHERE h.descripcion = :descripcion")})
public class HorarioAtencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HORARIO_ATENCION", nullable = false)
    private Integer idHorarioAtencion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DIA", nullable = false, length = 2)
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_INICIO", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_FIN", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarioAtencion")
    private List<EmpleadoHorario> empleadoHorarioList;

    public HorarioAtencion() {
    }

    public HorarioAtencion(Integer idHorarioAtencion) {
        this.idHorarioAtencion = idHorarioAtencion;
    }

    public HorarioAtencion(Integer idHorarioAtencion, String usuarioActualiza, boolean activo, String dia, Date horaInicio, Date horaFin, String descripcion) {
        this.idHorarioAtencion = idHorarioAtencion;
        this.usuarioActualiza = usuarioActualiza;
        this.activo = activo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.descripcion = descripcion;
    }

    public Integer getIdHorarioAtencion() {
        return idHorarioAtencion;
    }

    public void setIdHorarioAtencion(Integer idHorarioAtencion) {
        this.idHorarioAtencion = idHorarioAtencion;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idHorarioAtencion != null ? idHorarioAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioAtencion)) {
            return false;
        }
        HorarioAtencion other = (HorarioAtencion) object;
        if ((this.idHorarioAtencion == null && other.idHorarioAtencion != null) || (this.idHorarioAtencion != null && !this.idHorarioAtencion.equals(other.idHorarioAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.HorarioAtencion[ idHorarioAtencion=" + idHorarioAtencion + " ]";
    }
    
}
