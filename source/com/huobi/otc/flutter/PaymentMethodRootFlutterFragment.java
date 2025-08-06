package com.huobi.otc.flutter;

import android.text.TextUtils;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import up.g;

public class PaymentMethodRootFlutterFragment extends AbsGlobalFlutterFragment {

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78628i;

    public String Bh() {
        String string = getArguments().getString("pay_method_router");
        return TextUtils.isEmpty(string) ? "otc_payment_list_page" : string;
    }

    public final void Uh(MethodCall methodCall, MethodChannel.Result result) {
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
                if (getActivity() instanceof P2PPayMethodRootFlutterActivity) {
                    ((P2PPayMethodRootFlutterActivity) getActivity()).Mi(methodCall, result);
                }
                result.success((Object) null);
            } else if (c11 != 2) {
                if (c11 != 3) {
                    result.notImplemented();
                } else {
                    result.success("");
                }
            } else if (getArguments() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("payMethodId", Integer.valueOf(getArguments().getInt("payMethodId_extra", 0)));
                hashMap.put("payMethodName", Integer.valueOf(getArguments().getInt("payMethodName_extra", 0)));
                result.success(hashMap);
            } else {
                result.success((Object) null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            result.notImplemented();
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_payment_list_channel");
        this.f78628i = methodChannel;
        methodChannel.setMethodCallHandler(new c1(this));
    }
}
