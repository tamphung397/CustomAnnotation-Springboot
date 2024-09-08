package com.example.cutomannotationspringboot.service.impl;

import com.example.cutomannotationspringboot.constant.EntityStatus;
import com.example.cutomannotationspringboot.dto.product.CreateProductDto;
import com.example.cutomannotationspringboot.dto.product.ProductDto;
import com.example.cutomannotationspringboot.dto.product.UpdateProductDto;
import com.example.cutomannotationspringboot.exception.SpringDemoException;
import com.example.cutomannotationspringboot.service.ProductService;
import com.example.cutomannotationspringboot.springdata.entity.Product;
import com.example.cutomannotationspringboot.springdata.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public ProductDto getProductById(int id) throws SpringDemoException {
        Optional<Product> productEntityOptional = productRepository.findById(id);
        Product productEntity = productEntityOptional.orElseThrow(() -> new SpringDemoException("Not found product"));
        return modelMapper.map(productEntity, ProductDto.class);
    }

    @Override
    public ProductDto createProduct(CreateProductDto createProductDto) {
        Product product = modelMapper.map(createProductDto, Product.class);
        product.setStatus(EntityStatus.ProductStatusEnum.ACTIVE.ordinal());
        Product savedProduct = productRepository.save(product);

        //return saved data
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(UpdateProductDto updateProductDto) throws SpringDemoException {
        Optional<Product> productEntityOptional = productRepository.findById(updateProductDto.getId());
        Product productEntity = productEntityOptional.orElseThrow(() -> new SpringDemoException("Not found product"));

        //update data
        productEntity.setName(updateProductDto.getName());
        productEntity.setDescription(updateProductDto.getDescription());
        productEntity.setPrice(updateProductDto.getPrice());
        Product savedProduct = productRepository.save(productEntity);

        //return saved data
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(int id) throws SpringDemoException {
        Optional<Product> productEntityOptional = productRepository.findById(id);
        Product productEntity = productEntityOptional.orElseThrow(() -> new SpringDemoException("Not found product"));
        productEntity.setStatus(EntityStatus.ProductStatusEnum.DISABLE.ordinal());
        productRepository.save(productEntity);
    }
}
