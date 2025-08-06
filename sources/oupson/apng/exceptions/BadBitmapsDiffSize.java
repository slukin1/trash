package oupson.apng.exceptions;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Loupson/apng/exceptions/BadBitmapsDiffSize;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "firstBitmapWidth", "", "firstBitmapHeight", "secondBitmapWidth", "secondBitmapHeight", "(IIII)V", "message", "", "getMessage", "()Ljava/lang/String;", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class BadBitmapsDiffSize extends Exception {
    private final String message;

    public BadBitmapsDiffSize(int i11, int i12, int i13, int i14) {
        this.message = i11 + 'x' + i12 + " must be bigger than or equal to " + i13 + 'x' + i14;
    }

    public String getMessage() {
        return this.message;
    }
}
