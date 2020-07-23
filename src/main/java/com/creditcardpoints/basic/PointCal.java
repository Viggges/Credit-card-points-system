package com.creditcardpoints.basic;

import com.creditcardpoints.pointcal.IPointCal;
import com.creditcardpoints.pointcal.PointCalFactory;

/**
 * description: PointCal <br>
 * date: 2020/7/23/023 15:27 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class PointCal {
    IPointCal iPointCal;

    public long calPoint(Consumption consumption) {
        PointCalFactory pointCalFactory = new PointCalFactory();
        iPointCal = pointCalFactory.getPointCal(consumption.getConsumeType());
        return iPointCal.calPoint(consumption);
    }
}
