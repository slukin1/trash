package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class MediaDrmCallbackException extends IOException {
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uriAfterRedirects;

    public MediaDrmCallbackException(DataSpec dataSpec2, Uri uri, Map<String, List<String>> map, long j11, Throwable th2) {
        super(th2);
        this.dataSpec = dataSpec2;
        this.uriAfterRedirects = uri;
        this.responseHeaders = map;
        this.bytesLoaded = j11;
    }
}
