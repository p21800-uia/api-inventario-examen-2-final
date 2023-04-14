package uia.com.api.inventario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uia.com.api.inventario.model.Categoria;
import uia.com.api.inventario.model.Partida;
import uia.com.api.inventario.model.Categoria;

import java.util.List;


public interface CategoriaRepository extends CrudRepository<Categoria, String>, QueryByExampleExecutor<Categoria> {
    List<Categoria> findByName(String name);
    List<Categoria> findByIdCategoria(String idCategoria);
    Boolean existsByIdCategoria(String idCategoria);
}
