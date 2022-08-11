package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.ItemRequest;
import org.example.dto.response.ItemResponse;
import org.example.entities.Item;
import org.example.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {
    Random random = new Random();
    private final ItemRepository repository;
    private final ModelMapper modelMapper;


    public ItemResponse salvar(ItemRequest itemRequest){
        Item item = modelMapper.map(itemRequest, Item.class);
        item.setSkuid(itemRequest.getNome().substring(0, 2) +
                (random.nextInt(9999999)));
        Item salvo = repository.save(item);

        return modelMapper.map(salvo, ItemResponse.class);
    }

    public List<ItemResponse> listar(){
        List<Item> itens = repository.findAll();
        List<ItemResponse> responses = itens.stream().map(item ->
                modelMapper.map(item, ItemResponse.class)).collect(Collectors.toList());

        return responses;
    }

    public void atualizar(Long id, ItemRequest request){
        Item item = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.save(item);
    }
}
