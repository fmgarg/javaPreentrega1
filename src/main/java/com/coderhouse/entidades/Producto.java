package com.coderhouse.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Clients")
public class Producto {
    @Id
    @Column(name="sku")
    private Integer "sku";
    @Column(name="productTitle")
    private String "productTitle";
    @Column(name="productDescription")
    private String "productDescription";
    @Column(name="productStock")
    private Integer "productStock";
    @Column(name="productPrice")
    private Integer "productPrice";


}
