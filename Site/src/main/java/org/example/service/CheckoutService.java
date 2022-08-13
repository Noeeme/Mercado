package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.response.PedidoDTO;
import org.example.dto.response.PedidoItemDTO;
import org.example.entities.Item;
import org.example.repositories.ClienteRepository;
import org.example.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CheckoutService {

    private final ItemRepository itemRepository;
    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;
    private final WebClient.Builder webClient;

//    public CheckoutDtoResponse salvar(CheckoutDtoRequest checkoutDtoRequest){
//        Cliente cliente = clienteRepository.findById(checkoutDtoRequest.getCliente().getCartaoId())
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));6
//    }

    public double calculaTotal(List<PedidoItemDTO> pedidoItemDTOS){
        double total = 0.0;
        for (PedidoItemDTO pedidoItemDTO: pedidoItemDTOS) {
            double itensValor = pedidoItemDTO.getValor() * pedidoItemDTO.getQtd();
            total += itensValor;
        }
        return total;
    }

    public void verificaEstoqueEAtualiza(PedidoItemDTO pedidoItemDTO, Item item){
        if(pedidoItemDTO.getQtd() > item.getEstoque()){
            throw new ResponseStatusException(HttpStatus.INSUFFICIENT_STORAGE);
        }else{
            item.setEstoque(item.getEstoque() - pedidoItemDTO.getQtd());
        }
    }

    public void agrupaInfo(){

    }

    public PedidoDTO enviaRequisicao(PedidoDTO pedidoDTO){
        String url = "http://localhost:8080/api/pedido";

        PedidoDTO pedido = webClient.build()
                .post()
                .uri(url)
                .bodyValue(pedidoDTO)
                .retrieve()
                .bodyToMono(PedidoDTO.class)
                .block();
        return pedido;
    }
}
