package com.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.entity.*;

@Repository
public interface ProductRepository extends JpaRepository <Product,Integer>{

}

