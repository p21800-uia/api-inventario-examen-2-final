package uia.com.api.inventario.service;

import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.api.inventario.dto.SolicitudIngresoDTO;
import uia.com.api.inventario.model.Item;
import uia.com.api.inventario.model.SolicitudIngreso;
import uia.com.api.inventario.model.SolicitudMaterial;
import uia.com.api.inventario.repository.ItemRepository;
import uia.com.api.inventario.repository.SolicitudIngresoRepository;
import uia.com.api.inventario.repository.SolicitudMaterialRepository;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class SolicitudIngresoService<solicitudIngreso> {
    SolicitudIngresoRepository repositorySolicitudIngreso;
    ItemRepository repositoryItem;

    Validator validator;
    private SolicitudMaterialRepository repositorySolicitudMaterial;

    @Autowired
    public SolicitudIngresoService(SolicitudIngresoRepository repositorySolicitudIngreso,
                                   SolicitudMaterialRepository repositorySolicitudMaterial,
                                   ItemRepository repositoryItem,
                                   Validator validator) {
        this.repositorySolicitudIngreso = repositorySolicitudIngreso;
        this.repositorySolicitudMaterial = repositorySolicitudMaterial;
        this.repositoryItem = repositoryItem;
        this.validator = validator;
    }

    public SolicitudIngreso save(SolicitudIngresoDTO solicitud) {
        return saveInformation(solicitud);
    }

    public SolicitudIngreso update(SolicitudIngresoDTO solicitud) {
        return saveInformation(solicitud);
    }

    private SolicitudIngreso saveInformation(SolicitudIngresoDTO solicitudInDTO) {
        SolicitudIngresoDTO solicitudes_salvados = new SolicitudIngresoDTO();
        ArrayList<Item> itemsApartados = new ArrayList<Item>();
        SolicitudIngreso solicitudIngreso = new SolicitudIngreso();
        int itemDisponibles = 0;
        Optional<SolicitudMaterial> solicitudMaterialBD = null;

        if (this.repositorySolicitudMaterial.existsById(solicitudInDTO.getId())) {
            //-- Se toma el 0 como el unico que debe haber
            solicitudMaterialBD = this.repositorySolicitudMaterial.findById(solicitudInDTO.getId());
            for (int k = 0; k < solicitudMaterialBD.get().getItems().size(); k++) {

                if (solicitudMaterialBD.get().getItems().get(k).getEstatus().contentEquals("Ingresodo")) {
                    solicitudMaterialBD.get().getItems().get(k).setEstatus("Ingresodo");
                    itemsApartados.add(solicitudMaterialBD.get().getItems().get(k));
                }
            }
            ++itemDisponibles;
        }

        if (itemDisponibles > 0) {
            for (int j = 0; j < itemsApartados.size(); j++) {
                this.repositoryItem.save(itemsApartados.get(j));
            }
            solicitudIngreso.setItems(itemsApartados);
            solicitudIngreso.setId("SEM-1");
            solicitudIngreso.setName("Pedro Perez");
            solicitudIngreso.setEstatus("Ingresoda");
            solicitudIngreso.setClase("SEM");
            solicitudIngreso.setCantidad(String.valueOf(itemsApartados.size()));
            repositorySolicitudIngreso.save(solicitudIngreso);

        }


        return solicitudIngreso;
    }


}
