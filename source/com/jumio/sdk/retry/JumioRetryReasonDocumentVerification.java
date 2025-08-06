package com.jumio.sdk.retry;

public final class JumioRetryReasonDocumentVerification {
    public static final int DOCUMENT_ENCRYPTED = 402;
    public static final int DOCUMENT_NOT_READABLE = 401;
    public static final int DOCUMENT_PAGE_LIMIT = 403;
    public static final int DOCUMENT_SIZE_LIMIT = 404;
    public static final JumioRetryReasonDocumentVerification INSTANCE = new JumioRetryReasonDocumentVerification();
}
