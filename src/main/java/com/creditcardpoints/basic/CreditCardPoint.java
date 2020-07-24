package com.creditcardpoints.basic;

import com.creditcardpoints.user.User;

/**
 * description: CreditCardPoint <br>
 * date: 2020/7/23/023 10:52 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class CreditCardPoint {
    Consumption consumption;
    long point;
    public CreditCardPoint(Consumption consumption, User user) {
        this.consumption = consumption;
        PointCal pointCal = new PointCal();
        this.point = pointCal.calPoint(consumption, user);
    }
}
