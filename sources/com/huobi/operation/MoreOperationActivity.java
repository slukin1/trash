package com.huobi.operation;

import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.utils.GsonHelper;
import gs.g;
import i6.k;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import to.a;
import yl.o;

@Route(path = "/home/operation/more")
public class MoreOperationActivity extends AbsGlobalFlutterActivity {
    /* renamed from: Fi */
    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        IndexFeatureItem indexFeatureItem;
        Map map;
        try {
            if ("openFunctionModel".equals(methodCall.method)) {
                if (!methodCall.hasArgument("params") || (map = (Map) methodCall.argument("params")) == null || map.isEmpty()) {
                    str = null;
                    indexFeatureItem = null;
                } else {
                    Gson a11 = GsonHelper.a();
                    str = a11.toJson((Object) map);
                    indexFeatureItem = !TextUtils.isEmpty(str) ? (IndexFeatureItem) a11.fromJson(str, IndexFeatureItem.class) : null;
                }
                if (indexFeatureItem != null) {
                    o.p(this, indexFeatureItem);
                } else {
                    k.f("home_operation_more_click", "data:" + str);
                }
            }
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "home_function_extension";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "home_function_extension_channel").setMethodCallHandler(new a(this));
    }

    public void onResume() {
        super.onResume();
        g.i("more_server_view", (HashMap) null);
    }
}
