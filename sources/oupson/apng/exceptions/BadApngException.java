package oupson.apng.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Loupson/apng/exceptions/BadApngException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class BadApngException extends Exception {
    private final String message;

    public BadApngException() {
        this((String) null, 1, (r) null);
    }

    public BadApngException(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadApngException(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str);
    }
}
