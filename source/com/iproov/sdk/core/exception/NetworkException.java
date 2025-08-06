package com.iproov.sdk.core.exception;

import android.content.Context;
import com.iproov.sdk.R;

public class NetworkException extends IProovException {
    public NetworkException(Context context, String str) {
        super(reason(context), str);
    }

    private static String reason(Context context) {
        return context.getString(R.string.iproov__error_network);
    }

    public NetworkException(Context context, Exception exc) {
        super(reason(context), exc);
    }
}
