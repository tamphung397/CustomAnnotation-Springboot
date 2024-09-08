package com.example.cutomannotationspringboot.service;

import com.example.cutomannotationspringboot.dto.product.CreateProductDto;
import com.example.cutomannotationspringboot.dto.product.ProductDto;
import com.example.cutomannotationspringboot.dto.product.UpdateProductDto;
import com.example.cutomannotationspringboot.dto.staff.CreateStaffDto;
import com.example.cutomannotationspringboot.dto.staff.StaffDto;
import com.example.cutomannotationspringboot.dto.staff.UpdateStaffDto;
import com.example.cutomannotationspringboot.exception.SpringDemoException;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProduct();
    ProductDto getProductById(int id) throws SpringDemoException;
    ProductDto createProduct(CreateProductDto createProductDto);
    ProductDto updateProduct(UpdateProductDto updateProductDto) throws SpringDemoException;
    void deleteProduct(int id) throws SpringDemoException;
}
