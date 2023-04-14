package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.SolicitudMaterial;

import java.util.List;


public interface SolicitudMaterialRepository extends CrudRepository<SolicitudMaterial, String>, QueryByExampleExecutor<SolicitudMaterial> {
    List<SolicitudMaterial> findByName(String name);
}
