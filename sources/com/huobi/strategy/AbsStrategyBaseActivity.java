package com.huobi.strategy;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.share.fragment.StrategyShareFragment;
import com.huobi.strategy.bean.StrategyOrderConfig;
import com.huobi.utils.k0;
import d7.y;
import i6.d;
import i6.k;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;

public abstract class AbsStrategyBaseActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public StrategyShareFragment f81299k;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            d.j("flutter", "onPlatformMessageChannelMethodCall method - " + methodCall.method);
            d.j("flutter", "onPlatformMessageChannelMethodCall arguments - " + methodCall.arguments);
            AbsStrategyBaseActivity.this.Hi(methodCall, result);
        }
    }

    public final void Di(MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        try {
            boolean hasArgument = methodCall2.hasArgument("symbol");
            boolean hasArgument2 = methodCall2.hasArgument("profitRate");
            boolean hasArgument3 = methodCall2.hasArgument("lowPrice");
            boolean hasArgument4 = methodCall2.hasArgument("highPrice");
            boolean hasArgument5 = methodCall2.hasArgument("apy");
            boolean hasArgument6 = methodCall2.hasArgument("tradeTimes");
            if (!hasArgument || !hasArgument2 || !hasArgument3 || !hasArgument4 || !hasArgument5 || !hasArgument6) {
                result2.error("callNativeShare", methodCall2.method + "argument error", (Object) null);
                return;
            }
            String str = (String) methodCall2.argument("symbol");
            String str2 = (String) methodCall2.argument("profitRate");
            String str3 = (String) methodCall2.argument("lowPrice");
            String str4 = (String) methodCall2.argument("highPrice");
            String str5 = (String) methodCall2.argument("apy");
            String str6 = (String) methodCall2.argument("runTime");
            int intValue = ((Integer) methodCall2.argument("tradeTimes")).intValue();
            StrategyShareFragment strategyShareFragment = this.f81299k;
            if (strategyShareFragment == null) {
                this.f81299k = new StrategyShareFragment();
            } else if (strategyShareFragment.isVisible()) {
                this.f81299k.dismiss();
            }
            this.f81299k.gi(str, str2, str3, str4, str5, String.valueOf(intValue), str6);
            this.f81299k.show(getSupportFragmentManager(), "strategy_share");
        } catch (Exception e11) {
            e11.printStackTrace();
            result2.error("callNativeShare", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("orderId")) {
                StrategyDetailActivity.start(this, (String) methodCall.argument("orderId"));
                result.success((Object) null);
                return;
            }
            result.error("-1", methodCall.method + "argument error", (Object) null);
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public void Fi(MethodCall methodCall, MethodChannel.Result result) {
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            StrategyOrderConfig strategyOrderConfig = new StrategyOrderConfig();
            for (String next : y.g()) {
                String z11 = d7.k.C().z(next);
                if (!TextUtils.isEmpty(z11)) {
                    strategyOrderConfig.getBaseCurrencyList().add(next);
                    strategyOrderConfig.getDisplayBaseCurrencyList().add(z11);
                }
            }
            for (String next2 : y.j()) {
                String z12 = d7.k.C().z(next2);
                if (!TextUtils.isEmpty(z12)) {
                    strategyOrderConfig.getQuoteCurrencyList().add(next2);
                    strategyOrderConfig.getDisplayQuoteCurrencyList().add(z12);
                }
            }
            String json = new Gson().toJson((Object) strategyOrderConfig);
            d.d("flutter -> " + json);
            result.success(json);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initStrategyOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public void Hi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initStrategyDetail".equals(str)) {
                Fi(methodCall, result);
            } else if ("initStrategyOrder".equals(str)) {
                Gi(methodCall, result);
            } else if ("callNativeShare".equals(str)) {
                Di(methodCall, result);
            } else if ("goToStrategyDetail".equals(str)) {
                Ei(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "strategy_channel").setMethodCallHandler(new a());
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
    public void onTokenError(mo.a aVar) {
        Intent h11 = k0.h(this);
        c.i().m(this, new JumpTarget(h11, h11));
    }

    public SplashScreen provideSplashScreen() {
        return new DrawableSplashScreen(new ColorDrawable(getResources().getColor(R.color.baseColorContentBackground)), ImageView.ScaleType.FIT_XY, 200);
    }
}
