package uia.com.api.inventario.dto;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import uia.com.api.inventario.model.InfoItem;
import uia.com.api.inventario.model.Item;
import uia.com.api.inventario.model.Lote;

import java.util.ArrayList;

public class CategoriaDTO
{
    private String idCategoria;
    private int cantidad = 0;
    private ArrayList<Item> items = new ArrayList<Item>();


    public CategoriaDTO()
    {}

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
