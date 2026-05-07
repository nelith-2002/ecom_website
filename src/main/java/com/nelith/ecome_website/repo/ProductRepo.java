package com.nelith.ecome_website.repo;

import com.nelith.ecome_website.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product , Integer> {
}
