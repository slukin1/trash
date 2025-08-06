package com.iproov.sdk.core.exception;

import android.content.Context;
import com.iproov.sdk.R;

public class CameraException extends IProovException {
    public CameraException(Context context, String str) {
        super(reason(context), str);
    }

    private static String reason(Context context) {
        return context.getString(R.string.iproov__error_camera);
    }

    public CameraException(Context context, Exception exc) {
        super(reason(context), exc);
    }

    public CameraException(Context context, Throwable th2) {
        super(reason(context), th2);
    }
}
