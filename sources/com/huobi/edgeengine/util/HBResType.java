package com.huobi.edgeengine.util;

public enum HBResType {
    String("string"),
    Drawable("drawable"),
    Color("color"),
    Raw("raw");
    
    public final String type;

    private HBResType(String str) {
        this.type = str;
    }

    public static HBResType createType(String str) {
        HBResType hBResType = Drawable;
        if (str.equals(hBResType.type)) {
            return hBResType;
        }
        HBResType hBResType2 = Color;
        if (str.equals(hBResType2.type)) {
            return hBResType2;
        }
        return String;
    }
}
