package com.huobi.zeroswap.vm;

import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.m0;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroCreateBean;
import com.huobi.copytrading.engine.CopytradingNativeAbility;
import com.huobi.edgeengine.ability.AbstractAbility;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.LottieWidget;
import com.huobi.zeroswap.engine.widget.KLineListViewWidget;
import com.huobi.zeroswap.engine.widget.KLineViewWidget;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class ZeroSwapViewModel extends a {

    /* renamed from: l  reason: collision with root package name */
    public final WeakReference<Context> f21229l;

    /* renamed from: m  reason: collision with root package name */
    public final MutableLiveData<ActivityZeroCreateBean> f21230m;

    /* renamed from: n  reason: collision with root package name */
    public final LiveData<ActivityZeroCreateBean> f21231n;

    /* renamed from: o  reason: collision with root package name */
    public final String f21232o = "activityzero";

    public ZeroSwapViewModel(WeakReference<Context> weakReference, Application application) {
        super(application);
        this.f21229l = weakReference;
        MutableLiveData<ActivityZeroCreateBean> mutableLiveData = new MutableLiveData<>();
        this.f21230m = mutableLiveData;
        this.f21231n = mutableLiveData;
    }

    public WeakReference<Context> h0() {
        return this.f21229l;
    }

    public List<String> i0() {
        return CollectionsKt__CollectionsJVMKt.e(this.f21232o);
    }

    public HashMap<String, HashMap<String, Class<? extends AbstractAbility>>> k0() {
        return MapsKt__MapsKt.j(l.a(this.f21232o, MapsKt__MapsKt.j(l.a("copyTradingBridge", CopytradingNativeAbility.class))));
    }

    public HashMap<String, HashMap<String, Class<? extends Widget>>> l0() {
        return MapsKt__MapsKt.j(l.a(this.f21232o, MapsKt__MapsKt.j(KLineViewWidget.f21216i0.a(), l.a("LottieView", LottieWidget.class), KLineListViewWidget.f21213i0.a())));
    }

    public String m0() {
        return "ZeroSwapViewModel";
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
        a.f(this, this.f21232o, "moduleDisappear", (JSONObject) null, 4, (Object) null);
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
        Boolean value = o0().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        if (value.booleanValue()) {
            a.c(this, this.f21232o, "openPosition", "onAppear", (JSONObject) null, 8, (Object) null);
            a.f(this, this.f21232o, "moduleAppear", (JSONObject) null, 4, (Object) null);
        }
    }

    public final void t0() {
        a.f(this, this.f21232o, "requestPositionList", (JSONObject) null, 4, (Object) null);
    }

    public final void u0() {
        a.c(this, this.f21232o, "openPosition", "start", (JSONObject) null, 8, (Object) null);
    }

    public final LiveData<ActivityZeroCreateBean> v0() {
        return this.f21231n;
    }

    public final String w0() {
        return this.f21232o;
    }

    public final void x0() {
        n1 unused = i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new ZeroSwapViewModel$onRequestActivityZeroCreate$1(this, (c<? super ZeroSwapViewModel$onRequestActivityZeroCreate$1>) null), 3, (Object) null);
    }

    public final void y0() {
        a.c(this, this.f21232o, "position", "showActivityRuleDialog", (JSONObject) null, 8, (Object) null);
    }

    public final void z0(ViewGroup viewGroup) {
        a.r0(this, this.f21232o, "headerProfit.xml", viewGroup, (JSONObject) null, 8, (Object) null);
    }
}
