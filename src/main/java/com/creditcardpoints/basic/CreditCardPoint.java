package com.creditcardpoints.basic;

import java.math.BigDecimal;

/**
 * description: CreditCardPoint <br>
 * date: 2020/7/23/023 10:52 <br>
 * author: LouWei <br>
 * version: 1.0 <br>
 */
public class CreditCardPoint {
    Consumption consumption;
    long point;

    public CreditCardPoint(Consumption consumption) {
        this.consumption = consumption;
        String consumeType = consumption.getConsumeType();
        if ("POS机消费".equals(consumeType)) {
            this.point = consumption.getAmt().setScale(0, BigDecimal.ROUND_DOWN).longValue() / 10;
        }
    }
}
