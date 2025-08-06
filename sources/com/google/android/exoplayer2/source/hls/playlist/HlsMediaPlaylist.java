package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class HlsMediaPlaylist extends HlsPlaylist {
    public static final int PLAYLIST_TYPE_EVENT = 2;
    public static final int PLAYLIST_TYPE_UNKNOWN = 0;
    public static final int PLAYLIST_TYPE_VOD = 1;
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final long partTargetDurationUs;
    public final int playlistType;
    public final boolean preciseStart;
    public final DrmInitData protectionSchemes;
    public final Map<Uri, RenditionReport> renditionReports;
    public final List<Segment> segments;
    public final ServerControl serverControl;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final List<Part> trailingParts;
    public final int version;

    public static final class Part extends SegmentBase {
        public final boolean isIndependent;
        public final boolean isPreload;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Part(String str, Segment segment, long j11, int i11, long j12, DrmInitData drmInitData, String str2, String str3, long j13, long j14, boolean z11, boolean z12, boolean z13) {
            super(str, segment, j11, i11, j12, drmInitData, str2, str3, j13, j14, z11);
            this.isIndependent = z12;
            this.isPreload = z13;
        }

        public Part copyWith(long j11, int i11) {
            int i12 = i11;
            return new Part(this.url, this.initializationSegment, this.durationUs, i12, j11, this.drmInitData, this.fullSegmentEncryptionKeyUri, this.encryptionIV, this.byteRangeOffset, this.byteRangeLength, this.hasGapTag, this.isIndependent, this.isPreload);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public static final class RenditionReport {
        public final long lastMediaSequence;
        public final int lastPartIndex;
        public final Uri playlistUri;

        public RenditionReport(Uri uri, long j11, int i11) {
            this.playlistUri = uri;
            this.lastMediaSequence = j11;
            this.lastPartIndex = i11;
        }
    }

    public static class SegmentBase implements Comparable<Long> {
        public final long byteRangeLength;
        public final long byteRangeOffset;
        public final DrmInitData drmInitData;
        public final long durationUs;
        public final String encryptionIV;
        public final String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final String url;

        private SegmentBase(String str, Segment segment, long j11, int i11, long j12, DrmInitData drmInitData2, String str2, String str3, long j13, long j14, boolean z11) {
            this.url = str;
            this.initializationSegment = segment;
            this.durationUs = j11;
            this.relativeDiscontinuitySequence = i11;
            this.relativeStartTimeUs = j12;
            this.drmInitData = drmInitData2;
            this.fullSegmentEncryptionKeyUri = str2;
            this.encryptionIV = str3;
            this.byteRangeOffset = j13;
            this.byteRangeLength = j14;
            this.hasGapTag = z11;
        }

        public int compareTo(Long l11) {
            if (this.relativeStartTimeUs > l11.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < l11.longValue() ? -1 : 0;
        }
    }

    public static final class ServerControl {
        public final boolean canBlockReload;
        public final boolean canSkipDateRanges;
        public final long holdBackUs;
        public final long partHoldBackUs;
        public final long skipUntilUs;

        public ServerControl(long j11, boolean z11, long j12, long j13, boolean z12) {
            this.skipUntilUs = j11;
            this.canSkipDateRanges = z11;
            this.holdBackUs = j12;
            this.partHoldBackUs = j13;
            this.canBlockReload = z12;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HlsMediaPlaylist(int i11, String str, List<String> list, long j11, boolean z11, long j12, boolean z12, int i12, long j13, int i13, long j14, long j15, boolean z13, boolean z14, boolean z15, DrmInitData drmInitData, List<Segment> list2, List<Part> list3, ServerControl serverControl2, Map<Uri, RenditionReport> map) {
        super(str, list, z13);
        long j16 = j11;
        String str2 = str;
        List<String> list4 = list;
        this.playlistType = i11;
        this.startTimeUs = j12;
        this.preciseStart = z11;
        this.hasDiscontinuitySequence = z12;
        this.discontinuitySequence = i12;
        this.mediaSequence = j13;
        this.version = i13;
        this.targetDurationUs = j14;
        this.partTargetDurationUs = j15;
        this.hasEndTag = z14;
        this.hasProgramDateTime = z15;
        this.protectionSchemes = drmInitData;
        this.segments = ImmutableList.copyOf(list2);
        this.trailingParts = ImmutableList.copyOf(list3);
        this.renditionReports = ImmutableMap.copyOf(map);
        if (!list3.isEmpty()) {
            Part part = (Part) Iterables.getLast(list3);
            this.durationUs = part.relativeStartTimeUs + part.durationUs;
        } else if (!list2.isEmpty()) {
            Segment segment = (Segment) Iterables.getLast(list2);
            this.durationUs = segment.relativeStartTimeUs + segment.durationUs;
        } else {
            this.durationUs = 0;
        }
        long j17 = -9223372036854775807L;
        if (j16 != -9223372036854775807L) {
            if (j16 >= 0) {
                j17 = Math.min(this.durationUs, j11);
            } else {
                j17 = Math.max(0, this.durationUs + j16);
            }
        }
        this.startOffsetUs = j17;
        this.serverControl = serverControl2;
    }

    public HlsMediaPlaylist copy(List<StreamKey> list) {
        return this;
    }

    public HlsMediaPlaylist copyWith(long j11, int i11) {
        int i12 = this.playlistType;
        return new HlsMediaPlaylist(i12, this.baseUri, this.tags, this.startOffsetUs, this.preciseStart, j11, true, i11, this.mediaSequence, this.version, this.targetDurationUs, this.partTargetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments, this.trailingParts, this.serverControl, this.renditionReports);
    }

    public HlsMediaPlaylist copyWithEndTag() {
        if (this.hasEndTag) {
            return this;
        }
        HlsMediaPlaylist hlsMediaPlaylist = r2;
        HlsMediaPlaylist hlsMediaPlaylist2 = new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.preciseStart, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.partTargetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments, this.trailingParts, this.serverControl, this.renditionReports);
        return hlsMediaPlaylist;
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public boolean isNewerThan(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j11 = this.mediaSequence;
        long j12 = hlsMediaPlaylist.mediaSequence;
        if (j11 > j12) {
            return true;
        }
        if (j11 < j12) {
            return false;
        }
        int size = this.segments.size() - hlsMediaPlaylist.segments.size();
        if (size == 0) {
            int size2 = this.trailingParts.size();
            int size3 = hlsMediaPlaylist.trailingParts.size();
            if (size2 > size3) {
                return true;
            }
            if (size2 != size3 || !this.hasEndTag || hlsMediaPlaylist.hasEndTag) {
                return false;
            }
            return true;
        } else if (size > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static final class Segment extends SegmentBase {
        public final List<Part> parts;
        public final String title;

        public Segment(String str, long j11, long j12, String str2, String str3) {
            this(str, (Segment) null, "", 0, -1, -9223372036854775807L, (DrmInitData) null, str2, str3, j11, j12, false, ImmutableList.of());
        }

        public Segment copyWith(long j11, int i11) {
            ArrayList arrayList = new ArrayList();
            long j12 = j11;
            for (int i12 = 0; i12 < this.parts.size(); i12++) {
                Part part = this.parts.get(i12);
                arrayList.add(part.copyWith(j12, i11));
                j12 += part.durationUs;
            }
            int i13 = i11;
            return new Segment(this.url, this.initializationSegment, this.title, this.durationUs, i11, j11, this.drmInitData, this.fullSegmentEncryptionKeyUri, this.encryptionIV, this.byteRangeOffset, this.byteRangeLength, this.hasGapTag, arrayList);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Segment(String str, Segment segment, String str2, long j11, int i11, long j12, DrmInitData drmInitData, String str3, String str4, long j13, long j14, boolean z11, List<Part> list) {
            super(str, segment, j11, i11, j12, drmInitData, str3, str4, j13, j14, z11);
            this.title = str2;
            this.parts = ImmutableList.copyOf(list);
        }
    }
}
