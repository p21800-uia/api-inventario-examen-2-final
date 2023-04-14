package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import uia.com.api.inventario.dto.PartidaDTO;


@Node("Lote")
public class Lote extends InfoItem{
    @Property("fechaIngreso")
    private String fechaIngreso;
    private String nameEmbalaje;
    @Relationship(type = "EMPACADO_CON")
    private Embalaje embalaje;

    public Lote(String id, String name, String descripcion, String estatus, String clase, String fechaIngreso, String nameEmbalaje)
    {
        super(id, name, descripcion, estatus, clase);
        this.fechaIngreso = fechaIngreso;
        this.nameEmbalaje = nameEmbalaje;
    }

    public Lote() {
    }

    public Lote(String idDTO, PartidaDTO entityPartidaDTO)
    {
        this.setId(idDTO);
        this.setName(idDTO);
        this.setEstatus(entityPartidaDTO.getEstatus());
        this.setClase("Item");
        this.setIdSubpartida(entityPartidaDTO.getIdSubpartida());
        this.setNameSubpartida(entityPartidaDTO.getNameSubpartida());
        this.setIdCategoria(entityPartidaDTO.getIdCategoria());
        this.setNameCategoria(entityPartidaDTO.getNameCategoria());
    }


    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Embalaje getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(Embalaje embalaje) {
        this.embalaje = embalaje;
    }

    public String getNameEmbalaje() {
        return nameEmbalaje;
    }

    public void setNameEmbalaje(String nameEmbalaje) {
        this.nameEmbalaje = nameEmbalaje;
    }


}
