package com.hbg.module.kline.enums;

public enum SymbolTypeEnum {
    SYMBOl(1, "交易对"),
    CURRENCY(2, "左币");
    
    public String desc;
    public int type;

    private SymbolTypeEnum(int i11, String str) {
        this.type = i11;
        this.desc = str;
    }

    public static SymbolTypeEnum getType(int i11) {
        SymbolTypeEnum[] values = values();
        if (values != null) {
            for (SymbolTypeEnum symbolTypeEnum : values) {
                if (symbolTypeEnum.type == i11) {
                    return symbolTypeEnum;
                }
            }
        }
        return SYMBOl;
    }
}
