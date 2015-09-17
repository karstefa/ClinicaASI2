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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MEDICAMENTO", catalog = "clinica_medica")
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m"),
    @NamedQuery(name = "Medicamento.findByIdMedicamento", query = "SELECT m FROM Medicamento m WHERE m.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "Medicamento.findByUsuarioActualiza", query = "SELECT m FROM Medicamento m WHERE m.usuarioActualiza = :usuarioActualiza"),
    @NamedQuery(name = "Medicamento.findByCantidadMinima", query = "SELECT m FROM Medicamento m WHERE m.cantidadMinima = :cantidadMinima"),
    @NamedQuery(name = "Medicamento.findByCantidadMaxima", query = "SELECT m FROM Medicamento m WHERE m.cantidadMaxima = :cantidadMaxima"),
    @NamedQuery(name = "Medicamento.findByNombre", query = "SELECT m FROM Medicamento m WHERE m.nombre = :nombre")})
public class Medicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MEDICAMENTO", nullable = false)
    private Integer idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USUARIO_ACTUALIZA", nullable = false, length = 10)
    private String usuarioActualiza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_MINIMA", nullable = false)
    private int cantidadMinima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_MAXIMA", nullable = false)
    private int cantidadMaxima;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicamento")
    private List<ConsultaMedicamento> consultaMedicamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicamento")
    private List<LoteMedicamento> loteMedicamentoList;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID_FABRICANTE", nullable = false)
    @ManyToOne(optional = false)
    private Fabricante idFabricante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicamento")
    private List<OrdenLoteMedicamento> ordenLoteMedicamentoList;

    public Medicamento() {
    }

    public Medicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamento(Integer idMedicamento, String usuarioActualiza, int cantidadMinima, int cantidadMaxima, String nombre) {
        this.idMedicamento = idMedicamento;
        this.usuarioActualiza = usuarioActualiza;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
        this.nombre = nombre;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
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

    public List<LoteMedicamento> getLoteMedicamentoList() {
        return loteMedicamentoList;
    }

    public void setLoteMedicamentoList(List<LoteMedicamento> loteMedicamentoList) {
        this.loteMedicamentoList = loteMedicamentoList;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Fabricante getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Fabricante idFabricante) {
        this.idFabricante = idFabricante;
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
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.asi.entidades.Medicamento[ idMedicamento=" + idMedicamento + " ]";
    }
    
}
