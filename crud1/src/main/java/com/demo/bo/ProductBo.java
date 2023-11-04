package com.demo.bo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.dao.ProductRepository;
import com.demo.entity.Product;
@Component
public class ProductBo {
	@Autowired
	ProductRepository product;

	public Product insertProduct(Product addProduct) {
		return product.save(addProduct);
		
	}
		
	public Product findProduct(Integer id) {
		Optional<Product> clm = product.findById(id);
		return clm.get();
		}
	
	public List<Product> findAllProduct(){
		return product.findAll();
	}
		
	public Product updateProduct(Product updateProduct) {
			return product.save(updateProduct);	
	}

}
