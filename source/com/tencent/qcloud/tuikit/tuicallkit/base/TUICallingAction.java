package com.tencent.qcloud.tuikit.tuicallkit.base;

import android.content.Context;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.TUIVideoView;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallEngine;
import com.tencent.qcloud.tuikit.tuicallkit.config.OfflinePushInfoConfig;
import java.util.List;

public class TUICallingAction {
    /* access modifiers changed from: private */
    public final Context mContext;

    public TUICallingAction(Context context) {
        this.mContext = context;
    }

    public void accept(final TUICommonDefine.Callback callback) {
        TUICallEngine.createInstance(this.mContext).accept(new TUICommonDefine.Callback() {
            public void onError(int i11, String str) {
                TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateCallStatus(TUICallDefine.Status.None);
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onError(i11, str);
                }
            }

            public void onSuccess() {
                TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateCallStatus(TUICallDefine.Status.Accept);
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess();
                }
            }
        });
    }

    public void closeCamera() {
        TUICallEngine.createInstance(this.mContext).closeCamera();
        TUICallingStatusManager.sharedInstance(this.mContext).updateCameraOpenStatus(false, TUICallingStatusManager.sharedInstance(this.mContext).getFrontCamera());
    }

    public void closeMicrophone() {
        TUICallEngine.createInstance(this.mContext).closeMicrophone();
        TUICallingStatusManager.sharedInstance(this.mContext).updateMicMuteStatus(true);
    }

    public void hangup(final TUICommonDefine.Callback callback) {
        TUICallEngine.createInstance(this.mContext).hangup(new TUICommonDefine.Callback() {
            public void onError(int i11, String str) {
                TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateCallStatus(TUICallDefine.Status.None);
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onError(i11, str);
                }
            }

            public void onSuccess() {
                TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateCallStatus(TUICallDefine.Status.None);
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess();
                }
            }
        });
    }

    public void inviteUser(List<String> list, TUICommonDefine.ValueCallback valueCallback) {
        TUICallDefine.CallParams callParams = new TUICallDefine.CallParams();
        callParams.offlinePushInfo = OfflinePushInfoConfig.createOfflinePushInfo(this.mContext);
        callParams.timeout = Constants.SIGNALING_MAX_TIME;
        TUICallEngine.createInstance(this.mContext).inviteUser(list, callParams, valueCallback);
    }

    public void openCamera(TUICommonDefine.Camera camera, TUIVideoView tUIVideoView, final TUICommonDefine.Callback callback) {
        TUICallEngine.createInstance(this.mContext).openCamera(camera, tUIVideoView, new TUICommonDefine.Callback() {
            public void onError(int i11, String str) {
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onError(i11, str);
                }
            }

            public void onSuccess() {
                if (!TUICallDefine.Status.None.equals(TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).getCallStatus())) {
                    TUICommonDefine.Camera frontCamera = TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).getFrontCamera();
                    TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateCameraOpenStatus(true, frontCamera);
                    TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateFrontCameraStatus(frontCamera);
                }
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess();
                }
            }
        });
    }

    public void openMicrophone(TUICommonDefine.Callback callback) {
        TUICallEngine.createInstance(this.mContext).openMicrophone(callback);
        TUICallingStatusManager.sharedInstance(this.mContext).updateMicMuteStatus(false);
    }

    public void reject(final TUICommonDefine.Callback callback) {
        TUICallEngine.createInstance(this.mContext).reject(new TUICommonDefine.Callback() {
            public void onError(int i11, String str) {
                TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateCallStatus(TUICallDefine.Status.None);
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onError(i11, str);
                }
            }

            public void onSuccess() {
                TUICallingStatusManager.sharedInstance(TUICallingAction.this.mContext).updateCallStatus(TUICallDefine.Status.None);
                TUICommonDefine.Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess();
                }
            }
        });
    }

    public void selectAudioPlaybackDevice(TUICommonDefine.AudioPlaybackDevice audioPlaybackDevice) {
        TUICallEngine.createInstance(this.mContext).selectAudioPlaybackDevice(audioPlaybackDevice);
        TUICallingStatusManager.sharedInstance(this.mContext).updateAudioPlaybackDevice(audioPlaybackDevice);
    }

    public void startRemoteView(String str, TUIVideoView tUIVideoView, TUICommonDefine.PlayCallback playCallback) {
        TUICallEngine.createInstance(this.mContext).startRemoteView(str, tUIVideoView, playCallback);
    }

    public void stopRemoteView(String str) {
        TUICallEngine.createInstance(this.mContext).stopRemoteView(str);
    }

    public void switchCallMediaType(TUICallDefine.MediaType mediaType) {
        TUICallEngine.createInstance(this.mContext).switchCallMediaType(mediaType);
    }

    public void switchCamera(TUICommonDefine.Camera camera) {
        TUICallEngine.createInstance(this.mContext).switchCamera(camera);
        TUICallingStatusManager.sharedInstance(this.mContext).updateFrontCameraStatus(camera);
    }
}
