package com.huobi.home.ui;

import com.hbg.lib.network.hbg.core.bean.TokenBindInfo;
import com.huobi.utils.t0;
import d10.l;
import kotlin.jvm.internal.Lambda;
import rx.Observable;
import v7.b;

public final class HomeFragment$AuthTarget$show$1 extends Lambda implements l<String, Observable<? extends TokenBindInfo>> {
    public static final HomeFragment$AuthTarget$show$1 INSTANCE = new HomeFragment$AuthTarget$show$1();

    public HomeFragment$AuthTarget$show$1() {
        super(1);
    }

    public final Observable<? extends TokenBindInfo> invoke(String str) {
        return b.a().R(t0.a(), 1, str).b();
    }
}
