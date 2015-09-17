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
@Table(name = "EMPLEADO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByUsuarioActualiza", query = "SELECT e FROM Empleado e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "Empleado.findByCarnet", query = "SELECT e FROM Empleado e WHERE e.carnet = :carnet"),
    @NamedQuery(name = "Empleado.findBySalario", query = "SELECT e FROM Empleado e WHERE e.salario = :salario")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMPLEADO", nullable = false)
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CARNET", nullable = false, length = 12)
    private String carnet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO", nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;
    @JoinColumn(name = "ID_TIPO_EMPLEADO", referencedColumnName = "ID_TIPO_EMPLEADO", nullable = false)
    @ManyToOne(optional = false)
    private TipoEmpleado idTipoEmpleado;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", nullable = false)
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "ID_ESTADO_EMPLEADO", referencedColumnName = "ID_ESTADO_EMPLEADO", nullable = false)
    @ManyToOne(optional = false)
    private EstadoEmpleado idEstadoEmpleado;
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO", nullable = false)
    @ManyToOne(optional = false)
    private Cargo idCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<EmpleadoEspecialidad> empleadoEspecialidadList;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String usuarioActualiza, String carnet, BigDecimal salario) {
        this.idEmpleado = idEmpleado;
        this.usuarioActualiza = usuarioActualiza;
        this.carnet = carnet;
        this.salario = salario;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public TipoEmpleado getIdTipoEmpleado() {
        return idTipoEmpleado;
    }

    public void setIdTipoEmpleado(TipoEmpleado idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public EstadoEmpleado getIdEstadoEmpleado() {
        return idEstadoEmpleado;
    }

    public void setIdEstadoEmpleado(EstadoEmpleado idEstadoEmpleado) {
        this.idEstadoEmpleado = idEstadoEmpleado;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public List<EmpleadoEspecialidad> getEmpleadoEspecialidadList() {
        return empleadoEspecialidadList;
    }

    public void setEmpleadoEspecialidadList(List<EmpleadoEspecialidad> empleadoEspecialidadList) {
        this.empleadoEspecialidadList = empleadoEspecialidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
