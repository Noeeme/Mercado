package com.sprint.sprint5.services;

import com.sprint.sprint5.models.Pedido_itens;
import com.sprint.sprint5.models.Pedido_itens_ofertas;
import com.sprint.sprint5.models.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class OfertaServiceTest {

    @InjectMocks
    private OfertaService ofertaService;

    @Test
//            (expected = DataValidadeOfertaInvalida.class)
    public void dataCriacaoDeOfertaMaiorQueValidade() {
        Pedido pedido = new Pedido();
        Pedido_itens item = new Pedido_itens();
        item.setId(1l);
        Pedido_itens_ofertas oferta = new Pedido_itens_ofertas();
        oferta.setId(1l);
        List<Pedido_itens_ofertas> ofertas = new ArrayList<>();
        List<Pedido_itens> items = new ArrayList<>();

        LocalDateTime dateTime = LocalDateTime.of(2022,5,2,11,22,0);

        ofertas.add(oferta);
        item.setOfertas(ofertas);
        items.add(item);
        pedido.setItens(items);

        pedido.getItens().get(0).getOfertas().get(0).setDataCriacao(LocalDateTime.now());
        pedido.getItens().get(0).getOfertas().get(0).setDataValidade(dateTime);


        boolean data = ofertaService.dataCriacaoDeOfertaMaiorQueValidade(pedido);

        Assertions.assertTrue(data);
//        Assertions.assertNotNull(pedido);
//        Assertions.assertThrows("Data de validade da oferta inválida");
    }
}