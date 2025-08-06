package com.hbg.lib.network.otc.enums;

import java.util.HashMap;

public enum OrderStatus {
    ONGOING("ongoing", "进行中"),
    OTHER("other", "其他"),
    UNPAID("unpaid", "未支付"),
    PAID("paid", "已支付"),
    CANCEL("cancel", "已取消"),
    COMPLETED("completed", "已完成"),
    APPEAL("appeal", "申诉中"),
    QUOTE_EXPIRED("quote_expired", "报价过期"),
    PAYING("paying", "支付中"),
    PAY_FAIL("paid_fail", "支付失败"),
    PAY_ERROR("abnormal", "支付异常"),
    WITHDRAW_DOING("withdraw_doing", "提币中"),
    WITHDRAW_FAILED("withdraw_failed", "提币失败");
    
    private static HashMap<String, OrderStatus> map;
    private String key;
    private String text;

    /* access modifiers changed from: public */
    static {
        map = new HashMap<>();
        for (OrderStatus orderStatus : values()) {
            map.put(orderStatus.key, orderStatus);
        }
    }

    private OrderStatus(String str, String str2) {
        this.key = str;
        this.text = str2;
    }

    public static OrderStatus parse(String str) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    public String getKey() {
        return this.key;
    }

    public String getText() {
        return this.text;
    }
}
