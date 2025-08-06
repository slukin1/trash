package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.d;
import com.google.android.play.integrity.internal.q;
import com.google.android.play.integrity.internal.w;
import java.util.ArrayList;

final class ax {

    /* renamed from: a  reason: collision with root package name */
    public final ac f66811a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final q f66812b;

    /* renamed from: c  reason: collision with root package name */
    private final String f66813c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final TaskCompletionSource f66814d;

    public ax(Context context, q qVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f66814d = taskCompletionSource;
        this.f66813c = context.getPackageName();
        this.f66812b = qVar;
        ac acVar = new ac(context, qVar, "ExpressIntegrityService", ay.f66815a, ap.f66795a, (w) null);
        this.f66811a = acVar;
        acVar.c().post(new aq(this, taskCompletionSource, context));
    }

    public static /* bridge */ /* synthetic */ Bundle a(ax axVar, String str, long j11, long j12) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", axVar.f66813c);
        bundle.putLong("cloud.prj", j11);
        bundle.putString("nonce", str);
        bundle.putLong("warm.up.sid", j12);
        ArrayList arrayList = new ArrayList();
        d.b(5, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(d.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ Bundle b(ax axVar, long j11) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", axVar.f66813c);
        bundle.putLong("cloud.prj", j11);
        ArrayList arrayList = new ArrayList();
        d.b(4, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(d.a(arrayList)));
        return bundle;
    }

    public static /* bridge */ /* synthetic */ boolean g(ax axVar) {
        return axVar.f66814d.getTask().isSuccessful() && !((Boolean) axVar.f66814d.getTask().getResult()).booleanValue();
    }

    public final Task c(String str, long j11, long j12) {
        this.f66812b.c("requestExpressIntegrityToken(%s)", Long.valueOf(j12));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f66811a.t(new as(this, taskCompletionSource, str, j11, j12, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task d(long j11) {
        this.f66812b.c("warmUpIntegrityToken(%s)", Long.valueOf(j11));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f66811a.t(new ar(this, taskCompletionSource, j11, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
