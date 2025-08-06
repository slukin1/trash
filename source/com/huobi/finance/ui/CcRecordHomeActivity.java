package com.huobi.finance.ui;

import androidx.annotation.Keep;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.order.ui.TradeOrderActivity;
import com.huobi.utils.k0;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;

public class CcRecordHomeActivity extends AbsGlobalFlutterActivity {
    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("gotoCcOrderRecordPage".equals(str)) {
                TradeOrderActivity.Fi(this, TradeType.PRO, (String) null);
            } else if ("gotoCcRecordPage".equals(str)) {
                DwRecordActivity.Ji(this, ((Integer) methodCall.argument("pageType")).intValue());
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "cc_record_home";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "cc_record_home_channel").setMethodCallHandler(new e3(this));
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(a aVar) {
        c.i().m(this, new JumpTarget(k0.c(this), k0.h(this)));
    }
}
