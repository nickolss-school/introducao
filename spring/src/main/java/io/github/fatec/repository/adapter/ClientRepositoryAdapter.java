package io.github.fatec.repository.adapter;

import io.github.fatec.entity.Client;
import io.github.fatec.repository.orm.ClientOrmMongo;

public class ClientRepositoryAdapter {
    private ClientRepositoryAdapter() {
    }

    public static Client castOrm(ClientOrmMongo orm) {
        return new Client(
                orm.id(),
                orm.name(),
                orm.address(),
                orm.phone());
    }

    public static ClientOrmMongo castEntity(Client entity) {
        return new ClientOrmMongo(
                entity.id(),
                entity.name(),
                entity.address(),
                entity.phone());
    }
}
