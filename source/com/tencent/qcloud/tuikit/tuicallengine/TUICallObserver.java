package com.tencent.qcloud.tuikit.tuicallengine;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import java.util.List;
import java.util.Map;

public abstract class TUICallObserver {
    public void onCallBegin(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role) {
    }

    public void onCallCancelled(String str) {
    }

    public void onCallEnd(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role, long j11) {
    }

    public void onCallMediaTypeChanged(TUICallDefine.MediaType mediaType, TUICallDefine.MediaType mediaType2) {
    }

    @Deprecated
    public void onCallReceived(String str, List<String> list, String str2, TUICallDefine.MediaType mediaType) {
    }

    public void onCallReceived(String str, List<String> list, String str2, TUICallDefine.MediaType mediaType, String str3) {
    }

    public void onError(int i11, String str) {
    }

    public void onKickedOffline() {
    }

    public void onUserAudioAvailable(String str, boolean z11) {
    }

    public void onUserJoin(String str) {
    }

    public void onUserLeave(String str) {
    }

    public void onUserLineBusy(String str) {
    }

    public void onUserNetworkQualityChanged(List<TUICommonDefine.NetworkQualityInfo> list) {
    }

    public void onUserNoResponse(String str) {
    }

    public void onUserReject(String str) {
    }

    public void onUserSigExpired() {
    }

    public void onUserVideoAvailable(String str, boolean z11) {
    }

    public void onUserVoiceVolumeChanged(Map<String, Integer> map) {
    }
}
