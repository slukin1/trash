package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

abstract class StreamReader {
    private static final int STATE_END_OF_INPUT = 3;
    private static final int STATE_READ_HEADERS = 0;
    private static final int STATE_READ_PAYLOAD = 2;
    private static final int STATE_SKIP_HEADERS = 1;
    private long currentGranule;
    private ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final OggPacket oggPacket = new OggPacket();
    private OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private SetupData setupData = new SetupData();
    private int state;
    private long targetGranule;
    private TrackOutput trackOutput;

    public static class SetupData {
        public Format format;
        public OggSeeker oggSeeker;
    }

    public static final class UnseekableOggSeeker implements OggSeeker {
        private UnseekableOggSeeker() {
        }

        public SeekMap createSeekMap() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }

        public long read(ExtractorInput extractorInput) {
            return -1;
        }

        public void startSeek(long j11) {
        }
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    private boolean readHeaders(ExtractorInput extractorInput) throws IOException {
        while (this.oggPacket.populate(extractorInput)) {
            this.lengthOfReadPacket = extractorInput.getPosition() - this.payloadStartPosition;
            if (!readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData)) {
                return true;
            }
            this.payloadStartPosition = extractorInput.getPosition();
        }
        this.state = 3;
        return false;
    }

    @RequiresNonNull({"trackOutput"})
    private int readHeadersAndUpdateState(ExtractorInput extractorInput) throws IOException {
        if (!readHeaders(extractorInput)) {
            return -1;
        }
        Format format = this.setupData.format;
        this.sampleRate = format.sampleRate;
        if (!this.formatSet) {
            this.trackOutput.format(format);
            this.formatSet = true;
        }
        OggSeeker oggSeeker2 = this.setupData.oggSeeker;
        if (oggSeeker2 != null) {
            this.oggSeeker = oggSeeker2;
        } else if (extractorInput.getLength() == -1) {
            this.oggSeeker = new UnseekableOggSeeker();
        } else {
            OggPageHeader pageHeader = this.oggPacket.getPageHeader();
            this.oggSeeker = new DefaultOggSeeker(this, this.payloadStartPosition, extractorInput.getLength(), (long) (pageHeader.headerSize + pageHeader.bodySize), pageHeader.granulePosition, (pageHeader.type & 4) != 0);
        }
        this.state = 2;
        this.oggPacket.trimPayload();
        return 0;
    }

    @RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    private int readPayload(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        long read = this.oggSeeker.read(extractorInput2);
        if (read >= 0) {
            positionHolder.position = read;
            return 1;
        }
        if (read < -1) {
            onSeekEnd(-(read + 2));
        }
        if (!this.seekMapSet) {
            this.extractorOutput.seekMap((SeekMap) Assertions.checkStateNotNull(this.oggSeeker.createSeekMap()));
            this.seekMapSet = true;
        }
        if (this.lengthOfReadPacket > 0 || this.oggPacket.populate(extractorInput2)) {
            this.lengthOfReadPacket = 0;
            ParsableByteArray payload = this.oggPacket.getPayload();
            long preparePayload = preparePayload(payload);
            if (preparePayload >= 0) {
                long j11 = this.currentGranule;
                if (j11 + preparePayload >= this.targetGranule) {
                    long convertGranuleToTime = convertGranuleToTime(j11);
                    this.trackOutput.sampleData(payload, payload.limit());
                    this.trackOutput.sampleMetadata(convertGranuleToTime, 1, payload.limit(), 0, (TrackOutput.CryptoData) null);
                    this.targetGranule = -1;
                }
            }
            this.currentGranule += preparePayload;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    public long convertGranuleToTime(long j11) {
        return (j11 * 1000000) / ((long) this.sampleRate);
    }

    public long convertTimeToGranule(long j11) {
        return (((long) this.sampleRate) * j11) / 1000000;
    }

    public void init(ExtractorOutput extractorOutput2, TrackOutput trackOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = trackOutput2;
        reset(true);
    }

    public void onSeekEnd(long j11) {
        this.currentGranule = j11;
    }

    public abstract long preparePayload(ParsableByteArray parsableByteArray);

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        int i11 = this.state;
        if (i11 == 0) {
            return readHeadersAndUpdateState(extractorInput);
        }
        if (i11 == 1) {
            extractorInput.skipFully((int) this.payloadStartPosition);
            this.state = 2;
            return 0;
        } else if (i11 == 2) {
            Util.castNonNull(this.oggSeeker);
            return readPayload(extractorInput, positionHolder);
        } else if (i11 == 3) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean readHeaders(ParsableByteArray parsableByteArray, long j11, SetupData setupData2) throws IOException;

    public void reset(boolean z11) {
        if (z11) {
            this.setupData = new SetupData();
            this.payloadStartPosition = 0;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.targetGranule = -1;
        this.currentGranule = 0;
    }

    public final void seek(long j11, long j12) {
        this.oggPacket.reset();
        if (j11 == 0) {
            reset(!this.seekMapSet);
        } else if (this.state != 0) {
            this.targetGranule = convertTimeToGranule(j12);
            ((OggSeeker) Util.castNonNull(this.oggSeeker)).startSeek(this.targetGranule);
            this.state = 2;
        }
    }
}
