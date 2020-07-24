package com.creditcardpoints.basic;

import com.creditcardpoints.user.GeneralCard;
import com.creditcardpoints.user.GoldCard;
import com.creditcardpoints.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * description: PointsViewTest<br>
 * date: 2020/7/23/023 10:24 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class PointsViewTest {
    private List<Consumption> consumptionListOne;
    private List<Consumption> consumptionListTwo;
    private List<Consumption> consumptionListThree;
    private List<Consumption> consumptionListFour;
    private List<Consumption> consumptionListFive;
    private List<Consumption> consumptionListSix;
    private User goldUser = new User(new GoldCard());
    private User generalUser = new User(new GeneralCard());

    @Before
    public void consumptionListInit() {
        Consumption pos_8 = new Consumption("2020-07-01 18:40", "POS机消费", new BigDecimal(8));
        Consumption pos_108 = new Consumption("2020-07-01 18:50", "POS机消费", new BigDecimal(108));
        Consumption pos_208 = new Consumption("2020-07-02 18:50", "POS机消费", new BigDecimal(208));
        Consumption weChat_25 = new Consumption("2020-07-01 12:20", "微信支付消费", new BigDecimal(25));
        Consumption weChat_18 = new Consumption("2020-07-01 12:50", "微信支付消费", new BigDecimal(18));
        Consumption weChat_10 = new Consumption("2020-07-02 08:20", "微信支付消费", new BigDecimal(10));
        Consumption weChat_22 = new Consumption("2020-07-02 12:20", "微信支付消费", new BigDecimal(22));
        Consumption fastPayment_208 = new Consumption("2020-07-02 20:30", "快捷支付消费", new BigDecimal(208));
        Consumption fastPayment_2208 = new Consumption("2020-07-02 22:30", "快捷支付消费", new BigDecimal(2208));
        Consumption installment_6400 = new Consumption("2020-07-02 23:00", "信用卡分期购物消费", new BigDecimal(6400));
        consumptionListOne = Arrays.asList(pos_8, pos_108, pos_208);
        consumptionListTwo = Arrays.asList(weChat_25, weChat_18, pos_108, weChat_10, weChat_22, pos_208);
        consumptionListThree = Arrays.asList(weChat_25, weChat_18, pos_108, weChat_10, weChat_22, pos_208, fastPayment_208, fastPayment_2208);
        consumptionListFour = Arrays.asList(weChat_25, weChat_18, pos_108, weChat_10, weChat_22, pos_208, fastPayment_208, fastPayment_2208, installment_6400);
        consumptionListFive = Arrays.asList(weChat_25, weChat_18, pos_108, weChat_10, weChat_22, pos_208, fastPayment_208, fastPayment_2208, installment_6400);
        consumptionListSix = Arrays.asList(weChat_25, weChat_18, pos_108, weChat_10, weChat_22, pos_208, fastPayment_208, fastPayment_2208, installment_6400);
    }

    @Test
    public void given_consumption_list_one_when_pos_then_get_points_details() {
        PointsView pointsView = new PointsView();
        String actual = pointsView.textView(consumptionListOne, generalUser);
        Assert.assertEquals("总积分：30\n" +
                "2020-07-02 18:50 POS机消费 208元， 积分 +20\n" +
                "2020-07-01 18:50 POS机消费 108元， 积分 +10\n" +
                "2020-07-01 18:40 POS机消费 8元， 积分 +0", actual);
    }

    @Test
    public void given_consumption_list_two_when_add_weChat_then_get_points_details() {
        PointsView pointsView = new PointsView();
        String actual = pointsView.textView(consumptionListTwo, generalUser);
        Assert.assertEquals("总积分：32\n" +
                "2020-07-02 18:50 POS机消费 208元， 积分 +20\n" +
                "2020-07-02 12:20 微信支付消费 22元， 积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元， 积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元， 积分 +10\n" +
                "2020-07-01 12:50 微信支付消费 18元， 积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元， 积分 +1", actual);
    }

    @Test
    public void given_consumption_list_three_when_add_fast_payment_then_get_points_details() {
        PointsView pointsView = new PointsView();
        String actual = pointsView.textView(consumptionListThree, generalUser);
        Assert.assertEquals("总积分：382\n" +
                "2020-07-02 22:30 快捷支付消费 2208元， 积分 +320\n" +
                "2020-07-02 20:30 快捷支付消费 208元， 积分 +30\n" +
                "2020-07-02 18:50 POS机消费 208元， 积分 +20\n" +
                "2020-07-02 12:20 微信支付消费 22元， 积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元， 积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元， 积分 +10\n" +
                "2020-07-01 12:50 微信支付消费 18元， 积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元， 积分 +1", actual);
    }

    @Test
    public void given_consumption_list_four_when_add_installment_then_get_points_details() {
        PointsView pointsView = new PointsView();
        String actual = pointsView.textView(consumptionListFour, generalUser);
        Assert.assertEquals("总积分：1122\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元， 积分 +740\n" +
                "2020-07-02 22:30 快捷支付消费 2208元， 积分 +320\n" +
                "2020-07-02 20:30 快捷支付消费 208元， 积分 +30\n" +
                "2020-07-02 18:50 POS机消费 208元， 积分 +20\n" +
                "2020-07-02 12:20 微信支付消费 22元， 积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元， 积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元， 积分 +10\n" +
                "2020-07-01 12:50 微信支付消费 18元， 积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元， 积分 +1", actual);
    }

    @Test
    public void given_consumption_list_five_when_add_gold_card_users_then_get_points_details() {

        PointsView pointsView = new PointsView();
        String actual = pointsView.textView(consumptionListFive, goldUser);
        Assert.assertEquals("总积分：1577\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元， 积分 +1060\n" +
                "2020-07-02 22:30 快捷支付消费 2208元， 积分 +430\n" +
                "2020-07-02 20:30 快捷支付消费 208元， 积分 +40\n" +
                "2020-07-02 18:50 POS机消费 208元， 积分 +30\n" +
                "2020-07-02 12:20 微信支付消费 22元， 积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元， 积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元， 积分 +15\n" +
                "2020-07-01 12:50 微信支付消费 18元， 积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元， 积分 +1", actual);
    }

    @Test
    public void given_consumption_list_six_when_add_html_then_get_points_details() {

        PointsView pointsView = new PointsView();
        String actualHtml = pointsView.htmlView(consumptionListSix, goldUser);
        String actual = pointsView.textView(consumptionListSix, goldUser);

        Assert.assertEquals("<h2>总积分：<b>1577</b></h2>\n" +
                "<p>2020-07-02 23:00 信用卡分期购物消费 6400元， 积分 <b>+1060</b></p>\n" +
                "<p>2020-07-02 22:30 快捷支付消费 2208元， 积分 <b>+430</b></p>\n" +
                "<p>2020-07-02 20:30 快捷支付消费 208元， 积分 <b>+40</b></p>\n" +
                "<p>2020-07-02 18:50 POS机消费 208元， 积分 <b>+30</b></p>\n" +
                "<p>2020-07-02 12:20 微信支付消费 22元， 积分 <b>+1</b></p>\n" +
                "<p>2020-07-02 08:20 微信支付消费 10元， 积分 <b>+0</b></p>\n" +
                "<p>2020-07-01 18:50 POS机消费 108元， 积分 <b>+15</b></p>\n" +
                "<p>2020-07-01 12:50 微信支付消费 18元， 积分 <b>+0</b></p>\n" +
                "<p>2020-07-01 12:20 微信支付消费 25元， 积分 <b>+1</b></p>", actualHtml);
        Assert.assertEquals("总积分：1577\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元， 积分 +1060\n" +
                "2020-07-02 22:30 快捷支付消费 2208元， 积分 +430\n" +
                "2020-07-02 20:30 快捷支付消费 208元， 积分 +40\n" +
                "2020-07-02 18:50 POS机消费 208元， 积分 +30\n" +
                "2020-07-02 12:20 微信支付消费 22元， 积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元， 积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元， 积分 +15\n" +
                "2020-07-01 12:50 微信支付消费 18元， 积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元， 积分 +1", actual);
    }
}
