package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMSDKListener {
    public void onConnectFailed(int i11, String str) {
    }

    public void onConnectSuccess() {
    }

    public void onConnecting() {
    }

    public void onKickedOffline() {
    }

    public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
    }

    public void onUserSigExpired() {
    }

    public void onUserStatusChanged(List<V2TIMUserStatus> list) {
    }
}
