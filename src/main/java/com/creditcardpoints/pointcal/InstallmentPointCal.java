package com.creditcardpoints.pointcal;

import com.creditcardpoints.basic.Consumption;

import java.math.BigDecimal;

/**
 * description: InstallmentPointCal <br>
 * date: 2020/7/23/023 17:17 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class InstallmentPointCal implements IPointCal {
    private static final BigDecimal LIMIT = new BigDecimal(5000);

    @Override
    public long calBasicPoint(Consumption consumption) {
        return consumption.getAmt().longValue() / 10;
    }

    @Override
    public long calExtraPoint(Consumption consumption) {
        if (consumption.getAmt().compareTo(LIMIT) == 1) {
            return 100;
        }
        return 0;
    }
}
