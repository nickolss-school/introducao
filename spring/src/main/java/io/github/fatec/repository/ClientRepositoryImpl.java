package io.github.fatec.repository;

import io.github.fatec.entity.Client;
import io.github.fatec.repository.adapter.ClientRepositoryAdapter;
import io.github.fatec.repository.mongo.ClientRepositoryWithMongoDB;
import io.github.fatec.repository.orm.ClientOrmMongo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientRepositoryWithMongoDB repository;

    public ClientRepositoryImpl(ClientRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) {
        ClientOrmMongo orm = ClientRepositoryAdapter.castEntity(client);
        ClientOrmMongo ormSave = repository.save(orm);
        return ClientRepositoryAdapter.castOrm(ormSave);
    }

    @Override
    public Client findById(String id) {
        ClientOrmMongo orm = repository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientRepositoryAdapter.castOrm(orm);
    }

    @Override
    public void deleteById(String id) {
        ClientOrmMongo orm = repository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        repository.delete(orm);
    }

    @Override
    public Client update(String id, Client client) {
        ClientOrmMongo existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        ClientOrmMongo updated = new ClientOrmMongo(
                existing.id(),
                client.name(),
                client.address(),
                client.phone());

        ClientOrmMongo saved = repository.save(updated);

        return ClientRepositoryAdapter.castOrm(saved);
    }

    @Override
    public List<Client> findAll() {
        List<ClientOrmMongo> ormList = repository.findAll();
        return ormList.stream()
                .map(ClientRepositoryAdapter::castOrm)
                .toList();
    }
}
