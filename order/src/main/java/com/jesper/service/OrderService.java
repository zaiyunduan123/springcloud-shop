package com.jesper.service;

import com.jesper.dto.OrderDTO;

public interface OrderService {

    /**
     * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);
}
