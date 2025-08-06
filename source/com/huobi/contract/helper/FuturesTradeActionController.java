package com.huobi.contract.helper;

import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.huobi.contract.entity.ContractOrderPlace;
import i6.m;
import java.math.BigDecimal;

public class FuturesTradeActionController {
    public ContractOrderPlace a(ContractOrderPlace contractOrderPlace) {
        int Q = contractOrderPlace.Q();
        int O = contractOrderPlace.O();
        int v11 = contractOrderPlace.v();
        if (contractOrderPlace.X()) {
            contractOrderPlace.p0("buy");
        } else {
            contractOrderPlace.p0("sell");
        }
        if (v11 == 0) {
            contractOrderPlace.w0("open");
        } else if (v11 == 1) {
            contractOrderPlace.w0("close");
        } else {
            contractOrderPlace.w0("close");
        }
        if (2 == contractOrderPlace.t()) {
            contractOrderPlace.D0("post_only");
        } else if (4 == contractOrderPlace.t()) {
            if (Q == 1) {
                contractOrderPlace.D0("fok");
            } else if (Q == 6) {
                contractOrderPlace.D0("lightning_fok");
            } else if (Q == 2) {
                contractOrderPlace.D0("opponent_fok");
            } else if (Q == 3) {
                contractOrderPlace.D0("optimal_5_fok");
            } else if (Q == 4) {
                contractOrderPlace.D0("optimal_10_fok");
            } else if (Q == 5) {
                contractOrderPlace.D0("optimal_20_fok");
            }
        } else if (3 == contractOrderPlace.t()) {
            if (Q == 1) {
                contractOrderPlace.D0("ioc");
            } else if (Q == 6) {
                contractOrderPlace.D0("lightning_ioc");
            } else if (Q == 2) {
                contractOrderPlace.D0("opponent_ioc");
            } else if (Q == 3) {
                contractOrderPlace.D0("optimal_5_ioc");
            } else if (Q == 4) {
                contractOrderPlace.D0("optimal_10_ioc");
            } else if (Q == 5) {
                contractOrderPlace.D0("optimal_20_ioc");
            }
        } else if (5 == contractOrderPlace.t()) {
            if (O == 7) {
                contractOrderPlace.D0("formula_price");
            } else if (O == 3) {
                contractOrderPlace.D0("optimal_5");
            } else if (O == 4) {
                contractOrderPlace.D0("optimal_10");
            } else if (O == 5) {
                contractOrderPlace.D0("optimal_20");
            }
        } else if (6 == contractOrderPlace.t()) {
            contractOrderPlace.D0(PrimeRounds.ROUND_TRADE_MARKET_TYPE);
        } else if (Q == 1) {
            contractOrderPlace.D0("limit");
        } else if (Q == 6) {
            contractOrderPlace.D0("");
        } else if (Q == 2) {
            contractOrderPlace.D0("opponent");
        } else if (Q == 3) {
            contractOrderPlace.D0("optimal_5");
        } else if (Q == 4) {
            contractOrderPlace.D0("optimal_10");
        } else if (Q == 5) {
            contractOrderPlace.D0("optimal_20");
        } else if (Q == 8) {
            contractOrderPlace.D0(PrimeRounds.ROUND_TRADE_MARKET_TYPE);
        }
        if (1 == contractOrderPlace.t()) {
            if (m.a(contractOrderPlace.S()).compareTo(BigDecimal.valueOf(contractOrderPlace.k())) >= 0) {
                contractOrderPlace.a1("ge");
            } else {
                contractOrderPlace.a1("le");
            }
        }
        return contractOrderPlace;
    }

    public boolean b(int i11) {
        return i11 == 0 || i11 == 6 || i11 == 2 || i11 == 3 || i11 == 4;
    }
}
