package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultHlsPlaylistTracker.MediaPlaylistBundle f66023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f66024c;

    public /* synthetic */ b(DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle, Uri uri) {
        this.f66023b = mediaPlaylistBundle;
        this.f66024c = uri;
    }

    public final void run() {
        this.f66023b.lambda$loadPlaylistInternal$0(this.f66024c);
    }
}
