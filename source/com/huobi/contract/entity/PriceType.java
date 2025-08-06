package com.huobi.contract.entity;

import android.content.res.Resources;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.huobi.coupon.bean.CouponReturn;

public enum PriceType {
    LIMIT("limit"),
    MARKET(PrimeRounds.ROUND_TRADE_MARKET_TYPE),
    OPTIMAL_FIVE("optimal_5"),
    OPTIMAL_TEN("optimal_10"),
    OPTIMAL_TWENTY("optimal_20");
    
    private final String type;

    private PriceType(String str) {
        this.type = str;
    }

    public static PriceType getPriceType(String str) {
        PriceType priceType = OPTIMAL_FIVE;
        if (!priceType.getName().equals(str) && !priceType.type.equals(str)) {
            priceType = OPTIMAL_TEN;
            if (!priceType.getName().equals(str) && !priceType.type.equals(str)) {
                priceType = OPTIMAL_TWENTY;
                if (!priceType.getName().equals(str) && !priceType.type.equals(str)) {
                    priceType = MARKET;
                    if (!priceType.getName().equals(str) && !priceType.type.equals(str)) {
                        return LIMIT;
                    }
                }
            }
        }
        return priceType;
    }

    public static boolean isOptimalPriceType(String str) {
        PriceType priceType = OPTIMAL_FIVE;
        if (!priceType.getName().equals(str)) {
            PriceType priceType2 = OPTIMAL_TEN;
            if (!priceType2.getName().equals(str)) {
                PriceType priceType3 = OPTIMAL_TWENTY;
                return priceType3.getName().equals(str) || priceType.type.equals(str) || priceType2.type.equals(str) || priceType3.type.equals(str);
            }
        }
    }

    public String getName() {
        int i11 = R$string.contract_order_trigger_optimal;
        Resources resources = BaseApplication.b().getResources();
        String str = this.type;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1081306052:
                if (str.equals(PrimeRounds.ROUND_TRADE_MARKET_TYPE)) {
                    c11 = 0;
                    break;
                }
                break;
            case 1305011708:
                if (str.equals("optimal_10")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1305011739:
                if (str.equals("optimal_20")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1843212472:
                if (str.equals("optimal_5")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return resources.getString(R$string.n_exchange_order_list_market);
            case 1:
                return resources.getString(i11, new Object[]{CouponReturn.TYPE_EXPERIENCE});
            case 2:
                return resources.getString(i11, new Object[]{"20"});
            case 3:
                return resources.getString(i11, new Object[]{BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC});
            default:
                return name();
        }
    }

    public String getType() {
        return this.type;
    }

    public static boolean isOptimalPriceType(PriceType priceType) {
        return OPTIMAL_TWENTY == priceType || OPTIMAL_TEN == priceType || OPTIMAL_FIVE == priceType;
    }
}
