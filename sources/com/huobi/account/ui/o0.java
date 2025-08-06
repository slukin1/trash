package com.huobi.account.ui;

import androidx.appcompat.widget.SwitchCompat;
import c6.b;
import java.util.List;

public final /* synthetic */ class o0 implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NotificationManagerSettingActivity f41772b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f41773c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f41774d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f41775e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SwitchCompat f41776f;

    public /* synthetic */ o0(NotificationManagerSettingActivity notificationManagerSettingActivity, boolean z11, int i11, List list, SwitchCompat switchCompat) {
        this.f41772b = notificationManagerSettingActivity;
        this.f41773c = z11;
        this.f41774d = i11;
        this.f41775e = list;
        this.f41776f = switchCompat;
    }

    public final void onCallback(Object obj) {
        this.f41772b.Pg(this.f41773c, this.f41774d, this.f41775e, this.f41776f, obj);
    }
}
