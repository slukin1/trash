package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {
    private MappedTrackInfo currentMappedTrackInfo;

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup, int[] iArr, boolean z11) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        boolean z12 = true;
        int i11 = 0;
        for (int i12 = 0; i12 < rendererCapabilitiesArr.length; i12++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < trackGroup.length; i14++) {
                i13 = Math.max(i13, s0.d(rendererCapabilities.supportsFormat(trackGroup.getFormat(i14))));
            }
            boolean z13 = iArr[i12] == 0;
            if (i13 > i11 || (i13 == i11 && z11 && !z12 && z13)) {
                length = i12;
                z12 = z13;
                i11 = i13;
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i11 = 0; i11 < trackGroup.length; i11++) {
            iArr[i11] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i11));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = rendererCapabilitiesArr[i11].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (MappedTrackInfo) obj;
    }

    public abstract Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;

    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        int[] iArr;
        RendererCapabilities[] rendererCapabilitiesArr2 = rendererCapabilitiesArr;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        int[] iArr2 = new int[(rendererCapabilitiesArr2.length + 1)];
        int length = rendererCapabilitiesArr2.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr2.length + 1)][][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = trackGroupArray2.length;
            trackGroupArr[i11] = new TrackGroup[i12];
            iArr3[i11] = new int[i12][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArr);
        for (int i13 = 0; i13 < trackGroupArray2.length; i13++) {
            TrackGroup trackGroup = trackGroupArray2.get(i13);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup, iArr2, MimeTypes.getTrackType(trackGroup.getFormat(0).sampleMimeType) == 5);
            if (findRenderer == rendererCapabilitiesArr2.length) {
                iArr = new int[trackGroup.length];
            } else {
                iArr = getFormatSupport(rendererCapabilitiesArr2[findRenderer], trackGroup);
            }
            int i14 = iArr2[findRenderer];
            trackGroupArr[findRenderer][i14] = trackGroup;
            iArr3[findRenderer][i14] = iArr;
            iArr2[findRenderer] = iArr2[findRenderer] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr2.length];
        String[] strArr = new String[rendererCapabilitiesArr2.length];
        int[] iArr4 = new int[rendererCapabilitiesArr2.length];
        for (int i15 = 0; i15 < rendererCapabilitiesArr2.length; i15++) {
            int i16 = iArr2[i15];
            trackGroupArrayArr[i15] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i15], i16));
            iArr3[i15] = (int[][]) Util.nullSafeArrayCopy(iArr3[i15], i16);
            strArr[i15] = rendererCapabilitiesArr2[i15].getName();
            iArr4[i15] = rendererCapabilitiesArr2[i15].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(strArr, iArr4, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr3, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr2.length], iArr2[rendererCapabilitiesArr2.length])));
        Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr3, mixedMimeTypeAdaptationSupports, mediaPeriodId, timeline);
        return new TrackSelectorResult((RendererConfiguration[]) selectTracks.first, (ExoTrackSelection[]) selectTracks.second, mappedTrackInfo);
    }

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final String[] rendererNames;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        public MappedTrackInfo(String[] strArr, int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererNames = strArr;
            this.rendererTrackTypes = iArr;
            this.rendererTrackGroups = trackGroupArrayArr;
            this.rendererFormatSupports = iArr3;
            this.rendererMixedMimeTypeAdaptiveSupports = iArr2;
            this.unmappedTrackGroups = trackGroupArray;
            this.rendererCount = iArr.length;
        }

        public int getAdaptiveSupport(int i11, int i12, boolean z11) {
            int i13 = this.rendererTrackGroups[i11].get(i12).length;
            int[] iArr = new int[i13];
            int i14 = 0;
            for (int i15 = 0; i15 < i13; i15++) {
                int trackSupport = getTrackSupport(i11, i12, i15);
                if (trackSupport == 4 || (z11 && trackSupport == 3)) {
                    iArr[i14] = i15;
                    i14++;
                }
            }
            return getAdaptiveSupport(i11, i12, Arrays.copyOf(iArr, i14));
        }

        public int getRendererCount() {
            return this.rendererCount;
        }

        public String getRendererName(int i11) {
            return this.rendererNames[i11];
        }

        public int getRendererSupport(int i11) {
            int i12 = 0;
            for (int[] iArr : this.rendererFormatSupports[i11]) {
                for (int d11 : r11[r2]) {
                    int d12 = s0.d(d11);
                    int i13 = 2;
                    if (d12 == 0 || d12 == 1 || d12 == 2) {
                        i13 = 1;
                    } else if (d12 != 3) {
                        if (d12 == 4) {
                            return 3;
                        }
                        throw new IllegalStateException();
                    }
                    i12 = Math.max(i12, i13);
                }
            }
            return i12;
        }

        public int getRendererType(int i11) {
            return this.rendererTrackTypes[i11];
        }

        public TrackGroupArray getTrackGroups(int i11) {
            return this.rendererTrackGroups[i11];
        }

        public int getTrackSupport(int i11, int i12, int i13) {
            return s0.d(this.rendererFormatSupports[i11][i12][i13]);
        }

        public int getTypeSupport(int i11) {
            int i12 = 0;
            for (int i13 = 0; i13 < this.rendererCount; i13++) {
                if (this.rendererTrackTypes[i13] == i11) {
                    i12 = Math.max(i12, getRendererSupport(i13));
                }
            }
            return i12;
        }

        public TrackGroupArray getUnmappedTrackGroups() {
            return this.unmappedTrackGroups;
        }

        public int getAdaptiveSupport(int i11, int i12, int[] iArr) {
            int i13 = 0;
            int i14 = 16;
            String str = null;
            boolean z11 = false;
            int i15 = 0;
            while (i13 < iArr.length) {
                String str2 = this.rendererTrackGroups[i11].get(i12).getFormat(iArr[i13]).sampleMimeType;
                int i16 = i15 + 1;
                if (i15 == 0) {
                    str = str2;
                } else {
                    z11 |= !Util.areEqual(str, str2);
                }
                i14 = Math.min(i14, s0.c(this.rendererFormatSupports[i11][i12][i13]));
                i13++;
                i15 = i16;
            }
            return z11 ? Math.min(i14, this.rendererMixedMimeTypeAdaptiveSupports[i11]) : i14;
        }
    }
}
