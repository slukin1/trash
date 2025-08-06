package com.huobi.points.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.points.utils.PointsHelper;
import com.huobi.utils.k0;
import d7.a1;
import dt.h2;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigDecimal;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import tg.r;
import u6.g;

public abstract class AbsPointsNewActivity extends AbsGlobalFlutterActivity {

    public class a extends BaseSubscriber<Map<String, SymbolPrice>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80331b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80332c;

        public a(String str, MethodChannel.Result result) {
            this.f80331b = str;
            this.f80332c = result;
        }

        /* renamed from: a */
        public void onNext(Map<String, SymbolPrice> map) {
            BigDecimal bigDecimal;
            super.onNext(map);
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            if (!(map == null || map.isEmpty() || (bigDecimal = h2.t1().s1("usdt", map).get(this.f80331b)) == null)) {
                bigDecimal2 = bigDecimal;
            }
            this.f80332c.success(bigDecimal2.toPlainString());
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80332c.success("0");
        }
    }

    public class b extends BaseSubscriber<Map<String, String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80335c;

        public b(String str, MethodChannel.Result result) {
            this.f80334b = str;
            this.f80335c = result;
        }

        /* renamed from: a */
        public void onNext(Map<String, String> map) {
            super.onNext(map);
            String str = map.get(this.f80334b);
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.f80335c.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80335c.success("--");
        }
    }

    public final void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            h2.t1().y3(TradeType.PRO, false).compose(RxJavaHelper.t((g) null)).subscribe(new b((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), result));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getCurrencyAsset", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        try {
            LegalCurrencyConfigUtil.S(TradeType.PRO, false).compose(RxJavaHelper.t((g) null)).subscribe(new a((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), result));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getUsdtPrice", e11.getMessage(), e11.getMessage());
        }
    }

    public void Fi(MethodCall methodCall, MethodChannel.Result result) {
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            result.success(Boolean.valueOf(r.x().X()));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("isChildAccount", e11.getMessage(), e11.getMessage());
        }
    }

    public void Hi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("getUsdtPrice".equals(str)) {
                Ei(methodCall, result);
            } else if ("getCurrencyAsset".equals(str)) {
                Di(methodCall, result);
            } else if ("isChildAccount".equals(str)) {
                Gi(methodCall, result);
            } else if ("goToPointPage".equals(str)) {
                PointsHelper.a(this, (String) methodCall.argument("pageId"));
                result.success((Object) null);
            } else if ("toSpotExchangeCurrency".equals(str)) {
                Ii(methodCall, result);
            } else if ("initPointExchange".equals(str)) {
                Fi(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            k0.O(this, a1.v().K((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY)), true);
            finish();
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("isChildAccount", e11.getMessage(), e11.getMessage());
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "points_channel").setMethodCallHandler(new fq.a(this));
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
