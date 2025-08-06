package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;

public final /* synthetic */ class b implements MetadataOutput {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f65953b = new b();

    public final void onMetadata(Metadata metadata) {
        DownloadHelper.lambda$getRendererCapabilities$1(metadata);
    }
}
