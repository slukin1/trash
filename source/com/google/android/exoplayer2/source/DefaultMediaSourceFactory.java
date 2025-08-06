package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String TAG = "DefaultMediaSourceFactory";
    private AdViewProvider adViewProvider;
    private AdsLoaderProvider adsLoaderProvider;
    private final DataSource.Factory dataSourceFactory;
    private long liveMaxOffsetMs;
    private float liveMaxSpeed;
    private long liveMinOffsetMs;
    private float liveMinSpeed;
    private long liveTargetOffsetMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final SparseArray<MediaSourceFactory> mediaSourceFactories;
    private final int[] supportedTypes;

    public interface AdsLoaderProvider {
        AdsLoader getAdsLoader(MediaItem.AdsConfiguration adsConfiguration);
    }

    public DefaultMediaSourceFactory(Context context) {
        this((DataSource.Factory) new DefaultDataSourceFactory(context));
    }

    private static SparseArray<MediaSourceFactory> loadDelegates(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        Class<DataSource.Factory> cls = DataSource.Factory.class;
        Class<MediaSourceFactory> cls2 = MediaSourceFactory.class;
        SparseArray<MediaSourceFactory> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (MediaSourceFactory) DashMediaSource.Factory.class.asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{factory}));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (MediaSourceFactory) SsMediaSource.Factory.class.asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{factory}));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (MediaSourceFactory) HlsMediaSource.Factory.class.asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{factory}));
        } catch (Exception unused3) {
        }
        try {
            sparseArray.put(3, (MediaSourceFactory) Class.forName("com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception unused4) {
        }
        sparseArray.put(4, new ProgressiveMediaSource.Factory(factory, extractorsFactory));
        return sparseArray;
    }

    private static MediaSource maybeClipMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingProperties clippingProperties = mediaItem.clippingProperties;
        long j11 = clippingProperties.startPositionMs;
        if (j11 == 0 && clippingProperties.endPositionMs == Long.MIN_VALUE && !clippingProperties.relativeToDefaultPosition) {
            return mediaSource;
        }
        long msToUs = C.msToUs(j11);
        long msToUs2 = C.msToUs(mediaItem.clippingProperties.endPositionMs);
        MediaItem.ClippingProperties clippingProperties2 = mediaItem.clippingProperties;
        return new ClippingMediaSource(mediaSource, msToUs, msToUs2, !clippingProperties2.startsAtKeyFrame, clippingProperties2.relativeToLiveWindow, clippingProperties2.relativeToDefaultPosition);
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem mediaItem, MediaSource mediaSource) {
        Pair pair;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.playbackProperties.adsConfiguration;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoaderProvider adsLoaderProvider2 = this.adsLoaderProvider;
        AdViewProvider adViewProvider2 = this.adViewProvider;
        if (adsLoaderProvider2 == null || adViewProvider2 == null) {
            Log.w(TAG, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
            return mediaSource;
        }
        AdsLoader adsLoader = adsLoaderProvider2.getAdsLoader(adsConfiguration);
        if (adsLoader == null) {
            Log.w(TAG, "Playing media without ads, as no AdsLoader was provided.");
            return mediaSource;
        }
        DataSpec dataSpec = new DataSpec(adsConfiguration.adTagUri);
        Object obj = adsConfiguration.adsId;
        if (obj != null) {
            pair = obj;
        } else {
            pair = Pair.create(mediaItem.mediaId, adsConfiguration.adTagUri);
        }
        return new AdsMediaSource(mediaSource, dataSpec, pair, this, adsLoader, adViewProvider2);
    }

    public /* synthetic */ MediaSource createMediaSource(Uri uri) {
        return m.a(this, uri);
    }

    public MediaSource createMediaSource(MediaItem mediaItem) {
        Assertions.checkNotNull(mediaItem.playbackProperties);
        MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(playbackProperties.uri, playbackProperties.mimeType);
        MediaSourceFactory mediaSourceFactory = this.mediaSourceFactories.get(inferContentTypeForUriAndMimeType);
        StringBuilder sb2 = new StringBuilder(68);
        sb2.append("No suitable media source factory found for content type: ");
        sb2.append(inferContentTypeForUriAndMimeType);
        Assertions.checkNotNull(mediaSourceFactory, sb2.toString());
        MediaItem.LiveConfiguration liveConfiguration = mediaItem.liveConfiguration;
        if ((liveConfiguration.targetOffsetMs == -9223372036854775807L && this.liveTargetOffsetMs != -9223372036854775807L) || ((liveConfiguration.minPlaybackSpeed == -3.4028235E38f && this.liveMinSpeed != -3.4028235E38f) || ((liveConfiguration.maxPlaybackSpeed == -3.4028235E38f && this.liveMaxSpeed != -3.4028235E38f) || ((liveConfiguration.minOffsetMs == -9223372036854775807L && this.liveMinOffsetMs != -9223372036854775807L) || (liveConfiguration.maxOffsetMs == -9223372036854775807L && this.liveMaxOffsetMs != -9223372036854775807L))))) {
            MediaItem.Builder buildUpon = mediaItem.buildUpon();
            long j11 = mediaItem.liveConfiguration.targetOffsetMs;
            if (j11 == -9223372036854775807L) {
                j11 = this.liveTargetOffsetMs;
            }
            MediaItem.Builder liveTargetOffsetMs2 = buildUpon.setLiveTargetOffsetMs(j11);
            float f11 = mediaItem.liveConfiguration.minPlaybackSpeed;
            if (f11 == -3.4028235E38f) {
                f11 = this.liveMinSpeed;
            }
            MediaItem.Builder liveMinPlaybackSpeed = liveTargetOffsetMs2.setLiveMinPlaybackSpeed(f11);
            float f12 = mediaItem.liveConfiguration.maxPlaybackSpeed;
            if (f12 == -3.4028235E38f) {
                f12 = this.liveMaxSpeed;
            }
            MediaItem.Builder liveMaxPlaybackSpeed = liveMinPlaybackSpeed.setLiveMaxPlaybackSpeed(f12);
            long j12 = mediaItem.liveConfiguration.minOffsetMs;
            if (j12 == -9223372036854775807L) {
                j12 = this.liveMinOffsetMs;
            }
            MediaItem.Builder liveMinOffsetMs2 = liveMaxPlaybackSpeed.setLiveMinOffsetMs(j12);
            long j13 = mediaItem.liveConfiguration.maxOffsetMs;
            if (j13 == -9223372036854775807L) {
                j13 = this.liveMaxOffsetMs;
            }
            mediaItem = liveMinOffsetMs2.setLiveMaxOffsetMs(j13).build();
        }
        MediaSource createMediaSource = mediaSourceFactory.createMediaSource(mediaItem);
        List<MediaItem.Subtitle> list = ((MediaItem.PlaybackProperties) Util.castNonNull(mediaItem.playbackProperties)).subtitles;
        if (!list.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(list.size() + 1)];
            int i11 = 0;
            mediaSourceArr[0] = createMediaSource;
            SingleSampleMediaSource.Factory loadErrorHandlingPolicy2 = new SingleSampleMediaSource.Factory(this.dataSourceFactory).setLoadErrorHandlingPolicy(this.loadErrorHandlingPolicy);
            while (i11 < list.size()) {
                int i12 = i11 + 1;
                mediaSourceArr[i12] = loadErrorHandlingPolicy2.createMediaSource(list.get(i11), -9223372036854775807L);
                i11 = i12;
            }
            createMediaSource = new MergingMediaSource(mediaSourceArr);
        }
        return maybeWrapWithAdsMediaSource(mediaItem, maybeClipMediaSource(mediaItem, createMediaSource));
    }

    public int[] getSupportedTypes() {
        int[] iArr = this.supportedTypes;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public DefaultMediaSourceFactory setAdViewProvider(AdViewProvider adViewProvider2) {
        this.adViewProvider = adViewProvider2;
        return this;
    }

    public DefaultMediaSourceFactory setAdsLoaderProvider(AdsLoaderProvider adsLoaderProvider2) {
        this.adsLoaderProvider = adsLoaderProvider2;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long j11) {
        this.liveMaxOffsetMs = j11;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxSpeed(float f11) {
        this.liveMaxSpeed = f11;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinOffsetMs(long j11) {
        this.liveMinOffsetMs = j11;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinSpeed(float f11) {
        this.liveMinSpeed = f11;
        return this;
    }

    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long j11) {
        this.liveTargetOffsetMs = j11;
        return this;
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSourceFactory(context), extractorsFactory);
    }

    public DefaultMediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
        for (int i11 = 0; i11 < this.mediaSourceFactories.size(); i11++) {
            this.mediaSourceFactories.valueAt(i11).setDrmHttpDataSourceFactory(factory);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        for (int i11 = 0; i11 < this.mediaSourceFactories.size(); i11++) {
            this.mediaSourceFactories.valueAt(i11).setDrmSessionManager(drmSessionManager);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        for (int i11 = 0; i11 < this.mediaSourceFactories.size(); i11++) {
            this.mediaSourceFactories.valueAt(i11).setDrmSessionManagerProvider(drmSessionManagerProvider);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmUserAgent(String str) {
        for (int i11 = 0; i11 < this.mediaSourceFactories.size(); i11++) {
            this.mediaSourceFactories.valueAt(i11).setDrmUserAgent(str);
        }
        return this;
    }

    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        for (int i11 = 0; i11 < this.mediaSourceFactories.size(); i11++) {
            this.mediaSourceFactories.valueAt(i11).setLoadErrorHandlingPolicy(loadErrorHandlingPolicy2);
        }
        return this;
    }

    @Deprecated
    public DefaultMediaSourceFactory setStreamKeys(List<StreamKey> list) {
        for (int i11 = 0; i11 < this.mediaSourceFactories.size(); i11++) {
            this.mediaSourceFactories.valueAt(i11).setStreamKeys(list);
        }
        return this;
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = factory;
        SparseArray<MediaSourceFactory> loadDelegates = loadDelegates(factory, extractorsFactory);
        this.mediaSourceFactories = loadDelegates;
        this.supportedTypes = new int[loadDelegates.size()];
        for (int i11 = 0; i11 < this.mediaSourceFactories.size(); i11++) {
            this.supportedTypes[i11] = this.mediaSourceFactories.keyAt(i11);
        }
        this.liveTargetOffsetMs = -9223372036854775807L;
        this.liveMinOffsetMs = -9223372036854775807L;
        this.liveMaxOffsetMs = -9223372036854775807L;
        this.liveMinSpeed = -3.4028235E38f;
        this.liveMaxSpeed = -3.4028235E38f;
    }
}
