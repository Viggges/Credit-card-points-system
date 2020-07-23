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
    @Override
    public long calPoint(Consumption consumption) {
        BigDecimal amt = consumption.getAmt();

        if(amt.compareTo(new BigDecimal(5000))==1){
            return amt.longValue()/10+100;
        }
        return amt.longValue()/10;
    }
}
