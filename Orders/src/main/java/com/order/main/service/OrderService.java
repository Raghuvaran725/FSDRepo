package com.order.main.service;

import java.util.List;



import com.order.main.entity.Orders;
import com.order.main.exception.OrderNotFoundException;



public interface OrderService {
public List<Orders> getOrders();

public Orders getOrder(int oid) throws OrderNotFoundException;

public Orders addOrder(Orders order);

public boolean deleteOrder(int oid) throws OrderNotFoundException;

public Orders updateOrder(Orders order);
}
