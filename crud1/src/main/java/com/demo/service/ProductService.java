package com.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bo.ProductBo;
import com.demo.entity.Product;

@Component

public class ProductService {
	
		
		@Autowired
		ProductBo servicesBO;
		
		public Product insertServiceProduct(Product addProduct) {
			return servicesBO.insertProduct(addProduct);
		}
		
		public Product findServiceProduct(Integer id) {
			return  servicesBO.findProduct(id);
			
			}
		
		public List<Product> findAllServiceProduct(){
			return servicesBO.findAllProduct();
		}
			
		public Product updateServiceProduct(Product updateProduct) {
				return servicesBO.updateProduct(updateProduct);	
		}

	}

