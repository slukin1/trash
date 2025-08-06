package com.huobi.otc.event;

import com.huobi.otc.bean.MarketCoin;
import java.io.Serializable;

public class OtcCoinTransferClickEvent implements Serializable {
    public MarketCoin.Coin coin;
}
