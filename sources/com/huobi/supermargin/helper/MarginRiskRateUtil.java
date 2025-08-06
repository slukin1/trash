package com.huobi.supermargin.helper;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.bean.MarginRiskRateBean;
import com.hbg.lib.network.pro.core.bean.SuperMarginRiskRateBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import u6.g;

public class MarginRiskRateUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f81302a = false;

    /* renamed from: b  reason: collision with root package name */
    public static SuperMarginRiskRateBean f81303b;

    /* renamed from: c  reason: collision with root package name */
    public static MarginRiskRateBean f81304c;

    public class a extends BaseSubscriber<Integer> {
        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            if (num == null || num.intValue() != 2) {
                MarginRiskRateUtil.f81302a = false;
            } else {
                MarginRiskRateUtil.f81302a = true;
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            MarginRiskRateUtil.f81302a = false;
        }
    }

    public class b extends BaseSubscriber<MarginRiskRateBean> {
        /* renamed from: a */
        public void onNext(MarginRiskRateBean marginRiskRateBean) {
            super.onNext(marginRiskRateBean);
            MarginRiskRateUtil.f81304c = marginRiskRateBean;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            MarginRiskRateUtil.f81304c = null;
        }
    }

    public class c extends BaseSubscriber<SuperMarginRiskRateBean> {
        /* renamed from: a */
        public void onNext(SuperMarginRiskRateBean superMarginRiskRateBean) {
            super.onNext(superMarginRiskRateBean);
            MarginRiskRateUtil.f81303b = superMarginRiskRateBean;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            MarginRiskRateUtil.f81303b = null;
        }
    }

    public static boolean a() {
        return f81302a;
    }

    public static void b() {
        x8.a.a().getMarginJudgment().b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    public static void c(String str) {
        x8.a.a().getMarginRiskRate(str).b().compose(RxJavaHelper.t((g) null)).subscribe(new b());
    }

    public static void d(String str) {
        x8.a.a().getSuperMarginRiskRate(str).b().compose(RxJavaHelper.t((g) null)).subscribe(new c());
    }
}
