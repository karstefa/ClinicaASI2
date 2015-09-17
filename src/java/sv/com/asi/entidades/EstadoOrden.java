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
@Table(name = "ESTADO_ORDEN", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EstadoOrden.findAll", query = "SELECT e FROM EstadoOrden e"),
    @NamedQuery(name = "EstadoOrden.findByIdEstadoOrden", query = "SELECT e FROM EstadoOrden e WHERE e.idEstadoOrden = :idEstadoOrden"),
    @NamedQuery(name = "EstadoOrden.findByUsuarioActualiza", query = "SELECT e FROM EstadoOrden e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "EstadoOrden.findByNombre", query = "SELECT e FROM EstadoOrden e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoOrden.findByActivo", query = "SELECT e FROM EstadoOrden e WHERE e.activo = :activo")})
public class EstadoOrden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_ORDEN", nullable = false)
    private Integer idEstadoOrden;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoOrden")
    private List<OrdenLoteMedicamento> ordenLoteMedicamentoList;

    public EstadoOrden() {
    }

    public EstadoOrden(Integer idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    public EstadoOrden(Integer idEstadoOrden, String usuarioActualiza, String nombre, boolean activo) {
        this.idEstadoOrden = idEstadoOrden;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(Integer idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
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

    public List<OrdenLoteMedicamento> getOrdenLoteMedicamentoList() {
        return ordenLoteMedicamentoList;
    }

    public void setOrdenLoteMedicamentoList(List<OrdenLoteMedicamento> ordenLoteMedicamentoList) {
        this.ordenLoteMedicamentoList = ordenLoteMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOrden != null ? idEstadoOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOrden)) {
            return false;
        }
        EstadoOrden other = (EstadoOrden) object;
        if ((this.idEstadoOrden == null && other.idEstadoOrden != null) || (this.idEstadoOrden != null && !this.idEstadoOrden.equals(other.idEstadoOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EstadoOrden[ idEstadoOrden=" + idEstadoOrden + " ]";
    }
    
}
