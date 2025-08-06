package com.huobi.notice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.tencent.qcloud.tuicore.TUIConstants;
import i6.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class NoticeActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f78102k;

    public static void start(Context context, String str) {
        d.b("NoticeActivity-->start-->articles:" + str);
        if (context != null) {
            Intent intent = new Intent(context, NoticeActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (str != null) {
                intent.putExtra("PARAM_ARTICLES", str);
            }
            context.startActivity(intent);
        }
    }

    public String Nh() {
        return TUIConstants.TUIChat.NOTICE;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f78102k = getIntent().getStringExtra("PARAM_ARTICLES");
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if ("noticeData".equals(methodCall.method)) {
                String str = "{\"articles\":" + this.f78102k + "}";
                d.b("NoticeActivity-->onMethodCall-->noticeData:" + str);
                result.success(str);
                return;
            }
            super.onMethodCall(methodCall, result);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }
}
