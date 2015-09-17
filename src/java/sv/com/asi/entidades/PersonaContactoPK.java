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
public class PersonaContactoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONTACTO", nullable = false)
    private int idContacto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA", nullable = false)
    private int idPersona;

    public PersonaContactoPK() {
    }

    public PersonaContactoPK(int idContacto, int idPersona) {
        this.idContacto = idContacto;
        this.idPersona = idPersona;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idContacto;
        hash += (int) idPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaContactoPK)) {
            return false;
        }
        PersonaContactoPK other = (PersonaContactoPK) object;
        if (this.idContacto != other.idContacto) {
            return false;
        }
        if (this.idPersona != other.idPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.PersonaContactoPK[ idContacto=" + idContacto + ", idPersona=" + idPersona + " ]";
    }
    
}
