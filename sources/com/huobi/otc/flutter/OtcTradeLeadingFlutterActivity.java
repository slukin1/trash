package com.huobi.otc.flutter;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class OtcTradeLeadingFlutterActivity extends AbsOtcTradeFlutterActivity {
    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        result.notImplemented();
    }

    public String Nh() {
        return "trade_leading_app";
    }
}
