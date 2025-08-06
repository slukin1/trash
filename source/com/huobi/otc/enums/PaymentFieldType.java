package com.huobi.otc.enums;

import com.huobi.account.entity.BalanceQueryData;

public enum PaymentFieldType {
    SINGLE_TEXT("输入框", "single_text"),
    QR_CODE("二维码图片", "qr_code"),
    PAYEE("姓名", "payee"),
    PAY_ACCOUNT("银行账号/卡号", "pay_account"),
    BANK("银行名称", BalanceQueryData.TYPE_BANK),
    SUB_BANK("开户支行", "sub_bank"),
    MUTLI_TEXT("多行输入框", "mutli_text");
    
    public String fieldType;
    public String name;

    private PaymentFieldType(String str, String str2) {
        this.name = str;
        this.fieldType = str2;
    }

    public String getFieldType() {
        return this.fieldType;
    }

    public String getName() {
        return this.name;
    }
}
