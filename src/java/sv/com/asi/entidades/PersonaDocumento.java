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
@Table(name = "PERSONA_DOCUMENTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "PersonaDocumento.findAll", query = "SELECT p FROM PersonaDocumento p"),
    @NamedQuery(name = "PersonaDocumento.findByIdDocumento", query = "SELECT p FROM PersonaDocumento p WHERE p.personaDocumentoPK.idDocumento = :idDocumento"),
    @NamedQuery(name = "PersonaDocumento.findByIdPersona", query = "SELECT p FROM PersonaDocumento p WHERE p.personaDocumentoPK.idPersona = :idPersona"),
    @NamedQuery(name = "PersonaDocumento.findByUsuarioActualiza", query = "SELECT p FROM PersonaDocumento p WHERE p.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "PersonaDocumento.findByValor", query = "SELECT p FROM PersonaDocumento p WHERE p.valor = :valor")})
public class PersonaDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonaDocumentoPK personaDocumentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VALOR", nullable = false, length = 100)
    private String valor;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Documento documento;

    public PersonaDocumento() {
    }

    public PersonaDocumento(PersonaDocumentoPK personaDocumentoPK) {
        this.personaDocumentoPK = personaDocumentoPK;
    }

    public PersonaDocumento(PersonaDocumentoPK personaDocumentoPK, String usuarioActualiza, String valor) {
        this.personaDocumentoPK = personaDocumentoPK;
        this.usuarioActualiza = usuarioActualiza;
        this.valor = valor;
    }

    public PersonaDocumento(int idDocumento, int idPersona) {
        this.personaDocumentoPK = new PersonaDocumentoPK(idDocumento, idPersona);
    }

    public PersonaDocumentoPK getPersonaDocumentoPK() {
        return personaDocumentoPK;
    }

    public void setPersonaDocumentoPK(PersonaDocumentoPK personaDocumentoPK) {
        this.personaDocumentoPK = personaDocumentoPK;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaDocumentoPK != null ? personaDocumentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaDocumento)) {
            return false;
        }
        PersonaDocumento other = (PersonaDocumento) object;
        if ((this.personaDocumentoPK == null && other.personaDocumentoPK != null) || (this.personaDocumentoPK != null && !this.personaDocumentoPK.equals(other.personaDocumentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.PersonaDocumento[ personaDocumentoPK=" + personaDocumentoPK + " ]";
    }
    
}
