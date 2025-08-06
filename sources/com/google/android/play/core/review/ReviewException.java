package com.google.android.play.core.review;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.review.model.zza;
import java.util.Locale;

public class ReviewException extends ApiException {
    public ReviewException(int i11) {
        super(new Status(i11, String.format(Locale.getDefault(), "Review Error(%d): %s", new Object[]{Integer.valueOf(i11), zza.zza(i11)})));
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
