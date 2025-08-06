package com.huobi.search.ui;

import android.content.Intent;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.module.content.ui.activity.NewsDetailActivity;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import er.a;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class NewsSearchActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f80781k;

    /* renamed from: Fi */
    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        Intent intent;
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == 1486260220) {
                if (str.equals("toCMSContentDetail")) {
                    c11 = 0;
                }
            }
            if (c11 == 0) {
                try {
                    Object argument = methodCall.argument("type");
                    int intValue = argument instanceof Integer ? ((Integer) argument).intValue() : 2;
                    Object argument2 = methodCall.argument("contentId");
                    if (argument2 instanceof String) {
                        if (intValue == 2) {
                            intent = new Intent(this, NewsDetailActivity.class);
                            intent.putExtra("newflashId", (String) argument2);
                        } else {
                            intent = new Intent(this, HBBaseWebActivity.class);
                            BaseModuleConfig.a a11 = BaseModuleConfig.a();
                            intent.putExtra("url", a11.k("pretender/news-detail-long?id=" + ((String) argument2)));
                        }
                        startActivity(intent);
                    }
                } catch (ClassCastException | NumberFormatException e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            e12.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "cms_search";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "cms_search_channel");
        this.f80781k = methodChannel;
        methodChannel.setMethodCallHandler(new a(this));
    }
}
