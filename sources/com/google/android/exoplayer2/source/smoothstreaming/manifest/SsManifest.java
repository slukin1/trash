package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SsManifest implements FilterableManifest<SsManifest> {
    public static final int UNSET_LOOKAHEAD = -1;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    public final ProtectionElement protectionElement;
    public final StreamElement[] streamElements;

    public static class ProtectionElement {
        public final byte[] data;
        public final TrackEncryptionBox[] trackEncryptionBoxes;
        public final UUID uuid;

        public ProtectionElement(UUID uuid2, byte[] bArr, TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.uuid = uuid2;
            this.data = bArr;
            this.trackEncryptionBoxes = trackEncryptionBoxArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SsManifest(int i11, int i12, long j11, long j12, long j13, int i13, boolean z11, ProtectionElement protectionElement2, StreamElement[] streamElementArr) {
        this(i11, i12, j12 == 0 ? -9223372036854775807L : Util.scaleLargeTimestamp(j12, 1000000, j11), j13 != 0 ? Util.scaleLargeTimestamp(j13, 1000000, j11) : -9223372036854775807L, i13, z11, protectionElement2, streamElementArr);
    }

    public final SsManifest copy(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        StreamElement streamElement = null;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i11);
            StreamElement streamElement2 = this.streamElements[streamKey.groupIndex];
            if (!(streamElement2 == streamElement || streamElement == null)) {
                arrayList2.add(streamElement.copy((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.formats[streamKey.trackIndex]);
            i11++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.copy((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new SsManifest(this.majorVersion, this.minorVersion, this.durationUs, this.dvrWindowLengthUs, this.lookAheadCount, this.isLive, this.protectionElement, (StreamElement[]) arrayList2.toArray(new StreamElement[0]));
    }

    public static class StreamElement {
        private static final String URL_PLACEHOLDER_BITRATE_1 = "{bitrate}";
        private static final String URL_PLACEHOLDER_BITRATE_2 = "{Bitrate}";
        private static final String URL_PLACEHOLDER_START_TIME_1 = "{start time}";
        private static final String URL_PLACEHOLDER_START_TIME_2 = "{start_time}";
        private final String baseUri;
        public final int chunkCount;
        private final List<Long> chunkStartTimes;
        private final long[] chunkStartTimesUs;
        private final String chunkTemplate;
        public final int displayHeight;
        public final int displayWidth;
        public final Format[] formats;
        public final String language;
        private final long lastChunkDurationUs;
        public final int maxHeight;
        public final int maxWidth;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public StreamElement(String str, String str2, int i11, String str3, long j11, String str4, int i12, int i13, int i14, int i15, String str5, Format[] formatArr, List<Long> list, long j12) {
            this(str, str2, i11, str3, j11, str4, i12, i13, i14, i15, str5, formatArr, list, Util.scaleLargeTimestamps(list, 1000000, j11), Util.scaleLargeTimestamp(j12, 1000000, j11));
            String str6 = str;
            String str7 = str2;
            int i16 = i11;
        }

        public Uri buildRequestUri(int i11, int i12) {
            boolean z11 = true;
            Assertions.checkState(this.formats != null);
            Assertions.checkState(this.chunkStartTimes != null);
            if (i12 >= this.chunkStartTimes.size()) {
                z11 = false;
            }
            Assertions.checkState(z11);
            String num = Integer.toString(this.formats[i11].bitrate);
            String l11 = this.chunkStartTimes.get(i12).toString();
            return UriUtil.resolveToUri(this.baseUri, this.chunkTemplate.replace(URL_PLACEHOLDER_BITRATE_1, num).replace(URL_PLACEHOLDER_BITRATE_2, num).replace(URL_PLACEHOLDER_START_TIME_1, l11).replace(URL_PLACEHOLDER_START_TIME_2, l11));
        }

        public StreamElement copy(Format[] formatArr) {
            String str = this.baseUri;
            return new StreamElement(str, this.chunkTemplate, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.chunkStartTimes, this.chunkStartTimesUs, this.lastChunkDurationUs);
        }

        public long getChunkDurationUs(int i11) {
            if (i11 == this.chunkCount - 1) {
                return this.lastChunkDurationUs;
            }
            long[] jArr = this.chunkStartTimesUs;
            return jArr[i11 + 1] - jArr[i11];
        }

        public int getChunkIndex(long j11) {
            return Util.binarySearchFloor(this.chunkStartTimesUs, j11, true, true);
        }

        public long getStartTimeUs(int i11) {
            return this.chunkStartTimesUs[i11];
        }

        private StreamElement(String str, String str2, int i11, String str3, long j11, String str4, int i12, int i13, int i14, int i15, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j12) {
            this.baseUri = str;
            this.chunkTemplate = str2;
            this.type = i11;
            this.subType = str3;
            this.timescale = j11;
            this.name = str4;
            this.maxWidth = i12;
            this.maxHeight = i13;
            this.displayWidth = i14;
            this.displayHeight = i15;
            this.language = str5;
            this.formats = formatArr;
            this.chunkStartTimes = list;
            this.chunkStartTimesUs = jArr;
            this.lastChunkDurationUs = j12;
            this.chunkCount = list.size();
        }
    }

    private SsManifest(int i11, int i12, long j11, long j12, int i13, boolean z11, ProtectionElement protectionElement2, StreamElement[] streamElementArr) {
        this.majorVersion = i11;
        this.minorVersion = i12;
        this.durationUs = j11;
        this.dvrWindowLengthUs = j12;
        this.lookAheadCount = i13;
        this.isLive = z11;
        this.protectionElement = protectionElement2;
        this.streamElements = streamElementArr;
    }
}
