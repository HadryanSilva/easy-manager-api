package br.com.easy.api.mapper;

import br.com.easy.api.mapper.request.ProductPostRequest;
import br.com.easy.api.mapper.response.ProductResponse;
import br.com.easy.api.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product postToProduct(ProductPostRequest productPostRequest);

    Product putToProduct(ProductPostRequest productPostRequest);

    ProductResponse productToResponse(Product product);

}
