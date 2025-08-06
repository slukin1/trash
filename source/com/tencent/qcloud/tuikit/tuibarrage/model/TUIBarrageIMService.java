package com.tencent.qcloud.tuikit.tuibarrage.model;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.qcloud.tuikit.tuibarrage.manager.IHbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.TUIBarrageCallBack;

public class TUIBarrageIMService {
    /* access modifiers changed from: private */
    public static final String TAG = "TUIBarrageIMService";
    private AdvanceListener mAdvanceListener;
    /* access modifiers changed from: private */
    public String mGroupId;
    /* access modifiers changed from: private */
    public IHbBarrageManager mPresenter;
    private V2TIMMessageManager messageManager;
    private V2TIMGroupListener onRecvGroupCustomMessageListener;

    public class AdvanceListener extends V2TIMAdvancedMsgListener {
        private AdvanceListener() {
        }

        public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
            super.onRecvNewMessage(v2TIMMessage);
            String groupID = v2TIMMessage.getGroupID();
            if (groupID != null && TextUtils.equals(TUIBarrageIMService.this.mGroupId, groupID)) {
                int elemType = v2TIMMessage.getElemType();
                if (elemType == 1) {
                    TUIBarrageMessage tUIBarrageMessage = new TUIBarrageMessage();
                    tUIBarrageMessage.message = v2TIMMessage.getTextElem().getText();
                    tUIBarrageMessage.sender = v2TIMMessage.getSender();
                    tUIBarrageMessage.sendTime = v2TIMMessage.getTimestamp();
                    tUIBarrageMessage.v2TIMMessage = v2TIMMessage;
                    if (TUIBarrageIMService.this.mPresenter != null) {
                        TUIBarrageIMService.this.mPresenter.receiveTextBarrage(tUIBarrageMessage);
                    }
                } else if (elemType == 2) {
                    String str = new String(v2TIMMessage.getCustomElem().getData());
                    if (TextUtils.isEmpty(str)) {
                        Log.d(TUIBarrageIMService.TAG, "onRecvGroupCustomMessage customData is empty");
                        return;
                    }
                    try {
                        TUIBarrageMessage tUIBarrageMessage2 = (TUIBarrageMessage) new Gson().fromJson(str, TUIBarrageMessage.class);
                        tUIBarrageMessage2.sender = v2TIMMessage.getSender();
                        tUIBarrageMessage2.sendTime = v2TIMMessage.getTimestamp();
                        tUIBarrageMessage2.v2TIMMessage = v2TIMMessage;
                        if (TUIBarrageIMService.this.mPresenter != null) {
                            TUIBarrageIMService.this.mPresenter.receiveCustomBarrage(tUIBarrageMessage2);
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        Log.e(TUIBarrageIMService.TAG, "protocol version is not match, ignore msg");
                    }
                }
            }
        }
    }

    public TUIBarrageIMService(IHbBarrageManager iHbBarrageManager) {
        initIMListener();
        this.mPresenter = iHbBarrageManager;
    }

    public static String getCusMsgJsonStr(TUIBarrageMessage tUIBarrageMessage) {
        if (tUIBarrageMessage == null) {
            return null;
        }
        return new Gson().toJson((Object) tUIBarrageMessage);
    }

    private void initIMListener() {
        this.messageManager = V2TIMManager.getMessageManager();
        if (this.mAdvanceListener == null) {
            this.mAdvanceListener = new AdvanceListener();
        }
        this.messageManager.addAdvancedMsgListener(this.mAdvanceListener);
        this.onRecvGroupCustomMessageListener = new V2TIMGroupListener() {
            public void onReceiveRESTCustomData(String str, byte[] bArr) {
                if (str != null && TextUtils.equals(TUIBarrageIMService.this.mGroupId, str)) {
                    String str2 = new String(bArr);
                    String access$200 = TUIBarrageIMService.TAG;
                    Log.d(access$200, "onReceiveRESTCustomData customData is " + str2);
                    if (TextUtils.isEmpty(str2)) {
                        Log.d(TUIBarrageIMService.TAG, "onReceiveRESTCustomData customData is empty");
                        return;
                    }
                    try {
                        TUIBarrageMessage tUIBarrageMessage = (TUIBarrageMessage) new Gson().fromJson(str2, TUIBarrageMessage.class);
                        if (TUIBarrageIMService.this.mPresenter != null) {
                            TUIBarrageIMService.this.mPresenter.receiveCustomBarrage(tUIBarrageMessage);
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        Log.e(TUIBarrageIMService.TAG, "protocol version is not match, ignore msg");
                    }
                }
            }
        };
        V2TIMManager.getInstance().addGroupListener(this.onRecvGroupCustomMessageListener);
    }

    private void sendAdvanceMessage(final TUIBarrageCallBack tUIBarrageCallBack, V2TIMMessage v2TIMMessage) {
        this.messageManager.sendMessage(v2TIMMessage, (String) null, this.mGroupId, 1, false, (V2TIMOfflinePushInfo) null, new V2TIMSendCallback<V2TIMMessage>() {
            public void onError(int i11, String str) {
                String access$200 = TUIBarrageIMService.TAG;
                Log.e(access$200, "sendGroupTextMessage error " + i11 + " errorMessage:" + str);
                TUIBarrageCallBack tUIBarrageCallBack = tUIBarrageCallBack;
                if (tUIBarrageCallBack != null) {
                    tUIBarrageCallBack.onFailed(i11, str);
                }
            }

            public void onProgress(int i11) {
            }

            public void onSuccess(V2TIMMessage v2TIMMessage) {
                TUIBarrageMessage tUIBarrageMessage = new TUIBarrageMessage();
                tUIBarrageMessage.message = v2TIMMessage.getTextElem().getText();
                tUIBarrageMessage.sender = v2TIMMessage.getSender();
                tUIBarrageMessage.sendTime = v2TIMMessage.getTimestamp();
                tUIBarrageMessage.v2TIMMessage = v2TIMMessage;
                TUIBarrageCallBack tUIBarrageCallBack = tUIBarrageCallBack;
                if (tUIBarrageCallBack != null) {
                    tUIBarrageCallBack.onTextCallback(0, tUIBarrageMessage);
                    Log.e(TUIBarrageIMService.TAG, "sendGroupTextMessage success");
                }
            }
        });
    }

    private void unInitImListener() {
        V2TIMManager.getInstance().setGroupListener((V2TIMGroupListener) null);
        this.messageManager.removeAdvancedMsgListener(this.mAdvanceListener);
    }

    public void sendCustomBarrage(TUIBarrageMessage tUIBarrageMessage, TUIBarrageCallBack tUIBarrageCallBack) {
        String cusMsgJsonStr = getCusMsgJsonStr(tUIBarrageMessage);
        if (TextUtils.isEmpty(cusMsgJsonStr)) {
            Log.d(TAG, "sendBarrage data is empty");
        } else {
            sendAdvanceMessage(tUIBarrageCallBack, this.messageManager.createCustomMessage(cusMsgJsonStr.getBytes()));
        }
    }

    public void sendTextBarrage(String str, TUIBarrageCallBack tUIBarrageCallBack) {
        String str2 = TAG;
        Log.d(str2, "sendBarrage: data = " + str + " , mGroupId = " + this.mGroupId);
        sendAdvanceMessage(tUIBarrageCallBack, this.messageManager.createTextMessage(str));
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }
}
