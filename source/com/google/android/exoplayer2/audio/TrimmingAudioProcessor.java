package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class TrimmingAudioProcessor extends BaseAudioProcessor {
    private static final int OUTPUT_ENCODING = 2;
    private byte[] endBuffer = Util.EMPTY_BYTE_ARRAY;
    private int endBufferSize;
    private int pendingTrimStartBytes;
    private boolean reconfigurationPending;
    private int trimEndFrames;
    private int trimStartFrames;
    private long trimmedFrameCount;

    public ByteBuffer getOutput() {
        int i11;
        if (super.isEnded() && (i11 = this.endBufferSize) > 0) {
            replaceOutputBuffer(i11).put(this.endBuffer, 0, this.endBufferSize).flip();
            this.endBufferSize = 0;
        }
        return super.getOutput();
    }

    public long getTrimmedFrameCount() {
        return this.trimmedFrameCount;
    }

    public boolean isEnded() {
        return super.isEnded() && this.endBufferSize == 0;
    }

    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding == 2) {
            this.reconfigurationPending = true;
            return (this.trimStartFrames == 0 && this.trimEndFrames == 0) ? AudioProcessor.AudioFormat.NOT_SET : audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public void onFlush() {
        if (this.reconfigurationPending) {
            this.reconfigurationPending = false;
            int i11 = this.trimEndFrames;
            int i12 = this.inputAudioFormat.bytesPerFrame;
            this.endBuffer = new byte[(i11 * i12)];
            this.pendingTrimStartBytes = this.trimStartFrames * i12;
        }
        this.endBufferSize = 0;
    }

    public void onQueueEndOfStream() {
        if (this.reconfigurationPending) {
            int i11 = this.endBufferSize;
            if (i11 > 0) {
                this.trimmedFrameCount += (long) (i11 / this.inputAudioFormat.bytesPerFrame);
            }
            this.endBufferSize = 0;
        }
    }

    public void onReset() {
        this.endBuffer = Util.EMPTY_BYTE_ARRAY;
    }

    public void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = limit - position;
        if (i11 != 0) {
            int min = Math.min(i11, this.pendingTrimStartBytes);
            this.trimmedFrameCount += (long) (min / this.inputAudioFormat.bytesPerFrame);
            this.pendingTrimStartBytes -= min;
            byteBuffer.position(position + min);
            if (this.pendingTrimStartBytes <= 0) {
                int i12 = i11 - min;
                int length = (this.endBufferSize + i12) - this.endBuffer.length;
                ByteBuffer replaceOutputBuffer = replaceOutputBuffer(length);
                int constrainValue = Util.constrainValue(length, 0, this.endBufferSize);
                replaceOutputBuffer.put(this.endBuffer, 0, constrainValue);
                int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i12);
                byteBuffer.limit(byteBuffer.position() + constrainValue2);
                replaceOutputBuffer.put(byteBuffer);
                byteBuffer.limit(limit);
                int i13 = i12 - constrainValue2;
                int i14 = this.endBufferSize - constrainValue;
                this.endBufferSize = i14;
                byte[] bArr = this.endBuffer;
                System.arraycopy(bArr, constrainValue, bArr, 0, i14);
                byteBuffer.get(this.endBuffer, this.endBufferSize, i13);
                this.endBufferSize += i13;
                replaceOutputBuffer.flip();
            }
        }
    }

    public void resetTrimmedFrameCount() {
        this.trimmedFrameCount = 0;
    }

    public void setTrimFrameCount(int i11, int i12) {
        this.trimStartFrames = i11;
        this.trimEndFrames = i12;
    }
}
