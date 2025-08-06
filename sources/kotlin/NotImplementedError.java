package kotlin;

import kotlin.jvm.internal.r;

public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this((String) null, 1, (r) null);
    }

    public NotImplementedError(String str) {
        super(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotImplementedError(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
