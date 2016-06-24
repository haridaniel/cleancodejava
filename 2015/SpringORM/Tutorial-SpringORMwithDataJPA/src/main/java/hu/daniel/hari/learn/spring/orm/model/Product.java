package hu.daniel.hari.learn.spring.orm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/** 
 * 	This is a data structure, so
 *  fields can be public. (Clean-Code)
 */
@Entity
public class Product {
	
    @Id
	public Integer id;
    public String name;
	
	public Product() {
		//Default constructor needed for JPA.
	}
	public Product(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
}
