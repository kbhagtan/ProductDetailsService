package com.product.details.ProductDetailsService.controller;

import com.product.details.ProductDetailsService.pojos.ProductDetails;
import com.product.details.ProductDetailsService.service.ProductDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@RestController
public class ProductDetailsController {

    @Autowired
    private ProductDetailsServiceImpl productDetailsService;

    /**
     *
     * @param productDetails
     */
    @PostMapping("/saveProductDetails")
    public void saveProductDetails(@RequestBody ProductDetails productDetails) {
        productDetailsService.saveProductDetails(productDetails);
    }

    /**
     *
     * @return productDetails
     */
    @Cacheable("listOfProducts")
    @GetMapping("/productDetails")
    public List<ProductDetails> getAllProductDetails() {
        return productDetailsService.getProductDetailsList();
    }

    /**
     *
     * @param quantity quantity
     * @param productName productName
     * @return Availability
     */
    @ApiIgnore
    @GetMapping("/removeProductFromCart/{quantity}/{productName}")
    public String productCart(@RequestParam int quantity, String productName)  {
        boolean productExists = productDetailsService.checkIfProductExists(productName);
        if (productExists) {
            productDetailsService.addItemToCart(quantity, productName);
            return "Added to cart";
        } else
            return "Item Unavailable";
    }
}
