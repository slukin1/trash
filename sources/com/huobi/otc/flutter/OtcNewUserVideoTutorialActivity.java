package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import oa.a;
import org.json.JSONObject;
import qu.d;

public class OtcNewUserVideoTutorialActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78518k;

    /* renamed from: l  reason: collision with root package name */
    public String f78519l = "";

    public static void Ei(Context context, String str) {
        Intent intent = new Intent(context, OtcNewUserVideoTutorialActivity.class);
        intent.putExtra("guideType", str);
        context.startActivity(intent);
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        Class<OtcTradeActivity> cls = OtcTradeActivity.class;
        try {
            String str = methodCall.method;
            char c11 = 65535;
            int hashCode = str.hashCode();
            int i11 = 0;
            if (hashCode != -1949106608) {
                if (hashCode == -1418705092) {
                    if (str.equals("toBuyCoin")) {
                        c11 = 1;
                    }
                }
            } else if (str.equals("getInitData")) {
                c11 = 0;
            }
            if (c11 == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("auto_open_guide", 0);
                if (d.i().n()) {
                    i11 = 1;
                }
                hashMap.put("new_user", Integer.valueOf(i11));
                hashMap.put("type", this.f78519l);
                result.success(new JSONObject(hashMap).toString());
            } else if (c11 == 1) {
                finish();
                if (a.g().f(cls) != null) {
                    a.g().f(cls).finish();
                }
                String str2 = (String) methodCall.arguments;
                if ("express".equals(str2)) {
                    zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/index?tradeArea=express&isOutArea=true&isFromGuide=true")).a().c();
                } else if ("p2p".equals(str2)) {
                    zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/index?tradeArea=p2p&isOutArea=true&isFromGuide=true")).a().c();
                } else if ("deposit".equals(str2)) {
                    zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/index?tradeArea=deposit&isOutArea=true&isFromGuide=true")).a().c();
                }
                result.success((Object) null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "new_user_video_tutorial";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "new_user_guide_channel");
        this.f78518k = methodChannel;
        methodChannel.setMethodCallHandler(new b0(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f78519l = getIntent().getStringExtra("guideType");
    }
}
