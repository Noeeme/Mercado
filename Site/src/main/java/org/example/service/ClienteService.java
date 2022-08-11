package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.ClienteRequest;
import org.example.dto.response.ClientResponse;
import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final ModelMapper modelMapper;

    public ClientResponse salvar(ClienteRequest clienteRequest){
        if(repository.existsById(Long.valueOf(clienteRequest.getCpf()))){
            throw new ResponseStatusException(HttpStatus.IM_USED);
        }
        Cliente cliente = modelMapper.map(clienteRequest, Cliente.class);
        Cliente salvo = repository.save(cliente);

        return modelMapper.map(salvo, ClientResponse.class);
    }

    public List<ClientResponse> listar(){
        List<Cliente> clientes = repository.findAll();
        List<ClientResponse> responses = clientes.stream().map(cliente ->
                modelMapper.map(cliente, ClientResponse.class)).collect(Collectors.toList());

        return responses;
    }

    public void atualizar(Long id, ClienteRequest request){
        Cliente cliente = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.save(cliente);
    }
}
