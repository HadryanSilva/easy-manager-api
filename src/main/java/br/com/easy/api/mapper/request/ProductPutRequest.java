package br.com.easy.api.mapper.request;

import br.com.easy.api.model.enums.ProductStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPutRequest {

    private String name;

    private Double price;

    private String brand;

    private String category;

}
