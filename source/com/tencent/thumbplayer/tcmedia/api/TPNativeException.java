package com.tencent.thumbplayer.tcmedia.api;

import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryException;

public class TPNativeException extends TPNativeLibraryException {
    public TPNativeException(String str) {
        super(str);
    }

    public TPNativeException(String str, Throwable th2) {
        super(str, th2);
    }

    public TPNativeException(Throwable th2) {
        super(th2);
    }
}
