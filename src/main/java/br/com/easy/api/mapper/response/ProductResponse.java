package br.com.easy.api.mapper.response;

import br.com.easy.api.model.enums.StockStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;

    private String brand;

    private Double price;

    private String category;

    private String stockStatus;

}
