package hu.daniel.hari.learn.spring.orm.repository;

import hu.daniel.hari.learn.spring.orm.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/** 
 * This is the Data Access layer. Simple huh?
 * PLease note that no need for any dao implementation. This is an interface!
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/** No need to define findAll() here, because 
	 * 	inherited from JpaRepository with many other basic JPA operations.**/  
	//public List<Product> findAll();


	/** spring-jpa-data understands this method name,
	 *  because it supports the resolution of specific keywords inside method names. **/
	public List<Product> findByNameContainingIgnoreCase(String searchString);
	
	
    /** You can define a JPA query.**/
	@Query("select p from Product p where p.name = :name")
    public List<Product> findByNameIs(@Param("name") String name);
    
}
