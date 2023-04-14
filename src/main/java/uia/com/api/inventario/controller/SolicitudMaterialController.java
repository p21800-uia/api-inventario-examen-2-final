package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uia.com.api.inventario.dto.SolicitudMaterialDTO;
import uia.com.api.inventario.model.Item;
import uia.com.api.inventario.model.SolicitudMaterial;
import uia.com.api.inventario.service.SolicitudMaterialService;

import java.util.ArrayList;


@RestController
@RequestMapping("/SolicitudMaterial")
@CrossOrigin(origins = "http://localhost:4200")
public class SolicitudMaterialController {

    private SolicitudMaterialService solicitudMaterialService;

    @Autowired
    public SolicitudMaterialController(SolicitudMaterialService solicitudMaterialService) {
        this.solicitudMaterialService = solicitudMaterialService;
    }


    @PostMapping
    public ResponseEntity<SolicitudMaterial> save(@RequestBody SolicitudMaterial item)
    {
        SolicitudMaterial response = solicitudMaterialService.save(item);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<ArrayList<SolicitudMaterial>> getAll()
    {
        ArrayList<SolicitudMaterial> response = solicitudMaterialService.getAll();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
