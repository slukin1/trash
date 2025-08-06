package okio;

/* renamed from: okio.-GzipSourceExtensions  reason: invalid class name */
public final class GzipSourceExtensions {
    private static final int FCOMMENT = 4;
    private static final int FEXTRA = 2;
    private static final int FHCRC = 1;
    private static final int FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;

    private static final boolean getBit(int i11, int i12) {
        return ((i11 >> i12) & 1) == 1;
    }

    public static final GzipSource gzip(Source source) {
        return new GzipSource(source);
    }
}
