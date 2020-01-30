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

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "FirstName",nullable = false, length = 40,columnDefinition = "nvarchar")
    private String firstName;

    @Column(name = "LastName",nullable = false, length = 40,columnDefinition = "nvarchar")
    private String lastName;

    @Column(name = "City",nullable = false, length = 40,columnDefinition = "nvarchar")
    private String city;

    @Column(name = "Country",nullable = false, length = 40,columnDefinition = "nvarchar")
    private String country;

    @Column(name = "Phone",nullable = false, length = 40,columnDefinition = "nvarchar")
    private String phone;
}