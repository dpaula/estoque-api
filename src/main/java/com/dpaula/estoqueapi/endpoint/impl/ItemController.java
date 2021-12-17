package com.dpaula.estoqueapi.endpoint.impl;

import com.dpaula.estoqueapi.endpoint.IItemController;
import com.dpaula.estoqueapi.entity.Item;
import com.dpaula.estoqueapi.payload.ItemPayload;
import com.dpaula.estoqueapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ItemController implements IItemController {

    private final ItemService service;

    @Override
    public ResponseEntity<ItemPayload> post(final ItemPayload itemInput) {
        final ItemPayload item = ItemPayload.parse(service.post(Item.parse(itemInput)));
        return ResponseEntity.ok(item);
    }

    @Override
    public  ResponseEntity<Page<ItemPayload>> listAll(final Pageable pageable) {
        final Page<ItemPayload> itensPage = service.listAll(pageable)
            .map(ItemPayload::parse);

        return ResponseEntity.ok(itensPage);
    }

    @Override
    public ItemPayload retirarItem(final String itemId) {
        return ItemPayload.parse(service.removerItemEstoque(itemId));
    }
}
