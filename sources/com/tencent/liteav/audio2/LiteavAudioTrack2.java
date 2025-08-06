package com.tencent.liteav.audio2;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
public class LiteavAudioTrack2 {
    private static final String TAG = "LiteavAudioTrack2";
    private AudioTrack mAudioTrack;
    private int mBufferSize = 0;
    private byte[] mPlayBuffer;
    private int mSystemOSVersion = 0;

    private static AudioTrack createStartedAudioTrack(int i11, int i12, int i13, int i14) {
        AudioTrack audioTrack;
        try {
            audioTrack = new AudioTrack(i14, i11, i12, 2, i13, 1);
            try {
                if (audioTrack.getState() == 1) {
                    audioTrack.play();
                    Log.i(TAG, "create AudioTrack success. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), streamTypeToString(i14));
                    return audioTrack;
                }
                throw new RuntimeException("AudioTrack is not initialized.");
            } catch (Throwable unused) {
                Log.w(TAG, "create AudioTrack failed. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), streamTypeToString(i14));
                destroyAudioTrack(audioTrack);
                return null;
            }
        } catch (Throwable unused2) {
            audioTrack = null;
            Log.w(TAG, "create AudioTrack failed. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), streamTypeToString(i14));
            destroyAudioTrack(audioTrack);
            return null;
        }
    }

    private static void destroyAudioTrack(AudioTrack audioTrack) {
        if (audioTrack != null) {
            try {
                if (audioTrack.getPlayState() == 3) {
                    audioTrack.stop();
                    audioTrack.flush();
                }
                audioTrack.release();
            } catch (Throwable th2) {
                Log.e(TAG, "stop AudioTrack failed.", th2);
            }
        }
    }

    private static String streamTypeToString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }

    public int getBufferSize() {
        return this.mBufferSize;
    }

    public int startPlayout(int i11, int i12, int i13, int i14) {
        int[] iArr = {i11, 0, 3, 1};
        int i15 = i13 == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(i12, i15, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioTrack.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
            return -2;
        }
        for (int i16 = 0; i16 < 4 && this.mAudioTrack == null; i16++) {
            int i17 = iArr[i16];
            for (int i18 = 1; i18 <= 2 && this.mAudioTrack == null; i18++) {
                int i19 = minBufferSize * i18;
                this.mBufferSize = i19;
                if (i19 >= i14 * 4 || i18 >= 2) {
                    this.mAudioTrack = createStartedAudioTrack(i12, i15, i19, i17);
                }
            }
        }
        if (this.mAudioTrack == null) {
            return -1;
        }
        this.mSystemOSVersion = LiteavSystemInfo.getSystemOSVersionInt();
        Process.setThreadPriority(-19);
        return 0;
    }

    public void stopPlayout() {
        destroyAudioTrack(this.mAudioTrack);
        this.mAudioTrack = null;
    }

    public int write(ByteBuffer byteBuffer, int i11, int i12, boolean z11) {
        int i13;
        if (this.mAudioTrack == null) {
            return -1;
        }
        byteBuffer.position(i11);
        if (this.mSystemOSVersion >= 21) {
            i13 = this.mAudioTrack.write(byteBuffer, i12, z11 ? 1 : 0);
        } else {
            byte[] bArr = this.mPlayBuffer;
            if (bArr == null || bArr.length < i12) {
                this.mPlayBuffer = new byte[i12];
            }
            byteBuffer.get(this.mPlayBuffer, 0, i12);
            i13 = this.mAudioTrack.write(this.mPlayBuffer, 0, i12);
        }
        if (i13 >= 0) {
            return i13;
        }
        Log.e(TAG, "write audio data to AudioTrack failed. ".concat(String.valueOf(i13)), new Object[0]);
        return -1;
    }
}
