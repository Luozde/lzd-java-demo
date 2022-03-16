package com.luozd.demo.statusmachine.constant;

/**
 * 订单状态
 */
public enum OrderStatus {
    // 待支付，待发货，待收货，已完成
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}
