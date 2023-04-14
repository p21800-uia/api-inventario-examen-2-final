package uia.com.api.inventario.dto;

import uia.com.api.inventario.model.Subpartida;

import java.util.ArrayList;
import java.util.List;


public class PartidaDTO {
    private  String minimoNivel;
    private String id;
    private String name;
    private String descripcion;
    private String estatus;
    private String clase;
    private String fechaIngreso;
    private String idLote;
    private String nameLote;
    private String idPartida;
    private String idSubpartida;
    private String nameSubpartida;
    private String idCategoria;
    private String nameCategoria;
    private String cantidad;
    private String idProveedor;
    private List<PartidaDTO> partidas = new ArrayList<PartidaDTO>();
    private List<Subpartida> subpartidas = new ArrayList<Subpartida>();

    public PartidaDTO() {
    }

    public PartidaDTO(String id, String name, String descripcion, String estatus, String clase, String fechaIngreso, String nameLote, String idPartida,
                      String idSubpartida, String nameSubpartida, String idCategoria, String nameCategoria, String cantidad, String minimoNivel, List<PartidaDTO> partidas)
    {
        this.id = name;
        this.name = name;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.clase = clase;
        this.partidas = partidas;
        this.idSubpartida = idSubpartida;
        this.nameSubpartida = nameSubpartida;
        this.idCategoria = idCategoria;
        this.nameCategoria = nameCategoria;
        this.idLote = idLote;
        this.nameLote = nameLote;
        this.cantidad = cantidad;
        this.minimoNivel = minimoNivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNameLote() {
        return nameLote;
    }

    public void setNameLote(String nameLote) {
        this.nameLote = nameLote;
    }

    public List<PartidaDTO> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaDTO> partidas) {
        this.partidas = partidas;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getIdSubpartida() {
        return idSubpartida;
    }

    public void setIdSubpartida(String idSubpartida) {
        this.idSubpartida = idSubpartida;
    }

    public String getNameSubpartida() {
        return nameSubpartida;
    }

    public void setNameSubpartida(String nameSubpartida) {
        this.nameSubpartida = nameSubpartida;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNameCategoria() {
        return nameCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNamePartida() {
        return this.getName();
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getMinimoNivel() {
        return minimoNivel;
    }

    public void setMinimoNivel(String minimoNivel) {
        this.minimoNivel = minimoNivel;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public List<Subpartida> getSubpartidas() {
        return subpartidas;
    }

    public void setSubpartidas(List<Subpartida> subpartidas) {
        this.subpartidas = subpartidas;
    }
}
