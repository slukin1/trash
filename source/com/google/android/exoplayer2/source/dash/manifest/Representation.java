package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import java.util.Collections;
import java.util.List;

public abstract class Representation {
    public static final long REVISION_ID_DEFAULT = -1;
    public final String baseUrl;
    public final Format format;
    public final List<Descriptor> inbandEventStreams;
    private final RangedUri initializationUri;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    public static class MultiSegmentRepresentation extends Representation implements DashSegmentIndex {
        public final SegmentBase.MultiSegmentBase segmentBase;

        public MultiSegmentRepresentation(long j11, Format format, String str, SegmentBase.MultiSegmentBase multiSegmentBase, List<Descriptor> list) {
            super(j11, format, str, multiSegmentBase, list);
            this.segmentBase = multiSegmentBase;
        }

        public long getAvailableSegmentCount(long j11, long j12) {
            return this.segmentBase.getAvailableSegmentCount(j11, j12);
        }

        public String getCacheKey() {
            return null;
        }

        public long getDurationUs(long j11, long j12) {
            return this.segmentBase.getSegmentDurationUs(j11, j12);
        }

        public long getFirstAvailableSegmentNum(long j11, long j12) {
            return this.segmentBase.getFirstAvailableSegmentNum(j11, j12);
        }

        public long getFirstSegmentNum() {
            return this.segmentBase.getFirstSegmentNum();
        }

        public DashSegmentIndex getIndex() {
            return this;
        }

        public RangedUri getIndexUri() {
            return null;
        }

        public long getNextSegmentAvailableTimeUs(long j11, long j12) {
            return this.segmentBase.getNextSegmentAvailableTimeUs(j11, j12);
        }

        public long getSegmentCount(long j11) {
            return this.segmentBase.getSegmentCount(j11);
        }

        public long getSegmentNum(long j11, long j12) {
            return this.segmentBase.getSegmentNum(j11, j12);
        }

        public RangedUri getSegmentUrl(long j11) {
            return this.segmentBase.getSegmentUrl(this, j11);
        }

        public long getTimeUs(long j11) {
            return this.segmentBase.getSegmentTimeUs(j11);
        }

        public boolean isExplicit() {
            return this.segmentBase.isExplicit();
        }
    }

    public static class SingleSegmentRepresentation extends Representation {
        private final String cacheKey;
        public final long contentLength;
        private final RangedUri indexUri;
        private final SingleSegmentIndex segmentIndex;
        public final Uri uri;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SingleSegmentRepresentation(long j11, Format format, String str, SegmentBase.SingleSegmentBase singleSegmentBase, List<Descriptor> list, String str2, long j12) {
            super(j11, format, str, singleSegmentBase, list);
            SingleSegmentIndex singleSegmentIndex;
            this.uri = Uri.parse(str);
            RangedUri index = singleSegmentBase.getIndex();
            this.indexUri = index;
            this.cacheKey = str2;
            this.contentLength = j12;
            if (index != null) {
                singleSegmentIndex = null;
            } else {
                singleSegmentIndex = new SingleSegmentIndex(new RangedUri((String) null, 0, j12));
            }
            this.segmentIndex = singleSegmentIndex;
        }

        public static SingleSegmentRepresentation newInstance(long j11, Format format, String str, long j12, long j13, long j14, long j15, List<Descriptor> list, String str2, long j16) {
            return new SingleSegmentRepresentation(j11, format, str, new SegmentBase.SingleSegmentBase(new RangedUri((String) null, j12, (j13 - j12) + 1), 1, 0, j14, (j15 - j14) + 1), list, str2, j16);
        }

        public String getCacheKey() {
            return this.cacheKey;
        }

        public DashSegmentIndex getIndex() {
            return this.segmentIndex;
        }

        public RangedUri getIndexUri() {
            return this.indexUri;
        }
    }

    public static Representation newInstance(long j11, Format format2, String str, SegmentBase segmentBase) {
        return newInstance(j11, format2, str, segmentBase, (List<Descriptor>) null);
    }

    public abstract String getCacheKey();

    public abstract DashSegmentIndex getIndex();

    public abstract RangedUri getIndexUri();

    public RangedUri getInitializationUri() {
        return this.initializationUri;
    }

    private Representation(long j11, Format format2, String str, SegmentBase segmentBase, List<Descriptor> list) {
        List<Descriptor> list2;
        this.revisionId = j11;
        this.format = format2;
        this.baseUrl = str;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.inbandEventStreams = list2;
        this.initializationUri = segmentBase.getInitialization(this);
        this.presentationTimeOffsetUs = segmentBase.getPresentationTimeOffsetUs();
    }

    public static Representation newInstance(long j11, Format format2, String str, SegmentBase segmentBase, List<Descriptor> list) {
        return newInstance(j11, format2, str, segmentBase, list, (String) null);
    }

    public static Representation newInstance(long j11, Format format2, String str, SegmentBase segmentBase, List<Descriptor> list, String str2) {
        SegmentBase segmentBase2 = segmentBase;
        if (segmentBase2 instanceof SegmentBase.SingleSegmentBase) {
            return new SingleSegmentRepresentation(j11, format2, str, (SegmentBase.SingleSegmentBase) segmentBase2, list, str2, -1);
        } else if (segmentBase2 instanceof SegmentBase.MultiSegmentBase) {
            return new MultiSegmentRepresentation(j11, format2, str, (SegmentBase.MultiSegmentBase) segmentBase2, list);
        } else {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }
}
