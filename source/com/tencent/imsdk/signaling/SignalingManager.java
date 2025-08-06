package com.tencent.imsdk.signaling;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageOfflinePushInfo;
import java.util.List;

public class SignalingManager {
    private static String TAG = "SignalingManager";
    private SignalingListener mInternalSignalingListener;
    /* access modifiers changed from: private */
    public SignalingListener mSignalingListener;

    public static class SignalingManagerHolder {
        /* access modifiers changed from: private */
        public static final SignalingManager signalingManager = new SignalingManager();

        private SignalingManagerHolder() {
        }
    }

    public static SignalingManager getInstance() {
        return SignalingManagerHolder.signalingManager;
    }

    private void initSignalingListener() {
        if (this.mInternalSignalingListener == null) {
            this.mInternalSignalingListener = new SignalingListener() {
                public void onInvitationCancelled(final String str, final String str2, final String str3) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (SignalingManager.this.mSignalingListener != null) {
                                SignalingManager.this.mSignalingListener.onInvitationCancelled(str, str2, str3);
                            }
                        }
                    });
                }

                public void onInvitationModified(final String str, final String str2) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (SignalingManager.this.mSignalingListener != null) {
                                SignalingManager.this.mSignalingListener.onInvitationModified(str, str2);
                            }
                        }
                    });
                }

                public void onInvitationTimeout(final String str, final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (SignalingManager.this.mSignalingListener != null) {
                                SignalingManager.this.mSignalingListener.onInvitationTimeout(str, list);
                            }
                        }
                    });
                }

                public void onInviteeAccepted(final String str, final String str2, final String str3) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (SignalingManager.this.mSignalingListener != null) {
                                SignalingManager.this.mSignalingListener.onInviteeAccepted(str, str2, str3);
                            }
                        }
                    });
                }

                public void onInviteeRejected(final String str, final String str2, final String str3) {
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (SignalingManager.this.mSignalingListener != null) {
                                SignalingManager.this.mSignalingListener.onInviteeRejected(str, str2, str3);
                            }
                        }
                    });
                }

                public void onReceiveNewInvitation(String str, String str2, String str3, List<String> list, String str4) {
                    final String str5 = str;
                    final String str6 = str2;
                    final String str7 = str3;
                    final List<String> list2 = list;
                    final String str8 = str4;
                    IMContext.getInstance().runOnMainThread(new Runnable() {
                        public void run() {
                            if (SignalingManager.this.mSignalingListener != null) {
                                SignalingManager.this.mSignalingListener.onReceiveNewInvitation(str5, str6, str7, list2, str8);
                            }
                        }
                    });
                }
            };
        }
        nativeSetSignalingObserver(this.mInternalSignalingListener);
    }

    public void accept(String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeAccept(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void addInvitedSignaling(SignalingInfo signalingInfo, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            IMLog.e(TAG, "addInvitedSignaling error, sdk not init");
        } else {
            nativeAddInvitedSignaling(signalingInfo, iMCallback);
        }
    }

    public void cancel(String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeCancel(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public SignalingInfo getSignalingInfo(Message message) {
        if (BaseManager.getInstance().isInited()) {
            return nativeGetSignalingInfo(message);
        }
        IMLog.e(TAG, "getSignalingInfo error, sdk not init");
        return null;
    }

    public void init() {
        initSignalingListener();
    }

    public String invite(String str, String str2, boolean z11, MessageOfflinePushInfo messageOfflinePushInfo, int i11, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            return nativeInvite(str, str2, z11, messageOfflinePushInfo, i11, iMCallback);
        }
        if (iMCallback == null) {
            return null;
        }
        iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        return null;
    }

    public String inviteInGroup(String str, List<String> list, String str2, boolean z11, int i11, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            return nativeInviteInGroup(str, list, str2, z11, i11, iMCallback);
        }
        if (iMCallback == null) {
            return null;
        }
        iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        return null;
    }

    public void modifyInvitation(String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            IMLog.e(TAG, "modifyInvitation error, sdk not init");
        } else {
            nativeModifyInvitation(str, str2, iMCallback);
        }
    }

    public native void nativeAccept(String str, String str2, IMCallback iMCallback);

    public native void nativeAddInvitedSignaling(SignalingInfo signalingInfo, IMCallback iMCallback);

    public native void nativeCancel(String str, String str2, IMCallback iMCallback);

    public native SignalingInfo nativeGetSignalingInfo(Message message);

    public native String nativeInvite(String str, String str2, boolean z11, MessageOfflinePushInfo messageOfflinePushInfo, int i11, IMCallback iMCallback);

    public native String nativeInviteInGroup(String str, List<String> list, String str2, boolean z11, int i11, IMCallback iMCallback);

    public native void nativeModifyInvitation(String str, String str2, IMCallback iMCallback);

    public native void nativeReject(String str, String str2, IMCallback iMCallback);

    public native void nativeSetSignalingObserver(SignalingListener signalingListener);

    public void reject(String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeReject(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setSignalingListener(SignalingListener signalingListener) {
        this.mSignalingListener = signalingListener;
    }
}
