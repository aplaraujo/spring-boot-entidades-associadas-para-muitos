package com.example.spring_boot_entidades_associadas_para_muitos.controllers;

import java.net.URI;

import com.example.spring_boot_entidades_associadas_para_muitos.entities.Product;
import com.example.spring_boot_entidades_associadas_para_muitos.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.spring_boot_entidades_associadas_para_muitos.dto.ProductDTO;
import com.example.spring_boot_entidades_associadas_para_muitos.services.ProductService;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController implements GenericController {

    private final ProductService service;
    private final ProductMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductDTO dto) {
        Product product = mapper.toEntity(dto);
        service.save(product);
        var url = generateHeaderLocation(product.getId());
        return ResponseEntity.created(url).build();
    }

//    @PostMapping
//    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
//        dto = productService.insert(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);
//    }
}
