package com.creditcardpoints.basic;

import com.creditcardpoints.pointcal.IPointCal;
import com.creditcardpoints.pointcal.PointCalFactory;
import com.creditcardpoints.user.User;

/**
 * description: PointCal <br>
 * date: 2020/7/23/023 15:27 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class PointCal {
    private IPointCal iPointCal;

    public long calPoint(Consumption consumption, User user) {
        PointCalFactory pointCalFactory = new PointCalFactory();
        iPointCal = pointCalFactory.getPointCal(consumption.getConsumeType());
        long basicPoint = (long) (iPointCal.calBasicPoint(consumption) * user.getCard().getAdditionalPercentage());
        long extraPoint = iPointCal.calExtraPoint(consumption);
        return basicPoint + extraPoint;
    }
}
