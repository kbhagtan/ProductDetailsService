package com.product.details.ProductDetailsService.repository;

import com.product.details.ProductDetailsService.pojos.ProductDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductDetailsRepository extends CrudRepository<ProductDetails, Long> {

    @Query("SELECT p FROM ProductDetails p WHERE p.quantity > 0")
    List<ProductDetails> findAllByQuantityGreaterThanZero();

    @Transactional
    @Modifying
    @Query("UPDATE ProductDetails set quantity = quantity - :quan where productName = :proName")
    void removeProductDetailsByQuantityAndProductName(@Param("quan") int quantity, @Param("proName") String prodName);

    @Query("SELECT COUNT(p.productName) FROM ProductDetails p WHERE p.productName = :proName")
    int checkIfProductExists(@Param("proName") String prodName);


}
