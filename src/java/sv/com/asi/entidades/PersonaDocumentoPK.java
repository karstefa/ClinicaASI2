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
public class PersonaDocumentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENTO", nullable = false)
    private int idDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA", nullable = false)
    private int idPersona;

    public PersonaDocumentoPK() {
    }

    public PersonaDocumentoPK(int idDocumento, int idPersona) {
        this.idDocumento = idDocumento;
        this.idPersona = idPersona;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
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
        hash += (int) idDocumento;
        hash += (int) idPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaDocumentoPK)) {
            return false;
        }
        PersonaDocumentoPK other = (PersonaDocumentoPK) object;
        if (this.idDocumento != other.idDocumento) {
            return false;
        }
        if (this.idPersona != other.idPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.PersonaDocumentoPK[ idDocumento=" + idDocumento + ", idPersona=" + idPersona + " ]";
    }
    
}
