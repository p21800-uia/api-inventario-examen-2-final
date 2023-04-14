package uia.com.api.inventario.dto;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;

public class ItemDTO {
    private String id;
    private String name;
    private String clase;
    private String namePartida;
    private String nameSubpartida;
    private String nameCategoria;
    private String idPartida;
    private String idSubpartida;
    private String idCategoria;
    private String estatus;

    public ItemDTO(String id, String name, String partida, String subpartida, String categoria, String estatus) {
        this.id = id;
        this.name = name;
        this.namePartida = partida;
        this.nameSubpartida = subpartida;
        this.nameCategoria = categoria;
        this.estatus = estatus;
    }

    public ItemDTO() {
    }

    public ItemDTO(String id, String name, String descripcion, String estatus, String clase) {
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


    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getNamePartida() {
        return namePartida;
    }

    public void setNamePartida(String namePartida) {
        this.namePartida = namePartida;
    }

    public String getNameSubpartida() {
        return nameSubpartida;
    }

    public void setNameSubpartida(String nameSubpartida) {
        this.nameSubpartida = nameSubpartida;
    }

    public String getNameCategoria() {
        return nameCategoria;
    }

    public void setNameCategoria(String nameCategoria) {
        this.nameCategoria = nameCategoria;
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

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
