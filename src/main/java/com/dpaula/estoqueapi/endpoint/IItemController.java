package com.dpaula.estoqueapi.endpoint;

import com.dpaula.estoqueapi.payload.ItemPayload;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/itens")
@CrossOrigin(origins = "*")
@Tag(name = "Itens", description = "Serviços para gerenciar itens de estoque")
public interface IItemController {

    @Operation(summary = "Incluir Item", description = "Post para incluir itens ao estoque")
    @PostMapping()
    ResponseEntity<ItemPayload> post(@NotNull @Valid @RequestBody final ItemPayload itemInput);

    @Operation(summary = "Listar Itens", description = "Listar todos os Itens")
    @GetMapping()
    ResponseEntity<Page<ItemPayload>> listAll(@Parameter(hidden = true) Pageable pageable);

    @Operation(summary = "Retirar Item", description = "Remove item do estoque")
    @PostMapping("retirar")
    ItemPayload retirarItem(@RequestParam(value = "idItem", required = false) String idItem);
}
