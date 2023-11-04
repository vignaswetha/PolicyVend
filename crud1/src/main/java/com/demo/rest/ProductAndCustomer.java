package com.demo.rest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.bo.CustomerBo;
import com.demo.bo.ProductBo;
import com.demo.dao.CustomerCustomized;
import com.demo.dao.UserRepository;
import com.demo.dto.CustomerDTO;
import com.demo.dto.LoginRequest;
import com.demo.entity.Customer;
import com.demo.entity.Product;
import com.demo.entity.User;
import com.demo.exception.CustomerException;
import com.demo.response.CustomerResponse;

@CrossOrigin
@RestController
public class ProductAndCustomer {
	@Autowired
	CustomerBo customer;
	
	@Autowired
	ProductBo product;
	
	@Autowired
    private UserRepository ur;
	
	@RequestMapping(value="/createCustomer",method=RequestMethod.POST)
	public CustomerResponse<CustomerDTO> insertCred1(@RequestBody CustomerDTO msg) {
		System.out.println("Id:"+msg.getId());
		System.out.println("Name:"+msg.getName());
		System.out.println("Street:"+msg.getStreet());
		System.out.println("ContactNumber:"+msg.getContactNumber());

        Customer c = new Customer();
        c.setName(msg.getName());
        c.setStreet(msg.getStreet());
        c.setContactNumber(msg.getContactNumber());
        
        Customer c1=customer.insertCustomer(c);
        msg.setId(c1.getId());
        msg.setCreatedAt(c1.getCreatedAt());
        msg.setCreatedAt(c1.getUpdatedAt());
        return new CustomerResponse<>(true, "Customer created successfully", msg);
	}
	
	//FindById(parent)
	@RequestMapping(value="/findCustomerById",method=RequestMethod.GET)
	public CustomerResponse<CustomerDTO> findCred1(@RequestParam int id) {
	//public CustomerDTO findCred(@RequestParam int id){
	
		System.out.println("ID: "+id);
		Customer c2=customer.findCustomer(id);
		CustomerDTO dto=new CustomerDTO();
		dto.setId(c2.getId());
		dto.setName(c2.getName());
		dto.setStreet(c2.getStreet());
		dto.setContactNumber(c2.getContactNumber());
		dto.setCreatedAt(c2.getCreatedAt());
		dto.setUpdatedAt(c2.getUpdatedAt());
		return new CustomerResponse<>(true, "customer found successfully", dto);
    
		//return dto;
	}
	
	//FindAll(parent)
	@RequestMapping(value="/findAllCustomer",method=RequestMethod.GET)
	public CustomerResponse<List<Customer>> findAllCred() {
        List<Customer> fetchAll = customer.findAllCustomer();
    
	//public List<CustomerDTO> findAllCred(){
		//List<Customer> credentials=customer.findAllCred1();
		List<CustomerDTO> dtos=new ArrayList<>();
		for(Customer c2:fetchAll) {
			CustomerDTO dto=new CustomerDTO();
			dto.setId(c2.getId());
			dto.setName(c2.getName());
			dto.setStreet(c2.getStreet());
			dto.setContactNumber(c2.getContactNumber());
			dto.setCreatedAt(c2.getCreatedAt());
			dto.setUpdatedAt(c2.getUpdatedAt());
			
			dtos.add(dto);
		}
		return new CustomerResponse<>(true, "Credentials fetched successfully", fetchAll);
		//return dtos;
	}
	
	//fetchById(child)
	@RequestMapping(value="/fetchProductById",method=RequestMethod.GET)
	public CustomerResponse<Product> fetchProduct(@RequestParam int Id) {
	//public Product fetchPers(@RequestParam int Id) {
		System.out.println("Id: "+Id);
		Product p=product.findProduct(Id);
		p.getCreatedAt();
		p.getUpdatedAt();
		p.getProductId();
		p.getBudget();
		p.getProductName();
		
		//System.out.println("Personal details fetched successfully...");
		//return p;
		return new CustomerResponse<>(true, "Product details fetched successfully", p);
	}
	
	//fetchAll(child)
	@RequestMapping(value="/fetchAllPers",method=RequestMethod.GET)
	public CustomerResponse<List<Product>> fetchAllPers() {
	//public List<Product> fetchAllPers(){
		List<Product>fetchAll=product.findAllProduct();
		//return fetchAll;
		return new CustomerResponse<>(true, "Product details fetched successfully", fetchAll);

	}
	
	//insert PersonalDetails(child)
	@RequestMapping(value="/createPers",method=RequestMethod.POST)
	public CustomerResponse<Product> addCred2(@RequestBody Product msg) {
		
		System.out.println("ID:"+msg.getCustomer().getId());
		System.out.println("Personal Name:"+msg.getProductName());
		System.out.println("Personal Number:"+msg.getBudget());
		Customer c1=customer.findCustomer(msg.getCustomer().getId());

		System.out.println("Product Details response--->"+c1);
		Product p=new Product();
		
		p.setProductName(msg.getProductName());
		p.setBudget(msg.getBudget());
		Product response=product.insertProduct(msg);
		System.out.println("Product Details(Product) added successfully");
		return new CustomerResponse<>(true, "Product details inserted successfully", response);

		//return response;
		
	}
	
