package com.product.main.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.product.main.dao.ProductDao;
import com.product.main.entity.Product;
import com.product.main.serviceimpl.ProductServiceImpl;

public class ProductServiceImplTest {

    @Mock
    private ProductDao productDaoMock;

    @InjectMocks
    private ProductServiceImpl productService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProducts() {
        // Arrange
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product());
        expectedProducts.add(new Product());

        when(productDaoMock.getProducts()).thenReturn(expectedProducts);

        // Act
        List<Product> actualProducts = productService.getProducts();

        // Assert
        assertEquals(expectedProducts.size(), actualProducts.size());
        for (int i = 0; i < expectedProducts.size(); i++) {
            assertEquals(expectedProducts.get(i), actualProducts.get(i));
        }
    }

    @Test
    public void testGetProduct() {
        // Arrange
        int productId = 1;
        Product expectedProduct = new Product();

        when(productDaoMock.getProduct(productId)).thenReturn(expectedProduct);

        // Act
        Product actualProduct = productService.getProduct(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testAddProduct() {
        // Arrange
        Product newProduct = new Product();

        when(productDaoMock.addProduct(newProduct)).thenReturn(newProduct);

        // Act
        Product addedProduct = productService.addProduct(newProduct);

        // Assert
        assertEquals(newProduct, addedProduct);
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        int productId = 1;

        // Act
        String result = productService.deleteProduct(productId);

        // Assert
        assertEquals("Deleted Product Succesfully", result);
        verify(productDaoMock, times(1)).deleteProduct(productId);
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        Product updatedProduct = new Product();

        when(productDaoMock.updateProduct(updatedProduct)).thenReturn(updatedProduct);

        // Act
        Product result = productService.updateProduct(updatedProduct);

        // Assert
        assertEquals(updatedProduct, result);
    }
}
