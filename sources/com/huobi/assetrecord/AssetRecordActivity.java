package com.huobi.assetrecord;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.AccountType;
import com.huobi.finance.ui.UnifyRiskActivity;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.order.bean.OrderBean;
import com.huobi.order.ui.TradeOrderHistoryDetailActivity;
import com.huobi.otc.flutter.OtcDepositDetailFlutterActivity;
import com.huobi.supermargin.ui.SuperLoanDetailActivity;
import com.huobi.supermargin.ui.SuperRepayDetailActivity;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.utils.k0;
import com.huobi.view.DatePickerDialog;
import d7.a1;
import dt.h2;
import i6.d;
import i6.k;
import i6.m;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;

public class AssetRecordActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public int f42808k = 0;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f42809l;

    public class a implements DatePickerDialog.ResultListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f42810a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42811b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f42812c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f42813d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f42814e;

        public a(boolean z11, long j11, MethodChannel.Result result, long j12) {
            this.f42811b = z11;
            this.f42812c = j11;
            this.f42813d = result;
            this.f42814e = j12;
        }

        public void onCancel() {
            if (!this.f42810a) {
                try {
                    this.f42813d.success((Object) null);
                } catch (Exception e11) {
                    k.k(e11);
                }
            }
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            long j12 = j11;
            if (this.f42811b) {
                long currentTimeMillis = System.currentTimeMillis();
                if (AssetRecordActivity.Ni(currentTimeMillis, j12)) {
                    HuobiToastUtil.j(R.string.n_order_filter_start_time_error_tip);
                } else if (AssetRecordActivity.Ni(this.f42812c, j12)) {
                    HuobiToastUtil.j(R.string.n_order_filter_end_time_early_tip);
                } else if (AssetRecordActivity.Ni(j12, currentTimeMillis - 31449600000L)) {
                    HuobiToastUtil.j(R.string.n_order_filter_four_year_ahead_tip);
                } else {
                    this.f42810a = true;
                    try {
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(j12);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        instance.set(14, 0);
                        this.f42813d.success(Long.valueOf(instance.getTimeInMillis()));
                    } catch (Exception e11) {
                        k.k(e11);
                    }
                    datePickerDialog.dismiss();
                }
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (AssetRecordActivity.Ni(currentTimeMillis2, j12)) {
                    HuobiToastUtil.j(R.string.n_order_filter_end_time_error_tip);
                } else if (AssetRecordActivity.Ni(j12, this.f42814e)) {
                    HuobiToastUtil.j(R.string.n_order_filter_end_time_early_tip);
                } else if (AssetRecordActivity.Ni(j12, currentTimeMillis2 - 31449600000L)) {
                    HuobiToastUtil.j(R.string.n_order_filter_four_year_ahead_tip);
                } else {
                    this.f42810a = true;
                    try {
                        Calendar instance2 = Calendar.getInstance();
                        instance2.setTimeInMillis(j12);
                        instance2.set(11, 23);
                        instance2.set(12, 59);
                        instance2.set(13, 59);
                        instance2.set(14, 999);
                        this.f42813d.success(Long.valueOf(instance2.getTimeInMillis()));
                    } catch (Exception e12) {
                        k.k(e12);
                    }
                    datePickerDialog.dismiss();
                }
            }
        }
    }

    public static String Fi(long j11) {
        return DateTimeUtils.m(j11 / 1000);
    }

    public static boolean Ni(long j11, long j12) {
        return j11 < j12 && !Fi(j11).equals(Fi(j12));
    }

    public static void Qi(Context context) {
        context.startActivity(new Intent(context, AssetRecordActivity.class));
    }

    public static void Ri(Context context, int i11) {
        Intent intent = new Intent(context, AssetRecordActivity.class);
        intent.putExtra("EXTRA_TABBARINDEX", i11);
        context.startActivity(intent);
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = d7.k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        if (F == null) {
            result.success("");
        } else {
            result.success(F.getDisplayName());
        }
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        List<String> j11 = a1.v().j();
        ArrayList arrayList = new ArrayList();
        if (j11 != null) {
            for (String i11 : j11) {
                arrayList.add(StringUtils.i(i11));
            }
        }
        result.success(new Gson().toJson((Object) arrayList));
    }

    public final void Hi(MethodCall methodCall, MethodChannel.Result result) {
        result.success(a1.v().s((String) methodCall.argument("baseDisplayName")).toLowerCase(Locale.US));
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = d7.k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        String valueOf = F != null ? String.valueOf(F.getSafeConfirms()) : "";
        d.c("AssetRecordActivity", "getSafeConfirmCount=" + valueOf);
        result.success(valueOf);
    }

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
        String x11 = d7.k.C().x(str2, (String) methodCall.argument("chain"));
        if ("usdt".equals(str2)) {
            str = m.F(x11, 4);
        } else {
            str = m.F(x11, 8);
        }
        result.success(str);
    }

    public final void Ki(MethodCall methodCall, MethodChannel.Result result) {
        startActivity(UnifyRiskActivity.Ch(this, Long.parseLong((String) methodCall.argument("transactionId")), 0));
        result.success((Object) null);
    }

    public final void Li(MethodCall methodCall, MethodChannel.Result result) {
        TradeOrderHistory transToTradeOrderHistory = ((OrderBean) new Gson().fromJson((String) methodCall.argument("orderJson"), OrderBean.class)).transToTradeOrderHistory();
        Intent intent = new Intent(this, TradeOrderHistoryDetailActivity.class);
        intent.putExtra("symbolId", transToTradeOrderHistory.getSymbolId());
        intent.putExtra("extra_order_history", transToTradeOrderHistory);
        startActivity(intent);
        result.success("");
    }

    public final void Mi(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        hashMap.put("isTurkeyMarginOpen", Boolean.valueOf(gj.d.n().G()));
        hashMap.put("tabbarIndex", String.valueOf(this.f42808k));
        result.success(new Gson().toJson((Object) hashMap));
    }

    public String Nh() {
        return "asset_record";
    }

    public void Oi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -2029717751:
                    if (str.equals("getSmallAmount")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1963941488:
                    if (str.equals("getSpotAccountId")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -1772531868:
                    if (str.equals("getFilterSymbolsWithBase")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case -1575342544:
                    if (str.equals("getCrossMarginAccountId")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -1512881710:
                    if (str.equals("getSafeConfirmCount")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1306864332:
                    if (str.equals("gotoRecordDetailPage")) {
                        c11 = 15;
                        break;
                    }
                    break;
                case -915452021:
                    if (str.equals("getIsolatedMarginAccountId")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -761589593:
                    if (str.equals("openAppleOrderHistoryRecord")) {
                        c11 = 14;
                        break;
                    }
                    break;
                case -633835073:
                    if (str.equals("getDisplayQuoteCurrencyList")) {
                        c11 = 12;
                        break;
                    }
                    break;
                case -467023823:
                    if (str.equals("initAssetRecord")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -451543966:
                    if (str.equals("getChainDisplayName")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -369030742:
                    if (str.equals("canPopFlutterPage")) {
                        c11 = 13;
                        break;
                    }
                    break;
                case 253404617:
                    if (str.equals("gotoOrderHistoryDetailPage")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 748644405:
                    if (str.equals("toCrossMarginRecordDetail")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 829719516:
                    if (str.equals("goToVerify")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1630368510:
                    if (str.equals("showDatePickerView")) {
                        c11 = 1;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    Mi(methodCall, result);
                    return;
                case 1:
                    Pi(methodCall, result);
                    return;
                case 2:
                    Ii(methodCall, result);
                    return;
                case 3:
                    Ji(methodCall, result);
                    return;
                case 4:
                    Ki(methodCall, result);
                    finish();
                    return;
                case 5:
                    Ei(methodCall, result);
                    return;
                case 6:
                    result.success(h2.t1().b1(TradeType.SUPERMARGIN, AccountType.supermargin.toString()).toBlocking().firstOrDefault(null));
                    return;
                case 7:
                    result.success(h2.t1().b1(TradeType.PRO, AccountType.spot.toString()).toBlocking().firstOrDefault(null));
                    return;
                case 8:
                    result.success(h2.t1().b1(TradeType.MARGIN, AccountType.margin.toString()).toBlocking().firstOrDefault(null));
                    return;
                case 9:
                    Si(methodCall, result);
                    return;
                case 10:
                    Li(methodCall, result);
                    return;
                case 11:
                    Hi(methodCall, result);
                    return;
                case 12:
                    Gi(methodCall, result);
                    return;
                case 13:
                    result.success(Boolean.TRUE);
                    return;
                case 14:
                    AppleOrderHistoryRecordActivity.Hh(this);
                    result.success(Boolean.TRUE);
                    return;
                case 15:
                    Map map = (Map) methodCall.arguments;
                    OtcDepositDetailFlutterActivity.Ti(this, Long.valueOf((String) map.get("key_record_id")).longValue(), ((Boolean) map.get("key_is_withdraw")).booleanValue(), ((Boolean) map.get("key_is_need_delete")).booleanValue());
                    result.success((Object) null);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Pi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            long longValue = methodCall.hasArgument("startDate") ? ((Long) methodCall.argument("startDate")).longValue() : 0;
            long longValue2 = methodCall.hasArgument("endDate") ? ((Long) methodCall.argument("endDate")).longValue() : 0;
            boolean booleanValue = methodCall.hasArgument("isSelectedStartDate") ? ((Boolean) methodCall.argument("isSelectedStartDate")).booleanValue() : false;
            if (booleanValue && longValue == 0) {
                d.d(methodCall.method + "startDate is 0");
                result.success((Object) null);
            } else if (booleanValue || longValue2 != 0) {
                new DatePickerDialog.Builder().setInitDate(booleanValue ? longValue : longValue2).setTitle(booleanValue ? R.string.n_order_filter_start_time : R.string.n_order_filter_end_time).setResultListener(new a(booleanValue, longValue2, result, longValue)).show(this);
            } else {
                d.d(methodCall.method + "endDate is 0");
                result.success((Object) null);
            }
        } catch (Exception e11) {
            k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Si(MethodCall methodCall, MethodChannel.Result result) {
        Intent intent;
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        if (((Boolean) methodCall.argument("isLoan")).booleanValue()) {
            intent = SuperLoanDetailActivity.fg(this, (long) intValue);
        } else {
            intent = SuperRepayDetailActivity.fg(this, (long) intValue);
        }
        startActivity(intent);
        result.success("");
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "asset_record_channel");
        this.f42809l = methodChannel;
        methodChannel.setMethodCallHandler(new ii.m(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f42808k = getIntent().getIntExtra("EXTRA_TABBARINDEX", 0);
        BaseModuleConfig.a().w("app_assets_history_exposure", (HashMap) null);
    }

    public void onPointerCaptureChanged(boolean z11) {
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
