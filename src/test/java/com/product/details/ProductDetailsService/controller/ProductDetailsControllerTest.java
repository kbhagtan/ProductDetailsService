package com.product.details.ProductDetailsService.controller;

import com.product.details.ProductDetailsService.pojos.ProductDetails;
import com.product.details.ProductDetailsService.service.ProductDetailsServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductDetailsControllerTest {

    @InjectMocks
    private ProductDetailsController productDetailsController;

    @Mock
    private ProductDetailsServiceImpl productDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveProductDetails() {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setPrice(1250);
        productDetails.setProductId(2);
        productDetails.setProductName("Blackberry");
        productDetails.setSize("Medium");
        doNothing().when(productDetailsService).saveProductDetails(productDetails);
        productDetailsController.saveProductDetails(productDetails);
    }

    @Test
    public void getAllProductDetails() {
        List<ProductDetails> productDetailsList = getAllDetails();
        when(productDetailsService.getProductDetailsList()).thenReturn(productDetailsList);
        List<ProductDetails> productDetailsResult = productDetailsController.getAllProductDetails();
        assertEquals("Blackberry", productDetailsResult.get(0).getProductName());
        assertEquals("CottonWorld", productDetailsResult.get(1).getProductName());
    }

    @Test
    public void productCart() {
        int quantity = 2;
        String productName = "Blackberry";
        when(productDetailsService.checkIfProductExists(productName)).thenReturn(true);
        doNothing().when(productDetailsService).addItemToCart(quantity, productName);
        String result = productDetailsController.productCart(quantity, productName);
        assertEquals("Added to cart", result);
    }

    @Test
    public void productCartUnavailable() {
        int quantity = 2;
        String productName = "Jack&Jones";
        when(productDetailsService.checkIfProductExists(productName)).thenReturn(false);
        doNothing().when(productDetailsService).addItemToCart(quantity, productName);
        String result = productDetailsController.productCart(quantity, productName);
        assertEquals("Item Unavailable", result);
    }

    private List<ProductDetails> getAllDetails() {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setPrice(1250);
        productDetails.setProductId(2);
        productDetails.setProductName("Blackberry");
        productDetails.setSize("Medium");
        productDetails.setQuantity(2);
        ProductDetails productDetails2 = new ProductDetails();
        productDetails2.setPrice(1850);
        productDetails2.setProductId(3);
        productDetails2.setProductName("CottonWorld");
        productDetails2.setSize("Small");
        productDetails2.setQuantity(5);
        List<ProductDetails> productDetailsList = new ArrayList<>();
        productDetailsList.add(productDetails);
        productDetailsList.add(productDetails2);
        return productDetailsList;
    }
}
