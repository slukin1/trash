package com.tencent.qcloud.tuikit.tuicallkit.base;

import android.content.Context;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallkit.TUICallKitImpl;
import java.util.HashMap;

public class TUICallingStatusManager {
    private static TUICallingStatusManager sInstance;
    private TUICommonDefine.AudioPlaybackDevice mAudioDevice = TUICommonDefine.AudioPlaybackDevice.Speakerphone;
    private TUICallDefine.Role mCallRole = TUICallDefine.Role.None;
    private TUICallDefine.Scene mCallScene;
    private TUICallDefine.Status mCallStatus = TUICallDefine.Status.None;
    private final Context mContext;
    private String mGroupId;
    private boolean mIsCameraOpen;
    private TUICommonDefine.Camera mIsFrontCamera = TUICommonDefine.Camera.Front;
    private boolean mIsMicMute;
    private TUICallDefine.MediaType mMediaType = TUICallDefine.MediaType.Unknown;

    private TUICallingStatusManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static TUICallingStatusManager sharedInstance(Context context) {
        if (sInstance == null) {
            synchronized (TUICallKitImpl.class) {
                if (sInstance == null) {
                    sInstance = new TUICallingStatusManager(context);
                }
            }
        }
        return sInstance;
    }

    public void clear() {
        this.mIsCameraOpen = false;
        this.mIsFrontCamera = TUICommonDefine.Camera.Front;
        this.mIsMicMute = false;
        this.mAudioDevice = TUICommonDefine.AudioPlaybackDevice.Speakerphone;
        this.mCallStatus = TUICallDefine.Status.None;
        this.mCallRole = TUICallDefine.Role.None;
        this.mMediaType = TUICallDefine.MediaType.Unknown;
        this.mCallScene = null;
        this.mGroupId = "";
    }

    public TUICommonDefine.AudioPlaybackDevice getAudioPlaybackDevice() {
        return this.mAudioDevice;
    }

    public TUICallDefine.Role getCallRole() {
        return this.mCallRole;
    }

    public TUICallDefine.Scene getCallScene() {
        return this.mCallScene;
    }

    public TUICallDefine.Status getCallStatus() {
        return this.mCallStatus;
    }

    public TUICommonDefine.Camera getFrontCamera() {
        return this.mIsFrontCamera;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public TUICallDefine.MediaType getMediaType() {
        return this.mMediaType;
    }

    public boolean isCameraOpen() {
        return this.mIsCameraOpen;
    }

    public boolean isMicMute() {
        return this.mIsMicMute;
    }

    public void setCallRole(TUICallDefine.Role role) {
        this.mCallRole = role;
    }

    public void setCallScene(TUICallDefine.Scene scene) {
        this.mCallScene = scene;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setMediaType(TUICallDefine.MediaType mediaType) {
        this.mMediaType = mediaType;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.CALL_MEDIA_TYPE, this.mMediaType);
        TUICore.notifyEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CALL_TYPE_CHANGED, hashMap);
    }

    public void updateAudioPlaybackDevice(TUICommonDefine.AudioPlaybackDevice audioPlaybackDevice) {
        this.mAudioDevice = audioPlaybackDevice;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.HANDS_FREE, audioPlaybackDevice);
        TUICore.notifyEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_AUDIOPLAYDEVICE_CHANGED, hashMap);
    }

    public void updateCallStatus(TUICallDefine.Status status) {
        if (!this.mCallStatus.equals(status)) {
            this.mCallStatus = status;
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.CALL_STATUS, status);
            TUICore.notifyEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CALL_STATUS_CHANGED, hashMap);
        }
    }

    public void updateCameraOpenStatus(boolean z11, TUICommonDefine.Camera camera) {
        this.mIsCameraOpen = z11;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.OPEN_CAMERA, Boolean.valueOf(z11));
        if (z11) {
            hashMap.put(Constants.SWITCH_CAMERA, camera);
        }
        TUICore.notifyEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CAMERA_OPEN, hashMap);
    }

    public void updateFrontCameraStatus(TUICommonDefine.Camera camera) {
        this.mIsFrontCamera = camera;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.SWITCH_CAMERA, camera);
        TUICore.notifyEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CAMERA_FRONT, hashMap);
    }

    public void updateMicMuteStatus(boolean z11) {
        this.mIsMicMute = z11;
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.MUTE_MIC, Boolean.valueOf(z11));
        TUICore.notifyEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_MIC_STATUS_CHANGED, hashMap);
    }
}
