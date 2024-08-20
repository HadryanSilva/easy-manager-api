package br.com.easy.api.model.enums;

import lombok.Getter;

@Getter
public enum StockStatus {

    IN_STOCK("Em Estoque"),
    LOW_STOCK("Estoque Baixo"),
    OUT_OF_STOCK("Sem Estoque");

    private final String description;

    StockStatus(String description) {
        this.description = description;
    }

}
