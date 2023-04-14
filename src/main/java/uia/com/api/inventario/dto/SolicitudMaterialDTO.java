package uia.com.api.inventario.dto;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import uia.com.api.inventario.dto.ItemDTO;
import uia.com.api.inventario.model.Categoria;
import uia.com.api.inventario.model.Item;

import java.util.ArrayList;
import java.util.List;


public class SolicitudMaterialDTO {
    private String id;
    private String name;
    private String estatus;
    private String clase;
    private String descripcion;
    private String idItem;
    private String nameItem;
    private String idCategoria;
    private String nameCategoria;
    private String nameLote;
    private String cantidad;
    private String idProveedor;
    private String minimoNivel;
    private  ArrayList<Item> items = new ArrayList<Item>();;


    public SolicitudMaterialDTO(String id, String name, String descripcion, String estatus, String clase, String fechaIngreso, String nameLote, String idItem,
                                String nameItem, String idCategoria, String nameCategoria, String cantidad, String idProveedor, String minimoNivel, List<ItemDTO> partidas)
    {
        this.id = id;
        this.name = id;
        this.estatus = estatus;
        this.clase = clase;
        this.descripcion = descripcion;
        this.idItem = idItem;
        this.nameItem = nameItem;
        this.idCategoria = idCategoria;
        this.nameCategoria = nameCategoria;
        this.nameLote = nameLote;
        this.cantidad = cantidad;
        this.idProveedor = idProveedor;
        this.minimoNivel = minimoNivel;
    }

    public SolicitudMaterialDTO() {
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


    public String getIdItem() {
        return idItem;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
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
