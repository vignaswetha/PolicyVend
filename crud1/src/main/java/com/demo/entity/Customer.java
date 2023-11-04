package com.demo.entity;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.NamedQuery;
import org.hibernate.annotations.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="customer_detailss")
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({@NamedQuery(name="Customer.findAllOrderByNameDescending",query="select c from Customer c ORDER BY c.name DESC")})




public class Customer {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      
     
      @Column(unique=true, name = "customer_name")
      private String name;
      
      @JsonManagedReference
      @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "customer")
      private List<Product> product;
      
      @Column(name="street")
      private String street;
      
     
      @Column(name="contact_number")
      private Long contactNumber;
      
      
      @Column(nullable = false,updatable = false)
      @Temporal(TemporalType.TIMESTAMP)
      @CreatedDate
      private Date createdAt;
      
      @Column(nullable = false)
      @Temporal(TemporalType.TIMESTAMP)
      @LastModifiedDate
      private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", street=" + street + ", contactNumber=" + contactNumber
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	
	 
	


}
