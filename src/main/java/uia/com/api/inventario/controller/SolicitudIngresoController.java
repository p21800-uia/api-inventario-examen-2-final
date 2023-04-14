package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uia.com.api.inventario.dto.SolicitudIngresoDTO;
import uia.com.api.inventario.model.Item;
import uia.com.api.inventario.model.SolicitudIngreso;
import uia.com.api.inventario.service.SolicitudIngresoService;

import java.util.ArrayList;


@RestController
@RequestMapping("/SolicitudIngreso")
@CrossOrigin(origins = "http://localhost:4200")
public class SolicitudIngresoController {

    private SolicitudIngresoService solicitudIngresoService;

    @Autowired
    public SolicitudIngresoController(SolicitudIngresoService solicitudIngresoService) {
        this.solicitudIngresoService = solicitudIngresoService;
    }


    @PostMapping
    public ResponseEntity<SolicitudIngreso> save(@RequestBody SolicitudIngreso item)
    {
        SolicitudIngreso response = null; //solicitudIngresoService.save(item);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<ArrayList<SolicitudIngreso>> getAll()
    {
        ArrayList<SolicitudIngreso> response = null; //solicitudIngresoService.getAll();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
