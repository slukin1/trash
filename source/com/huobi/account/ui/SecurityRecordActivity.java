package com.huobi.account.ui;

import android.content.Intent;
import androidx.annotation.Keep;
import bh.u;
import com.google.gson.Gson;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.setting.bean.FlutterSettingVerifyToken;
import com.huobi.utils.k0;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import q6.d;
import tg.r;
import tq.p;
import u6.g;

public class SecurityRecordActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public boolean f41388k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f41389l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f41390m;

    /* renamed from: n  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f41391n;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            SecurityRecordActivity.this.cj(methodCall, result);
        }
    }

    public class b extends d<Object> {
        public b(g gVar) {
            super(gVar);
        }

        public void onAfter() {
            super.onAfter();
            SecurityRecordActivity.this.finish();
            r x11 = r.x();
            x11.m("old clearUserLoginInfo method t - [" + Thread.currentThread().getName() + "]", false);
            u.e();
            rn.c.i().d(SecurityRecordActivity.this, new JumpTarget((Intent) null, k0.a(SecurityRecordActivity.this)));
        }
    }

    public class c extends SecurityStrategyController {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41394g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f41395h;

        public c(String str, MethodChannel.Result result) {
            this.f41394g = str;
            this.f41395h = result;
        }

        public boolean C() {
            return SecurityRecordActivity.this.f41388k;
        }

        public final String Y() {
            return this.f41394g;
        }

        public void i(String str, String str2, String str3, String str4) {
            SecurityRecordActivity.this.f41391n.dismiss();
            SecurityRecordActivity.this.ej(str, str2, str3, Y(), this.f41395h);
        }

        public String n() {
            return r.x().M().e();
        }

        public String o() {
            return r.x().M().h();
        }

        public Map<String, Object> p() {
            return MapParamsBuilder.c().a("use_type", Y()).b();
        }

        public Map<String, Object> s() {
            return MapParamsBuilder.c().a("use_type", Y()).a("voice", Boolean.FALSE).b();
        }

        public boolean x() {
            return SecurityRecordActivity.this.f41390m;
        }

        public boolean y() {
            return SecurityRecordActivity.this.f41389l;
        }

        public boolean z() {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Si(HBDialogFragment hBDialogFragment) {
        rn.c.i().t().compose(RxJavaHelper.t(this)).subscribe(new b(this));
    }

    public static /* synthetic */ void Ti() {
    }

    public static /* synthetic */ void Ui(MethodChannel.Result result, String str) {
        FlutterSettingVerifyToken flutterSettingVerifyToken = new FlutterSettingVerifyToken();
        flutterSettingVerifyToken.setToken(str);
        result.success(new Gson().toJson((Object) flutterSettingVerifyToken));
    }

    public static /* synthetic */ void Vi(MethodChannel.Result result, APIStatusErrorException aPIStatusErrorException) {
        result.error("token_remote_error", aPIStatusErrorException.getErrMsg(), aPIStatusErrorException.getMessage());
        i6.d.j("token", aPIStatusErrorException.getErrMsg());
    }

    public static /* synthetic */ void Wi(MethodChannel.Result result, Throwable th2) {
        result.error("token_error", th2.getMessage(), th2.getMessage());
        th2.printStackTrace();
    }

    public static /* synthetic */ void Xi() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(MethodChannel.Result result, SecurityStrategySet securityStrategySet) {
        this.f41388k = securityStrategySet.getSetting().isVerify_phone();
        this.f41390m = securityStrategySet.getSetting().isVerify_email();
        this.f41389l = securityStrategySet.getSetting().isVerify_ga();
        dj(result, "LOGOUT");
    }

    public static /* synthetic */ void Zi(MethodChannel.Result result, APIStatusErrorException aPIStatusErrorException) {
        i6.d.j("verify_remote_error", aPIStatusErrorException.getErrMsg());
        result.error("verify_remote_error", aPIStatusErrorException.getErrCode(), aPIStatusErrorException.getMessage());
    }

    public static /* synthetic */ void aj(MethodChannel.Result result, Throwable th2) {
        result.error("verify_error", th2.getMessage(), th2.getMessage());
        th2.printStackTrace();
    }

    public String Nh() {
        return "security_record_page";
    }

    public final void bj(MethodChannel.Result result) {
        DialogUtils.c0(this, getString(R.string.setting_sign_out_msg), "", getString(R.string.security_google_cancel), getString(R.string.setting_sign_out_confirm), z2.f41868a, new y2(this));
        result.success("");
    }

    public void cj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("security_start_verify".equals(str)) {
                fj(methodCall, result);
            } else if ("security_logout".equals(str)) {
                bj(result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "security_channel").setMethodCallHandler(new a());
    }

    public void dj(MethodChannel.Result result, String str) {
        this.f41391n.Ci(new c(str, result));
        this.f41391n.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public void ej(String str, String str2, String str3, String str4, MethodChannel.Result result) {
        MethodChannel.Result result2 = result;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("useType:=");
        String str5 = str4;
        sb2.append(str4);
        i6.d.j("logout", sb2.toString());
        UserCenterRemoteDataSource.G(str, str2, str3, (String) null, (Map<String, Object>) null, str4, d.b(this, b3.f41648b, new f3(result2), new d3(result2), new g3(result2), a3.f41639b), this);
    }

    public void fj(MethodCall methodCall, MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t(this)).subscribe(d.d(this, new c3(this, result), new e3(result), new h3(result)));
    }

    public void onResume() {
        super.onResume();
        if (this.f41391n == null) {
            this.f41391n = new SecurityStrategyBottomMenuFragment();
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        Intent h11 = k0.h(this);
        rn.c.i().m(this, new JumpTarget(h11, h11));
        finish();
    }
}
