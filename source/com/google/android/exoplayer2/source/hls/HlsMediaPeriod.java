package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper.Callback, HlsPlaylistTracker.PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private int audioVideoSampleStreamWrapperCount;
    private MediaPeriod.Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private int[][] manifestUrlIndicesPerWrapper = new int[0][];
    private final TransferListener mediaTransferListener;
    private final int metadataType;
    private int pendingPrepareCount;
    private final HlsPlaylistTracker playlistTracker;
    private HlsSampleStreamWrapper[] sampleStreamWrappers = new HlsSampleStreamWrapper[0];
    private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices = new IdentityHashMap<>();
    private final TimestampAdjusterProvider timestampAdjusterProvider = new TimestampAdjusterProvider();
    private TrackGroupArray trackGroups;
    private final boolean useSessionKeys;

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher3, Allocator allocator2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, boolean z11, int i11, boolean z12) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.mediaTransferListener = transferListener;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher3;
        this.allocator = allocator2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.allowChunklessPreparation = z11;
        this.metadataType = i11;
        this.useSessionKeys = z12;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
    }

    private void buildAndPrepareAudioSampleStreamWrappers(long j11, List<HlsMasterPlaylist.Rendition> list, List<HlsSampleStreamWrapper> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        List<HlsMasterPlaylist.Rendition> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list4.get(i11).name;
            if (!hashSet.add(str)) {
                List<HlsSampleStreamWrapper> list5 = list2;
                List<int[]> list6 = list3;
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z11 = true;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (Util.areEqual(str, list4.get(i12).name)) {
                        HlsMasterPlaylist.Rendition rendition = list4.get(i12);
                        arrayList3.add(Integer.valueOf(i12));
                        arrayList.add(rendition.url);
                        arrayList2.add(rendition.format);
                        z11 &= Util.getCodecCountOfType(rendition.format.codecs, 1) == 1;
                    }
                }
                HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(1, (Uri[]) arrayList.toArray((Uri[]) Util.castNonNullTypeArray(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j11);
                list3.add(Ints.toArray(arrayList3));
                list2.add(buildSampleStreamWrapper);
                if (this.allowChunklessPreparation && z11) {
                    buildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new TrackGroup[]{new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    private void buildAndPrepareMainSampleStreamWrapper(HlsMasterPlaylist hlsMasterPlaylist, long j11, List<HlsSampleStreamWrapper> list, List<int[]> list2, Map<String, DrmInitData> map) {
        boolean z11;
        boolean z12;
        HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        int size = hlsMasterPlaylist2.variants.size();
        int[] iArr = new int[size];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < hlsMasterPlaylist2.variants.size(); i13++) {
            Format format = hlsMasterPlaylist2.variants.get(i13).format;
            if (format.height > 0 || Util.getCodecsOfType(format.codecs, 2) != null) {
                iArr[i13] = 2;
                i11++;
            } else if (Util.getCodecsOfType(format.codecs, 1) != null) {
                iArr[i13] = 1;
                i12++;
            } else {
                iArr[i13] = -1;
            }
        }
        if (i11 > 0) {
            size = i11;
            z12 = true;
            z11 = false;
        } else if (i12 < size) {
            size -= i12;
            z12 = false;
            z11 = true;
        } else {
            z12 = false;
            z11 = false;
        }
        Uri[] uriArr = new Uri[size];
        Format[] formatArr = new Format[size];
        int[] iArr2 = new int[size];
        int i14 = 0;
        for (int i15 = 0; i15 < hlsMasterPlaylist2.variants.size(); i15++) {
            if ((!z12 || iArr[i15] == 2) && (!z11 || iArr[i15] != 1)) {
                HlsMasterPlaylist.Variant variant = hlsMasterPlaylist2.variants.get(i15);
                uriArr[i14] = variant.url;
                formatArr[i14] = variant.format;
                iArr2[i14] = i15;
                i14++;
            }
        }
        String str = formatArr[0].codecs;
        int codecCountOfType = Util.getCodecCountOfType(str, 2);
        int codecCountOfType2 = Util.getCodecCountOfType(str, 1);
        boolean z13 = codecCountOfType2 <= 1 && codecCountOfType <= 1 && codecCountOfType2 + codecCountOfType > 0;
        HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(0, uriArr, formatArr, hlsMasterPlaylist2.muxedAudioFormat, hlsMasterPlaylist2.muxedCaptionFormats, map, j11);
        list.add(buildSampleStreamWrapper);
        list2.add(iArr2);
        if (this.allowChunklessPreparation && z13) {
            ArrayList arrayList = new ArrayList();
            if (codecCountOfType > 0) {
                Format[] formatArr2 = new Format[size];
                for (int i16 = 0; i16 < size; i16++) {
                    formatArr2[i16] = deriveVideoFormat(formatArr[i16]);
                }
                arrayList.add(new TrackGroup(formatArr2));
                if (codecCountOfType2 > 0 && (hlsMasterPlaylist2.muxedAudioFormat != null || hlsMasterPlaylist2.audios.isEmpty())) {
                    arrayList.add(new TrackGroup(deriveAudioFormat(formatArr[0], hlsMasterPlaylist2.muxedAudioFormat, false)));
                }
                List<Format> list3 = hlsMasterPlaylist2.muxedCaptionFormats;
                if (list3 != null) {
                    for (int i17 = 0; i17 < list3.size(); i17++) {
                        arrayList.add(new TrackGroup(list3.get(i17)));
                    }
                }
            } else {
                Format[] formatArr3 = new Format[size];
                for (int i18 = 0; i18 < size; i18++) {
                    formatArr3[i18] = deriveAudioFormat(formatArr[i18], hlsMasterPlaylist2.muxedAudioFormat, true);
                }
                arrayList.add(new TrackGroup(formatArr3));
            }
            TrackGroup trackGroup = new TrackGroup(new Format.Builder().setId("ID3").setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
            arrayList.add(trackGroup);
            buildSampleStreamWrapper.prepareWithMasterPlaylistInfo((TrackGroup[]) arrayList.toArray(new TrackGroup[0]), 0, arrayList.indexOf(trackGroup));
        }
    }

    private void buildAndPrepareSampleStreamWrappers(long j11) {
        Map<String, DrmInitData> map;
        HlsMasterPlaylist hlsMasterPlaylist = (HlsMasterPlaylist) Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist());
        if (this.useSessionKeys) {
            map = deriveOverridingDrmInitData(hlsMasterPlaylist.sessionKeyDrmInitData);
        } else {
            map = Collections.emptyMap();
        }
        Map<String, DrmInitData> map2 = map;
        boolean z11 = !hlsMasterPlaylist.variants.isEmpty();
        List<HlsMasterPlaylist.Rendition> list = hlsMasterPlaylist.audios;
        List<HlsMasterPlaylist.Rendition> list2 = hlsMasterPlaylist.subtitles;
        this.pendingPrepareCount = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z11) {
            buildAndPrepareMainSampleStreamWrapper(hlsMasterPlaylist, j11, arrayList, arrayList2, map2);
        }
        buildAndPrepareAudioSampleStreamWrappers(j11, list, arrayList, arrayList2, map2);
        this.audioVideoSampleStreamWrapperCount = arrayList.size();
        int i11 = 0;
        while (i11 < list2.size()) {
            HlsMasterPlaylist.Rendition rendition = list2.get(i11);
            int i12 = i11;
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(3, new Uri[]{rendition.url}, new Format[]{rendition.format}, (Format) null, Collections.emptyList(), map2, j11);
            arrayList2.add(new int[]{i12});
            arrayList.add(buildSampleStreamWrapper);
            buildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new TrackGroup[]{new TrackGroup(rendition.format)}, 0, new int[0]);
            i11 = i12 + 1;
        }
        this.sampleStreamWrappers = (HlsSampleStreamWrapper[]) arrayList.toArray(new HlsSampleStreamWrapper[0]);
        this.manifestUrlIndicesPerWrapper = (int[][]) arrayList2.toArray(new int[0][]);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
        this.pendingPrepareCount = hlsSampleStreamWrapperArr.length;
        hlsSampleStreamWrapperArr[0].setIsTimestampMaster(true);
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(int i11, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j11) {
        return new HlsSampleStreamWrapper(i11, this, new HlsChunkSource(this.extractorFactory, this.playlistTracker, uriArr, formatArr, this.dataSourceFactory, this.mediaTransferListener, this.timestampAdjusterProvider, list), map, this.allocator, j11, format, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.eventDispatcher, this.metadataType);
    }

    private static Format deriveAudioFormat(Format format, Format format2, boolean z11) {
        String str;
        int i11;
        String str2;
        int i12;
        int i13;
        Metadata metadata;
        String str3;
        int i14 = -1;
        if (format2 != null) {
            str3 = format2.codecs;
            metadata = format2.metadata;
            int i15 = format2.channelCount;
            i12 = format2.selectionFlags;
            int i16 = format2.roleFlags;
            String str4 = format2.language;
            str = format2.label;
            String str5 = str4;
            i11 = i15;
            i13 = i16;
            str2 = str5;
        } else {
            String codecsOfType = Util.getCodecsOfType(format.codecs, 1);
            Metadata metadata2 = format.metadata;
            if (z11) {
                int i17 = format.channelCount;
                int i18 = format.selectionFlags;
                int i19 = format.roleFlags;
                str2 = format.language;
                int i21 = i17;
                str3 = codecsOfType;
                str = format.label;
                i11 = i21;
                int i22 = i19;
                i12 = i18;
                metadata = metadata2;
                i13 = i22;
            } else {
                str2 = null;
                i12 = 0;
                i11 = -1;
                str3 = codecsOfType;
                str = null;
                metadata = metadata2;
                i13 = 0;
            }
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str3);
        int i23 = z11 ? format.averageBitrate : -1;
        if (z11) {
            i14 = format.peakBitrate;
        }
        return new Format.Builder().setId(format.f65676id).setLabel(str).setContainerMimeType(format.containerMimeType).setSampleMimeType(mediaMimeType).setCodecs(str3).setMetadata(metadata).setAverageBitrate(i23).setPeakBitrate(i14).setChannelCount(i11).setSelectionFlags(i12).setRoleFlags(i13).setLanguage(str2).build();
    }

    private static Map<String, DrmInitData> deriveOverridingDrmInitData(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            DrmInitData drmInitData = list.get(i11);
            String str = drmInitData.schemeType;
            i11++;
            int i12 = i11;
            while (i12 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i12);
                if (TextUtils.equals(drmInitData2.schemeType, str)) {
                    drmInitData = drmInitData.merge(drmInitData2);
                    arrayList.remove(i12);
                } else {
                    i12++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    private static Format deriveVideoFormat(Format format) {
        String codecsOfType = Util.getCodecsOfType(format.codecs, 2);
        return new Format.Builder().setId(format.f65676id).setLabel(format.label).setContainerMimeType(format.containerMimeType).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType)).setCodecs(codecsOfType).setMetadata(format.metadata).setAverageBitrate(format.averageBitrate).setPeakBitrate(format.peakBitrate).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate).setSelectionFlags(format.selectionFlags).setRoleFlags(format.roleFlags).build();
    }

    public boolean continueLoading(long j11) {
        if (this.trackGroups != null) {
            return this.compositeSequenceableLoader.continueLoading(j11);
        }
        for (HlsSampleStreamWrapper continuePreparing : this.sampleStreamWrappers) {
            continuePreparing.continuePreparing();
        }
        return false;
    }

    public void discardBuffer(long j11, boolean z11) {
        for (HlsSampleStreamWrapper discardBuffer : this.enabledSampleStreamWrappers) {
            discardBuffer.discardBuffer(j11, z11);
        }
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        return j11;
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        TrackGroupArray trackGroupArray;
        int[] iArr;
        int i11;
        HlsMediaPeriod hlsMediaPeriod = this;
        HlsMasterPlaylist hlsMasterPlaylist = (HlsMasterPlaylist) Assertions.checkNotNull(hlsMediaPeriod.playlistTracker.getMasterPlaylist());
        boolean z11 = !hlsMasterPlaylist.variants.isEmpty();
        int length = hlsMediaPeriod.sampleStreamWrappers.length - hlsMasterPlaylist.subtitles.size();
        int i12 = 0;
        if (z11) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.sampleStreamWrappers[0];
            iArr = hlsMediaPeriod.manifestUrlIndicesPerWrapper[0];
            trackGroupArray = hlsSampleStreamWrapper.getTrackGroups();
            i11 = hlsSampleStreamWrapper.getPrimaryTrackGroupIndex();
        } else {
            iArr = new int[0];
            trackGroupArray = TrackGroupArray.EMPTY;
            i11 = 0;
        }
        ArrayList arrayList = new ArrayList();
        boolean z12 = false;
        boolean z13 = false;
        for (ExoTrackSelection next : list) {
            TrackGroup trackGroup = next.getTrackGroup();
            int indexOf = trackGroupArray.indexOf(trackGroup);
            if (indexOf == -1) {
                int i13 = z11;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = hlsMediaPeriod.sampleStreamWrappers;
                    if (i13 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i13].getTrackGroups().indexOf(trackGroup) != -1) {
                        int i14 = i13 < length ? 1 : 2;
                        int[] iArr2 = hlsMediaPeriod.manifestUrlIndicesPerWrapper[i13];
                        int i15 = 0;
                        while (i15 < next.length()) {
                            arrayList.add(new StreamKey(i14, iArr2[next.getIndexInTrackGroup(i15)]));
                            i15++;
                        }
                    } else {
                        i13++;
                        hlsMediaPeriod = this;
                    }
                }
            } else if (indexOf == i11) {
                for (int i16 = i12; i16 < next.length(); i16++) {
                    arrayList.add(new StreamKey(i12, iArr[next.getIndexInTrackGroup(i16)]));
                }
                z13 = true;
            } else {
                z12 = true;
            }
            hlsMediaPeriod = this;
            i12 = 0;
        }
        if (z12 && !z13) {
            int i17 = iArr[0];
            int i18 = hlsMasterPlaylist.variants.get(iArr[0]).format.bitrate;
            for (int i19 = 1; i19 < iArr.length; i19++) {
                int i21 = hlsMasterPlaylist.variants.get(iArr[i19]).format.bitrate;
                if (i21 < i18) {
                    i17 = iArr[i19];
                    i18 = i21;
                }
            }
            arrayList.add(new StreamKey(0, i17));
        }
        return arrayList;
    }

    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() throws IOException {
        for (HlsSampleStreamWrapper maybeThrowPrepareError : this.sampleStreamWrappers) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public void onPlaylistChanged() {
        for (HlsSampleStreamWrapper onPlaylistUpdated : this.sampleStreamWrappers) {
            onPlaylistUpdated.onPlaylistUpdated();
        }
        this.callback.onContinueLoadingRequested(this);
    }

    public boolean onPlaylistError(Uri uri, long j11) {
        boolean z11 = true;
        for (HlsSampleStreamWrapper onPlaylistError : this.sampleStreamWrappers) {
            z11 &= onPlaylistError.onPlaylistError(uri, j11);
        }
        this.callback.onContinueLoadingRequested(this);
        return z11;
    }

    public void onPlaylistRefreshRequired(Uri uri) {
        this.playlistTracker.refreshPlaylist(uri);
    }

    public void onPrepared() {
        int i11 = this.pendingPrepareCount - 1;
        this.pendingPrepareCount = i11;
        if (i11 <= 0) {
            int i12 = 0;
            for (HlsSampleStreamWrapper trackGroups2 : this.sampleStreamWrappers) {
                i12 += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i12];
            int i13 = 0;
            for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
                int i14 = hlsSampleStreamWrapper.getTrackGroups().length;
                int i15 = 0;
                while (i15 < i14) {
                    trackGroupArr[i13] = hlsSampleStreamWrapper.getTrackGroups().get(i15);
                    i15++;
                    i13++;
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    public void prepare(MediaPeriod.Callback callback2, long j11) {
        this.callback = callback2;
        this.playlistTracker.addListener(this);
        buildAndPrepareSampleStreamWrappers(j11);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long j11) {
        this.compositeSequenceableLoader.reevaluateBuffer(j11);
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        for (HlsSampleStreamWrapper release : this.sampleStreamWrappers) {
            release.release();
        }
        this.callback = null;
    }

    public long seekToUs(long j11) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean seekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j11, false);
            int i11 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                if (i11 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i11].seekToUs(j11, seekToUs);
                i11++;
            }
            if (seekToUs) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return j11;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        boolean z11;
        int i11;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        for (int i12 = 0; i12 < exoTrackSelectionArr2.length; i12++) {
            if (sampleStreamArr2[i12] == null) {
                i11 = -1;
            } else {
                i11 = this.streamWrapperIndices.get(sampleStreamArr2[i12]).intValue();
            }
            iArr[i12] = i11;
            iArr2[i12] = -1;
            if (exoTrackSelectionArr2[i12] != null) {
                TrackGroup trackGroup = exoTrackSelectionArr2[i12].getTrackGroup();
                int i13 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
                    if (i13 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    } else if (hlsSampleStreamWrapperArr[i13].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i12] = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
        }
        this.streamWrapperIndices.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
        int i14 = 0;
        int i15 = 0;
        boolean z12 = false;
        while (i15 < this.sampleStreamWrappers.length) {
            for (int i16 = 0; i16 < exoTrackSelectionArr2.length; i16++) {
                ExoTrackSelection exoTrackSelection = null;
                sampleStreamArr4[i16] = iArr[i16] == i15 ? sampleStreamArr2[i16] : null;
                if (iArr2[i16] == i15) {
                    exoTrackSelection = exoTrackSelectionArr2[i16];
                }
                exoTrackSelectionArr3[i16] = exoTrackSelection;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrappers[i15];
            HlsSampleStreamWrapper hlsSampleStreamWrapper2 = hlsSampleStreamWrapper;
            int i17 = length;
            int i18 = i15;
            int i19 = i14;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean selectTracks = hlsSampleStreamWrapper.selectTracks(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j11, z12);
            int i21 = 0;
            boolean z13 = false;
            while (true) {
                z11 = true;
                if (i21 >= exoTrackSelectionArr2.length) {
                    break;
                }
                SampleStream sampleStream = sampleStreamArr4[i21];
                if (iArr2[i21] == i18) {
                    Assertions.checkNotNull(sampleStream);
                    sampleStreamArr3[i21] = sampleStream;
                    this.streamWrapperIndices.put(sampleStream, Integer.valueOf(i18));
                    z13 = true;
                } else if (iArr[i21] == i18) {
                    if (sampleStream != null) {
                        z11 = false;
                    }
                    Assertions.checkState(z11);
                }
                i21++;
            }
            if (z13) {
                hlsSampleStreamWrapperArr3[i19] = hlsSampleStreamWrapper2;
                i14 = i19 + 1;
                if (i19 == 0) {
                    hlsSampleStreamWrapper2.setIsTimestampMaster(true);
                    if (!selectTracks) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.enabledSampleStreamWrappers;
                        if (hlsSampleStreamWrapperArr4.length != 0 && hlsSampleStreamWrapper2 == hlsSampleStreamWrapperArr4[0]) {
                        }
                    }
                    this.timestampAdjusterProvider.reset();
                    z12 = true;
                } else {
                    if (i18 >= this.audioVideoSampleStreamWrapperCount) {
                        z11 = false;
                    }
                    hlsSampleStreamWrapper2.setIsTimestampMaster(z11);
                }
            } else {
                i14 = i19;
            }
            i15 = i18 + 1;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
            length = i17;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
            sampleStreamArr2 = sampleStreamArr;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = (HlsSampleStreamWrapper[]) Util.nullSafeArrayCopy(hlsSampleStreamWrapperArr2, i14);
        this.enabledSampleStreamWrappers = hlsSampleStreamWrapperArr5;
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(hlsSampleStreamWrapperArr5);
        return j11;
    }

    public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.callback.onContinueLoadingRequested(this);
    }
}
