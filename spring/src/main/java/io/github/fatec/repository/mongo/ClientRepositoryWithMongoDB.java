package io.github.fatec.repository.mongo;

import io.github.fatec.repository.orm.ClientOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryWithMongoDB extends MongoRepository<ClientOrmMongo, String> {
}