package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = a.f66000a;
    private static final PositionHolder POSITION_HOLDER = new PositionHolder();
    private final SparseArray<BindingTrackOutput> bindingTrackOutputs = new SparseArray<>();
    private long endTimeUs;
    private final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private ChunkExtractor.TrackOutputProvider trackOutputProvider;

    public static final class BindingTrackOutput implements TrackOutput {
        private long endTimeUs;
        private final DummyTrackOutput fakeTrackOutput = new DummyTrackOutput();

        /* renamed from: id  reason: collision with root package name */
        private final int f65999id;
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int i11, int i12, Format format) {
            this.f65999id = i11;
            this.type = i12;
            this.manifestFormat = format;
        }

        public void bind(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j11) {
            if (trackOutputProvider == null) {
                this.trackOutput = this.fakeTrackOutput;
                return;
            }
            this.endTimeUs = j11;
            TrackOutput track = trackOutputProvider.track(this.f65999id, this.type);
            this.trackOutput = track;
            Format format = this.sampleFormat;
            if (format != null) {
                track.format(format);
            }
        }

        public void format(Format format) {
            Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.withManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            ((TrackOutput) Util.castNonNull(this.trackOutput)).format(this.sampleFormat);
        }

        public /* synthetic */ int sampleData(DataReader dataReader, int i11, boolean z11) {
            return d.a(this, dataReader, i11, z11);
        }

        public int sampleData(DataReader dataReader, int i11, boolean z11, int i12) throws IOException {
            return ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(dataReader, i11, z11);
        }

        public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i11) {
            d.b(this, parsableByteArray, i11);
        }

        public void sampleMetadata(long j11, int i11, int i12, int i13, TrackOutput.CryptoData cryptoData) {
            long j12 = this.endTimeUs;
            if (j12 != -9223372036854775807L && j11 >= j12) {
                this.trackOutput = this.fakeTrackOutput;
            }
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j11, i11, i12, i13, cryptoData);
        }

        public void sampleData(ParsableByteArray parsableByteArray, int i11, int i12) {
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(parsableByteArray, i11);
        }
    }

    public BundledChunkExtractor(Extractor extractor2, int i11, Format format) {
        this.extractor = extractor2;
        this.primaryTrackType = i11;
        this.primaryTrackManifestFormat = format;
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor] */
    /* JADX WARNING: type inference failed for: r9v6, types: [com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ com.google.android.exoplayer2.source.chunk.ChunkExtractor lambda$static$0(int r7, com.google.android.exoplayer2.Format r8, boolean r9, java.util.List r10, com.google.android.exoplayer2.extractor.TrackOutput r11) {
        /*
            java.lang.String r0 = r8.containerMimeType
            boolean r1 = com.google.android.exoplayer2.util.MimeTypes.isText(r0)
            if (r1 == 0) goto L_0x0018
            java.lang.String r9 = "application/x-rawcc"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0016
            com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor r9 = new com.google.android.exoplayer2.extractor.rawcc.RawCcExtractor
            r9.<init>(r8)
            goto L_0x0034
        L_0x0016:
            r7 = 0
            return r7
        L_0x0018:
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.isMatroska(r0)
            if (r0 == 0) goto L_0x0025
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor r9 = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor
            r10 = 1
            r9.<init>(r10)
            goto L_0x0034
        L_0x0025:
            r0 = 0
            if (r9 == 0) goto L_0x0029
            r0 = 4
        L_0x0029:
            r2 = r0
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor r9 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor
            r3 = 0
            r4 = 0
            r1 = r9
            r5 = r10
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0034:
            com.google.android.exoplayer2.source.chunk.BundledChunkExtractor r10 = new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor
            r10.<init>(r9, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.BundledChunkExtractor.lambda$static$0(int, com.google.android.exoplayer2.Format, boolean, java.util.List, com.google.android.exoplayer2.extractor.TrackOutput):com.google.android.exoplayer2.source.chunk.ChunkExtractor");
    }

    public void endTracks() {
        Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
        for (int i11 = 0; i11 < this.bindingTrackOutputs.size(); i11++) {
            formatArr[i11] = (Format) Assertions.checkStateNotNull(this.bindingTrackOutputs.valueAt(i11).sampleFormat);
        }
        this.sampleFormats = formatArr;
    }

    public ChunkIndex getChunkIndex() {
        SeekMap seekMap2 = this.seekMap;
        if (seekMap2 instanceof ChunkIndex) {
            return (ChunkIndex) seekMap2;
        }
        return null;
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider2, long j11, long j12) {
        this.trackOutputProvider = trackOutputProvider2;
        this.endTimeUs = j12;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            if (j11 != -9223372036854775807L) {
                this.extractor.seek(0, j11);
            }
            this.extractorInitialized = true;
            return;
        }
        Extractor extractor2 = this.extractor;
        if (j11 == -9223372036854775807L) {
            j11 = 0;
        }
        extractor2.seek(0, j11);
        for (int i11 = 0; i11 < this.bindingTrackOutputs.size(); i11++) {
            this.bindingTrackOutputs.valueAt(i11).bind(trackOutputProvider2, j12);
        }
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        int read = this.extractor.read(extractorInput, POSITION_HOLDER);
        Assertions.checkState(read != 1);
        if (read == 0) {
            return true;
        }
        return false;
    }

    public void release() {
        this.extractor.release();
    }

    public void seekMap(SeekMap seekMap2) {
        this.seekMap = seekMap2;
    }

    public TrackOutput track(int i11, int i12) {
        BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i11);
        if (bindingTrackOutput == null) {
            Assertions.checkState(this.sampleFormats == null);
            bindingTrackOutput = new BindingTrackOutput(i11, i12, i12 == this.primaryTrackType ? this.primaryTrackManifestFormat : null);
            bindingTrackOutput.bind(this.trackOutputProvider, this.endTimeUs);
            this.bindingTrackOutputs.put(i11, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }
}
