package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final Format sampleFormat;
    private final int trackType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i11, Object obj, long j11, long j12, long j13, int i12, Format format2) {
        super(dataSource, dataSpec, format, i11, obj, j11, j12, -9223372036854775807L, -9223372036854775807L, j13);
        this.trackType = i12;
        this.sampleFormat = format2;
    }

    public void cancelLoad() {
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    /* JADX INFO: finally extract failed */
    public void load() throws IOException {
        BaseMediaChunkOutput output = getOutput();
        output.setSampleOffsetUs(0);
        TrackOutput track = output.track(0, this.trackType);
        track.format(this.sampleFormat);
        try {
            long open = this.dataSource.open(this.dataSpec.subrange(this.nextLoadPosition));
            if (open != -1) {
                open += this.nextLoadPosition;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, this.nextLoadPosition, open);
            for (int i11 = 0; i11 != -1; i11 = track.sampleData((DataReader) defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.nextLoadPosition += (long) i11;
            }
            track.sampleMetadata(this.startTimeUs, 1, (int) this.nextLoadPosition, 0, (TrackOutput.CryptoData) null);
            Util.closeQuietly((DataSource) this.dataSource);
            this.loadCompleted = true;
        } catch (Throwable th2) {
            Util.closeQuietly((DataSource) this.dataSource);
            throw th2;
        }
    }
}
