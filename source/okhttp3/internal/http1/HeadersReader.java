package okhttp3.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import kotlin.jvm.internal.r;
import okhttp3.Headers;
import okio.BufferedSource;

public final class HeadersReader {
    public static final Companion Companion = new Companion((r) null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    private final BufferedSource source;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public HeadersReader(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public final BufferedSource getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readLine = readLine();
            if (readLine.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(readLine);
        }
    }

    public final String readLine() {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long) readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }
}
