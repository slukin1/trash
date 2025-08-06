package com.huobi.account.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.tencent.push.TencentPushManager;
import com.huobi.account.ui.SecurityPasskeyActivity;
import com.huobi.login.ui.SecurityGuideActivity;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.statistics.AppVersionUidHelper;
import i6.d;
import rn.c;
import rx.Observable;
import rx.functions.Action0;
import sn.f;
import tg.h;
import tg.i;
import tg.j;
import tg.k;
import tg.r;
import u6.g;

public class UserLoginHelper {

    /* renamed from: a  reason: collision with root package name */
    public kn.a f40988a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static UserLoginHelper f40989a = new UserLoginHelper();
    }

    public static UserLoginHelper e() {
        return a.f40989a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Context context, kn.a aVar, Action0 action0, UserKycInfoNew userKycInfoNew) {
        com.huobi.lifecycle.a.j().s();
        AppVersionUidHelper.a(context);
        j(context, aVar);
        if (action0 != null) {
            action0.call();
        }
    }

    public void d(Context context) {
        String str;
        try {
            str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("ENGAGELAB_PRIVATES_APPKEY");
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            str = "";
        }
        d.b("UserLoginHelper-->bindCidUid-->appCode = " + str);
        String str2 = !SystemUtils.c() ? "ASB6T7FGUVEX" : "A1QNE66U8GZ4";
        String registrationId = MTCorePrivatesApi.getRegistrationId(context);
        d.b("UserLoginHelper-->bindCidUid-->cid:" + registrationId);
        UserCenterRemoteDataSource.A().D0(MapParamsBuilder.c().a("cid", registrationId).a(com.sumsub.sentry.a.f30241h, "APP_HUOBI_PRO").a("app_code", str).a("tcid", TencentPushManager.a(context)).a("tappcode", str2).b()).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
    }

    public Observable<KvStore> f() {
        return UserCenterRemoteDataSource.A().getKvStore("2", KvStore.QUICK_WITHDRAW);
    }

    public Observable<UserKycInfoNew> g() {
        return r.x().O(false).flatMap(j.f29322b);
    }

    public void h(g gVar, String str, Context context, kn.a aVar, Action0 action0) {
        r.x().O(false).flatMap(k.f29323b).compose(RxJavaHelper.t(gVar)).subscribe(EasySubscriber.create(new i(this, context, aVar, action0)));
    }

    public boolean i() {
        return "360".equals(ChannelUtils.b());
    }

    public void j(Context context, kn.a aVar) {
        k(context, aVar, true);
    }

    public void k(Context context, kn.a aVar, boolean z11) {
        String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
        if (!TextUtils.isEmpty(e11)) {
            this.f40988a = aVar;
            if (!h.c().i() || h.c().e(e11)) {
                o(context, z11);
                return;
            }
            Intent intent = new Intent(context, SecurityPasskeyActivity.class);
            intent.putExtra("checkGuide", z11);
            intent.putExtra("showJump", true);
            context.startActivity(intent);
        }
    }

    public void o(Context context, boolean z11) {
        boolean z12;
        if (z11) {
            Activity activity = (Activity) context;
            z12 = SecurityGuideActivity.Zf(activity, this.f40988a);
            if (!z12) {
                if (r.x().X()) {
                    c.i().A(activity, this.f40988a);
                } else {
                    kn.a aVar = this.f40988a;
                    if (aVar != null) {
                        f.e(activity, aVar);
                    }
                }
            }
        } else {
            if (r.x().X()) {
                c.i().A((Activity) context, this.f40988a);
            } else {
                kn.a aVar2 = this.f40988a;
                if (aVar2 != null) {
                    f.e((Activity) context, aVar2);
                }
            }
            z12 = false;
        }
        if (!z12) {
            tg.d.g().f();
            tg.d.g().f47851a = false;
            return;
        }
        tg.d.g().f47851a = true;
    }
}
