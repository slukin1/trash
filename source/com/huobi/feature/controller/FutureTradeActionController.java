package com.huobi.feature.controller;

import android.content.Context;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.huobi.contract.entity.ContractOrderPlace;
import i6.m;
import java.math.BigDecimal;

public abstract class FutureTradeActionController {

    /* renamed from: a  reason: collision with root package name */
    public BigDecimal f44623a;

    /* renamed from: b  reason: collision with root package name */
    public BigDecimal f44624b;

    /* renamed from: c  reason: collision with root package name */
    public BigDecimal f44625c;

    /* renamed from: d  reason: collision with root package name */
    public BigDecimal f44626d;

    /* renamed from: e  reason: collision with root package name */
    public BigDecimal f44627e;

    /* renamed from: f  reason: collision with root package name */
    public BigDecimal f44628f;

    /* renamed from: g  reason: collision with root package name */
    public String f44629g;

    public abstract void a(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo);

    public abstract void b(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo);

    public abstract void c(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo);

    public abstract void d(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo);

    public abstract ContractOrderPlace e(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo);

    public ContractOrderPlace f(ContractOrderPlace contractOrderPlace) {
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

    public BigDecimal g() {
        return this.f44627e;
    }

    public BigDecimal h() {
        return this.f44623a;
    }

    public BigDecimal i() {
        BigDecimal bigDecimal = this.f44625c;
        return bigDecimal != null ? bigDecimal : BigDecimal.ZERO;
    }

    public BigDecimal j() {
        BigDecimal bigDecimal = this.f44626d;
        return bigDecimal != null ? bigDecimal : BigDecimal.ZERO;
    }

    public BigDecimal k() {
        return this.f44628f;
    }

    public String l() {
        return this.f44629g;
    }

    public boolean m(int i11) {
        return i11 == 0 || i11 == 6 || i11 == 2 || i11 == 3 || i11 == 4;
    }

    public void n(BigDecimal bigDecimal) {
        this.f44627e = bigDecimal;
    }

    public void o(BigDecimal bigDecimal) {
        this.f44623a = bigDecimal;
    }

    public void p(BigDecimal bigDecimal) {
        this.f44624b = bigDecimal;
    }

    public void q(BigDecimal bigDecimal) {
        this.f44625c = bigDecimal;
    }

    public void r(BigDecimal bigDecimal) {
        this.f44626d = bigDecimal;
    }

    public ContractOrderPlace s(ContractOrderPlace contractOrderPlace) {
        int t11 = contractOrderPlace.t();
        int Q = contractOrderPlace.Q();
        String w11 = contractOrderPlace.w();
        if (t11 == 1) {
            if (Q != 1) {
                w11 = contractOrderPlace.S();
            }
        } else if (t11 == 6 || Q != 1) {
            w11 = contractOrderPlace.n() != 0.0d ? BigDecimal.valueOf(contractOrderPlace.n()).toPlainString() : contractOrderPlace.f() != 0.0d ? BigDecimal.valueOf(contractOrderPlace.f()).toPlainString() : m.a(contractOrderPlace.m()).toPlainString();
        }
        contractOrderPlace.B0(w11);
        return contractOrderPlace;
    }

    public void t(String str) {
        this.f44629g = str;
    }

    public void u(BigDecimal bigDecimal) {
        this.f44628f = bigDecimal;
    }

    public abstract ContractOrderPlace v(Context context, ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo);

    public abstract void w(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo, Context context);
}