	//update PersonalDetails(child)
	@RequestMapping(value="/updatePers/{id}",method=RequestMethod.POST)
	
	public CustomerResponse<Product> updateProd(@PathVariable("id") int id,@RequestBody Product updatePers) {
		System.out.println("Budget:" + updatePers.getBudget());
		Product p=product.findProduct(id);
	
		p.setBudget(updatePers.getBudget());
		
		Product result=product.updateProduct(p);
		System.out.println("PersonalDetails(Product)updated successfully...");
		return new CustomerResponse<>(true, "Personal details updated successfully", result);
		//return result;
	}
	
	//update(parent)
	@RequestMapping(value="/updateCus/{id}",method=RequestMethod.POST)
	public CustomerResponse<CustomerDTO> updateCred(@PathVariable("id") int id,@RequestBody CustomerDTO msg) {
		//System.out.println("name:"+ msg.getName());
		System.out.println("contact number:" + msg.getContactNumber());
		System.out.println("street:" + msg.getStreet());
		
		Customer c=customer.findCustomer(id);
		c.setContactNumber(msg.getContactNumber());
		c.setStreet(msg.getStreet());
		//c.setName(msg.getName());)
		
		Customer c1=customer.updateCustomer(c);
		CustomerDTO c2= new CustomerDTO();
		c2.setId(c1.getId());
		c2.setContactNumber(c1.getContactNumber());
		c2.setStreet(c1.getStreet());
		c2.setCreatedAt(c1.getCreatedAt());
		c2.setUpdatedAt(c1.getUpdatedAt());
		return new CustomerResponse<>(true, "Customer details updated successfully", c2);

		//return c2;
	}
	
	// Queries Methods
	//GreaterThanId
	/*@RequestMapping(value="/greaterThanId",method=RequestMethod.GET)
	public CustomerResponse<List<Customer>> getPatientById(@RequestParam int id){
	List<Customer> g =customer.filterById(id);
	return new CustomerResponse<>(true, "GreaterThanId details fetched successfully FROM credential details", g);
	//return g;
	}
		
		//FilterByNameCustomized
		@RequestMapping(value = "/findByNameCustomized", method = RequestMethod.GET)
		public CustomerResponse<List<CustomerCustomized>> findApplicantByNameCustomized(@RequestParam String name) 
		{
		    List<CustomerCustomized> list = customer.filterByNameCustomized(name);
			return new CustomerResponse<>(true, "FilterByNameCust details fetched successfully", list);

		    //return list;
		}*/
		
		//FindAllOrderByNameDesc
		@RequestMapping(value = "/findAllOrderByNameDescending", method = RequestMethod.GET)
		public CustomerResponse<List<Customer>> findAllOrderByNameDescending() 
		{
		    List<Customer> list = customer.findAllOrderByNameDescending();
			return new CustomerResponse<>(true, "FindAllOrderByNameDesc details fetched successfully", list);

		    //return list;
		}
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
		    Map<String, Object> response = new HashMap<>();

		    User user =ur.findByUsername(request.getUsername());

