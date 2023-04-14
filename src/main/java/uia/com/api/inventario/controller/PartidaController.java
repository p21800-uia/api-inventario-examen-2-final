package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uia.com.api.inventario.dto.PartidaDTO;
import uia.com.api.inventario.model.Partida;
import uia.com.api.inventario.service.PartidaService;

import java.util.ArrayList;


@RestController
@RequestMapping("/Partidas")
@CrossOrigin(origins = "http://localhost:4200")
public class PartidaController {

    private PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }


    @PostMapping
    public ResponseEntity<PartidaDTO> save(@RequestBody PartidaDTO partidaDTO)
    {
        PartidaDTO response = partidaService.save(partidaDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<ArrayList<Partida>> save()
    {
        ArrayList<Partida> response = partidaService.getAll();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
