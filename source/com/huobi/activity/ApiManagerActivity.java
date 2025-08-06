package com.huobi.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.ui.SecurityStrategyBottomMenuFragment;
import com.huobi.account.ui.SecurityStrategyController;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.setting.bean.FlutterSettingConfig;
import com.huobi.setting.bean.FlutterSettingVerifyToken;
import com.huobi.utils.UserInfoUtil;
import com.huobi.utils.k0;
import i6.d;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import tg.r;
import tq.p;
import xg.c;
import xg.e;
import xg.f;
import xg.g;
import xg.h;
import xg.i;

public class ApiManagerActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public SecurityStrategyBottomMenuFragment f42024k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f42025l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f42026m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f42027n;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            ApiManagerActivity.this.aj(methodCall, result);
        }
    }

    public class b extends SecurityStrategyController {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f42029g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f42030h;

        public b(String str, MethodChannel.Result result) {
            this.f42029g = str;
            this.f42030h = result;
        }

        public boolean C() {
            return ApiManagerActivity.this.f42025l;
        }

        public final String Y() {
            return this.f42029g;
        }

        public void i(String str, String str2, String str3, String str4) {
            ApiManagerActivity.this.f42024k.dismiss();
            ApiManagerActivity.this.cj(str, str2, str3, Y(), this.f42030h);
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
            return ApiManagerActivity.this.f42027n;
        }

        public boolean y() {
            return ApiManagerActivity.this.f42026m;
        }

        public boolean z() {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ri(FlutterSettingConfig flutterSettingConfig, MethodChannel.Result result, String str, Boolean bool, List list, Integer num) {
        if ("--".equals(str)) {
            flutterSettingConfig.setUserName("--");
        } else {
            flutterSettingConfig.setUserName(str);
        }
        flutterSettingConfig.setSubAccountType(r.x().X());
        flutterSettingConfig.setUid(r.x().J());
        flutterSettingConfig.setFingerprint(PhoneUtils.s(true));
        flutterSettingConfig.setvToken(ku.b.e().h(this));
        result.success(new Gson().toJson((Object) flutterSettingConfig));
    }

    public static /* synthetic */ void Si() {
    }

    public static /* synthetic */ void Ti(MethodChannel.Result result, String str) {
        FlutterSettingVerifyToken flutterSettingVerifyToken = new FlutterSettingVerifyToken();
        flutterSettingVerifyToken.setToken(str);
        result.success(new Gson().toJson((Object) flutterSettingVerifyToken));
    }

    public static /* synthetic */ void Ui(MethodChannel.Result result, APIStatusErrorException aPIStatusErrorException) {
        result.error("token_remote_error", aPIStatusErrorException.getErrMsg(), aPIStatusErrorException.getMessage());
        d.j("token", aPIStatusErrorException.getErrMsg());
    }

    public static /* synthetic */ void Vi(MethodChannel.Result result, Throwable th2) {
        result.error("token_error", th2.getMessage(), th2.getMessage());
        th2.printStackTrace();
    }

    public static /* synthetic */ void Wi() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xi(MethodChannel.Result result, String str, SecurityStrategySet securityStrategySet) {
        this.f42025l = securityStrategySet.getSetting().isVerify_phone();
        this.f42027n = securityStrategySet.getSetting().isVerify_email();
        this.f42026m = securityStrategySet.getSetting().isVerify_ga();
        bj(result, str);
    }

    public static /* synthetic */ void Yi(MethodChannel.Result result, APIStatusErrorException aPIStatusErrorException) {
        d.j("verify_remote_error", aPIStatusErrorException.getErrMsg());
        result.error("verify_remote_error", aPIStatusErrorException.getErrCode(), aPIStatusErrorException.getMessage());
    }

    public static /* synthetic */ void Zi(MethodChannel.Result result, Throwable th2) {
        result.error("verify_error", th2.getMessage(), th2.getMessage());
        th2.printStackTrace();
    }

    public String Nh() {
        return "index_app_config_api_manager";
    }

    public final void Qi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FlutterSettingConfig flutterSettingConfig = new FlutterSettingConfig();
            if (r.x().F0()) {
                UserInfoUtil.h(this, new xg.a(this, flutterSettingConfig, result));
            } else {
                result.error("settingConfig", "Not Login", "Not Login");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("settingConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public void aj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("init_user_info".equals(str)) {
                Qi(methodCall, result);
            } else if ("start_verify".equals(str)) {
                dj(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void bj(MethodChannel.Result result, String str) {
        this.f42024k.Ci(new b(str, result));
        this.f42024k.show(getSupportFragmentManager(), "BottomMenuFragment");
    }

    public void cj(String str, String str2, String str3, String str4, MethodChannel.Result result) {
        MethodChannel.Result result2 = result;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("useType:=");
        String str5 = str4;
        sb2.append(str4);
        d.j("startAddAddressAction", sb2.toString());
        UserCenterRemoteDataSource.G(str, str2, str3, (String) null, (Map<String, Object>) null, str4, q6.d.b(this, xg.b.f61545b, new g(result2), new e(result2), new h(result2), c.f61547b), this);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "setting_channel").setMethodCallHandler(new a());
    }

    public void dj(MethodCall methodCall, MethodChannel.Result result) {
        UserCenterRemoteDataSource.A().F().compose(p.c0()).compose(RxJavaHelper.t(this)).subscribe(q6.d.d(this, new xg.d(this, result, methodCall.hasArgument("use_type") ? (String) methodCall.argument("use_type") : "VERIFY_SETTING_POLICY"), new f(result), new i(result)));
    }

    public void onResume() {
        super.onResume();
        if (this.f42024k == null) {
            this.f42024k = new SecurityStrategyBottomMenuFragment();
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

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        Intent h11 = k0.h(this);
        rn.c.i().m(this, new JumpTarget(h11, h11));
    }

    public SplashScreen provideSplashScreen() {
        return new DrawableSplashScreen(new ColorDrawable(getResources().getColor(R.color.baseColorContentBackground)), ImageView.ScaleType.FIT_XY, 200);
    }
}
