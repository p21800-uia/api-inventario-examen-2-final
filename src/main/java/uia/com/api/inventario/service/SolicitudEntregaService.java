package uia.com.api.inventario.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.api.inventario.dto.CategoriaDTO;
import uia.com.api.inventario.dto.SolicitudEntregaDTO;
import uia.com.api.inventario.model.*;
import uia.com.api.inventario.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SolicitudEntregaService {
    SolicitudEntregaRepository repositorySolicitudEntrega;
    ItemRepository repositoryItem;
    SubpartidaRepository repositorySubpartida;
    PartidaRepository repositoryPartida;
    CategoriaRepository repositoryCategoria;
    ControlId idControl;
    ControlId idControlDTO;

    Validator validator;

    @Autowired
    public SolicitudEntregaService(SolicitudEntregaRepository repositorySolicitudEntrega,
                                    SubpartidaRepository repositorySubpartida,
                                    PartidaRepository repositoryPartida,
                                    ItemRepository repositoryItem,
                                    CategoriaRepository repositoryCategoria,
                                    Validator validator) {
        this.repositorySolicitudEntrega = repositorySolicitudEntrega;
        this.repositoryItem = repositoryItem;
        this.repositoryCategoria = repositoryCategoria;
        this.repositorySubpartida = repositorySubpartida;
        this.repositoryPartida = repositoryPartida;

        this.validator = validator;
    }

    public SolicitudEntrega save(SolicitudEntrega solicitud)
    {
        SolicitudEntregaDTO solicitudes_salvados = new SolicitudEntregaDTO();
        // creacion de nueva solicitud de material
        ArrayList<Item> itemsApartados = new ArrayList<Item>();
        SolicitudEntrega solicitudEntrega = new SolicitudEntrega();
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
        SolicitudEntrega newSolicitudEntrega = null;
        if (itemsSolicitados == ndxItemsApartados)
        {
            long numSSM = this.repositorySolicitudEntrega.count();
            String id = "SSM-"+numSSM;
            newSolicitudEntrega = new SolicitudEntrega();
            for (int j = 0; j < itemsApartados.size(); j++) {
                this.repositoryItem.save(itemsApartados.get(j));
            }
            newSolicitudEntrega.setItems(itemsApartados);
            newSolicitudEntrega.setId(id);
            newSolicitudEntrega.setName(id);
            newSolicitudEntrega.setEstatus("Apartada");
            newSolicitudEntrega.setClase("SSM");
            newSolicitudEntrega.setCantidad(String.valueOf(itemsApartados.size()));
            repositorySolicitudEntrega.save(newSolicitudEntrega);
        }
        return newSolicitudEntrega;
    }

    public SolicitudEntrega  update(SolicitudEntrega solicitud) {
        return save(solicitud);
    }

    public ArrayList<SolicitudEntrega> getAll()
    {
        ArrayList<SolicitudEntrega> listaSolicitudes = (ArrayList<SolicitudEntrega>) this.repositorySolicitudEntrega.findAll();
        return listaSolicitudes;
    }
}
