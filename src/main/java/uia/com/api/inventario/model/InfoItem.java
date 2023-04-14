package uia.com.api.inventario.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.*;


@Node("InfoItem")
public  class InfoItem {
    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("clase")
    private String clase;
    @Property("namePartida")
    private String namePartida;
    @Property("nameSubpartida")
    private String nameSubpartida;
    @Property("nameCategoria")
    private String nameCategoria;
    @Property("idPartida")
    private String idPartida;
    @Property("idSubpartida")
    private String idSubpartida;
    @Property("idCategoria")
    private String idCategoria;
    @Property("estatus")
    private String estatus;


    public InfoItem() {
    }

    public InfoItem(String clase, String idCat, String descCat, String sinEstatus, String cantidad, String ubic) {
    }

    public InfoItem(String id, String name, String descripcion, String estatus, String clase) {
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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}
