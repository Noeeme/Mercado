package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.ItemRequest;
import org.example.dto.response.ItemResponse;
import org.example.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    @Transactional
    public ResponseEntity<ItemResponse> salvaItem(@Valid @RequestBody ItemRequest itemRequest){
        ItemResponse itemResponse = itemService.salvar(itemRequest);
        return ResponseEntity.ok(itemResponse);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> listarItens(){
        List<ItemResponse> itens = itemService.listar();
        return ResponseEntity.ok(itens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody ItemRequest itemRequest){
        itemService.atualizar(id, itemRequest);
        return ResponseEntity.noContent().build();
    }
}
