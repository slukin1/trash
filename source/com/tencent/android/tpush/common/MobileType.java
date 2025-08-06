package com.tencent.android.tpush.common;

public enum MobileType {
    UNKNOWN((byte) 0, "未知运营商"),
    TELCOM((byte) 1, "中国电信"),
    UNICOM((byte) 2, "中国联通"),
    CHINAMOBILE((byte) 3, "中国移动");
    
    private String str;
    private byte type;

    private MobileType(byte b11, String str2) {
        this.type = b11;
        this.str = str2;
    }

    public String getStr() {
        return this.str;
    }

    public byte getType() {
        return this.type;
    }
}
