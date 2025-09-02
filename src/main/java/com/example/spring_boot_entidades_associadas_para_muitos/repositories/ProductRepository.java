package com.example.spring_boot_entidades_associadas_para_muitos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boot_entidades_associadas_para_muitos.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
