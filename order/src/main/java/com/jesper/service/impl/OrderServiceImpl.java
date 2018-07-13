package com.jesper.service.impl;

import com.jesper.data.OrderMaster;
import com.jesper.dto.OrderDTO;
import com.jesper.enums.OrderStatusEnum;
import com.jesper.enums.PayStatusEnum;
import com.jesper.respository.OrderDetailRepository;
import com.jesper.respository.OrderMasterRepository;
import com.jesper.service.OrderService;
import com.jesper.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Key;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        /**
         * 1、查询商品信息（调用商品服务）
         * 2、计算总价
         * 3、扣库存（调用商品服务）
         */

        //订单入苦
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderId(KeyUtil.genUniqueKey());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
