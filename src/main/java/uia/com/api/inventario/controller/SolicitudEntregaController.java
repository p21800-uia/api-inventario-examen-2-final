package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uia.com.api.inventario.dto.SolicitudEntregaDTO;
import uia.com.api.inventario.model.Item;
import uia.com.api.inventario.model.SolicitudEntrega;
import uia.com.api.inventario.service.SolicitudEntregaService;

import java.util.ArrayList;


@RestController
@RequestMapping("/SolicitudEntrega")
@CrossOrigin(origins = "http://localhost:4200")
public class SolicitudEntregaController {

    private SolicitudEntregaService solicitudEntregaService;

    @Autowired
    public SolicitudEntregaController(SolicitudEntregaService solicitudEntregaService) {
        this.solicitudEntregaService = solicitudEntregaService;
    }


    @PostMapping
    public ResponseEntity<SolicitudEntrega> save(@RequestBody SolicitudEntrega item)
    {
        SolicitudEntrega response = solicitudEntregaService.save(item);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<ArrayList<SolicitudEntrega>> getAll()
    {
        ArrayList<SolicitudEntrega> response = solicitudEntregaService.getAll();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
