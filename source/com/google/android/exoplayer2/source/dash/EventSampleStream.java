package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class EventSampleStream implements SampleStream {
    private int currentIndex;
    private final EventMessageEncoder eventMessageEncoder = new EventMessageEncoder();
    private EventStream eventStream;
    private boolean eventStreamAppendable;
    private long[] eventTimesUs;
    private boolean isFormatSentDownstream;
    private long pendingSeekPositionUs = -9223372036854775807L;
    private final Format upstreamFormat;

    public EventSampleStream(EventStream eventStream2, Format format, boolean z11) {
        this.upstreamFormat = format;
        this.eventStream = eventStream2;
        this.eventTimesUs = eventStream2.presentationTimesUs;
        updateEventStream(eventStream2, z11);
    }

    public String eventStreamId() {
        return this.eventStream.id();
    }

    public boolean isReady() {
        return true;
    }

    public void maybeThrowError() throws IOException {
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
        if ((i11 & 2) != 0 || !this.isFormatSentDownstream) {
            formatHolder.format = this.upstreamFormat;
            this.isFormatSentDownstream = true;
            return -5;
        }
        int i12 = this.currentIndex;
        if (i12 != this.eventTimesUs.length) {
            this.currentIndex = i12 + 1;
            byte[] encode = this.eventMessageEncoder.encode(this.eventStream.events[i12]);
            decoderInputBuffer.ensureSpaceForWrite(encode.length);
            decoderInputBuffer.data.put(encode);
            decoderInputBuffer.timeUs = this.eventTimesUs[i12];
            decoderInputBuffer.setFlags(1);
            return -4;
        } else if (this.eventStreamAppendable) {
            return -3;
        } else {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
    }

    public void seekToUs(long j11) {
        boolean z11 = true;
        int binarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j11, true, false);
        this.currentIndex = binarySearchCeil;
        if (!this.eventStreamAppendable || binarySearchCeil != this.eventTimesUs.length) {
            z11 = false;
        }
        if (!z11) {
            j11 = -9223372036854775807L;
        }
        this.pendingSeekPositionUs = j11;
    }

    public int skipData(long j11) {
        int max = Math.max(this.currentIndex, Util.binarySearchCeil(this.eventTimesUs, j11, true, false));
        int i11 = max - this.currentIndex;
        this.currentIndex = max;
        return i11;
    }

    public void updateEventStream(EventStream eventStream2, boolean z11) {
        int i11 = this.currentIndex;
        long j11 = i11 == 0 ? -9223372036854775807L : this.eventTimesUs[i11 - 1];
        this.eventStreamAppendable = z11;
        this.eventStream = eventStream2;
        long[] jArr = eventStream2.presentationTimesUs;
        this.eventTimesUs = jArr;
        long j12 = this.pendingSeekPositionUs;
        if (j12 != -9223372036854775807L) {
            seekToUs(j12);
        } else if (j11 != -9223372036854775807L) {
            this.currentIndex = Util.binarySearchCeil(jArr, j11, false, false);
        }
    }
}
