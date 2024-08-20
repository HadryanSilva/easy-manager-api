package br.com.easy.api.service;

import br.com.easy.api.exception.NotFoundException;
import br.com.easy.api.mapper.ProductMapper;
import br.com.easy.api.mapper.request.ProductPostRequest;
import br.com.easy.api.mapper.request.ProductPutRequest;
import br.com.easy.api.mapper.response.ProductResponse;
import br.com.easy.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public List<ProductResponse> findAll(Pageable pageable) {
        log.info("Finding all products");
        return productRepository.findAll(pageable)
                .stream()
                .map(productMapper::productToResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        log.info("Finding product by id: {}", id);
        var productFound = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        return productMapper.productToResponse(productFound);
    }

    public ProductResponse save(ProductPostRequest request) {
        log.info("Saving product: {}", request.getName());
        var product = productMapper.postToProduct(request);
        var productSaved = productRepository.save(product);
        return productMapper.productToResponse(productSaved);
    }

    public ProductResponse update(Long id, ProductPutRequest request) {
        log.info("Updating product: {}", id);
        var product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        productMapper.putToProduct(request);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        var productUpdated = productRepository.save(product);
        return productMapper.productToResponse(productUpdated);
    }

    public void delete(Long id) {
        log.info("Deleting product: {}", id);
        var product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        productRepository.delete(product);
    }

}
