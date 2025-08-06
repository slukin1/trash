package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.utils.StatusBarUtils;
import cp.c;
import dp.t;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import up.g;

public class P2PPayMethodRootFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public com.huobi.otc.helper.a f78619k;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f78620l;

    /* renamed from: m  reason: collision with root package name */
    public t f78621m;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f78622a;

        public a(MethodCall methodCall) {
            this.f78622a = methodCall;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("userPayMethodId", this.f78622a.argument("userPayMethodId"));
            hashMap.put("action", this.f78622a.argument("action"));
            hashMap.put("securityToken", str);
            P2PPayMethodRootFlutterActivity.this.f78620l.invokeMethod("payMethodCode", hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = P2PPayMethodRootFlutterActivity.this.f78621m = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("userPayMethodId", this.f78622a.argument("userPayMethodId"));
            hashMap.put("action", this.f78622a.argument("action"));
            hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, str);
            P2PPayMethodRootFlutterActivity.this.f78620l.invokeMethod("payMethodCode", hashMap);
            if (P2PPayMethodRootFlutterActivity.this.f78621m != null && P2PPayMethodRootFlutterActivity.this.f78621m.isShowing()) {
                P2PPayMethodRootFlutterActivity.this.f78621m.dismiss();
            }
        }
    }

    public class b implements jp.c {

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f78625a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f78625a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                P2PPayMethodRootFlutterActivity.this.f78619k.s().c(authResult.getToken());
                this.f78625a.v();
            }
        }

        /* renamed from: com.huobi.otc.flutter.P2PPayMethodRootFlutterActivity$b$b  reason: collision with other inner class name */
        public class C0839b implements jp.c {
            public C0839b() {
            }

            public void call() {
                P2PPayMethodRootFlutterActivity.this.f78619k.I();
            }
        }

        public b() {
        }

        public void call() {
            P2PPayMethodRootFlutterActivity p2PPayMethodRootFlutterActivity = P2PPayMethodRootFlutterActivity.this;
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(p2PPayMethodRootFlutterActivity, p2PPayMethodRootFlutterActivity, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new C0839b());
        }
    }

    public static void Ji(Activity activity, int i11, String str, int i12) {
        Intent intent = new Intent(activity, P2PPayMethodRootFlutterActivity.class);
        intent.putExtra("pay_method_router", "otc_add_payment");
        intent.putExtra("payMethodId_extra", i11);
        intent.putExtra("payMethodName_extra", str);
        Ki(activity, intent, i12);
    }

    public static void Ki(Activity activity, Intent intent, int i11) {
        if (i11 == 0) {
            activity.startActivity(intent);
        } else {
            activity.startActivityForResult(intent, i11);
        }
    }

    public static void Li(Activity activity, int i11) {
        Intent intent = new Intent(activity, P2PPayMethodRootFlutterActivity.class);
        intent.putExtra("pay_method_router", "otc_payment_list_page");
        Ki(activity, intent, i11);
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1836262593:
                    if (str.equals("showFundPasswordAlert")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1482873135:
                    if (str.equals("queryEditPayMethodInitData")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1235098814:
                    if (str.equals("getSelectedCurrency")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -67491957:
                    if (str.equals("hideFiatHelpReminder")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            if (c11 == 0) {
                result.success(g.c("otc_select_trade_currency_quote_asset").toUpperCase());
            } else if (c11 == 1) {
                Mi(methodCall, result);
                result.success((Object) null);
            } else if (c11 != 2) {
                if (c11 != 3) {
                    result.notImplemented();
                } else {
                    result.success("");
                }
            } else if (getIntent() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("payMethodId", Integer.valueOf(getIntent().getIntExtra("payMethodId_extra", 0)));
                hashMap.put("payMethodName", getIntent().getStringExtra("payMethodName_extra"));
                result.success(hashMap);
            } else {
                result.success((Object) null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            result.notImplemented();
        }
    }

    public void Mi(MethodCall methodCall, MethodChannel.Result result) {
        if (this.f78619k == null) {
            this.f78619k = new com.huobi.otc.helper.a(this, this);
        }
        this.f78619k.J(new a(methodCall));
        this.f78619k.M(new b());
    }

    public String Nh() {
        String stringExtra = getIntent().getStringExtra("pay_method_router");
        return TextUtils.isEmpty(stringExtra) ? "otc_payment_list_page" : stringExtra;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_payment_list_channel");
        this.f78620l = methodChannel;
        methodChannel.setMethodCallHandler(new b1(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtils.e(this, 0);
    }
}
