package br.com.easy.api.mapper.response;

import br.com.easy.api.model.enums.ProductStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;

    private Double price;

    private String category;

    private ProductStatus status;

}
