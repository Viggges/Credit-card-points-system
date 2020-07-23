package com.creditcardpoints.basic;

/**
 * description: ConsumeTypeEnum <br>
 * date: 2020/7/23/023 15:42 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public enum ConsumeTypeEnum {
    /**
     * POS机消费
     */
    POS("POS机消费"),
    WeChat("微信支付消费");

    private String describe;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    ConsumeTypeEnum(String consumeType) {
        this.describe = consumeType;
    }
}
