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
    private static final String HTML_OPEN_H2 = "<h2>";
    private static final String HTML_CLOSE_H2 = "</h2>";
    private static final String HTML_OPEN_P = "<p>";
    private static final String HTML_CLOSE_P = "</p>";
    private static final String HTML_OPEN_B = "<b>";
    private static final String HTML_CLOSE_B = "</b>";


    public String htmlView(List<Consumption> consumptionList, User user) {
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
            String htmlConsume = "<p>" + creditCardPoint.consumption.describe() + "<b>+" + creditCardPoint.point + "</b></p>";
            if ("".equals(sb.toString())) {
                sb.append(htmlConsume);
            } else {
                sb.append("\n")
                        .append(htmlConsume);
            }
        }
        result.append("<h2>总积分：<b>" + total + "</b></h2>\n");
        result.append(sb);
        return result.toString();
    }

    public String view(List<Consumption> consumptionList, User user) {
        String htmlResult = htmlView(consumptionList, user);
        String regex = "<[^>]+>";
        String result = htmlResult.replaceAll(regex, "");
        return result;
    }
}
