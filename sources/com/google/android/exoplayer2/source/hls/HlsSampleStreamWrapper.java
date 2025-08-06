package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    private static final Set<Integer> MAPPABLE_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_FATAL = -2;
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_NON_FATAL = -3;
    public static final int SAMPLE_QUEUE_INDEX_PENDING = -1;
    private static final String TAG = "HlsSampleStreamWrapper";
    private final Allocator allocator;
    private final Callback callback;
    private final HlsChunkSource chunkSource;
    private Format downstreamTrackFormat;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private DrmInitData drmInitData;
    private final DrmSessionManager drmSessionManager;
    private TrackOutput emsgUnwrappingTrackOutput;
    private int enabledTrackGroupCount;
    private final Handler handler;
    private boolean haveAudioVideoSampleQueues;
    private final ArrayList<HlsSampleStream> hlsSampleStreams;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader = new Loader("Loader:HlsSampleStreamWrapper");
    private Chunk loadingChunk;
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final ArrayList<HlsMediaChunk> mediaChunks;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private final int metadataType;
    private final Format muxedAudioFormat;
    private final HlsChunkSource.HlsChunkHolder nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    private final Runnable onTracksEndedRunnable;
    private Set<TrackGroup> optionalTrackGroups;
    private final Map<String, DrmInitData> overridingDrmInitData;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primarySampleQueueIndex;
    private int primarySampleQueueType;
    private int primaryTrackGroupIndex;
    private final List<HlsMediaChunk> readOnlyMediaChunks;
    private boolean released;
    private long sampleOffsetUs;
    private SparseIntArray sampleQueueIndicesByType;
    private boolean[] sampleQueueIsAudioVideoFlags;
    private Set<Integer> sampleQueueMappingDoneByType;
    private int[] sampleQueueTrackIds = new int[0];
    private HlsSampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private boolean[] sampleQueuesEnabledStates;
    private boolean seenFirstTrackSelection;
    private HlsMediaChunk sourceChunk;
    private int[] trackGroupToSampleQueueIndex;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private Format upstreamTrackFormat;

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(Uri uri);

        void onPrepared();
    }

    public static final class HlsSampleQueue extends SampleQueue {
        private DrmInitData drmInitData;
        private final Map<String, DrmInitData> overridingDrmInitData;

        private Metadata getAdjustedMetadata(Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    i12 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i12);
                if ((entry instanceof PrivFrame) && HlsMediaChunk.PRIV_TIMESTAMP_FRAME_OWNER.equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[(length - 1)];
            while (i11 < length) {
                if (i11 != i12) {
                    entryArr[i11 < i12 ? i11 : i11 - 1] = metadata.get(i11);
                }
                i11++;
            }
            return new Metadata(entryArr);
        }

        public Format getAdjustedUpstreamFormat(Format format) {
            DrmInitData drmInitData2;
            DrmInitData drmInitData3 = this.drmInitData;
            if (drmInitData3 == null) {
                drmInitData3 = format.drmInitData;
            }
            if (!(drmInitData3 == null || (drmInitData2 = this.overridingDrmInitData.get(drmInitData3.schemeType)) == null)) {
                drmInitData3 = drmInitData2;
            }
            Metadata adjustedMetadata = getAdjustedMetadata(format.metadata);
            if (!(drmInitData3 == format.drmInitData && adjustedMetadata == format.metadata)) {
                format = format.buildUpon().setDrmInitData(drmInitData3).setMetadata(adjustedMetadata).build();
            }
            return super.getAdjustedUpstreamFormat(format);
        }

        public void sampleMetadata(long j11, int i11, int i12, int i13, TrackOutput.CryptoData cryptoData) {
            super.sampleMetadata(j11, i11, i12, i13, cryptoData);
        }

        public void setDrmInitData(DrmInitData drmInitData2) {
            this.drmInitData = drmInitData2;
            invalidateUpstreamFormatAdjustment();
        }

        public void setSourceChunk(HlsMediaChunk hlsMediaChunk) {
            sourceId(hlsMediaChunk.uid);
        }

        private HlsSampleQueue(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Map<String, DrmInitData> map) {
            super(allocator, looper, drmSessionManager, eventDispatcher);
            this.overridingDrmInitData = map;
        }
    }

    public HlsSampleStreamWrapper(int i11, Callback callback2, HlsChunkSource hlsChunkSource, Map<String, DrmInitData> map, Allocator allocator2, long j11, Format format, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i12) {
        this.trackType = i11;
        this.callback = callback2;
        this.chunkSource = hlsChunkSource;
        this.overridingDrmInitData = map;
        this.allocator = allocator2;
        this.muxedAudioFormat = format;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.metadataType = i12;
        Set<Integer> set = MAPPABLE_TYPES;
        this.sampleQueueMappingDoneByType = new HashSet(set.size());
        this.sampleQueueIndicesByType = new SparseIntArray(set.size());
        this.sampleQueues = new HlsSampleQueue[0];
        this.sampleQueueIsAudioVideoFlags = new boolean[0];
        this.sampleQueuesEnabledStates = new boolean[0];
        ArrayList<HlsMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList);
        this.hlsSampleStreams = new ArrayList<>();
        this.maybeFinishPrepareRunnable = new d(this);
        this.onTracksEndedRunnable = new c(this);
        this.handler = Util.createHandlerForCurrentLooper();
        this.lastSeekPositionUs = j11;
        this.pendingResetPositionUs = j11;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void assertIsPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackGroups);
        Assertions.checkNotNull(this.optionalTrackGroups);
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void buildTracksFromSampleStreams() {
        int length = this.sampleQueues.length;
        boolean z11 = false;
        int i11 = 7;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            int i14 = 2;
            if (i13 >= length) {
                break;
            }
            String str = ((Format) Assertions.checkStateNotNull(this.sampleQueues[i13].getUpstreamFormat())).sampleMimeType;
            if (!MimeTypes.isVideo(str)) {
                if (MimeTypes.isAudio(str)) {
                    i14 = 1;
                } else {
                    i14 = MimeTypes.isText(str) ? 3 : 7;
                }
            }
            if (getTrackTypeScore(i14) > getTrackTypeScore(i11)) {
                i12 = i13;
                i11 = i14;
            } else if (i14 == i11 && i12 != -1) {
                i12 = -1;
            }
            i13++;
        }
        TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        int i15 = trackGroup.length;
        this.primaryTrackGroupIndex = -1;
        this.trackGroupToSampleQueueIndex = new int[length];
        for (int i16 = 0; i16 < length; i16++) {
            this.trackGroupToSampleQueueIndex[i16] = i16;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i17 = 0; i17 < length; i17++) {
            Format format = (Format) Assertions.checkStateNotNull(this.sampleQueues[i17].getUpstreamFormat());
            if (i17 == i12) {
                Format[] formatArr = new Format[i15];
                if (i15 == 1) {
                    formatArr[0] = format.withManifestFormatInfo(trackGroup.getFormat(0));
                } else {
                    for (int i18 = 0; i18 < i15; i18++) {
                        formatArr[i18] = deriveFormat(trackGroup.getFormat(i18), format, true);
                    }
                }
                trackGroupArr[i17] = new TrackGroup(formatArr);
                this.primaryTrackGroupIndex = i17;
            } else {
                trackGroupArr[i17] = new TrackGroup(deriveFormat((i11 != 2 || !MimeTypes.isAudio(format.sampleMimeType)) ? null : this.muxedAudioFormat, format, false));
            }
        }
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroupArr);
        if (this.optionalTrackGroups == null) {
            z11 = true;
        }
        Assertions.checkState(z11);
        this.optionalTrackGroups = Collections.emptySet();
    }

    private boolean canDiscardUpstreamMediaChunksFromIndex(int i11) {
        for (int i12 = i11; i12 < this.mediaChunks.size(); i12++) {
            if (this.mediaChunks.get(i12).shouldSpliceIn) {
                return false;
            }
        }
        HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(i11);
        for (int i13 = 0; i13 < this.sampleQueues.length; i13++) {
            if (this.sampleQueues[i13].getReadIndex() > hlsMediaChunk.getFirstSampleIndex(i13)) {
                return false;
            }
        }
        return true;
    }

    private static DummyTrackOutput createFakeTrackOutput(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("Unmapped track with id ");
        sb2.append(i11);
        sb2.append(" of type ");
        sb2.append(i12);
        Log.w(TAG, sb2.toString());
        return new DummyTrackOutput();
    }

    private SampleQueue createSampleQueue(int i11, int i12) {
        int length = this.sampleQueues.length;
        boolean z11 = true;
        if (!(i12 == 1 || i12 == 2)) {
            z11 = false;
        }
        HlsSampleQueue hlsSampleQueue = new HlsSampleQueue(this.allocator, this.handler.getLooper(), this.drmSessionManager, this.drmEventDispatcher, this.overridingDrmInitData);
        hlsSampleQueue.setStartTimeUs(this.lastSeekPositionUs);
        if (z11) {
            hlsSampleQueue.setDrmInitData(this.drmInitData);
        }
        hlsSampleQueue.setSampleOffsetUs(this.sampleOffsetUs);
        HlsMediaChunk hlsMediaChunk = this.sourceChunk;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.setSourceChunk(hlsMediaChunk);
        }
        hlsSampleQueue.setUpstreamFormatChangeListener(this);
        int i13 = length + 1;
        int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i13);
        this.sampleQueueTrackIds = copyOf;
        copyOf[length] = i11;
        this.sampleQueues = (HlsSampleQueue[]) Util.nullSafeArrayAppend(this.sampleQueues, hlsSampleQueue);
        boolean[] copyOf2 = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, i13);
        this.sampleQueueIsAudioVideoFlags = copyOf2;
        copyOf2[length] = z11;
        this.haveAudioVideoSampleQueues = copyOf2[length] | this.haveAudioVideoSampleQueues;
        this.sampleQueueMappingDoneByType.add(Integer.valueOf(i12));
        this.sampleQueueIndicesByType.append(i12, length);
        if (getTrackTypeScore(i12) > getTrackTypeScore(this.primarySampleQueueType)) {
            this.primarySampleQueueIndex = length;
            this.primarySampleQueueType = i12;
        }
        this.sampleQueuesEnabledStates = Arrays.copyOf(this.sampleQueuesEnabledStates, i13);
        return hlsSampleQueue;
    }

    private TrackGroupArray createTrackGroupArrayWithDrmInfo(TrackGroup[] trackGroupArr) {
        for (int i11 = 0; i11 < trackGroupArr.length; i11++) {
            TrackGroup trackGroup = trackGroupArr[i11];
            Format[] formatArr = new Format[trackGroup.length];
            for (int i12 = 0; i12 < trackGroup.length; i12++) {
                Format format = trackGroup.getFormat(i12);
                formatArr[i12] = format.copyWithExoMediaCryptoType(this.drmSessionManager.getExoMediaCryptoType(format));
            }
            trackGroupArr[i11] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private static Format deriveFormat(Format format, Format format2, boolean z11) {
        String str;
        String str2;
        if (format == null) {
            return format2;
        }
        int trackType2 = MimeTypes.getTrackType(format2.sampleMimeType);
        if (Util.getCodecCountOfType(format.codecs, trackType2) == 1) {
            str2 = Util.getCodecsOfType(format.codecs, trackType2);
            str = MimeTypes.getMediaMimeType(str2);
        } else {
            str2 = MimeTypes.getCodecsCorrespondingToMimeType(format.codecs, format2.sampleMimeType);
            str = format2.sampleMimeType;
        }
        Format.Builder height = format2.buildUpon().setId(format.f65676id).setLabel(format.label).setLanguage(format.language).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).setAverageBitrate(z11 ? format.averageBitrate : -1).setPeakBitrate(z11 ? format.peakBitrate : -1).setCodecs(str2).setWidth(format.width).setHeight(format.height);
        if (str != null) {
            height.setSampleMimeType(str);
        }
        int i11 = format.channelCount;
        if (i11 != -1) {
            height.setChannelCount(i11);
        }
        Metadata metadata = format.metadata;
        if (metadata != null) {
            Metadata metadata2 = format2.metadata;
            if (metadata2 != null) {
                metadata = metadata2.copyWithAppendedEntriesFrom(metadata);
            }
            height.setMetadata(metadata);
        }
        return height.build();
    }

    private void discardUpstream(int i11) {
        Assertions.checkState(!this.loader.isLoading());
        while (true) {
            if (i11 >= this.mediaChunks.size()) {
                i11 = -1;
                break;
            } else if (canDiscardUpstreamMediaChunksFromIndex(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1) {
            long j11 = getLastMediaChunk().endTimeUs;
            HlsMediaChunk discardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(i11);
            if (this.mediaChunks.isEmpty()) {
                this.pendingResetPositionUs = this.lastSeekPositionUs;
            } else {
                ((HlsMediaChunk) Iterables.getLast(this.mediaChunks)).invalidateExtractor();
            }
            this.loadingFinished = false;
            this.mediaSourceEventDispatcher.upstreamDiscarded(this.primarySampleQueueType, discardUpstreamMediaChunksFromIndex.startTimeUs, j11);
        }
    }

    private HlsMediaChunk discardUpstreamMediaChunksFromIndex(int i11) {
        HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(i11);
        ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, i11, arrayList.size());
        for (int i12 = 0; i12 < this.sampleQueues.length; i12++) {
            this.sampleQueues[i12].discardUpstreamSamples(hlsMediaChunk.getFirstSampleIndex(i12));
        }
        return hlsMediaChunk;
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        int i11 = hlsMediaChunk.uid;
        int length = this.sampleQueues.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (this.sampleQueuesEnabledStates[i12] && this.sampleQueues[i12].peekSourceId() == i11) {
                return false;
            }
        }
        return true;
    }

    private static boolean formatsMatch(Format format, Format format2) {
        String str = format.sampleMimeType;
        String str2 = format2.sampleMimeType;
        int trackType2 = MimeTypes.getTrackType(str);
        if (trackType2 != 3) {
            if (trackType2 == MimeTypes.getTrackType(str2)) {
                return true;
            }
            return false;
        } else if (!Util.areEqual(str, str2)) {
            return false;
        } else {
            if ((MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str)) && format.accessibilityChannel != format2.accessibilityChannel) {
                return false;
            }
            return true;
        }
    }

    private HlsMediaChunk getLastMediaChunk() {
        ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
        return arrayList.get(arrayList.size() - 1);
    }

    private TrackOutput getMappedTrackOutput(int i11, int i12) {
        Assertions.checkArgument(MAPPABLE_TYPES.contains(Integer.valueOf(i12)));
        int i13 = this.sampleQueueIndicesByType.get(i12, -1);
        if (i13 == -1) {
            return null;
        }
        if (this.sampleQueueMappingDoneByType.add(Integer.valueOf(i12))) {
            this.sampleQueueTrackIds[i13] = i11;
        }
        if (this.sampleQueueTrackIds[i13] == i11) {
            return this.sampleQueues[i13];
        }
        return createFakeTrackOutput(i11, i12);
    }

    private static int getTrackTypeScore(int i11) {
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 0 : 1;
        }
        return 3;
    }

    private void initMediaChunkLoad(HlsMediaChunk hlsMediaChunk) {
        this.sourceChunk = hlsMediaChunk;
        this.upstreamTrackFormat = hlsMediaChunk.trackFormat;
        this.pendingResetPositionUs = -9223372036854775807L;
        this.mediaChunks.add(hlsMediaChunk);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (HlsSampleQueue writeIndex : this.sampleQueues) {
            builder.add((Object) Integer.valueOf(writeIndex.getWriteIndex()));
        }
        hlsMediaChunk.init(this, builder.build());
        for (HlsSampleQueue hlsSampleQueue : this.sampleQueues) {
            hlsSampleQueue.setSourceChunk(hlsMediaChunk);
            if (hlsMediaChunk.shouldSpliceIn) {
                hlsSampleQueue.splice();
            }
        }
    }

    private static boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    @RequiresNonNull({"trackGroups"})
    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    private void mapSampleQueuesToMatchTrackGroups() {
        int i11 = this.trackGroups.length;
        int[] iArr = new int[i11];
        this.trackGroupToSampleQueueIndex = iArr;
        Arrays.fill(iArr, -1);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
                if (i13 >= hlsSampleQueueArr.length) {
                    break;
                } else if (formatsMatch((Format) Assertions.checkStateNotNull(hlsSampleQueueArr[i13].getUpstreamFormat()), this.trackGroups.get(i12).getFormat(0))) {
                    this.trackGroupToSampleQueueIndex[i12] = i13;
                    break;
                } else {
                    i13++;
                }
            }
        }
        Iterator<HlsSampleStream> it2 = this.hlsSampleStreams.iterator();
        while (it2.hasNext()) {
            it2.next().bindSampleQueue();
        }
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && this.trackGroupToSampleQueueIndex == null && this.sampleQueuesBuilt) {
            HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
            int length = hlsSampleQueueArr.length;
            int i11 = 0;
            while (i11 < length) {
                if (hlsSampleQueueArr[i11].getUpstreamFormat() != null) {
                    i11++;
                } else {
                    return;
                }
            }
            if (this.trackGroups != null) {
                mapSampleQueuesToMatchTrackGroups();
                return;
            }
            buildTracksFromSampleStreams();
            setIsPrepared();
            this.callback.onPrepared();
        }
    }

    /* access modifiers changed from: private */
    public void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    private void resetSampleQueues() {
        for (HlsSampleQueue reset : this.sampleQueues) {
            reset.reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
    }

    private boolean seekInsideBufferUs(long j11) {
        int length = this.sampleQueues.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!this.sampleQueues[i11].seekTo(j11, false) && (this.sampleQueueIsAudioVideoFlags[i11] || !this.haveAudioVideoSampleQueues)) {
                return false;
            }
        }
        return true;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void setIsPrepared() {
        this.prepared = true;
    }

    private void updateSampleStreams(SampleStream[] sampleStreamArr) {
        this.hlsSampleStreams.clear();
        for (HlsSampleStream hlsSampleStream : sampleStreamArr) {
            if (hlsSampleStream != null) {
                this.hlsSampleStreams.add(hlsSampleStream);
            }
        }
    }

    public int bindSampleQueueToSampleStream(int i11) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i12 = this.trackGroupToSampleQueueIndex[i11];
        if (i12 != -1) {
            boolean[] zArr = this.sampleQueuesEnabledStates;
            if (zArr[i12]) {
                return -2;
            }
            zArr[i12] = true;
            return i12;
        } else if (this.optionalTrackGroups.contains(this.trackGroups.get(i11))) {
            return -3;
        } else {
            return -2;
        }
    }

    public boolean continueLoading(long j11) {
        long j12;
        List<HlsMediaChunk> list;
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        if (isPendingReset()) {
            list = Collections.emptyList();
            j12 = this.pendingResetPositionUs;
            for (HlsSampleQueue startTimeUs : this.sampleQueues) {
                startTimeUs.setStartTimeUs(this.pendingResetPositionUs);
            }
        } else {
            list = this.readOnlyMediaChunks;
            HlsMediaChunk lastMediaChunk = getLastMediaChunk();
            if (lastMediaChunk.isLoadCompleted()) {
                j12 = lastMediaChunk.endTimeUs;
            } else {
                j12 = Math.max(this.lastSeekPositionUs, lastMediaChunk.startTimeUs);
            }
        }
        List<HlsMediaChunk> list2 = list;
        long j13 = j12;
        this.nextChunkHolder.clear();
        this.chunkSource.getNextChunk(j11, j13, list2, this.prepared || !list2.isEmpty(), this.nextChunkHolder);
        HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.nextChunkHolder;
        boolean z11 = hlsChunkHolder.endOfStream;
        Chunk chunk = hlsChunkHolder.chunk;
        Uri uri = hlsChunkHolder.playlistUrl;
        if (z11) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            if (uri != null) {
                this.callback.onPlaylistRefreshRequired(uri);
            }
            return false;
        } else {
            if (isMediaChunk(chunk)) {
                initMediaChunkLoad((HlsMediaChunk) chunk);
            }
            this.loadingChunk = chunk;
            this.mediaSourceEventDispatcher.loadStarted(new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
            return true;
        }
    }

    public void continuePreparing() {
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        }
    }

    public void discardBuffer(long j11, boolean z11) {
        if (this.sampleQueuesBuilt && !isPendingReset()) {
            int length = this.sampleQueues.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.sampleQueues[i11].discardTo(j11, z11, this.sampleQueuesEnabledStates[i11]);
            }
        }
    }

    public void endTracks() {
        this.tracksEnded = true;
        this.handler.post(this.onTracksEndedRunnable);
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j11 = this.lastSeekPositionUs;
        HlsMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
                lastMediaChunk = arrayList.get(arrayList.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j11 = Math.max(j11, lastMediaChunk.endTimeUs);
        }
        if (this.sampleQueuesBuilt) {
            for (HlsSampleQueue largestQueuedTimestampUs : this.sampleQueues) {
                j11 = Math.max(j11, largestQueuedTimestampUs.getLargestQueuedTimestampUs());
            }
        }
        return j11;
    }

    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    public int getPrimaryTrackGroupIndex() {
        return this.primaryTrackGroupIndex;
    }

    public TrackGroupArray getTrackGroups() {
        assertIsPrepared();
        return this.trackGroups;
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public boolean isReady(int i11) {
        return !isPendingReset() && this.sampleQueues[i11].isReady(this.loadingFinished);
    }

    public void maybeThrowError(int i11) throws IOException {
        maybeThrowError();
        this.sampleQueues[i11].maybeThrowError();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public void onLoaderReleased() {
        for (HlsSampleQueue release : this.sampleQueues) {
            release.release();
        }
    }

    public void onNewExtractor() {
        this.sampleQueueMappingDoneByType.clear();
    }

    public boolean onPlaylistError(Uri uri, long j11) {
        return this.chunkSource.onPlaylistError(uri, j11);
    }

    public void onPlaylistUpdated() {
        if (!this.mediaChunks.isEmpty()) {
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.getLast(this.mediaChunks);
            int chunkPublicationState = this.chunkSource.getChunkPublicationState(hlsMediaChunk);
            if (chunkPublicationState == 1) {
                hlsMediaChunk.publish();
            } else if (chunkPublicationState == 2 && !this.loadingFinished && this.loader.isLoading()) {
                this.loader.cancelLoading();
            }
        }
    }

    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void prepareWithMasterPlaylistInfo(TrackGroup[] trackGroupArr, int i11, int... iArr) {
        this.trackGroups = createTrackGroupArrayWithDrmInfo(trackGroupArr);
        this.optionalTrackGroups = new HashSet();
        for (int i12 : iArr) {
            this.optionalTrackGroups.add(this.trackGroups.get(i12));
        }
        this.primaryTrackGroupIndex = i11;
        Handler handler2 = this.handler;
        Callback callback2 = this.callback;
        Objects.requireNonNull(callback2);
        handler2.post(new b(callback2));
        setIsPrepared();
    }

    public int readData(int i11, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i12) {
        Format format;
        if (isPendingReset()) {
            return -3;
        }
        int i13 = 0;
        if (!this.mediaChunks.isEmpty()) {
            int i14 = 0;
            while (i14 < this.mediaChunks.size() - 1 && finishedReadingChunk(this.mediaChunks.get(i14))) {
                i14++;
            }
            Util.removeRange(this.mediaChunks, 0, i14);
            HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(0);
            Format format2 = hlsMediaChunk.trackFormat;
            if (!format2.equals(this.downstreamTrackFormat)) {
                this.mediaSourceEventDispatcher.downstreamFormatChanged(this.trackType, format2, hlsMediaChunk.trackSelectionReason, hlsMediaChunk.trackSelectionData, hlsMediaChunk.startTimeUs);
            }
            this.downstreamTrackFormat = format2;
        }
        if (!this.mediaChunks.isEmpty() && !this.mediaChunks.get(0).isPublished()) {
            return -3;
        }
        int read = this.sampleQueues[i11].read(formatHolder, decoderInputBuffer, i12, this.loadingFinished);
        if (read == -5) {
            Format format3 = (Format) Assertions.checkNotNull(formatHolder.format);
            if (i11 == this.primarySampleQueueIndex) {
                int peekSourceId = this.sampleQueues[i11].peekSourceId();
                while (i13 < this.mediaChunks.size() && this.mediaChunks.get(i13).uid != peekSourceId) {
                    i13++;
                }
                if (i13 < this.mediaChunks.size()) {
                    format = this.mediaChunks.get(i13).trackFormat;
                } else {
                    format = (Format) Assertions.checkNotNull(this.upstreamTrackFormat);
                }
                format3 = format3.withManifestFormatInfo(format);
            }
            formatHolder.format = format3;
        }
        return read;
    }

    public void reevaluateBuffer(long j11) {
        if (!this.loader.hasFatalError() && !isPendingReset()) {
            if (this.loader.isLoading()) {
                Assertions.checkNotNull(this.loadingChunk);
                if (this.chunkSource.shouldCancelLoad(j11, this.loadingChunk, this.readOnlyMediaChunks)) {
                    this.loader.cancelLoading();
                    return;
                }
                return;
            }
            int size = this.readOnlyMediaChunks.size();
            while (size > 0 && this.chunkSource.getChunkPublicationState(this.readOnlyMediaChunks.get(size - 1)) == 2) {
                size--;
            }
            if (size < this.readOnlyMediaChunks.size()) {
                discardUpstream(size);
            }
            int preferredQueueSize = this.chunkSource.getPreferredQueueSize(j11, this.readOnlyMediaChunks);
            if (preferredQueueSize < this.mediaChunks.size()) {
                discardUpstream(preferredQueueSize);
            }
        }
    }

    public void release() {
        if (this.prepared) {
            for (HlsSampleQueue preRelease : this.sampleQueues) {
                preRelease.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages((Object) null);
        this.released = true;
        this.hlsSampleStreams.clear();
    }

    public void seekMap(SeekMap seekMap) {
    }

    public boolean seekToUs(long j11, boolean z11) {
        this.lastSeekPositionUs = j11;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j11;
            return true;
        }
        if (this.sampleQueuesBuilt && !z11 && seekInsideBufferUs(j11)) {
            return false;
        }
        this.pendingResetPositionUs = j11;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            if (this.sampleQueuesBuilt) {
                for (HlsSampleQueue discardToEnd : this.sampleQueues) {
                    discardToEnd.discardToEnd();
                }
            }
            this.loader.cancelLoading();
        } else {
            this.loader.clearFatalError();
            resetSampleQueues();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r20, boolean[] r21, com.google.android.exoplayer2.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            r12 = r24
            r19.assertIsPrepared()
            int r3 = r0.enabledTrackGroupCount
            r14 = 0
            r4 = r14
        L_0x000f:
            int r5 = r1.length
            r6 = 0
            r15 = 1
            if (r4 >= r5) goto L_0x002f
            r5 = r2[r4]
            com.google.android.exoplayer2.source.hls.HlsSampleStream r5 = (com.google.android.exoplayer2.source.hls.HlsSampleStream) r5
            if (r5 == 0) goto L_0x002c
            r7 = r1[r4]
            if (r7 == 0) goto L_0x0022
            boolean r7 = r21[r4]
            if (r7 != 0) goto L_0x002c
        L_0x0022:
            int r7 = r0.enabledTrackGroupCount
            int r7 = r7 - r15
            r0.enabledTrackGroupCount = r7
            r5.unbindSampleQueue()
            r2[r4] = r6
        L_0x002c:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x002f:
            if (r26 != 0) goto L_0x0041
            boolean r4 = r0.seenFirstTrackSelection
            if (r4 == 0) goto L_0x0038
            if (r3 != 0) goto L_0x003f
            goto L_0x0041
        L_0x0038:
            long r3 = r0.lastSeekPositionUs
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r3 = r14
            goto L_0x0042
        L_0x0041:
            r3 = r15
        L_0x0042:
            com.google.android.exoplayer2.source.hls.HlsChunkSource r4 = r0.chunkSource
            com.google.android.exoplayer2.trackselection.ExoTrackSelection r4 = r4.getTrackSelection()
            r16 = r3
            r11 = r4
            r3 = r14
        L_0x004c:
            int r5 = r1.length
            if (r3 >= r5) goto L_0x00a3
            r5 = r1[r3]
            if (r5 != 0) goto L_0x0054
            goto L_0x00a0
        L_0x0054:
            com.google.android.exoplayer2.source.TrackGroupArray r7 = r0.trackGroups
            com.google.android.exoplayer2.source.TrackGroup r8 = r5.getTrackGroup()
            int r7 = r7.indexOf(r8)
            int r8 = r0.primaryTrackGroupIndex
            if (r7 != r8) goto L_0x0068
            com.google.android.exoplayer2.source.hls.HlsChunkSource r8 = r0.chunkSource
            r8.setTrackSelection(r5)
            r11 = r5
        L_0x0068:
            r5 = r2[r3]
            if (r5 != 0) goto L_0x00a0
            int r5 = r0.enabledTrackGroupCount
            int r5 = r5 + r15
            r0.enabledTrackGroupCount = r5
            com.google.android.exoplayer2.source.hls.HlsSampleStream r5 = new com.google.android.exoplayer2.source.hls.HlsSampleStream
            r5.<init>(r0, r7)
            r2[r3] = r5
            r23[r3] = r15
            int[] r5 = r0.trackGroupToSampleQueueIndex
            if (r5 == 0) goto L_0x00a0
            r5 = r2[r3]
            com.google.android.exoplayer2.source.hls.HlsSampleStream r5 = (com.google.android.exoplayer2.source.hls.HlsSampleStream) r5
            r5.bindSampleQueue()
            if (r16 != 0) goto L_0x00a0
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r5 = r0.sampleQueues
            int[] r8 = r0.trackGroupToSampleQueueIndex
            r7 = r8[r7]
            r5 = r5[r7]
            boolean r7 = r5.seekTo(r12, r15)
            if (r7 != 0) goto L_0x009d
            int r5 = r5.getReadIndex()
            if (r5 == 0) goto L_0x009d
            r5 = r15
            goto L_0x009e
        L_0x009d:
            r5 = r14
        L_0x009e:
            r16 = r5
        L_0x00a0:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x00a3:
            int r1 = r0.enabledTrackGroupCount
            if (r1 != 0) goto L_0x00da
            com.google.android.exoplayer2.source.hls.HlsChunkSource r1 = r0.chunkSource
            r1.reset()
            r0.downstreamTrackFormat = r6
            r0.pendingResetUpstreamFormats = r15
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r1 = r0.mediaChunks
            r1.clear()
            com.google.android.exoplayer2.upstream.Loader r1 = r0.loader
            boolean r1 = r1.isLoading()
            if (r1 == 0) goto L_0x00d5
            boolean r1 = r0.sampleQueuesBuilt
            if (r1 == 0) goto L_0x00ce
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r1 = r0.sampleQueues
            int r3 = r1.length
        L_0x00c4:
            if (r14 >= r3) goto L_0x00ce
            r4 = r1[r14]
            r4.discardToEnd()
            int r14 = r14 + 1
            goto L_0x00c4
        L_0x00ce:
            com.google.android.exoplayer2.upstream.Loader r1 = r0.loader
            r1.cancelLoading()
            goto L_0x0140
        L_0x00d5:
            r19.resetSampleQueues()
            goto L_0x0140
        L_0x00da:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r1 = r0.mediaChunks
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x012d
            boolean r1 = com.google.android.exoplayer2.util.Util.areEqual(r11, r4)
            if (r1 != 0) goto L_0x012d
            boolean r1 = r0.seenFirstTrackSelection
            if (r1 != 0) goto L_0x0124
            r3 = 0
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f3
            long r3 = -r12
        L_0x00f3:
            r6 = r3
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r1 = r19.getLastMediaChunk()
            com.google.android.exoplayer2.source.hls.HlsChunkSource r3 = r0.chunkSource
            com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] r17 = r3.createMediaChunkIterators(r1, r12)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r10 = r0.readOnlyMediaChunks
            r3 = r11
            r4 = r24
            r18 = r11
            r11 = r17
            r3.updateSelectedTrack(r4, r6, r8, r10, r11)
            com.google.android.exoplayer2.source.hls.HlsChunkSource r3 = r0.chunkSource
            com.google.android.exoplayer2.source.TrackGroup r3 = r3.getTrackGroup()
            com.google.android.exoplayer2.Format r1 = r1.trackFormat
            int r1 = r3.indexOf(r1)
            int r3 = r18.getSelectedIndexInTrackGroup()
            if (r3 == r1) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r1 = r14
            goto L_0x0125
        L_0x0124:
            r1 = r15
        L_0x0125:
            if (r1 == 0) goto L_0x012d
            r0.pendingResetUpstreamFormats = r15
            r1 = r15
            r16 = r1
            goto L_0x012f
        L_0x012d:
            r1 = r26
        L_0x012f:
            if (r16 == 0) goto L_0x0140
            r0.seekToUs(r12, r1)
        L_0x0134:
            int r1 = r2.length
            if (r14 >= r1) goto L_0x0140
            r1 = r2[r14]
            if (r1 == 0) goto L_0x013d
            r23[r14] = r15
        L_0x013d:
            int r14 = r14 + 1
            goto L_0x0134
        L_0x0140:
            r0.updateSampleStreams(r2)
            r0.seenFirstTrackSelection = r15
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void setDrmInitData(DrmInitData drmInitData2) {
        if (!Util.areEqual(this.drmInitData, drmInitData2)) {
            this.drmInitData = drmInitData2;
            int i11 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.sampleQueues;
                if (i11 < hlsSampleQueueArr.length) {
                    if (this.sampleQueueIsAudioVideoFlags[i11]) {
                        hlsSampleQueueArr[i11].setDrmInitData(drmInitData2);
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public void setIsTimestampMaster(boolean z11) {
        this.chunkSource.setIsTimestampMaster(z11);
    }

    public void setSampleOffsetUs(long j11) {
        if (this.sampleOffsetUs != j11) {
            this.sampleOffsetUs = j11;
            for (HlsSampleQueue sampleOffsetUs2 : this.sampleQueues) {
                sampleOffsetUs2.setSampleOffsetUs(j11);
            }
        }
    }

    public int skipData(int i11, long j11) {
        if (isPendingReset()) {
            return 0;
        }
        HlsSampleQueue hlsSampleQueue = this.sampleQueues[i11];
        int skipCount = hlsSampleQueue.getSkipCount(j11, this.loadingFinished);
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.getLast(this.mediaChunks, null);
        if (hlsMediaChunk != null && !hlsMediaChunk.isPublished()) {
            skipCount = Math.min(skipCount, hlsMediaChunk.getFirstSampleIndex(i11) - hlsSampleQueue.getReadIndex());
        }
        hlsSampleQueue.skip(skipCount);
        return skipCount;
    }

    public TrackOutput track(int i11, int i12) {
        TrackOutput trackOutput;
        if (!MAPPABLE_TYPES.contains(Integer.valueOf(i12))) {
            int i13 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.sampleQueues;
                if (i13 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                } else if (this.sampleQueueTrackIds[i13] == i11) {
                    trackOutput = trackOutputArr[i13];
                    break;
                } else {
                    i13++;
                }
            }
        } else {
            trackOutput = getMappedTrackOutput(i11, i12);
        }
        if (trackOutput == null) {
            if (this.tracksEnded) {
                return createFakeTrackOutput(i11, i12);
            }
            trackOutput = createSampleQueue(i11, i12);
        }
        if (i12 != 5) {
            return trackOutput;
        }
        if (this.emsgUnwrappingTrackOutput == null) {
            this.emsgUnwrappingTrackOutput = new EmsgUnwrappingTrackOutput(trackOutput, this.metadataType);
        }
        return this.emsgUnwrappingTrackOutput;
    }

    public void unbindSampleQueue(int i11) {
        assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int i12 = this.trackGroupToSampleQueueIndex[i11];
        Assertions.checkState(this.sampleQueuesEnabledStates[i12]);
        this.sampleQueuesEnabledStates[i12] = false;
    }

    public void onLoadCanceled(Chunk chunk, long j11, long j12, boolean z11) {
        Chunk chunk2 = chunk;
        this.loadingChunk = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j11, j12, chunk.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        this.mediaSourceEventDispatcher.loadCanceled(loadEventInfo, chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs);
        if (!z11) {
            if (isPendingReset() || this.enabledTrackGroupCount == 0) {
                resetSampleQueues();
            }
            if (this.enabledTrackGroupCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    public void onLoadCompleted(Chunk chunk, long j11, long j12) {
        Chunk chunk2 = chunk;
        this.loadingChunk = null;
        this.chunkSource.onChunkLoadCompleted(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j11, j12, chunk.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        this.mediaSourceEventDispatcher.loadCompleted(loadEventInfo, chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs);
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public Loader.LoadErrorAction onLoadError(Chunk chunk, long j11, long j12, IOException iOException, int i11) {
        Loader.LoadErrorAction loadErrorAction;
        int i12;
        Chunk chunk2 = chunk;
        IOException iOException2 = iOException;
        boolean isMediaChunk = isMediaChunk(chunk);
        if (isMediaChunk && !((HlsMediaChunk) chunk2).isPublished() && (iOException2 instanceof HttpDataSource.InvalidResponseCodeException) && ((i12 = ((HttpDataSource.InvalidResponseCodeException) iOException2).responseCode) == 410 || i12 == 404)) {
            return Loader.RETRY;
        }
        long bytesLoaded = chunk.bytesLoaded();
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j11, j12, bytesLoaded);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, C.usToMs(chunk2.startTimeUs), C.usToMs(chunk2.endTimeUs)), iOException2, i11);
        long blacklistDurationMsFor = this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(loadErrorInfo);
        boolean z11 = false;
        boolean maybeExcludeTrack = blacklistDurationMsFor != -9223372036854775807L ? this.chunkSource.maybeExcludeTrack(chunk2, blacklistDurationMsFor) : false;
        if (maybeExcludeTrack) {
            if (isMediaChunk && bytesLoaded == 0) {
                ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
                if (arrayList.remove(arrayList.size() - 1) == chunk2) {
                    z11 = true;
                }
                Assertions.checkState(z11);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                } else {
                    ((HlsMediaChunk) Iterables.getLast(this.mediaChunks)).invalidateExtractor();
                }
            }
            loadErrorAction = Loader.DONT_RETRY;
        } else {
            long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorInfo);
            if (retryDelayMsFor != -9223372036854775807L) {
                loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
            } else {
                loadErrorAction = Loader.DONT_RETRY_FATAL;
            }
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z12 = !loadErrorAction2.isRetry();
        this.mediaSourceEventDispatcher.loadError(loadEventInfo, chunk2.type, this.trackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs, iOException, z12);
        if (z12) {
            this.loadingChunk = null;
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        }
        if (maybeExcludeTrack) {
            if (!this.prepared) {
                continueLoading(this.lastSeekPositionUs);
            } else {
                this.callback.onContinueLoadingRequested(this);
            }
        }
        return loadErrorAction2;
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public static class EmsgUnwrappingTrackOutput implements TrackOutput {
        private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();
        private static final Format ID3_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_ID3).build();
        private static final String TAG = "EmsgUnwrappingTrackOutput";
        private byte[] buffer;
        private int bufferPosition;
        private final TrackOutput delegate;
        private final Format delegateFormat;
        private final EventMessageDecoder emsgDecoder = new EventMessageDecoder();
        private Format format;

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput, int i11) {
            this.delegate = trackOutput;
            if (i11 == 1) {
                this.delegateFormat = ID3_FORMAT;
            } else if (i11 == 3) {
                this.delegateFormat = EMSG_FORMAT;
            } else {
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Unknown metadataType: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            }
            this.buffer = new byte[0];
            this.bufferPosition = 0;
        }

        private boolean emsgContainsExpectedWrappedFormat(EventMessage eventMessage) {
            Format wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && Util.areEqual(this.delegateFormat.sampleMimeType, wrappedMetadataFormat.sampleMimeType);
        }

        private void ensureBufferCapacity(int i11) {
            byte[] bArr = this.buffer;
            if (bArr.length < i11) {
                this.buffer = Arrays.copyOf(bArr, i11 + (i11 / 2));
            }
        }

        private ParsableByteArray getSampleAndTrimBuffer(int i11, int i12) {
            int i13 = this.bufferPosition - i12;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.buffer, i13 - i11, i13));
            byte[] bArr = this.buffer;
            System.arraycopy(bArr, i13, bArr, 0, i12);
            this.bufferPosition = i12;
            return parsableByteArray;
        }

        public void format(Format format2) {
            this.format = format2;
            this.delegate.format(this.delegateFormat);
        }

        public /* synthetic */ int sampleData(DataReader dataReader, int i11, boolean z11) {
            return d.a(this, dataReader, i11, z11);
        }

        public int sampleData(DataReader dataReader, int i11, boolean z11, int i12) throws IOException {
            ensureBufferCapacity(this.bufferPosition + i11);
            int read = dataReader.read(this.buffer, this.bufferPosition, i11);
            if (read != -1) {
                this.bufferPosition += read;
                return read;
            } else if (z11) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i11) {
            d.b(this, parsableByteArray, i11);
        }

        public void sampleMetadata(long j11, int i11, int i12, int i13, TrackOutput.CryptoData cryptoData) {
            Assertions.checkNotNull(this.format);
            ParsableByteArray sampleAndTrimBuffer = getSampleAndTrimBuffer(i12, i13);
            if (!Util.areEqual(this.format.sampleMimeType, this.delegateFormat.sampleMimeType)) {
                if (MimeTypes.APPLICATION_EMSG.equals(this.format.sampleMimeType)) {
                    EventMessage decode = this.emsgDecoder.decode(sampleAndTrimBuffer);
                    if (!emsgContainsExpectedWrappedFormat(decode)) {
                        Log.w(TAG, String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.delegateFormat.sampleMimeType, decode.getWrappedMetadataFormat()}));
                        return;
                    }
                    sampleAndTrimBuffer = new ParsableByteArray((byte[]) Assertions.checkNotNull(decode.getWrappedMetadataBytes()));
                } else {
                    String valueOf = String.valueOf(this.format.sampleMimeType);
                    Log.w(TAG, valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new String("Ignoring sample for unsupported format: "));
                    return;
                }
            }
            int bytesLeft = sampleAndTrimBuffer.bytesLeft();
            this.delegate.sampleData(sampleAndTrimBuffer, bytesLeft);
            this.delegate.sampleMetadata(j11, i11, bytesLeft, i13, cryptoData);
        }

        public void sampleData(ParsableByteArray parsableByteArray, int i11, int i12) {
            ensureBufferCapacity(this.bufferPosition + i11);
            parsableByteArray.readBytes(this.buffer, this.bufferPosition, i11);
            this.bufferPosition += i11;
        }
    }
}
