package com.google.android.play.core.integrity;

import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ad;
import com.google.android.play.integrity.internal.n;
import com.google.android.play.integrity.internal.r;

final class ab extends r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f66771a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Long f66772b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f66773c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ IntegrityTokenRequest f66774d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ad f66775e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(ad adVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l11, Parcelable parcelable, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f66775e = adVar;
        this.f66771a = bArr;
        this.f66772b = l11;
        this.f66773c = taskCompletionSource2;
        this.f66774d = integrityTokenRequest;
    }

    public final void a(Exception exc) {
        if (exc instanceof ad) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    public final void b() {
        try {
            ((n) this.f66775e.f66779a.e()).c(ad.a(this.f66775e, this.f66771a, this.f66772b, (Parcelable) null), new ac(this.f66775e, this.f66773c));
        } catch (RemoteException e11) {
            this.f66775e.f66780b.b(e11, "requestIntegrityToken(%s)", this.f66774d);
            this.f66773c.trySetException(new IntegrityServiceException(-100, e11));
        }
    }
}
