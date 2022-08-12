package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.request.CartaoRequest;
import org.example.dto.response.CartaoResponse;
import org.example.service.CartaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cliente/{clientId}/cartoes")
public class CartaoController {
    private final CartaoService cartaoService;

    @PostMapping
    @Transactional
    public ResponseEntity<CartaoResponse> salvaCartao(@PathVariable String cpf, @Valid @RequestBody CartaoRequest cartaoRequest){
        CartaoResponse cartaoResponse = cartaoService.salvar(cpf, cartaoRequest);
        return ResponseEntity.ok(cartaoResponse);
    }

    @GetMapping
    public ResponseEntity<List<CartaoResponse>> listarCartoes(@PathVariable String cpf){
        List<CartaoResponse> cartoes = cartaoService.listar(cpf);
        return ResponseEntity.ok(cartoes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable String cpf,@PathVariable Long id, @Valid @RequestBody CartaoRequest cartaoRequest){
        cartaoService.atualizar(cpf, id, cartaoRequest);
        return ResponseEntity.noContent().build();
    }
}
