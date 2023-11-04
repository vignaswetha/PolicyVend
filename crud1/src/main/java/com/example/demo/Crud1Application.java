package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import com.demo.dao.CustomerCustomized;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.demo.entity.Customer;
import com.demo.service.CustomerService;
import com.demo.entity.Product;
import com.demo.service.ProductService;


@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.demo")
@EntityScan(basePackages = {"com.demo.entity"})
@EnableJpaRepositories("com.demo.dao")


public class Crud1Application {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(Crud1Application.class, args);
		System.out.println("Success!!!");
	
	//task 1 insert customer
		/*	CustomerService service = ctx.getBean(CustomerService.class);
			Customer customer = new Customer();
			customer.setName("vinushkar");
			//customer.setId(1);
			customer.setStreet("vinu street");
			customer.setContactNumber(997565490l);
			
		   service.insertServiceCustomer(customer);
			
			//task 2 insert claim
			ProductService prodservice = ctx.getBean(ProductService.class);
			Product prod = new Product();
			prod.setProductName("van");
			prod.setBudget(50000);
			 
			Customer custom = new Customer();
			custom.setId(1);
			//prod.setCustomer(custom);
			//prodservice.insertServiceProduct(prod);
			
			//task 3 insert claim
			Product p1 = new Product();
			p1.setProductName("vvv");
			p1.setBudget(10000);
			
			Product p2 = new Product();
			p2.setProductName("sss");
			p2.setBudget(90000);
			//insert Customer
			Customer cu1 = new Customer();
			cu1.setContactNumber(9856407865l);
			cu1.setName("meera");
			cu1.setStreet("SR street");
			
			//Associating Claim to Customer
			p1.setCustomer(cu1);
			p2.setCustomer(cu1);
			
			//Associating Customer with Claim
			List<Product> cu2 = new ArrayList<Product>();
			cu2.add(p1);
			cu2.add(p2);
			cu1.setProduct(cu2);
			
			System.out.println("Adding Customer.......");
			CustomerService service3 = ctx.getBean(CustomerService.class);
			//service3.insertServiceCustomer(cu1);*/
			
			//Transaction
			//CustomerService tsc  = ctx.getBean(CustomerService.class); */
			/*Product product = new Product();
			product.setProductName("fridge");
			product.setBudget(60000);
			
			Customer cust1 = new Customer();
			cust1.setId(2);
			product.setCustomer(cust1);
			
			Customer cust2 = new Customer();
			cust2.setContactNumber(9043245907l);
			cust2.setName("anjush");
			cust2.setStreet("SRR Street");*/
	
			
			//tsc.transactionProductManagement(cust2, product);
			
			//@query1
			/*List<Customer> list=tsc.filterById(8);
			System.out.println("Customer based on id"+list);*/
			
			//@query2
			//List<Customer> list1=tsc.filterByName("e");
			//System.out.println("Customer  name with i"+list1);
			
			//named query
		    //System.out.println("Customer details Order by name desc: "+tsc.findAllOrderByNameDescending());
		    
		    //List<Customer> list3 = tsc.findCustomerWithPers();
			//System.out.println("Customer with Personal_details Inner Join: " + list3);
			
			//Left Join 
			/*List<Customer> list4 = tsc.findCustomerWithPersLeft();
			System.out.println("Credentials with Personal_details Left Join: " + list4);*/
			
			//customized data by Join 
			/*List<CustomerCustomized> list5 = tsc.findCustomerWithPersCust();
			for(CustomerCustomized cust: list5) {
				System.out.println("Customer with Personal_details customized Join: " + cust.getName()+"-"+cust.getStreet());
			}*/
		    
			
			//fetch
			//System.out.println(service.findServiceCustomer(1));
			
			//fetchAll
			//System.out.println(service.findAllServiceCustomer());
			
			
			//update
			//customer.setId(2);
			//customer.setEmail("tanjiro@gmail.com");
			//service.updateServiceCustomer(customer);		
			}

	}


