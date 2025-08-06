package com.iproov.sdk.core.exception;

import android.content.Context;
import com.iproov.sdk.R;

public class InvalidOptionsException extends IProovException {
    public InvalidOptionsException(Context context, String str) {
        super(reason(context), str);
    }

    private static String reason(Context context) {
        return context.getString(R.string.iproov__error_invalid_options);
    }

    public InvalidOptionsException(Context context, Exception exc) {
        super(reason(context), exc);
    }
}
