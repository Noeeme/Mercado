package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.repositories.ClienteRepository;
import org.example.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckoutService {

    private final ItemRepository itemRepository;
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    public void calculaTotal(){

    }

    public void verificaEstoque(){

    }

    public void agrupaInfo(){

    }

    public void enviaRequisicao(){

    }
}
