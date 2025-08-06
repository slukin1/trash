package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsMediaChunk extends MediaChunk {
    public static final String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
    private static final AtomicInteger uidSource = new AtomicInteger();
    public final int discontinuitySequenceNumber;
    private final DrmInitData drmInitData;
    private HlsMediaChunkExtractor extractor;
    private final HlsExtractorFactory extractorFactory;
    private boolean extractorInvalidated;
    private final boolean hasGapTag;
    private final Id3Decoder id3Decoder;
    private boolean initDataLoadRequired;
    private final DataSource initDataSource;
    private final DataSpec initDataSpec;
    private final boolean initSegmentEncrypted;
    private final boolean isMasterTimestampSource;
    private boolean isPublished;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private final boolean mediaSegmentEncrypted;
    private final List<Format> muxedCaptionFormats;
    private int nextLoadPosition;
    private HlsSampleStreamWrapper output;
    public final int partIndex;
    public final Uri playlistUrl;
    private final HlsMediaChunkExtractor previousExtractor;
    private ImmutableList<Integer> sampleQueueFirstSampleIndices;
    private final ParsableByteArray scratchId3Data;
    public final boolean shouldSpliceIn;
    private final TimestampAdjuster timestampAdjuster;
    public final int uid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z11, DataSource dataSource2, DataSpec dataSpec2, boolean z12, Uri uri, List<Format> list, int i11, Object obj, long j11, long j12, long j13, int i12, boolean z13, int i13, boolean z14, boolean z15, TimestampAdjuster timestampAdjuster2, DrmInitData drmInitData2, HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder2, ParsableByteArray parsableByteArray, boolean z16) {
        super(dataSource, dataSpec, format, i11, obj, j11, j12, j13);
        DataSpec dataSpec3 = dataSpec2;
        this.mediaSegmentEncrypted = z11;
        this.partIndex = i12;
        this.isPublished = z13;
        this.discontinuitySequenceNumber = i13;
        this.initDataSpec = dataSpec3;
        this.initDataSource = dataSource2;
        this.initDataLoadRequired = dataSpec3 != null;
        this.initSegmentEncrypted = z12;
        this.playlistUrl = uri;
        this.isMasterTimestampSource = z15;
        this.timestampAdjuster = timestampAdjuster2;
        this.hasGapTag = z14;
        this.extractorFactory = hlsExtractorFactory;
        this.muxedCaptionFormats = list;
        this.drmInitData = drmInitData2;
        this.previousExtractor = hlsMediaChunkExtractor;
        this.id3Decoder = id3Decoder2;
        this.scratchId3Data = parsableByteArray;
        this.shouldSpliceIn = z16;
        this.sampleQueueFirstSampleIndices = ImmutableList.of();
        this.uid = uidSource.getAndIncrement();
    }

    private static DataSource buildDataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return dataSource;
        }
        Assertions.checkNotNull(bArr2);
        return new Aes128DataSource(dataSource, bArr, bArr2);
    }

    public static HlsMediaChunk createInstance(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, Format format, long j11, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, Uri uri, List<Format> list, int i11, Object obj, boolean z11, TimestampAdjusterProvider timestampAdjusterProvider, HlsMediaChunk hlsMediaChunk, byte[] bArr, byte[] bArr2, boolean z12) {
        boolean z13;
        boolean z14;
        DataSpec dataSpec;
        DataSource dataSource2;
        ParsableByteArray parsableByteArray;
        Id3Decoder id3Decoder2;
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        DataSource dataSource3 = dataSource;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        HlsChunkSource.SegmentBaseHolder segmentBaseHolder2 = segmentBaseHolder;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder2.segmentBase;
        DataSpec build = new DataSpec.Builder().setUri(UriUtil.resolveToUri(hlsMediaPlaylist2.baseUri, segmentBase.url)).setPosition(segmentBase.byteRangeOffset).setLength(segmentBase.byteRangeLength).setFlags(segmentBaseHolder2.isPreload ? 8 : 0).build();
        boolean z15 = bArr3 != null;
        DataSource buildDataSource = buildDataSource(dataSource3, bArr3, z15 ? getEncryptionIvArray((String) Assertions.checkNotNull(segmentBase.encryptionIV)) : null);
        HlsMediaPlaylist.Segment segment = segmentBase.initializationSegment;
        if (segment != null) {
            boolean z16 = bArr4 != null;
            byte[] encryptionIvArray = z16 ? getEncryptionIvArray((String) Assertions.checkNotNull(segment.encryptionIV)) : null;
            z13 = z15;
            dataSpec = new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist2.baseUri, segment.url), segment.byteRangeOffset, segment.byteRangeLength);
            dataSource2 = buildDataSource(dataSource3, bArr4, encryptionIvArray);
            z14 = z16;
        } else {
            z13 = z15;
            dataSource2 = null;
            dataSpec = null;
            z14 = false;
        }
        long j12 = j11 + segmentBase.relativeStartTimeUs;
        long j13 = j12 + segmentBase.durationUs;
        int i12 = hlsMediaPlaylist2.discontinuitySequence + segmentBase.relativeDiscontinuitySequence;
        if (hlsMediaChunk2 != null) {
            boolean z17 = uri.equals(hlsMediaChunk2.playlistUrl) && hlsMediaChunk2.loadCompleted;
            Id3Decoder id3Decoder3 = hlsMediaChunk2.id3Decoder;
            id3Decoder2 = id3Decoder3;
            parsableByteArray = hlsMediaChunk2.scratchId3Data;
            hlsMediaChunkExtractor = (!z17 || hlsMediaChunk2.extractorInvalidated || hlsMediaChunk2.discontinuitySequenceNumber != i12) ? null : hlsMediaChunk2.extractor;
        } else {
            Uri uri2 = uri;
            id3Decoder2 = new Id3Decoder();
            parsableByteArray = new ParsableByteArray(10);
            hlsMediaChunkExtractor = null;
        }
        return new HlsMediaChunk(hlsExtractorFactory, buildDataSource, build, format, z13, dataSource2, dataSpec, z14, uri, list, i11, obj, j12, j13, segmentBaseHolder2.mediaSequence, segmentBaseHolder2.partIndex, !segmentBaseHolder2.isPreload, i12, segmentBase.hasGapTag, z11, timestampAdjusterProvider.getAdjuster(i12), segmentBase.drmInitData, hlsMediaChunkExtractor, id3Decoder2, parsableByteArray, z12);
    }

    @RequiresNonNull({"output"})
    private void feedDataToExtractor(DataSource dataSource, DataSpec dataSpec, boolean z11) throws IOException {
        DataSpec dataSpec2;
        DefaultExtractorInput prepareExtraction;
        long position;
        long j11;
        boolean z12 = false;
        if (z11) {
            if (this.nextLoadPosition != 0) {
                z12 = true;
            }
            dataSpec2 = dataSpec;
        } else {
            dataSpec2 = dataSpec.subrange((long) this.nextLoadPosition);
        }
        try {
            prepareExtraction = prepareExtraction(dataSource, dataSpec2);
            if (z12) {
                prepareExtraction.skipFully(this.nextLoadPosition);
            }
            do {
                if (this.loadCanceled || !this.extractor.read(prepareExtraction)) {
                    break;
                }
                break;
                break;
            } while (!this.extractor.read(prepareExtraction));
            break;
            position = prepareExtraction.getPosition();
            j11 = dataSpec.position;
        } catch (EOFException e11) {
            if ((this.trackFormat.roleFlags & 16384) != 0) {
                this.extractor.onTruncatedSegmentParsed();
                position = prepareExtraction.getPosition();
                j11 = dataSpec.position;
            } else {
                throw e11;
            }
        } catch (Throwable th2) {
            Util.closeQuietly(dataSource);
            throw th2;
        }
        this.nextLoadPosition = (int) (position - j11);
        Util.closeQuietly(dataSource);
    }

    private static byte[] getEncryptionIvArray(String str) {
        if (Ascii.toLowerCase(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static boolean isIndependent(HlsChunkSource.SegmentBaseHolder segmentBaseHolder, HlsMediaPlaylist hlsMediaPlaylist) {
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder.segmentBase;
        if (segmentBase instanceof HlsMediaPlaylist.Part) {
            return ((HlsMediaPlaylist.Part) segmentBase).isIndependent || (segmentBaseHolder.partIndex == 0 && hlsMediaPlaylist.hasIndependentSegments);
        }
        return hlsMediaPlaylist.hasIndependentSegments;
    }

    @RequiresNonNull({"output"})
    private void loadMedia() throws IOException {
        try {
            this.timestampAdjuster.sharedInitializeOrWait(this.isMasterTimestampSource, this.startTimeUs);
            feedDataToExtractor(this.dataSource, this.dataSpec, this.mediaSegmentEncrypted);
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    @RequiresNonNull({"output"})
    private void maybeLoadInitData() throws IOException {
        if (this.initDataLoadRequired) {
            Assertions.checkNotNull(this.initDataSource);
            Assertions.checkNotNull(this.initDataSpec);
            feedDataToExtractor(this.initDataSource, this.initDataSpec, this.initSegmentEncrypted);
            this.nextLoadPosition = 0;
            this.initDataLoadRequired = false;
        }
    }

    private long peekId3PrivTimestamp(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        try {
            this.scratchId3Data.reset(10);
            extractorInput.peekFully(this.scratchId3Data.getData(), 0, 10);
            if (this.scratchId3Data.readUnsignedInt24() != 4801587) {
                return -9223372036854775807L;
            }
            this.scratchId3Data.skipBytes(3);
            int readSynchSafeInt = this.scratchId3Data.readSynchSafeInt();
            int i11 = readSynchSafeInt + 10;
            if (i11 > this.scratchId3Data.capacity()) {
                byte[] data = this.scratchId3Data.getData();
                this.scratchId3Data.reset(i11);
                System.arraycopy(data, 0, this.scratchId3Data.getData(), 0, 10);
            }
            extractorInput.peekFully(this.scratchId3Data.getData(), 10, readSynchSafeInt);
            Metadata decode = this.id3Decoder.decode(this.scratchId3Data.getData(), readSynchSafeInt);
            if (decode == null) {
                return -9223372036854775807L;
            }
            int length = decode.length();
            for (int i12 = 0; i12 < length; i12++) {
                Metadata.Entry entry = decode.get(i12);
                if (entry instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) entry;
                    if (PRIV_TIMESTAMP_FRAME_OWNER.equals(privFrame.owner)) {
                        System.arraycopy(privFrame.privateData, 0, this.scratchId3Data.getData(), 0, 8);
                        this.scratchId3Data.setPosition(0);
                        this.scratchId3Data.setLimit(8);
                        return this.scratchId3Data.readLong() & 8589934591L;
                    }
                }
            }
            return -9223372036854775807L;
        } catch (EOFException unused) {
        }
    }

    @RequiresNonNull({"output"})
    @EnsuresNonNull({"extractor"})
    private DefaultExtractorInput prepareExtraction(DataSource dataSource, DataSpec dataSpec) throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        long j11;
        DataSpec dataSpec2 = dataSpec;
        DataSource dataSource2 = dataSource;
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource2, dataSpec2.position, dataSource.open(dataSpec));
        if (this.extractor == null) {
            long peekId3PrivTimestamp = peekId3PrivTimestamp(defaultExtractorInput);
            defaultExtractorInput.resetPeekPosition();
            HlsMediaChunkExtractor hlsMediaChunkExtractor2 = this.previousExtractor;
            if (hlsMediaChunkExtractor2 != null) {
                hlsMediaChunkExtractor = hlsMediaChunkExtractor2.recreate();
            } else {
                hlsMediaChunkExtractor = this.extractorFactory.createExtractor(dataSpec2.uri, this.trackFormat, this.muxedCaptionFormats, this.timestampAdjuster, dataSource.getResponseHeaders(), defaultExtractorInput);
            }
            this.extractor = hlsMediaChunkExtractor;
            if (hlsMediaChunkExtractor.isPackedAudioExtractor()) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = this.output;
                if (peekId3PrivTimestamp != -9223372036854775807L) {
                    j11 = this.timestampAdjuster.adjustTsTimestamp(peekId3PrivTimestamp);
                } else {
                    j11 = this.startTimeUs;
                }
                hlsSampleStreamWrapper.setSampleOffsetUs(j11);
            } else {
                this.output.setSampleOffsetUs(0);
            }
            this.output.onNewExtractor();
            this.extractor.init(this.output);
        }
        this.output.setDrmInitData(this.drmInitData);
        return defaultExtractorInput;
    }

    public static boolean shouldSpliceIn(HlsMediaChunk hlsMediaChunk, Uri uri, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, long j11) {
        if (hlsMediaChunk == null) {
            return false;
        }
        if (uri.equals(hlsMediaChunk.playlistUrl) && hlsMediaChunk.loadCompleted) {
            return false;
        }
        long j12 = j11 + segmentBaseHolder.segmentBase.relativeStartTimeUs;
        if (!isIndependent(segmentBaseHolder, hlsMediaPlaylist) || j12 < hlsMediaChunk.endTimeUs) {
            return true;
        }
        return false;
    }

    public void cancelLoad() {
        this.loadCanceled = true;
    }

    public int getFirstSampleIndex(int i11) {
        Assertions.checkState(!this.shouldSpliceIn);
        if (i11 >= this.sampleQueueFirstSampleIndices.size()) {
            return 0;
        }
        return this.sampleQueueFirstSampleIndices.get(i11).intValue();
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper, ImmutableList<Integer> immutableList) {
        this.output = hlsSampleStreamWrapper;
        this.sampleQueueFirstSampleIndices = immutableList;
    }

    public void invalidateExtractor() {
        this.extractorInvalidated = true;
    }

    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    public boolean isPublished() {
        return this.isPublished;
    }

    public void load() throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        Assertions.checkNotNull(this.output);
        if (this.extractor == null && (hlsMediaChunkExtractor = this.previousExtractor) != null && hlsMediaChunkExtractor.isReusable()) {
            this.extractor = this.previousExtractor;
            this.initDataLoadRequired = false;
        }
        maybeLoadInitData();
        if (!this.loadCanceled) {
            if (!this.hasGapTag) {
                loadMedia();
            }
            this.loadCompleted = !this.loadCanceled;
        }
    }

    public void publish() {
        this.isPublished = true;
    }
}
