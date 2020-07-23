package com.creditcardpoints.basic;

import java.math.BigDecimal;

/**
 * description: Consumption <br>
 * date: 2020/7/23/023 10:38 <br>
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class Consumption {

    private final String time;
    private final String consumeType;
    private final BigDecimal amt;

    public Consumption(String time, String consumeType, BigDecimal amt) {
        this.time = time;
        this.consumeType = consumeType;
        this.amt = amt;
    }

    public String getTime() {
        return time;
    }

    public String getConsumeType() {
        return consumeType;
    }

    public BigDecimal getAmt() {
        return amt;
    }
    public String describe(){
        return time+" "+consumeType+" "+amt+"元， 积分 +";
    }
}
