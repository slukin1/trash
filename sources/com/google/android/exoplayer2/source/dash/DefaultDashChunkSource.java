package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {
    private final int[] adaptationSetIndices;
    private final DataSource dataSource;
    private final long elapsedRealtimeOffsetMs;
    private IOException fatalError;
    private DashManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int maxSegmentsPerLoad;
    private boolean missingLastSegment;
    private int periodIndex;
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler;
    public final RepresentationHolder[] representationHolders;
    private ExoTrackSelection trackSelection;
    private final int trackType;

    public static final class Factory implements DashChunkSource.Factory {
        private final ChunkExtractor.Factory chunkExtractorFactory;
        private final DataSource.Factory dataSourceFactory;
        private final int maxSegmentsPerLoad;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public DashChunkSource createDashChunkSource(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i11, int[] iArr, ExoTrackSelection exoTrackSelection, int i12, long j11, boolean z11, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener) {
            TransferListener transferListener2 = transferListener;
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener2 != null) {
                createDataSource.addTransferListener(transferListener2);
            }
            return new DefaultDashChunkSource(this.chunkExtractorFactory, loaderErrorThrower, dashManifest, i11, iArr, exoTrackSelection, i12, createDataSource, j11, this.maxSegmentsPerLoad, z11, list, playerTrackEmsgHandler);
        }

        public Factory(DataSource.Factory factory, int i11) {
            this(BundledChunkExtractor.FACTORY, factory, i11);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i11) {
            this.chunkExtractorFactory = factory;
            this.dataSourceFactory = factory2;
            this.maxSegmentsPerLoad = i11;
        }
    }

    public static final class RepresentationHolder {
        public final ChunkExtractor chunkExtractor;
        /* access modifiers changed from: private */
        public final long periodDurationUs;
        public final Representation representation;
        public final DashSegmentIndex segmentIndex;
        private final long segmentNumShift;

        public RepresentationHolder(long j11, Representation representation2, ChunkExtractor chunkExtractor2, long j12, DashSegmentIndex dashSegmentIndex) {
            this.periodDurationUs = j11;
            this.representation = representation2;
            this.segmentNumShift = j12;
            this.chunkExtractor = chunkExtractor2;
            this.segmentIndex = dashSegmentIndex;
        }

        public RepresentationHolder copyWithNewRepresentation(long j11, Representation representation2) throws BehindLiveWindowException {
            long j12;
            long j13;
            long j14 = j11;
            DashSegmentIndex index = this.representation.getIndex();
            DashSegmentIndex index2 = representation2.getIndex();
            if (index == null) {
                return new RepresentationHolder(j11, representation2, this.chunkExtractor, this.segmentNumShift, index);
            } else if (!index.isExplicit()) {
                return new RepresentationHolder(j11, representation2, this.chunkExtractor, this.segmentNumShift, index2);
            } else {
                long segmentCount = index.getSegmentCount(j14);
                if (segmentCount == 0) {
                    return new RepresentationHolder(j11, representation2, this.chunkExtractor, this.segmentNumShift, index2);
                }
                long firstSegmentNum = index.getFirstSegmentNum();
                long timeUs = index.getTimeUs(firstSegmentNum);
                long j15 = (segmentCount + firstSegmentNum) - 1;
                long firstSegmentNum2 = index2.getFirstSegmentNum();
                long j16 = firstSegmentNum;
                long timeUs2 = index2.getTimeUs(firstSegmentNum2);
                long j17 = this.segmentNumShift;
                int i11 = ((index.getTimeUs(j15) + index.getDurationUs(j15, j14)) > timeUs2 ? 1 : ((index.getTimeUs(j15) + index.getDurationUs(j15, j14)) == timeUs2 ? 0 : -1));
                if (i11 == 0) {
                    j12 = j17 + ((j15 + 1) - firstSegmentNum2);
                    long j18 = j11;
                } else if (i11 >= 0) {
                    if (timeUs2 < timeUs) {
                        j13 = j17 - (index2.getSegmentNum(timeUs, j11) - j16);
                    } else {
                        j13 = j17 + (index.getSegmentNum(timeUs2, j11) - firstSegmentNum2);
                    }
                    j12 = j13;
                } else {
                    throw new BehindLiveWindowException();
                }
                return new RepresentationHolder(j11, representation2, this.chunkExtractor, j12, index2);
            }
        }

        public RepresentationHolder copyWithNewSegmentIndex(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.periodDurationUs, this.representation, this.chunkExtractor, this.segmentNumShift, dashSegmentIndex);
        }

        public long getFirstAvailableSegmentNum(long j11) {
            return this.segmentIndex.getFirstAvailableSegmentNum(this.periodDurationUs, j11) + this.segmentNumShift;
        }

        public long getFirstSegmentNum() {
            return this.segmentIndex.getFirstSegmentNum() + this.segmentNumShift;
        }

        public long getLastAvailableSegmentNum(long j11) {
            return (getFirstAvailableSegmentNum(j11) + this.segmentIndex.getAvailableSegmentCount(this.periodDurationUs, j11)) - 1;
        }

        public long getSegmentCount() {
            return this.segmentIndex.getSegmentCount(this.periodDurationUs);
        }

        public long getSegmentEndTimeUs(long j11) {
            return getSegmentStartTimeUs(j11) + this.segmentIndex.getDurationUs(j11 - this.segmentNumShift, this.periodDurationUs);
        }

        public long getSegmentNum(long j11) {
            return this.segmentIndex.getSegmentNum(j11, this.periodDurationUs) + this.segmentNumShift;
        }

        public long getSegmentStartTimeUs(long j11) {
            return this.segmentIndex.getTimeUs(j11 - this.segmentNumShift);
        }

        public RangedUri getSegmentUrl(long j11) {
            return this.segmentIndex.getSegmentUrl(j11 - this.segmentNumShift);
        }

        public boolean isSegmentAvailableAtFullNetworkSpeed(long j11, long j12) {
            if (!this.segmentIndex.isExplicit() && j12 != -9223372036854775807L && getSegmentEndTimeUs(j11) > j12) {
                return false;
            }
            return true;
        }
    }

    public static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {
        private final long nowPeriodTimeUs;
        private final RepresentationHolder representationHolder;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder2, long j11, long j12, long j13) {
            super(j11, j12);
            this.representationHolder = representationHolder2;
            this.nowPeriodTimeUs = j13;
        }

        public long getChunkEndTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentEndTimeUs(getCurrentIndex());
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.representationHolder.getSegmentStartTimeUs(getCurrentIndex());
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            long currentIndex = getCurrentIndex();
            return DashUtil.buildDataSpec(this.representationHolder.representation, this.representationHolder.getSegmentUrl(currentIndex), this.representationHolder.isSegmentAvailableAtFullNetworkSpeed(currentIndex, this.nowPeriodTimeUs) ? 0 : 8);
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, int i11, int[] iArr, ExoTrackSelection exoTrackSelection, int i12, DataSource dataSource2, long j11, int i13, boolean z11, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2) {
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = dashManifest;
        this.adaptationSetIndices = iArr;
        this.trackSelection = exoTrackSelection2;
        this.trackType = i12;
        this.dataSource = dataSource2;
        this.periodIndex = i11;
        this.elapsedRealtimeOffsetMs = j11;
        this.maxSegmentsPerLoad = i13;
        this.playerTrackEmsgHandler = playerTrackEmsgHandler2;
        long periodDurationUs = dashManifest.getPeriodDurationUs(i11);
        ArrayList<Representation> representations = getRepresentations();
        this.representationHolders = new RepresentationHolder[exoTrackSelection.length()];
        int i14 = 0;
        while (i14 < this.representationHolders.length) {
            Representation representation = representations.get(exoTrackSelection2.getIndexInTrackGroup(i14));
            int i15 = i14;
            this.representationHolders[i15] = new RepresentationHolder(periodDurationUs, representation, BundledChunkExtractor.FACTORY.createProgressiveMediaExtractor(i12, representation.format, z11, list, playerTrackEmsgHandler2), 0, representation.getIndex());
            i14 = i15 + 1;
            representations = representations;
        }
    }

    private long getAvailableLiveDurationUs(long j11, long j12) {
        if (!this.manifest.dynamic) {
            return -9223372036854775807L;
        }
        return Math.max(0, Math.min(getNowPeriodTimeUs(j11), this.representationHolders[0].getSegmentEndTimeUs(this.representationHolders[0].getLastAvailableSegmentNum(j11))) - j12);
    }

    private long getNowPeriodTimeUs(long j11) {
        DashManifest dashManifest = this.manifest;
        long j12 = dashManifest.availabilityStartTimeMs;
        if (j12 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j11 - C.msToUs(j12 + dashManifest.getPeriod(this.periodIndex).startMs);
    }

    private ArrayList<Representation> getRepresentations() {
        List<AdaptationSet> list = this.manifest.getPeriod(this.periodIndex).adaptationSets;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i11 : this.adaptationSetIndices) {
            arrayList.addAll(list.get(i11).representations);
        }
        return arrayList;
    }

    private long getSegmentNum(RepresentationHolder representationHolder, MediaChunk mediaChunk, long j11, long j12, long j13) {
        if (mediaChunk != null) {
            return mediaChunk.getNextChunkIndex();
        }
        return Util.constrainValue(representationHolder.getSegmentNum(j11), j12, j13);
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        long j12 = j11;
        for (RepresentationHolder representationHolder : this.representationHolders) {
            if (representationHolder.segmentIndex != null) {
                long segmentNum = representationHolder.getSegmentNum(j12);
                long segmentStartTimeUs = representationHolder.getSegmentStartTimeUs(segmentNum);
                long segmentCount = representationHolder.getSegmentCount();
                return seekParameters.resolveSeekPositionUs(j11, segmentStartTimeUs, (segmentStartTimeUs >= j12 || (segmentCount != -1 && segmentNum >= (representationHolder.getFirstSegmentNum() + segmentCount) - 1)) ? segmentStartTimeUs : representationHolder.getSegmentStartTimeUs(segmentNum + 1));
            }
        }
        return j12;
    }

    public void getNextChunk(long j11, long j12, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        MediaChunk mediaChunk;
        int i11;
        MediaChunkIterator[] mediaChunkIteratorArr;
        int i12;
        long j13;
        DefaultDashChunkSource defaultDashChunkSource = this;
        long j14 = j11;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (defaultDashChunkSource.fatalError == null) {
            long j15 = j12 - j14;
            long msToUs = C.msToUs(defaultDashChunkSource.manifest.availabilityStartTimeMs) + C.msToUs(defaultDashChunkSource.manifest.getPeriod(defaultDashChunkSource.periodIndex).startMs) + j12;
            PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = defaultDashChunkSource.playerTrackEmsgHandler;
            if (playerTrackEmsgHandler2 == null || !playerTrackEmsgHandler2.maybeRefreshManifestBeforeLoadingNextChunk(msToUs)) {
                long msToUs2 = C.msToUs(Util.getNowUnixTimeMs(defaultDashChunkSource.elapsedRealtimeOffsetMs));
                long nowPeriodTimeUs = defaultDashChunkSource.getNowPeriodTimeUs(msToUs2);
                boolean z11 = true;
                if (list.isEmpty()) {
                    List<? extends MediaChunk> list2 = list;
                    mediaChunk = null;
                } else {
                    mediaChunk = (MediaChunk) list.get(list.size() - 1);
                }
                int length = defaultDashChunkSource.trackSelection.length();
                MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
                int i13 = 0;
                while (i13 < length) {
                    RepresentationHolder representationHolder = defaultDashChunkSource.representationHolders[i13];
                    if (representationHolder.segmentIndex == null) {
                        mediaChunkIteratorArr2[i13] = MediaChunkIterator.EMPTY;
                        i12 = i13;
                        i11 = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j13 = msToUs2;
                    } else {
                        long firstAvailableSegmentNum = representationHolder.getFirstAvailableSegmentNum(msToUs2);
                        long lastAvailableSegmentNum = representationHolder.getLastAvailableSegmentNum(msToUs2);
                        RepresentationHolder representationHolder2 = representationHolder;
                        i12 = i13;
                        i11 = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        boolean z12 = z11;
                        j13 = msToUs2;
                        long segmentNum = getSegmentNum(representationHolder, mediaChunk, j12, firstAvailableSegmentNum, lastAvailableSegmentNum);
                        if (segmentNum < firstAvailableSegmentNum) {
                            mediaChunkIteratorArr[i12] = MediaChunkIterator.EMPTY;
                        } else {
                            mediaChunkIteratorArr[i12] = new RepresentationSegmentIterator(representationHolder2, segmentNum, lastAvailableSegmentNum, nowPeriodTimeUs);
                        }
                    }
                    i13 = i12 + 1;
                    z11 = true;
                    List<? extends MediaChunk> list3 = list;
                    msToUs2 = j13;
                    mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                    length = i11;
                    defaultDashChunkSource = this;
                }
                long availableLiveDurationUs = defaultDashChunkSource.getAvailableLiveDurationUs(msToUs2, j14);
                long j16 = msToUs2;
                defaultDashChunkSource.trackSelection.updateSelectedTrack(j11, j15, availableLiveDurationUs, list, mediaChunkIteratorArr2);
                RepresentationHolder representationHolder3 = defaultDashChunkSource.representationHolders[defaultDashChunkSource.trackSelection.getSelectedIndex()];
                ChunkExtractor chunkExtractor = representationHolder3.chunkExtractor;
                if (chunkExtractor != null) {
                    Representation representation = representationHolder3.representation;
                    RangedUri initializationUri = chunkExtractor.getSampleFormats() == null ? representation.getInitializationUri() : null;
                    RangedUri indexUri = representationHolder3.segmentIndex == null ? representation.getIndexUri() : null;
                    if (!(initializationUri == null && indexUri == null)) {
                        chunkHolder2.chunk = newInitializationChunk(representationHolder3, defaultDashChunkSource.dataSource, defaultDashChunkSource.trackSelection.getSelectedFormat(), defaultDashChunkSource.trackSelection.getSelectionReason(), defaultDashChunkSource.trackSelection.getSelectionData(), initializationUri, indexUri);
                        return;
                    }
                }
                long access$000 = representationHolder3.periodDurationUs;
                long j17 = -9223372036854775807L;
                int i14 = (access$000 > -9223372036854775807L ? 1 : (access$000 == -9223372036854775807L ? 0 : -1));
                boolean z13 = i14 != 0;
                if (representationHolder3.getSegmentCount() == 0) {
                    chunkHolder2.endOfStream = z13;
                    return;
                }
                long firstAvailableSegmentNum2 = representationHolder3.getFirstAvailableSegmentNum(j16);
                long lastAvailableSegmentNum2 = representationHolder3.getLastAvailableSegmentNum(j16);
                boolean z14 = z13;
                long segmentNum2 = getSegmentNum(representationHolder3, mediaChunk, j12, firstAvailableSegmentNum2, lastAvailableSegmentNum2);
                if (segmentNum2 < firstAvailableSegmentNum2) {
                    defaultDashChunkSource.fatalError = new BehindLiveWindowException();
                    return;
                }
                int i15 = (segmentNum2 > lastAvailableSegmentNum2 ? 1 : (segmentNum2 == lastAvailableSegmentNum2 ? 0 : -1));
                if (i15 > 0 || (defaultDashChunkSource.missingLastSegment && i15 >= 0)) {
                    chunkHolder.endOfStream = z14;
                } else if (!z14 || representationHolder3.getSegmentStartTimeUs(segmentNum2) < access$000) {
                    ChunkHolder chunkHolder3 = chunkHolder;
                    int min = (int) Math.min((long) defaultDashChunkSource.maxSegmentsPerLoad, (lastAvailableSegmentNum2 - segmentNum2) + 1);
                    if (i14 != 0) {
                        while (min > 1 && representationHolder3.getSegmentStartTimeUs((((long) min) + segmentNum2) - 1) >= access$000) {
                            min--;
                        }
                    }
                    int i16 = min;
                    if (list.isEmpty()) {
                        j17 = j12;
                    }
                    chunkHolder3.chunk = newMediaChunk(representationHolder3, defaultDashChunkSource.dataSource, defaultDashChunkSource.trackType, defaultDashChunkSource.trackSelection.getSelectedFormat(), defaultDashChunkSource.trackSelection.getSelectionReason(), defaultDashChunkSource.trackSelection.getSelectionData(), segmentNum2, i16, j17, nowPeriodTimeUs);
                } else {
                    chunkHolder.endOfStream = true;
                }
            }
        }
    }

    public int getPreferredQueueSize(long j11, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j11, list);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public Chunk newInitializationChunk(RepresentationHolder representationHolder, DataSource dataSource2, Format format, int i11, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        Representation representation = representationHolder.representation;
        if (rangedUri == null || (rangedUri2 = rangedUri.attemptMerge(rangedUri2, representation.baseUrl)) != null) {
            rangedUri = rangedUri2;
        }
        return new InitializationChunk(dataSource2, DashUtil.buildDataSpec(representation, rangedUri, 0), format, i11, obj, representationHolder.chunkExtractor);
    }

    public Chunk newMediaChunk(RepresentationHolder representationHolder, DataSource dataSource2, int i11, Format format, int i12, Object obj, long j11, int i13, long j12, long j13) {
        RepresentationHolder representationHolder2 = representationHolder;
        long j14 = j11;
        long j15 = j13;
        Representation representation = representationHolder2.representation;
        long segmentStartTimeUs = representationHolder2.getSegmentStartTimeUs(j14);
        RangedUri segmentUrl = representationHolder2.getSegmentUrl(j14);
        String str = representation.baseUrl;
        if (representationHolder2.chunkExtractor == null) {
            return new SingleSampleMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, segmentUrl, representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j14, j15) ? 0 : 8), format, i12, obj, segmentStartTimeUs, representationHolder2.getSegmentEndTimeUs(j14), j11, i11, format);
        }
        int i14 = 1;
        int i15 = i13;
        int i16 = 1;
        while (i14 < i15) {
            RangedUri attemptMerge = segmentUrl.attemptMerge(representationHolder2.getSegmentUrl(((long) i14) + j14), str);
            if (attemptMerge == null) {
                break;
            }
            i16++;
            i14++;
            segmentUrl = attemptMerge;
        }
        long j16 = (((long) i16) + j14) - 1;
        long segmentEndTimeUs = representationHolder2.getSegmentEndTimeUs(j16);
        long access$000 = representationHolder.periodDurationUs;
        return new ContainerMediaChunk(dataSource2, DashUtil.buildDataSpec(representation, segmentUrl, representationHolder2.isSegmentAvailableAtFullNetworkSpeed(j16, j15) ? 0 : 8), format, i12, obj, segmentStartTimeUs, segmentEndTimeUs, j12, (access$000 == -9223372036854775807L || access$000 > segmentEndTimeUs) ? -9223372036854775807L : access$000, j11, i16, -representation.presentationTimeOffsetUs, representationHolder2.chunkExtractor);
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        ChunkIndex chunkIndex;
        if (chunk instanceof InitializationChunk) {
            int indexOf = this.trackSelection.indexOf(((InitializationChunk) chunk).trackFormat);
            RepresentationHolder representationHolder = this.representationHolders[indexOf];
            if (representationHolder.segmentIndex == null && (chunkIndex = representationHolder.chunkExtractor.getChunkIndex()) != null) {
                this.representationHolders[indexOf] = representationHolder.copyWithNewSegmentIndex(new DashWrappingSegmentIndex(chunkIndex, representationHolder.representation.presentationTimeOffsetUs));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null) {
            playerTrackEmsgHandler2.onChunkLoadCompleted(chunk);
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z11, Exception exc, long j11) {
        if (!z11) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = this.playerTrackEmsgHandler;
        if (playerTrackEmsgHandler2 != null && playerTrackEmsgHandler2.onChunkLoadError(chunk)) {
            return true;
        }
        if (!this.manifest.dynamic && (chunk instanceof MediaChunk) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404) {
            RepresentationHolder representationHolder = this.representationHolders[this.trackSelection.indexOf(chunk.trackFormat)];
            long segmentCount = representationHolder.getSegmentCount();
            if (!(segmentCount == -1 || segmentCount == 0)) {
                if (((MediaChunk) chunk).getNextChunkIndex() > (representationHolder.getFirstSegmentNum() + segmentCount) - 1) {
                    this.missingLastSegment = true;
                    return true;
                }
            }
        }
        if (j11 == -9223372036854775807L) {
            return false;
        }
        ExoTrackSelection exoTrackSelection = this.trackSelection;
        if (exoTrackSelection.blacklist(exoTrackSelection.indexOf(chunk.trackFormat), j11)) {
            return true;
        }
        return false;
    }

    public void release() {
        for (RepresentationHolder representationHolder : this.representationHolders) {
            ChunkExtractor chunkExtractor = representationHolder.chunkExtractor;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }

    public boolean shouldCancelLoad(long j11, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j11, chunk, list);
    }

    public void updateManifest(DashManifest dashManifest, int i11) {
        try {
            this.manifest = dashManifest;
            this.periodIndex = i11;
            long periodDurationUs = dashManifest.getPeriodDurationUs(i11);
            ArrayList<Representation> representations = getRepresentations();
            for (int i12 = 0; i12 < this.representationHolders.length; i12++) {
                RepresentationHolder[] representationHolderArr = this.representationHolders;
                representationHolderArr[i12] = representationHolderArr[i12].copyWithNewRepresentation(periodDurationUs, representations.get(this.trackSelection.getIndexInTrackGroup(i12)));
            }
        } catch (BehindLiveWindowException e11) {
            this.fatalError = e11;
        }
    }

    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }
}
