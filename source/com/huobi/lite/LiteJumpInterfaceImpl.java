package com.huobi.lite;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ChannelUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.activity.AppConfigActivity;
import com.huobi.entity.UpdateResponse;
import com.huobi.lite.kyc.ui.BaseLiteFaceLiveDetectionActivity;
import com.huobi.lite.kyc.ui.LiteVerifiedActivity;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.message.ui.MessageActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.utils.UpgradeUtil;
import com.huobi.utils.k0;
import com.zopim.android.sdk.api.ZopimChat;
import eh.h;
import ra.b;
import rn.c;
import sn.f;
import u6.g;
import yl.o;

public class LiteJumpInterfaceImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f75364a = false;

    public class a extends EasySubscriber<UpdateResponse> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f75365b;

        public a(Activity activity) {
            this.f75365b = activity;
        }

        /* renamed from: a */
        public void onNext(UpdateResponse updateResponse) {
            super.onNext(updateResponse);
            boolean unused = LiteJumpInterfaceImpl.this.f75364a = true;
            String downloadurl = updateResponse.getDownloadurl();
            if (updateResponse.getVersion_code() <= 105400) {
                UpgradeUtil.d((String) null);
                SP.u("user_config", "config_app_upgrade_count", 0);
            } else {
                UpgradeUtil.d(downloadurl);
                if (!(updateResponse.getMd5() == null || updateResponse.getDirect_downloadurl() == null)) {
                    h.q().k(updateResponse);
                }
            }
            if (LiteJumpInterfaceImpl.this.u(updateResponse) && updateResponse.getService_check() <= 0 && "upgrade".equals(updateResponse.getMsgtype()) && UpgradeUtil.c()) {
                h.z(this.f75365b, updateResponse);
            }
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (!LiteJumpInterfaceImpl.this.f75364a) {
                boolean unused = LiteJumpInterfaceImpl.this.f75364a = true;
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (!LiteJumpInterfaceImpl.this.f75364a) {
                boolean unused = LiteJumpInterfaceImpl.this.f75364a = true;
            }
        }

        public void onStart() {
            super.onStart();
        }
    }

    public void a(Context context, String str) {
        o.C(context, str);
    }

    public void b(FragmentActivity fragmentActivity, Intent intent, String str, boolean z11) {
        Class<HuobiMainActivity> cls = HuobiMainActivity.class;
        String str2 = TextUtils.equals(str, "balance") ? "pro.huobi.balance" : "";
        if (!TextUtils.isEmpty(str) && intent != null) {
            intent.setComponent(new ComponentName(fragmentActivity, cls));
            intent.putExtra("navigator_action", str2);
        }
        if (z11) {
            LiteExchangeDialogFragment.zh(fragmentActivity, intent, false);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setComponent(new ComponentName(fragmentActivity, cls));
            intent.putExtra("navigator_action", str2);
        }
        fragmentActivity.startActivity(intent);
    }

    public void c(Activity activity, String str, String str2) {
        f.h0(activity, str, str2);
    }

    public void d(Activity activity) {
        AppLanguageHelper.getInstance().openAppLanguageActivity(activity, AppConfigActivity.class);
    }

    public void e(Activity activity, Intent intent, Intent intent2) {
        c.i().m(activity, (intent == null && intent2 == null) ? null : new JumpTarget(intent, intent2));
    }

    public Class f() {
        return OtcTradeActivity.class;
    }

    public Intent g(Activity activity) {
        return new Intent(activity, MessageActivity.class);
    }

    public void h(Activity activity) {
        f.y(activity, (ZopimChat.SessionConfig) null);
        ZopimChat.trackEvent("Started chat with mandatory pre-chat form");
    }

    public void i(Activity activity, boolean z11, boolean z12, boolean z13) {
        if (!z11) {
            LiteVerifiedActivity.qh(activity, z12, z13);
        } else {
            BaseLiteFaceLiveDetectionActivity.Og(activity, "", "", "", z12);
        }
    }

    public void j(Activity activity) {
        c.i().d(activity, new JumpTarget(new Intent(db.a.b().c()), new Intent(db.a.b().a())));
    }

    public void k(Context context) {
        Intent intent = new Intent(context, LiteReMainActivity.class);
        intent.putExtra("lite_navigator_action", "lite_re_main_asset_action");
        context.startActivity(intent);
    }

    public void l(String str) {
        try {
            oa.a.g().f(Class.forName(str)).finish();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public Intent m(Context context) {
        return new Intent(context, LiteReMainActivity.class);
    }

    public void n() {
    }

    public Intent o(Context context) {
        return k0.h(context);
    }

    public void p(Activity activity) {
        f.J(activity);
    }

    public void q(Activity activity) {
        if (!this.f75364a && !"GooglePlayAndroid".equals(ChannelUtils.b())) {
            h.B().compose(RxJavaHelper.t((g) null)).subscribe(new a(activity));
        }
    }

    public final boolean u(UpdateResponse updateResponse) {
        if (updateResponse.getIs_popup() <= 0) {
            return false;
        }
        if (updateResponse.getForce_upgrade() == 1) {
            return true;
        }
        long w11 = DateTimeUtils.w();
        if (w11 - ((long) ConfigPreferences.g("user_config", "config_app_upgrade_time", 0)) < 86400) {
            return false;
        }
        ConfigPreferences.l("user_config", "config_app_upgrade_time", w11);
        int f11 = SP.f("user_config", "config_app_upgrade_count", 0);
        if (f11 >= updateResponse.getTip_count_sum()) {
            return false;
        }
        SP.u("user_config", "config_app_upgrade_count", f11 + 1);
        return true;
    }
}
