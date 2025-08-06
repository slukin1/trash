package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

public final /* synthetic */ class bc implements StandardIntegrityManager.StandardIntegrityTokenProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bd f66823a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f66824b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f66825c;

    public /* synthetic */ bc(bd bdVar, long j11, long j12) {
        this.f66823a = bdVar;
        this.f66824b = j11;
        this.f66825c = j12;
    }

    public final Task request(StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.f66823a.a(this.f66824b, this.f66825c, standardIntegrityTokenRequest);
    }
}
