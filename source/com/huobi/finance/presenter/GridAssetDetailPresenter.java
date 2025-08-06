package com.huobi.finance.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.module.asset.R$color;
import g9.a;
import i6.m;
import u6.g;

public class GridAssetDetailPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f45559a;

    /* renamed from: b  reason: collision with root package name */
    public KlineInfo f45560b;

    /* renamed from: c  reason: collision with root package name */
    public LastKlineListener f45561c = new a();

    /* renamed from: d  reason: collision with root package name */
    public a.d f45562d = new c4(this);

    public class a extends LastKlineListener {
        public a() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            KlineInfo unused = GridAssetDetailPresenter.this.f45560b = lastKlineResponse.getTick();
            GridAssetDetailPresenter gridAssetDetailPresenter = GridAssetDetailPresenter.this;
            gridAssetDetailPresenter.W(Double.valueOf(gridAssetDetailPresenter.f45560b.getOpen()), Double.valueOf(GridAssetDetailPresenter.this.f45560b.getClose()));
        }
    }

    public interface b extends g {
        void ah(String str, String str2, int i11);

        String o0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U() {
        x8.a.a().g(true, o0(), Period.day, this.f45561c);
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        this.f45559a = bVar.o0();
    }

    public final void W(Double d11, Double d12) {
        String str;
        int i11;
        String o02 = o0();
        double doubleValue = (d12 == null || d11 == null) ? 0.0d : d12.doubleValue() - d11.doubleValue();
        String str2 = "--";
        if (d12 == null || Double.compare(d12.doubleValue(), 0.0d) == 0) {
            str = str2;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Double.compare(doubleValue, 0.0d) > 0 ? "+" : "");
            sb2.append(m.i((doubleValue / d11.doubleValue()) * 100.0d, PrecisionUtil.v(o02)));
            sb2.append("%");
            str = sb2.toString();
        }
        if (Double.compare(doubleValue, 0.0d) > 0) {
            i11 = getResources().getColor(w.h());
        } else if (Double.compare(doubleValue, 0.0d) < 0) {
            i11 = getResources().getColor(w.d());
        } else {
            i11 = getResources().getColor(R$color.color_flat);
        }
        if (d12 != null) {
            str2 = m.m(String.valueOf(d12), PrecisionUtil.x(o02));
        }
        ((b) getUI()).ah(str2, str, i11);
    }

    public String o0() {
        return this.f45559a;
    }

    public void onPause() {
        super.onPause();
        if (!TextUtils.isEmpty(o0())) {
            x8.a.a().g(false, o0(), Period.day, this.f45561c);
        }
        x8.a.a().c(this.f45562d);
    }

    public void onResume() {
        super.onResume();
        x8.a.a().d(this.f45562d);
        if (!TextUtils.isEmpty(o0())) {
            x8.a.a().g(true, o0(), Period.day, this.f45561c);
        }
    }
}
