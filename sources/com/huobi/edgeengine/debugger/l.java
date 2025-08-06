package com.huobi.edgeengine.debugger;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huobi/edgeengine/debugger/l;", "", "", "projectName", "data", "", "a", "b", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "projectNameArr", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "dataMap", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f44036a = new l();

    /* renamed from: b  reason: collision with root package name */
    public static final ArrayList<String> f44037b = CollectionsKt__CollectionsKt.g("framework.js", "authkyc", FirebaseAnalytics.Param.COUPON, FirebaseAnalytics.Param.CURRENCY, "kycquickauth", "networkdetection", "spottradeconfirm", "tradeconfirm", "tradetime", "liveGift");

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, String> f44038c = new HashMap<>();

    public final void a(String str, String str2) {
        if (!r.f44050a.h()) {
            f44038c.put(str, str2);
        }
    }

    public final String b(String str) {
        String str2 = f44038c.get(str);
        return str2 == null ? "" : str2;
    }

    public final ArrayList<String> c() {
        return f44037b;
    }

    public final void d(String str) {
        f44038c.remove(str);
    }
}
