package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public abstract class SegmentBase {
    public final RangedUri initialization;
    public final long presentationTimeOffset;
    public final long timescale;

    public static abstract class MultiSegmentBase extends SegmentBase {
        public final long availabilityTimeOffsetUs;
        public final long duration;
        private final long periodStartUnixTimeUs;
        public final List<SegmentTimelineElement> segmentTimeline;
        public final long startNumber;
        private final long timeShiftBufferDepthUs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MultiSegmentBase(RangedUri rangedUri, long j11, long j12, long j13, long j14, List<SegmentTimelineElement> list, long j15, long j16, long j17) {
            super(rangedUri, j11, j12);
            this.startNumber = j13;
            this.duration = j14;
            this.segmentTimeline = list;
            this.availabilityTimeOffsetUs = j15;
            this.timeShiftBufferDepthUs = j16;
            this.periodStartUnixTimeUs = j17;
        }

        public long getAvailableSegmentCount(long j11, long j12) {
            long segmentCount = getSegmentCount(j11);
            if (segmentCount != -1) {
                return segmentCount;
            }
            return (long) ((int) (getSegmentNum((j12 - this.periodStartUnixTimeUs) + this.availabilityTimeOffsetUs, j11) - getFirstAvailableSegmentNum(j11, j12)));
        }

        public long getFirstAvailableSegmentNum(long j11, long j12) {
            if (getSegmentCount(j11) == -1) {
                long j13 = this.timeShiftBufferDepthUs;
                if (j13 != -9223372036854775807L) {
                    return Math.max(getFirstSegmentNum(), getSegmentNum((j12 - this.periodStartUnixTimeUs) - j13, j11));
                }
            }
            return getFirstSegmentNum();
        }

        public long getFirstSegmentNum() {
            return this.startNumber;
        }

        public long getNextSegmentAvailableTimeUs(long j11, long j12) {
            if (this.segmentTimeline != null) {
                return -9223372036854775807L;
            }
            long firstAvailableSegmentNum = getFirstAvailableSegmentNum(j11, j12) + getAvailableSegmentCount(j11, j12);
            return (getSegmentTimeUs(firstAvailableSegmentNum) + getSegmentDurationUs(firstAvailableSegmentNum, j11)) - this.availabilityTimeOffsetUs;
        }

        public abstract long getSegmentCount(long j11);

        public final long getSegmentDurationUs(long j11, long j12) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (list.get((int) (j11 - this.startNumber)).duration * 1000000) / this.timescale;
            }
            long segmentCount = getSegmentCount(j12);
            if (segmentCount == -1 || j11 != (getFirstSegmentNum() + segmentCount) - 1) {
                return (this.duration * 1000000) / this.timescale;
            }
            return j12 - getSegmentTimeUs(j11);
        }

        public long getSegmentNum(long j11, long j12) {
            long firstSegmentNum = getFirstSegmentNum();
            long segmentCount = getSegmentCount(j12);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.segmentTimeline == null) {
                long j13 = this.startNumber + (j11 / ((this.duration * 1000000) / this.timescale));
                if (j13 < firstSegmentNum) {
                    return firstSegmentNum;
                }
                if (segmentCount == -1) {
                    return j13;
                }
                return Math.min(j13, (firstSegmentNum + segmentCount) - 1);
            }
            long j14 = (segmentCount + firstSegmentNum) - 1;
            long j15 = firstSegmentNum;
            while (j15 <= j14) {
                long j16 = ((j14 - j15) / 2) + j15;
                int i11 = (getSegmentTimeUs(j16) > j11 ? 1 : (getSegmentTimeUs(j16) == j11 ? 0 : -1));
                if (i11 < 0) {
                    j15 = j16 + 1;
                } else if (i11 <= 0) {
                    return j16;
                } else {
                    j14 = j16 - 1;
                }
            }
            return j15 == firstSegmentNum ? j15 : j14;
        }

        public final long getSegmentTimeUs(long j11) {
            long j12;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j12 = list.get((int) (j11 - this.startNumber)).startTime - this.presentationTimeOffset;
            } else {
                j12 = (j11 - this.startNumber) * this.duration;
            }
            return Util.scaleLargeTimestamp(j12, 1000000, this.timescale);
        }

        public abstract RangedUri getSegmentUrl(Representation representation, long j11);

        public boolean isExplicit() {
            return this.segmentTimeline != null;
        }
    }

    public static final class SegmentList extends MultiSegmentBase {
        public final List<RangedUri> mediaSegments;

        public SegmentList(RangedUri rangedUri, long j11, long j12, long j13, long j14, List<SegmentTimelineElement> list, long j15, List<RangedUri> list2, long j16, long j17) {
            super(rangedUri, j11, j12, j13, j14, list, j15, j16, j17);
            this.mediaSegments = list2;
        }

        public long getSegmentCount(long j11) {
            return (long) this.mediaSegments.size();
        }

        public RangedUri getSegmentUrl(Representation representation, long j11) {
            return this.mediaSegments.get((int) (j11 - this.startNumber));
        }

        public boolean isExplicit() {
            return true;
        }
    }

    public static final class SegmentTemplate extends MultiSegmentBase {
        public final long endNumber;
        public final UrlTemplate initializationTemplate;
        public final UrlTemplate mediaTemplate;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SegmentTemplate(RangedUri rangedUri, long j11, long j12, long j13, long j14, long j15, List<SegmentTimelineElement> list, long j16, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j17, long j18) {
            super(rangedUri, j11, j12, j13, j15, list, j16, j17, j18);
            this.initializationTemplate = urlTemplate;
            this.mediaTemplate = urlTemplate2;
            this.endNumber = j14;
        }

        public RangedUri getInitialization(Representation representation) {
            UrlTemplate urlTemplate = this.initializationTemplate;
            if (urlTemplate == null) {
                return SegmentBase.super.getInitialization(representation);
            }
            Format format = representation.format;
            return new RangedUri(urlTemplate.buildUri(format.f65676id, 0, format.bitrate, 0), 0, -1);
        }

        public long getSegmentCount(long j11) {
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                return (long) list.size();
            }
            long j12 = this.endNumber;
            if (j12 != -1) {
                return (j12 - this.startNumber) + 1;
            }
            if (j11 != -9223372036854775807L) {
                return BigIntegerMath.divide(BigInteger.valueOf(j11).multiply(BigInteger.valueOf(this.timescale)), BigInteger.valueOf(this.duration).multiply(BigInteger.valueOf(1000000)), RoundingMode.CEILING).longValue();
            }
            return -1;
        }

        public RangedUri getSegmentUrl(Representation representation, long j11) {
            long j12;
            List<SegmentTimelineElement> list = this.segmentTimeline;
            if (list != null) {
                j12 = list.get((int) (j11 - this.startNumber)).startTime;
            } else {
                j12 = (j11 - this.startNumber) * this.duration;
            }
            long j13 = j12;
            UrlTemplate urlTemplate = this.mediaTemplate;
            Format format = representation.format;
            return new RangedUri(urlTemplate.buildUri(format.f65676id, j11, format.bitrate, j13), 0, -1);
        }
    }

    public static final class SegmentTimelineElement {
        public final long duration;
        public final long startTime;

        public SegmentTimelineElement(long j11, long j12) {
            this.startTime = j11;
            this.duration = j12;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SegmentTimelineElement.class != obj.getClass()) {
                return false;
            }
            SegmentTimelineElement segmentTimelineElement = (SegmentTimelineElement) obj;
            if (this.startTime == segmentTimelineElement.startTime && this.duration == segmentTimelineElement.duration) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.startTime) * 31) + ((int) this.duration);
        }
    }

    public SegmentBase(RangedUri rangedUri, long j11, long j12) {
        this.initialization = rangedUri;
        this.timescale = j11;
        this.presentationTimeOffset = j12;
    }

    public RangedUri getInitialization(Representation representation) {
        return this.initialization;
    }

    public long getPresentationTimeOffsetUs() {
        return Util.scaleLargeTimestamp(this.presentationTimeOffset, 1000000, this.timescale);
    }

    public static class SingleSegmentBase extends SegmentBase {
        public final long indexLength;
        public final long indexStart;

        public SingleSegmentBase(RangedUri rangedUri, long j11, long j12, long j13, long j14) {
            super(rangedUri, j11, j12);
            this.indexStart = j13;
            this.indexLength = j14;
        }

        public RangedUri getIndex() {
            long j11 = this.indexLength;
            if (j11 <= 0) {
                return null;
            }
            return new RangedUri((String) null, this.indexStart, j11);
        }

        public SingleSegmentBase() {
            this((RangedUri) null, 1, 0, 0, 0);
        }
    }
}
