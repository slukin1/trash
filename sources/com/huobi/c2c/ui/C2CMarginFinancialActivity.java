package com.huobi.c2c.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.C2CAccountInNetAssetResult;
import com.hbg.lib.network.hbg.core.bean.C2CAccountOutNetAssetInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import d7.k;
import dt.h2;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import pro.huobi.R;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;

public class C2CMarginFinancialActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f43008k;

    /* renamed from: l  reason: collision with root package name */
    public String f43009l;

    /* renamed from: m  reason: collision with root package name */
    public String f43010m;

    /* renamed from: n  reason: collision with root package name */
    public String f43011n;

    public class a extends TypeToken<HbgIntCodeResponse<List<C2CAccountInNetAssetResult>>> {
        public a() {
        }
    }

    public class b implements Func1<Map<String, SymbolPrice>, Observable<Map<String, BigDecimal>>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<Map<String, BigDecimal>> call(Map<String, SymbolPrice> map) {
            return Observable.just(h2.t1().s1("usdt", map));
        }
    }

    public class c extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f43014b;

        public c(MethodChannel.Result result) {
            this.f43014b = result;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            MethodChannel.Result result = this.f43014b;
            result.success(str + " " + StringUtils.i(LegalCurrencyConfigUtil.y()));
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f43014b.success("--");
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f43014b.success("--");
        }
    }

    public class d implements Func2<List<C2CAccountInNetAssetResult>, Map<String, BigDecimal>, String> {
        public d() {
        }

        /* renamed from: a */
        public String call(List<C2CAccountInNetAssetResult> list, Map<String, BigDecimal> map) {
            BigDecimal bigDecimal = BigDecimal.ZERO;
            for (C2CAccountInNetAssetResult next : list) {
                if ((C2CMarginFinancialActivity.this.f43008k + C2CMarginFinancialActivity.this.f43009l).equalsIgnoreCase(next.getSubtype())) {
                    for (C2CAccountOutNetAssetInfo next2 : next.getList()) {
                        if ("trade".equalsIgnoreCase(next2.getType()) || "loan".equalsIgnoreCase(next2.getType()) || "interest".equalsIgnoreCase(next2.getType()) || "frozen".equalsIgnoreCase(next2.getType())) {
                            BigDecimal a11 = m.a(next2.getBalance());
                            BigDecimal bigDecimal2 = map.get(next2.getCurrency());
                            if (bigDecimal2 != null) {
                                bigDecimal = bigDecimal.add(a11.multiply(bigDecimal2));
                            }
                        }
                    }
                }
            }
            return LegalCurrencyConfigUtil.B(m.u0(bigDecimal.toPlainString(), 12, 8));
        }
    }

    public static void Hi(Context context, String str, String str2) {
        Ii(context, str, str2, -1);
    }

    public static void Ii(Context context, String str, String str2, int i11) {
        Intent intent = new Intent(context, C2CMarginFinancialActivity.class);
        intent.putExtra("base_currency", str);
        intent.putExtra("quote_currency", str2);
        String z11 = k.C().z(str);
        String z12 = k.C().z(str2);
        if (TextUtils.isEmpty(z11) || TextUtils.isEmpty(z12)) {
            k.C().n(false, p.b(), "2").compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
            HuobiToastUtil.j(R.string.server_error);
            return;
        }
        if (i11 != -1) {
            intent.addFlags(i11);
        }
        context.startActivity(intent);
    }

    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
        HbgIntCodeResponse hbgIntCodeResponse = (HbgIntCodeResponse) new Gson().fromJson(new JSONObject((Map) methodCall.argument("responseDic")).toString(), new a().getType());
        if (hbgIntCodeResponse == null || !hbgIntCodeResponse.isSuccess()) {
            result.success("--");
            return;
        }
        Observable.zip(Observable.just((List) hbgIntCodeResponse.getData()), LegalCurrencyConfigUtil.f(true).compose(RxJavaHelper.s()).onErrorResumeNext(Observable.just(null)).flatMap(new b()), new d()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(result));
    }

    public void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = this.f43008k + this.f43009l;
            String str2 = methodCall.method;
            if ("initFinancial".equals(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("baseCurrency", this.f43008k);
                jSONObject.put("quoteCurrency", this.f43009l);
                jSONObject.put("baseCurrencyDisplayName", this.f43010m);
                jSONObject.put("quoteCurrencyDisplayName", this.f43011n);
                result.success(jSONObject.toString());
            } else if ("equivalent".equals(str2)) {
                Fi(methodCall, result);
            } else if ("openC2CMarginExchange".equals(str2)) {
                k0.J(this, str, true);
                result.success((Object) null);
            } else if ("openC2CMarginTransfer".equals(str2)) {
                UnifyTransferActivity.Uh(this, (String) null, "8", false, str, false);
                result.success((Object) null);
            } else if ("openC2CLendIn".equals(str2)) {
                C2CBorrowActivity.Ii(this, str);
                result.success((Object) null);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "c2c_margin_financial";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "c2c_margin_financial_channel").setMethodCallHandler(new si.b(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f43008k = getIntent().getStringExtra("base_currency");
        this.f43009l = getIntent().getStringExtra("quote_currency");
        this.f43010m = k.C().z(this.f43008k);
        this.f43011n = k.C().z(this.f43009l);
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
        rn.c.i().m(this, new JumpTarget(k0.c(this), k0.h(this)));
    }
}
