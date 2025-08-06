package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.MessageOfflinePushInfo;
import com.tencent.imsdk.signaling.SignalingInfo;
import com.tencent.imsdk.signaling.SignalingListener;
import com.tencent.imsdk.signaling.SignalingManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class V2TIMSignalingManagerImpl extends V2TIMSignalingManager {
    private final String TAG;
    private boolean mHasValidSignalingListener;
    private SignalingListener mInternalSignalingListener;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<V2TIMSignalingListener> mSignalingListenerList;

    public static class V2TIMSignalingManagerImplHolder {
        /* access modifiers changed from: private */
        public static final V2TIMSignalingManagerImpl v2TIMSignalingManagerImpl = new V2TIMSignalingManagerImpl();

        private V2TIMSignalingManagerImplHolder() {
        }
    }

    private void checkSignalingListener() {
        BaseManager.getInstance().enableSignaling(this.mHasValidSignalingListener);
    }

    public static V2TIMSignalingManagerImpl getInstance() {
        return V2TIMSignalingManagerImplHolder.v2TIMSignalingManagerImpl;
    }

    private void initSignalingListener() {
        if (this.mInternalSignalingListener == null) {
            this.mInternalSignalingListener = new SignalingListener() {
                public void onInvitationCancelled(String str, String str2, String str3) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                        while (it2.hasNext()) {
                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                            if (v2TIMSignalingListener != null) {
                                v2TIMSignalingListener.onInvitationCancelled(str, str2, str3);
                            }
                        }
                    }
                }

                public void onInvitationModified(String str, String str2) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                        while (it2.hasNext()) {
                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                            if (v2TIMSignalingListener != null) {
                                v2TIMSignalingListener.onInvitationModified(str, str2);
                            }
                        }
                    }
                }

                public void onInvitationTimeout(String str, List<String> list) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                        while (it2.hasNext()) {
                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                            if (v2TIMSignalingListener != null) {
                                v2TIMSignalingListener.onInvitationTimeout(str, list);
                            }
                        }
                    }
                }

                public void onInviteeAccepted(String str, String str2, String str3) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                        while (it2.hasNext()) {
                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                            if (v2TIMSignalingListener != null) {
                                v2TIMSignalingListener.onInviteeAccepted(str, str2, str3);
                            }
                        }
                    }
                }

                public void onInviteeRejected(String str, String str2, String str3) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                        while (it2.hasNext()) {
                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                            if (v2TIMSignalingListener != null) {
                                v2TIMSignalingListener.onInviteeRejected(str, str2, str3);
                            }
                        }
                    }
                }

                public void onReceiveNewInvitation(String str, String str2, String str3, List<String> list, String str4) {
                    synchronized (V2TIMSignalingManagerImpl.this) {
                        Iterator it2 = V2TIMSignalingManagerImpl.this.mSignalingListenerList.iterator();
                        while (it2.hasNext()) {
                            V2TIMSignalingListener v2TIMSignalingListener = (V2TIMSignalingListener) it2.next();
                            if (v2TIMSignalingListener != null) {
                                v2TIMSignalingListener.onReceiveNewInvitation(str, str2, str3, list, str4);
                            }
                        }
                    }
                }
            };
        }
        SignalingManager.getInstance().setSignalingListener(this.mInternalSignalingListener);
    }

    public void accept(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMSigMgrImpl", "signaling accept failed, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is null");
                return;
            }
            return;
        }
        SignalingManager.getInstance().accept(str, str2, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void addInvitedSignaling(V2TIMSignalingInfo v2TIMSignalingInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMSignalingInfo == null || TextUtils.isEmpty(v2TIMSignalingInfo.getInviteID()) || TextUtils.isEmpty(v2TIMSignalingInfo.getInviter()) || v2TIMSignalingInfo.getInviteeList() == null || v2TIMSignalingInfo.getInviteeList().isEmpty()) {
            IMLog.e("V2TIMSigMgrImpl", "addInvitedSignaling, info is invalid");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "V2TIMSignalingInfo is invalid");
                return;
            }
            return;
        }
        SignalingManager.getInstance().addInvitedSignaling(v2TIMSignalingInfo.getSignalingInfo(), new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void addSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            if (!this.mSignalingListenerList.contains(v2TIMSignalingListener)) {
                this.mSignalingListenerList.add(v2TIMSignalingListener);
                this.mHasValidSignalingListener = true;
                checkSignalingListener();
            }
        }
    }

    public void cancel(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            SignalingManager.getInstance().cancel(str, str2, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            IMLog.e("V2TIMSigMgrImpl", "signaling cancel error, inviteID is empty");
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is empty");
        }
    }

    public V2TIMSignalingInfo getSignalingInfo(V2TIMMessage v2TIMMessage) {
        SignalingInfo signalingInfo;
        if (v2TIMMessage == null || v2TIMMessage.getElemType() != 2 || (signalingInfo = SignalingManager.getInstance().getSignalingInfo(v2TIMMessage.getMessage())) == null || TextUtils.isEmpty(signalingInfo.getInviteID()) || TextUtils.isEmpty(signalingInfo.getInviter()) || signalingInfo.getInviteeList() == null || signalingInfo.getInviteeList().size() == 0 || signalingInfo.getActionType() == 0) {
            return null;
        }
        V2TIMSignalingInfo v2TIMSignalingInfo = new V2TIMSignalingInfo();
        v2TIMSignalingInfo.setSignalingInfo(signalingInfo);
        return v2TIMSignalingInfo;
    }

    public String invite(String str, String str2, boolean z11, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, int i11, V2TIMCallback v2TIMCallback) {
        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
        MessageOfflinePushInfo messageOfflinePushInfo = null;
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback2 != null) {
                v2TIMCallback2.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invitee is empty");
            }
            IMLog.e("V2TIMSigMgrImpl", "signaling invite error, invitee is empty");
            return null;
        } else if (i11 < 0) {
            if (v2TIMCallback2 != null) {
                IMLog.e("V2TIMSigMgrImpl", "signaling invite error, timeout invalid");
                v2TIMCallback2.onError(BaseConstants.ERR_INVALID_PARAMETERS, "timeout invalid");
            }
            return null;
        } else {
            if (v2TIMOfflinePushInfo != null) {
                messageOfflinePushInfo = v2TIMOfflinePushInfo.getMessageOfflinePushInfo();
            }
            return SignalingManager.getInstance().invite(str, str2, z11, messageOfflinePushInfo, i11, new IMCallback(v2TIMCallback2) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    public String inviteInGroup(String str, List<String> list, String str2, boolean z11, int i11, V2TIMCallback v2TIMCallback) {
        V2TIMCallback v2TIMCallback2 = v2TIMCallback;
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback2 != null) {
                v2TIMCallback2.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
            IMLog.e("V2TIMSigMgrImpl", "signaling invite error, groupID is empty");
            return null;
        } else if (list == null || list.size() == 0) {
            if (v2TIMCallback2 != null) {
                IMLog.e("V2TIMSigMgrImpl", "signaling invite error, inviteeList is empty");
                v2TIMCallback2.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteeList is empty");
            }
            return null;
        } else if (i11 < 0) {
            if (v2TIMCallback2 != null) {
                IMLog.e("V2TIMSigMgrImpl", "signaling invite error, timeout invalid");
                v2TIMCallback2.onError(BaseConstants.ERR_INVALID_PARAMETERS, "timeout invalid");
            }
            return null;
        } else {
            return SignalingManager.getInstance().inviteInGroup(str, list, str2, z11, i11, new IMCallback(v2TIMCallback2) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    public void modifyInvitation(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            SignalingManager.getInstance().modifyInvitation(str, str2, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            IMLog.e("V2TIMSigMgrImpl", "modifyInvitation error, inviteID is empty");
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is empty");
        }
    }

    public void reject(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMSigMgrImpl", "signaling reject invite, inviteID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "inviteID is null");
                return;
            }
            return;
        }
        SignalingManager.getInstance().reject(str, str2, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void removeSignalingListener(V2TIMSignalingListener v2TIMSignalingListener) {
        synchronized (this) {
            this.mSignalingListenerList.remove(v2TIMSignalingListener);
            if (this.mSignalingListenerList.size() == 0) {
                this.mHasValidSignalingListener = false;
            }
            checkSignalingListener();
        }
    }

    public void unInit() {
        synchronized (this) {
            this.mSignalingListenerList.clear();
            this.mHasValidSignalingListener = false;
        }
    }

    private V2TIMSignalingManagerImpl() {
        this.TAG = "V2TIMSigMgrImpl";
        this.mHasValidSignalingListener = false;
        this.mSignalingListenerList = new CopyOnWriteArrayList<>();
        initSignalingListener();
    }
}
