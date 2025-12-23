package com.example.spring_boot_entidades_associadas_para_muitos.dto;

import java.util.List;

public record ProductDTO(Long id, String name, Double price, List<CategoryDTO> categories) {}
