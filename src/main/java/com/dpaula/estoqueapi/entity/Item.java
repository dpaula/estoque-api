package com.dpaula.estoqueapi.entity;

import com.dpaula.estoqueapi.enuns.EnTipoDepartamento;
import com.dpaula.estoqueapi.payload.ItemPayload;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "itens")
public class Item {

    @Id
    private String id;
    private String descricao;
    private BigDecimal valor;
    private EnTipoDepartamento departamento;
    private LocalDateTime dataInclusao;
    private Integer qtdEstoque;

    public static Item parse(final ItemPayload item) {
        return Item.builder()
            .id(item.getId())
            .descricao(item.getDescricao())
            .valor(item.getValor())
            .departamento(item.getDepartamento())
            .dataInclusao(item.getDataInclusao())
            .qtdEstoque(item.getQtdEstoque())
            .build();
    }

    public void removerEstoque() {
        if (Objects.isNull(qtdEstoque)) {
            qtdEstoque = 0;
        }

        if (qtdEstoque < 1) {
            throw new IllegalStateException("Item sem Estoque!");
        }

        qtdEstoque--;
    }
}
