package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class AudioFormat {
        public static final AudioFormat NOT_SET = new AudioFormat(-1, -1, -1);
        public final int bytesPerFrame;
        public final int channelCount;
        public final int encoding;
        public final int sampleRate;

        public AudioFormat(int i11, int i12, int i13) {
            this.sampleRate = i11;
            this.channelCount = i12;
            this.encoding = i13;
            this.bytesPerFrame = Util.isEncodingLinearPcm(i13) ? Util.getPcmFrameSize(i13, i12) : -1;
        }

        public String toString() {
            int i11 = this.sampleRate;
            int i12 = this.channelCount;
            int i13 = this.encoding;
            StringBuilder sb2 = new StringBuilder(83);
            sb2.append("AudioFormat[sampleRate=");
            sb2.append(i11);
            sb2.append(", channelCount=");
            sb2.append(i12);
            sb2.append(", encoding=");
            sb2.append(i13);
            sb2.append(']');
            return sb2.toString();
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnhandledAudioFormatException(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                int r0 = r0 + 18
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Unhandled format: "
                r1.append(r0)
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioProcessor.UnhandledAudioFormatException.<init>(com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat):void");
        }
    }

    AudioFormat configure(AudioFormat audioFormat) throws UnhandledAudioFormatException;

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
