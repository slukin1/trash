package com.huobi.newtrade.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.trade.helper.d;
import d7.a1;
import dt.i2;
import java.util.List;
import ro.a;

public abstract class NewTradeBasePresenter<V extends a> extends BaseFragmentPresenter<V> {

    /* renamed from: c  reason: collision with root package name */
    public TradeType f78056c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f78057d = true;

    /* renamed from: e  reason: collision with root package name */
    public String f78058e;

    /* renamed from: f  reason: collision with root package name */
    public String f78059f;

    /* renamed from: g  reason: collision with root package name */
    public String f78060g;

    /* renamed from: h  reason: collision with root package name */
    public qo.a f78061h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f78062i;

    public void Y(boolean z11) {
        super.Y(z11);
        d0(z11);
    }

    public final void b0() {
        String d11 = i2.a().d(this.f78056c);
        if (!TextUtils.isEmpty(d11)) {
            this.f78058e = d11;
            SymbolBean J = a1.v().J(this.f78058e, this.f78056c);
            this.f78060g = J.getSymbolName();
            this.f78059f = J.getBaseCurrency();
        } else {
            List<SymbolBean> Z = a1.v().Z(this.f78056c);
            if (Z != null && !Z.isEmpty()) {
                SymbolBean symbolBean = Z.get(0);
                this.f78058e = symbolBean.getSymbol();
                this.f78060g = symbolBean.getSymbolName();
                this.f78059f = symbolBean.getBaseCurrency();
                i2.a().h(this.f78056c, this.f78058e);
            }
        }
        this.f78061h.u(this.f78058e);
    }

    /* renamed from: c0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        this.f78056c = TradeType.valueOf(Q().getArguments().getString("key_trade_type", TradeType.PRO.name()));
        qo.a aVar = new qo.a(((a) getUI()).U6(), getActivity());
        this.f78061h = aVar;
        aVar.w(this.f78056c);
        ((a) getUI()).Je(this.f78061h);
        this.f78061h.g(0, false);
    }

    public void d0(boolean z11) {
        if (getActivity() != null) {
            if (z11) {
                if (d.b(this.f78056c)) {
                    boolean a11 = d.a(this.f78056c);
                    this.f78057d = a11;
                    this.f78061h.s(a11);
                    d.c(this.f78056c);
                    ((a) getUI()).B(d.a(this.f78056c) ^ true ? 1 : 0);
                }
                b0();
            }
            this.f78062i = true;
        }
    }
}
