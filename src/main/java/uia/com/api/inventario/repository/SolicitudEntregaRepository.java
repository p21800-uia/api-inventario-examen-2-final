package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.SolicitudEntrega;
import uia.com.api.inventario.model.SolicitudEntrega;

import java.util.List;


public interface SolicitudEntregaRepository extends CrudRepository<SolicitudEntrega, String>, QueryByExampleExecutor<SolicitudEntrega> {
    List<SolicitudEntrega> findByName(String name);
}
