package com.iproov.sdk.core.exception;

import android.content.Context;
import com.iproov.sdk.R;

public class CameraPermissionException extends IProovException {
    public CameraPermissionException(Context context) {
        super(context.getString(R.string.iproov__error_camera_permission_denied), context.getString(R.string.iproov__error_camera_permission_denied_message));
    }
}
