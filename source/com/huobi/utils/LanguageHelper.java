package com.huobi.utils;

import bh.j;
import com.hbg.lib.core.lang.BaseLang;
import com.hbg.lib.core.lang.TrLang;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.imsdk.HbgDialogManager;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.dynamiclangs.util.DynamicStringsHelper;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.otcoption.util.OtcOptionsEntryHelper;
import d7.a1;
import d7.k;
import d7.m;
import gj.g;
import java.util.List;
import qu.d;
import va.b;

public final class LanguageHelper {

    /* renamed from: a  reason: collision with root package name */
    public static List<Integer> f83697a;

    public class a extends BaseSubscriber<String> {
    }

    public static void a() {
        k.C().i();
        a1.v().g();
        m.c();
        d.i().u();
        d.i().v();
        d.i().r();
    }

    public static void b(BaseLang baseLang) {
        i6.d.c("DataDiffTools", "CHANGE LANGUAGE");
        DynamicStringsHelper.a();
        m6.a.o(baseLang);
        AppLanguageHelper.getInstance().changeAppLanguage(j.c().getApplicationContext(), baseLang.getLocale());
        b.o().b();
        OtcOrderReminder.e().j();
        AppLanguageHelper.getInstance().setChangeLanguage(true);
        a();
        g.e().k();
        OtcOptionsEntryHelper.g().k();
        HbgDialogManager.A().a0();
        com.huobi.lifecycle.a.j().q();
        e6.d.r().x(AppLanguageHelper.getInstance().getCurLanguageHeader());
        if (baseLang instanceof TrLang) {
            hf.b.A();
        }
        HBHTtoHTXManager.f83692a.c();
        hf.b.v();
        v7.b.a().Q(m6.a.f()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a());
    }
}
