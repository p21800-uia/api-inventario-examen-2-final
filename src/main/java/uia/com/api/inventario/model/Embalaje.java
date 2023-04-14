package uia.com.api.inventario.model;


import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;


@Node("Embalaje")
public class Embalaje extends InfoItem {
    @Relationship(type = "pertenece_a")
    private List<Lote> lotes;

    public Embalaje(String id, String name, String descripcion, String estatus, String clase)
    {
        super(id, name, descripcion, estatus, clase);
        this.lotes  = new ArrayList<Lote>();
    }

    public Embalaje() {
    }




    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
}
