package com.creditcardpoints.basic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * description: 完成需求1的测试，不采用策略模式 <br>
 * date: 2020/7/23/023 10:24 <br>
 * author: LouWei <br>
 * version: 1.0 <br>
 */
public class RequirementOneTest {
    List<Consumption> consumptionList;

    @Before
    public void consumptionListInit() {
        Consumption conOne = new Consumption("2020-07-01 18:40", "POS机消费", new BigDecimal(8));
        Consumption conTwo = new Consumption("2020-07-01 18:50", "POS机消费", new BigDecimal(108));
        Consumption conThree = new Consumption("2020-07-02 18:50", "POS机消费", new BigDecimal(208));
        consumptionList = Arrays.asList(conOne, conTwo, conThree);
    }

    @Test
    public void given_consumption_list_when_pos_then_get_points_details() {
        PointsView pointsView = new PointsView();
        String actual = pointsView.view(consumptionList);
        Assert.assertEquals("总积分：30\n" +
                "2020-07-02 18:50 POS机消费 208元， 积分 +20\n" +
                "2020-07-01 18:50 POS机消费 108元， 积分 +10\n" +
                "2020-07-01 18:40 POS机消费 8元， 积分 +0", actual);

    }
}
