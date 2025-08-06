package com.hbg.lib.core.util;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import u6.g;

public class RxJavaHelper {
    public static /* synthetic */ Boolean l(Integer num) {
        return Boolean.valueOf(num.intValue() == 5 || num.intValue() == 7 || num.intValue() == 9);
    }

    public static /* synthetic */ Boolean p(Integer num) {
        return Boolean.valueOf(num.intValue() == 5 || num.intValue() == 7 || num.intValue() == 9);
    }

    public static <T> Observable.Transformer<T, T> s() {
        return b0.f68693b;
    }

    public static <T> Observable.Transformer<T, T> t(g gVar) {
        return u(gVar, Schedulers.io());
    }

    public static <T> Observable.Transformer<T, T> u(g gVar, Scheduler scheduler) {
        if (gVar == null) {
            return new x(scheduler);
        }
        return new a0(scheduler, gVar);
    }

    public static <T> Observable.Transformer<T, T> v(g gVar, Scheduler scheduler, Scheduler scheduler2) {
        if (gVar == null) {
            return new y(scheduler, scheduler2);
        }
        return new z(scheduler, scheduler2, gVar);
    }
}
