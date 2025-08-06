package com.tencent.liteav.audio;

import android.text.TextUtils;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@JNINamespace("liteav::manager")
public class TXAudioEffectManagerImpl implements TXAudioEffectManager {
    private static final int EFFECT_PLAYER_ID_TYPE = 2;
    private static final String TAG = "TXAudioEffectManagerImpl";
    private List<Integer> mEffectIdList = new ArrayList();
    private final MusicPlayObserver mMusicPlayObserver;
    private final MusicPreloadObserver mMusicPreloadObserver;
    private long mNativeAudioEffectMgr = 0;

    public static class AudioBgmParams {
        private TXAudioEffectManager.AudioMusicParam mParams;

        public AudioBgmParams(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
            this.mParams = audioMusicParam;
        }

        public long getEndTimeMS() {
            return this.mParams.endTimeMS;
        }

        public int getLoopCount() {
            return this.mParams.loopCount;
        }

        public String getPath() {
            return this.mParams.path;
        }

        public long getStartTimeMS() {
            return this.mParams.startTimeMS;
        }

        public boolean isPublish() {
            return this.mParams.publish;
        }
    }

    public static class MusicPlayObserver {
        private final HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver> mObserverMap = new HashMap<>();

        public void addObserver(long j11, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
            if (tXMusicPlayObserver != null) {
                synchronized (this) {
                    this.mObserverMap.put(Long.valueOf(j11), tXMusicPlayObserver);
                }
            }
        }

