package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;


    @Column(name = "ProductName",nullable = false, length = 50,columnDefinition = "nvarchar")
    private String productNAme;

    @ManyToOne
    @JoinColumn(name = "SupplierId", nullable = false)
    private Supplier supplier;

    @Column(name = "UnitPrice",nullable = true,columnDefinition = "decimal")
    private Double unitPrice ;

    @Column(name = "Package",nullable = true, length = 30,columnDefinition = "nvarchar")
    private String pacote;

    @Column(name = "IsDiscontinued",nullable = false)
    private Boolean isDiscontinued;

    @Column(name = "ImagemName",nullable = true, length = 255)
    private String imagemName;
}
