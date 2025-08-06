package com.hbg.lib.network.option.core.util;

import com.hbg.lib.network.hbg.prime.PrimeRounds;

public enum OptionOrderPriceType {
    LIMIT("limit"),
    OPPONENT("opponent"),
    LIGHTNING("lightning"),
    POST_ONLY("post_only"),
    MARKET(PrimeRounds.ROUND_TRADE_MARKET_TYPE),
    OPTIMAL_5("optimal_5"),
    OPTIMAL_10("optimal_10"),
    OPTIMAL_20("optimal_20"),
    FOK("fok"),
    IOC("ioc"),
    OPPONENT_IOC("opponent_ioc"),
    LIGHTNING_IOC("lightning_ioc"),
    OPTIMAL_5_IOC("optimal_5_ioc"),
    OPTIMAL_10_IOC("optimal_10_ioc"),
    OPTIMAL_20_IOC("optimal_20_ioc"),
    OPPONENT_FOK("opponent_fok"),
    LIGHTNING_FOK("lightning_fok"),
    OPTIMAL_5_FOK("optimal_5_fok"),
    OPTIMAL_10_FOK("optimal_10_fok"),
    OPTIMAL_20_FOK("optimal_20_fok"),
    SYSTEM("system");
    
    public String type;

    private OptionOrderPriceType(String str) {
        this.type = str;
    }
}
