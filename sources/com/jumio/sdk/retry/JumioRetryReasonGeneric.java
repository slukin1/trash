package com.jumio.sdk.retry;

public final class JumioRetryReasonGeneric {
    public static final int ATTEMPT_FAILED = 4;
    public static final int GENERIC = 1;
    public static final JumioRetryReasonGeneric INSTANCE = new JumioRetryReasonGeneric();
    public static final int USER_BACK = 3;
    public static final int USER_CANCEL = 2;
}
