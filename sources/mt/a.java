package mt;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.data.symbol.TradeType;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.jvm.internal.r;

public final class a extends com.huobi.zeroswap.vm.a {

    /* renamed from: m  reason: collision with root package name */
    public static final C0876a f84450m = new C0876a((r) null);

    /* renamed from: l  reason: collision with root package name */
    public WeakReference<Context> f84451l;

    /* renamed from: mt.a$a  reason: collision with other inner class name */
    public static final class C0876a {
        public C0876a() {
        }

        public /* synthetic */ C0876a(r rVar) {
            this();
        }
    }

    public a(Application application) {
        super(application);
    }

    public WeakReference<Context> h0() {
        return this.f84451l;
    }

    public List<String> i0() {
        return CollectionsKt__CollectionsJVMKt.e("exchange");
    }

    public final void s0(String str, TradeType tradeType) {
        Log.d("广告位", "symbol = " + str + " , tradeType = " + tradeType);
        if (str.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("symbol", str);
            jSONObject.put("showType", 9);
            jSONObject.put("pageType", Integer.valueOf(tradeType == TradeType.PRO ? 43 : 44));
            b("exchange", "adActivityBanner", "pageAppear", jSONObject);
        }
    }

    public final void t0() {
        com.huobi.zeroswap.vm.a.c(this, "exchange", "adActivityBanner", "pageDisappear", (JSONObject) null, 8, (Object) null);
    }

    public final void u0(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            com.huobi.zeroswap.vm.a.r0(this, "exchange", "adActivityBanner.xml", viewGroup, (JSONObject) null, 8, (Object) null);
        }
    }

    public final void v0(FragmentActivity fragmentActivity) {
        this.f84451l = new WeakReference<>(fragmentActivity);
        fragmentActivity.getLifecycle().a(this);
    }
}
