package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import d10.l;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.n0;

final class zzi extends Lambda implements l {
    public final /* synthetic */ TaskCompletionSource zza;
    public final /* synthetic */ n0 zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzi(TaskCompletionSource taskCompletionSource, n0 n0Var) {
        super(1);
        this.zza = taskCompletionSource;
        this.zzb = n0Var;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        Throwable th2 = (Throwable) obj;
        if (th2 instanceof CancellationException) {
            this.zza.setException((Exception) th2);
        } else {
            Throwable z11 = this.zzb.z();
            if (z11 == null) {
                this.zza.setResult(this.zzb.f());
            } else {
                TaskCompletionSource taskCompletionSource = this.zza;
                Exception exc = z11 instanceof Exception ? (Exception) z11 : null;
                if (exc == null) {
                    exc = new RuntimeExecutionException(z11);
                }
                taskCompletionSource.setException(exc);
            }
        }
        return Unit.f56620a;
    }
}
