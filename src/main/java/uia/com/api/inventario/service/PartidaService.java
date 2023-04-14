package uia.com.api.inventario.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.com.api.inventario.dto.PartidaDTO;
import uia.com.api.inventario.mapper.ApiMapperPartida;
import uia.com.api.inventario.model.*;
import uia.com.api.inventario.repository.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;


@Service
public class PartidaService {
    PartidaRepository repositoryPartidas;
    SubpartidaRepository repositorySubpartidas;
    LoteRepository repositoryLote;
    ItemRepository repositoryItem;
    CategoriaRepository repositoryCategoria;
    ControlId idControl;
    ControlId idControlDTO;

    Validator validator;

    @Autowired
    public PartidaService(PartidaRepository repositoryPartidas,
                          LoteRepository repositoryLote,
                          ItemRepository repositoryItem,
                          SubpartidaRepository repositorySubpartida,
                          CategoriaRepository repositoryCategoria,
                          Validator validator) {
        this.repositoryPartidas = repositoryPartidas;
        this.repositoryLote = repositoryLote;
        this.repositoryItem = repositoryItem;
        this.repositorySubpartidas = repositorySubpartida;
        this.repositoryCategoria = repositoryCategoria;
        this.validator = validator;
    }

    public PartidaDTO save(PartidaDTO partida) {
        return saveInformation(partida);
    }

    public PartidaDTO update(PartidaDTO partida) {
        return saveInformation(partida);
    }

    private PartidaDTO saveInformation(PartidaDTO partidaDTO)
    {
        PartidaDTO partidas_salvados = new PartidaDTO();

                this.idControlDTO = new ControlId(partidaDTO);

                Partida entityPartida = ApiMapperPartida.INSTANCE.DTOToEntity(partidaDTO);
                this.idControl = new ControlId(entityPartida);
                entityPartida.setId((this.idControl.getIdPartida()));
                String id = this.idControl.getIdPartida();

                if (!this.repositoryPartidas.existsById(id)) {
                    entityPartida.setId((this.idControl.getIdPartida()));
                    String idLote = this.idControl.getIdLote();
                    agregaPartida(entityPartida, partidaDTO);
                    partidas_salvados.getPartidas().add(partidaDTO);
                } else {
                    this.idControlDTO = new ControlId(partidaDTO);

                    Optional<Partida> entityPartidaBD = this.repositoryPartidas.findById(this.idControlDTO.getIdPartida());

                    if (!this.repositorySubpartidas.existsById(idControlDTO.getIdSubpartida())) {
                        agregaSubpartida(entityPartidaBD.get(), partidaDTO);
                    } else {
                        if (!this.repositoryCategoria.existsById(this.idControlDTO.getIdCategoria())) {
                            Optional<Subpartida> subPartidaBD = this.repositorySubpartidas.findById(this.idControlDTO.getIdSubpartida());
                            agregaCategoria(subPartidaBD.get(), partidaDTO);
                        } else {
                            Optional<Categoria> categoriaBD = this.repositoryCategoria.findById(this.idControlDTO.getIdCategoria());
                            if (!this.repositoryLote.existsById(this.idControlDTO.getIdLote())) {
                                agregaLote(categoriaBD.get(), partidaDTO);
                            } else {
                                agregaItems(categoriaBD.get(), partidaDTO);
                            }

                        }
                    }
                    partidas_salvados.getPartidas().add(ApiMapperPartida.INSTANCE.entityToDTO(this.agregaPartida(entityPartidaBD.get(), partidaDTO)));
                }
        return partidas_salvados;
    }

    private void agregaItems(Partida entityPartida) {
    }

    private void agregaCategoria(Partida idCategoria) {
    }

    private Partida agregaPartida(Partida entityPartida, PartidaDTO partidaDTO) {
        Set<ConstraintViolation<Partida>> violations2 = validator.validate(entityPartida);
        if (!violations2.isEmpty()) {
            throw new ConstraintViolationException(violations2);
        }
        Subpartida subpartida = agregaSubpartida(entityPartida, partidaDTO);
        Categoria categoria = agregaCategoria(subpartida, partidaDTO);
        agregaLote(categoria, partidaDTO);
        agregaItems(categoria, partidaDTO);
        repositoryPartidas.save(entityPartida);
        return entityPartida;
    }



