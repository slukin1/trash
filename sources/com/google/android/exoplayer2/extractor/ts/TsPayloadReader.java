package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

public interface TsPayloadReader {
    public static final int FLAG_DATA_ALIGNMENT_INDICATOR = 4;
    public static final int FLAG_PAYLOAD_UNIT_START_INDICATOR = 1;
    public static final int FLAG_RANDOM_ACCESS_INDICATOR = 2;

    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String str, int i11, byte[] bArr) {
            this.language = str;
            this.type = i11;
            this.initializationData = bArr;
        }
    }

    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final List<DvbSubtitleInfo> dvbSubtitleInfos;
        public final String language;
        public final int streamType;

        public EsInfo(int i11, String str, List<DvbSubtitleInfo> list, byte[] bArr) {
            List<DvbSubtitleInfo> list2;
            this.streamType = i11;
            this.language = str;
            if (list == null) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.dvbSubtitleInfos = list2;
            this.descriptorBytes = bArr;
        }
    }

    public interface Factory {
        SparseArray<TsPayloadReader> createInitialPayloadReaders();

        TsPayloadReader createPayloadReader(int i11, EsInfo esInfo);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class TrackIdGenerator {
        private static final int ID_UNSET = Integer.MIN_VALUE;
        private final int firstTrackId;
        private String formatId;
        private final String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int i11, int i12) {
            this(Integer.MIN_VALUE, i11, i12);
        }

        private void maybeThrowUninitializedError() {
            if (this.trackId == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void generateNewId() {
            int i11 = this.trackId;
            int i12 = i11 == Integer.MIN_VALUE ? this.firstTrackId : i11 + this.trackIdIncrement;
            this.trackId = i12;
            String str = this.formatIdPrefix;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11);
            sb2.append(str);
            sb2.append(i12);
            this.formatId = sb2.toString();
        }

        public String getFormatId() {
            maybeThrowUninitializedError();
            return this.formatId;
        }

        public int getTrackId() {
            maybeThrowUninitializedError();
            return this.trackId;
        }

        public TrackIdGenerator(int i11, int i12, int i13) {
            String str;
            if (i11 != Integer.MIN_VALUE) {
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(i11);
                sb2.append("/");
                str = sb2.toString();
            } else {
                str = "";
            }
            this.formatIdPrefix = str;
            this.firstTrackId = i12;
            this.trackIdIncrement = i13;
            this.trackId = Integer.MIN_VALUE;
            this.formatId = "";
        }
    }

    void consume(ParsableByteArray parsableByteArray, int i11) throws ParserException;

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();
}
