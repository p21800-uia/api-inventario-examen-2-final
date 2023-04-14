package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import uia.com.api.inventario.dto.PartidaDTO;

import java.util.ArrayList;
import java.util.List;


@Node("Partida")
public class Partida {
    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("estatus")
    private String estatus;
    @Property("clase")
    private String clase;
    @Property("descripcion")
    private String descripcion;
    private String idPartida;
    private String idSubpartida;
    private String nameSubpartida;
    private String idCategoria;
    private String nameCategoria;
    private String nameLote;
    private String cantidad;
    private String idProveedor;
    private String minimoNivel;
    @Relationship(type = "CONTIENE")
    private ArrayList<Subpartida> subpartidas = new ArrayList<Subpartida>();


    public Partida(String id, String name, String descripcion, String estatus, String clase, String fechaIngreso, String nameLote, String idPartida,
                   String idSubpartida, String nameSubpartida, String idCategoria, String nameCategoria, String cantidad, String idProveedor, String minimoNivel, List<PartidaDTO> partidas)
    {
        this.id = id;
        this.name = id;
        this.estatus = estatus;
        this.clase = clase;
        this.descripcion = descripcion;
        this.idSubpartida = idSubpartida;
        this.nameSubpartida = nameSubpartida;
        this.idCategoria = idCategoria;
        this.nameCategoria = nameCategoria;
        this.nameLote = nameLote;
        this.cantidad = cantidad;
        this.idProveedor = idProveedor;
        this.minimoNivel = minimoNivel;
    }

    public Partida() {
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

    public ArrayList<Subpartida> getSubpartidas() {
        return subpartidas;
    }

    public void setSubpartidas(ArrayList<Subpartida> subpartidas) {
        this.subpartidas = subpartidas;
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

    public String getNameLote() {
        return nameLote;
    }

    public void setNameLote(String nameLote) {
        this.nameLote = nameLote;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
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
}
