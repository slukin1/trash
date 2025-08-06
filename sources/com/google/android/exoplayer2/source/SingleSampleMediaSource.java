package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;

public final class SingleSampleMediaSource extends BaseMediaSource {
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private final Timeline timeline;
    private TransferListener transferListener;
    private final boolean treatLoadErrorsAsEndOfStream;

    public static final class Factory {
        private final DataSource.Factory dataSourceFactory;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        private Object tag;
        private String trackId;
        private boolean treatLoadErrorsAsEndOfStream = true;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public SingleSampleMediaSource createMediaSource(MediaItem.Subtitle subtitle, long j11) {
            return new SingleSampleMediaSource(this.trackId, subtitle, this.dataSourceFactory, j11, this.loadErrorHandlingPolicy, this.treatLoadErrorsAsEndOfStream, this.tag);
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            if (loadErrorHandlingPolicy2 == null) {
                loadErrorHandlingPolicy2 = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            return this;
        }

        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Factory setTrackId(String str) {
            this.trackId = str;
            return this;
        }

        public Factory setTreatLoadErrorsAsEndOfStream(boolean z11) {
            this.treatLoadErrorsAsEndOfStream = z11;
            return this;
        }

        @Deprecated
        public SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j11) {
            String str = format.f65676id;
            if (str == null) {
                str = this.trackId;
            }
            return new SingleSampleMediaSource(str, new MediaItem.Subtitle(uri, (String) Assertions.checkNotNull(format.sampleMimeType), format.language, format.selectionFlags), this.dataSourceFactory, j11, this.loadErrorHandlingPolicy, this.treatLoadErrorsAsEndOfStream, this.tag);
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        return new SingleSampleMediaPeriod(this.dataSpec, this.dataSourceFactory, this.transferListener, this.format, this.durationUs, this.loadErrorHandlingPolicy, createEventDispatcher(mediaPeriodId), this.treatLoadErrorsAsEndOfStream);
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Deprecated
    public Object getTag() {
        return ((MediaItem.PlaybackProperties) Util.castNonNull(this.mediaItem.playbackProperties)).tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void prepareSourceInternal(TransferListener transferListener2) {
        this.transferListener = transferListener2;
        refreshSourceInfo(this.timeline);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).release();
    }

    public void releaseSourceInternal() {
    }

    private SingleSampleMediaSource(String str, MediaItem.Subtitle subtitle, DataSource.Factory factory, long j11, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, boolean z11, Object obj) {
        MediaItem.Subtitle subtitle2 = subtitle;
        this.dataSourceFactory = factory;
        long j12 = j11;
        this.durationUs = j12;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.treatLoadErrorsAsEndOfStream = z11;
        MediaItem build = new MediaItem.Builder().setUri(Uri.EMPTY).setMediaId(subtitle2.uri.toString()).setSubtitles(Collections.singletonList(subtitle)).setTag(obj).build();
        this.mediaItem = build;
        String str2 = str;
        this.format = new Format.Builder().setId(str).setSampleMimeType(subtitle2.mimeType).setLanguage(subtitle2.language).setSelectionFlags(subtitle2.selectionFlags).setRoleFlags(subtitle2.roleFlags).setLabel(subtitle2.label).build();
        this.dataSpec = new DataSpec.Builder().setUri(subtitle2.uri).setFlags(1).build();
        this.timeline = new SinglePeriodTimeline(j12, true, false, false, (Object) null, build);
    }
}
