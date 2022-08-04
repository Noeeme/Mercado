package com.sprint.sprint5.repositories;

import com.sprint.sprint5.models.Pedido_itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Pedido_itens, Long> {
}
