package com.tencent.qcloud.tuikit.tuicallkit.view.function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingAction;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;

public class TUICallingVideoFunctionView extends BaseFunctionView {
    private ImageView mImageHandsFree;
    private ImageView mImageMute;
    private ImageView mImageOpenCamera;
    private ImageView mImageSwitchCamera;
    private LinearLayout mLayoutHandsFree;
    private LinearLayout mLayoutHangup;
    private LinearLayout mLayoutMute;
    private LinearLayout mLayoutOpenCamera;

    public TUICallingVideoFunctionView(Context context) {
        super(context);
        initView();
        initClickListener();
    }

    private void initClickListener() {
        this.mLayoutMute.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                boolean isMicMute = TUICallingStatusManager.sharedInstance(TUICallingVideoFunctionView.this.mContext).isMicMute();
                if (isMicMute) {
                    TUICallingVideoFunctionView.this.mCallingAction.openMicrophone(new TUICommonDefine.Callback() {
                        public void onError(int i11, String str) {
                        }

                        public void onSuccess() {
                        }
                    });
                } else {
                    TUICallingVideoFunctionView.this.mCallingAction.closeMicrophone();
                }
                ToastUtil.toastShortMessage(TUICallingVideoFunctionView.this.mContext.getString(isMicMute ? R.string.tuicalling_toast_disable_mute : R.string.tuicalling_toast_enable_mute));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutHandsFree.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICommonDefine.AudioPlaybackDevice audioPlaybackDevice = TUICommonDefine.AudioPlaybackDevice.Speakerphone;
                boolean equals = audioPlaybackDevice.equals(TUICallingStatusManager.sharedInstance(TUICallingVideoFunctionView.this.mContext).getAudioPlaybackDevice());
                if (equals) {
                    TUICallingVideoFunctionView.this.mCallingAction.selectAudioPlaybackDevice(TUICommonDefine.AudioPlaybackDevice.Earpiece);
                } else {
                    TUICallingVideoFunctionView.this.mCallingAction.selectAudioPlaybackDevice(audioPlaybackDevice);
                }
                ToastUtil.toastShortMessage(TUICallingVideoFunctionView.this.mContext.getString(equals ? R.string.tuicalling_toast_use_handset : R.string.tuicalling_toast_speaker));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutOpenCamera.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (TUICallingStatusManager.sharedInstance(TUICallingVideoFunctionView.this.mContext).isCameraOpen()) {
                    TUICallingVideoFunctionView.this.mCallingAction.closeCamera();
                    ToastUtil.toastShortMessage(TUICallingVideoFunctionView.this.mContext.getString(R.string.tuicalling_toast_disable_camera));
                } else {
                    TUICallingVideoFunctionView tUICallingVideoFunctionView = TUICallingVideoFunctionView.this;
                    if (tUICallingVideoFunctionView.mLocalUserLayout != null) {
                        tUICallingVideoFunctionView.mCallingAction.openCamera(TUICallingStatusManager.sharedInstance(tUICallingVideoFunctionView.mContext).getFrontCamera(), TUICallingVideoFunctionView.this.mLocalUserLayout.getVideoView(), (TUICommonDefine.Callback) null);
                        ToastUtil.toastShortMessage(TUICallingVideoFunctionView.this.mContext.getString(R.string.tuicalling_toast_enable_camera));
                    }
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mImageSwitchCamera.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICommonDefine.Camera frontCamera = TUICallingStatusManager.sharedInstance(TUICallingVideoFunctionView.this.mContext).getFrontCamera();
                TUICallingAction tUICallingAction = TUICallingVideoFunctionView.this.mCallingAction;
                TUICommonDefine.Camera camera = TUICommonDefine.Camera.Front;
                if (camera.equals(frontCamera)) {
                    camera = TUICommonDefine.Camera.Back;
                }
                tUICallingAction.switchCamera(camera);
                ToastUtil.toastShortMessage(TUICallingVideoFunctionView.this.mContext.getString(R.string.tuicalling_toast_switch_camera));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutHangup.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICallingVideoFunctionView.this.mCallingAction.hangup((TUICommonDefine.Callback) null);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_funcation_view_video, this);
        this.mLayoutMute = (LinearLayout) findViewById(R.id.ll_mute);
        this.mImageMute = (ImageView) findViewById(R.id.iv_mute);
        this.mLayoutHandsFree = (LinearLayout) findViewById(R.id.ll_handsfree);
        this.mImageHandsFree = (ImageView) findViewById(R.id.iv_handsfree);
        this.mLayoutOpenCamera = (LinearLayout) findViewById(R.id.ll_open_camera);
        this.mImageOpenCamera = (ImageView) findViewById(R.id.img_camera);
        this.mLayoutHangup = (LinearLayout) findViewById(R.id.ll_hangup);
        this.mImageSwitchCamera = (ImageView) findViewById(R.id.switch_camera);
    }

    public void updateAudioPlayDevice(boolean z11) {
        super.updateAudioPlayDevice(z11);
        this.mImageHandsFree.setActivated(z11);
    }

    public void updateCameraOpenStatus(boolean z11) {
        super.updateCameraOpenStatus(z11);
        this.mImageOpenCamera.setActivated(z11);
    }

    public void updateMicMuteStatus(boolean z11) {
        super.updateMicMuteStatus(z11);
        this.mImageMute.setActivated(z11);
    }
}
