package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.CartaoRequest;
import org.example.dto.response.CartaoResponse;
import org.example.entities.Cartao;
import org.example.entities.Cliente;
import org.example.repositories.CartaoRepository;
import org.example.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CartaoService {

    private final CartaoRepository repository;
    private final ModelMapper modelMapper;
    private final ClienteRepository clienteRepository;

    public CartaoResponse salvar(String cpf, CartaoRequest cartaoRequest){
        Cliente cliente = clienteRepository.findById(Long.valueOf(cpf)).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Cartao cartao = modelMapper.map(cartaoRequest, Cartao.class);
        List<Cartao> cartoesList = cliente.getCartaoList();
        cartoesList.add(cartao);
        cliente.setCartaoList(cartoesList);
        Cliente salvo = clienteRepository.save(cliente);

        return modelMapper.map(salvo, CartaoResponse.class);
    }

    public List<CartaoResponse> listar(String cpf){
        Cliente cliente = clienteRepository.findById(Long.valueOf(cpf)).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<CartaoResponse> responses = cliente.getCartaoList().stream().map(cartoesEntity ->
                modelMapper.map(cartoesEntity, CartaoResponse.class)).collect(Collectors.toList());

        return responses;
    }

    public void atualizar(String cpf, Long id, CartaoRequest request){
        Cliente cliente = clienteRepository.findById(Long.valueOf(cpf)).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Cartao cartao = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.save(cartao);
    }
}
