package com.order.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.main.dao.Orderdao;

import com.order.main.entity.Orders;
import com.order.main.exception.OrderNotFoundException;
import com.order.main.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private Orderdao orderdao;
	
	
	@Override
	public List<Orders> getOrders() {
		List<Orders> orderlist=orderdao.getOrders(); 
		return orderlist;
	}

	@Override
	public Orders getOrder(int oid) throws OrderNotFoundException {
		Orders order = orderdao.getOrder(oid);
		if (order == null) {
			throw new OrderNotFoundException(oid);
		}
		return order;
	}

	@Override
	public Orders addOrder(Orders order ) {
		
		return orderdao.addOrder(order);
		
	}

	@Override
	public boolean deleteOrder(int oid) throws OrderNotFoundException {
		boolean deleted = orderdao.deleteOrder(oid);
		if (!deleted) {
			throw new OrderNotFoundException(oid);
		}
		return deleted;
	}

	@Override
	public Orders updateOrder(Orders order) {
		
		Orders o = orderdao.updateOrder(order);
		return o;
	}

}
