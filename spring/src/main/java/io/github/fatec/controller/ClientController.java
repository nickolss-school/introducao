package io.github.fatec.controller;

import io.github.fatec.controller.adapter.ClientControllerAdapter;
import io.github.fatec.controller.dto.request.ClientRequest;
import io.github.fatec.controller.dto.response.ClientResponse;
import io.github.fatec.entity.Client;
import io.github.fatec.repository.ClientRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    public final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable String id) {
        Client client = clientRepository.findById(id);
        return ResponseEntity.ok(ClientControllerAdapter.castResponse(client));
    }

    @PostMapping("/client/register")
    public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest request) {
        Client client = ClientControllerAdapter.castRequest(request);
        Client clientSalvo = clientRepository.save(client);
        return ResponseEntity.ok(ClientControllerAdapter.castResponse(clientSalvo));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable String id, @RequestBody ClientRequest request) {
        Client client = ClientControllerAdapter.castRequest(request);
        Client updatedClient = clientRepository.update(id, client);
        return ResponseEntity.ok(ClientControllerAdapter.castResponse(updatedClient));
    }

}
