package okio;

import java.util.zip.Deflater;

/* renamed from: okio.-DeflaterSinkExtensions  reason: invalid class name */
public final class DeflaterSinkExtensions {
    public static final DeflaterSink deflate(Sink sink, Deflater deflater) {
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink sink, Deflater deflater, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            deflater = new Deflater();
        }
        return new DeflaterSink(sink, deflater);
    }
}
