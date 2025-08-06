package com.huobi.search.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.search.presenter.SearchDataPresenter;
import er.b;
import i6.d;
import i6.k;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.concurrent.ConcurrentHashMap;
import pro.huobi.R;

public class SearchFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public SearchDataPresenter f80782k = new SearchDataPresenter();

    public static /* synthetic */ void Ei(MethodChannel.Result result, ConcurrentHashMap concurrentHashMap) {
        String json = new Gson().toJson((Object) concurrentHashMap);
        d.b("lyl >>>>>>>SearchResult " + json);
        result.success(json);
    }

    public static void Fi(Activity activity) {
        Gi(activity, (Bundle) null);
    }

    public static void Gi(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, SearchFlutterActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public String Nh() {
        return "global_search";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "global_search_channel").setMethodCallHandler(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f80782k.o();
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            k.o("onMethodCall", str);
            char c11 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -565242054) {
                if (hashCode == 244624088) {
                    if (str.equals("initSearch")) {
                        c11 = 1;
                    }
                }
            } else if (str.equals("searchCoins")) {
                c11 = 0;
            }
            if (c11 == 0) {
                String str2 = (String) methodCall.argument("keyword");
                if (!TextUtils.isEmpty(str2)) {
                    this.f80782k.u(str2, new b(result));
                }
            } else if (c11 != 1) {
                super.onMethodCall(methodCall, result);
            } else {
                String string = getIntent().getExtras().getString("hotWord");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                result.success(string);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void onPointerCaptureChanged(boolean z11) {
        super.onPointerCaptureChanged(z11);
    }
}
