package com.example.cutomannotationspringboot.controller;

import com.example.cutomannotationspringboot.dto.product.CreateProductDto;
import com.example.cutomannotationspringboot.dto.product.ProductDto;
import com.example.cutomannotationspringboot.dto.product.UpdateProductDto;
import com.example.cutomannotationspringboot.exception.SpringDemoException;
import com.example.cutomannotationspringboot.service.ProductService;
import com.example.cutomannotationspringboot.validator.annotation.TamValidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    @TamValidateRequest
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto createProductDto) {
        ProductDto productDtoResponse = productService.createProduct(createProductDto);
        return ResponseEntity.ok(productDtoResponse);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> productDtoList = productService.getAllProduct();
        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
    public ResponseEntity<ProductDto> getProduct(@PathVariable int id) throws SpringDemoException {
        ProductDto productDto = productService.getProductById(id);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductDto updateProductDto) throws SpringDemoException {
        ProductDto productDtoResponse = productService.updateProduct(updateProductDto);
        return ResponseEntity.ok(productDtoResponse);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProduct(@PathVariable int id) throws SpringDemoException {
        productService.deleteProduct(id);
    }
}
