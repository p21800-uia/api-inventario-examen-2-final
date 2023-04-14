package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.SolicitudIngreso;

import java.util.List;


public interface SolicitudIngresoRepository extends CrudRepository<SolicitudIngreso, String>, QueryByExampleExecutor<SolicitudIngreso> {
    List<SolicitudIngreso> findByName(String name);
}
