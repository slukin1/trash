package com.tencent.ugc.videobase.egl;

import java.io.IOException;

public class EGLException extends IOException {
    private static final long serialVersionUID = 2723743254380545567L;
    private final int mErrorCode;
    private final String mErrorMessage;

    public EGLException(int i11) {
        this(i11, "");
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getMessage() {
        if (this.mErrorMessage != null) {
            return "EGL error code: " + this.mErrorCode + ", " + this.mErrorMessage;
        }
        return "EGL error code: " + this.mErrorCode + ", " + super.getMessage();
    }

    public EGLException(int i11, String str) {
        super(str);
        this.mErrorCode = i11;
        this.mErrorMessage = str;
    }

    public EGLException(int i11, String str, Throwable th2) {
        super(str, th2);
        this.mErrorCode = i11;
        this.mErrorMessage = str;
    }
}
