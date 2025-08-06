package com.huobi.trade.helper;

import android.text.TextUtils;
import android.util.Pair;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.index.api.IndexService;
import com.huobi.index.bean.IndexFeature;
import com.huobi.index.bean.IndexFeatureItem;
import com.twitter.sdk.android.core.identity.AuthHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import sn.a;
import tg.r;
import tq.p;
import yl.g;

public class c0 {

    /* renamed from: e  reason: collision with root package name */
    public static c0 f82019e = new c0();

    /* renamed from: a  reason: collision with root package name */
    public IndexFeature f82020a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f82021b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f82022c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f82023d = true;

    public static c0 d() {
        return f82019e;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ IndexFeature g(IndexFeature indexFeature) {
        this.f82020a = indexFeature;
        return indexFeature;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Throwable th2) {
        this.f82020a = null;
    }

    public IndexFeature c() {
        return this.f82020a;
    }

    public Observable<IndexFeature> e() {
        long j11;
        int i11;
        String valueOf = String.valueOf(4);
        String J = r.x().J();
        if (TextUtils.isEmpty(J) || !valueOf.equals(8)) {
            i11 = 0;
            j11 = 0;
        } else {
            i11 = Integer.parseInt(J);
            j11 = System.currentTimeMillis();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("platform", 1);
        hashMap.put("version", String.valueOf(105400));
        hashMap.put("nightMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        hashMap.put("uid", Integer.valueOf(i11));
        hashMap.put("moduleSize", 20);
        if (j11 > 0) {
            hashMap.put(AuthHandler.EXTRA_TOKEN_SECRET, Long.valueOf(j11));
        }
        int g11 = g.h().g();
        if (g11 == -1) {
            try {
                String a11 = a.c().a();
                if (!b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        return ((IndexService) p.V(IndexService.class)).getAppFeatures(valueOf, g11, hashMap).compose(p.E()).map(new b0(this)).doOnError(new a0(this));
    }

    public Pair<Integer, Map<Integer, String>> f(IndexFeature indexFeature) {
        List<IndexFeatureItem> indexFeatureItems;
        HashMap hashMap = new HashMap();
        int i11 = 0;
        if (!(indexFeature == null || (indexFeatureItems = indexFeature.getIndexFeatureItems()) == null)) {
            for (IndexFeatureItem next : indexFeatureItems) {
                if ("币币交易".equals(next.getTitle()) && !TextUtils.isEmpty(next.getIntroduction())) {
                    i11 |= 1;
                    if (!hashMap.containsKey(1)) {
                        hashMap.put(1, next.getIntroduction());
                    }
                }
                if ("杠杆交易".equals(next.getTitle()) && !TextUtils.isEmpty(next.getIntroduction())) {
                    i11 |= 16;
                    if (!hashMap.containsKey(16)) {
                        hashMap.put(16, next.getIntroduction());
                    }
                }
                if ("法币交易".equals(next.getTitle()) && !TextUtils.isEmpty(next.getIntroduction())) {
                    i11 |= 256;
                    if (!hashMap.containsKey(256)) {
                        hashMap.put(256, next.getIntroduction());
                    }
                }
            }
        }
        return new Pair<>(Integer.valueOf(i11), hashMap);
    }

    public void i(boolean z11) {
        this.f82021b = z11;
    }

    public void j(boolean z11) {
        this.f82023d = z11;
    }

    public void k(boolean z11) {
        this.f82022c = z11;
    }
}
