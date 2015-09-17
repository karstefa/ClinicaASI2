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
@Table(name = "PERSONA", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByUsuarioActualiza", query = "SELECT p FROM Persona p WHERE p.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "Persona.findByPrimerNombre", query = "SELECT p FROM Persona p WHERE p.primerNombre = :primerNombre"),
    @NamedQuery(name = "Persona.findByTercerNombre", query = "SELECT p FROM Persona p WHERE p.tercerNombre = :tercerNombre"),
    @NamedQuery(name = "Persona.findByPrimerApellido", query = "SELECT p FROM Persona p WHERE p.primerApellido = :primerApellido"),
    @NamedQuery(name = "Persona.findBySegundoApellido", query = "SELECT p FROM Persona p WHERE p.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findBySegundoNombre", query = "SELECT p FROM Persona p WHERE p.segundoNombre = :segundoNombre")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERSONA", nullable = false)
    private Integer idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PRIMER_NOMBRE", nullable = false, length = 100)
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TERCER_NOMBRE", nullable = false, length = 100)
    private String tercerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PRIMER_APELLIDO", nullable = false, length = 200)
    private String primerApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SEGUNDO_APELLIDO", nullable = false, length = 200)
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SEGUNDO_NOMBRE", nullable = false, length = 100)
    private String segundoNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<PersonaContacto> personaContactoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Empleado> empleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Paciente> pacienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<PersonaDocumento> personaDocumentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Direccion> direccionList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String usuarioActualiza, String primerNombre, String tercerNombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String segundoNombre) {
        this.idPersona = idPersona;
        this.usuarioActualiza = usuarioActualiza;
        this.primerNombre = primerNombre;
        this.tercerNombre = tercerNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.segundoNombre = segundoNombre;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getTercerNombre() {
        return tercerNombre;
    }

    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public List<PersonaContacto> getPersonaContactoList() {
        return personaContactoList;
    }

    public void setPersonaContactoList(List<PersonaContacto> personaContactoList) {
        this.personaContactoList = personaContactoList;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public List<PersonaDocumento> getPersonaDocumentoList() {
        return personaDocumentoList;
    }

    public void setPersonaDocumentoList(List<PersonaDocumento> personaDocumentoList) {
        this.personaDocumentoList = personaDocumentoList;
    }

    public List<Direccion> getDireccionList() {
        return direccionList;
    }

    public void setDireccionList(List<Direccion> direccionList) {
        this.direccionList = direccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
