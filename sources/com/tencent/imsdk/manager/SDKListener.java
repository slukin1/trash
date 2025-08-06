package com.tencent.imsdk.manager;

import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserStatus;
import java.util.List;

public interface SDKListener {
    void onConnectFailed(int i11, String str);

    void onConnectSuccess();

    void onConnecting();

    void onKickedOffline();

    void onLog(int i11, String str);

    void onSelfInfoUpdated(UserInfo userInfo);

    void onUserSigExpired();

    void onUserStatusChanged(List<UserStatus> list);
}
