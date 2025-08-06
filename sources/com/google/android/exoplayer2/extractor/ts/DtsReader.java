package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DtsReader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 18;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private Format format;
    private String formatId;
    private final ParsableByteArray headerScratchBytes = new ParsableByteArray(new byte[18]);
    private final String language;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state = 0;
    private int syncBytes;
    private long timeUs;

    public DtsReader(String str) {
        this.language = str;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i11) {
        int min = Math.min(parsableByteArray.bytesLeft(), i11 - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, min);
        int i12 = this.bytesRead + min;
        this.bytesRead = i12;
        return i12 == i11;
    }

    @RequiresNonNull({"output"})
    private void parseHeader() {
        byte[] data = this.headerScratchBytes.getData();
        if (this.format == null) {
            Format parseDtsFormat = DtsUtil.parseDtsFormat(data, this.formatId, this.language, (DrmInitData) null);
            this.format = parseDtsFormat;
            this.output.format(parseDtsFormat);
        }
        this.sampleSize = DtsUtil.getDtsFrameSize(data);
        this.sampleDurationUs = (long) ((int) ((((long) DtsUtil.parseDtsAudioSampleCount(data)) * 1000000) / ((long) this.format.sampleRate)));
    }

    private boolean skipToNextSync(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i11 = this.syncBytes << 8;
            this.syncBytes = i11;
            int readUnsignedByte = i11 | parsableByteArray.readUnsignedByte();
            this.syncBytes = readUnsignedByte;
            if (DtsUtil.isSyncWord(readUnsignedByte)) {
                byte[] data = this.headerScratchBytes.getData();
                int i12 = this.syncBytes;
                data[0] = (byte) ((i12 >> 24) & 255);
                data[1] = (byte) ((i12 >> 16) & 255);
                data[2] = (byte) ((i12 >> 8) & 255);
                data[3] = (byte) (i12 & 255);
                this.bytesRead = 4;
                this.syncBytes = 0;
                return true;
            }
        }
        return false;
    }

    public void consume(ParsableByteArray parsableByteArray) {
        Assertions.checkStateNotNull(this.output);
        while (parsableByteArray.bytesLeft() > 0) {
            int i11 = this.state;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int min = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(parsableByteArray, min);
                        int i12 = this.bytesRead + min;
                        this.bytesRead = i12;
                        int i13 = this.sampleSize;
                        if (i12 == i13) {
                            this.output.sampleMetadata(this.timeUs, 1, i13, 0, (TrackOutput.CryptoData) null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.getData(), 18)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 18);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
            }
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    public void packetFinished() {
    }

    public void packetStarted(long j11, int i11) {
        this.timeUs = j11;
    }

    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.syncBytes = 0;
    }
}
