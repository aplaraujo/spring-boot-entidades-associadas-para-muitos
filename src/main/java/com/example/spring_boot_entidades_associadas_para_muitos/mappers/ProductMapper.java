package com.example.spring_boot_entidades_associadas_para_muitos.mappers;

import com.example.spring_boot_entidades_associadas_para_muitos.dto.CategoryDTO;
import com.example.spring_boot_entidades_associadas_para_muitos.dto.ProductDTO;
import com.example.spring_boot_entidades_associadas_para_muitos.entities.Category;
import com.example.spring_boot_entidades_associadas_para_muitos.entities.Product;
import com.example.spring_boot_entidades_associadas_para_muitos.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryRepository categoryRepository;
    public Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        for(CategoryDTO cat: dto.categories()) {
            Category category = categoryRepository.findById(cat.id()).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
            product.getCategories().add(category);
        }
        return product;
    }

    public ProductDTO toDTO(Product product) {
        List<CategoryDTO> list = product.getCategories().stream().map(cat -> new CategoryDTO(cat.getId(), cat.getName())).toList();
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), list);
    }
}
