package com.hbg.lib.core.util;

import com.hbg.lib.network.hbg.otcoptions.PreVisibleBean;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class t implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t f68752b = new t();

    public final Object call(Object obj) {
        return Observable.just(Boolean.valueOf(((PreVisibleBean) obj).isVisible()));
    }
}
