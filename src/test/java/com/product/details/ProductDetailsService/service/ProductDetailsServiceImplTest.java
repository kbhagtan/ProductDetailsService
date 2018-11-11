package com.product.details.ProductDetailsService.service;

import com.product.details.ProductDetailsService.pojos.ProductDetails;
import com.product.details.ProductDetailsService.repository.ProductDetailsRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProductDetailsServiceImplTest {

    @InjectMocks
    private ProductDetailsServiceImpl productDetailsService;

    @Mock
    private ProductDetailsRepository productDetailsRepository;

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
        when(productDetailsRepository.save(productDetails)).thenReturn(productDetails);
        productDetailsService.saveProductDetails(productDetails);
        assertEquals("Blackberry", productDetails.getProductName());
        assertEquals("Medium", productDetails.getSize());
    }

    @Test
    public void checkIfProductExists() {
        when(productDetailsRepository.checkIfProductExists("Puma")).thenReturn(1);
        boolean result = productDetailsService.checkIfProductExists("Puma");
        assertTrue(result);
    }

    @Test
    public void checkIfProductNotExists() {
        when(productDetailsRepository.checkIfProductExists("Nike")).thenReturn(0);
        boolean result = productDetailsService.checkIfProductExists("Nike");
        assertFalse(result);
    }

    @Test
    public void addItemToCart() {
        int quantity = 3;
        String prodName = "Adidas";
        doNothing().when(productDetailsRepository).removeProductDetailsByQuantityAndProductName(quantity, prodName);
        productDetailsService.addItemToCart(quantity, prodName);
    }

    @Test
    public void getProductDetailsList() {
        List<ProductDetails> productDetailsList = getAllDetails();
        when(productDetailsRepository.findAllByQuantityGreaterThanZero()).thenReturn(productDetailsList);
        List<ProductDetails> productDetailsResult = productDetailsService.getProductDetailsList();
        assertEquals("Blackberry", productDetailsResult.get(0).getProductName());
        assertEquals("CottonWorld", productDetailsResult.get(1).getProductName());
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
