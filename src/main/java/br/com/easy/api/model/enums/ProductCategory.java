package br.com.easy.api.model.enums;

import lombok.Getter;

@Getter
public enum ProductCategory {

    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    BOOKS("Books"),
    FOOD("Food"),
    TOYS("Toys");

    private final String description;

    ProductCategory(String description) {
        this.description = description;
    }

}
