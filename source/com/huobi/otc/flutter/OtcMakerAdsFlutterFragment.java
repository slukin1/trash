package com.huobi.otc.flutter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.persenter.OtcTradePresenter;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import uf.b;

public class OtcMakerAdsFlutterFragment extends AbsGlobalFlutterFragment {

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78507i;

    public String Bh() {
        return "otc_my_adverts";
    }

    public void Th(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        String str3;
        if (methodCall.method.equals("showTabBar")) {
            FragmentActivity fragmentActivity = this.f67730h;
            if (fragmentActivity instanceof OtcTradePresenter.i) {
                ((OtcTradePresenter.i) fragmentActivity).y5(true);
            }
            result.success((Object) null);
            return;
        }
        int i11 = 0;
        if (methodCall.method.equals("hideTabBar")) {
            FragmentActivity fragmentActivity2 = this.f67730h;
            if (fragmentActivity2 instanceof OtcTradePresenter.i) {
                ((OtcTradePresenter.i) fragmentActivity2).y5(false);
            }
            result.success((Object) null);
        } else if (methodCall.method.equals("goPublish")) {
            if (!(methodCall.arguments instanceof Map)) {
                result.notImplemented();
                return;
            }
            String str4 = methodCall.hasArgument("advertId") ? (String) methodCall.argument("advertId") : "";
            if (methodCall.hasArgument("coinName")) {
                str = (String) methodCall.argument("coinName");
            } else {
                str = "";
            }
            if (methodCall.hasArgument("currencyName")) {
                str2 = (String) methodCall.argument("currencyName");
            } else {
                str2 = "";
            }
            int intValue = methodCall.hasArgument("tradeType") ? ((Integer) methodCall.argument("tradeType")).intValue() : 0;
            boolean booleanValue = methodCall.hasArgument("isPrivilegeOn") ? ((Boolean) methodCall.argument("isPrivilegeOn")).booleanValue() : false;
            if (methodCall.hasArgument("quickEdit")) {
                i11 = ((Boolean) methodCall.argument("quickEdit")).booleanValue();
            }
            if (str4 == null || str4.isEmpty() || i11 == 0) {
                b b11 = OtcModuleConfig.b();
                Context context = getContext();
                if (str4 == null) {
                    str3 = "";
                } else {
                    str3 = str4;
                }
                b11.r(context, str3, intValue, booleanValue, str, str2);
            } else {
                ((OtcTradePresenter.i) this.f67730h).L3(str4);
            }
            result.success((Object) null);
        } else if (methodCall.method.equals("goDetail")) {
            if (!(methodCall.arguments instanceof Map)) {
                result.notImplemented();
            } else {
                OtcAdvertPublishDetailActivity.Pi(getContext(), (String) methodCall.argument("advertId"));
            }
        } else if (!methodCall.method.equals("goPrivilegeHome")) {
            result.notImplemented();
        } else if (!(methodCall.arguments instanceof Map)) {
            result.notImplemented();
        } else {
            if (methodCall.hasArgument("entranceType")) {
                i11 = ((Integer) methodCall.argument("entranceType")).intValue();
            }
            OtcAdvertPrivilegeHomeFlutterActivity.Gi(getContext(), i11);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_my_adverts_channel");
        this.f78507i = methodChannel;
        methodChannel.setMethodCallHandler(new x(this));
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    public void onFilterAdverts(OtcAdvertPrivilegeFilterEvent otcAdvertPrivilegeFilterEvent) {
        HashMap hashMap = new HashMap();
        hashMap.put("side", otcAdvertPrivilegeFilterEvent.side);
        hashMap.put("currencyName", otcAdvertPrivilegeFilterEvent.currencyName);
        hashMap.put("coinName", otcAdvertPrivilegeFilterEvent.coinName);
        this.f78507i.invokeMethod("privilegeFilter", hashMap);
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }
}
