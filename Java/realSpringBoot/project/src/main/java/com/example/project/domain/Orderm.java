package com.example.project.domain;

import java.util.Date;

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
public class Orderm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OrderDate",nullable = false)
    private Date orderDate;

    @Column(name = "OrderNumber",nullable = true, length = 10,columnDefinition = "nvarchar")
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(name = "TotalAmount",nullable = false,columnDefinition = "decimal")
    private Double totalAmount ;
}