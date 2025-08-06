package com.huobi.finance.controller;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CTAccountBean;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.internal.r;
import v7.b;

public final class CTAccountController {

    /* renamed from: b  reason: collision with root package name */
    public static final a f45408b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final i<CTAccountController> f45409c = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.SYNCHRONIZED, CTAccountController$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public CTAccountBean f45410a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CTAccountController a() {
            return (CTAccountController) CTAccountController.f45409c.getValue();
        }
    }

    public final CTAccountBean b() {
        return this.f45410a;
    }

    public final void c() {
        RequestExtKt.d(b.a().getCopyTradingAccountStatus(), new CTAccountController$requestCTAStatus$1(this), CTAccountController$requestCTAStatus$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void d(CTAccountBean cTAccountBean) {
        this.f45410a = cTAccountBean;
    }
}
