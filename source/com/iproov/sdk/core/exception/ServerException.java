package com.iproov.sdk.core.exception;

import android.content.Context;
import com.iproov.sdk.R;

public class ServerException extends IProovException {
    public ServerException(Context context, String str) {
        super(context.getString(R.string.iproov__error_server), str);
    }
}
