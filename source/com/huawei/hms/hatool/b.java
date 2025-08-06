package com.huawei.hms.hatool;

import android.content.Context;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public s0 f38116a;

    /* renamed from: b  reason: collision with root package name */
    public s0 f38117b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38118c;

    /* renamed from: d  reason: collision with root package name */
    public String f38119d;

    public b(Context context) {
        if (context != null) {
            this.f38118c = context.getApplicationContext();
        }
        this.f38116a = new s0();
        this.f38117b = new s0();
    }

    public b a(int i11, String str) {
        s0 s0Var;
        v.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i11);
        if (!p1.b(str)) {
            str = "";
        }
        if (i11 == 0) {
            s0Var = this.f38116a;
        } else if (i11 != 1) {
            v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
            return this;
        } else {
            s0Var = this.f38117b;
        }
        s0Var.b(str);
        return this;
    }

    public b a(String str) {
        v.c("hmsSdk", "Builder.setAppID is execute");
        this.f38119d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z11) {
        v.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f38116a.j().a(z11);
        this.f38117b.j().a(z11);
        return this;
    }

    public void a() {
        if (this.f38118c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.c("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.f38116a));
        z0Var.a(new s0(this.f38117b));
        m.a().a(this.f38118c);
        g0.a().a(this.f38118c);
        q.c().a(z0Var);
        m.a().a(this.f38119d);
    }

    @Deprecated
    public b b(boolean z11) {
        v.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f38116a.j().b(z11);
        this.f38117b.j().b(z11);
        return this;
    }

    @Deprecated
    public b c(boolean z11) {
        v.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f38116a.j().c(z11);
        this.f38117b.j().c(z11);
        return this;
    }
}
