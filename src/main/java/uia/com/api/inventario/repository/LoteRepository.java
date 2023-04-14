package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.Lote;

import java.util.List;


public interface LoteRepository extends CrudRepository<Lote, String>, QueryByExampleExecutor<Lote> {
    List<Lote> findByName(String name);
}
