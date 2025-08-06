package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.integrity.model.b;
import java.util.Locale;

public class StandardIntegrityException extends ApiException {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f66766a;

    public StandardIntegrityException(int i11, Throwable th2) {
        super(new Status(i11, String.format(Locale.ROOT, "Standard Integrity API error (%d): %s.", new Object[]{Integer.valueOf(i11), b.a(i11)})));
        if (i11 != 0) {
            this.f66766a = th2;
            return;
        }
        throw new IllegalArgumentException("ErrorCode should not be 0.");
    }

    public final synchronized Throwable getCause() {
        return this.f66766a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
