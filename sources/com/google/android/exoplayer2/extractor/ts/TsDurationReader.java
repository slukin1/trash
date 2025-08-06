package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class TsDurationReader {
    private long durationUs = -9223372036854775807L;
    private long firstPcrValue = -9223372036854775807L;
    private boolean isDurationRead;
    private boolean isFirstPcrValueRead;
    private boolean isLastPcrValueRead;
    private long lastPcrValue = -9223372036854775807L;
    private final ParsableByteArray packetBuffer = new ParsableByteArray();
    private final TimestampAdjuster pcrTimestampAdjuster = new TimestampAdjuster(0);
    private final int timestampSearchBytes;

    public TsDurationReader(int i11) {
        this.timestampSearchBytes = i11;
    }

    private int finishReadDuration(ExtractorInput extractorInput) {
        this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        this.isDurationRead = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    private int readFirstPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int i11) throws IOException {
        int min = (int) Math.min((long) this.timestampSearchBytes, extractorInput.getLength());
        long j11 = (long) 0;
        if (extractorInput.getPosition() != j11) {
            positionHolder.position = j11;
            return 1;
        }
        this.packetBuffer.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.getData(), 0, min);
        this.firstPcrValue = readFirstPcrValueFromBuffer(this.packetBuffer, i11);
        this.isFirstPcrValueRead = true;
        return 0;
    }

    private long readFirstPcrValueFromBuffer(ParsableByteArray parsableByteArray, int i11) {
        int limit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < limit; position++) {
            if (parsableByteArray.getData()[position] == 71) {
                long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, position, i11);
                if (readPcrFromPacket != -9223372036854775807L) {
                    return readPcrFromPacket;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int readLastPcrValue(ExtractorInput extractorInput, PositionHolder positionHolder, int i11) throws IOException {
        long length = extractorInput.getLength();
        int min = (int) Math.min((long) this.timestampSearchBytes, length);
        long j11 = length - ((long) min);
        if (extractorInput.getPosition() != j11) {
            positionHolder.position = j11;
            return 1;
        }
        this.packetBuffer.reset(min);
        extractorInput.resetPeekPosition();
        extractorInput.peekFully(this.packetBuffer.getData(), 0, min);
        this.lastPcrValue = readLastPcrValueFromBuffer(this.packetBuffer, i11);
        this.isLastPcrValueRead = true;
        return 0;
    }

    private long readLastPcrValueFromBuffer(ParsableByteArray parsableByteArray, int i11) {
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (true) {
            limit--;
            if (limit < position) {
                return -9223372036854775807L;
            }
            if (parsableByteArray.getData()[limit] == 71) {
                long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, limit, i11);
                if (readPcrFromPacket != -9223372036854775807L) {
                    return readPcrFromPacket;
                }
            }
        }
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TimestampAdjuster getPcrTimestampAdjuster() {
        return this.pcrTimestampAdjuster;
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(ExtractorInput extractorInput, PositionHolder positionHolder, int i11) throws IOException {
        if (i11 <= 0) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isLastPcrValueRead) {
            return readLastPcrValue(extractorInput, positionHolder, i11);
        }
        if (this.lastPcrValue == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        if (!this.isFirstPcrValueRead) {
            return readFirstPcrValue(extractorInput, positionHolder, i11);
        }
        long j11 = this.firstPcrValue;
        if (j11 == -9223372036854775807L) {
            return finishReadDuration(extractorInput);
        }
        this.durationUs = this.pcrTimestampAdjuster.adjustTsTimestamp(this.lastPcrValue) - this.pcrTimestampAdjuster.adjustTsTimestamp(j11);
        return finishReadDuration(extractorInput);
    }
}
