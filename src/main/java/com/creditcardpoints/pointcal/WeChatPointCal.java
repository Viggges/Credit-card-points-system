package com.creditcardpoints.pointcal;

import com.creditcardpoints.basic.Consumption;

/**
 * description: WeChatPointCal <br>
 * date: 2020/7/23/023 15:53 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class WeChatPointCal implements IPointCal {

    @Override
    public long calBasicPoint(Consumption consumption) {
        return consumption.getAmt().longValue() / 20;
    }

    @Override
    public long calExtraPoint(Consumption consumption) {
        return 0;
    }
}
