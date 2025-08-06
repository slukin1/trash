package com.eclipsesource.v8;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;

public abstract class V8ScriptException extends V8RuntimeException {
    private final int endColumn;
    private final String fileName;
    private final String jsMessage;
    private final String jsStackTrace;
    private final int lineNumber;
    private final String sourceLine;
    private final int startColumn;

    public V8ScriptException(String str, int i11, String str2, String str3, int i12, int i13, String str4, Throwable th2) {
        this.fileName = str;
        this.lineNumber = i11;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i12;
        this.endColumn = i13;
        this.jsStackTrace = str4;
        if (th2 != null) {
            initCause(th2);
        }
    }

    private char[] createCharSequence(int i11, char c11) {
        char[] cArr = new char[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cArr[i12] = c11;
        }
        return cArr;
    }

    private String createJSStackDetails() {
        if (this.jsStackTrace == null) {
            return "";
        }
        return "\n" + this.jsStackTrace;
    }

    private String createMessageDetails() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.sourceLine;
        if (str != null && !str.isEmpty()) {
            sb2.append(10);
            sb2.append(this.sourceLine);
            sb2.append(10);
            int i11 = this.startColumn;
            if (i11 >= 0) {
                sb2.append(createCharSequence(i11, ' '));
                sb2.append(createCharSequence(this.endColumn - this.startColumn, '^'));
            }
        }
        return sb2.toString();
    }

    private String createMessageLine() {
        return this.fileName + ":" + this.lineNumber + l.f34627b + this.jsMessage;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getJSMessage() {
        return this.jsMessage;
    }

    public String getJSStackTrace() {
        return this.jsStackTrace;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getMessage() {
        return createMessageLine();
    }

    public String getSourceLine() {
        return this.sourceLine;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    public String toString() {
        return createMessageLine() + createMessageDetails() + createJSStackDetails() + "\n" + getClass().getName();
    }
}
