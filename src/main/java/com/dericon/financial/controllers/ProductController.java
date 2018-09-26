package com.dericon.financial.controllers;

import com.dericon.financial.fileresponse.UploadFileResponse;
import com.dericon.financial.models.Product;
import com.dericon.financial.models.ProductNew;
import com.dericon.financial.repositories.ProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadVariantFile(@RequestParam("file") MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploadFile/")
                .path(fileName)
                .toUriString();

        ObjectMapper objectMapper = new ObjectMapper();

        // objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        try{
            File fileType = this.convert(file);
            Product[] listProducts = objectMapper.readValue(fileType, Product[].class);

            for(Product product : listProducts){
                System.out.println(product);
                productRepository.save(product);
            }

        } catch (IOException e){
            System.out.println(e);
        }

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "_id");
        return productRepository.findAll(sortByCreatedAtDesc);
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        System.out.println(product);
        return productRepository.save(product);
    }

    @GetMapping(value="/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        return productRepository.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id,
                                           @Valid @RequestBody Product product) {
        return productRepository.findById(id)
                .map(productData -> {
                    productData.setDerived(product.getDerived());
                    productData.setIds(product.getIds());
                    productData.setFigures(product.getFigures());

                    Product updatedProduct = productRepository.save(productData);

                    return ResponseEntity.ok().body(updatedProduct);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/productssideyieldpa")
    public List<Product> getAllProductsBySideYieldPa() {
        return productRepository.findTop10ByOrderByFiguresSideYieldPaDesc();
    }

    @GetMapping("/productsspecific")
    public List<ProductNew> getAllProductsSpecific() {

        List<Product> products = productRepository.findByOrderByDerived();

        List<ProductNew> productsNew = new ArrayList<>();

        ProductNew productNew = new ProductNew();

        for(Product product : products){


            productNew.set_id(product.get_id());
            productNew.setIssuerName(product.getDerived().getIssuer().getName());
            productNew.setUnderlyingName(product.getDerived().getUnderlying().getName());
            productNew.setIsin(product.getIds().getIsin());
            productNew.setSideYieldPa(product.getFigures().getSideYieldPa());

            productsNew.add(productNew);

        }

        return productsNew;
    }



    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

}
