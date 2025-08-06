package com.huobi.otc.flutter;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.OtcTradeActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class OtcTutorialFlutterFragment extends AbsGlobalFlutterFragment {

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78607i;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            OtcTutorialFlutterFragment.this.Th(methodCall, result);
        }
    }

    public String Bh() {
        return "otc_trade_tutorial";
    }

    public void Th(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("dismissTutorialFragment".equals(str)) {
                FragmentActivity activity = getActivity();
                if (activity instanceof OtcTradeActivity) {
                    ((OtcTradeActivity) activity).Eh(true);
                }
            } else if ("toHelpCenter".equals(str)) {
                FragmentActivity activity2 = getActivity();
                if (activity2 instanceof OtcTradeActivity) {
                    ((OtcTradeActivity) activity2).Og();
                }
            } else if ("getCurrentTabIndex".equals(str)) {
                FragmentActivity activity3 = getActivity();
                if (activity3 instanceof OtcTradeActivity) {
                    OtcTradeAreaEnum Ed = ((OtcTradeActivity) activity3).Ed();
                    if (Ed == OtcTradeAreaEnum.FAST_AREA) {
                        result.success(1);
                    } else if (Ed == OtcTradeAreaEnum.DEPOSIT_AREA) {
                        result.success(2);
                    } else if (Ed == OtcTradeAreaEnum.FREE_AREA) {
                        result.success(3);
                    }
                }
            } else if ("toTutorialVideoPage".equals(str)) {
                OtcModuleConfig.b().O(getActivity(), (String) methodCall.argument("url"));
            } else if ("toBuyCoin".equals(str)) {
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
            result.notImplemented();
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_tutorial_hannel");
        this.f78607i = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}
