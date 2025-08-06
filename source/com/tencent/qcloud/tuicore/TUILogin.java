package com.tencent.qcloud.tuicore;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMLogListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import com.tencent.qcloud.tuicore.interfaces.TUILogListener;
import com.tencent.qcloud.tuicore.interfaces.TUILoginConfig;
import com.tencent.qcloud.tuicore.interfaces.TUILoginListener;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class TUILogin {
    /* access modifiers changed from: private */
    public static final String TAG = "TUILogin";
    private static Context appContext;
    /* access modifiers changed from: private */
    public static int sdkAppId;
    private int currentBusinessScene;
    /* access modifiers changed from: private */
    public boolean hasLoginSuccess;
    private final V2TIMSDKListener imSdkListener;
    /* access modifiers changed from: private */
    public final List<TUILoginListener> listenerList;
    /* access modifiers changed from: private */
    public String userId;
    /* access modifiers changed from: private */
    public String userSig;

    public static class TUIBusinessScene {
        public static final int IN_CALLING_ROOM = 2;
        public static final int IN_LIVING_ROOM = 4;
        public static final int IN_MEETING_ROOM = 3;
        public static final int IN_RECORDING = 1;
        public static final int NONE = 0;
    }

    public static class TUILoginHolder {
        /* access modifiers changed from: private */
        public static final TUILogin loginInstance = new TUILogin();

        private TUILoginHolder() {
        }
    }

    public static void addLoginListener(TUILoginListener tUILoginListener) {
        getInstance().internalAddLoginListener(tUILoginListener);
    }

    public static Context getAppContext() {
        getInstance();
        return appContext;
    }

    public static int getCurrentBusinessScene() {
        return getInstance().currentBusinessScene;
    }

    public static String getFaceUrl() {
        return TUIConfig.getSelfFaceUrl();
    }

    public static TUILogin getInstance() {
        return TUILoginHolder.loginInstance;
    }

    public static String getLoginUser() {
        return V2TIMManager.getInstance().getLoginUser();
    }

    public static String getNickName() {
        return TUIConfig.getSelfNickName();
    }

    public static int getSdkAppId() {
        getInstance();
        return sdkAppId;
    }

    public static String getUserId() {
        return getInstance().userId;
    }

    /* access modifiers changed from: private */
    public static void getUserInfo(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
            public void onError(int i11, String str) {
                String access$900 = TUILogin.TAG;
                Log.e(access$900, "get logined userInfo failed. code : " + i11 + " desc : " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(List<V2TIMUserFullInfo> list) {
                if (list.isEmpty()) {
                    Log.e(TUILogin.TAG, "get logined userInfo failed. list is empty");
                    return;
                }
                V2TIMUserFullInfo v2TIMUserFullInfo = list.get(0);
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }
        });
    }

    public static String getUserSig() {
        return getInstance().userSig;
    }

    @Deprecated
    public static boolean init(Context context, int i11, V2TIMSDKConfig v2TIMSDKConfig, final V2TIMSDKListener v2TIMSDKListener) {
        getInstance();
        if (sdkAppId != 0) {
            getInstance();
            if (i11 != sdkAppId) {
                logout((V2TIMCallback) null);
                unInit();
            }
        }
        getInstance();
        appContext = context.getApplicationContext();
        getInstance();
        sdkAppId = i11;
        V2TIMManager.getInstance().addIMSDKListener(new V2TIMSDKListener() {
            public void onConnectFailed(int i11, String str) {
                V2TIMSDKListener v2TIMSDKListener = V2TIMSDKListener.this;
                if (v2TIMSDKListener != null) {
                    v2TIMSDKListener.onConnectFailed(i11, ErrorMessageConverter.convertIMError(i11, str));
                }
            }

            public void onConnectSuccess() {
                V2TIMSDKListener v2TIMSDKListener = V2TIMSDKListener.this;
                if (v2TIMSDKListener != null) {
                    v2TIMSDKListener.onConnectSuccess();
                }
            }

            public void onConnecting() {
                V2TIMSDKListener v2TIMSDKListener = V2TIMSDKListener.this;
                if (v2TIMSDKListener != null) {
                    v2TIMSDKListener.onConnecting();
                }
            }

            public void onKickedOffline() {
                V2TIMSDKListener v2TIMSDKListener = V2TIMSDKListener.this;
                if (v2TIMSDKListener != null) {
                    v2TIMSDKListener.onKickedOffline();
                }
                TUILogin.setCurrentBusinessScene(0);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE, (Map<String, Object>) null);
            }

            public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
                V2TIMSDKListener v2TIMSDKListener = V2TIMSDKListener.this;
                if (v2TIMSDKListener != null) {
                    v2TIMSDKListener.onSelfInfoUpdated(v2TIMUserFullInfo);
                }
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }

            public void onUserSigExpired() {
                V2TIMSDKListener v2TIMSDKListener = V2TIMSDKListener.this;
                if (v2TIMSDKListener != null) {
                    v2TIMSDKListener.onUserSigExpired();
                }
                TUILogin.setCurrentBusinessScene(0);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED, (Map<String, Object>) null);
            }
        });
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT, (Map<String, Object>) null);
        return V2TIMManager.getInstance().initSDK(context, i11, v2TIMSDKConfig);
    }

    public static void initContext(Context context, int i11) {
        appContext = context.getApplicationContext();
        sdkAppId = i11;
    }

    private void internalAddLoginListener(TUILoginListener tUILoginListener) {
        String str = TAG;
        Log.i(str, "addLoginListener listener : " + tUILoginListener);
        if (tUILoginListener != null && !this.listenerList.contains(tUILoginListener)) {
            this.listenerList.add(tUILoginListener);
        }
    }

    private void internalLogin(Context context, int i11, final String str, String str2, TUILoginConfig tUILoginConfig, final TUICallback tUICallback) {
        V2TIMSDKConfig v2TIMSDKConfig;
        int i12 = sdkAppId;
        if (!(i12 == 0 || i11 == i12)) {
            logout((TUICallback) null);
        }
        appContext = context.getApplicationContext();
        sdkAppId = i11;
        this.currentBusinessScene = 0;
        V2TIMManager.getInstance().addIMSDKListener(this.imSdkListener);
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT, (Map<String, Object>) null);
        if (tUILoginConfig != null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
            v2TIMSDKConfig.setLogLevel(tUILoginConfig.getLogLevel());
            final TUILogListener logListener = tUILoginConfig.getLogListener();
            if (logListener != null) {
                v2TIMSDKConfig.setLogListener(new V2TIMLogListener() {
                    public void onLog(int i11, String str) {
                        logListener.onLog(i11, str);
                    }
                });
            }
        } else {
            v2TIMSDKConfig = null;
        }
        if (V2TIMManager.getInstance().initSDK(context, i11, v2TIMSDKConfig)) {
            this.userId = str;
            this.userSig = str2;
            if (!TextUtils.equals(str, V2TIMManager.getInstance().getLoginUser()) || TextUtils.isEmpty(str)) {
                V2TIMManager.getInstance().login(str, str2, new V2TIMCallback() {
                    public void onError(int i11, String str) {
                        TUICallback.onError(tUICallback, i11, ErrorMessageConverter.convertIMError(i11, str));
                    }

                    public void onSuccess() {
                        boolean unused = TUILogin.this.hasLoginSuccess = true;
                        TUILogin.getUserInfo(str);
                        TUICallback.onSuccess(tUICallback);
                        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, (Map<String, Object>) null);
                    }
                });
                return;
            }
            this.hasLoginSuccess = true;
            getUserInfo(str);
            TUICallback.onSuccess(tUICallback);
            TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, (Map<String, Object>) null);
            return;
        }
        TUICallback.onError(tUICallback, -1, "init failed");
    }

    private void internalLogout(final TUICallback tUICallback) {
        this.currentBusinessScene = 0;
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_UNINIT, (Map<String, Object>) null);
        V2TIMManager.getInstance().logout(new V2TIMCallback() {
            public void onError(int i11, String str) {
                TUICallback.onError(tUICallback, i11, str);
            }

            public void onSuccess() {
                int unused = TUILogin.sdkAppId = 0;
                String unused2 = TUILogin.this.userId = null;
                String unused3 = TUILogin.this.userSig = null;
                V2TIMManager.getInstance().unInitSDK();
                TUIConfig.clearSelfInfo();
                TUICallback.onSuccess(tUICallback);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, (Map<String, Object>) null);
            }
        });
    }

    private void internalRemoveLoginListener(TUILoginListener tUILoginListener) {
        String str = TAG;
        Log.i(str, "removeLoginListener listener : " + tUILoginListener);
        if (tUILoginListener != null) {
            this.listenerList.remove(tUILoginListener);
        }
    }

    public static boolean isUserLogined() {
        return getInstance().hasLoginSuccess && V2TIMManager.getInstance().getLoginStatus() == 1;
    }

    public static void login(Context context, int i11, String str, String str2, TUICallback tUICallback) {
        getInstance().internalLogin(context, i11, str, str2, (TUILoginConfig) null, tUICallback);
    }

    public static void logout(TUICallback tUICallback) {
        getInstance().internalLogout(tUICallback);
    }

    /* access modifiers changed from: private */
    public static void notifyUserInfoChanged(V2TIMUserFullInfo v2TIMUserFullInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUILogin.SELF_ID, v2TIMUserFullInfo.getUserID());
        hashMap.put(TUIConstants.TUILogin.SELF_SIGNATURE, v2TIMUserFullInfo.getSelfSignature());
        hashMap.put(TUIConstants.TUILogin.SELF_NICK_NAME, v2TIMUserFullInfo.getNickName());
        hashMap.put(TUIConstants.TUILogin.SELF_FACE_URL, v2TIMUserFullInfo.getFaceUrl());
        hashMap.put(TUIConstants.TUILogin.SELF_BIRTHDAY, Long.valueOf(v2TIMUserFullInfo.getBirthday()));
        hashMap.put(TUIConstants.TUILogin.SELF_ROLE, Integer.valueOf(v2TIMUserFullInfo.getRole()));
        hashMap.put(TUIConstants.TUILogin.SELF_GENDER, Integer.valueOf(v2TIMUserFullInfo.getGender()));
        hashMap.put(TUIConstants.TUILogin.SELF_LEVEL, Integer.valueOf(v2TIMUserFullInfo.getLevel()));
        hashMap.put(TUIConstants.TUILogin.SELF_ALLOW_TYPE, Integer.valueOf(v2TIMUserFullInfo.getAllowType()));
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_INFO_UPDATED, hashMap);
    }

    public static void removeLoginListener(TUILoginListener tUILoginListener) {
        getInstance().internalRemoveLoginListener(tUILoginListener);
    }

    public static void setCurrentBusinessScene(int i11) {
        getInstance().currentBusinessScene = i11;
    }

    @Deprecated
    public static void unInit() {
        getInstance();
        sdkAppId = 0;
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_UNINIT, (Map<String, Object>) null);
        V2TIMManager.getInstance().unInitSDK();
        TUIConfig.clearSelfInfo();
    }

    private TUILogin() {
        this.hasLoginSuccess = false;
        this.currentBusinessScene = 0;
        this.listenerList = new CopyOnWriteArrayList();
        this.imSdkListener = new V2TIMSDKListener() {
            public void onConnectFailed(int i11, String str) {
                for (TUILoginListener onConnectFailed : TUILogin.this.listenerList) {
                    onConnectFailed.onConnectFailed(i11, str);
                }
                TUICore.notifyEvent(TUIConstants.NetworkConnection.EVENT_CONNECTION_STATE_CHANGED, TUIConstants.NetworkConnection.EVENT_SUB_KEY_CONNECT_FAILED, (Map<String, Object>) null);
            }

            public void onConnectSuccess() {
                for (TUILoginListener onConnectSuccess : TUILogin.this.listenerList) {
                    onConnectSuccess.onConnectSuccess();
                }
                TUICore.notifyEvent(TUIConstants.NetworkConnection.EVENT_CONNECTION_STATE_CHANGED, TUIConstants.NetworkConnection.EVENT_SUB_KEY_CONNECT_SUCCESS, (Map<String, Object>) null);
            }

            public void onConnecting() {
                for (TUILoginListener onConnecting : TUILogin.this.listenerList) {
                    onConnecting.onConnecting();
                }
                TUICore.notifyEvent(TUIConstants.NetworkConnection.EVENT_CONNECTION_STATE_CHANGED, TUIConstants.NetworkConnection.EVENT_SUB_KEY_CONNECTING, (Map<String, Object>) null);
            }

            public void onKickedOffline() {
                for (TUILoginListener onKickedOffline : TUILogin.this.listenerList) {
                    onKickedOffline.onKickedOffline();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE, (Map<String, Object>) null);
            }

            public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }

            public void onUserSigExpired() {
                for (TUILoginListener onUserSigExpired : TUILogin.this.listenerList) {
                    onUserSigExpired.onUserSigExpired();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED, (Map<String, Object>) null);
            }
        };
    }

    public static void login(Context context, int i11, String str, String str2, TUILoginConfig tUILoginConfig, TUICallback tUICallback) {
        getInstance().internalLogin(context, i11, str, str2, tUILoginConfig, tUICallback);
    }

    @Deprecated
    public static void logout(final V2TIMCallback v2TIMCallback) {
        V2TIMManager.getInstance().logout(new V2TIMCallback() {
            public void onError(int i11, String str) {
                V2TIMCallback v2TIMCallback = V2TIMCallback.this;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i11, ErrorMessageConverter.convertIMError(i11, str));
                }
            }

            public void onSuccess() {
                String unused = TUILogin.getInstance().userId = null;
                String unused2 = TUILogin.getInstance().userSig = null;
                V2TIMCallback v2TIMCallback = V2TIMCallback.this;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
                TUIConfig.clearSelfInfo();
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, (Map<String, Object>) null);
            }
        });
    }

    @Deprecated
    public static void login(final String str, String str2, final V2TIMCallback v2TIMCallback) {
        getInstance().userId = str;
        getInstance().userSig = str2;
        if (!TextUtils.equals(str, V2TIMManager.getInstance().getLoginUser()) || TextUtils.isEmpty(str)) {
            V2TIMManager.getInstance().login(str, str2, new V2TIMCallback() {
                public void onError(int i11, String str) {
                    V2TIMCallback v2TIMCallback = V2TIMCallback.this;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(i11, ErrorMessageConverter.convertIMError(i11, str));
                    }
                }

                public void onSuccess() {
                    boolean unused = TUILogin.getInstance().hasLoginSuccess = true;
                    V2TIMCallback v2TIMCallback = V2TIMCallback.this;
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onSuccess();
                    }
                    TUILogin.getUserInfo(str);
                    TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, (Map<String, Object>) null);
                }
            });
            return;
        }
        if (v2TIMCallback != null) {
            v2TIMCallback.onSuccess();
        }
        getUserInfo(str);
    }
}
