package com.creditcardpoints.basic;

import com.creditcardpoints.CommonConstant;

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
    POS(CommonConstant.CONSUME_POS),
    WeChat(CommonConstant.CONSUME_WECHAT),
    FastPayment(CommonConstant.CONSUME_FAST_PAYMENT),
    Installment(CommonConstant.CONSUME_INSTALLMENT);

    private String describe;

    public String getDescribe() {
        return describe;
    }

    ConsumeTypeEnum(String consumeType) {
        this.describe = consumeType;
    }
}
