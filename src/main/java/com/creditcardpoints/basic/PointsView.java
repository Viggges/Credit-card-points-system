package com.creditcardpoints.basic;

import java.math.BigDecimal;
import java.util.List;

/**
 * description: PointsView <br>
 * date: 2020/7/23/023 11:08 <br>
 * author: LouWei <br>
 * version: 1.0 <br>
 */
public class PointsView {

    public String view(List<Consumption> consumptionList) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        long total = 0;
        for (Consumption con : consumptionList) {
            CreditCardPoint creditCardPoint = new CreditCardPoint(con);
            total+=creditCardPoint.point;
            if ("".equals(sb.toString())) {
                sb.append(creditCardPoint.consumption.describe())
                        .append(creditCardPoint.point);
            } else {
                sb.append("\n")
                        .append(creditCardPoint.consumption.describe())
                        .append(creditCardPoint.point);
            }
        }
        result.append("总积分："+total+"\n");
        result.append(sb);
        return result.toString();
    }

}
