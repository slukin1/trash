package org.joda.time.format;

import com.huobi.login.usercenter.data.source.bean.KvStore;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static n f23264a;

    public static n a() {
        if (f23264a == null) {
            f23264a = new PeriodFormatterBuilder().f("P").o().l(KvStore.Y).h().l("M").n().l("W").b().l("D").k("T").e().l("H").g().l("M").i().l("S").s();
        }
        return f23264a;
    }
}
