package com.project.omss.repository;

import org.springframework.data.repository.CrudRepository;
import com.project.omss.entity.Cart;

public interface CartJpaRepository extends CrudRepository<Cart,Integer>{

}
