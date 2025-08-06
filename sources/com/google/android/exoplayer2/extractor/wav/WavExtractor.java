package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class WavExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = a.f65909a;
    private static final int TARGET_SAMPLES_PER_SECOND = 10;
    private long dataEndPosition = -1;
    private int dataStartPosition = -1;
    private ExtractorOutput extractorOutput;
    private OutputWriter outputWriter;
    private TrackOutput trackOutput;

    public static final class ImaAdPcmOutputWriter implements OutputWriter {
        private static final int[] INDEX_TABLE = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] STEP_TABLE = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_FILTER, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        private final ParsableByteArray decodedData;
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final int framesPerBlock;
        private final WavHeader header;
        private final byte[] inputData;
        private long outputFrameCount;
        private int pendingInputBytes;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeFrames;
        private final TrackOutput trackOutput;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput2, TrackOutput trackOutput2, WavHeader wavHeader) throws ParserException {
            this.extractorOutput = extractorOutput2;
            this.trackOutput = trackOutput2;
            this.header = wavHeader;
            int max = Math.max(1, wavHeader.frameRateHz / 10);
            this.targetSampleSizeFrames = max;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavHeader.extraData);
            parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            this.framesPerBlock = readLittleEndianUnsignedShort;
            int i11 = wavHeader.numChannels;
            int i12 = (((wavHeader.blockSize - (i11 * 4)) * 8) / (wavHeader.bitsPerSample * i11)) + 1;
            if (readLittleEndianUnsignedShort == i12) {
                int ceilDivide = Util.ceilDivide(max, readLittleEndianUnsignedShort);
                this.inputData = new byte[(wavHeader.blockSize * ceilDivide)];
                this.decodedData = new ParsableByteArray(ceilDivide * numOutputFramesToBytes(readLittleEndianUnsignedShort, i11));
                int i13 = ((wavHeader.frameRateHz * wavHeader.blockSize) * 8) / readLittleEndianUnsignedShort;
                this.format = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setAverageBitrate(i13).setPeakBitrate(i13).setMaxInputSize(numOutputFramesToBytes(max, i11)).setChannelCount(wavHeader.numChannels).setSampleRate(wavHeader.frameRateHz).setPcmEncoding(2).build();
                return;
            }
            StringBuilder sb2 = new StringBuilder(56);
            sb2.append("Expected frames per block: ");
            sb2.append(i12);
            sb2.append("; got: ");
            sb2.append(readLittleEndianUnsignedShort);
            throw new ParserException(sb2.toString());
        }

        private void decode(byte[] bArr, int i11, ParsableByteArray parsableByteArray) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < this.header.numChannels; i13++) {
                    decodeBlockForChannel(bArr, i12, i13, parsableByteArray.getData());
                }
            }
            int numOutputFramesToBytes = numOutputFramesToBytes(this.framesPerBlock * i11);
            parsableByteArray.setPosition(0);
            parsableByteArray.setLimit(numOutputFramesToBytes);
        }

        private void decodeBlockForChannel(byte[] bArr, int i11, int i12, byte[] bArr2) {
            WavHeader wavHeader = this.header;
            int i13 = wavHeader.blockSize;
            int i14 = wavHeader.numChannels;
            int i15 = (i11 * i13) + (i12 * 4);
            int i16 = (i14 * 4) + i15;
            int i17 = (i13 / i14) - 4;
            int i18 = (short) (((bArr[i15 + 1] & 255) << 8) | (bArr[i15] & 255));
            int min = Math.min(bArr[i15 + 2] & 255, 88);
            int i19 = STEP_TABLE[min];
            int i21 = ((i11 * this.framesPerBlock * i14) + i12) * 2;
            bArr2[i21] = (byte) (i18 & 255);
            bArr2[i21 + 1] = (byte) (i18 >> 8);
            for (int i22 = 0; i22 < i17 * 2; i22++) {
                byte b11 = bArr[((i22 / 8) * i14 * 4) + i16 + ((i22 / 2) % 4)] & 255;
                int i23 = i22 % 2 == 0 ? b11 & 15 : b11 >> 4;
                int i24 = ((((i23 & 7) * 2) + 1) * i19) >> 3;
                if ((i23 & 8) != 0) {
                    i24 = -i24;
                }
                i18 = Util.constrainValue(i18 + i24, -32768, 32767);
                i21 += i14 * 2;
                bArr2[i21] = (byte) (i18 & 255);
                bArr2[i21 + 1] = (byte) (i18 >> 8);
                int i25 = min + INDEX_TABLE[i23];
                int[] iArr = STEP_TABLE;
                min = Util.constrainValue(i25, 0, iArr.length - 1);
                i19 = iArr[min];
            }
        }

        private int numOutputBytesToFrames(int i11) {
            return i11 / (this.header.numChannels * 2);
        }

        private int numOutputFramesToBytes(int i11) {
            return numOutputFramesToBytes(i11, this.header.numChannels);
        }

        private static int numOutputFramesToBytes(int i11, int i12) {
            return i11 * 2 * i12;
        }

        private void writeSampleMetadata(int i11) {
            long scaleLargeTimestamp = this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000, (long) this.header.frameRateHz);
            int numOutputFramesToBytes = numOutputFramesToBytes(i11);
            this.trackOutput.sampleMetadata(scaleLargeTimestamp, 1, numOutputFramesToBytes, this.pendingOutputBytes - numOutputFramesToBytes, (TrackOutput.CryptoData) null);
            this.outputFrameCount += (long) i11;
            this.pendingOutputBytes -= numOutputFramesToBytes;
        }

        public void init(int i11, long j11) {
            this.extractorOutput.seekMap(new WavSeekMap(this.header, this.framesPerBlock, (long) i11, j11));
            this.trackOutput.format(this.format);
        }

        public void reset(long j11) {
            this.pendingInputBytes = 0;
            this.startTimeUs = j11;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003e A[EDGE_INSN: B:22:0x003e->B:10:0x003e ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0020  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean sampleData(com.google.android.exoplayer2.extractor.ExtractorInput r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.targetSampleSizeFrames
                int r1 = r6.pendingOutputBytes
                int r1 = r6.numOutputBytesToFrames(r1)
                int r0 = r0 - r1
                int r1 = r6.framesPerBlock
                int r0 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r1)
                com.google.android.exoplayer2.extractor.wav.WavHeader r1 = r6.header
                int r1 = r1.blockSize
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L_0x001d
            L_0x001b:
                r1 = r2
                goto L_0x001e
            L_0x001d:
                r1 = 0
            L_0x001e:
                if (r1 != 0) goto L_0x003e
                int r3 = r6.pendingInputBytes
                if (r3 >= r0) goto L_0x003e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.inputData
                int r5 = r6.pendingInputBytes
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L_0x0038
                goto L_0x001b
            L_0x0038:
                int r4 = r6.pendingInputBytes
                int r4 = r4 + r3
                r6.pendingInputBytes = r4
                goto L_0x001e
            L_0x003e:
                int r7 = r6.pendingInputBytes
                com.google.android.exoplayer2.extractor.wav.WavHeader r8 = r6.header
                int r8 = r8.blockSize
                int r7 = r7 / r8
                if (r7 <= 0) goto L_0x0075
                byte[] r8 = r6.inputData
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.decodedData
                r6.decode(r8, r7, r9)
                int r8 = r6.pendingInputBytes
                com.google.android.exoplayer2.extractor.wav.WavHeader r9 = r6.header
                int r9 = r9.blockSize
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.pendingInputBytes = r8
                com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.decodedData
                int r7 = r7.limit()
                com.google.android.exoplayer2.extractor.TrackOutput r8 = r6.trackOutput
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.decodedData
                r8.sampleData(r9, r7)
                int r8 = r6.pendingOutputBytes
                int r8 = r8 + r7
                r6.pendingOutputBytes = r8
                int r7 = r6.numOutputBytesToFrames(r8)
                int r8 = r6.targetSampleSizeFrames
                if (r7 < r8) goto L_0x0075
                r6.writeSampleMetadata(r8)
            L_0x0075:
                if (r1 == 0) goto L_0x0082
                int r7 = r6.pendingOutputBytes
                int r7 = r6.numOutputBytesToFrames(r7)
                if (r7 <= 0) goto L_0x0082
                r6.writeSampleMetadata(r7)
            L_0x0082:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.sampleData(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
        }
    }

    public interface OutputWriter {
        void init(int i11, long j11) throws ParserException;

        void reset(long j11);

        boolean sampleData(ExtractorInput extractorInput, long j11) throws IOException;
    }

    public static final class PassthroughOutputWriter implements OutputWriter {
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final WavHeader header;
        private long outputFrameCount;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeBytes;
        private final TrackOutput trackOutput;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput2, TrackOutput trackOutput2, WavHeader wavHeader, String str, int i11) throws ParserException {
            this.extractorOutput = extractorOutput2;
            this.trackOutput = trackOutput2;
            this.header = wavHeader;
            int i12 = (wavHeader.numChannels * wavHeader.bitsPerSample) / 8;
            if (wavHeader.blockSize == i12) {
                int i13 = wavHeader.frameRateHz;
                int i14 = i13 * i12 * 8;
                int max = Math.max(i12, (i13 * i12) / 10);
                this.targetSampleSizeBytes = max;
                this.format = new Format.Builder().setSampleMimeType(str).setAverageBitrate(i14).setPeakBitrate(i14).setMaxInputSize(max).setChannelCount(wavHeader.numChannels).setSampleRate(wavHeader.frameRateHz).setPcmEncoding(i11).build();
                return;
            }
            int i15 = wavHeader.blockSize;
            StringBuilder sb2 = new StringBuilder(50);
            sb2.append("Expected block size: ");
            sb2.append(i12);
            sb2.append("; got: ");
            sb2.append(i15);
            throw new ParserException(sb2.toString());
        }

        public void init(int i11, long j11) {
            this.extractorOutput.seekMap(new WavSeekMap(this.header, 1, (long) i11, j11));
            this.trackOutput.format(this.format);
        }

        public void reset(long j11) {
            this.startTimeUs = j11;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0;
        }

        public boolean sampleData(ExtractorInput extractorInput, long j11) throws IOException {
            int i11;
            int i12;
            int i13;
            long j12 = j11;
            while (true) {
                i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
                if (i11 <= 0 || (i12 = this.pendingOutputBytes) >= (i13 = this.targetSampleSizeBytes)) {
                    WavHeader wavHeader = this.header;
                    int i14 = wavHeader.blockSize;
                    int i15 = this.pendingOutputBytes / i14;
                } else {
                    int sampleData = this.trackOutput.sampleData((DataReader) extractorInput, (int) Math.min((long) (i13 - i12), j12), true);
                    if (sampleData == -1) {
                        j12 = 0;
                    } else {
                        this.pendingOutputBytes += sampleData;
                        j12 -= (long) sampleData;
                    }
                }
            }
            WavHeader wavHeader2 = this.header;
            int i142 = wavHeader2.blockSize;
            int i152 = this.pendingOutputBytes / i142;
            if (i152 > 0) {
                int i16 = i152 * i142;
                int i17 = this.pendingOutputBytes - i16;
                this.trackOutput.sampleMetadata(this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000, (long) wavHeader2.frameRateHz), 1, i16, i17, (TrackOutput.CryptoData) null);
                this.outputFrameCount += (long) i152;
                this.pendingOutputBytes = i17;
            }
            if (i11 <= 0) {
                return true;
            }
            return false;
        }
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new WavExtractor()};
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        extractorOutput2.endTracks();
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        if (this.outputWriter == null) {
            WavHeader peek = WavHeaderReader.peek(extractorInput);
            if (peek != null) {
                int i11 = peek.formatType;
                if (i11 == 17) {
                    this.outputWriter = new ImaAdPcmOutputWriter(this.extractorOutput, this.trackOutput, peek);
                } else if (i11 == 6) {
                    this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, peek, MimeTypes.AUDIO_ALAW, -1);
                } else if (i11 == 7) {
                    this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, peek, MimeTypes.AUDIO_MLAW, -1);
                } else {
                    int pcmEncodingForType = WavUtil.getPcmEncodingForType(i11, peek.bitsPerSample);
                    if (pcmEncodingForType != 0) {
                        this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, peek, MimeTypes.AUDIO_RAW, pcmEncodingForType);
                    } else {
                        int i12 = peek.formatType;
                        StringBuilder sb2 = new StringBuilder(40);
                        sb2.append("Unsupported WAV format type: ");
                        sb2.append(i12);
                        throw new ParserException(sb2.toString());
                    }
                }
            } else {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
        }
        if (this.dataStartPosition == -1) {
            Pair<Long, Long> skipToData = WavHeaderReader.skipToData(extractorInput);
            this.dataStartPosition = ((Long) skipToData.first).intValue();
            long longValue = ((Long) skipToData.second).longValue();
            this.dataEndPosition = longValue;
            this.outputWriter.init(this.dataStartPosition, longValue);
        } else if (extractorInput.getPosition() == 0) {
            extractorInput.skipFully(this.dataStartPosition);
        }
        Assertions.checkState(this.dataEndPosition != -1);
        if (this.outputWriter.sampleData(extractorInput, this.dataEndPosition - extractorInput.getPosition())) {
            return -1;
        }
        return 0;
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        OutputWriter outputWriter2 = this.outputWriter;
        if (outputWriter2 != null) {
            outputWriter2.reset(j12);
        }
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return WavHeaderReader.peek(extractorInput) != null;
    }
}
