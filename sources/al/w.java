package al;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.hbg.lib.network.hbg.core.bean.UserCardInfoBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.ui.CurrencyFromCCDetailActivity;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategy;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.a0;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pro.huobi.R;
import q6.d;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import tq.p;
import u6.g;

public final class w {

    public class a extends Subscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f40740b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Intent f40741c;

        public a(Context context, Intent intent) {
            this.f40740b = context;
            this.f40741c = intent;
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            w.o(this.f40740b, false);
            HBBaseWebActivity.showWebView(this.f40740b, this.f40741c);
        }

        public void onNext(Object obj) {
            w.o(this.f40740b, false);
        }
    }

    public class b implements Func2<Object, List<UserCardInfoBean>, Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Intent f40742b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f40743c;

        public b(Intent intent, Context context) {
            this.f40742b = intent;
            this.f40743c = context;
        }

        /* renamed from: a */
        public Object call(Object obj, List<UserCardInfoBean> list) {
            if (!(obj instanceof Map)) {
                return null;
            }
            int intValue = Double.valueOf(((Map) obj).get("cardId").toString()).intValue();
            this.f40742b.putExtra("accountNumber", String.valueOf(intValue));
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (String.valueOf(intValue).equals(String.valueOf(list.get(i11).getCardId()))) {
                    this.f40742b.putExtra("accountNumber", list.get(i11).getAccountNumber());
                    HBBaseWebActivity.showWebView(this.f40743c, this.f40742b);
                }
            }
            return null;
        }
    }

    public interface c {
        void onSuccess();
    }

    public static void d(String str, g gVar, c cVar) {
        v7.b.a().c0(str, f()).b().compose(RxJavaHelper.t(gVar)).subscribe(d.c(gVar, new u(cVar)));
    }

    public static Observable<Boolean> e() {
        return UserCenterRemoteDataSource.A().F().compose(p.c0()).flatMap(v.f3602b);
    }

    public static Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", g());
        hashMap.put("source", "android");
        hashMap.put("x-version", "10.54.0");
        return hashMap;
    }

    public static String g() {
        return SystemUtils.c() ? "52d6d3" : "global";
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return g();
        }
        return (TextUtils.equals(str.toUpperCase(), "EUR") || TextUtils.equals(str.toUpperCase(), "GBP")) ? "b3Rj5Z" : g();
    }

    public static void i(Context context, String str, String str2, String str3, String str4, BigDecimal bigDecimal, String str5, String str6, String str7) {
        Intent webViewIntent = HBBaseWebActivity.getWebViewIntent(context, str, "", "", false);
        if (webViewIntent != null) {
            webViewIntent.putExtra(FirebaseAnalytics.Param.CURRENCY, str2);
            webViewIntent.putExtra(AppsFlyerProperties.CHANNEL, str3);
            webViewIntent.putExtra("paymentMethodCode", str4);
            webViewIntent.putExtra("amount", String.valueOf(bigDecimal));
            webViewIntent.putExtra("deviceFingerprint", str5);
            webViewIntent.putExtra("limitMin", str6);
            webViewIntent.putExtra("limitMax", str7);
            HBBaseWebActivity.showWebView(context, webViewIntent);
        }
    }

    public static void j(Context context, String str, String str2, String str3, String str4) {
        Intent webViewIntent = HBBaseWebActivity.getWebViewIntent(context, str, "", "", false);
        if (webViewIntent != null) {
            webViewIntent.putExtra("orderCode", str2);
            webViewIntent.putExtra(FirebaseAnalytics.Param.CURRENCY, str3);
            webViewIntent.putExtra("paymentMethodCode", str4);
            if ("settlepay".equals(str4)) {
                o(context, true);
                HashMap hashMap = new HashMap();
                hashMap.put("merchantCode", "settlepay210811");
                hashMap.put("paymentMethod", "settlepay");
                Observable.zip(v7.b.a().detailDepositCurrencyFromCCFinance(str2, f()).b(), v7.b.a().getSettlePayUserCardList(hashMap).b(), new b(webViewIntent, context)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(context, webViewIntent));
                return;
            }
            HBBaseWebActivity.showWebView(context, webViewIntent);
        }
    }

    public static void k(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent webViewIntent = HBBaseWebActivity.getWebViewIntent(context, str, "", "", false);
        if (webViewIntent != null) {
            webViewIntent.putExtra("orderCode", str2);
            webViewIntent.putExtra(FirebaseAnalytics.Param.CURRENCY, str3);
            webViewIntent.putExtra("paymentMethodCode", str4);
            webViewIntent.putExtra("accountNumber", str5);
            HBBaseWebActivity.showWebView(context, webViewIntent);
        }
    }

    public static void l(Context context, CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo) {
        if (currencyFromCCFinanceRecordInfo != null) {
            String paymentMethodCode = currencyFromCCFinanceRecordInfo.getPaymentMethodCode();
            if (TextUtils.equals(paymentMethodCode, "4")) {
                String h11 = a0.h();
                String currency = currencyFromCCFinanceRecordInfo.getCurrency();
                BigDecimal amount = currencyFromCCFinanceRecordInfo.getAmount();
                String channel = currencyFromCCFinanceRecordInfo.getChannel();
                String str = null;
                if (iu.a.f().k()) {
                    str = ku.b.e().h(context);
                }
                i(context, h11, currency, channel, paymentMethodCode, amount, str, "", "");
                return;
            }
            j(context, a0.g(), currencyFromCCFinanceRecordInfo.getOrderCode(), currencyFromCCFinanceRecordInfo.getCurrency(), paymentMethodCode);
        }
    }

    public static /* synthetic */ void m(c cVar, Object obj) {
        HuobiToastUtil.s(R.string.n_currency_from_cc_order_canceled);
        if (cVar != null) {
            cVar.onSuccess();
        }
    }

    public static /* synthetic */ Observable n(SecurityStrategySet securityStrategySet) {
        SecurityStrategy setting = securityStrategySet != null ? securityStrategySet.getSetting() : null;
        boolean z11 = true;
        if (((setting == null || !setting.isVerify_email()) ? 0 : 1) + ((setting == null || !setting.isVerify_phone()) ? 0 : 1) + ((setting == null || !setting.isVerify_ga()) ? 0 : 1) < 2) {
            z11 = false;
        }
        return Observable.just(Boolean.valueOf(z11));
    }

    public static void o(Context context, boolean z11) {
        if (context instanceof CurrencyFromCCDetailActivity) {
            ((CurrencyFromCCDetailActivity) context).Th(z11);
        }
    }
}
