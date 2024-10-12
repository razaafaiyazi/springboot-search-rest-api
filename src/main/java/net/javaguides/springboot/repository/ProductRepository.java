package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //BELOW IS JPQL QUERY
    //:query -> this refers to the param we are passing to the query or we can say that
    // it's a placeholder
    @Query("SELECT p FROM Product" +
            "WHERE p.name LIKE CONCAT('%',:query,'%')" +
            "OR p.description LIKE CONCAT('%',:query,'%')")
    List<Product> searchProducts(@Param("query") String query);

    // below is NATIVE QUERY
    // make sure to use the attribute (nativeQuery = true)
    /*@Query(value = "SELECT * FROM products" +
            "WHERE p.name LIKE CONCAT('%',:query,'%')" +
            "OR p.description LIKE CONCAT('%',:query,'%')",nativeQuery = true)
    List<Product> searchProductsSQL(@Param("query") String query);*/
}
