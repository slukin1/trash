package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import java.util.List;

public final /* synthetic */ class b implements ChunkExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f66001a = new b();

    public final ChunkExtractor createProgressiveMediaExtractor(int i11, Format format, boolean z11, List list, TrackOutput trackOutput) {
        return MediaParserChunkExtractor.lambda$static$0(i11, format, z11, list, trackOutput);
    }
}
