package com.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	@Query(value="select c from Customer c where c.id< :id")
	List<Customer> filterById(@Param("id") int id);
	
	//@Query("select c from Customer c where c.name LIKE % :name%")
	//List<Customer>filterByName(@Param("name")String name);

	//NamedQuery
    List<Customer> findAllOrderByNameDescending();
    

    
  //Inner Join
  	//@Query("select c from Customer c JOIN c.product p")
  	//List<Customer> findCustomerWithPers();
  	
  	
  	//Left Outer Join
  	//@Query("select c from Customer c left JOIN c.product")
      //List<Customer> findCustomerWithPersLeft();

  	//customized data by join
  	//@Query("select c.name as name,c.street as street from Customer c JOIN c.product")
  	//List<CustomerCustomized> findCustomerWithPersCust();

}
