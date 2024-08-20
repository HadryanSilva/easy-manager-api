package br.com.easy.api.mapper;

import br.com.easy.api.mapper.request.ProductPostRequest;
import br.com.easy.api.mapper.request.ProductPutRequest;
import br.com.easy.api.mapper.response.ProductResponse;
import br.com.easy.api.model.Product;
import br.com.easy.api.model.enums.StockStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "stockStatus", expression = "java(mapStringToStockStatus(productPostRequest.getStockStatus()))")
    Product postToProduct(ProductPostRequest productPostRequest);

    @Mapping(target = "stockStatus", expression = "java(mapStringToStockStatus(productPutRequest.getStockStatus()))")
    Product putToProduct(ProductPutRequest productPutRequest);

    @Mapping(target = "stockStatus", expression = "java(mapStockStatusToString(product.getStockStatus()))")
    ProductResponse productToResponse(Product product);

    default StockStatus mapStringToStockStatus(String status) {
        if (status == null) {
            return null;
        }

        for (StockStatus stockStatus : StockStatus.values()) {
            if (stockStatus.name().equals(status) ||
                    stockStatus.getDescription().equals(status)) {
                return stockStatus;
            }
        }

        throw new IllegalArgumentException("Invalid stock status: " + status);
    }

    default String mapStockStatusToString(StockStatus stockStatus) {
        return stockStatus.getDescription();
    }


}
