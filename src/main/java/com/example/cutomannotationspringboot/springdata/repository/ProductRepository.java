package com.example.cutomannotationspringboot.springdata.repository;

import com.example.cutomannotationspringboot.springdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
