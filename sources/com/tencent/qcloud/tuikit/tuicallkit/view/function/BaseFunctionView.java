package com.tencent.qcloud.tuikit.tuicallkit.view.function;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallkit.base.Constants;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingAction;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayout;
import java.util.Map;

public abstract class BaseFunctionView extends RelativeLayout {
    public TUICallingAction mCallingAction;
    public Context mContext;
    public UserLayout mLocalUserLayout;
    private final ITUINotification mNotification = new ITUINotification() {
        public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
            if (Constants.EVENT_TUICALLING_CHANGED.equals(str) && map != null) {
                str2.hashCode();
                char c11 = 65535;
                switch (str2.hashCode()) {
                    case -2042145547:
                        if (str2.equals(Constants.EVENT_SUB_CAMERA_OPEN)) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 1836742849:
                        if (str2.equals(Constants.EVENT_SUB_MIC_STATUS_CHANGED)) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 2028149850:
                        if (str2.equals(Constants.EVENT_SUB_AUDIOPLAYDEVICE_CHANGED)) {
                            c11 = 2;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        BaseFunctionView.this.updateCameraOpenStatus(((Boolean) map.get(Constants.OPEN_CAMERA)).booleanValue());
                        return;
                    case 1:
                        BaseFunctionView.this.updateMicMuteStatus(((Boolean) map.get(Constants.MUTE_MIC)).booleanValue());
                        return;
                    case 2:
                        BaseFunctionView.this.updateAudioPlayDevice(TUICommonDefine.AudioPlaybackDevice.Speakerphone.equals((TUICommonDefine.AudioPlaybackDevice) map.get(Constants.HANDS_FREE)));
                        return;
                    default:
                        return;
                }
            }
        }
    };

    public BaseFunctionView(Context context) {
        super(context);
        this.mContext = context.getApplicationContext();
        this.mCallingAction = new TUICallingAction(context);
        registerEvent();
    }

    private void registerEvent() {
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CAMERA_OPEN, this.mNotification);
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_MIC_STATUS_CHANGED, this.mNotification);
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_AUDIOPLAYDEVICE_CHANGED, this.mNotification);
    }

    public void setLocalUserLayout(UserLayout userLayout) {
        this.mLocalUserLayout = userLayout;
    }

    public void updateAudioPlayDevice(boolean z11) {
    }

    public void updateCameraOpenStatus(boolean z11) {
    }

    public void updateMicMuteStatus(boolean z11) {
    }

    public void updateTextColor(int i11) {
    }
}
