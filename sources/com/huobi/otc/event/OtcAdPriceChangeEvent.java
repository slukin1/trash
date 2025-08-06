package com.huobi.otc.event;

import java.io.Serializable;

public class OtcAdPriceChangeEvent implements Serializable {
    public String advertId;
    public String price;
}
