package com.huobi.savings.ui;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import dt.h2;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import u6.g;

public class SavingsDataActivity extends AbsGlobalFlutterActivity {

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            d.b("onMethodCall");
            SavingsDataActivity.this.Fi(methodCall, result);
        }
    }

    public class b extends BaseSubscriber<Map<String, String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80744b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80745c;

        public b(String str, MethodChannel.Result result) {
            this.f80744b = str;
            this.f80745c = result;
        }

        /* renamed from: a */
        public void onNext(Map<String, String> map) {
            super.onNext(map);
            String str = map.get(this.f80744b);
            if (str == null) {
                str = "0";
            }
            this.f80745c.success(str);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80745c.success((Object) null);
        }
    }

    public class c extends BaseSubscriber<List<LegalRateBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f80747b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80748c;

        public c(List list, MethodChannel.Result result) {
            this.f80747b = list;
            this.f80748c = result;
        }

        public void onAfter() {
            super.onAfter();
            ArrayList arrayList = new ArrayList();
            List<String> list = this.f80747b;
            if (list != null) {
                for (String str : list) {
                    if ("- -".equals(str) || TextUtils.isEmpty(str)) {
                        arrayList.add("- -");
                    } else {
                        arrayList.add(LegalCurrencyConfigUtil.G(str, "btc", TradeType.PRO));
                    }
                }
            }
            this.f80748c.success(arrayList);
        }
    }

    public void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            d.b(str + "====");
            if ("getAvailableData".equals(str)) {
                h2.t1().y3(TradeType.PRO, false).compose(RxJavaHelper.t((g) null)).subscribe(new b((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), result));
            } else if ("getSavingsBtcFiats".equals(str)) {
                LegalCurrencyConfigUtil.S(TradeType.PRO, false).flatMap(yq.a.f61976b).compose(RxJavaHelper.t((g) null)).subscribe(new c((List) methodCall.argument("assets"), result));
            } else if ("showOverseaVerifyAlert".equals(str)) {
                AbsGlobalFlutterActivity.zi(this);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "savings_list";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "savings_data_channel").setMethodCallHandler(new a());
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
        rn.c.i().m(this, new JumpTarget(h11, h11));
    }
}
