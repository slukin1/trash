package com.huobi.otc.flutter;

import java.io.Serializable;

public class OtcAdvertPrivilegeFilterEvent implements Serializable {
    public String coinName;
    public String currencyName;
    public String side;

    public OtcAdvertPrivilegeFilterEvent(String str, String str2, String str3) {
        this.side = str;
        this.currencyName = str2;
        this.coinName = str3;
    }
}
