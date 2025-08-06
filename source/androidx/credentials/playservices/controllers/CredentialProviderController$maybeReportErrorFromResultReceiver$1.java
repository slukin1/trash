package androidx.credentials.playservices.controllers;

import androidx.credentials.h;
import d10.a;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderController$maybeReportErrorFromResultReceiver$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ h<R1, E1> $callback;
    public final /* synthetic */ E1 $exception;
    public final /* synthetic */ Executor $executor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderController$maybeReportErrorFromResultReceiver$1(Executor executor, h<R1, E1> hVar, E1 e12) {
        super(0);
        this.$executor = executor;
        this.$callback = hVar;
        this.$exception = e12;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(h hVar, Object obj) {
        hVar.a(obj);
    }

    public final void invoke() {
        this.$executor.execute(new CredentialProviderController$maybeReportErrorFromResultReceiver$1$$ExternalSyntheticLambda0(this.$callback, this.$exception));
    }
}
