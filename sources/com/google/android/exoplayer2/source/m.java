package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import java.util.List;

public final /* synthetic */ class m {
    @Deprecated
    public static MediaSource a(MediaSourceFactory mediaSourceFactory, Uri uri) {
        return mediaSourceFactory.createMediaSource(MediaItem.fromUri(uri));
    }

    @Deprecated
    public static MediaSourceFactory b(MediaSourceFactory mediaSourceFactory, List list) {
        return mediaSourceFactory;
    }
}
