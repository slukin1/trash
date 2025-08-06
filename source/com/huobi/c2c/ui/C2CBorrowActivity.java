package com.huobi.c2c.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.c2c.C2CCurrencyProvider;
import com.hbg.lib.network.hbg.c2c.C2CSymbolsProvider;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.hbg.lib.network.hbg.core.bean.C2CSymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.c2c.bean.FlutterC2CBorrowConfig;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.network.listener.HbHbgInterceptorListener;
import com.huobi.utils.k0;
import d7.a1;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import rx.Observable;
import sn.f;
import tg.r;
import u6.g;

public class C2CBorrowActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f42998k;

    /* renamed from: l  reason: collision with root package name */
    public C2CSymbolBean f42999l;

    public class a extends EasySubscriber<Pair<List<C2CCurrencyBean>, List<C2CSymbolBean>>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f43000b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43001c;

        public a(Activity activity, String str) {
            this.f43000b = activity;
            this.f43001c = str;
        }

        /* renamed from: a */
        public void onNext(Pair<List<C2CCurrencyBean>, List<C2CSymbolBean>> pair) {
            super.onNext(pair);
            C2CBorrowActivity.Ji(this.f43000b, this.f43001c);
        }

        public void onError2(Throwable th2) {
            if (C2CCurrencyProvider.i() || C2CSymbolsProvider.e()) {
                super.onError2(th2);
            } else {
                C2CBorrowActivity.Ji(this.f43000b, this.f43001c);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public class b implements MethodChannel.MethodCallHandler {
        public b() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            C2CBorrowActivity.this.Hi(methodCall, result);
        }
    }

    public static /* synthetic */ Pair Gi(List list, List list2) {
        return new Pair(list, list2);
    }

    public static void Ii(Activity activity, String str) {
        if (activity != null) {
            if (r.x().F0()) {
                Observable.zip(C2CCurrencyProvider.e(true).compose(RxJavaHelper.t((g) null)), C2CSymbolsProvider.c(true).compose(RxJavaHelper.t((g) null)), si.a.f66619b).compose(RxJavaHelper.t((g) null)).subscribe(new a(activity, str));
            } else {
                f.f(TradeType.C2C, activity);
            }
        }
    }

    public static void Ji(Activity activity, String str) {
        if (C2CSymbolsProvider.g(str) != null) {
            Intent intent = new Intent(activity, C2CBorrowActivity.class);
            intent.putExtra("extra_symbol", str);
            activity.startActivity(intent);
        }
    }

    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FlutterC2CBorrowConfig flutterC2CBorrowConfig = new FlutterC2CBorrowConfig();
            flutterC2CBorrowConfig.setC2cSocketUrl(HbHbgInterceptorListener.a());
            C2CCurrencyBean m11 = C2CCurrencyProvider.m(this.f42999l.getBaseCurrency());
            C2CCurrencyBean m12 = C2CCurrencyProvider.m(this.f42999l.getQuoteCurrency());
            if (m11 != null) {
                flutterC2CBorrowConfig.setBaseCurrencyTerms(m11.getTermDayConfigs());
            }
            if (m12 != null) {
                flutterC2CBorrowConfig.setQuoteCurrencyTerms(m12.getTermDayConfigs());
            }
            flutterC2CBorrowConfig.setBaseCurrency(this.f42999l.getBaseCurrency());
            flutterC2CBorrowConfig.setBaseCurrencyDisplayName(a1.v().p(this.f42999l.getSymbol()));
            flutterC2CBorrowConfig.setQuoteCurrency(this.f42999l.getQuoteCurrency());
            flutterC2CBorrowConfig.setQuoteCurrencyDisplayName(a1.v().F(this.f42999l.getSymbol()));
            flutterC2CBorrowConfig.setLoanEnabled(this.f42999l.getEnable());
            flutterC2CBorrowConfig.setBaseCurrencyBorrowMinAmount(this.f42999l.getBaseCurrencyBorrowMinAmount());
            flutterC2CBorrowConfig.setQuoteCurrencyBorrowMinAmount(this.f42999l.getQuoteCurrencyBorrowMinAmount());
            String json = new Gson().toJson((Object) flutterC2CBorrowConfig);
            d.b("C2CBorrowActivity-->initLendin-->" + json);
            result.success(json);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initLendin", e11.getMessage(), e11.getMessage());
        }
    }

    public void Hi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initLendin".equals(str)) {
                Fi(methodCall, result);
            } else if ("toTransfer".equals(str)) {
                UnifyTransferActivity.Uh(this, (String) null, "8", false, this.f42998k, false);
                result.success((Object) null);
            } else if ("toLendOut".equals(str)) {
                k0.K(this, "");
                result.success((Object) null);
            } else if ("toC2CFinancialRecords".equals(str)) {
                Ki();
                result.success((Object) null);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Ki() {
        C2CMarginFinancialActivity.Ii(this, this.f42999l.getBaseCurrency(), this.f42999l.getQuoteCurrency(), 67108864);
    }

    public String Nh() {
        return "c2c_lendin";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "lendin_channel").setMethodCallHandler(new b());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("extra_symbol");
        this.f42998k = stringExtra;
        this.f42999l = C2CSymbolsProvider.g(stringExtra);
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
        finish();
    }
}
