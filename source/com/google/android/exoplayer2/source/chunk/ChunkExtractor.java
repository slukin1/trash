package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import java.io.IOException;
import java.util.List;

public interface ChunkExtractor {

    public interface Factory {
        ChunkExtractor createProgressiveMediaExtractor(int i11, Format format, boolean z11, List<Format> list, TrackOutput trackOutput);
    }

    public interface TrackOutputProvider {
        TrackOutput track(int i11, int i12);
    }

    ChunkIndex getChunkIndex();

    Format[] getSampleFormats();

    void init(TrackOutputProvider trackOutputProvider, long j11, long j12);

    boolean read(ExtractorInput extractorInput) throws IOException;

    void release();
}
