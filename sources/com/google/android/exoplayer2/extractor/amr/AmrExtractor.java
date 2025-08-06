package com.google.android.exoplayer2.extractor.amr;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class AmrExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a.f65888a;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_FRAME_SIZE_BYTES;
    private static final int NUM_SAME_SIZE_CONSTANT_BIT_RATE_THRESHOLD = 20;
    private static final int SAMPLE_RATE_NB = 8000;
    private static final int SAMPLE_RATE_WB = 16000;
    private static final int SAMPLE_TIME_PER_FRAME_US = 20000;
    private static final byte[] amrSignatureNb = Util.getUtf8Bytes("#!AMR\n");
    private static final byte[] amrSignatureWb = Util.getUtf8Bytes("#!AMR-WB\n");
    private static final int[] frameSizeBytesByTypeNb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] frameSizeBytesByTypeWb;
    private int currentSampleBytesRemaining;
    private int currentSampleSize;
    private long currentSampleTimeUs;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private int firstSampleSize;
    private final int flags;
    private boolean hasOutputFormat;
    private boolean hasOutputSeekMap;
    private boolean isWideBand;
    private int numSamplesWithSameSize;
    private final byte[] scratch;
    private SeekMap seekMap;
    private long timeOffsetUs;
    private TrackOutput trackOutput;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        frameSizeBytesByTypeWb = iArr;
        MAX_FRAME_SIZE_BYTES = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    public static byte[] amrSignatureNb() {
        byte[] bArr = amrSignatureNb;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public static byte[] amrSignatureWb() {
        byte[] bArr = amrSignatureWb;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    public static int frameSizeBytesByTypeNb(int i11) {
        return frameSizeBytesByTypeNb[i11];
    }

    public static int frameSizeBytesByTypeWb(int i11) {
        return frameSizeBytesByTypeWb[i11];
    }

    private static int getBitrateFromFrameSize(int i11, long j11) {
        return (int) ((((long) (i11 * 8)) * 1000000) / j11);
    }

    private SeekMap getConstantBitrateSeekMap(long j11) {
        return new ConstantBitrateSeekMap(j11, this.firstSamplePosition, getBitrateFromFrameSize(this.firstSampleSize, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US), this.firstSampleSize);
    }

    private int getFrameSizeInBytes(int i11) throws ParserException {
        if (isValidFrameType(i11)) {
            return this.isWideBand ? frameSizeBytesByTypeWb[i11] : frameSizeBytesByTypeNb[i11];
        }
        String str = this.isWideBand ? "WB" : "NB";
        StringBuilder sb2 = new StringBuilder(str.length() + 35);
        sb2.append("Illegal AMR ");
        sb2.append(str);
        sb2.append(" frame type ");
        sb2.append(i11);
        throw new ParserException(sb2.toString());
    }

    private boolean isNarrowBandValidFrameType(int i11) {
        return !this.isWideBand && (i11 < 12 || i11 > 14);
    }

    private boolean isValidFrameType(int i11) {
        return i11 >= 0 && i11 <= 15 && (isWideBandValidFrameType(i11) || isNarrowBandValidFrameType(i11));
    }

    private boolean isWideBandValidFrameType(int i11) {
        return this.isWideBand && (i11 < 10 || i11 > 13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new AmrExtractor()};
    }

    @RequiresNonNull({"trackOutput"})
    private void maybeOutputFormat() {
        if (!this.hasOutputFormat) {
            this.hasOutputFormat = true;
            boolean z11 = this.isWideBand;
            this.trackOutput.format(new Format.Builder().setSampleMimeType(z11 ? MimeTypes.AUDIO_AMR_WB : MimeTypes.AUDIO_AMR_NB).setMaxInputSize(MAX_FRAME_SIZE_BYTES).setChannelCount(1).setSampleRate(z11 ? 16000 : 8000).build());
        }
    }

    @RequiresNonNull({"extractorOutput"})
    private void maybeOutputSeekMap(long j11, int i11) {
        int i12;
        if (!this.hasOutputSeekMap) {
            if ((this.flags & 1) == 0 || j11 == -1 || !((i12 = this.firstSampleSize) == -1 || i12 == this.currentSampleSize)) {
                SeekMap.Unseekable unseekable = new SeekMap.Unseekable(-9223372036854775807L);
                this.seekMap = unseekable;
                this.extractorOutput.seekMap(unseekable);
                this.hasOutputSeekMap = true;
            } else if (this.numSamplesWithSameSize >= 20 || i11 == -1) {
                SeekMap constantBitrateSeekMap = getConstantBitrateSeekMap(j11);
                this.seekMap = constantBitrateSeekMap;
                this.extractorOutput.seekMap(constantBitrateSeekMap);
                this.hasOutputSeekMap = true;
            }
        }
    }

    private static boolean peekAmrSignature(ExtractorInput extractorInput, byte[] bArr) throws IOException {
        extractorInput.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int peekNextSampleSize(ExtractorInput extractorInput) throws IOException {
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.scratch, 0, 1);
        byte b11 = this.scratch[0];
        if ((b11 & ISOFileInfo.FILE_IDENTIFIER) <= 0) {
            return getFrameSizeInBytes((b11 >> 3) & 15);
        }
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("Invalid padding bits for frame header ");
        sb2.append(b11);
        throw new ParserException(sb2.toString());
    }

    private boolean readAmrHeader(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = amrSignatureNb;
        if (peekAmrSignature(extractorInput, bArr)) {
            this.isWideBand = false;
            extractorInput.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = amrSignatureWb;
        if (!peekAmrSignature(extractorInput, bArr2)) {
            return false;
        }
        this.isWideBand = true;
        extractorInput.skipFully(bArr2.length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    private int readSample(ExtractorInput extractorInput) throws IOException {
        if (this.currentSampleBytesRemaining == 0) {
            try {
                int peekNextSampleSize = peekNextSampleSize(extractorInput);
                this.currentSampleSize = peekNextSampleSize;
                this.currentSampleBytesRemaining = peekNextSampleSize;
                if (this.firstSampleSize == -1) {
                    this.firstSamplePosition = extractorInput.getPosition();
                    this.firstSampleSize = this.currentSampleSize;
                }
                if (this.firstSampleSize == this.currentSampleSize) {
                    this.numSamplesWithSameSize++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int sampleData = this.trackOutput.sampleData((DataReader) extractorInput, this.currentSampleBytesRemaining, true);
        if (sampleData == -1) {
            return -1;
        }
        int i11 = this.currentSampleBytesRemaining - sampleData;
        this.currentSampleBytesRemaining = i11;
        if (i11 > 0) {
            return 0;
        }
        this.trackOutput.sampleMetadata(this.timeOffsetUs + this.currentSampleTimeUs, 1, this.currentSampleSize, 0, (TrackOutput.CryptoData) null);
        this.currentSampleTimeUs += SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
        return 0;
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        extractorOutput2.endTracks();
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        if (extractorInput.getPosition() != 0 || readAmrHeader(extractorInput)) {
            maybeOutputFormat();
            int readSample = readSample(extractorInput);
            maybeOutputSeekMap(extractorInput.getLength(), readSample);
            return readSample;
        }
        throw new ParserException("Could not find AMR header.");
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        this.currentSampleTimeUs = 0;
        this.currentSampleSize = 0;
        this.currentSampleBytesRemaining = 0;
        if (j11 != 0) {
            SeekMap seekMap2 = this.seekMap;
            if (seekMap2 instanceof ConstantBitrateSeekMap) {
                this.timeOffsetUs = ((ConstantBitrateSeekMap) seekMap2).getTimeUsAtPosition(j11);
                return;
            }
        }
        this.timeOffsetUs = 0;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return readAmrHeader(extractorInput);
    }

    public AmrExtractor(int i11) {
        this.flags = i11;
        this.scratch = new byte[1];
        this.firstSampleSize = -1;
    }
}
