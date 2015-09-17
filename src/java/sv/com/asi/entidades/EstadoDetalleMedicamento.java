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
@Table(name = "ESTADO_DETALLE_MEDICAMENTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "EstadoDetalleMedicamento.findAll", query = "SELECT e FROM EstadoDetalleMedicamento e"),
    @NamedQuery(name = "EstadoDetalleMedicamento.findByIdEstadoDetalleMedicamento", query = "SELECT e FROM EstadoDetalleMedicamento e WHERE e.idEstadoDetalleMedicamento = :idEstadoDetalleMedicamento"),
    @NamedQuery(name = "EstadoDetalleMedicamento.findByActivo", query = "SELECT e FROM EstadoDetalleMedicamento e WHERE e.activo = :activo"),
    @NamedQuery(name = "EstadoDetalleMedicamento.findByUsuarioActualiza", query = "SELECT e FROM EstadoDetalleMedicamento e WHERE e.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "EstadoDetalleMedicamento.findByNombre", query = "SELECT e FROM EstadoDetalleMedicamento e WHERE e.nombre = :nombre")})
public class EstadoDetalleMedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_DETALLE_MEDICAMENTO", nullable = false)
    private Integer idEstadoDetalleMedicamento;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoDetalleMedicamento")
    private List<DetalleMedicamento> detalleMedicamentoList;

    public EstadoDetalleMedicamento() {
    }

    public EstadoDetalleMedicamento(Integer idEstadoDetalleMedicamento) {
        this.idEstadoDetalleMedicamento = idEstadoDetalleMedicamento;
    }

    public EstadoDetalleMedicamento(Integer idEstadoDetalleMedicamento, boolean activo, String usuarioActualiza, String nombre) {
        this.idEstadoDetalleMedicamento = idEstadoDetalleMedicamento;
        this.activo = activo;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
    }

    public Integer getIdEstadoDetalleMedicamento() {
        return idEstadoDetalleMedicamento;
    }

    public void setIdEstadoDetalleMedicamento(Integer idEstadoDetalleMedicamento) {
        this.idEstadoDetalleMedicamento = idEstadoDetalleMedicamento;
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

    public List<DetalleMedicamento> getDetalleMedicamentoList() {
        return detalleMedicamentoList;
    }

    public void setDetalleMedicamentoList(List<DetalleMedicamento> detalleMedicamentoList) {
        this.detalleMedicamentoList = detalleMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoDetalleMedicamento != null ? idEstadoDetalleMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDetalleMedicamento)) {
            return false;
        }
        EstadoDetalleMedicamento other = (EstadoDetalleMedicamento) object;
        if ((this.idEstadoDetalleMedicamento == null && other.idEstadoDetalleMedicamento != null) || (this.idEstadoDetalleMedicamento != null && !this.idEstadoDetalleMedicamento.equals(other.idEstadoDetalleMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.EstadoDetalleMedicamento[ idEstadoDetalleMedicamento=" + idEstadoDetalleMedicamento + " ]";
    }
    
}
