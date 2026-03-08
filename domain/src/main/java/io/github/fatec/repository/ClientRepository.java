package io.github.fatec.repository;

import java.util.List;

import io.github.fatec.entity.Client;

public interface ClientRepository {
    Client save(Client client);

    Client findById(String id);

    List<Client> findAll();

    void deleteById(String id);

    Client update(String id, Client client);
}