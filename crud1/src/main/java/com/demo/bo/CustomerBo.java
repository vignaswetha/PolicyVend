package com.demo.bo;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.dao.CustomerCustomized;
import com.demo.dao.CustomerRepository;
import com.demo.entity.Customer;
import com.demo.exception.CustomerException;

@Component
public class CustomerBo {
	@Autowired
	CustomerRepository cus1;
	Customer customer=new Customer();

	public Customer insertCustomer(Customer addCred1) {
		
		if (addCred1.getName() == null || addCred1.getName().isEmpty()) {
	        throw new CustomerException("customer---> name cannot be empty.");
	    }
		return cus1.save(addCred1);
		
	}
		
	public Customer findCustomer (Integer id) {
		Optional<Customer> clm = cus1.findById(id);
		if(clm.isPresent()) {
			Customer c=clm.get();
			return c;
		}
else {
			throw new CustomerException("Inappropriate Id");
		}
	}
	
	public List<Customer> findAllCustomer(){
		if(customer==null) {
			throw new CustomerException("Null value not allowed");
		}
		return cus1.findAll();
	}
		
	public Customer updateCustomer(Customer updateCred1) {
		if(updateCred1.getId()>=900) {
			throw new CustomerException("Inappropriate Id");
		}
			return cus1.save(updateCred1);	
	}

	public List<Customer> filterById(int id){
		return cus1.filterById(id);
		}
	
	/*public List<Customer> filterByName(String name)
	{
		return customer.filterByName(name);
		}*/
	
	public List<Customer> findAllOrderByNameDescending()
	{
		return cus1.findAllOrderByNameDescending();
	}
	/*public List <Customer> findCustomerWithPers()
	{
		return customer.findCustomerWithPers();
	}*/
	
	//Left Join
	/*public List<Customer> findCustomerWithPersLeft()
	{
		return customer.findCustomerWithPersLeft();
	}*/
	//customized data by join
	
	/*public List<CustomerCustomized> findCustomerWithPersCust()
	{
		return customer.findCustomerWithPersCust();
	}*/

}
