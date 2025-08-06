package com.huobi.otc.enums;

public enum ThirdPayOrderStatus {
    COMPLETED(3, "已完成"),
    PAID_FAIL(104, "支付失败"),
    SMALL_COIN_FAIL(100, "订单过期"),
    ABNORMAL(105, "交易异常"),
    CANCEL(2, "已取消"),
    PAYING(103, "支付中"),
    PAID(1, "已支付"),
    REFUND_SUCCESS(106, "退款成功"),
    INIT(0, "未支付");
    
    public String name;
    public int value;

    private ThirdPayOrderStatus(int i11, String str) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
