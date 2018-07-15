package com.jesper.service.impl;

import com.jesper.data.OrderDetail;
import com.jesper.data.OrderMaster;
import com.jesper.data.ProductInfo;
import com.jesper.dto.CartDTO;
import com.jesper.dto.OrderDTO;
import com.jesper.enums.OrderStatusEnum;
import com.jesper.enums.PayStatusEnum;
import com.jesper.product.client.ProductClient;
import com.jesper.product.common.DecreaseStockInput;
import com.jesper.product.common.ProductInfoOutput;
import com.jesper.respository.OrderDetailRepository;
import com.jesper.respository.OrderMasterRepository;
import com.jesper.service.OrderService;
import com.jesper.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        /**
         * 1、查询商品信息（调用商品服务）
         * 2、计算总价
         * 3、扣库存（调用商品服务）
         */

        String orderId = KeyUtil.genUniqueKey();

        ///1、查询商品信息（调用商品服务）
        List<String> productList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfos = productClient.listForOrder(productList);

        //2、计算总价

        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            //单价*数量
            for (ProductInfoOutput productInfo : productInfos) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    //单价*数量
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        //扣库存(调用商品服务)
        List<DecreaseStockInput> decreaseStockInput = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInput);

        //订单入库存
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderId(orderId);

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
