package oupson.apng.exceptions;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Loupson/apng/exceptions/InvalidFrameSizeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "animationWidth", "", "animationHeight", "frameWidth", "frameHeight", "isFirstFrame", "", "(IIIIZ)V", "message", "", "getMessage", "()Ljava/lang/String;", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class InvalidFrameSizeException extends Exception {
    private final String message;

    public InvalidFrameSizeException(int i11, int i12, int i13, int i14, boolean z11) {
        String str;
        if (i11 != i13 && z11) {
            str = "Width of first frame must be equal to width of APNG (" + i11 + " != " + i13 + ").";
        } else if (i13 > i11) {
            str = "Frame width must be inferior or equal at the animation width (" + i11 + " < " + i13 + ").";
        } else if (i14 > i12) {
            str = "Frame height must be inferior or equal at the animation height (" + i12 + " < " + i14 + ").";
        } else {
            str = "Unknown problem";
        }
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }
}
