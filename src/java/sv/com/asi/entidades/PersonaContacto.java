/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "PERSONA_CONTACTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "PersonaContacto.findAll", query = "SELECT p FROM PersonaContacto p"),
    @NamedQuery(name = "PersonaContacto.findByIdContacto", query = "SELECT p FROM PersonaContacto p WHERE p.personaContactoPK.idContacto = :idContacto"),
    @NamedQuery(name = "PersonaContacto.findByIdPersona", query = "SELECT p FROM PersonaContacto p WHERE p.personaContactoPK.idPersona = :idPersona"),
    @NamedQuery(name = "PersonaContacto.findByValor", query = "SELECT p FROM PersonaContacto p WHERE p.valor = :valor")})
public class PersonaContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonaContactoPK personaContactoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "VALOR", nullable = false, length = 200)
    private String valor;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "ID_CONTACTO", referencedColumnName = "ID_CONTACTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contacto contacto;

    public PersonaContacto() {
    }

    public PersonaContacto(PersonaContactoPK personaContactoPK) {
        this.personaContactoPK = personaContactoPK;
    }

    public PersonaContacto(PersonaContactoPK personaContactoPK, String valor) {
        this.personaContactoPK = personaContactoPK;
        this.valor = valor;
    }

    public PersonaContacto(int idContacto, int idPersona) {
        this.personaContactoPK = new PersonaContactoPK(idContacto, idPersona);
    }

    public PersonaContactoPK getPersonaContactoPK() {
        return personaContactoPK;
    }

    public void setPersonaContactoPK(PersonaContactoPK personaContactoPK) {
        this.personaContactoPK = personaContactoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaContactoPK != null ? personaContactoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaContacto)) {
            return false;
        }
        PersonaContacto other = (PersonaContacto) object;
        if ((this.personaContactoPK == null && other.personaContactoPK != null) || (this.personaContactoPK != null && !this.personaContactoPK.equals(other.personaContactoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.PersonaContacto[ personaContactoPK=" + personaContactoPK + " ]";
    }
    
}
