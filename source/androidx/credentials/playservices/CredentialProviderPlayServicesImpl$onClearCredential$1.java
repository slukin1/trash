package androidx.credentials.playservices;

import android.os.CancellationSignal;
import android.util.Log;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.h;
import d10.l;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderPlayServicesImpl$onClearCredential$1 extends Lambda implements l<Void, Unit> {
    public final /* synthetic */ h<Void, ClearCredentialException> $callback;
    public final /* synthetic */ CancellationSignal $cancellationSignal;
    public final /* synthetic */ Executor $executor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderPlayServicesImpl$onClearCredential$1(CancellationSignal cancellationSignal, Executor executor, h<Void, ClearCredentialException> hVar) {
        super(1);
        this.$cancellationSignal = cancellationSignal;
        this.$executor = executor;
        this.$callback = hVar;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1(h hVar) {
        hVar.onResult(null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Void) obj);
        return Unit.f56620a;
    }

    public final void invoke(Void voidR) {
        CancellationSignal cancellationSignal = this.$cancellationSignal;
        if (!(cancellationSignal != null ? cancellationSignal.isCanceled() : false)) {
            Log.i(CredentialProviderPlayServicesImpl.TAG, "During clear credential, signed out successfully!");
            this.$executor.execute(new CredentialProviderPlayServicesImpl$onClearCredential$1$$ExternalSyntheticLambda0(this.$callback));
        }
    }
}
