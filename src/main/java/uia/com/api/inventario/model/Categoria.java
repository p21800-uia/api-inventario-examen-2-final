package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import uia.com.api.inventario.dto.PartidaDTO;

import java.util.ArrayList;

@Node("Categoria")
public class Categoria extends InfoItem
{
    @Property("minimoNivel")
    private int minimoNivel = -1;
    @Property("cantidadEntregada")
    private int cantidadEntrega = -1;
    @Property("idProveedor")
    private String idProveedor;
    @Relationship(type = "PERTENECE")
    private ArrayList<Lote> lotes = new ArrayList<Lote>();
    @Relationship(type = "AGREGO")
    private ArrayList<Item> items = new ArrayList<Item>();

    public Categoria(String clase, String idCat, String descCat, String sinEstatus, String cantidad, String ubic) {
        super(clase, idCat, descCat, sinEstatus, cantidad, ubic);
    }

    public Categoria()
    {}

    public Categoria(String clase, String idCat, String descCat, String sinEstatus, String cantidad, String ubic, int minimoNivel)
    {
        super(clase, idCat, descCat, sinEstatus, cantidad, ubic);
        this.setMinimoNivel(minimoNivel);
    }

    public Categoria(String idDTO, PartidaDTO entityPartidaDTO) {
        this.setId(idDTO);
        this.setName(idDTO);
        this.setEstatus(entityPartidaDTO.getEstatus());
        this.setClase("Item");
        this.setIdSubpartida(entityPartidaDTO.getIdSubpartida());
        this.setNameSubpartida(entityPartidaDTO.getNameSubpartida());
        this.setIdCategoria(entityPartidaDTO.getIdCategoria());
        this.setNameCategoria(entityPartidaDTO.getNameCategoria());
        if(entityPartidaDTO.getMinimoNivel() == null)
            entityPartidaDTO.setMinimoNivel("0");
        this.setMinimoNivel(Integer.parseInt(entityPartidaDTO.getMinimoNivel()));
        this.setIdProveedor(entityPartidaDTO.getIdProveedor());
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getMinimoNivel() {
        return minimoNivel;
    }

    public void setMinimoNivel(int minimoNivel) {
        this.minimoNivel = minimoNivel;
    }

    public int getCantidadEntrega() {
        return cantidadEntrega;
    }

    public void setCantidadEntrega(int cantidadEntrega) {
        this.cantidadEntrega = cantidadEntrega;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }
}
