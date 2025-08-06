package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader implements ElementaryStreamReader {
    private int bytesToCheck;
    private final TrackOutput[] outputs;
    private int sampleBytesWritten;
    private long sampleTimeUs;
    private final List<TsPayloadReader.DvbSubtitleInfo> subtitleInfos;
    private boolean writingSample;

    public DvbSubtitleReader(List<TsPayloadReader.DvbSubtitleInfo> list) {
        this.subtitleInfos = list;
        this.outputs = new TrackOutput[list.size()];
    }

    private boolean checkNextByte(ParsableByteArray parsableByteArray, int i11) {
        if (parsableByteArray.bytesLeft() == 0) {
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != i11) {
            this.writingSample = false;
        }
        this.bytesToCheck--;
        return this.writingSample;
    }

    public void consume(ParsableByteArray parsableByteArray) {
        if (!this.writingSample) {
            return;
        }
        if (this.bytesToCheck != 2 || checkNextByte(parsableByteArray, 32)) {
            if (this.bytesToCheck != 1 || checkNextByte(parsableByteArray, 0)) {
                int position = parsableByteArray.getPosition();
                int bytesLeft = parsableByteArray.bytesLeft();
                for (TrackOutput sampleData : this.outputs) {
                    parsableByteArray.setPosition(position);
                    sampleData.sampleData(parsableByteArray, bytesLeft);
                }
                this.sampleBytesWritten += bytesLeft;
            }
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        for (int i11 = 0; i11 < this.outputs.length; i11++) {
            TsPayloadReader.DvbSubtitleInfo dvbSubtitleInfo = this.subtitleInfos.get(i11);
            trackIdGenerator.generateNewId();
            TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 3);
            track.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_DVBSUBS).setInitializationData(Collections.singletonList(dvbSubtitleInfo.initializationData)).setLanguage(dvbSubtitleInfo.language).build());
            this.outputs[i11] = track;
        }
    }

    public void packetFinished() {
        if (this.writingSample) {
            for (TrackOutput sampleMetadata : this.outputs) {
                sampleMetadata.sampleMetadata(this.sampleTimeUs, 1, this.sampleBytesWritten, 0, (TrackOutput.CryptoData) null);
            }
            this.writingSample = false;
        }
    }

    public void packetStarted(long j11, int i11) {
        if ((i11 & 4) != 0) {
            this.writingSample = true;
            this.sampleTimeUs = j11;
            this.sampleBytesWritten = 0;
            this.bytesToCheck = 2;
        }
    }

    public void seek() {
        this.writingSample = false;
    }
}
