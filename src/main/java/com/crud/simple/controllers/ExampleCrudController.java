package com.crud.simple.controllers;

import com.crud.simple.dto.ProductDto;
import com.crud.simple.services.ExampleCrudService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/examples")
public class ExampleCrudController {

    @Autowired
    ExampleCrudService exampleCrudService;


    @PostMapping("/save")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(exampleCrudService.createProduct(productDto));
    }

    @GetMapping("/find/{idProduct}")
    public ResponseEntity<ProductDto> saveProduct(@PathVariable UUID idProduct){
        return ResponseEntity.ok(exampleCrudService.findProduct(idProduct));
    }

    @GetMapping("/findParam")
    public ResponseEntity<ProductDto> getFind(@PathParam("codeProduct") UUID idProduct ){
        return ResponseEntity.ok(exampleCrudService.findProduct(idProduct));
    }

    @GetMapping("/marina")
    public ResponseEntity<String> getMarina(){
        return ResponseEntity.ok("marina esta com muito sono");
    }

    @GetMapping("/lara")
    public ResponseEntity<String> getLara(){
        return ResponseEntity.ok("lais esta na sala e marina preucupada " );
    }


    @GetMapping("/lais")
    public ResponseEntity<String> getLais() { return ResponseEntity.ok("lais");}
}
