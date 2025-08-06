package com.tencent.qcloud.tuikit.tuicallengine;

import android.content.Context;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.TUIVideoView;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.trtc.TRTCCloud;
import java.util.List;

public abstract class TUICallEngine {
    public static TUICallEngine createInstance(Context context) {
        if (a.f48173a == null) {
            synchronized (a.class) {
                if (a.f48173a == null) {
                    a.f48173a = new a(context);
                }
            }
        }
        return a.f48173a;
    }

    public static void destroyInstance() {
        a aVar = a.f48173a;
        synchronized (a.class) {
            a aVar2 = a.f48173a;
            if (aVar2 != null) {
                aVar2.b();
                a.f48173a = null;
            }
        }
    }

    public abstract void accept(TUICommonDefine.Callback callback);

    public abstract void addObserver(TUICallObserver tUICallObserver);

    @Deprecated
    public abstract void call(TUICommonDefine.RoomId roomId, String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback);

    public abstract void call(String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback);

    public abstract void callExperimentalAPI(String str);

    public abstract void closeCamera();

    public abstract void closeMicrophone();

    public abstract void deleteRecordCalls(List<String> list, TUICommonDefine.ValueCallback valueCallback);

    public abstract void enableMultiDeviceAbility(boolean z11, TUICommonDefine.Callback callback);

    public abstract TRTCCloud getTRTCCloudInstance();

    @Deprecated
    public abstract void groupCall(TUICommonDefine.RoomId roomId, String str, List<String> list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback);

    public abstract void groupCall(String str, List<String> list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback);

    public abstract void hangup(TUICommonDefine.Callback callback);

    public abstract void ignore(TUICommonDefine.Callback callback);

    public abstract void init(int i11, String str, String str2, TUICommonDefine.Callback callback);

    public abstract void inviteUser(List<String> list, TUICallDefine.CallParams callParams, TUICommonDefine.ValueCallback valueCallback);

    public abstract void joinInGroupCall(TUICommonDefine.RoomId roomId, String str, TUICallDefine.MediaType mediaType, TUICommonDefine.Callback callback);

    public abstract void openCamera(TUICommonDefine.Camera camera, TUIVideoView tUIVideoView, TUICommonDefine.Callback callback);

    public abstract void openMicrophone(TUICommonDefine.Callback callback);

    @Deprecated
    public abstract void queryOfflineCall();

    public abstract void queryRecentCalls(TUICallDefine.RecentCallsFilter recentCallsFilter, TUICommonDefine.ValueCallback valueCallback);

    public abstract void reject(TUICommonDefine.Callback callback);

    public abstract void removeObserver(TUICallObserver tUICallObserver);

    public abstract void selectAudioPlaybackDevice(TUICommonDefine.AudioPlaybackDevice audioPlaybackDevice);

    public abstract void setBeautyLevel(float f11, TUICommonDefine.Callback callback);

    public abstract void setBlurBackground(int i11, TUICommonDefine.Callback callback);

    public abstract void setSelfInfo(String str, String str2, TUICommonDefine.Callback callback);

    public abstract void setVideoEncoderParams(TUICommonDefine.VideoEncoderParams videoEncoderParams, TUICommonDefine.Callback callback);

    public abstract void setVideoRenderParams(String str, TUICommonDefine.VideoRenderParams videoRenderParams, TUICommonDefine.Callback callback);

    public abstract void setVirtualBackground(String str, TUICommonDefine.Callback callback);

    public abstract void startRemoteView(String str, TUIVideoView tUIVideoView, TUICommonDefine.PlayCallback playCallback);

    public abstract void stopRemoteView(String str);

    public abstract void switchCallMediaType(TUICallDefine.MediaType mediaType);

    public abstract void switchCamera(TUICommonDefine.Camera camera);
}
