package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClientList extends CrudRepository<Client, Long> {
    List <Client> findByLastName(String ultimoNome);

    Client findById(long id);
}
