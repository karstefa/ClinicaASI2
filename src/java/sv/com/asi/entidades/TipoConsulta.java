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
@Table(name = "TIPO_CONSULTA", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "TipoConsulta.findAll", query = "SELECT t FROM TipoConsulta t"),
    @NamedQuery(name = "TipoConsulta.findByIdTipoConsulta", query = "SELECT t FROM TipoConsulta t WHERE t.idTipoConsulta = :idTipoConsulta"),
    @NamedQuery(name = "TipoConsulta.findByActivo", query = "SELECT t FROM TipoConsulta t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoConsulta.findByUsuarioActualiza", query = "SELECT t FROM TipoConsulta t WHERE t.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "TipoConsulta.findByNombre", query = "SELECT t FROM TipoConsulta t WHERE t.nombre = :nombre")})
public class TipoConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_CONSULTA", nullable = false)
    private Integer idTipoConsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVO", nullable = false)
    private boolean activo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoConsulta")
    private List<Espcialidad> espcialidadList;

    public TipoConsulta() {
    }

    public TipoConsulta(Integer idTipoConsulta) {
        this.idTipoConsulta = idTipoConsulta;
    }

    public TipoConsulta(Integer idTipoConsulta, boolean activo, String usuarioActualiza, String nombre) {
        this.idTipoConsulta = idTipoConsulta;
        this.activo = activo;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
    }

    public Integer getIdTipoConsulta() {
        return idTipoConsulta;
    }

    public void setIdTipoConsulta(Integer idTipoConsulta) {
        this.idTipoConsulta = idTipoConsulta;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public List<Espcialidad> getEspcialidadList() {
        return espcialidadList;
    }

    public void setEspcialidadList(List<Espcialidad> espcialidadList) {
        this.espcialidadList = espcialidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoConsulta != null ? idTipoConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConsulta)) {
            return false;
        }
        TipoConsulta other = (TipoConsulta) object;
        if ((this.idTipoConsulta == null && other.idTipoConsulta != null) || (this.idTipoConsulta != null && !this.idTipoConsulta.equals(other.idTipoConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.TipoConsulta[ idTipoConsulta=" + idTipoConsulta + " ]";
    }
    
}
