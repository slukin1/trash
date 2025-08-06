package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class Ac3Extractor implements Extractor {
    private static final int AC3_SYNC_WORD = 2935;
    public static final ExtractorsFactory FACTORY = a.f65903a;
    private static final int MAX_SNIFF_BYTES = 8192;
    private static final int MAX_SYNC_FRAME_SIZE = 2786;
    private final Ac3Reader reader = new Ac3Reader();
    private final ParsableByteArray sampleData = new ParsableByteArray((int) MAX_SYNC_FRAME_SIZE);
    private boolean startedPacket;

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Ac3Extractor()};
    }

    public void init(ExtractorOutput extractorOutput) {
        this.reader.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
        extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = extractorInput.read(this.sampleData.getData(), 0, MAX_SYNC_FRAME_SIZE);
        if (read == -1) {
            return -1;
        }
        this.sampleData.setPosition(0);
        this.sampleData.setLimit(read);
        if (!this.startedPacket) {
            this.reader.packetStarted(0, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.sampleData);
        return 0;
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        this.startedPacket = false;
        this.reader.seek();
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        int i11 = 0;
        while (true) {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 10);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt24() != 4801587) {
                break;
            }
            parsableByteArray.skipBytes(3);
            int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
            i11 += readSynchSafeInt + 10;
            extractorInput.advancePeekPosition(readSynchSafeInt);
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i11);
        int i12 = 0;
        int i13 = i11;
        while (true) {
            extractorInput.peekFully(parsableByteArray.getData(), 0, 6);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedShort() != AC3_SYNC_WORD) {
                extractorInput.resetPeekPosition();
                i13++;
                if (i13 - i11 >= 8192) {
                    return false;
                }
                extractorInput.advancePeekPosition(i13);
                i12 = 0;
            } else {
                i12++;
                if (i12 >= 4) {
                    return true;
                }
                int parseAc3SyncframeSize = Ac3Util.parseAc3SyncframeSize(parsableByteArray.getData());
                if (parseAc3SyncframeSize == -1) {
                    return false;
                }
                extractorInput.advancePeekPosition(parseAc3SyncframeSize - 6);
            }
        }
    }
}
