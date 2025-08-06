package com.iproov.sdk.core.exception;

import android.content.Context;
import com.iproov.sdk.R;

public class UnexpectedErrorException extends IProovException {
    public UnexpectedErrorException(Context context, String str) {
        super(reason(context), str);
    }

    private static String reason(Context context) {
        return context.getString(R.string.iproov__error_unexpected_error);
    }

    public String getReason() {
        if (getCause() == null) {
            return super.getReason();
        }
        return super.getReason() + ": cause: " + getCause().toString();
    }

    public UnexpectedErrorException(Context context, Exception exc) {
        super(reason(context), exc);
    }

    public UnexpectedErrorException(Context context, Throwable th2) {
        super(reason(context), th2);
    }
}
