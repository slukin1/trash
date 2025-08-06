package androidx.core.os;

import androidx.core.util.b;

public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this((String) null);
    }

    public OperationCanceledException(String str) {
        super(b.e(str, "The operation has been canceled."));
    }
}
