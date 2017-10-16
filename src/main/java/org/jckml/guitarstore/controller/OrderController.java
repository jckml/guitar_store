package org.jckml.guitarstore.controller;

import org.jckml.guitarstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/1/2")
	public String process() {
		orderService.processOrder(1, 2);
		return "redirect:/products";
	}
}
