package com.tencent.qcloud.tuikit.tuicallkit.internal;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import com.tencent.qcloud.tuicore.interfaces.TUIServiceCallback;
import com.tencent.qcloud.tuicore.permission.PermissionCallback;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallEngine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;
import com.tencent.qcloud.tuikit.tuicallkit.utils.PermissionRequest;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudListener;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import zy.b;

public class TUIAudioMessageRecordService implements ITUIService, ITUINotification {
    private static final String TAG = "TUIAudioMessageRecordService";
    private AudioManager mAudioManager;
    /* access modifiers changed from: private */
    public AudioRecordInfo mAudioRecordInfo;
    private TUIServiceCallback mAudioRecordValueCallback;
    private TUICallObserver mCallObserver = new TUICallObserver() {
        public void onCallReceived(String str, List<String> list, String str2, TUICallDefine.MediaType mediaType, String str3) {
            super.onCallReceived(str, list, str2, mediaType, str3);
            TUIAudioMessageRecordService.this.stopRecordAudioMessage();
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;
    private AudioFocusRequest mFocusRequest;
    private AudioManager.OnAudioFocusChangeListener mOnFocusChangeListener;
    /* access modifiers changed from: private */
    public TRTCCloudListener mTRTCCloudListener = new TRTCCloudListener() {
        public void onError(int i11, String str, Bundle bundle) {
            super.onError(i11, str, bundle);
            if (i11 == -1302 || i11 == -1317 || i11 == -1318 || i11 == -1319) {
                TUIAudioMessageRecordService.this.notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, i11, (String) null);
            }
        }

        public void onLocalRecordBegin(int i11, String str) {
            super.onLocalRecordBegin(i11, str);
            int access$700 = TUIAudioMessageRecordService.this.convertErrorCode("onLocalRecordBegin", i11);
            if (i11 == 0) {
                TRTCCloud.sharedInstance(TUIAudioMessageRecordService.this.mContext).startLocalAudio(1);
            }
            TUIAudioMessageRecordService.this.notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, access$700, str);
        }

        public void onLocalRecordComplete(int i11, String str) {
            super.onLocalRecordComplete(i11, str);
            TUIAudioMessageRecordService.this.notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_STOP, TUIAudioMessageRecordService.this.convertErrorCode("onLocalRecordComplete", i11), str);
        }
    };

    public class AudioRecordInfo {
        public String path;
        public int sdkAppId;
        public String signature;

        public AudioRecordInfo() {
        }

        public String toString() {
            return "AudioRecordInfo{path=" + this.path + ", SDKAppID=" + this.sdkAppId + '}';
        }
    }

    public TUIAudioMessageRecordService(Context context) {
        this.mContext = context.getApplicationContext();
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, this);
    }

    private int abandonAudioFocus() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.abandonAudioFocusRequest(this.mFocusRequest);
        }
        return audioManager.abandonAudioFocus(this.mOnFocusChangeListener);
    }

    /* access modifiers changed from: private */
    public int convertErrorCode(String str, int i11) {
        if (i11 == -5) {
            return TUIConstants.TUICalling.ERROR_SIGNATURE_EXPIRED;
        }
        if (i11 == -4) {
            return TUIConstants.TUICalling.ERROR_SIGNATURE_ERROR;
        }
        if (i11 == -3) {
            return TUIConstants.TUICalling.ERROR_NO_MESSAGE_TO_RECORD;
        }
        if (i11 == -2) {
            return -2002;
        }
        if (i11 != -1) {
            return 0;
        }
        return "onLocalRecordBegin".equals(str) ? -2001 : -2003;
    }

    /* access modifiers changed from: private */
    public void initAudioFocusManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        }
        if (this.mOnFocusChangeListener == null) {
            this.mOnFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int i11) {
                    if (i11 == -3 || i11 == -2 || i11 == -1) {
                        TUIAudioMessageRecordService.this.stopRecordAudioMessage();
                    }
                }
            };
        }
        AudioAttributes audioAttributes = null;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            audioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        }
        if (i11 >= 26) {
            this.mFocusRequest = new AudioFocusRequest.Builder(2).setWillPauseWhenDucked(true).setAudioAttributes(audioAttributes).setOnAudioFocusChangeListener(this.mOnFocusChangeListener).build();
        }
    }

    /* access modifiers changed from: private */
    public void notifyAudioMessageRecordEvent(String str, int i11, String str2) {
        TUILog.i("TUIAudioMessageRecordService", "notifyAudioMessageRecordEvent, method: " + str + ", errCode: " + i11 + ",path: " + str2);
        if (this.mAudioRecordValueCallback != null) {
            Bundle bundle = new Bundle();
            bundle.putString(TUIConstants.TUICalling.EVENT_KEY_RECORD_AUDIO_MESSAGE, str);
            bundle.putString("path", str2);
            this.mAudioRecordValueCallback.onServiceCallback(i11, "", bundle);
        }
    }

    /* access modifiers changed from: private */
    public int requestAudioFocus() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.requestAudioFocus(this.mFocusRequest);
        }
        return audioManager.requestAudioFocus(this.mOnFocusChangeListener, 3, 2);
    }

    /* access modifiers changed from: private */
    public void startRecordAudioMessage() {
        if (this.mAudioRecordInfo == null) {
            TUILog.e("TUIAudioMessageRecordService", "startRecordAudioMessage failed, audioRecordInfo is empty");
            return;
        }
        TUILog.i("TUIAudioMessageRecordService", "startRecordAudioMessage, mAudioRecordInfo: " + this.mAudioRecordInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api", "startRecordAudioMessage");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TUIConstants.TUICalling.PARAM_NAME_SDK_APP_ID, this.mAudioRecordInfo.sdkAppId);
            jSONObject2.put("path", this.mAudioRecordInfo.path);
            jSONObject2.put("key", this.mAudioRecordInfo.signature);
            jSONObject.put("params", jSONObject2);
            TRTCCloud.sharedInstance(this.mContext).callExperimentalAPI(jSONObject.toString());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void stopRecordAudioMessage() {
        if (this.mAudioRecordInfo == null) {
            TUILog.w("TUIAudioMessageRecordService", "stopRecordAudioMessage, current recording status is Idle,do not need to stop");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api", "stopRecordAudioMessage");
            jSONObject.put("params", new JSONObject());
            TRTCCloud.sharedInstance(this.mContext).callExperimentalAPI(jSONObject.toString());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        TUILog.i("TUIAudioMessageRecordService", "stopRecordAudioMessage, stopLocalAudio");
        TRTCCloud.sharedInstance(this.mContext).stopLocalAudio();
        this.mAudioRecordInfo = null;
        abandonAudioFocus();
    }

    public /* synthetic */ Object onCall(String str, Map map) {
        return b.a(this, str, map);
    }

    public Object onCall(String str, final Map<String, Object> map, TUIServiceCallback tUIServiceCallback) {
        this.mAudioRecordValueCallback = tUIServiceCallback;
        if (!TextUtils.equals(TUIConstants.TUICalling.METHOD_NAME_START_RECORD_AUDIO_MESSAGE, str)) {
            if (TextUtils.equals(TUIConstants.TUICalling.METHOD_NAME_STOP_RECORD_AUDIO_MESSAGE, str)) {
                stopRecordAudioMessage();
            }
            return Boolean.TRUE;
        } else if (map == null) {
            TUILog.e("TUIAudioMessageRecordService", "startRecordAudioMessage failed, param is empty");
            notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, -1001, (String) null);
            return Boolean.FALSE;
        } else if (!TUICallDefine.Status.None.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallStatus())) {
            TUILog.e("TUIAudioMessageRecordService", "startRecordAudioMessage failed, The current call status does not support recording");
            notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, -1002, (String) null);
            return Boolean.FALSE;
        } else if (this.mAudioRecordInfo != null) {
            TUILog.e("TUIAudioMessageRecordService", "startRecordAudioMessage failed, The recording is not over, It cannot be called again");
            notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, -1003, (String) null);
            return Boolean.FALSE;
        } else {
            PermissionRequest.requestPermissions(this.mContext, TUICallDefine.MediaType.Audio, new PermissionCallback() {
                public void onDenied() {
                    super.onDenied();
                    TUIAudioMessageRecordService.this.notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, -1004, (String) null);
                }

                public void onGranted() {
                    TUIAudioMessageRecordService.this.initAudioFocusManager();
                    if (TUIAudioMessageRecordService.this.requestAudioFocus() != 1) {
                        TUILog.e("TUIAudioMessageRecordService", "startRecordAudioMessage failed, Failed to obtain audio focus");
                        TUIAudioMessageRecordService.this.notifyAudioMessageRecordEvent(TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, TUIConstants.TUICalling.ERROR_REQUEST_AUDIO_FOCUS_FAILED, (String) null);
                        return;
                    }
                    TUIAudioMessageRecordService tUIAudioMessageRecordService = TUIAudioMessageRecordService.this;
                    AudioRecordInfo unused = tUIAudioMessageRecordService.mAudioRecordInfo = new AudioRecordInfo();
                    if (map.containsKey("path")) {
                        TUIAudioMessageRecordService.this.mAudioRecordInfo.path = (String) map.get("path");
                    }
                    if (map.containsKey(TUIConstants.TUICalling.PARAM_NAME_SDK_APP_ID)) {
                        TUIAudioMessageRecordService.this.mAudioRecordInfo.sdkAppId = ((Integer) map.get(TUIConstants.TUICalling.PARAM_NAME_SDK_APP_ID)).intValue();
                    }
                    if (map.containsKey(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE)) {
                        TUIAudioMessageRecordService.this.mAudioRecordInfo.signature = (String) map.get(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE);
                    }
                    TRTCCloud.sharedInstance(TUIAudioMessageRecordService.this.mContext).setListener(TUIAudioMessageRecordService.this.mTRTCCloudListener);
                    TUIAudioMessageRecordService.this.startRecordAudioMessage();
                }
            });
            return Boolean.TRUE;
        }
    }

    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        if (TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED.equals(str) && TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS.equals(str2)) {
            TUICallEngine.createInstance(this.mContext).addObserver(this.mCallObserver);
        }
    }
}
