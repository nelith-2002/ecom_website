package com.nelith.ecome_website.controller;

import com.nelith.ecome_website.model.Product;
import com.nelith.ecome_website.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello World!";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts() , HttpStatus.OK) ;
    }

    @GetMapping("/product/{Id}")
    public ResponseEntity <Product> getProductById(@PathVariable int Id){

        Product product = service.getProductById(Id);
        if(product != null){
            return new ResponseEntity<>(product , HttpStatus.OK) ;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile
    ) {
        try {
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){

        Product product = service.getProductById(productId);
        byte[] imageFile = product.getImageDate();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

}
