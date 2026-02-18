package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testCreate() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.create(product)).thenReturn(product);

        Product result = productService.create(product);

        assertEquals(product.getProductId(), result.getProductId());
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAll() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        // Mock the iterator behavior
        Iterator<Product> iterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(1, result.size());
        assertEquals("Sampo Cap Bambang", result.get(0).getProductName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.findById(product.getProductId())).thenReturn(product);

        Product result = productService.findById(product.getProductId());

        assertNotNull(result);
        assertEquals(product.getProductId(), result.getProductId());
        verify(productRepository, times(1)).findById(product.getProductId());
    }

    @Test
    void testFindByIdNotFound() {
        String invalidId = "invalid-id";
        when(productRepository.findById(invalidId)).thenReturn(null);

        Product result = productService.findById(invalidId);

        assertNull(result);
        verify(productRepository, times(1)).findById(invalidId);
    }

    @Test
    void testUpdate() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        when(productRepository.update(product)).thenReturn(product);

        productService.update(product);

        verify(productRepository, times(1)).update(product);
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);


        doNothing().when(productRepository).delete(product.getProductId());

        productService.delete(product.getProductId());

        verify(productRepository, times(1)).delete(product.getProductId());
    }
}