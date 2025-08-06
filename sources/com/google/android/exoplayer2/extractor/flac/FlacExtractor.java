package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class FlacExtractor implements Extractor {
    private static final int BUFFER_LENGTH = 32768;
    public static final ExtractorsFactory FACTORY = b.f65891a;
    public static final int FLAG_DISABLE_ID3_METADATA = 1;
    private static final int SAMPLE_NUMBER_UNKNOWN = -1;
    private static final int STATE_GET_FRAME_START_MARKER = 4;
    private static final int STATE_GET_STREAM_MARKER_AND_INFO_BLOCK_BYTES = 1;
    private static final int STATE_READ_FRAMES = 5;
    private static final int STATE_READ_ID3_METADATA = 0;
    private static final int STATE_READ_METADATA_BLOCKS = 3;
    private static final int STATE_READ_STREAM_MARKER = 2;
    private FlacBinarySearchSeeker binarySearchSeeker;
    private final ParsableByteArray buffer;
    private int currentFrameBytesWritten;
    private long currentFrameFirstSampleNumber;
    private ExtractorOutput extractorOutput;
    private FlacStreamMetadata flacStreamMetadata;
    private int frameStartMarker;
    private Metadata id3Metadata;
    private final boolean id3MetadataDisabled;
    private int minFrameSize;
    private final FlacFrameReader.SampleNumberHolder sampleNumberHolder;
    private int state;
    private final byte[] streamMarkerAndInfoBlock;
    private TrackOutput trackOutput;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public FlacExtractor() {
        this(0);
    }

    private long findFrame(ParsableByteArray parsableByteArray, boolean z11) {
        boolean z12;
        Assertions.checkNotNull(this.flacStreamMetadata);
        int position = parsableByteArray.getPosition();
        while (position <= parsableByteArray.limit() - 16) {
            parsableByteArray.setPosition(position);
            if (FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder)) {
                parsableByteArray.setPosition(position);
                return this.sampleNumberHolder.sampleNumber;
            }
            position++;
        }
        if (z11) {
            while (position <= parsableByteArray.limit() - this.minFrameSize) {
                parsableByteArray.setPosition(position);
                boolean z13 = false;
                try {
                    z12 = FlacFrameReader.checkAndReadFrameHeader(parsableByteArray, this.flacStreamMetadata, this.frameStartMarker, this.sampleNumberHolder);
                } catch (IndexOutOfBoundsException unused) {
                    z12 = false;
                }
                if (parsableByteArray.getPosition() <= parsableByteArray.limit()) {
                    z13 = z12;
                }
                if (z13) {
                    parsableByteArray.setPosition(position);
                    return this.sampleNumberHolder.sampleNumber;
                }
                position++;
            }
            parsableByteArray.setPosition(parsableByteArray.limit());
            return -1;
        }
        parsableByteArray.setPosition(position);
        return -1;
    }

    private void getFrameStartMarker(ExtractorInput extractorInput) throws IOException {
        this.frameStartMarker = FlacMetadataReader.getFrameStartMarker(extractorInput);
        ((ExtractorOutput) Util.castNonNull(this.extractorOutput)).seekMap(getSeekMap(extractorInput.getPosition(), extractorInput.getLength()));
        this.state = 5;
    }

    private SeekMap getSeekMap(long j11, long j12) {
        Assertions.checkNotNull(this.flacStreamMetadata);
        FlacStreamMetadata flacStreamMetadata2 = this.flacStreamMetadata;
        if (flacStreamMetadata2.seekTable != null) {
            return new FlacSeekTableSeekMap(flacStreamMetadata2, j11);
        }
        if (j12 == -1 || flacStreamMetadata2.totalSamples <= 0) {
            return new SeekMap.Unseekable(flacStreamMetadata2.getDurationUs());
        }
        FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata2, this.frameStartMarker, j11, j12);
        this.binarySearchSeeker = flacBinarySearchSeeker;
        return flacBinarySearchSeeker.getSeekMap();
    }

    private void getStreamMarkerAndInfoBlockBytes(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = this.streamMarkerAndInfoBlock;
        extractorInput.peekFully(bArr, 0, bArr.length);
        extractorInput.resetPeekPosition();
        this.state = 2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FlacExtractor()};
    }

    private void outputSampleMetadata() {
        ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata((this.currentFrameFirstSampleNumber * 1000000) / ((long) ((FlacStreamMetadata) Util.castNonNull(this.flacStreamMetadata)).sampleRate), 1, this.currentFrameBytesWritten, 0, (TrackOutput.CryptoData) null);
    }

    private int readFrames(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z11;
        Assertions.checkNotNull(this.trackOutput);
        Assertions.checkNotNull(this.flacStreamMetadata);
        FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
        if (flacBinarySearchSeeker != null && flacBinarySearchSeeker.isSeeking()) {
            return this.binarySearchSeeker.handlePendingSeek(extractorInput, positionHolder);
        }
        if (this.currentFrameFirstSampleNumber == -1) {
            this.currentFrameFirstSampleNumber = FlacFrameReader.getFirstSampleNumber(extractorInput, this.flacStreamMetadata);
            return 0;
        }
        int limit = this.buffer.limit();
        if (limit < 32768) {
            int read = extractorInput.read(this.buffer.getData(), limit, 32768 - limit);
            z11 = read == -1;
            if (!z11) {
                this.buffer.setLimit(limit + read);
            } else if (this.buffer.bytesLeft() == 0) {
                outputSampleMetadata();
                return -1;
            }
        } else {
            z11 = false;
        }
        int position = this.buffer.getPosition();
        int i11 = this.currentFrameBytesWritten;
        int i12 = this.minFrameSize;
        if (i11 < i12) {
            ParsableByteArray parsableByteArray = this.buffer;
            parsableByteArray.skipBytes(Math.min(i12 - i11, parsableByteArray.bytesLeft()));
        }
        long findFrame = findFrame(this.buffer, z11);
        int position2 = this.buffer.getPosition() - position;
        this.buffer.setPosition(position);
        this.trackOutput.sampleData(this.buffer, position2);
        this.currentFrameBytesWritten += position2;
        if (findFrame != -1) {
            outputSampleMetadata();
            this.currentFrameBytesWritten = 0;
            this.currentFrameFirstSampleNumber = findFrame;
        }
        if (this.buffer.bytesLeft() < 16) {
            int bytesLeft = this.buffer.bytesLeft();
            System.arraycopy(this.buffer.getData(), this.buffer.getPosition(), this.buffer.getData(), 0, bytesLeft);
            this.buffer.setPosition(0);
            this.buffer.setLimit(bytesLeft);
        }
        return 0;
    }

    private void readId3Metadata(ExtractorInput extractorInput) throws IOException {
        this.id3Metadata = FlacMetadataReader.readId3Metadata(extractorInput, !this.id3MetadataDisabled);
        this.state = 1;
    }

    private void readMetadataBlocks(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.FlacStreamMetadataHolder flacStreamMetadataHolder = new FlacMetadataReader.FlacStreamMetadataHolder(this.flacStreamMetadata);
        boolean z11 = false;
        while (!z11) {
            z11 = FlacMetadataReader.readMetadataBlock(extractorInput, flacStreamMetadataHolder);
            this.flacStreamMetadata = (FlacStreamMetadata) Util.castNonNull(flacStreamMetadataHolder.flacStreamMetadata);
        }
        Assertions.checkNotNull(this.flacStreamMetadata);
        this.minFrameSize = Math.max(this.flacStreamMetadata.minFrameSize, 6);
        ((TrackOutput) Util.castNonNull(this.trackOutput)).format(this.flacStreamMetadata.getFormat(this.streamMarkerAndInfoBlock, this.id3Metadata));
        this.state = 4;
    }

    private void readStreamMarker(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.readStreamMarker(extractorInput);
        this.state = 3;
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        extractorOutput2.endTracks();
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i11 = this.state;
        if (i11 == 0) {
            readId3Metadata(extractorInput);
            return 0;
        } else if (i11 == 1) {
            getStreamMarkerAndInfoBlockBytes(extractorInput);
            return 0;
        } else if (i11 == 2) {
            readStreamMarker(extractorInput);
            return 0;
        } else if (i11 == 3) {
            readMetadataBlocks(extractorInput);
            return 0;
        } else if (i11 == 4) {
            getFrameStartMarker(extractorInput);
            return 0;
        } else if (i11 == 5) {
            return readFrames(extractorInput, positionHolder);
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        long j13 = 0;
        if (j11 == 0) {
            this.state = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.binarySearchSeeker;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.setSeekTargetUs(j12);
            }
        }
        if (j12 != 0) {
            j13 = -1;
        }
        this.currentFrameFirstSampleNumber = j13;
        this.currentFrameBytesWritten = 0;
        this.buffer.reset(0);
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        FlacMetadataReader.peekId3Metadata(extractorInput, false);
        return FlacMetadataReader.checkAndPeekStreamMarker(extractorInput);
    }

    public FlacExtractor(int i11) {
        this.streamMarkerAndInfoBlock = new byte[42];
        this.buffer = new ParsableByteArray(new byte[32768], 0);
        this.id3MetadataDisabled = (i11 & 1) == 0 ? false : true;
        this.sampleNumberHolder = new FlacFrameReader.SampleNumberHolder();
        this.state = 0;
    }
}
