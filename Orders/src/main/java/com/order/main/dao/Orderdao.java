package com.order.main.dao;

import java.util.List;

import com.order.main.entity.Orders;

public interface Orderdao{
	public List<Orders> getOrders();

	public Orders getOrder(int oid);

	public Orders addOrder(Orders order);

	public boolean deleteOrder(int oid);

	public Orders updateOrder(Orders order);
}