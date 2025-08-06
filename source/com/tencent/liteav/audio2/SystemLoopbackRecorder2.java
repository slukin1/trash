package com.tencent.liteav.audio2;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Process;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
public class SystemLoopbackRecorder2 {
    private static final String TAG = "SystemLoopbackRecorder2";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f21320a = 0;
    private static final Object mLock = new Object();
    private static MediaProjection mMediaProjection;
    private static volatile long mNativeSystemLoopbackRecorder;

    public SystemLoopbackRecorder2(long j11) {
        mNativeSystemLoopbackRecorder = j11;
    }

    private static native void nativeSetMediaProjectionSession(long j11, MediaProjection mediaProjection);

    public static void notifyMediaProjectionState(MediaProjection mediaProjection) {
        StringBuilder sb2 = new StringBuilder("Received MediaProjection state ");
        sb2.append(mediaProjection != null);
        Log.i(TAG, sb2.toString(), new Object[0]);
        synchronized (mLock) {
            mMediaProjection = mediaProjection;
            setMediaProjectionSession();
        }
    }

    public static void setMediaProjectionSession() {
        if (mMediaProjection == null) {
            Log.i(TAG, "MediaProjection is null.", new Object[0]);
        } else if (mNativeSystemLoopbackRecorder != 0) {
            nativeSetMediaProjectionSession(mNativeSystemLoopbackRecorder, mMediaProjection);
        }
    }

    public MediaProjection getMediaProjection() {
        return mMediaProjection;
    }

    public void releaseNativeSystemLoopbackRecorder() {
        mNativeSystemLoopbackRecorder = 0;
    }

    public static class Recorder {

        /* renamed from: a  reason: collision with root package name */
        private AudioRecord f21321a;

        /* renamed from: b  reason: collision with root package name */
        private AudioManager f21322b;

        public Recorder() {
            Context applicationContext = ContextUtils.getApplicationContext();
            ContextUtils.getApplicationContext();
            this.f21322b = (AudioManager) applicationContext.getSystemService("audio");
        }

        private static AudioRecord a(MediaProjection mediaProjection, int i11, int i12, int i13) {
            AudioPlaybackCaptureConfiguration.Builder builder = new AudioPlaybackCaptureConfiguration.Builder(mediaProjection);
            builder.addMatchingUsage(1);
            builder.addMatchingUsage(14);
            AudioPlaybackCaptureConfiguration build = builder.build();
            if (build == null) {
                return null;
            }
            int i14 = i12 == 1 ? 16 : 12;
            AudioFormat build2 = new AudioFormat.Builder().setEncoding(2).setSampleRate(i11).setChannelMask(i14).build();
            int minBufferSize = AudioRecord.getMinBufferSize(i11, i14, 2);
            AudioRecord audioRecord = null;
            for (int i15 = 1; i15 <= 2 && audioRecord == null; i15++) {
                int i16 = minBufferSize * i15;
                if (i16 >= i13 * 4 || i15 >= 2) {
                    try {
                        audioRecord = new AudioRecord.Builder().setAudioFormat(build2).setBufferSizeInBytes(i16).setAudioPlaybackCaptureConfig(build).build();
                        if (audioRecord.getState() != 1) {
                            Log.e(SystemLoopbackRecorder2.TAG, "Audio record state error", new Object[0]);
                            a(audioRecord);
                            audioRecord = null;
                        } else {
                            audioRecord.startRecording();
                            Log.i(SystemLoopbackRecorder2.TAG, "Create audio record success", new Object[0]);
                        }
                    } catch (Throwable th2) {
                        Log.w(SystemLoopbackRecorder2.TAG, "Create record error " + th2.getMessage(), new Object[0]);
                        a(audioRecord);
                    }
                }
            }
            return audioRecord;
        }

        public int read(ByteBuffer byteBuffer, int i11) {
            if (this.f21321a == null) {
                return -1;
            }
            byteBuffer.position(0);
            int read = this.f21321a.read(byteBuffer, i11);
            if (read > 0) {
                return read;
            }
            Log.e(SystemLoopbackRecorder2.TAG, "Read failed ".concat(String.valueOf(read)), new Object[0]);
            return -1;
        }

        public int startRecording(MediaProjection mediaProjection, int i11, int i12, int i13) {
            try {
                AudioManager audioManager = this.f21322b;
                if (audioManager != null) {
                    audioManager.setAllowedCapturePolicy(3);
                }
            } catch (Throwable th2) {
                Log.e(SystemLoopbackRecorder2.TAG, "ForbidCaptureAudioFromCurrentApp error " + th2.getMessage(), new Object[0]);
            }
            AudioManager audioManager2 = this.f21322b;
            int mode = audioManager2 != null ? audioManager2.getMode() : 0;
            a(0);
            this.f21321a = a(mediaProjection, i11, i12, i13);
            a(mode);
            if (this.f21321a == null) {
                return -1;
            }
            Process.setThreadPriority(-19);
            return 0;
        }

        public void stopRecording() {
            a(this.f21321a);
            this.f21321a = null;
        }

        private static void a(AudioRecord audioRecord) {
            if (audioRecord != null) {
                try {
                    if (audioRecord.getRecordingState() == 3) {
                        audioRecord.stop();
                    }
                    audioRecord.release();
                } catch (Throwable th2) {
                    Log.e(SystemLoopbackRecorder2.TAG, "Destroy AudioRecord failed." + th2.getMessage(), new Object[0]);
                }
            }
        }

        private void a(int i11) {
            try {
                AudioManager audioManager = this.f21322b;
                if (audioManager != null) {
                    audioManager.setMode(i11);
                }
            } catch (Throwable th2) {
                Log.e(SystemLoopbackRecorder2.TAG, "Set audio mode exception " + th2.getMessage(), new Object[0]);
            }
        }
    }
}
