package com.orders.demo.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.order.main.dao.Orderdao;
import com.order.main.entity.Orders;
import com.order.main.exception.OrderNotFoundException;
import com.order.main.serviceimpl.OrderServiceImpl;

public class OrderServiceImplTest {

    @Mock
    private Orderdao orderDaoMock;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetOrders() {
        // Arrange
        Orders order1 = new Orders();
        order1.setId(1);
        Orders order2 = new Orders();
        order2.setId(2);

        List<Orders> expectedOrders = Arrays.asList(order1, order2);

        when(orderDaoMock.getOrders()).thenReturn(expectedOrders);

        // Act
        List<Orders> actualOrders = orderService.getOrders();

        // Assert
        assertEquals(expectedOrders.size(), actualOrders.size());
        assertEquals(expectedOrders.get(0).getId(), actualOrders.get(0).getId());
        assertEquals(expectedOrders.get(1).getId(), actualOrders.get(1).getId());
    }

    

    @Test
    void testGetOrder_OrderNotFound() {
        // Arrange
        int orderId = 1;

        when(orderDaoMock.getOrder(orderId)).thenReturn(null);

        // Act & Assert
        assertThrows(OrderNotFoundException.class, () -> orderService.getOrder(orderId));
    }

    // Similarly, write tests for addOrder, updateOrder, and deleteOrder methods
}

