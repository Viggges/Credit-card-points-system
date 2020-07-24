package com.creditcardpoints.pointcal;

import com.creditcardpoints.user.User;
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
     * 计算基础积分
     *
     * @param consumption 消费项
     * @return 基础积分
     */
    long calBasicPoint(Consumption consumption);

    /**
     * 计算额外积分
     * @param consumption 消费项
     * @return 额外积分
     */
    long calExtraPoint(Consumption consumption);

}