        public void onComplete(long j11, int i11) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j11));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onComplete((int) j11, i11);
            }
        }

        public void onPlayProgress(long j11, long j12, long j13) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j11));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onPlayProgress((int) j11, j12, j13);
            }
        }

        public void onStart(long j11, int i11) {
            TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver;
            synchronized (this) {
                tXMusicPlayObserver = this.mObserverMap.get(Long.valueOf(j11));
            }
            if (tXMusicPlayObserver != null) {
                tXMusicPlayObserver.onStart((int) j11, i11);
            }
        }

        public void removeObserver(long j11) {
            synchronized (this) {
                this.mObserverMap.remove(Long.valueOf(j11));
            }
        }
    }

    public static class MusicPreloadObserver {
        private TXAudioEffectManager.TXMusicPreloadObserver mObserver;

        public void onLoadError(long j11, int i11) {
            TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver = this.mObserver;
            if (tXMusicPreloadObserver != null) {
                tXMusicPreloadObserver.onLoadError((int) j11, i11);
            }
        }

        public void onLoadProgress(long j11, int i11) {
            TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver = this.mObserver;
            if (tXMusicPreloadObserver != null) {
                tXMusicPreloadObserver.onLoadProgress((int) j11, i11);
            }
        }

        public void setObserver(TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver) {
            this.mObserver = tXMusicPreloadObserver;
        }
    }

    public TXAudioEffectManagerImpl(long j11) {
        MusicPlayObserver musicPlayObserver = new MusicPlayObserver();
        this.mMusicPlayObserver = musicPlayObserver;
        MusicPreloadObserver musicPreloadObserver = new MusicPreloadObserver();
        this.mMusicPreloadObserver = musicPreloadObserver;
        this.mNativeAudioEffectMgr = j11;
        if (j11 != 0) {
            nativeSetMusicObserver(j11, musicPlayObserver);
            nativeSetPreloadObserver(this.mNativeAudioEffectMgr, musicPreloadObserver);
        }
    }

    private static long convertToEffectId(int i11) {
        return ((long) i11) | 8589934592L;
    }

    private static native void nativeDestroy(long j11);

    private static native void nativeEnableVoiceEarMonitor(long j11, boolean z11);

    private static native long nativeGetMusicCurrentPosInMS(long j11, long j12);

    private static native long nativeGetMusicDurationInMS(long j11, String str);

    private static native int nativeGetMusicTrackCount(long j11, long j12);

    private static native void nativePausePlayMusic(long j11, long j12);

    private static native void nativePreloadMusic(long j11, long j12, AudioBgmParams audioBgmParams);

    private static native void nativeResumePlayMusic(long j11, long j12);

    private static native void nativeSeekMusicToPosInMS(long j11, long j12, long j13);

    private static native void nativeSetAllMusicVolume(long j11, int i11);

    private static native void nativeSetMusicObserver(long j11, MusicPlayObserver musicPlayObserver);

    private static native void nativeSetMusicPitch(long j11, long j12, float f11);

    private static native void nativeSetMusicPlayoutVolume(long j11, long j12, int i11);

    private static native void nativeSetMusicPublishVolume(long j11, long j12, int i11);

    private static native void nativeSetMusicScratchSpeedRate(long j11, long j12, float f11);

    private static native void nativeSetMusicSpeedRate(long j11, long j12, float f11);

    private static native void nativeSetMusicTrack(long j11, long j12, int i11);

    private static native void nativeSetPreloadObserver(long j11, MusicPreloadObserver musicPreloadObserver);

    private static native void nativeSetVoiceCaptureVolume(long j11, int i11);

    private static native void nativeSetVoiceChangerType(long j11, int i11);

    private static native void nativeSetVoiceEarMonitorVolume(long j11, int i11);

    private static native void nativeSetVoicePitch(long j11, double d11);

    private static native void nativeSetVoiceReverbType(long j11, int i11);

    private static native void nativeStartPlayMusic(long j11, long j12, AudioBgmParams audioBgmParams);

    private static native void nativeStopPlayMusic(long j11, long j12);

    public static TXAudioEffectManager.TXVoiceChangerType voiceChangerTypeFromInt(int i11) {
        if (i11 == 0) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
        }
        if (i11 == 1) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1;
        }
        if (i11 == 2) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2;
        }
        if (i11 == 3) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3;
        }
        if (i11 == 4) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4;
        }
        if (i11 == 5) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5;
        }
        if (i11 == 6) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6;
        }
        if (i11 == 7) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7;
        }
        if (i11 == 8) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8;
        }
        if (i11 == 9) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9;
        }
        if (i11 == 10) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10;
        }
        if (i11 == 11) {
            return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11;
        }
        return TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
    }

    public static TXAudioEffectManager.TXVoiceReverbType voiceReverbTypeFromInt(int i11) {
        if (i11 == 0) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
        }
        if (i11 == 1) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1;
        }
        if (i11 == 2) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2;
        }
        if (i11 == 3) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3;
        }
        if (i11 == 4) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4;
        }
        if (i11 == 5) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5;
        }
        if (i11 == 6) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6;
        }
        if (i11 == 7) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7;
        }
        if (i11 == 8) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_8;
        }
        if (i11 == 9) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_9;
        }
        if (i11 == 10) {
            return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_10;
        }
        return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
    }

    public void enableVoiceEarMonitor(boolean z11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeEnableVoiceEarMonitor(j11, z11);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeAudioEffectMgr = 0;
        }
    }

    public long getMusicCurrentPosInMS(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            return nativeGetMusicCurrentPosInMS(j11, (long) i11);
        }
        return 0;
    }

    public long getMusicDurationInMS(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "getMusicDurationInMS invalid params");
            return 0;
        }
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            return nativeGetMusicDurationInMS(j11, str);
        }
        return 0;
    }

    public int getMusicTrackCount(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            return nativeGetMusicTrackCount(j11, (long) i11);
        }
        return 0;
    }

    public void pauseAudioEffect(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativePausePlayMusic(j11, convertToEffectId(i11));
        }
    }

    public void pausePlayMusic(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativePausePlayMusic(j11, (long) i11);
        }
    }

    public void playAudioEffect(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam == null || TextUtils.isEmpty(audioMusicParam.path)) {
            LiteavLog.e(TAG, "startPlayMusic invalid params");
            return;
        }
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeStartPlayMusic(j11, convertToEffectId(audioMusicParam.f21317id), new AudioBgmParams(audioMusicParam));
            synchronized (this) {
                this.mEffectIdList.add(Integer.valueOf(audioMusicParam.f21317id));
            }
        }
    }

    public boolean preloadMusic(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam == null || TextUtils.isEmpty(audioMusicParam.path)) {
            LiteavLog.e(TAG, "preloadMusic invalid params");
            return false;
        }
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 == 0) {
            return true;
        }
        nativePreloadMusic(j11, (long) audioMusicParam.f21317id, new AudioBgmParams(audioMusicParam));
        return true;
    }

    public void resumeAudioEffect(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeResumePlayMusic(j11, convertToEffectId(i11));
        }
    }

    public void resumePlayMusic(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeResumePlayMusic(j11, (long) i11);
        }
    }

    public void seekMusicToPosInMS(int i11, int i12) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSeekMusicToPosInMS(j11, (long) i11, (long) i12);
        }
    }

    public void setAllAudioEffectsVolume(int i11) {
        if (this.mNativeAudioEffectMgr != 0) {
            synchronized (this) {
                for (Integer intValue : this.mEffectIdList) {
                    setAudioEffectVolume(intValue.intValue(), i11);
                }
            }
        }
    }

    public void setAllMusicVolume(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetAllMusicVolume(j11, i11);
        }
    }

    public void setAudioEffectVolume(int i11, int i12) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetMusicPlayoutVolume(j11, convertToEffectId(i11), i12);
            nativeSetMusicPublishVolume(this.mNativeAudioEffectMgr, convertToEffectId(i11), i12);
        }
    }

    public void setEffectObserver(int i11, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        if (this.mNativeAudioEffectMgr == 0) {
            return;
        }
        if (tXMusicPlayObserver != null) {
            this.mMusicPlayObserver.addObserver(convertToEffectId(i11), tXMusicPlayObserver);
        } else {
            this.mMusicPlayObserver.removeObserver(convertToEffectId(i11));
        }
    }

    public void setMusicObserver(int i11, TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        if (this.mNativeAudioEffectMgr == 0) {
            return;
        }
        if (tXMusicPlayObserver != null) {
            this.mMusicPlayObserver.addObserver((long) i11, tXMusicPlayObserver);
        } else {
            this.mMusicPlayObserver.removeObserver((long) i11);
        }
    }

    public void setMusicPitch(int i11, float f11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetMusicPitch(j11, (long) i11, f11);
        }
    }

    public void setMusicPlayoutVolume(int i11, int i12) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetMusicPlayoutVolume(j11, (long) i11, i12);
        }
    }

    public void setMusicPublishVolume(int i11, int i12) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetMusicPublishVolume(j11, (long) i11, i12);
        }
    }

    public void setMusicScratchSpeedRate(int i11, float f11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetMusicScratchSpeedRate(j11, (long) i11, f11);
        }
    }

    public void setMusicSpeedRate(int i11, float f11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetMusicSpeedRate(j11, (long) i11, f11);
        }
    }

    public void setMusicTrack(int i11, int i12) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetMusicTrack(j11, (long) i11, i12);
        }
    }

    public void setPreloadObserver(TXAudioEffectManager.TXMusicPreloadObserver tXMusicPreloadObserver) {
        if (this.mNativeAudioEffectMgr != 0) {
            this.mMusicPreloadObserver.setObserver(tXMusicPreloadObserver);
        }
    }

    public void setVoiceCaptureVolume(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetVoiceCaptureVolume(j11, i11);
        }
    }

    public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType tXVoiceChangerType) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetVoiceChangerType(j11, tXVoiceChangerType.getNativeValue());
        }
    }

    public void setVoiceEarMonitorVolume(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetVoiceEarMonitorVolume(j11, i11);
        }
    }

    public void setVoicePitch(double d11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetVoicePitch(j11, d11);
        }
    }

    public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType tXVoiceReverbType) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeSetVoiceReverbType(j11, tXVoiceReverbType.getNativeValue());
        }
    }

    public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        if (audioMusicParam == null || TextUtils.isEmpty(audioMusicParam.path)) {
            LiteavLog.e(TAG, "startPlayMusic invalid params");
            return false;
        }
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 == 0) {
            return true;
        }
        nativeStartPlayMusic(j11, (long) audioMusicParam.f21317id, new AudioBgmParams(audioMusicParam));
        return true;
    }

    public void stopAllAudioEffects() {
        if (this.mNativeAudioEffectMgr != 0) {
            synchronized (this) {
                for (Integer next : this.mEffectIdList) {
                    this.mMusicPlayObserver.removeObserver(convertToEffectId(next.intValue()));
                    nativeStopPlayMusic(this.mNativeAudioEffectMgr, convertToEffectId(next.intValue()));
                }
                this.mEffectIdList.clear();
            }
        }
    }

    public void stopAudioEffect(int i11) {
        if (this.mNativeAudioEffectMgr != 0) {
            this.mMusicPlayObserver.removeObserver(convertToEffectId(i11));
            nativeStopPlayMusic(this.mNativeAudioEffectMgr, convertToEffectId(i11));
            synchronized (this) {
                int indexOf = this.mEffectIdList.indexOf(Integer.valueOf(i11));
                if (indexOf >= 0) {
                    this.mEffectIdList.remove(indexOf);
                }
            }
        }
    }

    public void stopPlayMusic(int i11) {
        long j11 = this.mNativeAudioEffectMgr;
        if (j11 != 0) {
            nativeStopPlayMusic(j11, (long) i11);
        }
    }
}
