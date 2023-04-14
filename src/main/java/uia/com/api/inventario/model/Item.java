package uia.com.api.inventario.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import uia.com.api.inventario.dto.PartidaDTO;

import java.util.ArrayList;


@Node("Item")
public class Item extends InfoItem{




    public Item(String id, String name, String partida, String subpartida, String categoria,
                String estatus, String nameProveedor)
    {
        super(id, name, partida, subpartida, categoria,estatus);
        //MiNeo4JDriver.neo4jClient.query();
        //this.proveedor = proveedor;

        String ubicP = String.valueOf(Integer.parseInt(partida)/100);
        char ubicS = (char) (65 + (Integer.parseInt(subpartida)/100)/10);
        String ubicC = String.valueOf((Integer.parseInt(categoria)-Integer.parseInt(subpartida)));
    }



    public Item() {
    }


    public Item(String idDTO, PartidaDTO entityPartidaDTO)
    {
        this.setId(idDTO);
        this.setName(idDTO);
        this.setEstatus(entityPartidaDTO.getEstatus());
        this.setClase("Item");
        this.setIdSubpartida(entityPartidaDTO.getIdSubpartida());
        this.setNameSubpartida(entityPartidaDTO.getNameSubpartida());
        this.setIdCategoria(entityPartidaDTO.getIdCategoria());
        this.setNameCategoria(entityPartidaDTO.getNameCategoria());
        this.setEstatus("Disponible");
    }
}
