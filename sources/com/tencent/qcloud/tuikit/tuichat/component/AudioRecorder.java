package com.tencent.qcloud.tuikit.tuichat.component;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.interfaces.TUIServiceCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.model.AIDenoiseSignatureManager;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.HashMap;
import java.util.Map;

public class AudioRecorder {
    private static String CURRENT_RECORD_FILE = (TUIConfig.getRecordDir() + "auto_");
    private static int MAGIC_NUMBER = 500;
    private static int MIN_RECORD_DURATION = 1000;
    /* access modifiers changed from: private */
    public static final String TAG = "AudioRecorder";
    private static AudioRecorder sInstance = new AudioRecorder();
    private String mAudioRecordPath;
    private TUIServiceCallback mCallkitAudioRecordValueCallback;
    private Handler mHandler = new Handler();
    private boolean mIsCallkitRecorder;
    private Callback mRecordCallback;
    private MediaRecorder mRecorder;
    private Runnable mUpdateMicStatusTimer = new Runnable() {
        public void run() {
            AudioRecorder.this.updateMicStatus();
        }
    };

    public interface Callback {
        void onCompletion(Boolean bool);

        void onVoiceDb(double d11);
    }

    private AudioRecorder() {
        initCallkitAudioRecordListener();
    }

    public static AudioRecorder getInstance() {
        return sInstance;
    }

