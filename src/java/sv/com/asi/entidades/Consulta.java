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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "CONSULTA", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.findByIdConsulta", query = "SELECT c FROM Consulta c WHERE c.idConsulta = :idConsulta"),
    @NamedQuery(name = "Consulta.findByFechaHora", query = "SELECT c FROM Consulta c WHERE c.fechaHora = :fechaHora"),
    @NamedQuery(name = "Consulta.findByMotivo", query = "SELECT c FROM Consulta c WHERE c.motivo = :motivo")})
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONSULTA", nullable = false)
    private Integer idConsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_HORA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "MOTIVO", nullable = false, length = 1000)
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "RESULTADO", nullable = false, length = 2147483647)
    private String resultado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta")
    private List<ConsultaMedicamento> consultaMedicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsulta")
    private List<ConsultaExamen> consultaExamenList;
    @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE", nullable = false)
    @ManyToOne(optional = false)
    private Paciente idPaciente;
    @JoinColumn(name = "ID_ESTADO_CONSULTA", referencedColumnName = "ID_ESTADO_CONSULTA", nullable = false)
    @ManyToOne(optional = false)
    private EstadoConsulta idEstadoConsulta;
    @JoinColumns({
        @JoinColumn(name = "ID_ESPECIALIDAD", referencedColumnName = "ID_ESPECIALIDAD", nullable = false),
        @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false),
        @JoinColumn(name = "ID_HORARIO_ATENCION", referencedColumnName = "ID_HORARIO_ATENCION", nullable = false)})
    @ManyToOne(optional = false)
    private EmpleadoHorario empleadoHorario;

    public Consulta() {
    }

    public Consulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Consulta(Integer idConsulta, Date fechaHora, String motivo, String resultado) {
        this.idConsulta = idConsulta;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.resultado = resultado;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public List<ConsultaMedicamento> getConsultaMedicamentoList() {
        return consultaMedicamentoList;
    }

    public void setConsultaMedicamentoList(List<ConsultaMedicamento> consultaMedicamentoList) {
        this.consultaMedicamentoList = consultaMedicamentoList;
    }

    public List<ConsultaExamen> getConsultaExamenList() {
        return consultaExamenList;
    }

    public void setConsultaExamenList(List<ConsultaExamen> consultaExamenList) {
        this.consultaExamenList = consultaExamenList;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public EstadoConsulta getIdEstadoConsulta() {
        return idEstadoConsulta;
    }

    public void setIdEstadoConsulta(EstadoConsulta idEstadoConsulta) {
        this.idEstadoConsulta = idEstadoConsulta;
    }

    public EmpleadoHorario getEmpleadoHorario() {
        return empleadoHorario;
    }

    public void setEmpleadoHorario(EmpleadoHorario empleadoHorario) {
        this.empleadoHorario = empleadoHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Consulta[ idConsulta=" + idConsulta + " ]";
    }
    
}
