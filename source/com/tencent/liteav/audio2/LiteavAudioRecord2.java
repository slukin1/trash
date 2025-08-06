package com.tencent.liteav.audio2;

import android.media.AudioRecord;
import android.os.Process;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
class LiteavAudioRecord2 {
    private static final String TAG = "LiteavAudioRecord";
    private AudioRecord mAudioRecord;
    private int mBufferSize = 0;

    private static String audioSourceToString(int i11) {
        switch (i11) {
            case 0:
                return MessengerShareContentUtility.PREVIEW_DEFAULT;
            case 1:
                return "MIC";
            case 2:
                return "VOICE_UPLINK";
            case 3:
                return "VOICE_DOWNLINK";
            case 4:
                return "VOICE_CALL";
            case 5:
                return "CAMCORDER";
            case 6:
                return "VOICE_RECOGNITION";
            case 7:
                return "VOICE_COMMUNICATION";
            case 9:
                return "UNPROCESSED";
            case 10:
                return "VOICE_PERFORMANCE";
            default:
                return "INVALID";
        }
    }

    private static AudioRecord createStartedAudioRecord(int i11, int i12, int i13, int i14) {
        AudioRecord audioRecord;
        try {
            audioRecord = new AudioRecord(i11, i12, i13, 2, i14);
            try {
                if (audioRecord.getState() == 1) {
                    audioRecord.startRecording();
                    Log.i(TAG, "create AudioRecord success. sampleRate: %d, channelConfig: %d, bufferSize: %d, audio source: %s", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), audioSourceToString(i11));
                    return audioRecord;
                }
                throw new RuntimeException("AudioRecord is not initialized.");
            } catch (Throwable unused) {
                Log.w(TAG, "create AudioRecord failed. source: %s, sampleRate: %d, channelConfig: %d, bufferSize: %d", audioSourceToString(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
                destroyAudioRecord(audioRecord);
                return null;
            }
        } catch (Throwable unused2) {
            audioRecord = null;
            Log.w(TAG, "create AudioRecord failed. source: %s, sampleRate: %d, channelConfig: %d, bufferSize: %d", audioSourceToString(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
            destroyAudioRecord(audioRecord);
            return null;
        }
    }

    private static void destroyAudioRecord(AudioRecord audioRecord) {
        if (audioRecord != null) {
            try {
                if (audioRecord.getRecordingState() == 3) {
                    audioRecord.stop();
                }
                audioRecord.release();
            } catch (Throwable th2) {
                Log.e(TAG, "stop AudioRecord failed.", th2);
            }
        }
    }

    public int getSessionId() {
        AudioRecord audioRecord = this.mAudioRecord;
        if (audioRecord == null) {
            return -1;
        }
        return audioRecord.getAudioSessionId();
    }

    public int read(ByteBuffer byteBuffer, int i11) {
        if (this.mAudioRecord == null) {
            return -1;
        }
        byteBuffer.position(0);
        int read = this.mAudioRecord.read(byteBuffer, i11);
        if (read >= 0) {
            return read;
        }
        Log.e(TAG, "read failed, %d", Integer.valueOf(read));
        return -1;
    }

    public int startRecording(int i11, int i12, int i13, int i14) {
        int[] iArr = {i11, 1, 5, 0};
        int i15 = i13 == 1 ? 16 : 12;
        int minBufferSize = AudioRecord.getMinBufferSize(i12, i15, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioRecord.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
            return -2;
        }
        for (int i16 = 0; i16 < 4 && this.mAudioRecord == null; i16++) {
            int i17 = iArr[i16];
            for (int i18 = 1; i18 <= 2 && this.mAudioRecord == null; i18++) {
                int i19 = minBufferSize * i18;
                this.mBufferSize = i19;
                if (i19 >= i14 * 4 || i18 >= 2) {
                    this.mAudioRecord = createStartedAudioRecord(i17, i12, i15, i19);
                }
            }
        }
        if (this.mAudioRecord == null) {
            return -1;
        }
        Process.setThreadPriority(-19);
        return 0;
    }

    public void stopRecording() {
        destroyAudioRecord(this.mAudioRecord);
        this.mAudioRecord = null;
    }
}
