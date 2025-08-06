package com.tencent.qcloud.tuikit.tuicallkit.extensions;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.huochat.community.network.domain.DomainTool;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import java.io.File;

public class CallingBellFeature {
    public static final String PROFILE_CALL_BELL = "per_call_bell";
    public static final String PROFILE_MUTE_MODE = "per_mute_mode";
    public static final String PROFILE_TUICALLKIT = "per_profile_tuicallkit";
    /* access modifiers changed from: private */
    public int mCallingBellResourceId = -1;
    /* access modifiers changed from: private */
    public String mCallingBellResourcePath;
    private Context mContext;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public final MediaPlayer mMediaPlayer;

    public CallingBellFeature(Context context) {
        this.mContext = context.getApplicationContext();
        this.mMediaPlayer = new MediaPlayer();
    }

    private boolean isUrl(String str) {
        return str.startsWith(DomainTool.DOMAIN_PREFIX_HTTP) || str.startsWith(DomainTool.DOMAIN_PREFIX);
    }

    private void preHandler() {
        if (this.mHandler == null) {
            HandlerThread handlerThread = new HandlerThread("CallingBell");
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper());
        }
    }

    private void start(String str, int i11) {
        preHandler();
        if (TextUtils.isEmpty(str) && -1 == i11) {
            return;
        }
        if (-1 != i11 && this.mCallingBellResourceId == i11) {
            return;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.equals(this.mCallingBellResourcePath, str)) {
            return;
        }
        if (TextUtils.isEmpty(str) || !isUrl(str)) {
            final AssetFileDescriptor assetFileDescriptor = null;
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                this.mCallingBellResourcePath = str;
            } else if (-1 != i11) {
                this.mCallingBellResourceId = i11;
                assetFileDescriptor = this.mContext.getResources().openRawResourceFd(i11);
            }
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (CallingBellFeature.this.mMediaPlayer.isPlaying()) {
                        CallingBellFeature.this.mMediaPlayer.stop();
                    }
                    CallingBellFeature.this.mMediaPlayer.reset();
                    CallingBellFeature.this.mMediaPlayer.setAudioStreamType(3);
                    try {
                        if (assetFileDescriptor != null) {
                            CallingBellFeature.this.mMediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                        } else if (!TextUtils.isEmpty(CallingBellFeature.this.mCallingBellResourcePath)) {
                            CallingBellFeature.this.mMediaPlayer.setDataSource(CallingBellFeature.this.mCallingBellResourcePath);
                        } else {
                            return;
                        }
                        CallingBellFeature.this.mMediaPlayer.setLooping(true);
                        CallingBellFeature.this.mMediaPlayer.prepare();
                        CallingBellFeature.this.mMediaPlayer.start();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            });
        }
    }

    private void stop() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (CallingBellFeature.this.mMediaPlayer.isPlaying()) {
                        CallingBellFeature.this.mMediaPlayer.stop();
                    }
                    int unused = CallingBellFeature.this.mCallingBellResourceId = -1;
                    String unused2 = CallingBellFeature.this.mCallingBellResourcePath = "";
                }
            });
        }
    }

    public void startDialingMusic() {
        start("", R.raw.phone_dialing);
    }

    public void startRing() {
        if (!SPUtils.getInstance(PROFILE_TUICALLKIT).getBoolean(PROFILE_MUTE_MODE, false)) {
            String string = SPUtils.getInstance(PROFILE_TUICALLKIT).getString(PROFILE_CALL_BELL, "");
            if (TextUtils.isEmpty(string)) {
                start("", R.raw.phone_ringing);
            } else {
                start(string, -1);
            }
        }
    }

    public void stopMusic() {
        stop();
    }
}
