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
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;

public class TUICallingAudioFunctionView extends BaseFunctionView {
    private ImageView mImageHandsFree;
    private ImageView mImageMute;
    private LinearLayout mLayoutHandsFree;
    private LinearLayout mLayoutHangup;
    private LinearLayout mLayoutMute;

    public TUICallingAudioFunctionView(Context context) {
        super(context);
        initView();
        initListener();
    }

    private void initListener() {
        this.mLayoutMute.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                boolean isMicMute = TUICallingStatusManager.sharedInstance(TUICallingAudioFunctionView.this.mContext).isMicMute();
                if (isMicMute) {
                    TUICallingAudioFunctionView.this.mCallingAction.openMicrophone(new TUICommonDefine.Callback() {
                        public void onError(int i11, String str) {
                        }

                        public void onSuccess() {
                        }
                    });
                } else {
                    TUICallingAudioFunctionView.this.mCallingAction.closeMicrophone();
                }
                ToastUtil.toastShortMessage(TUICallingAudioFunctionView.this.mContext.getString(isMicMute ? R.string.tuicalling_toast_disable_mute : R.string.tuicalling_toast_enable_mute));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutHangup.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICallingAudioFunctionView.this.mCallingAction.hangup((TUICommonDefine.Callback) null);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutHandsFree.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUICommonDefine.AudioPlaybackDevice audioPlaybackDevice = TUICommonDefine.AudioPlaybackDevice.Speakerphone;
                boolean equals = audioPlaybackDevice.equals(TUICallingStatusManager.sharedInstance(TUICallingAudioFunctionView.this.mContext).getAudioPlaybackDevice());
                if (equals) {
                    TUICallingAudioFunctionView.this.mCallingAction.selectAudioPlaybackDevice(TUICommonDefine.AudioPlaybackDevice.Earpiece);
                } else {
                    TUICallingAudioFunctionView.this.mCallingAction.selectAudioPlaybackDevice(audioPlaybackDevice);
                }
                ToastUtil.toastShortMessage(TUICallingAudioFunctionView.this.mContext.getString(equals ? R.string.tuicalling_toast_use_handset : R.string.tuicalling_toast_speaker));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_funcation_view_audio, this);
        this.mLayoutMute = (LinearLayout) findViewById(R.id.ll_mute);
        this.mImageMute = (ImageView) findViewById(R.id.img_mute);
        this.mLayoutHangup = (LinearLayout) findViewById(R.id.ll_hangup);
        this.mLayoutHandsFree = (LinearLayout) findViewById(R.id.ll_handsfree);
        this.mImageHandsFree = (ImageView) findViewById(R.id.img_handsfree);
    }

    public void updateAudioPlayDevice(boolean z11) {
        super.updateAudioPlayDevice(z11);
        this.mImageHandsFree.setActivated(z11);
    }

    public void updateMicMuteStatus(boolean z11) {
        super.updateMicMuteStatus(z11);
        this.mImageMute.setActivated(z11);
    }
}
