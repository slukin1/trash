package com.huobi.account.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.bean.LitePersonalCenterBean;
import com.huobi.activity.AppConfigAboutUsActivity;
import com.huobi.activity.AppConfigActivity;
import com.huobi.coupon.bean.Coupon;
import com.huobi.entity.UserTransInfo;
import com.huobi.lite.LiteExchangeDialogFragment;
import com.huobi.litere.BaseLiteReFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.UpgradeUtil;
import com.huobi.utils.UserInfoUtil;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import pro.huobi.R;
import qiu.niorgai.StatusBarCompat;
import rn.c;
import sn.f;
import tg.r;

public class LitePersonalCenterActivity extends BaseLiteReFlutterActivity {

    /* renamed from: n  reason: collision with root package name */
    public MethodChannel f41219n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f41220o;

    /* renamed from: p  reason: collision with root package name */
    public String f41221p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f41222q = Coupon.SPOT;

    /* renamed from: r  reason: collision with root package name */
    public boolean f41223r;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            LitePersonalCenterActivity.this.qj(methodCall, result);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void nj(LitePersonalCenterBean litePersonalCenterBean, MethodChannel.Result result, UserTransInfo userTransInfo, UnifyKycInfo unifyKycInfo) {
        if (userTransInfo != null) {
            if ("--".equals(userTransInfo.getTitle())) {
                litePersonalCenterBean.setUserName("--");
            } else {
                litePersonalCenterBean.setUserName(userTransInfo.getTitle());
            }
            litePersonalCenterBean.setUid(r.x().J());
            litePersonalCenterBean.setLogin(r.x().F0());
            litePersonalCenterBean.setUpdate(UpgradeUtil.c());
            litePersonalCenterBean.setCurrentVersion("10.54.0");
            litePersonalCenterBean.setJumpChannel(userTransInfo.getKycJumpChannel());
            litePersonalCenterBean.setSubTag(userTransInfo.getKycStateLabel());
            this.f41222q = userTransInfo.getKycJumpChannel();
        }
        result.success(new Gson().toJson((Object) litePersonalCenterBean));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oj(MethodChannel.Result result, UserTransInfo userTransInfo, UnifyKycInfo unifyKycInfo) {
        LitePersonalCenterBean litePersonalCenterBean = new LitePersonalCenterBean();
        if (userTransInfo != null) {
            if ("--".equals(userTransInfo.getTitle())) {
                litePersonalCenterBean.setUserName("");
            } else {
                litePersonalCenterBean.setUserName(userTransInfo.getTitle());
            }
            litePersonalCenterBean.setUid(r.x().J());
            litePersonalCenterBean.setJumpChannel(userTransInfo.getKycJumpChannel());
            litePersonalCenterBean.setSubTag(userTransInfo.getKycStateLabel());
            this.f41222q = userTransInfo.getKycJumpChannel();
        }
        result.success(new Gson().toJson((Object) litePersonalCenterBean));
    }

    public static void sj(Context context) {
        context.startActivity(new Intent(context, LitePersonalCenterActivity.class));
    }

    public String Nh() {
        return "lite_personal_center";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "lite_personal_center_channel");
        this.f41219n = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public final JumpTarget lj(Intent intent) {
        JumpTarget jumpTarget = new JumpTarget(intent, (Intent) null);
        jumpTarget.setExpandData("LOGIN_FROM_PERSONAL_CENTER");
        return jumpTarget;
    }

    public final void mj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            LitePersonalCenterBean litePersonalCenterBean = new LitePersonalCenterBean();
            if (r.x().F0()) {
                UserInfoUtil.g(this, new h0(this, litePersonalCenterBean, result));
                return;
            }
            litePersonalCenterBean.setUid(r.x().J());
            litePersonalCenterBean.setUserName("");
            litePersonalCenterBean.setLogin(false);
            litePersonalCenterBean.setUpdate(UpgradeUtil.c());
            litePersonalCenterBean.setCurrentVersion("10.54.0");
            result.success(new Gson().toJson((Object) litePersonalCenterBean));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("LitePersonalCenterActivity", e11.getMessage(), e11.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarCompat.d(this, true);
        if (NightHelper.e().g()) {
            StatusBarCompat.a(this);
        } else {
            StatusBarCompat.b(this);
        }
        this.f41220o = r.x().F0();
        this.f41223r = true;
    }

    public void onPointerCaptureChanged(boolean z11) {
    }

    public void onResume() {
        MethodChannel methodChannel;
        super.onResume();
        if (!this.f41223r && (methodChannel = this.f41219n) != null) {
            methodChannel.invokeMethod("personal_update_login_state", (Object) null);
        }
        this.f41223r = false;
    }

    public final void pj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (r.x().F0()) {
                UserInfoUtil.g(this, new i0(this, result));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("LitePersonalCenterActivity", e11.getMessage(), e11.getMessage());
        }
    }

    public SplashScreen provideSplashScreen() {
        return new DrawableSplashScreen(new ColorDrawable(getResources().getColor(R.color.baseColorContentBackground)), ImageView.ScaleType.FIT_XY, 200);
    }

    public void qj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1609279598:
                    if (str.equals("personal_open_general")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1595693930:
                    if (str.equals("personal_options_kyc_confirm")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case -1335191813:
                    if (str.equals("personal_open_orders")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -749202249:
                    if (str.equals("personal_open_about")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -732413687:
                    if (str.equals("personal_open_share")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -214861588:
                    if (str.equals("personal_open_header_click")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 790691286:
                    if (str.equals("personal_open_security")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 911068793:
                    if (str.equals("personal_open_support")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1416525718:
                    if (str.equals("personal_open_global_email")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 1501032095:
                    if (str.equals("personal_open_load_user_info")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 1507628327:
                    if (str.equals("personal_open_global_pro")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 1635597882:
                    if (str.equals("personal_init_data")) {
                        c11 = 0;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    mj(methodCall, result);
                    return;
                case 1:
                    rj(false);
                    result.success((Object) null);
                    return;
                case 2:
                    c.i().d(this, lj(new Intent(this, AccountOrderManageActivity.class)));
                    result.success((Object) null);
                    return;
                case 3:
                    if (!r.x().F0()) {
                        c.i().d(this, lj(new Intent(this, SecuritySetActivity.class)));
                    } else if (!NetworkStatus.c(this)) {
                        HuobiToastUtil.j(R.string.server_error);
                        return;
                    } else {
                        startActivity(new Intent(this, SecuritySetActivity.class));
                    }
                    is.a.i("5235", (Map<String, Object>) null);
                    result.success((Object) null);
                    return;
                case 4:
                    AppConfigActivity.Xh(this);
                    is.a.i("5236", (Map<String, Object>) null);
                    result.success((Object) null);
                    return;
                case 5:
                    startActivity(f.h(this));
                    result.success((Object) null);
                    return;
                case 6:
                    AppConfigAboutUsActivity.Sh(this);
                    is.a.i("5237", (Map<String, Object>) null);
                    result.success((Object) null);
                    return;
                case 7:
                    return;
                case 8:
                    f.O(this);
                    result.success((Object) null);
                    return;
                case 9:
                    pj(methodCall, result);
                    return;
                case 10:
                    LiteExchangeDialogFragment.Ah(this, false);
                    result.success((Object) null);
                    return;
                case 11:
                    rj(true);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void rj(boolean z11) {
        if (!r.x().X()) {
            Intent q11 = f.q(this, this.f41222q, "1");
            if (r.x().F0()) {
                startActivity(q11);
                return;
            }
            if (!z11) {
                q11 = null;
            }
            c.i().d(this, lj(q11));
        }
    }
}
