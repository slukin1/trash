package com.hbg.lib.data.symbol;

import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import d7.t;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import x8.a;

public class ExchangeSettingsController {

    /* renamed from: b  reason: collision with root package name */
    public static volatile ExchangeSettingsController f68854b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, ExchangeSettings> f68855a = new HashMap();

    public static ExchangeSettingsController d() {
        if (f68854b == null) {
            synchronized (ExchangeSettingsController.class) {
                if (f68854b == null) {
                    f68854b = new ExchangeSettingsController();
                }
            }
        }
        return f68854b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(String str, ExchangeSettings exchangeSettings) {
        synchronized (this.f68855a) {
            this.f68855a.put(str, exchangeSettings);
        }
    }

    public ExchangeSettings b(String str) {
        ExchangeSettings exchangeSettings;
        synchronized (this.f68855a) {
            exchangeSettings = this.f68855a.get(str);
        }
        return exchangeSettings;
    }

    public Observable<ExchangeSettings> c(boolean z11, String str) {
        return (!z11 || this.f68855a.isEmpty() || this.f68855a.get(str) == null) ? a.a().w(str).b().doOnNext(new t(this, str)) : Observable.just(this.f68855a.get(str));
    }
}
