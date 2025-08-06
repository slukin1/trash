package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public class ContainerMediaChunk extends BaseMediaChunk {
    private final int chunkCount;
    private final ChunkExtractor chunkExtractor;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final long sampleOffsetUs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i11, Object obj, long j11, long j12, long j13, long j14, long j15, int i12, long j16, ChunkExtractor chunkExtractor2) {
        super(dataSource, dataSpec, format, i11, obj, j11, j12, j13, j14, j15);
        this.chunkCount = i12;
        this.sampleOffsetUs = j16;
        this.chunkExtractor = chunkExtractor2;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public long getNextChunkIndex() {
        return this.chunkIndex + ((long) this.chunkCount);
    }

    public ChunkExtractor.TrackOutputProvider getTrackOutputProvider(BaseMediaChunkOutput baseMediaChunkOutput) {
        return baseMediaChunkOutput;
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public final void load() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        if (this.nextLoadPosition == 0) {
            BaseMediaChunkOutput output = getOutput();
            output.setSampleOffsetUs(this.sampleOffsetUs);
            ChunkExtractor chunkExtractor2 = this.chunkExtractor;
            ChunkExtractor.TrackOutputProvider trackOutputProvider = getTrackOutputProvider(output);
            long j11 = this.clippedStartTimeUs;
            long j12 = j11 == -9223372036854775807L ? -9223372036854775807L : j11 - this.sampleOffsetUs;
            long j13 = this.clippedEndTimeUs;
            chunkExtractor2.init(trackOutputProvider, j12, j13 == -9223372036854775807L ? -9223372036854775807L : j13 - this.sampleOffsetUs);
        }
        try {
            DataSpec subrange = this.dataSpec.subrange(this.nextLoadPosition);
            StatsDataSource statsDataSource = this.dataSource;
            defaultExtractorInput = new DefaultExtractorInput(statsDataSource, subrange.position, statsDataSource.open(subrange));
            do {
                if (this.loadCanceled || !this.chunkExtractor.read(defaultExtractorInput)) {
                    break;
                }
                break;
                break;
            } while (!this.chunkExtractor.read(defaultExtractorInput));
            break;
            this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.position;
            Util.closeQuietly((DataSource) this.dataSource);
            this.loadCompleted = !this.loadCanceled;
        } catch (Throwable th2) {
            Util.closeQuietly((DataSource) this.dataSource);
            throw th2;
        }
    }
}
