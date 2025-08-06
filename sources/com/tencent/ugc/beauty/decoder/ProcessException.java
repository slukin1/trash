package com.tencent.ugc.beauty.decoder;

import java.io.IOException;

public class ProcessException extends IOException {
    private static final long serialVersionUID = 7566826002677832701L;

    public ProcessException(String str) {
        super(str);
    }

    public ProcessException(String str, Throwable th2) {
        super("ProcessException: ".concat(String.valueOf(str)), th2);
    }
}
