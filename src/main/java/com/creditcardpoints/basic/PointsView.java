package com.creditcardpoints.basic;

import com.creditcardpoints.user.User;

import java.util.List;

/**
 * description: PointsView <br>
 * date: 2020/7/23/023 11:08 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class PointsView {


    public String view(List<Consumption> consumptionList, User user) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        long total = 0;
        // 按时间排序
        consumptionList.sort(
                (o1, o2) -> o2.getTime().compareTo(o1.getTime())
        );
        for (Consumption con : consumptionList) {
            CreditCardPoint creditCardPoint = new CreditCardPoint(con, user);
            total += creditCardPoint.point;
            if ("".equals(sb.toString())) {
                sb.append(creditCardPoint.consumption.describe())
                        .append(creditCardPoint.point);
            } else {
                sb.append("\n")
                        .append(creditCardPoint.consumption.describe())
                        .append(creditCardPoint.point);
            }
        }
        result.append("总积分：" + total + "\n");
        result.append(sb);
        return result.toString();
    }
}
