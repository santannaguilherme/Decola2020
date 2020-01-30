package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Supplier {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;


    @Column(name = "CompanyName",nullable = false, length = 40,columnDefinition = "nvarchar")
    private String companyName;

    @Column(name = "ContactName",nullable = true, length = 50,columnDefinition = "nvarchar")
    private String contactName;

    @Column(name = "ContactTitle",nullable = true, length = 40,columnDefinition = "nvarchar")
    private String contactTitle;

    @Column(name = "City",nullable = true, length = 40,columnDefinition = "nvarchar")
    private String city;

    @Column(name = "Country",nullable = true, length = 40,columnDefinition = "nvarchar")
    private String country;

    @Column(name = "Phone",nullable = true, length = 30,columnDefinition = "nvarchar")
    private String phone;

    @Column(name = "Fax",nullable = true, length = 30,columnDefinition = "nvarchar")
    private String fax;


    

}
