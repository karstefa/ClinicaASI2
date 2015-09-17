/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.asi.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rgluis
 */
@Entity
@Table(name = "TIPO_EXAMEN", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "TipoExamen.findAll", query = "SELECT t FROM TipoExamen t"),
    @NamedQuery(name = "TipoExamen.findByIdTipoExamen", query = "SELECT t FROM TipoExamen t WHERE t.idTipoExamen = :idTipoExamen"),
    @NamedQuery(name = "TipoExamen.findByUsuarioActualiza", query = "SELECT t FROM TipoExamen t WHERE t.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "TipoExamen.findByNombre", query = "SELECT t FROM TipoExamen t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoExamen.findByActivo", query = "SELECT t FROM TipoExamen t WHERE t.activo = :activo")})
public class TipoExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_EXAMEN", nullable = false)
    private Integer idTipoExamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoExamen")
    private List<Examen> examenList;

    public TipoExamen() {
    }

    public TipoExamen(Integer idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    public TipoExamen(Integer idTipoExamen, String usuarioActualiza, String nombre, boolean activo) {
        this.idTipoExamen = idTipoExamen;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdTipoExamen() {
        return idTipoExamen;
    }

    public void setIdTipoExamen(Integer idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoExamen != null ? idTipoExamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoExamen)) {
            return false;
        }
        TipoExamen other = (TipoExamen) object;
        if ((this.idTipoExamen == null && other.idTipoExamen != null) || (this.idTipoExamen != null && !this.idTipoExamen.equals(other.idTipoExamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.TipoExamen[ idTipoExamen=" + idTipoExamen + " ]";
    }
    
}
