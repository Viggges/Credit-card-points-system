package com.creditcardpoints.pointcal;

import com.creditcardpoints.basic.Consumption;

/**
 * description: IPointCal <br>
 * date: 2020/7/23/023 15:28 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public interface IPointCal {
    /**
     * 计算积分
     *
     * @param consumption
     * @return
     */
    long calPoint(Consumption consumption);

}
