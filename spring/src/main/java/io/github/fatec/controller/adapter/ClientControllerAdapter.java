package io.github.fatec.controller.adapter;

import io.github.fatec.controller.dto.request.ClientRequest;
import io.github.fatec.controller.dto.response.ClientResponse;
import io.github.fatec.entity.Client;

import java.util.UUID;

public class ClientControllerAdapter {
    private ClientControllerAdapter() {
    }

    public static Client castRequest(ClientRequest request) {
        return new Client(
                UUID.randomUUID().toString(),
                request.name(),
                request.address(),
                request.phone());
    }

    public static ClientResponse castResponse(Client client) {
        return new ClientResponse(
                client.id(),
                client.name(),
                client.address(),
                client.phone());
    }
}