		    if (user != null && user.getPassword().equals(request.getPassword())) {
		        response.put("success", true);
		        response.put("message", "Login successful");
		        return ResponseEntity.ok(response);
		    } else {
		        response.put("success", false);
		        response.put("message", "Invalid credentials");
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		    }
		}
}
		
		//Inner Join
		/* @RequestMapping(value = "/credWithPers", method = RequestMethod.GET)
		    public CustomerResponse<List<Customer>> findCredWithPers()
		 {
		        List<Customer> list = customer.findCustomerWithPers();
		    	return new CustomerResponse<>(true, "InnerJoin details fetched successfully", list);
		        //return list;
		 }
		 
		 //Left Outer Join
		 @RequestMapping(value = "/cresWithPersLeft", method = RequestMethod.GET)
		    public CustomerResponse<List<Customer>> findCredWithPersLeft() 
		 {
		        List<Customer> list = customer.findCustomerWithPersLeft();
		    	return new CustomerResponse<>(true, "LeftOuterJoin details fetched successfully", list);
		        //return list;
		 }
		 
		//Customized join
		 @RequestMapping(value = "/credWithPersCustomized", method = RequestMethod.GET)
		    public  CustomerResponse<List <CustomerCustomized>> findCredWithPersCustomized() 
		 {
			 List <CustomerCustomized> list = customer.findCredWithPersCust();
		    	return new CustomerResponse<>(true, "CustomizedJoin details fetched successfully", list);
		        //return list;
		 }
		 
		 @RestControllerAdvice
		 public class GlobalExceptionHandler {
		     @ExceptionHandler(CustomerException.class)
		     public ResponseEntity<String> handleCredException(CustomerException ex) {
		         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		     }
		     
		     // Add other exception handling methods for different custom exceptions if needed
		 }
}
	
	/*@RequestMapping(value="/createCustomer",method=RequestMethod.POST)
	public CustomerResponse<CustomerDTO> insertPd(@RequestBody CustomerDTO msg) {
		System.out.println("Id:"+msg.getId());
		System.out.println("Name:"+msg.getName());
		System.out.println("Street:"+msg.getStreet());
		System.out.println("Contact number:"+msg.getContactNumber());
		
		Customer cu=new Customer();
		//cu.setId(msg.getId());
		cu.setName(msg.getName());
		cu.setStreet(msg.getStreet());
		cu.setContactNumber(msg.getContactNumber());
		
		Customer cu1=customer.insertCustomer(cu);
		msg.setId(cu1.getId());
		msg.setCreatedAt(cu1.getCreatedAt());
		msg.setUpdatedAt(cu1.getUpdatedAt());
		  return new CustomerResponse<>(true, "Customer created successfully", msg);
	}
	@RequestMapping(value="/findCustomer" ,method=RequestMethod.GET)
	public CustomerResponse<CustomerDTO> findById(@RequestParam int id) {
		System.out.println("customer id"+id);
		Customer a= customer.findCustomer(id);
		CustomerDTO dto=new CustomerDTO();
		dto.setId(a.getId());
		dto.setName(a.getName());
		dto.setContactNumber(a.getContactNumber());
		dto.setStreet(a.getStreet());
		dto.setCreatedAt(a.getCreatedAt());
		dto.setUpdatedAt(a.getUpdatedAt());
		return new CustomerResponse<>(true, "Patient found successfully", dto);
}
	
	@RequestMapping(value="/findAll" ,method=RequestMethod.GET)
	public CustomerResponse<List<Customer>> findAll() {
        
		List<Customer> fetchAll=customer.findAllCustomer();
		
		return new CustomerResponse<>(true, "Patients fetched successfully", fetchAll);*/
	
	/*@RequestMapping(value="/updateCustomer/{id}",method=RequestMethod.POST)
	public CustomerDTO updateOp(@PathVariable("id") int id,@RequestBody CustomerDTO msg) {
		System.out.println("name:" + msg.getName());
		System.out.println("ContactNumber:" + msg.getContactNumber());
		System.out.println("street:" + msg.getStreet());
		Customer q=customer.findCustomer(id);
		q.setName(msg.getName());
		q.setContactNumber(msg.getContactNumber());
		q.setStreet(msg.getStreet());
		
		Customer q1=customer.updateCustomer(q);
		CustomerDTO  q2= new CustomerDTO();
		q2.setId(q1.getId());
		q2.setName(q1.getName());
		q2.setContactNumber(q1.getContactNumber());
		q2.setStreet(q1.getStreet());
		q2.setCreatedAt(q1.getCreatedAt());
		q2.setUpdatedAt(q1.getUpdatedAt());
		
		return q2;
	}*/
	// Queries Methods
	
		/*@RequestMapping(value = "/filterByIdd", method = RequestMethod.GET)
		public List<Customer> findCustomerById(@RequestParam int id)
		{
			 List<Customer> list = customer.filterById(id);
			 return list;
		
		
		//FindByName
		/*@RequestMapping(value = "/findByName", method = RequestMethod.GET)
		public List<Customer> findApplicantByName(@RequestParam String name) 
		{
		    List<Customer> list = customer.filterByName(name);
		    return list;
		}
		

		//FindAllOrderByNameDesc
		@RequestMapping(value = "/findAllOrderByNameDescending", method = RequestMethod.GET)
		public List<Customer> findAllOrderByNameDescending() 
		{
		    List<Customer> list = customer.findAllOrderByNameDescending();
		    return list;
		}
		
		

		//Inner Join
		 @RequestMapping(value = "/findCustomerWithPers", method = RequestMethod.GET)
		    public List<Customer> findCustomerWithPers()
		 {
		        List<Customer> list = customer.findCustomerWithPers();
		        return list;
		 }
		 
		 //Left Outer Join
		 @RequestMapping(value = "/CustomerWithPersLeft", method = RequestMethod.GET)
		    public List<Customer> findApplicantWithLoansLeft() 
		 {
		        List<Customer> list = customer.findCustomerWithPersLeft();
		        return list;
		 }
		 
		//Customized join
		 @RequestMapping(value = "/CustomerWitPersCustomized", method = RequestMethod.GET)
		    public  List <CustomerCustomized> findApplicantWithLoansCustomized() 
		 {
			 List <CustomerCustomized> list = customer.findCustomerWithPersCust();
		        return list;
		 }*/


    





