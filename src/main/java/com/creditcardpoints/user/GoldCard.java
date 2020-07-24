package com.creditcardpoints.user;

/**
 * description: GoldCard <br>
 * date: 2020/7/24/024 10:54 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class GoldCard extends Card{
    @Override
    public double getAdditionalPercentage() {
        return 1.5;
    }
}
