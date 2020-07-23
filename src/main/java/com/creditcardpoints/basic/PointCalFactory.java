package com.creditcardpoints.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * description: PointCalFactory <br>
 * date: 2020/7/23/023 15:36 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class PointCalFactory {

    Map<String, IPointCal> iPointCalMap = new HashMap<>();

    public PointCalFactory() {
        iPointCalMap.put(ConsumeTypeEnum.POS.getDescribe(), new PosPointCal());
        iPointCalMap.put(ConsumeTypeEnum.WeChat.getDescribe(), new WeChatPointCal());
    }

    public IPointCal getPointCal(String consumeType) {
        return iPointCalMap.get(consumeType);
    }
}
