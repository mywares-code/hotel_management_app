package com.sphy.hotelmanagementapplication.repositories;

import com.sphy.hotelmanagementapplication.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}