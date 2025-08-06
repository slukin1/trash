package com.huobi.otcoption.ui;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.otcoption.bean.OtcOptionsDrawerInfoData;
import com.huobi.otcoption.bean.OtcOptionsIndexData;
import com.huobi.share.fragment.OtcOptionsShareFragment;
import com.huobi.view.DatePickerDialog;
import d7.a1;
import d7.g0;
import d7.k0;
import i6.k;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import u6.g;

public abstract class AbsOtcOptionsBaseActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public OtcOptionsShareFragment f80206k;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            i6.d.j("flutter", "onPlatformMessageChannelMethodCall method - " + methodCall.method);
            i6.d.j("flutter", "onPlatformMessageChannelMethodCall arguments - " + methodCall.arguments);
            AbsOtcOptionsBaseActivity.this.Mi(methodCall, result);
        }
    }

    public class b extends BaseSubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80208b;

        public b(MethodChannel.Result result) {
            this.f80208b = result;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80208b.error("getOtcOptionsSymbols", th2.getMessage(), th2.getMessage());
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            OtcOptionsDrawerInfoData otcOptionsDrawerInfoData = new OtcOptionsDrawerInfoData();
            for (String next : list) {
                OtcOptionsIndexData otcOptionsIndexData = new OtcOptionsIndexData();
                otcOptionsIndexData.setSymbol(next);
                otcOptionsIndexData.setBaseCurrency(a1.v().n(next));
                otcOptionsIndexData.setQuoteCurrency(a1.v().D(next));
                otcOptionsIndexData.setBaseCurrencyDisplayName(a1.v().p(next));
                otcOptionsIndexData.setQuoteCurrencyDisplayName(a1.v().F(next));
                otcOptionsIndexData.setSymbolName(a1.v().W(next));
                otcOptionsDrawerInfoData.b().add(otcOptionsIndexData);
            }
            String json = new Gson().toJson((Object) otcOptionsDrawerInfoData);
            i6.d.b(json);
            this.f80208b.success(json);
        }
    }

    public class c extends BaseSubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80210b;

        public c(MethodChannel.Result result) {
            this.f80210b = result;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80210b.error("initOtcOptionsOrder", th2.getMessage(), th2.getMessage());
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            OtcOptionsIndexData otcOptionsIndexData = new OtcOptionsIndexData();
            String a11 = xp.a.a();
            if (TextUtils.isEmpty(a11) && list != null && !list.isEmpty()) {
                a11 = list.get(0);
                xp.a.e(a11);
            }
            otcOptionsIndexData.setSource(xp.a.d());
            otcOptionsIndexData.setSymbol(a11);
            otcOptionsIndexData.setBaseCurrency(a1.v().n(a11));
            otcOptionsIndexData.setQuoteCurrency(a1.v().D(a11));
            otcOptionsIndexData.setBaseCurrencyDisplayName(a1.v().p(a11));
            otcOptionsIndexData.setQuoteCurrencyDisplayName(a1.v().F(a11));
            otcOptionsIndexData.setSymbolName(a1.v().W(a11));
            otcOptionsIndexData.setTradeAmountPrecision(PrecisionUtil.z(a11));
            otcOptionsIndexData.setTradePricePrecision(PrecisionUtil.e(a11));
            if (!TextUtils.isEmpty(xp.a.b())) {
                otcOptionsIndexData.setCycle(xp.a.b());
            }
            otcOptionsIndexData.setOpenOrderLoss(ConfigPreferences.e("user_config", "getString", "1"));
            String json = new Gson().toJson((Object) otcOptionsIndexData);
            i6.d.b(json);
            this.f80210b.success(json);
        }
    }

    public class d implements DatePickerDialog.ResultListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f80212a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f80213b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f80214c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80215d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f80216e;

        public d(boolean z11, long j11, MethodChannel.Result result, long j12) {
            this.f80213b = z11;
            this.f80214c = j11;
            this.f80215d = result;
            this.f80216e = j12;
        }

        public void onCancel() {
            if (!this.f80212a) {
                try {
                    this.f80215d.success((Object) null);
                } catch (Exception e11) {
                    k.k(e11);
                }
            }
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            if (this.f80213b) {
                long currentTimeMillis = System.currentTimeMillis();
                if (AbsOtcOptionsBaseActivity.this.Li(currentTimeMillis, j11)) {
                    HuobiToastUtil.j(R.string.n_order_filter_start_time_error_tip);
                } else if (AbsOtcOptionsBaseActivity.this.Li(this.f80214c, j11)) {
                    HuobiToastUtil.j(R.string.n_order_filter_end_time_early_tip);
                } else if (AbsOtcOptionsBaseActivity.this.Li(j11, currentTimeMillis - 10281600000L)) {
                    HuobiToastUtil.j(R.string.n_order_filter_four_months_ahead_tip2);
                } else {
                    this.f80212a = true;
                    try {
                        this.f80215d.success(Long.valueOf(j11));
                    } catch (Exception e11) {
                        k.k(e11);
                    }
                    datePickerDialog.dismiss();
                }
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (AbsOtcOptionsBaseActivity.this.Li(currentTimeMillis2, j11)) {
                    HuobiToastUtil.j(R.string.n_order_filter_end_time_error_tip);
                } else if (AbsOtcOptionsBaseActivity.this.Li(j11, this.f80216e)) {
                    HuobiToastUtil.j(R.string.n_order_filter_end_time_early_tip);
                } else if (AbsOtcOptionsBaseActivity.this.Li(j11, currentTimeMillis2 - 10281600000L)) {
                    HuobiToastUtil.j(R.string.n_order_filter_four_months_ahead_tip2);
                } else {
                    this.f80212a = true;
                    try {
                        this.f80215d.success(Long.valueOf(j11));
                    } catch (Exception e12) {
                        k.k(e12);
                    }
                    datePickerDialog.dismiss();
                }
            }
        }
    }

    public class e extends BaseSubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f80218b;

        public e(MethodChannel.Result result) {
            this.f80218b = result;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f80218b.error("initOtcOptionsOrder", th2.getMessage(), th2.getMessage());
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            OtcOptionsIndexData otcOptionsIndexData = new OtcOptionsIndexData();
            String a11 = xp.a.a();
            if (TextUtils.isEmpty(a11) && list != null && !list.isEmpty()) {
                a11 = list.get(0);
                xp.a.e(a11);
            }
            otcOptionsIndexData.setSymbol(a11);
            otcOptionsIndexData.setBaseCurrency(a1.v().n(a11));
            otcOptionsIndexData.setQuoteCurrency(a1.v().D(a11));
            otcOptionsIndexData.setBaseCurrencyDisplayName(a1.v().p(a11));
            otcOptionsIndexData.setQuoteCurrencyDisplayName(a1.v().F(a11));
            otcOptionsIndexData.setSymbolName(a1.v().W(a11));
            otcOptionsIndexData.setTradeAmountPrecision(PrecisionUtil.z(a11));
            otcOptionsIndexData.setTradePricePrecision(PrecisionUtil.e(a11));
            otcOptionsIndexData.setCurrency(a1.v().n(xp.a.a()));
            otcOptionsIndexData.setCurrencyList(list);
            otcOptionsIndexData.setOpenOrderLoss(ConfigPreferences.e("user_config", "getString", "1"));
            otcOptionsIndexData.setProductType(xp.a.c());
            String json = new Gson().toJson((Object) otcOptionsIndexData);
            i6.d.b(json);
            this.f80218b.success(json);
        }
    }

    public static String Hi(long j11) {
        return DateTimeUtils.m(j11 / 1000);
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        String str3;
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        try {
            boolean hasArgument = methodCall2.hasArgument("productTitle");
            boolean hasArgument2 = methodCall2.hasArgument("shareText");
            boolean hasArgument3 = methodCall2.hasArgument("incomeRate");
            boolean hasArgument4 = methodCall2.hasArgument("priceTitle");
            boolean hasArgument5 = methodCall2.hasArgument(FirebaseAnalytics.Param.PRICE);
            boolean hasArgument6 = methodCall2.hasArgument("settlePriceTitle");
            boolean hasArgument7 = methodCall2.hasArgument("settlePrice");
            String str4 = "callNativeShare";
            if (!hasArgument || !hasArgument2 || (!(hasArgument3 & hasArgument4 & hasArgument5 & hasArgument6) || !hasArgument7)) {
                str = str4;
                try {
                    result2.error(str, methodCall2.method + "argument error", (Object) null);
                } catch (Exception e11) {
                    e = e11;
                }
            } else {
                try {
                    String str5 = (String) methodCall2.argument("productTitle");
                    String str6 = (String) methodCall2.argument("shareText");
                    String str7 = (String) methodCall2.argument("incomeRate");
                    String str8 = (String) methodCall2.argument("priceTitle");
                    String str9 = (String) methodCall2.argument(FirebaseAnalytics.Param.PRICE);
                    String str10 = (String) methodCall2.argument("settlePriceTitle");
                    String str11 = (String) methodCall2.argument("settlePrice");
                    if (methodCall2.hasArgument("qrImageDesc")) {
                        str2 = (String) methodCall2.argument("qrImageDesc");
                    } else {
                        str2 = "";
                    }
                    if (methodCall2.hasArgument("qrImagePath")) {
                        str3 = (String) methodCall2.argument("qrImagePath");
                    } else {
                        str3 = "";
                    }
                    OtcOptionsShareFragment otcOptionsShareFragment = this.f80206k;
                    if (otcOptionsShareFragment == null) {
                        this.f80206k = new OtcOptionsShareFragment();
                    } else if (otcOptionsShareFragment.isVisible()) {
                        this.f80206k.dismiss();
                    }
                    this.f80206k.ii(str6, str5, str9, str8, str11, str10, str7, str2, str3);
                    this.f80206k.di(false);
                    this.f80206k.show(getSupportFragmentManager(), "otc_options_share");
                    result2.success((Object) null);
                } catch (Exception e12) {
                    e = e12;
                    str = str4;
                    e.printStackTrace();
                    result2.error(str, e.getMessage(), e.getMessage());
                }
            }
        } catch (Exception e13) {
            e = e13;
            str = "callNativeShare";
            e.printStackTrace();
            result2.error(str, e.getMessage(), e.getMessage());
        }
    }

    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = (String) methodCall.argument("symbol");
            xp.a.e(str);
            OtcOptionsIndexData otcOptionsIndexData = new OtcOptionsIndexData();
            otcOptionsIndexData.setSymbol(str);
            otcOptionsIndexData.setBaseCurrency(a1.v().n(str));
            otcOptionsIndexData.setQuoteCurrency(a1.v().D(str));
            otcOptionsIndexData.setBaseCurrencyDisplayName(a1.v().p(str));
            otcOptionsIndexData.setQuoteCurrencyDisplayName(a1.v().F(str));
            otcOptionsIndexData.setSymbolName(a1.v().W(str));
            otcOptionsIndexData.setTradeAmountPrecision(PrecisionUtil.z(str));
            otcOptionsIndexData.setTradePricePrecision(PrecisionUtil.e(str));
            if (!TextUtils.isEmpty(xp.a.b())) {
                otcOptionsIndexData.setCycle(xp.a.b());
            }
            String json = new Gson().toJson((Object) otcOptionsIndexData);
            i6.d.b(json);
            result.success(json);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("changeSymbolDrawer", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        try {
            String str2 = (String) methodCall.argument("symbol");
            String str3 = (String) methodCall.argument(FirebaseAnalytics.Param.PRICE);
            if (TextUtils.isEmpty(str2) || !a1.v().D(str2).equalsIgnoreCase("usdt")) {
                str = LegalCurrencyConfigUtil.A(str3, str2, TradeType.PRO);
            } else {
                str = LegalCurrencyConfigUtil.B(str3);
            }
            result.success(str);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("equivalentCurrency", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            k0.d(true).compose(RxJavaHelper.t((g) null)).subscribe(new b(result));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getOtcOptionsSymbols", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
        try {
            k0.d(true).compose(RxJavaHelper.t((g) null)).subscribe(new c(result));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initOtcOptionsOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ki(MethodCall methodCall, MethodChannel.Result result) {
        try {
            g0.e(true).compose(RxJavaHelper.t((g) null)).subscribe(new e(result));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initOtcOptionsOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public final boolean Li(long j11, long j12) {
        return j11 < j12 && !Hi(j11).equals(Hi(j12));
    }

    public void Mi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            i6.d.b(str);
            if ("initOtcOptionsIndexData".equals(str)) {
                Ji(methodCall, result);
            } else if ("toTransfer".equals(str)) {
                UnifyTransferActivity.Uh(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), "12", false, (String) null, false);
                result.success((Object) null);
            } else if ("equivalentCurrency".equals(str)) {
                Gi(methodCall, result);
            } else if ("getOtcOptionsSymbols".equals(str)) {
                Ii(methodCall, result);
            } else if ("changeSymbolDrawer".equals(str)) {
                Fi(methodCall, result);
            } else if ("showDatePickerView".equals(str)) {
                Oi(methodCall, result);
            } else if ("toOrderList".equals(str)) {
                Pi(methodCall, result);
            } else if ("initOtcOptionsOrder".equals(str)) {
                Ki(methodCall, result);
            } else if ("saveCycle".equals(str)) {
                Ni(methodCall, result);
            } else if ("callNativeShare".equals(str)) {
                Ei(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Ni(MethodCall methodCall, MethodChannel.Result result) {
        try {
            xp.a.f((String) methodCall.arguments);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("toOrderList", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Oi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            long longValue = methodCall.hasArgument("startDate") ? ((Long) methodCall.argument("startDate")).longValue() : 0;
            long longValue2 = methodCall.hasArgument("endDate") ? ((Long) methodCall.argument("endDate")).longValue() : 0;
            boolean booleanValue = methodCall.hasArgument("isSelectedStartDate") ? ((Boolean) methodCall.argument("isSelectedStartDate")).booleanValue() : false;
            if (booleanValue && longValue == 0) {
                i6.d.d(methodCall.method + "startDate is 0");
                result.success((Object) null);
            } else if (booleanValue || longValue2 != 0) {
                new DatePickerDialog.Builder().setInitDate(booleanValue ? longValue : longValue2).setTitle(booleanValue ? R.string.n_order_filter_start_time : R.string.n_order_filter_end_time).setResultListener(new d(booleanValue, longValue2, result, longValue)).show(this);
            } else {
                i6.d.d(methodCall.method + "endDate is 0");
                result.success((Object) null);
            }
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Pi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            xp.a.g(((Integer) methodCall.argument("productType")).intValue());
            startActivity(new Intent(this, OtcOptionsOrderActivity.class));
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("toOrderList", e11.getMessage(), e11.getMessage());
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "otc_options_index_channel").setMethodCallHandler(new a());
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
        rn.c.i().m(this, new JumpTarget((Intent) null, (Intent) null));
        finish();
    }
}