    private Subpartida agregaSubpartida(Partida entityPartidaBD, PartidaDTO entityPartidaDTO) {
        String id = this.idControl.getIdSubpartida();

        if (!this.repositorySubpartidas.existsById(id)) {
            Subpartida subpartida = new Subpartida(id, id, entityPartidaBD.getIdSubpartida(), entityPartidaBD.getEstatus(), "Subpartidas", "02-02-2023", "No definido");
            Set<ConstraintViolation<Subpartida>> violations = validator.validate(subpartida);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            Categoria categoria = agregaCategoria(subpartida, entityPartidaDTO);
            subpartida.getCategorias().add(categoria);
            agregaLote(categoria, entityPartidaDTO);
            agregaItems(categoria, entityPartidaDTO);
            entityPartidaDTO.getSubpartidas().add(subpartida);
            entityPartidaBD.getSubpartidas().add(subpartida);
            repositorySubpartidas.save(subpartida);
            repositoryPartidas.save(entityPartidaBD);
            return subpartida;
        } else {
            Optional<Subpartida> subpartida = this.repositorySubpartidas.findById(id);
            Categoria categoria = agregaCategoria(subpartida.get(), entityPartidaDTO);
            agregaLote(categoria, entityPartidaDTO);
            agregaItems(categoria, entityPartidaDTO);
            return subpartida.get();
        }
    }


    private Categoria agregaCategoria(Subpartida subpartida, PartidaDTO entityPartidaDTO) {
        String id = this.idControl.getIdCategoria();

        String idDTO = this.idControlDTO.getIdCategoria();

        if (!this.repositoryCategoria.existsById(idDTO)) {
            Categoria categoria = new Categoria(idDTO, entityPartidaDTO);
            Set<ConstraintViolation<Categoria>> violations = validator.validate(categoria);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }

            subpartida.getCategorias().add(categoria);
            agregaLote(categoria, entityPartidaDTO);
            agregaItems(categoria, entityPartidaDTO);
            repositoryCategoria.save(categoria);
            return categoria;
        } else {
            Optional<Categoria> categoria = this.repositoryCategoria.findById(idDTO);
            subpartida.getCategorias().add(categoria.get());
            agregaLote(categoria.get(), entityPartidaDTO);
            agregaItems(categoria.get(), entityPartidaDTO);
            return categoria.get();
        }
    }

    private void agregaLote(Categoria categoria, PartidaDTO entityPartidaDTO) {
        String id = this.idControl.getIdLote();

        String idDTO = this.idControlDTO.getIdLote();

        if (!this.repositoryLote.existsById(idDTO)) {
            Lote lote = new Lote(idDTO, entityPartidaDTO);
            Set<ConstraintViolation<Lote>> violations = validator.validate(lote);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }

            categoria.getLotes().add(lote);
            agregaItems(categoria, entityPartidaDTO);
            repositoryLote.save(lote);
        } else {
            Optional<Lote> lote = this.repositoryLote.findById(idDTO);
            categoria.getLotes().add(lote.get());
            repositoryCategoria.save(categoria);
        }
    }

    private void agregaItems(Categoria categoria, PartidaDTO entityPartidaDTO) {

        for (int i = 0; i < Integer.parseInt(entityPartidaDTO.getCantidad()); i++) {
            String idDTO = this.idControlDTO.getIdItem(i);

            if (!this.repositoryItem.existsById(idDTO)) {
                Item item = new Item(idDTO, entityPartidaDTO);
                Set<ConstraintViolation<Item>> violations = validator.validate(item);
                if (!violations.isEmpty()) {
                    throw new ConstraintViolationException(violations);
                }

                categoria.getItems().add(item);
                repositoryItem.save(item);
            } else {
                Optional<Item> item = this.repositoryItem.findById(idDTO);
                categoria.getItems().add(item.get());
            }
            //repositoryCategoria.save(categoria);
        }
    }

    public ArrayList<Partida> getAll()
    {
        ArrayList<Partida> listaSolicitudes = (ArrayList<Partida>) this.repositoryPartidas.findAll();
        return listaSolicitudes;
    }
}
