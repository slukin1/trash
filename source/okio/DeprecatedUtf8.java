package okio;

/* renamed from: okio.-DeprecatedUtf8  reason: invalid class name */
public final class DeprecatedUtf8 {
    public static final DeprecatedUtf8 INSTANCE = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    public final long size(String str) {
        return Utf8.size$default(str, 0, 0, 3, (Object) null);
    }

    public final long size(String str, int i11, int i12) {
        return Utf8.size(str, i11, i12);
    }
}
