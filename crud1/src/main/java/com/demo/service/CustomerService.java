package com.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.demo.bo.CustomerBo;
import com.demo.entity.Customer;
import com.demo.entity.Product;
import com.demo.bo.ProductBo;
import com.demo.dao.CustomerCustomized;
@Component

public class CustomerService {
	@Autowired
	CustomerBo serviceBO;
	
	public Customer insertServiceCustomer(Customer addCustomer) {
		return serviceBO.insertCustomer(addCustomer);
	}
	
	public Customer findServiceCustomer(Integer id) {
		return  serviceBO.findCustomer(id);
		
		}
	
	public List<Customer> findAllServiceCustomer(){
		return serviceBO.findAllCustomer();
	}
		
	public Customer updateServiceCustomer(Customer upCustomer) {
			return serviceBO.updateCustomer(upCustomer);	
	}
	public List<Customer> filterById(Integer PdId)
	{
		return serviceBO.filterById(PdId);
	}
	
	/*public List<Customer> filterByName(String name)
	{
		return serviceBO.filterByName(name);
	}*/
	public List<Customer> findAllOrderByNameDescending()
	{
		return serviceBO.findAllOrderByNameDescending(); 
		}
	/*public List <Customer> findCustomerWithPers()
	{
		return serviceBO.findCustomerWithPers();
	}*/
	
	/*public List<Customer> findCustomerWithPersLeft()
	{
		return serviceBO.findCustomerWithPersLeft();
	}*/
	
	//customized data by join
	/*public List <CustomerCustomized> findCustomerWithPersCust()
	{
		return serviceBO.findCustomerWithPersCust();
	}*/
		
	@Autowired
	CustomerBo serviceBo; 
	
	@Autowired
	ProductBo  serviceProductBo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void transactionProductManagement(Customer c,Product pl) {
		System.out.println("Customer Add-----Before");
		serviceBO.insertCustomer(c);
		System.out.println("Customer Add-----After");
		System.out.println("Product Add-----Before");
		serviceProductBo.insertProduct(pl);
		System.out.println("Product Add-----After");
	}

}

