package dn;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapWhiteList;
import com.hbg.lib.network.linear.swap.core.bean.UnionModeData;
import com.hbg.lib.network.linear.swap.core.bean.UnionModeWhiteListInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tg.r;
import u6.g;

public final class d {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f76142g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f76143h;

    /* renamed from: a  reason: collision with root package name */
    public List<HeavyBubbleDialog> f76144a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<HighLightPopup> f76145b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<View> f76146c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Boolean> f76147d = new HashMap(2);

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Boolean> f76148e = new HashMap(2);

    /* renamed from: f  reason: collision with root package name */
    public final Handler f76149f = new C0806d();

    public class a extends BaseSubscriber<List<LinearSwapWhiteList>> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            d.this.o(true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            d.this.o(true);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            d.this.f76149f.postDelayed(new b(this), 15000);
        }

        public void onNext(List<LinearSwapWhiteList> list) {
            super.onNext(list);
            for (LinearSwapWhiteList next : list) {
                if (TextUtils.equals(next.getScene(), "1")) {
                    boolean is_hit = next.is_hit();
                    d.this.f76147d.put(r.x().J(), Boolean.valueOf(is_hit));
                    if (!is_hit) {
                        d.this.f76149f.postDelayed(new c(this), 300000);
                    }
                } else if (TextUtils.equals(next.getScene(), "2")) {
                    d.this.f76148e.put(r.x().J(), Boolean.valueOf(next.is_hit()));
                }
            }
        }
    }

    public class b extends EasySubscriber<UnionModeWhiteListInfo> {
        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            d.this.d();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            d.this.d();
        }

        /* renamed from: e */
        public void onNext(UnionModeWhiteListInfo unionModeWhiteListInfo) {
            SP.y("union_permission_status", unionModeWhiteListInfo.isUnionUser());
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            d.this.f76149f.postDelayed(new f(this), 15000);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            d.this.f76149f.postDelayed(new e(this), 15000);
        }
    }

    public class c extends EasySubscriber<UnionModeData> {
        public c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            d.this.n();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            d.this.n();
        }

        /* renamed from: e */
        public void onNext(UnionModeData unionModeData) {
            SPUtil.s(unionModeData.isUnionMode());
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            d.this.f76149f.postDelayed(new g(this), 15000);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            d.this.f76149f.postDelayed(new h(this), 15000);
        }
    }

    /* renamed from: dn.d$d  reason: collision with other inner class name */
    public class C0806d extends Handler {
        public C0806d() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public static d f() {
        if (f76143h == null) {
            synchronized (d.class) {
                if (f76143h == null) {
                    f76143h = new d();
                }
            }
        }
        return f76143h;
    }

    public void d() {
        h8.a.a().queryUnionWhiteList().b().compose(RxJavaHelper.t((g) null)).subscribe(new b());
    }

    public int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        if (!ConfigPreferences.a("user_config", "config_linear_swap_b_unit_type_" + str)) {
            return ConfigPreferences.g("user_config", "config_linear_swap_b_unit_type", 5);
        }
        return ConfigPreferences.g("user_config", "config_linear_swap_b_unit_type_" + str, 5);
    }

    public int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        if (!ConfigPreferences.a("user_config", "config_linear_swap_j_unit_type_" + str)) {
            return ConfigPreferences.g("user_config", "config_linear_swap_j_unit_type", 5);
        }
        return ConfigPreferences.g("user_config", "config_linear_swap_j_unit_type_" + str, 5);
    }

    public int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (!ConfigPreferences.a("user_config", "config_linear_swap_margin_type_" + str)) {
            return ConfigPreferences.g("user_config", "config_linear_swap_margin_type", 1);
        }
        return ConfigPreferences.g("user_config", "config_linear_swap_margin_type_" + str, 1);
    }

    public int i(String str) {
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        if (!ConfigPreferences.a("user_config", "config_linear_swap_unit_type_" + str)) {
            return ConfigPreferences.g("user_config", "config_linear_swap_unit_type", 3);
        }
        return ConfigPreferences.g("user_config", "config_linear_swap_unit_type_" + str, 3);
    }

    public boolean j(String str) {
        return h(str) == 1;
    }

    public boolean k() {
        Boolean bool = this.f76148e.get(r.x().J());
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean l() {
        return f76142g;
    }

    public boolean m() {
        Boolean bool = this.f76147d.get(r.x().J());
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void n() {
        h8.a.a().H().b().compose(RxJavaHelper.t((g) null)).subscribe(new c());
    }

    public void o(boolean z11) {
        if (!r.x().F0()) {
            return;
        }
        if (z11 || this.f76147d.get(r.x().J()) == null) {
            this.f76149f.removeCallbacksAndMessages((Object) null);
            HashMap hashMap = new HashMap();
            hashMap.put(InnerShareParams.SCENCE, "1,2");
            h8.a.a().queryUserIshit(hashMap).b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
        }
    }

    public void p(int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            ConfigPreferences.k("user_config", "config_linear_swap_b_unit_type_" + str, i11);
        }
    }

    public void q(int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            ConfigPreferences.k("user_config", "config_linear_swap_j_unit_type_" + str, i11);
        }
    }

    public void r(int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            ConfigPreferences.k("user_config", "config_linear_swap_margin_type_" + str, i11);
        }
    }

    public void s(int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            ConfigPreferences.k("user_config", "config_linear_swap_unit_type_" + str, i11);
        }
    }
}