    private void initCallkitAudioRecordListener() {
        this.mCallkitAudioRecordValueCallback = new TUIServiceCallback() {
            public void onServiceCallback(int i11, String str, Bundle bundle) {
                String string = bundle.getString(TUIConstants.TUICalling.EVENT_KEY_RECORD_AUDIO_MESSAGE);
                String string2 = bundle.getString("path");
                if (TextUtils.equals(string, TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START)) {
                    AudioRecorder.this.processCallkitRecordStart(i11, string2);
                } else if (TextUtils.equals(string, TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_STOP)) {
                    AudioRecorder.this.processCallkitRecordStop(i11, string2);
                } else {
                    String access$200 = AudioRecorder.TAG;
                    TUIChatLog.e(access$200, "unknown callkit recorder method:" + string + ", errorCode:" + i11);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void onRecordCompleted(boolean z11) {
        Callback callback = this.mRecordCallback;
        if (callback != null) {
            callback.onCompletion(Boolean.valueOf(z11));
            this.mRecordCallback = null;
        }
        if (!this.mIsCallkitRecorder && this.mRecorder != null) {
            this.mRecorder = null;
        }
    }

    /* access modifiers changed from: private */
    public void processCallkitRecordStart(int i11, String str) {
        String str2 = TAG;
        TUIChatLog.i(str2, "callkit recorder begin, errorCode:" + i11);
        if (!(i11 == -2001 || i11 == -1302)) {
            if (i11 != 0) {
                switch (i11) {
                    case -1319:
                    case -1318:
                    case -1317:
                        break;
                    default:
                        switch (i11) {
                            case TUIConstants.TUICalling.ERROR_REQUEST_AUDIO_FOCUS_FAILED:
                                break;
                            case -1004:
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AudioRecorder.this.stopCallkitRecord();
                                        AudioRecorder.this.onRecordCompleted(false);
                                        ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.audio_permission_error));
                                    }
                                });
                                return;
                            case -1003:
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AudioRecorder.this.onRecordCompleted(false);
                                        ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_rejected_for_in_recording));
                                    }
                                });
                                return;
                            case -1002:
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AudioRecorder.this.onRecordCompleted(false);
                                        ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_rejected_for_in_call));
                                    }
                                });
                                return;
                            default:
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AudioRecorder.this.stopCallkitRecord();
                                        AudioRecorder.this.startSystemRecorder();
                                    }
                                });
                                return;
                        }
                }
            } else {
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        AudioRecorder.this.stopCallkitRecord();
                        AudioRecorder.this.onRecordCompleted(true);
                        ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_limit_tips));
                    }
                }, (long) (TUIChatConfigs.getConfigs().getGeneralConfig().getAudioRecordMaxTime() * 1000));
                return;
            }
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                AudioRecorder.this.stopCallkitRecord();
                AudioRecorder.this.onRecordCompleted(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void processCallkitRecordStop(int i11, String str) {
        String str2 = TAG;
        TUIChatLog.i(str2, "callkit recorder complete, errorCode:" + i11);
        if (i11 == -2004 || i11 == -2003) {
            onRecordCompleted(false);
        } else if (i11 == 0) {
            onRecordCompleted(true);
        }
    }

    private boolean startCallkitRecorder() {
        if (TUICore.getService("TUIAudioMessageRecordService") == null) {
            TUIChatLog.i(TAG, "audio record service does not exists");
            return false;
        }
        String signature = AIDenoiseSignatureManager.getInstance().getSignature();
        if (TextUtils.isEmpty(signature)) {
            TUIChatLog.e(TAG, "denoise signature is empty");
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, signature);
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_SDK_APP_ID, Integer.valueOf(TUILogin.getSdkAppId()));
        hashMap.put("path", this.mAudioRecordPath);
        TUICore.callService("TUIAudioMessageRecordService", TUIConstants.TUICalling.METHOD_NAME_START_RECORD_AUDIO_MESSAGE, hashMap, this.mCallkitAudioRecordValueCallback);
        this.mIsCallkitRecorder = true;
        TUIChatLog.i(TAG, "use callkit recorder");
        return true;
    }

    /* access modifiers changed from: private */
    public void startSystemRecorder() {
        TUIChatLog.i(TAG, "use system media recorder");
        this.mIsCallkitRecorder = false;
        try {
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
                    AudioRecorder.this.stopInternalRecord();
                    AudioRecorder.this.onRecordCompleted(true);
                    ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_limit_tips));
                }
            }, (long) (TUIChatConfigs.getConfigs().getGeneralConfig().getAudioRecordMaxTime() * 1000));
            updateMicStatus();
        } catch (Exception e11) {
            TUIChatLog.w(TAG, "startRecord failed", e11);
            stopInternalRecord();
            onRecordCompleted(false);
        }
    }

    /* access modifiers changed from: private */
    public void stopCallkitRecord() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        TUICore.callService("TUIAudioMessageRecordService", TUIConstants.TUICalling.METHOD_NAME_STOP_RECORD_AUDIO_MESSAGE, (Map<String, Object>) null, this.mCallkitAudioRecordValueCallback);
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

    private void stopMediaRecord() {
        stopInternalRecord();
        onRecordCompleted(true);
    }

    /* access modifiers changed from: private */
    public void updateMicStatus() {
        MediaRecorder mediaRecorder = this.mRecorder;
        if (mediaRecorder != null) {
            double maxAmplitude = ((double) mediaRecorder.getMaxAmplitude()) / 1.0d;
            double d11 = 0.0d;
            if (maxAmplitude > 1.0d) {
                d11 = Math.log10(maxAmplitude) * 20.0d;
            }
            String str = TAG;
            TUIChatLog.d(str, "计算分贝值 = " + d11 + "dB");
            Callback callback = this.mRecordCallback;
            if (callback != null) {
                callback.onVoiceDb(d11);
            }
            this.mHandler.postDelayed(this.mUpdateMicStatusTimer, 100);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.getDuration():int");
    }

    public String getPath() {
        return this.mAudioRecordPath;
    }

    public void startRecord(Callback callback) {
        this.mRecordCallback = callback;
        this.mAudioRecordPath = CURRENT_RECORD_FILE + System.currentTimeMillis() + ".m4a";
        if (!startCallkitRecorder()) {
            startSystemRecorder();
        }
    }

    public void stopRecord() {
        if (this.mIsCallkitRecorder) {
            stopCallkitRecord();
        } else {
            stopMediaRecord();
        }
    }
}
