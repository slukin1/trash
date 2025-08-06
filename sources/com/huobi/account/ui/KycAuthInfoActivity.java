package com.huobi.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.router.HbgRouter;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.kyc.ui.KycQuickAuthDialogActivity;
import com.huobi.kyc.ui.VerificationTipsDialog;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.ui.FingerprintLoginActivity;
import com.huobi.login.ui.SecurityVerificationActivity;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.login.utils.FingerprintHelper;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.otc.helper.OtcSecurityTokenFactory;
import com.huobi.utils.GestureUtil;
import com.huobi.utils.GsonHelper;
import com.huobi.utils.a0;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cp.d;
import i6.k;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import sn.f;
import tg.r;
import u6.g;

@Route(path = "/account/kyc")
public class KycAuthInfoActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public FlutterKycConfig f41208k;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f41209l;

    /* renamed from: m  reason: collision with root package name */
    public MethodChannel.Result f41210m;

    /* renamed from: n  reason: collision with root package name */
    public OtcSecurityTokenFactory f41211n;

    public class a extends BaseSubscriber<UserInfoData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f41212b;

        public a(MethodChannel.Result result) {
            this.f41212b = result;
        }

        /* renamed from: a */
        public void onNext(UserInfoData userInfoData) {
            this.f41212b.success((Object) null);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f41212b.error("flutterKycConfig", th2.getMessage(), th2.getMessage());
        }
    }

    public class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f41214a;

        public b(MethodChannel.Result result) {
            this.f41214a = result;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            this.f41214a.success(Boolean.TRUE);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Li(VerificationTipsDialog verificationTipsDialog, View view) {
        HBBaseWebActivity.showWebView(this, a0.n(), (String) null, (String) null, false);
        verificationTipsDialog.doDismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Fi(FlutterKycConfig flutterKycConfig) {
        if (flutterKycConfig != null) {
            this.f41208k = flutterKycConfig;
            String y11 = LegalCurrencyConfigUtil.y();
            if (TextUtils.isEmpty(y11)) {
                y11 = "usd";
            }
            this.f41208k.setCurCurrencyRate(LegalCurrencyConfigUtil.v());
            this.f41208k.setCnyCurrencyRate(LegalCurrencyConfigUtil.s("cny"));
            this.f41208k.setCurrencyUnit(y11.toUpperCase());
        }
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        FingerprintHelper fingerprintHelper = new FingerprintHelper();
        JumpTarget jumpTarget = new JumpTarget((Intent) null, (Intent) null);
        this.f41210m = result;
        if (!r.x().F0()) {
            c.i().m(this, jumpTarget);
        } else if (fingerprintHelper.d()) {
            k.n("goToFingerprint");
            Intent intent = new Intent(this, FingerprintLoginActivity.class);
            intent.putExtra("verifyOnly", true);
            startActivityForResult(intent, 333);
        } else if (GestureUtil.c()) {
            k.n("goToSecurityVer");
            Intent intent2 = new Intent(this, SecurityVerificationActivity.class);
            intent2.putExtra("verifyOnly", true);
            startActivityForResult(intent2, 333);
        } else {
            if (this.f41211n == null) {
                this.f41211n = new OtcSecurityTokenFactory(this, this, true);
            }
            this.f41211n.n(new b(result));
        }
    }

    public final void Hi() {
        k.o("flutterKycGetWorkOrderConfig", "call getWorkOrderConfig");
        o7.b.f(false).compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        k.o("flutterKycInit", "call initKyc");
        try {
            if (this.f41208k != null) {
                k.o("flutterKycInit", "call initKyc success:" + this.f41208k);
                result.success(GsonHelper.a().toJson((Object) this.f41208k));
                return;
            }
            k.o("flutterKycInit", "call initKyc failed mFlutterInitConfig:null");
        } catch (Exception e11) {
            k.f("flutterKycInit", "call initKyc exception:" + e11.getMessage());
            result.error("flutterKycConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
    }

    public final void Mi(MethodCall methodCall, MethodChannel.Result result) {
        k.o("flutterKycModifyCountry", "call modifyCountry");
        VerificationTipsDialog verificationTipsDialog = new VerificationTipsDialog();
        verificationTipsDialog.setContent(getString(R.string.n_kyc_modify_country_tip));
        verificationTipsDialog.vh(new VerificationTipsDialog.a[]{new VerificationTipsDialog.a(R.drawable.ic_verification_country_icon, getString(R.string.n_kyc_modify_country_title), getString(R.string.n_kyc_modify_country_content), new b0(this, verificationTipsDialog))});
        verificationTipsDialog.show(getSupportFragmentManager(), "KycAuthInfoActivity#modifyCountry");
        result.success((Object) null);
        k.o("flutterKycModifyCountry", "call modifyCountry success:" + a0.n());
    }

    public String Nh() {
        return "kyc";
    }

    /* renamed from: Ni */
    public final void Ki(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1990182841:
                    if (str.equals("openDMCRights")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case -1472247929:
                    if (str.equals("openKycQuickL1")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -1457606554:
                    if (str.equals("decryptVerify")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -397658377:
                    if (str.equals("unbindAccount")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -146430422:
                    if (str.equals("openKycService")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 138940796:
                    if (str.equals("modifyCountry")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 603368194:
                    if (str.equals("updateUserInfo")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1056375503:
                    if (str.equals("initKycData")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 1376166839:
                    if (str.equals("sumsubConfig")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1681286906:
                    if (str.equals("selectCountry")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1899594378:
                    if (str.equals("jumioConfig")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    Ii(methodCall, result);
                    return;
                case 1:
                    Mi(methodCall, result);
                    return;
                case 2:
                    Qi(methodCall, result);
                    return;
                case 3:
                    Si(methodCall, result);
                    return;
                case 4:
                    Ji(methodCall, result);
                    return;
                case 5:
                    Ri(methodCall, result);
                    return;
                case 6:
                    Ti(methodCall, result);
                    return;
                case 7:
                    Pi(methodCall, result);
                    return;
                case 8:
                    Gi(methodCall, result);
                    return;
                case 9:
                    Oi();
                    return;
                case 10:
                    HbgRouter.h(this, "/account/dominicaKyc");
                    result.success((Object) null);
                    return;
                default:
                    return;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Oi() {
        Intent intent = new Intent(this, KycQuickAuthDialogActivity.class);
        intent.putExtra("authType", "0");
        startActivityForResult(intent, 3);
        startActivity(intent);
    }

    public final void Pi(MethodCall methodCall, MethodChannel.Result result) {
        startActivity(f.r(this));
        result.success((Object) null);
    }

    public final void Qi(MethodCall methodCall, MethodChannel.Result result) {
        Intent intent = new Intent(this, CountryAreaSelectActivityV2.class);
        intent.putExtra("choose_type", "choose_type_name");
        startActivityForResult(intent, 1002);
        result.success((Object) null);
    }

    public final void Ri(MethodCall methodCall, MethodChannel.Result result) {
    }

    public final void Si(MethodCall methodCall, MethodChannel.Result result) {
        k.o("flutterKycUnbindAccount", "call unbindAccount");
        HBBaseWebActivity.showWebView(this, a0.o(), (String) null, (String) null, false);
        result.success((Object) null);
        k.o("flutterKycUnbindAccount", "call unbindAccount success:" + a0.o());
    }

    public final void Ti(MethodCall methodCall, MethodChannel.Result result) {
        if (r.x().F0()) {
            r.x().O(false).compose(RxJavaHelper.t((g) null)).subscribe(new a(result));
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "kyc_channel");
        this.f41209l = methodChannel;
        methodChannel.setMethodCallHandler(new c0(this));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 3 && intent.getBooleanExtra("changeToDmcPage", false)) {
            finish();
            HbgRouter.h(this, "/account/dominicaKyc");
        }
    }

    public void onCreate(Bundle bundle) {
        FlutterKycConfig flutterKycConfig;
        super.onCreate(bundle);
        Hi();
        Intent intent = getIntent();
        if (intent.hasExtra("flag_kyc_config")) {
            flutterKycConfig = (FlutterKycConfig) intent.getSerializableExtra("flag_kyc_config");
        } else if (intent.hasExtra("authBizCode")) {
            FlutterKycConfig flutterKycConfig2 = new FlutterKycConfig();
            flutterKycConfig2.setPhone(r.x().F());
            flutterKycConfig2.setEmail(r.x().u());
            flutterKycConfig2.setAuthBizCode(intent.getStringExtra("source"));
            flutterKycConfig2.setSource(intent.getStringExtra("source"));
            flutterKycConfig = flutterKycConfig2;
        } else {
            flutterKycConfig = null;
        }
        Fi(flutterKycConfig);
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
        c.i().m(this, new JumpTarget(h11, h11));
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
