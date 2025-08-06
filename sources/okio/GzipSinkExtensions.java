package okio;

/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink sink) {
        return new GzipSink(sink);
    }
}
