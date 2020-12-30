package com.project.omss.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.omss.entity.Order;

public interface OrderJpaRepository extends CrudRepository<Order, Integer> {

}
