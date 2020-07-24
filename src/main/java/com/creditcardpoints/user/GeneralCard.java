package com.creditcardpoints.user;

/**
 * description: GeneralCard <br>
 * date: 2020/7/24/024 10:53 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class GeneralCard extends Card{

    @Override
    public double getAdditionalPercentage() {
        return 1;
    }
}
