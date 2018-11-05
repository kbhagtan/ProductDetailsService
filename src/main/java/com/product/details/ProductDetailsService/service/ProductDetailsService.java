package com.product.details.ProductDetailsService.service;

import com.product.details.ProductDetailsService.pojos.ProductDetails;

import java.util.List;


public interface ProductDetailsService {

   public  void saveProductDetails(ProductDetails productDetails);

   public List<ProductDetails> getProductDetailsList();

   public void addItemToCart(int quantity, String prodName);

   public boolean checkIfProductExists(String productName);
}
