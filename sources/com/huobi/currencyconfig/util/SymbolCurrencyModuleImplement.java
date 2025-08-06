package com.huobi.currencyconfig.util;

import android.text.TextUtils;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.data.symbol.SymbolsDataProvider;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import d7.a1;
import d7.c1;
import ht.o;
import tg.r;

public class SymbolCurrencyModuleImplement implements c1 {

    public class a extends BaseEasySubscriber<PrimeInfo> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SymbolBean f43762g;

        public a(SymbolBean symbolBean) {
            this.f43762g = symbolBean;
        }

        /* renamed from: k */
        public void onNext(PrimeInfo primeInfo) {
            super.onNext(primeInfo);
            if (primeInfo != null && this.f43762g.getSymbol().equalsIgnoreCase(primeInfo.getSymbolCode())) {
                this.f43762g.setGlobalVisible(primeInfo.isVisible());
                RetrofitLogger.a("SymbolConfigImpl-->getSymbols-->subscribe");
            }
        }
    }

    public boolean a() {
        return r.x().F0();
    }

    public String b() {
        return SymbolsDataProvider.i(r.x().J());
    }

    public boolean c(String str) {
        PrimeInfo F = o.B().F();
        return a1.v().s0(str) && F != null && !TextUtils.isEmpty(F.getSymbolCode()) && F.getSymbolCode().equals(str) && F.isListingTransfer();
    }

    public boolean d(String str) {
        PrimeInfo F = o.B().F();
        return a1.v().s0(str) && F != null && !TextUtils.isEmpty(F.getSymbolCode()) && F.getSymbolCode().equals(str) && F.isPrimeLite();
    }

    public void e(SymbolBean symbolBean) {
        PrimeInfo F;
        if (!symbolBean.isHiddenTag() && symbolBean.isPrimeTag()) {
            o.B().o0().subscribe(new a(symbolBean));
        } else if (!symbolBean.isPrimeTag() && (F = o.B().F()) != null && F.getSymbolCode() != null && F.getSymbolCode().equalsIgnoreCase(symbolBean.getSymbol())) {
            o.B().x();
        }
    }

    public boolean f(String str) {
        PrimeInfo F = o.B().F();
        return a1.v().s0(str) && F != null && !TextUtils.isEmpty(F.getSymbolCode()) && F.getSymbolCode().equals(str) && F.isPrime();
    }
}
