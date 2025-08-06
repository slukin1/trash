package com.huobi.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.facebook.places.model.PlaceFields;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.zopim.android.sdk.api.ZopimChat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import sn.f;

@Route(path = "/account/help")
public class HelpCenterActivity extends AbsGlobalFlutterActivity {
    public String Nh() {
        return "help_center";
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("openZopimChat".equals(str)) {
                f.y(this, (ZopimChat.SessionConfig) null);
                ZopimChat.trackEvent("Started chat with mandatory pre-chat form");
            } else if ("callPhone".equals(str)) {
                String str2 = (String) methodCall.argument(PlaceFields.PHONE);
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str2));
                    intent.setFlags(268435456);
                    startActivity(intent);
                }
            } else {
                super.onMethodCall(methodCall, result);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }
}
