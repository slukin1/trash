package com.eclipsesource.v8;

public class V8ScriptExecutionException extends V8ScriptException {
    public V8ScriptExecutionException(String str, int i11, String str2, String str3, int i12, int i13, String str4) {
        this(str, i11, str2, str3, i12, i13, str4, (Throwable) null);
    }

    public V8ScriptExecutionException(String str, int i11, String str2, String str3, int i12, int i13, String str4, Throwable th2) {
        super(str, i11, str2, str3, i12, i13, str4, th2);
    }
}
