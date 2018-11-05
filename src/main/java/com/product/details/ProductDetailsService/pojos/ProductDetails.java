package com.product.details.ProductDetailsService.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @Column(name ="product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name= "product_size")
    private String size;

    /**
     *  Default Constructor
     *
     */
    public ProductDetails() {
    }

    /**
     *
     * @param productId
     * @param productName
     * @param price
     * @param quantity
     * @param size
     */
    public ProductDetails(int productId, String productName, int price, int quantity, String size) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
    }

    /**
     *
     * @return productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     *
     * @param productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     *
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }
}
