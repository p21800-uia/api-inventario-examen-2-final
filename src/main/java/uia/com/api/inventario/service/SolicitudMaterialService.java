package uia.com.api.inventario.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.api.inventario.dto.CategoriaDTO;
import uia.com.api.inventario.dto.SolicitudMaterialDTO;
import uia.com.api.inventario.model.*;
import uia.com.api.inventario.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SolicitudMaterialService {
    SolicitudMaterialRepository repositorySolicitudMaterial;
    ItemRepository repositoryItem;
    SubpartidaRepository repositorySubpartida;
    PartidaRepository repositoryPartida;
    CategoriaRepository repositoryCategoria;
    ControlId idControl;
    ControlId idControlDTO;

    Validator validator;

    @Autowired
    public SolicitudMaterialService(SolicitudMaterialRepository repositorySolicitudMaterial,
                                    SubpartidaRepository repositorySubpartida,
                                    PartidaRepository repositoryPartida,
                                    ItemRepository repositoryItem,
                                    CategoriaRepository repositoryCategoria,
                                    Validator validator) {
        this.repositorySolicitudMaterial = repositorySolicitudMaterial;
        this.repositoryItem = repositoryItem;
        this.repositoryCategoria = repositoryCategoria;
        this.repositorySubpartida = repositorySubpartida;
        this.repositoryPartida = repositoryPartida;

        this.validator = validator;
    }

    public SolicitudMaterial save(SolicitudMaterial solicitud)
    {
        SolicitudMaterialDTO solicitudes_salvados = new SolicitudMaterialDTO();
        // creacion de nueva solicitud de material
        ArrayList<Item> itemsApartados = new ArrayList<Item>();
        SolicitudMaterial solicitudMaterial = new SolicitudMaterial();
        int itemsSolicitados = solicitud.getItems().size();
        int ndxItemsApartados = 0;
            for (int i = 0; i < itemsSolicitados; i++)
            {
                String idItem = solicitud.getItems().get(i).getId();
                if (this.repositoryItem.existsById(idItem)) {
                    Item itemBD = this.repositoryItem.findById(idItem).get();
                    itemBD.setEstatus("Apartado");
                    itemsApartados.add(itemBD);
                    ++ndxItemsApartados;
                }
            }
            SolicitudMaterial newSolicitudMaterial = null;
            if (itemsSolicitados == ndxItemsApartados)
            {
                long numSSM = this.repositorySolicitudMaterial.count();
                String id = "SSM-"+numSSM;
                newSolicitudMaterial = new SolicitudMaterial();
                for (int j = 0; j < itemsApartados.size(); j++) {
                    this.repositoryItem.save(itemsApartados.get(j));
                }
                newSolicitudMaterial.setItems(itemsApartados);
                newSolicitudMaterial.setId(id);
                newSolicitudMaterial.setName(id);
                newSolicitudMaterial.setEstatus("Apartada");
                newSolicitudMaterial.setClase("SSM");
                newSolicitudMaterial.setCantidad(String.valueOf(itemsApartados.size()));
                repositorySolicitudMaterial.save(newSolicitudMaterial);
            }
        return newSolicitudMaterial;
    }

    public SolicitudMaterial  update(SolicitudMaterial solicitud) {
        return save(solicitud);
    }

    public ArrayList<SolicitudMaterial> getAll()
    {
        ArrayList<SolicitudMaterial> listaSolicitudes = (ArrayList<SolicitudMaterial>) this.repositorySolicitudMaterial.findAll();
        return listaSolicitudes;
    }
}
