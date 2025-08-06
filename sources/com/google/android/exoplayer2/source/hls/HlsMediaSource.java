package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public final class HlsMediaSource extends BaseMediaSource implements HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int METADATA_TYPE_EMSG = 3;
    public static final int METADATA_TYPE_ID3 = 1;
    private final boolean allowChunklessPreparation;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final long elapsedRealTimeOffsetMs;
    private final HlsExtractorFactory extractorFactory;
    private MediaItem.LiveConfiguration liveConfiguration;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private TransferListener mediaTransferListener;
    private final int metadataType;
    private final MediaItem.PlaybackProperties playbackProperties;
    private final HlsPlaylistTracker playlistTracker;
    private final boolean useSessionKeys;

    public static final class Factory implements MediaSourceFactory {
        private boolean allowChunklessPreparation;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private long elapsedRealTimeOffsetMs;
        private HlsExtractorFactory extractorFactory;
        private final HlsDataSourceFactory hlsDataSourceFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private int metadataType;
        private HlsPlaylistParserFactory playlistParserFactory;
        private HlsPlaylistTracker.Factory playlistTrackerFactory;
        private List<StreamKey> streamKeys;
        private Object tag;
        private boolean useSessionKeys;
        private boolean usingCustomDrmSessionManagerProvider;

        public Factory(DataSource.Factory factory) {
            this((HlsDataSourceFactory) new DefaultHlsDataSourceFactory(factory));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ DrmSessionManager lambda$setDrmSessionManager$0(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
            return drmSessionManager;
        }

        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        public Factory setAllowChunklessPreparation(boolean z11) {
            this.allowChunklessPreparation = z11;
            return this;
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2) {
            if (compositeSequenceableLoaderFactory2 == null) {
                compositeSequenceableLoaderFactory2 = new DefaultCompositeSequenceableLoaderFactory();
            }
            this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
            return this;
        }

        public Factory setElapsedRealTimeOffsetMs(long j11) {
            this.elapsedRealTimeOffsetMs = j11;
            return this;
        }

        public Factory setExtractorFactory(HlsExtractorFactory hlsExtractorFactory) {
            if (hlsExtractorFactory == null) {
                hlsExtractorFactory = HlsExtractorFactory.DEFAULT;
            }
            this.extractorFactory = hlsExtractorFactory;
            return this;
        }

        public Factory setMetadataType(int i11) {
            this.metadataType = i11;
            return this;
        }

        public Factory setPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
            if (hlsPlaylistParserFactory == null) {
                hlsPlaylistParserFactory = new DefaultHlsPlaylistParserFactory();
            }
            this.playlistParserFactory = hlsPlaylistParserFactory;
            return this;
        }

        public Factory setPlaylistTrackerFactory(HlsPlaylistTracker.Factory factory) {
            if (factory == null) {
                factory = DefaultHlsPlaylistTracker.FACTORY;
            }
            this.playlistTrackerFactory = factory;
            return this;
        }

        @Deprecated
        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Factory setUseSessionKeys(boolean z11) {
            this.useSessionKeys = z11;
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory2) {
            this.hlsDataSourceFactory = (HlsDataSourceFactory) Assertions.checkNotNull(hlsDataSourceFactory2);
            this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            this.playlistParserFactory = new DefaultHlsPlaylistParserFactory();
            this.playlistTrackerFactory = DefaultHlsPlaylistTracker.FACTORY;
            this.extractorFactory = HlsExtractorFactory.DEFAULT;
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
            this.metadataType = 1;
            this.streamKeys = Collections.emptyList();
            this.elapsedRealTimeOffsetMs = -9223372036854775807L;
        }

        public Factory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
            if (!this.usingCustomDrmSessionManagerProvider) {
                ((DefaultDrmSessionManagerProvider) this.drmSessionManagerProvider).setDrmHttpDataSourceFactory(factory);
            }
            return this;
        }

        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            if (drmSessionManager == null) {
                setDrmSessionManagerProvider((DrmSessionManagerProvider) null);
            } else {
                setDrmSessionManagerProvider((DrmSessionManagerProvider) new a(drmSessionManager));
            }
            return this;
        }

        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider2) {
            if (drmSessionManagerProvider2 != null) {
                this.drmSessionManagerProvider = drmSessionManagerProvider2;
                this.usingCustomDrmSessionManagerProvider = true;
            } else {
                this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
                this.usingCustomDrmSessionManagerProvider = false;
            }
            return this;
        }

        public Factory setDrmUserAgent(String str) {
            if (!this.usingCustomDrmSessionManagerProvider) {
                ((DefaultDrmSessionManagerProvider) this.drmSessionManagerProvider).setDrmUserAgent(str);
            }
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            if (loadErrorHandlingPolicy2 == null) {
                loadErrorHandlingPolicy2 = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            return this;
        }

        @Deprecated
        public Factory setStreamKeys(List<StreamKey> list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.streamKeys = list;
            return this;
        }

        @Deprecated
        public HlsMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_M3U8).build());
        }

        public HlsMediaSource createMediaSource(MediaItem mediaItem) {
            List<StreamKey> list;
            MediaItem mediaItem2 = mediaItem;
            Assertions.checkNotNull(mediaItem2.playbackProperties);
            HlsPlaylistParserFactory hlsPlaylistParserFactory = this.playlistParserFactory;
            if (mediaItem2.playbackProperties.streamKeys.isEmpty()) {
                list = this.streamKeys;
            } else {
                list = mediaItem2.playbackProperties.streamKeys;
            }
            if (!list.isEmpty()) {
                hlsPlaylistParserFactory = new FilteringHlsPlaylistParserFactory(hlsPlaylistParserFactory, list);
            }
            MediaItem.PlaybackProperties playbackProperties = mediaItem2.playbackProperties;
            boolean z11 = true;
            boolean z12 = playbackProperties.tag == null && this.tag != null;
            if (!playbackProperties.streamKeys.isEmpty() || list.isEmpty()) {
                z11 = false;
            }
            if (z12 && z11) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.tag).setStreamKeys(list).build();
            } else if (z12) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.tag).build();
            } else if (z11) {
                mediaItem2 = mediaItem.buildUpon().setStreamKeys(list).build();
            }
            MediaItem mediaItem3 = mediaItem2;
            HlsDataSourceFactory hlsDataSourceFactory2 = this.hlsDataSourceFactory;
            HlsExtractorFactory hlsExtractorFactory = this.extractorFactory;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2 = this.compositeSequenceableLoaderFactory;
            DrmSessionManager drmSessionManager = this.drmSessionManagerProvider.get(mediaItem3);
            LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
            return new HlsMediaSource(mediaItem3, hlsDataSourceFactory2, hlsExtractorFactory, compositeSequenceableLoaderFactory2, drmSessionManager, loadErrorHandlingPolicy2, this.playlistTrackerFactory.createTracker(this.hlsDataSourceFactory, loadErrorHandlingPolicy2, hlsPlaylistParserFactory), this.elapsedRealTimeOffsetMs, this.allowChunklessPreparation, this.metadataType, this.useSessionKeys);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    private SinglePeriodTimeline createTimelineForLive(HlsMediaPlaylist hlsMediaPlaylist, long j11, long j12, HlsManifest hlsManifest) {
        long j13;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        long initialStartTimeUs = hlsMediaPlaylist2.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
        long j14 = hlsMediaPlaylist2.hasEndTag ? initialStartTimeUs + hlsMediaPlaylist2.durationUs : -9223372036854775807L;
        long liveEdgeOffsetUs = getLiveEdgeOffsetUs(hlsMediaPlaylist);
        long j15 = this.liveConfiguration.targetOffsetMs;
        if (j15 != -9223372036854775807L) {
            j13 = C.msToUs(j15);
        } else {
            j13 = getTargetLiveOffsetUs(hlsMediaPlaylist2, liveEdgeOffsetUs);
        }
        maybeUpdateLiveConfiguration(Util.constrainValue(j13, liveEdgeOffsetUs, hlsMediaPlaylist2.durationUs + liveEdgeOffsetUs));
        return new SinglePeriodTimeline(j11, j12, -9223372036854775807L, j14, hlsMediaPlaylist2.durationUs, initialStartTimeUs, getLiveWindowDefaultStartPositionUs(hlsMediaPlaylist2, liveEdgeOffsetUs), true, !hlsMediaPlaylist2.hasEndTag, (Object) hlsManifest, this.mediaItem, this.liveConfiguration);
    }

    private SinglePeriodTimeline createTimelineForOnDemand(HlsMediaPlaylist hlsMediaPlaylist, long j11, long j12, HlsManifest hlsManifest) {
        long j13;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        if (hlsMediaPlaylist2.startOffsetUs == -9223372036854775807L || hlsMediaPlaylist2.segments.isEmpty()) {
            j13 = 0;
        } else {
            if (!hlsMediaPlaylist2.preciseStart) {
                long j14 = hlsMediaPlaylist2.startOffsetUs;
                if (j14 != hlsMediaPlaylist2.durationUs) {
                    j13 = findClosestPrecedingSegment(hlsMediaPlaylist2.segments, j14).relativeStartTimeUs;
                }
            }
            j13 = hlsMediaPlaylist2.startOffsetUs;
        }
        long j15 = hlsMediaPlaylist2.durationUs;
        return new SinglePeriodTimeline(j11, j12, -9223372036854775807L, j15, j15, 0, j13, true, false, (Object) hlsManifest, this.mediaItem, (MediaItem.LiveConfiguration) null);
    }

    private static HlsMediaPlaylist.Part findClosestPrecedingIndependentPart(List<HlsMediaPlaylist.Part> list, long j11) {
        HlsMediaPlaylist.Part part = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            HlsMediaPlaylist.Part part2 = list.get(i11);
            long j12 = part2.relativeStartTimeUs;
            if (j12 <= j11 && part2.isIndependent) {
                part = part2;
            } else if (j12 > j11) {
                break;
            }
        }
        return part;
    }

    private static HlsMediaPlaylist.Segment findClosestPrecedingSegment(List<HlsMediaPlaylist.Segment> list, long j11) {
        return list.get(Util.binarySearchFloor(list, Long.valueOf(j11), true, true));
    }

    private long getLiveEdgeOffsetUs(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist.hasProgramDateTime) {
            return C.msToUs(Util.getNowUnixTimeMs(this.elapsedRealTimeOffsetMs)) - hlsMediaPlaylist.getEndTimeUs();
        }
        return 0;
    }

    private long getLiveWindowDefaultStartPositionUs(HlsMediaPlaylist hlsMediaPlaylist, long j11) {
        long j12 = hlsMediaPlaylist.startOffsetUs;
        if (j12 == -9223372036854775807L) {
            j12 = (hlsMediaPlaylist.durationUs + j11) - C.msToUs(this.liveConfiguration.targetOffsetMs);
        }
        if (hlsMediaPlaylist.preciseStart) {
            return j12;
        }
        HlsMediaPlaylist.Part findClosestPrecedingIndependentPart = findClosestPrecedingIndependentPart(hlsMediaPlaylist.trailingParts, j12);
        if (findClosestPrecedingIndependentPart != null) {
            return findClosestPrecedingIndependentPart.relativeStartTimeUs;
        }
        if (hlsMediaPlaylist.segments.isEmpty()) {
            return 0;
        }
        HlsMediaPlaylist.Segment findClosestPrecedingSegment = findClosestPrecedingSegment(hlsMediaPlaylist.segments, j12);
        HlsMediaPlaylist.Part findClosestPrecedingIndependentPart2 = findClosestPrecedingIndependentPart(findClosestPrecedingSegment.parts, j12);
        if (findClosestPrecedingIndependentPart2 != null) {
            return findClosestPrecedingIndependentPart2.relativeStartTimeUs;
        }
        return findClosestPrecedingSegment.relativeStartTimeUs;
    }

    private static long getTargetLiveOffsetUs(HlsMediaPlaylist hlsMediaPlaylist, long j11) {
        long j12;
        HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.serverControl;
        long j13 = hlsMediaPlaylist.startOffsetUs;
        if (j13 != -9223372036854775807L) {
            j12 = hlsMediaPlaylist.durationUs - j13;
        } else {
            long j14 = serverControl.partHoldBackUs;
            if (j14 == -9223372036854775807L || hlsMediaPlaylist.partTargetDurationUs == -9223372036854775807L) {
                long j15 = serverControl.holdBackUs;
                if (j15 != -9223372036854775807L) {
                    j12 = j15;
                } else {
                    j12 = hlsMediaPlaylist.targetDurationUs * 3;
                }
            } else {
                j12 = j14;
            }
        }
        return j12 + j11;
    }

    private void maybeUpdateLiveConfiguration(long j11) {
        long usToMs = C.usToMs(j11);
        if (usToMs != this.liveConfiguration.targetOffsetMs) {
            this.liveConfiguration = this.mediaItem.buildUpon().setLiveTargetOffsetMs(usToMs).build().liveConfiguration;
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.mediaTransferListener, this.drmSessionManager, createDrmEventDispatcher(mediaPeriodId), this.loadErrorHandlingPolicy, createEventDispatcher, allocator, this.compositeSequenceableLoaderFactory, this.allowChunklessPreparation, this.metadataType, this.useSessionKeys);
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Deprecated
    public Object getTag() {
        return this.playbackProperties.tag;
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        SinglePeriodTimeline singlePeriodTimeline;
        long usToMs = hlsMediaPlaylist.hasProgramDateTime ? C.usToMs(hlsMediaPlaylist.startTimeUs) : -9223372036854775807L;
        int i11 = hlsMediaPlaylist.playlistType;
        long j11 = (i11 == 2 || i11 == 1) ? usToMs : -9223372036854775807L;
        HlsManifest hlsManifest = new HlsManifest((HlsMasterPlaylist) Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist()), hlsMediaPlaylist);
        if (this.playlistTracker.isLive()) {
            singlePeriodTimeline = createTimelineForLive(hlsMediaPlaylist, j11, usToMs, hlsManifest);
        } else {
            singlePeriodTimeline = createTimelineForOnDemand(hlsMediaPlaylist, j11, usToMs, hlsManifest);
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.prepare();
        this.playlistTracker.start(this.playbackProperties.uri, createEventDispatcher((MediaSource.MediaPeriodId) null), this);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }

    public void releaseSourceInternal() {
        this.playlistTracker.stop();
        this.drmSessionManager.release();
    }

    private HlsMediaSource(MediaItem mediaItem2, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, HlsPlaylistTracker hlsPlaylistTracker, long j11, boolean z11, int i11, boolean z12) {
        this.playbackProperties = (MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem2.playbackProperties);
        this.mediaItem = mediaItem2;
        this.liveConfiguration = mediaItem2.liveConfiguration;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.playlistTracker = hlsPlaylistTracker;
        this.elapsedRealTimeOffsetMs = j11;
        this.allowChunklessPreparation = z11;
        this.metadataType = i11;
        this.useSessionKeys = z12;
    }
}
