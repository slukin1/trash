package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.io.IOException;

final class PsBinarySearchSeeker extends BinarySearchSeeker {
    private static final int MINIMUM_SEARCH_RANGE_BYTES = 1000;
    private static final long SEEK_TOLERANCE_US = 100000;
    private static final int TIMESTAMP_SEARCH_BYTES = 20000;

    public static final class PsScrSeeker implements BinarySearchSeeker.TimestampSeeker {
        private final ParsableByteArray packetBuffer;
        private final TimestampAdjuster scrTimestampAdjuster;

        private BinarySearchSeeker.TimestampSearchResult searchForScrValueInBuffer(ParsableByteArray parsableByteArray, long j11, long j12) {
            int i11 = -1;
            int i12 = -1;
            long j13 = -9223372036854775807L;
            while (parsableByteArray.bytesLeft() >= 4) {
                if (PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.getData(), parsableByteArray.getPosition()) != 442) {
                    parsableByteArray.skipBytes(1);
                } else {
                    parsableByteArray.skipBytes(4);
                    long readScrValueFromPack = PsDurationReader.readScrValueFromPack(parsableByteArray);
                    if (readScrValueFromPack != -9223372036854775807L) {
                        long adjustTsTimestamp = this.scrTimestampAdjuster.adjustTsTimestamp(readScrValueFromPack);
                        if (adjustTsTimestamp > j11) {
                            if (j13 == -9223372036854775807L) {
                                return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, j12);
                            }
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j12 + ((long) i12));
                        } else if (100000 + adjustTsTimestamp > j11) {
                            return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j12 + ((long) parsableByteArray.getPosition()));
                        } else {
                            i12 = parsableByteArray.getPosition();
                            j13 = adjustTsTimestamp;
                        }
                    }
                    skipToEndOfCurrentPack(parsableByteArray);
                    i11 = parsableByteArray.getPosition();
                }
            }
            if (j13 != -9223372036854775807L) {
                return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j13, j12 + ((long) i11));
            }
            return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        private static void skipToEndOfCurrentPack(ParsableByteArray parsableByteArray) {
            int limit = parsableByteArray.limit();
            if (parsableByteArray.bytesLeft() < 10) {
                parsableByteArray.setPosition(limit);
                return;
            }
            parsableByteArray.skipBytes(9);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 7;
            if (parsableByteArray.bytesLeft() < readUnsignedByte) {
                parsableByteArray.setPosition(limit);
                return;
            }
            parsableByteArray.skipBytes(readUnsignedByte);
            if (parsableByteArray.bytesLeft() < 4) {
                parsableByteArray.setPosition(limit);
                return;
            }
            if (PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.getData(), parsableByteArray.getPosition()) == 443) {
                parsableByteArray.skipBytes(4);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                if (parsableByteArray.bytesLeft() < readUnsignedShort) {
                    parsableByteArray.setPosition(limit);
                    return;
                }
                parsableByteArray.skipBytes(readUnsignedShort);
            }
            while (parsableByteArray.bytesLeft() >= 4 && (r1 = PsBinarySearchSeeker.peekIntAtPosition(parsableByteArray.getData(), parsableByteArray.getPosition())) != 442 && r1 != 441 && (r1 >>> 8) == 1) {
                parsableByteArray.skipBytes(4);
                if (parsableByteArray.bytesLeft() < 2) {
                    parsableByteArray.setPosition(limit);
                    return;
                } else {
                    parsableByteArray.setPosition(Math.min(parsableByteArray.limit(), parsableByteArray.getPosition() + parsableByteArray.readUnsignedShort()));
                }
            }
        }

        public void onSeekFinished() {
            this.packetBuffer.reset(Util.EMPTY_BYTE_ARRAY);
        }

        public BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j11) throws IOException {
            long position = extractorInput.getPosition();
            int min = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, extractorInput.getLength() - position);
            this.packetBuffer.reset(min);
            extractorInput.peekFully(this.packetBuffer.getData(), 0, min);
            return searchForScrValueInBuffer(this.packetBuffer, j11, position);
        }

        private PsScrSeeker(TimestampAdjuster timestampAdjuster) {
            this.scrTimestampAdjuster = timestampAdjuster;
            this.packetBuffer = new ParsableByteArray();
        }
    }

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j11, long j12) {
        super(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new PsScrSeeker(timestampAdjuster), j11, 0, j11 + 1, 0, j12, 188, 1000);
    }

    /* access modifiers changed from: private */
    public static int peekIntAtPosition(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }
}
