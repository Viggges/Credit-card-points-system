package com.creditcardpoints.basic;

import java.math.BigDecimal;

/**
 * description: WeChatPointCal <br>
 * date: 2020/7/23/023 15:53 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class WeChatPointCal implements IPointCal {
    @Override
    public long calPoint(Consumption consumption) {
        return consumption.getAmt().setScale(0, BigDecimal.ROUND_DOWN).longValue() / 20;
    }
}