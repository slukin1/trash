package androidx.credentials;

import android.os.CancellationSignal;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class CredentialManager$clearCredentialState$2$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ CancellationSignal $canceller;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialManager$clearCredentialState$2$1(CancellationSignal cancellationSignal) {
        super(1);
        this.$canceller = cancellationSignal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$canceller.cancel();
    }
}
