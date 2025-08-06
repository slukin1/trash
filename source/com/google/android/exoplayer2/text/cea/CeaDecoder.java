package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class CeaDecoder implements SubtitleDecoder {
    private static final int NUM_INPUT_BUFFERS = 10;
    private static final int NUM_OUTPUT_BUFFERS = 2;
    private final ArrayDeque<CeaInputBuffer> availableInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<SubtitleOutputBuffer> availableOutputBuffers;
    private CeaInputBuffer dequeuedInputBuffer;
    private long playbackPositionUs;
    private long queuedInputBufferCount;
    private final PriorityQueue<CeaInputBuffer> queuedInputBuffers;

    public static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {
        /* access modifiers changed from: private */
        public long queuedInputBufferCount;

        private CeaInputBuffer() {
        }

        public int compareTo(CeaInputBuffer ceaInputBuffer) {
            if (isEndOfStream() == ceaInputBuffer.isEndOfStream()) {
                long j11 = this.timeUs - ceaInputBuffer.timeUs;
                if (j11 == 0) {
                    j11 = this.queuedInputBufferCount - ceaInputBuffer.queuedInputBufferCount;
                    if (j11 == 0) {
                        return 0;
                    }
                }
                if (j11 > 0) {
                    return 1;
                }
                return -1;
            } else if (isEndOfStream()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static final class CeaOutputBuffer extends SubtitleOutputBuffer {
        private OutputBuffer.Owner<CeaOutputBuffer> owner;

        public CeaOutputBuffer(OutputBuffer.Owner<CeaOutputBuffer> owner2) {
            this.owner = owner2;
        }

        public final void release() {
            this.owner.releaseOutputBuffer(this);
        }
    }

    public CeaDecoder() {
        for (int i11 = 0; i11 < 10; i11++) {
            this.availableInputBuffers.add(new CeaInputBuffer());
        }
        this.availableOutputBuffers = new ArrayDeque<>();
        for (int i12 = 0; i12 < 2; i12++) {
            this.availableOutputBuffers.add(new CeaOutputBuffer(new b(this)));
        }
        this.queuedInputBuffers = new PriorityQueue<>();
    }

    private void releaseInputBuffer(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.clear();
        this.availableInputBuffers.add(ceaInputBuffer);
    }

    public abstract Subtitle createSubtitle();

    public abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    public void flush() {
        this.queuedInputBufferCount = 0;
        this.playbackPositionUs = 0;
        while (!this.queuedInputBuffers.isEmpty()) {
            releaseInputBuffer((CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.poll()));
        }
        CeaInputBuffer ceaInputBuffer = this.dequeuedInputBuffer;
        if (ceaInputBuffer != null) {
            releaseInputBuffer(ceaInputBuffer);
            this.dequeuedInputBuffer = null;
        }
    }

    public final SubtitleOutputBuffer getAvailableOutputBuffer() {
        return this.availableOutputBuffers.pollFirst();
    }

    public abstract String getName();

    public final long getPositionUs() {
        return this.playbackPositionUs;
    }

    public abstract boolean isNewSubtitleDataAvailable();

    public void release() {
    }

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.availableOutputBuffers.add(subtitleOutputBuffer);
    }

    public void setPositionUs(long j11) {
        this.playbackPositionUs = j11;
    }

    public SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        Assertions.checkState(this.dequeuedInputBuffer == null);
        if (this.availableInputBuffers.isEmpty()) {
            return null;
        }
        CeaInputBuffer pollFirst = this.availableInputBuffers.pollFirst();
        this.dequeuedInputBuffer = pollFirst;
        return pollFirst;
    }

    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        if (this.availableOutputBuffers.isEmpty()) {
            return null;
        }
        while (!this.queuedInputBuffers.isEmpty() && ((CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.peek())).timeUs <= this.playbackPositionUs) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) Util.castNonNull(this.queuedInputBuffers.poll());
            if (ceaInputBuffer.isEndOfStream()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.castNonNull(this.availableOutputBuffers.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                releaseInputBuffer(ceaInputBuffer);
                return subtitleOutputBuffer;
            }
            decode(ceaInputBuffer);
            if (isNewSubtitleDataAvailable()) {
                Subtitle createSubtitle = createSubtitle();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.castNonNull(this.availableOutputBuffers.pollFirst());
                subtitleOutputBuffer2.setContent(ceaInputBuffer.timeUs, createSubtitle, Long.MAX_VALUE);
                releaseInputBuffer(ceaInputBuffer);
                return subtitleOutputBuffer2;
            }
            releaseInputBuffer(ceaInputBuffer);
        }
        return null;
    }

    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        Assertions.checkArgument(subtitleInputBuffer == this.dequeuedInputBuffer);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        if (ceaInputBuffer.isDecodeOnly()) {
            releaseInputBuffer(ceaInputBuffer);
        } else {
            long j11 = this.queuedInputBufferCount;
            this.queuedInputBufferCount = 1 + j11;
            long unused = ceaInputBuffer.queuedInputBufferCount = j11;
            this.queuedInputBuffers.add(ceaInputBuffer);
        }
        this.dequeuedInputBuffer = null;
    }
}
