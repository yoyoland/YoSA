package sut.sa.g21.repository;

import sut.sa.g21.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
    public
    interface ProductRepository extends JpaRepository<Product, Long> {
       Product findByProductId(long productId);
}