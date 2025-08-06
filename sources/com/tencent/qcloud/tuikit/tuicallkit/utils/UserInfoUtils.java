package com.tencent.qcloud.tuikit.tuicallkit.utils;

import android.text.TextUtils;
import com.huochat.community.network.domain.DomainTool;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import java.util.ArrayList;
import java.util.List;

public class UserInfoUtils {
    private static final String ERROR_MSG_EMPTY_LIST = "userList is empty";
    private static final String TAG = "UserInfoUtils";

    public interface UserCallback {
        void onFailed(int i11, String str);

        void onSuccess(List<CallingUserModel> list);
    }

    private void internalGetUserInfo(List<String> list, final UserCallback userCallback) {
        if (list == null || list.isEmpty()) {
            TUILog.e(TAG, "internalGetUserInfo, userIdList is empty.");
            if (userCallback != null) {
                userCallback.onFailed(-1, ERROR_MSG_EMPTY_LIST);
                return;
            }
            return;
        }
        V2TIMManager.getInstance().getUsersInfo(list, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
            public void onError(int i11, String str) {
                TUILog.e(UserInfoUtils.TAG, "internalGetUserInfo fail, errorCode: " + i11 + ", errorMsg: " + str);
                UserCallback userCallback = userCallback;
                if (userCallback != null) {
                    userCallback.onFailed(i11, str);
                }
            }

            public void onSuccess(List<V2TIMUserFullInfo> list) {
                if (list == null || list.isEmpty()) {
                    TUILog.e(UserInfoUtils.TAG, "internalGetUserInfo result is empty");
                    UserCallback userCallback = userCallback;
                    if (userCallback != null) {
                        userCallback.onFailed(-1, UserInfoUtils.ERROR_MSG_EMPTY_LIST);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    CallingUserModel callingUserModel = new CallingUserModel();
                    callingUserModel.userName = list.get(i11).getNickName();
                    callingUserModel.userId = list.get(i11).getUserID();
                    String faceUrl = list.get(i11).getFaceUrl();
                    callingUserModel.userAvatar = faceUrl;
                    if (!UserInfoUtils.this.isUrl(faceUrl)) {
                        callingUserModel.userAvatar = "";
                    }
                    callingUserModel.userName = TextUtils.isEmpty(callingUserModel.userName) ? callingUserModel.userId : callingUserModel.userName;
                    TUILog.i(UserInfoUtils.TAG, "internalGetUserInfo, model: " + callingUserModel);
                    arrayList.add(callingUserModel);
                }
                UserCallback userCallback2 = userCallback;
                if (userCallback2 != null) {
                    userCallback2.onSuccess(arrayList);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean isUrl(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(DomainTool.DOMAIN_PREFIX_HTTP) || str.startsWith(DomainTool.DOMAIN_PREFIX));
    }

    public void getUserInfo(String str, UserCallback userCallback) {
        if (TextUtils.isEmpty(str)) {
            TUILog.e(TAG, "getUserInfo, userId is empty.");
            if (userCallback != null) {
                userCallback.onFailed(-1, ERROR_MSG_EMPTY_LIST);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        internalGetUserInfo(arrayList, userCallback);
    }

    public void getUserInfo(List<CallingUserModel> list, UserCallback userCallback) {
        if (list == null || list.isEmpty()) {
            TUILog.e(TAG, "getUserInfo, userIdList is empty.");
            if (userCallback != null) {
                userCallback.onFailed(-1, ERROR_MSG_EMPTY_LIST);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CallingUserModel next : list) {
            if (next != null && !TextUtils.isEmpty(next.userId)) {
                arrayList.add(next.userId);
            }
        }
        internalGetUserInfo(arrayList, userCallback);
    }
}
