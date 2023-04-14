package uia.com.api.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uia.com.api.inventario.dto.LotesDTO;
import uia.com.api.inventario.service.LoteService;


@RestController
@RequestMapping("/Lotes")
@CrossOrigin(origins = "http://localhost:4200")
public class LotesController {

    private LoteService loteService;

    @Autowired
    public LotesController(LoteService loteService) {
        this.loteService = loteService;
    }


    @PostMapping
    public ResponseEntity<LotesDTO> save(@RequestBody LotesDTO lotesDTO)
    {
        LotesDTO response = loteService.save(lotesDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
