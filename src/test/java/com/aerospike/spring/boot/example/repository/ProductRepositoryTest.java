package com.aerospike.spring.boot.example.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aerospike.spring.boot.example.configuration.RepositoryConfiguration;
import com.aerospike.spring.boot.example.domain.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {
	@Autowired
	private ProductRepository productRepository;

    @SuppressWarnings("unused")
	@Test
    public void testSaveProduct(){
    	Product product = new Product();
    	product.setDescription("Spring Data for Aerospike Shirt");
    	product.setPrice(18.95);
    	product.setProductId("1234");
    	product.setId(100);

    	productRepository.deleteAll();
    	productRepository.save(product);
    	assertNotNull(product.getId()); //not null after save

	    //fetch from DB
	    Product fetchedProduct = productRepository.findOne(product.getId());
	
	    //should not be null
	    assertNotNull(fetchedProduct);
	
	    //should equal
	    assertEquals(product.getId(), fetchedProduct.getId());
	    assertEquals(product.getDescription(), fetchedProduct.getDescription());
	
	    //update description and save
	    fetchedProduct.setDescription("New Description");
	    productRepository.save(fetchedProduct);
	
	    //get from Aerospike, should be updated
	    Product fetchedUpdatedProduct = productRepository.findOne(fetchedProduct.getId());
	    assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());
	
	    //verify count of products in DB
	    long productCount = productRepository.count();
	    assertEquals(productCount, 1);
	
	    //get all products, list should only have one
	    Iterable<Product> products = productRepository.findAll();
	
	    int count = 0;
	    for (Product p : products) {
	        count++;
	    }
	
	    assertEquals(count, 1);
    }
}
