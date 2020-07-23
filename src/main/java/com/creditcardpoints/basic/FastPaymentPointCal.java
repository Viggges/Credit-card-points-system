package com.creditcardpoints.basic;

import java.math.BigDecimal;

/**
 * description: FastPaymentPointCal <br>
 * date: 2020/7/23/023 16:13 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class FastPaymentPointCal implements IPointCal {

    @Override
    public long calPoint(Consumption consumption) {
        double amt = consumption.getAmt().setScale(0, BigDecimal.ROUND_DOWN).doubleValue();
        double extraPoints = (5 * Math.floor(amt / 100)) < 100 ? 5 * Math.floor(amt / 100) : 100;
        return (long) extraPoints + (long) amt / 10;
    }
}
