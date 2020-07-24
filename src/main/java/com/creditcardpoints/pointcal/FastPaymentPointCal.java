package com.creditcardpoints.pointcal;

import com.creditcardpoints.CommonConstant;
import com.creditcardpoints.user.User;
import com.creditcardpoints.basic.Consumption;

/**
 * description: FastPaymentPointCal <br>
 * date: 2020/7/23/023 16:13 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class FastPaymentPointCal implements IPointCal {

    @Override
    public long calBasicPoint(Consumption consumption) {
        double amt = consumption.getAmt().doubleValue();
        return (long) amt / 10;
    }

    @Override
    public long calExtraPoint(Consumption consumption) {
        double amt = consumption.getAmt().doubleValue();
        double extraPoints = (5 * Math.floor(amt / 100)) < 100 ? 5 * Math.floor(amt / 100) : 100;
        return (long) extraPoints;
    }
}
