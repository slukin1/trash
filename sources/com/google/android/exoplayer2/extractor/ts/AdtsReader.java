package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import net.sf.scuba.smartcards.ISO7816;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class AdtsReader implements ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER = {73, ISO7816.INS_REHABILITATE_CHV, 51};
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 512;
    private static final int MATCH_STATE_I = 768;
    private static final int MATCH_STATE_ID = 1024;
    private static final int MATCH_STATE_START = 256;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_CHECKING_ADTS_HEADER = 1;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 3;
    private static final int STATE_READING_ID3_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 4;
    private static final String TAG = "AdtsReader";
    private static final int VERSION_UNSET = -1;
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private int currentFrameVersion;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private int firstFrameSampleRateIndex;
    private int firstFrameVersion;
    private String formatId;
    private boolean foundFirstFrame;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;
    private final String language;
    private int matchState;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public AdtsReader(boolean z11) {
        this(z11, (String) null);
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void assertTracksCreated() {
        Assertions.checkNotNull(this.output);
        Util.castNonNull(this.currentOutput);
        Util.castNonNull(this.id3Output);
    }

    private void checkAdtsHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() != 0) {
            this.adtsScratch.data[0] = parsableByteArray.getData()[parsableByteArray.getPosition()];
            this.adtsScratch.setPosition(2);
            int readBits = this.adtsScratch.readBits(4);
            int i11 = this.firstFrameSampleRateIndex;
            if (i11 == -1 || readBits == i11) {
                if (!this.foundFirstFrame) {
                    this.foundFirstFrame = true;
                    this.firstFrameVersion = this.currentFrameVersion;
                    this.firstFrameSampleRateIndex = readBits;
                }
                setReadingAdtsHeaderState();
                return;
            }
            resetSync();
        }
    }

    private boolean checkSyncPositionValid(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.setPosition(i11 + 1);
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
            return false;
        }
        this.adtsScratch.setPosition(4);
        int readBits = this.adtsScratch.readBits(1);
        int i12 = this.firstFrameVersion;
        if (i12 != -1 && readBits != i12) {
            return false;
        }
        if (this.firstFrameSampleRateIndex != -1) {
            if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
                return true;
            }
            this.adtsScratch.setPosition(2);
            if (this.adtsScratch.readBits(4) != this.firstFrameSampleRateIndex) {
                return false;
            }
            parsableByteArray.setPosition(i11 + 2);
        }
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 4)) {
            return true;
        }
        this.adtsScratch.setPosition(14);
        int readBits2 = this.adtsScratch.readBits(13);
        if (readBits2 < 7) {
            return false;
        }
        byte[] data = parsableByteArray.getData();
        int limit = parsableByteArray.limit();
        int i13 = i11 + readBits2;
        if (i13 >= limit) {
            return true;
        }
        if (data[i13] == -1) {
            int i14 = i13 + 1;
            if (i14 == limit) {
                return true;
            }
            if (!isAdtsSyncBytes((byte) -1, data[i14]) || ((data[i14] & 8) >> 3) != readBits) {
                return false;
            }
            return true;
        } else if (data[i13] != 73) {
            return false;
        } else {
            int i15 = i13 + 1;
            if (i15 == limit) {
                return true;
            }
            if (data[i15] != 68) {
                return false;
            }
            int i16 = i13 + 2;
            if (i16 == limit || data[i16] == 51) {
                return true;
            }
            return false;
        }
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i11) {
        int min = Math.min(parsableByteArray.bytesLeft(), i11 - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        int i12 = this.bytesRead + min;
        this.bytesRead = i12;
        return i12 == i11;
    }

    private void findNextSample(ParsableByteArray parsableByteArray) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit) {
            int i11 = position + 1;
            byte b11 = data[position] & 255;
            if (this.matchState != 512 || !isAdtsSyncBytes((byte) -1, (byte) b11) || (!this.foundFirstFrame && !checkSyncPositionValid(parsableByteArray, i11 - 2))) {
                int i12 = this.matchState;
                byte b12 = b11 | i12;
                if (b12 == 329) {
                    this.matchState = MATCH_STATE_I;
                } else if (b12 == 511) {
                    this.matchState = 512;
                } else if (b12 == 836) {
                    this.matchState = 1024;
                } else if (b12 == 1075) {
                    setReadingId3HeaderState();
                    parsableByteArray.setPosition(i11);
                    return;
                } else if (i12 != 256) {
                    this.matchState = 256;
                    i11--;
                }
                position = i11;
            } else {
                this.currentFrameVersion = (b11 & 8) >> 3;
                boolean z11 = true;
                if ((b11 & 1) != 0) {
                    z11 = false;
                }
                this.hasCrc = z11;
                if (!this.foundFirstFrame) {
                    setCheckingAdtsHeaderState();
                } else {
                    setReadingAdtsHeaderState();
                }
                parsableByteArray.setPosition(i11);
                return;
            }
        }
        parsableByteArray.setPosition(position);
    }

    private boolean isAdtsSyncBytes(byte b11, byte b12) {
        return isAdtsSyncWord(((b11 & 255) << 8) | (b12 & 255));
    }

    public static boolean isAdtsSyncWord(int i11) {
        return (i11 & 65526) == 65520;
    }

    @RequiresNonNull({"output"})
    private void parseAdtsHeader() throws ParserException {
        this.adtsScratch.setPosition(0);
        if (!this.hasOutputFormat) {
            int readBits = this.adtsScratch.readBits(2) + 1;
            if (readBits != 2) {
                StringBuilder sb2 = new StringBuilder(61);
                sb2.append("Detected audio object type: ");
                sb2.append(readBits);
                sb2.append(", but assuming AAC LC.");
                Log.w(TAG, sb2.toString());
                readBits = 2;
            }
            this.adtsScratch.skipBits(5);
            byte[] buildAudioSpecificConfig = AacUtil.buildAudioSpecificConfig(readBits, this.firstFrameSampleRateIndex, this.adtsScratch.readBits(3));
            AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(buildAudioSpecificConfig);
            Format build = new Format.Builder().setId(this.formatId).setSampleMimeType(MimeTypes.AUDIO_AAC).setCodecs(parseAudioSpecificConfig.codecs).setChannelCount(parseAudioSpecificConfig.channelCount).setSampleRate(parseAudioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(buildAudioSpecificConfig)).setLanguage(this.language).build();
            this.sampleDurationUs = 1024000000 / ((long) build.sampleRate);
            this.output.format(build);
            this.hasOutputFormat = true;
        } else {
            this.adtsScratch.skipBits(10);
        }
        this.adtsScratch.skipBits(4);
        int readBits2 = (this.adtsScratch.readBits(13) - 2) - 5;
        if (this.hasCrc) {
            readBits2 -= 2;
        }
        setReadingSampleState(this.output, this.sampleDurationUs, 0, readBits2);
    }

    @RequiresNonNull({"id3Output"})
    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        setReadingSampleState(this.id3Output, 0, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    @RequiresNonNull({"currentOutput"})
    private void readSample(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(parsableByteArray, min);
        int i11 = this.bytesRead + min;
        this.bytesRead = i11;
        int i12 = this.sampleSize;
        if (i11 == i12) {
            this.currentOutput.sampleMetadata(this.timeUs, 1, i12, 0, (TrackOutput.CryptoData) null);
            this.timeUs += this.currentSampleDuration;
            setFindingSampleState();
        }
    }

    private void resetSync() {
        this.foundFirstFrame = false;
        setFindingSampleState();
    }

    private void setCheckingAdtsHeaderState() {
        this.state = 1;
        this.bytesRead = 0;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 3;
        this.bytesRead = 0;
    }

    private void setReadingId3HeaderState() {
        this.state = 2;
        this.bytesRead = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput trackOutput, long j11, int i11, int i12) {
        this.state = 4;
        this.bytesRead = i11;
        this.currentOutput = trackOutput;
        this.currentSampleDuration = j11;
        this.sampleSize = i12;
    }

    private boolean tryRead(ParsableByteArray parsableByteArray, byte[] bArr, int i11) {
        if (parsableByteArray.bytesLeft() < i11) {
            return false;
        }
        parsableByteArray.readBytes(bArr, 0, i11);
        return true;
    }

    public void consume(ParsableByteArray parsableByteArray) throws ParserException {
        assertTracksCreated();
        while (parsableByteArray.bytesLeft() > 0) {
            int i11 = this.state;
            if (i11 == 0) {
                findNextSample(parsableByteArray);
            } else if (i11 == 1) {
                checkAdtsHeader(parsableByteArray);
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (continueRead(parsableByteArray, this.adtsScratch.data, this.hasCrc ? 7 : 5)) {
                        parseAdtsHeader();
                    }
                } else if (i11 == 4) {
                    readSample(parsableByteArray);
                } else {
                    throw new IllegalStateException();
                }
            } else if (continueRead(parsableByteArray, this.id3HeaderBuffer.getData(), 10)) {
                parseId3Header();
            }
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.output = track;
        this.currentOutput = track;
        if (this.exposeId3) {
            trackIdGenerator.generateNewId();
            TrackOutput track2 = extractorOutput.track(trackIdGenerator.getTrackId(), 5);
            this.id3Output = track2;
            track2.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
            return;
        }
        this.id3Output = new DummyTrackOutput();
    }

    public long getSampleDurationUs() {
        return this.sampleDurationUs;
    }

    public void packetFinished() {
    }

    public void packetStarted(long j11, int i11) {
        this.timeUs = j11;
    }

    public void seek() {
        resetSync();
    }

    public AdtsReader(boolean z11, String str) {
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.firstFrameVersion = -1;
        this.firstFrameSampleRateIndex = -1;
        this.sampleDurationUs = -9223372036854775807L;
        this.exposeId3 = z11;
        this.language = str;
    }
}
