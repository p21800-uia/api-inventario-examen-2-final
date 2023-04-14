package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.Subpartida;
import uia.com.api.inventario.model.Subpartida;

import java.util.List;


public interface SubpartidaRepository extends CrudRepository<Subpartida, String>, QueryByExampleExecutor<Subpartida> {
    List<Subpartida> findByName(String name);
    List<Subpartida> findByIdSubpartida(String subpartida);
    Boolean existsByIdSubpartida(String subpartida);
}
