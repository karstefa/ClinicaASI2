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
@Table(name = "FRECUENCIA", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Frecuencia.findAll", query = "SELECT f FROM Frecuencia f"),
    @NamedQuery(name = "Frecuencia.findByIdFrecuencia", query = "SELECT f FROM Frecuencia f WHERE f.idFrecuencia = :idFrecuencia"),
    @NamedQuery(name = "Frecuencia.findByActivo", query = "SELECT f FROM Frecuencia f WHERE f.activo = :activo"),
    @NamedQuery(name = "Frecuencia.findByUsuarioActualiza", query = "SELECT f FROM Frecuencia f WHERE f.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "Frecuencia.findByNombre", query = "SELECT f FROM Frecuencia f WHERE f.nombre = :nombre")})
public class Frecuencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FRECUENCIA", nullable = false)
    private Integer idFrecuencia;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFrecuencia")
    private List<ConsultaMedicamento> consultaMedicamentoList;

    public Frecuencia() {
    }

    public Frecuencia(Integer idFrecuencia) {
        this.idFrecuencia = idFrecuencia;
    }

    public Frecuencia(Integer idFrecuencia, boolean activo, String usuarioActualiza, String nombre) {
        this.idFrecuencia = idFrecuencia;
        this.activo = activo;
        this.usuarioActualiza = usuarioActualiza;
        this.nombre = nombre;
    }

    public Integer getIdFrecuencia() {
        return idFrecuencia;
    }

    public void setIdFrecuencia(Integer idFrecuencia) {
        this.idFrecuencia = idFrecuencia;
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

    public List<ConsultaMedicamento> getConsultaMedicamentoList() {
        return consultaMedicamentoList;
    }

    public void setConsultaMedicamentoList(List<ConsultaMedicamento> consultaMedicamentoList) {
        this.consultaMedicamentoList = consultaMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFrecuencia != null ? idFrecuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frecuencia)) {
            return false;
        }
        Frecuencia other = (Frecuencia) object;
        if ((this.idFrecuencia == null && other.idFrecuencia != null) || (this.idFrecuencia != null && !this.idFrecuencia.equals(other.idFrecuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Frecuencia[ idFrecuencia=" + idFrecuencia + " ]";
    }
    
}
