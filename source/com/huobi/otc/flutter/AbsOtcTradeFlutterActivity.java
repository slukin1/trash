package com.huobi.otc.flutter;

import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public abstract class AbsOtcTradeFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78402k;

    public class a extends Security2FADialogHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Security2FADialogHelper f78403a;

        public a(Security2FADialogHelper security2FADialogHelper) {
            this.f78403a = security2FADialogHelper;
        }

        public void onFailed(String str) {
        }

        public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
            AbsOtcTradeFlutterActivity.this.f78402k.invokeMethod("ucTokenSuccess", authResult.getToken());
            this.f78403a.v();
        }
    }

    public abstract void Di(MethodCall methodCall, MethodChannel.Result result);

    public void Ei(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == -69163490) {
                if (str.equals("native_start_verify")) {
                    c11 = 0;
                }
            }
            if (c11 != 0) {
                Di(methodCall, result);
                return;
            }
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(this, this, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.R(new a(security2FADialogHelper));
            result.success("");
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "trade_setting_channel");
        this.f78402k = methodChannel;
        methodChannel.setMethodCallHandler(new a(this));
    }
}
