package com.huobi.lite;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lib.network.uc.retrofit.bean.UcAuthorizationBean;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.google.GooglePlayUtil;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.controller.KillProcessProxy;
import com.huobi.login.usercenter.data.source.api.UserCenterService;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.otc.bean.ReminderData;
import com.huobi.otc.helper.OtcLoginHelper;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.utils.ImageUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fn.f;
import fn.h;
import gp.g;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jp.l;
import ra.d;
import rn.c;
import rx.Observable;
import tg.r;
import tq.p;

public class LiteModuleInterfaceImpl implements d {

    /* renamed from: a  reason: collision with root package name */
    public g.C0864g f75367a;

    /* renamed from: b  reason: collision with root package name */
    public b f75368b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c6.b<Boolean>> f75369c = new ArrayList();

    public class b implements g.C0864g {
        public b() {
        }

        public void a(ReminderData reminderData) {
            synchronized (LiteModuleInterfaceImpl.this.f75369c) {
                for (c6.b bVar : LiteModuleInterfaceImpl.this.f75369c) {
                    if (bVar != null) {
                        bVar.onCallback(Boolean.valueOf(reminderData != null));
                    }
                }
            }
        }
    }

    public static /* synthetic */ Observable J(UcAuthorizationBean ucAuthorizationBean) {
        if (ucAuthorizationBean != null) {
            return Observable.just(ucAuthorizationBean.getAuthToken());
        }
        return Observable.just(null);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void L(Activity activity, View view) {
        KillProcessProxy.d(activity);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public com.hbg.lite.index.bean.ReminderData A() {
        return ReminderData.toLiteReminderData(OtcOrderReminder.e().f());
    }

    public void B(c6.b<Boolean> bVar) {
        synchronized (this.f75369c) {
            this.f75369c.add(bVar);
        }
        if (this.f75368b == null) {
            this.f75368b = new b();
            OtcOrderReminder.e().b(this.f75368b);
        }
    }

    public boolean C(Activity activity, Intent intent, Intent intent2) {
        if (p()) {
            return true;
        }
        c.i().d(activity, new JumpTarget(intent2, intent));
        return false;
    }

    public String D() {
        String str = wi.b.f48040d;
        if (!SystemUtils.c()) {
            return str;
        }
        String I = DomainSwitcher.I();
        return !TextUtils.isEmpty(I) ? str.replace("l10n-api.huobi.cn/", I) : str;
    }

    public void E() {
        UserCenterRemoteDataSource.A().v0();
    }

    public void F() {
        gj.g.e().k();
    }

    public void G() {
    }

    public String c() {
        return r.x().E();
    }

    public List<Integer> d() {
        UserInfoData M = r.x().M();
        if (M != null) {
            return M.d();
        }
        return null;
    }

    public void e(String str) {
        r.x().t0(str);
    }

    public String f(Bitmap bitmap, Bitmap.CompressFormat compressFormat, File file) {
        return ImageUtils.h(bitmap, compressFormat, file);
    }

    public void g(View view, boolean z11) {
        OtcOrderReminder.e().k(view, z11);
    }

    public String getUid() {
        return r.x().J();
    }

    public boolean h(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.HOME");
            activity.startActivity(intent);
            return true;
        } catch (Exception unused) {
            KillProcessProxy.c(activity);
            return true;
        }
    }

    public void i(c6.b bVar) {
        gj.g.e().i(bVar);
    }

    public void j() {
        DomainSwitcher.A().V0();
    }

    public Observable<String> k() {
        return ((UserCenterService) p.b0(UserCenterService.class)).getAuthorization("ASSET_PASSWORD_CHECK").compose(p.c0()).flatMap(h.f54710b);
    }

    public void l(String str, Map<String, Object> map) {
        hs.a.b().c(str, map);
    }

    public TeachConfigItem m(int i11) {
        return gj.g.e().f(i11);
    }

    public void n(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, str2.toLowerCase(Locale.US));
        }
        hs.a.b().c(str, hashMap);
    }

    public boolean o() {
        return OtcOrderReminder.e().f() != null;
    }

    public boolean p() {
        return r.x().F0();
    }

    public void q(Activity activity) {
        GooglePlayUtil.b(activity, new f(activity));
    }

    public void r(ya.a aVar) {
        if (this.f75367a != null) {
            OtcOrderReminder.e().m(this.f75367a);
        }
        if (aVar != null) {
            OtcOrderReminder.e().n();
            aVar.a(ReminderData.toLiteReminderData(OtcOrderReminder.e().f()));
            this.f75367a = new fn.g(aVar);
            OtcOrderReminder.e().b(this.f75367a);
        }
    }

    public Application s() {
        return j.c();
    }

    public void t(c6.b<Boolean> bVar) {
        synchronized (this.f75369c) {
            this.f75369c.remove(bVar);
        }
        if (this.f75369c.isEmpty()) {
            OtcOrderReminder.e().m(this.f75368b);
        }
    }

    public void track(String str, HashMap hashMap) {
        gs.g.i(str, hashMap);
    }

    public boolean u() {
        return LiteReHelper.a().b();
    }

    public String v(BigDecimal bigDecimal) {
        return LegalCurrencyConfigUtil.L(bigDecimal);
    }

    public Observable<String> w(Map<String, Object> map) {
        return l.G(map).compose(p.a0());
    }

    public Observable<String> x() {
        return OtcLoginHelper.g();
    }

    public void y(FragmentActivity fragmentActivity, u6.g gVar) {
        ui.d.m(fragmentActivity, gVar);
    }

    public void z(BaseCoreActivity baseCoreActivity, boolean z11) {
        if (z11) {
            OtcOrderReminder.e().c(baseCoreActivity);
        } else {
            OtcOrderReminder.e().d(baseCoreActivity);
        }
    }
}
