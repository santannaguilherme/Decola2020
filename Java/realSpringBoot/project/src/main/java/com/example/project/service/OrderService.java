package com.example.project.service;

import java.util.List;

import com.example.project.domain.Orderm;
import com.example.project.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orderm> list() {
        return orderRepository.findAll();
    }
}