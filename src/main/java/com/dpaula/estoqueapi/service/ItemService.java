package com.dpaula.estoqueapi.service;

import com.dpaula.estoqueapi.entity.Item;
import com.dpaula.estoqueapi.error.ItemNotFoundException;
import com.dpaula.estoqueapi.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemService {

    public static final ZoneId ZONA_ID = ZoneId.of("America/Sao_Paulo");

//    private final StreamBridge streamBridge;

    private final ItemRepository repository;

    public Item post(final Item item) {
        log.info("Incluindo novo item: {}", item.getDescricao());
        item.setDataInclusao(LocalDateTime.now(ZONA_ID));

//        final DataEvent<String, Pedido> event = new DataEvent<>(EventType.CREATE, null, item);
//        final boolean sent = streamBridge.send("supply-out-0", event);


        return repository.save(item);
    }

    public Page<Item> listAll(final Pageable pageable) {
        log.info("Buscando todos os itens");

        return repository.findAll(pageable);
    }

    public Item removerItemEstoque(final String itemId) {
        log.info("Retirando item do estoque, item: {}", itemId);

        final Item item = repository.findById(itemId)
            .orElseThrow(() -> new ItemNotFoundException("Item não encontrado!"));

        item.removerEstoque();
        return repository.save(item);
    }
}
