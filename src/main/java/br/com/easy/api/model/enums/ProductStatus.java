package br.com.easy.api.model.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {

    IN_STOCK("In stock"),
    LOW_STOCK("Low stock"),
    OUT_OF_STOCK("Out of stock");

    private final String description;

    ProductStatus(String description) {
        this.description = description;
    }

}
