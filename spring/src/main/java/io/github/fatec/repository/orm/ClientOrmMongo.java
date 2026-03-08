package io.github.fatec.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "client")
public record ClientOrmMongo(
        @Id String id,
        String name,
        String address,
        String phone) {
}