package io.github.fatec.repository;

import io.github.fatec.entity.Client;

public interface ClientRepository {
    Client save(Client client);

    Client findById(String id);

    void deleteById(String id);

    Client update(String id, Client client);
}