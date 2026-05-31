package com.shop.project.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.project.Entitys.Addresses;
import java.util.Optional;
public interface AddressRepository extends JpaRepository<Addresses,Long>{

    Optional<Addresses> findByStreet(String street);
}
