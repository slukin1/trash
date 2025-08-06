package com.tencent.qcloud.tuikit.tuichat.component;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class AudioPlayer {
    private static String CURRENT_RECORD_FILE = (TUIConfig.getRecordDir() + "auto_");
    private static int MAGIC_NUMBER = 500;
    private static int MIN_RECORD_DURATION = 1000;
    private static final String TAG = "AudioPlayer";
    private static AudioPlayer sInstance = new AudioPlayer();
    private String mAudioRecordPath;
    private Handler mHandler = new Handler();
    private Callback mPlayCallback;
    private MediaPlayer mPlayer;
    /* access modifiers changed from: private */
    public Callback mRecordCallback;
    private MediaRecorder mRecorder;

    public interface Callback {
        void onCompletion(Boolean bool);
    }

    private AudioPlayer() {
    }

    public static AudioPlayer getInstance() {
        return sInstance;
    }

    /* access modifiers changed from: private */
    public void onPlayCompleted(boolean z11) {
        Callback callback = this.mPlayCallback;
        if (callback != null) {
            callback.onCompletion(Boolean.valueOf(z11));
        }
        this.mPlayer = null;
    }

    /* access modifiers changed from: private */
    public void onRecordCompleted(boolean z11) {
        Callback callback = this.mRecordCallback;
        if (callback != null) {
            callback.onCompletion(Boolean.valueOf(z11));
        }
        this.mRecorder = null;
    }

    /* access modifiers changed from: private */
    public void stopInternalPlay() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mPlayer = null;
        }
    }

    /* access modifiers changed from: private */
    public void stopInternalRecord() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        MediaRecorder mediaRecorder = this.mRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.release();
            this.mRecorder = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getDuration() {
        /*
            r5 = this;
            java.lang.String r0 = r5.mAudioRecordPath
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            android.media.MediaPlayer r0 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x0027 }
            r0.<init>()     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = r5.mAudioRecordPath     // Catch:{ Exception -> 0x0027 }
            r0.setDataSource(r2)     // Catch:{ Exception -> 0x0027 }
            r0.prepare()     // Catch:{ Exception -> 0x0027 }
            int r0 = r0.getDuration()     // Catch:{ Exception -> 0x0027 }
            int r2 = MIN_RECORD_DURATION     // Catch:{ Exception -> 0x0025 }
            if (r0 >= r2) goto L_0x0021
            r0 = r1
            goto L_0x0030
        L_0x0021:
            int r2 = MAGIC_NUMBER     // Catch:{ Exception -> 0x0025 }
            int r0 = r0 + r2
            goto L_0x0030
        L_0x0025:
            r2 = move-exception
            goto L_0x0029
        L_0x0027:
            r2 = move-exception
            r0 = r1
        L_0x0029:
            java.lang.String r3 = TAG
            java.lang.String r4 = "getDuration failed"
            com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.w(r3, r4, r2)
        L_0x0030:
            if (r0 >= 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r1 = r0
        L_0x0034:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.getDuration():int");
    }

    public String getPath() {
        return this.mAudioRecordPath;
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void startPlay(String str, Callback callback) {
        this.mAudioRecordPath = str;
        this.mPlayCallback = callback;
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mPlayer = mediaPlayer;
            mediaPlayer.setDataSource(str);
            this.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    AudioPlayer.this.stopInternalPlay();
                    AudioPlayer.this.onPlayCompleted(true);
                }
            });
            this.mPlayer.prepare();
            this.mPlayer.start();
        } catch (Exception e11) {
            TUIChatLog.w(TAG, "startPlay failed", e11);
            ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.play_error_tip));
            stopInternalPlay();
            onPlayCompleted(false);
        }
    }

    public void startRecord(Callback callback) {
        this.mRecordCallback = callback;
        try {
            this.mAudioRecordPath = CURRENT_RECORD_FILE + System.currentTimeMillis() + ".m4a";
            MediaRecorder mediaRecorder = new MediaRecorder();
            this.mRecorder = mediaRecorder;
            mediaRecorder.setAudioSource(1);
            this.mRecorder.setOutputFormat(2);
            this.mRecorder.setOutputFile(this.mAudioRecordPath);
            this.mRecorder.setAudioEncoder(3);
            this.mRecorder.prepare();
            this.mRecorder.start();
            this.mHandler.removeCallbacksAndMessages((Object) null);
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    AudioPlayer.this.stopInternalRecord();
                    AudioPlayer.this.onRecordCompleted(true);
                    Callback unused = AudioPlayer.this.mRecordCallback = null;
                    ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_limit_tips));
                }
            }, (long) (TUIChatService.getChatConfig().getGeneralConfig().getAudioRecordMaxTime() * 1000));
        } catch (Exception e11) {
            TUIChatLog.w(TAG, "startRecord failed", e11);
            stopInternalRecord();
            onRecordCompleted(false);
        }
    }

    public void stopPlay() {
        stopInternalPlay();
        onPlayCompleted(false);
        this.mPlayCallback = null;
    }

    public void stopRecord() {
        stopInternalRecord();
        onRecordCompleted(true);
        this.mRecordCallback = null;
    }
}
