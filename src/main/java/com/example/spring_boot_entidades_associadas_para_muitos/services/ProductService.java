package com.example.spring_boot_entidades_associadas_para_muitos.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_entidades_associadas_para_muitos.dto.CategoryDTO;
import com.example.spring_boot_entidades_associadas_para_muitos.dto.ProductDTO;
import com.example.spring_boot_entidades_associadas_para_muitos.entities.Category;
import com.example.spring_boot_entidades_associadas_para_muitos.entities.Product;
import com.example.spring_boot_entidades_associadas_para_muitos.repositories.CategoryRepository;
import com.example.spring_boot_entidades_associadas_para_muitos.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }


//    public ProductDTO insert(ProductDTO dto) {
//        Product entity = new Product();
//        entity.setName(dto.getName());
//        entity.setPrice(dto.getPrice());
//
//        for(CategoryDTO cat: dto.getCategories()) {
//            Category category = categoryRepository.findById(cat.getId()).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
//            // Category category = new Category();
//            // category.setId(cat.getId());
//            entity.getCategories().add(category);
//        }
//        entity = productRepository.save(entity);
//        return new ProductDTO(entity);
//    }
}
