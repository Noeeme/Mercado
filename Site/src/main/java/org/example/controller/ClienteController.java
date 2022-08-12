package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.ClienteRequest;
import org.example.dto.response.ClienteResponse;
import org.example.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> salvaCliente(@Valid @RequestBody ClienteRequest clienteRequest){
        ClienteResponse clientResponse = clienteService.salvar(clienteRequest);
        return  ResponseEntity.ok(clientResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarClientes(){
        List<ClienteResponse> cliente = clienteService.listar();
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable Long id,
                                                 @Valid @RequestBody ClienteRequest clienteRequest){
        clienteService.atualizar(id, clienteRequest);
        return ResponseEntity.noContent().build();
    }
}
