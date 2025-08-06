package com.huobi.staring.helper;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.staring.bean.AllRulesResult;
import com.huobi.staring.bean.CustomConfig;
import com.huobi.staring.bean.CustomRuleListResult;
import com.huobi.staring.bean.CustomSaveResult;
import com.huobi.staring.bean.PriceConfig;
import com.huobi.staring.bean.RemindCustomSub;
import com.huobi.staring.bean.RuleConfigResult;
import com.huobi.staring.bean.StareConfig;
import com.huobi.staring.service.StaringRemindService;
import i6.d;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import rx.Observable;
import rx.Subscriber;
import tq.p;
import u6.g;

public class StaringRemindHelper {

    /* renamed from: a  reason: collision with root package name */
    public static RuleConfigResult f81170a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f81171b;

    public class a extends BaseSubscriber<RuleConfigResult> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseSubscriber f81172b;

        public a(BaseSubscriber baseSubscriber) {
            this.f81172b = baseSubscriber;
        }

        /* renamed from: a */
        public void onNext(RuleConfigResult ruleConfigResult) {
            super.onNext(ruleConfigResult);
            d.b("StaringRemindHelper-->requestRuleConfigList-->" + ruleConfigResult);
            RuleConfigResult unused = StaringRemindHelper.f81170a = ruleConfigResult;
            BaseSubscriber baseSubscriber = this.f81172b;
            if (baseSubscriber != null) {
                baseSubscriber.onNext(ruleConfigResult);
            }
        }

        public void onAfter() {
            super.onAfter();
            boolean unused = StaringRemindHelper.f81171b = false;
            BaseSubscriber baseSubscriber = this.f81172b;
            if (baseSubscriber != null) {
                baseSubscriber.onAfter();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            BaseSubscriber baseSubscriber = this.f81172b;
            if (baseSubscriber != null) {
                baseSubscriber.onError(th2);
            }
        }

        public void onStart() {
            super.onStart();
            BaseSubscriber baseSubscriber = this.f81172b;
            if (baseSubscriber != null) {
                baseSubscriber.onStart();
            }
        }
    }

    public static boolean c() {
        if (f81170a != null) {
            return false;
        }
        n();
        return true;
    }

    public static int d() {
        CustomConfig custom;
        PriceConfig price;
        RuleConfigResult ruleConfigResult = f81170a;
        if (ruleConfigResult == null || (custom = ruleConfigResult.getCustom()) == null || (price = custom.getPrice()) == null) {
            return 0;
        }
        return price.getPriceLimit();
    }

    public static RuleConfigResult e() {
        return f81170a;
    }

    public static int f() {
        RuleConfigResult ruleConfigResult = f81170a;
        if (ruleConfigResult != null) {
            return ruleConfigResult.getSymbolLimit();
        }
        return 0;
    }

    public static boolean g() {
        return f81170a != null;
    }

    public static boolean h(String str) {
        CustomConfig custom;
        PriceConfig price;
        List<String> symbols;
        if (!TextUtils.isEmpty(str) && !c() && (custom = f81170a.getCustom()) != null && (price = custom.getPrice()) != null && (symbols = price.getSymbols()) != null && !symbols.isEmpty()) {
            for (String equalsIgnoreCase : symbols) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean i(String str) {
        StareConfig marketStare;
        List<String> symbols;
        if (!TextUtils.isEmpty(str) && !c() && (marketStare = f81170a.getMarketStare()) != null && (symbols = marketStare.getSymbols()) != null && !symbols.isEmpty()) {
            for (String equalsIgnoreCase : symbols) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void j(g gVar, Subscriber<CustomRuleListResult> subscriber) {
        ((StaringRemindService) p.b0(StaringRemindService.class)).requestAllCustomSubRules(1).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(subscriber);
    }

    public static void k(String str, g gVar, Subscriber<AllRulesResult> subscriber) {
        if (!TextUtils.isEmpty(str)) {
            ((StaringRemindService) p.b0(StaringRemindService.class)).requestAllRulesBySymbol(str.replaceAll("/", "").toLowerCase(Locale.US), 1).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(subscriber);
        }
    }

    public static Observable<RemindCustomSub> l(String str, g gVar) {
        return ((StaringRemindService) p.b0(StaringRemindService.class)).requestCustomSub(str, 1).compose(p.c0()).compose(RxJavaHelper.t(gVar));
    }

    public static void m(List<Long> list, g gVar, Subscriber<Object> subscriber) {
        HashMap hashMap = new HashMap();
        hashMap.put("price_ids", list);
        ((StaringRemindService) p.b0(StaringRemindService.class)).requestDeleteCustomRule(hashMap).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(subscriber);
    }

    public static void n() {
        o((BaseSubscriber<RuleConfigResult>) null);
    }

    public static void o(BaseSubscriber<RuleConfigResult> baseSubscriber) {
        if (gj.d.n().B() && !f81171b) {
            f81171b = true;
            ((StaringRemindService) p.b0(StaringRemindService.class)).requestRuleConfigList(1).compose(p.c0()).compose(RxJavaHelper.t((g) null)).subscribe(new a(baseSubscriber));
        }
    }

    public static void p(long j11, String str, String str2, boolean z11, g gVar, Subscriber<CustomSaveResult> subscriber) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.replaceAll("/", "").toLowerCase(Locale.US);
            HashMap hashMap = new HashMap();
            hashMap.put("rule_id", Long.valueOf(j11));
            hashMap.put("symbol", lowerCase);
            hashMap.put(FirebaseAnalytics.Param.PRICE, str2);
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, Integer.valueOf(z11 ? 1 : 2));
            hashMap.put("type", 1);
            ((StaringRemindService) p.b0(StaringRemindService.class)).requestSaveCustomRule(hashMap).compose(p.c0()).compose(RxJavaHelper.t(gVar)).subscribe(subscriber);
        }
    }
}
