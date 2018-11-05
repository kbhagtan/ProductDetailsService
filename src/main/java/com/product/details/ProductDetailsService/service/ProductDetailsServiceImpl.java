package com.product.details.ProductDetailsService.service;

import com.product.details.ProductDetailsService.pojos.ProductDetails;
import com.product.details.ProductDetailsService.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public void saveProductDetails(ProductDetails productDetails) {
        productDetailsRepository.save(productDetails);
    }

    @Override
    public List<ProductDetails> getProductDetailsList() {
        return productDetailsRepository.findAllByQuantityGreaterThanZero();
    }

    @Override
    public void addItemToCart(int quantity, String prodName) {
        productDetailsRepository.removeProductDetailsByQuantityAndProductName(quantity, prodName);
    }

    @Override
    public boolean checkIfProductExists(String productName) {
        int count = productDetailsRepository.checkIfProductExists(productName);
        if (count > 0)
            return true;
        else
            return false;
    }
}
