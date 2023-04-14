package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;


@Node("Subpartida")
public class Subpartida {
    @Id
    private String id;
    @Property("name")
    private String name;
    @Property("estatus")
    private String estatus;
    @Property("clase")
    private String clase;
    @Property("idSubpartida")
    private String idSubpartida;
    @Relationship(type = "CONTIENE")
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();

    public Subpartida(String id, String name, String idSubpartida, String estatus, String clase, String fechaIngreso, String nameEmbalaje)
    {
        this.id = id;
        this.name = id;
        this.estatus = estatus;
        this.clase = clase;
        this.idSubpartida = idSubpartida;
    }

    public Subpartida() {
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


    public String getIdSubpartida() {
        return idSubpartida;
    }

    public void setIdSubpartida(String idSubpartida) {
        this.idSubpartida = idSubpartida;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }



}
