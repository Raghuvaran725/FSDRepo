package com.order.main.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.order.main.dao.Orderdao;
import com.order.main.entity.Orders;
import com.orders.main.repository.OrderRepository;



@Repository
public class OrderDaoImpl implements Orderdao{
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Orders> getOrders() {
		
		return orderRepository.findAll();
	}

	@Override
	public Orders getOrder(int oid) {
		Orders order = orderRepository.findById( oid).orElse(null);
		return order;
	}

	@Override
	public Orders addOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public boolean deleteOrder(int oid) {
		if (orderRepository.existsById( oid)) {
            orderRepository.deleteById( oid);
            return true;
        }
        return false;
	}

	@Override
	public Orders updateOrder(Orders order) {
		// TODO Auto-generated method stub
        return orderRepository.save(order);

	}
	
}
