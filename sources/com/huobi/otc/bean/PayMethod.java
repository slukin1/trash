package com.huobi.otc.bean;

import android.text.TextUtils;

public enum PayMethod {
    ALL("0"),
    BANK_CARD_PAY("1"),
    ALI_PAY("2"),
    WECHAT_PAY("3");
    
    public String value;

    private PayMethod(String str) {
        this.value = str;
    }

    public static PayMethod parsePayMethod(String str) {
        PayMethod payMethod = ALL;
        if (TextUtils.equals(str, payMethod.value)) {
            return payMethod;
        }
        PayMethod payMethod2 = BANK_CARD_PAY;
        if (TextUtils.equals(str, payMethod2.value)) {
            return payMethod2;
        }
        PayMethod payMethod3 = ALI_PAY;
        if (TextUtils.equals(str, payMethod3.value)) {
            return payMethod3;
        }
        PayMethod payMethod4 = WECHAT_PAY;
        if (TextUtils.equals(str, payMethod4.value)) {
            return payMethod4;
        }
        return null;
    }
}
