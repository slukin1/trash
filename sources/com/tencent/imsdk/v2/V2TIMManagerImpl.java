package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.tencent.android.tpush.XGServerInfo;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupApplication;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupListener;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.group.TopicInfo;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.CustomServerInfo;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.manager.SDKListener;
import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.GroupMessageReceipt;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageExtension;
import com.tencent.imsdk.message.MessageExtensionResult;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.offlinePush.OfflinePushConfig;
import com.tencent.imsdk.offlinePush.OfflinePushManager;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserStatus;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class V2TIMManagerImpl extends V2TIMManager {
    private static final String TAG = "V2TIMManagerImpl";
    private GroupListener mGroupInternalListener;
    /* access modifiers changed from: private */
    public final List<V2TIMGroupListener> mGroupListenerList = new ArrayList();
    /* access modifiers changed from: private */
    public V2TIMSDKListener mIMSDKListener;
    /* access modifiers changed from: private */
    public final List<V2TIMSDKListener> mIMSDKListenerList = new ArrayList();
    /* access modifiers changed from: private */
    public Object mLockObject = new Object();
    private MessageListener mMessageInternalListener;
    /* access modifiers changed from: private */
    public V2TIMGroupListener mV2TIMGroupListener;
    /* access modifiers changed from: private */
    public List<V2TIMSimpleMsgListener> mV2TIMSimpleMsgListenerList = new CopyOnWriteArrayList();

    public static class V2TIMManagerImplHolder {
        /* access modifiers changed from: private */
        public static final V2TIMManagerImpl v2TIMManagerImpl = new V2TIMManagerImpl();

        private V2TIMManagerImplHolder() {
        }
    }

    public V2TIMManagerImpl() {
        initMessageListener();
        initGroupListener();
        V2TIMMessageManagerImpl.getInstance().initListener();
    }

    private void callbackOnError(V2TIMValueCallback<Object> v2TIMValueCallback, int i11, String str) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(i11, str);
        }
    }

    private void callbackOnSuccess(V2TIMValueCallback<Object> v2TIMValueCallback, Object obj) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onSuccess(obj);
        }
    }

    private void clearLocalHistoryMessage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            MessageCenter.getInstance().clearLocalHistoryMessage(V2TIMConversationManagerImpl.getInstance().getConversationKey(jSONObject.optString(TUIConstants.TUIChat.CONVERSATION_ID)), jSONObject.optLong("beginTimestamp"), jSONObject.optLong("endTimestamp"), new IMCallback(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
            callbackOnSuccess(v2TIMValueCallback, (Object) null);
        } catch (JSONException e11) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
            e11.printStackTrace();
        }
    }

    private void getAIDenoiseSignature(V2TIMValueCallback<Object> v2TIMValueCallback) {
        BaseManager.getInstance().getAIDenoiseSignature(new IMCallback(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public static V2TIMManagerImpl getInstance() {
        return V2TIMManagerImplHolder.v2TIMManagerImpl;
    }

    private void getMessageExtensionsBySequence(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        String str2 = "";
        long j11 = 0;
        new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString(InnerShareParams.GROPU_ID);
            j11 = jSONObject.optLong("messageSequence");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        AnonymousClass29 r62 = new V2TIMValueCallback<List<MessageExtension>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<MessageExtension> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (MessageExtension messageExtension : list) {
                        V2TIMMessageExtension v2TIMMessageExtension = new V2TIMMessageExtension();
                        v2TIMMessageExtension.setMessageExtension(messageExtension);
                        arrayList.add(v2TIMMessageExtension);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        };
        Message message = new Message();
        message.setMessageStatus(2);
        message.setSupportMessageExtension(true);
        message.addElement(new TextElement());
        message.setMessageType(2);
        message.setGroupID(str2);
        message.setSeq(j11);
        MessageCenter.getInstance().getMessageExtensions(message, new IMCallback<List<MessageExtension>>(r62) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<MessageExtension> list) {
                super.success(list);
            }
        });
    }

    private void getMessageRevoker(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof List)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not list");
            return;
        }
        List list = (List) obj;
        Iterator it2 = list.iterator();
        if (!it2.hasNext() || (it2.next() instanceof String)) {
            MessageCenter.getInstance().findMessageByMessageId(list, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<Message> list) {
                    if (list.size() == 0) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "local messages do not exist");
                        }
                    } else if (v2TIMValueCallback != null) {
                        HashMap hashMap = new HashMap();
                        for (Message next : list) {
                            hashMap.put(next.getMsgID(), next.getRevokerUserID());
                        }
                        v2TIMValueCallback.onSuccess(hashMap);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<Message> list) {
                    super.success(list);
                }
            });
            return;
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "item is no String type");
    }

    private void getOfflinePushState(V2TIMValueCallback<Object> v2TIMValueCallback) {
        OfflinePushManager.getInstance().getOfflinePushConfig(new IMCallback(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                final int openOfflinePush = ((OfflinePushConfig) obj).getOpenOfflinePush();
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        if (AnonymousClass37.this.valueCallback != null) {
                            AnonymousClass37.this.valueCallback.onSuccess(Integer.valueOf(openOfflinePush));
                        }
                    }
                });
            }
        });
    }

    private void initGroupListener() {
        this.mGroupInternalListener = new GroupListener() {
            public V2TIMGroupMemberInfo convertToV2GroupMemberInfo(GroupMemberInfo groupMemberInfo) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                if (groupMemberInfo != null) {
                    v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                }
                return v2TIMGroupMemberInfo;
            }

            public List<V2TIMGroupMemberInfo> convertToV2GroupMemberInfoList(List<GroupMemberInfo> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMemberInfo convertToV2GroupMemberInfo : list) {
                    arrayList.add(convertToV2GroupMemberInfo(convertToV2GroupMemberInfo));
                }
                return arrayList;
            }

            public void onApplicationProcessed(String str, GroupMemberInfo groupMemberInfo, boolean z11, String str2) {
                for (V2TIMGroupListener onApplicationProcessed : V2TIMManagerImpl.this.mGroupListenerList) {
                    onApplicationProcessed.onApplicationProcessed(str, convertToV2GroupMemberInfo(groupMemberInfo), z11, str2);
                }
            }

            public void onGrantAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener onGrantAdministrator : V2TIMManagerImpl.this.mGroupListenerList) {
                    onGrantAdministrator.onGrantAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            public void onGroupAttributeChanged(String str, Map<String, String> map) {
                Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
                for (V2TIMGroupListener onGroupAttributeChanged : V2TIMManagerImpl.this.mGroupListenerList) {
                    onGroupAttributeChanged.onGroupAttributeChanged(str, unmodifiableMap);
                }
            }

            public void onGroupCounterChanged(String str, Map<String, Long> map) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    for (Map.Entry next : map.entrySet()) {
                        v2TIMGroupListener.onGroupCounterChanged(str, (String) next.getKey(), ((Long) next.getValue()).longValue());
                    }
                }
            }

            public void onGroupCounterDeleted(String str, List<String> list) {
            }

            public void onGroupCreated(String str) {
                for (V2TIMGroupListener onGroupCreated : V2TIMManagerImpl.this.mGroupListenerList) {
                    onGroupCreated.onGroupCreated(str);
                }
            }

            public void onGroupDismissed(String str, GroupMemberInfo groupMemberInfo) {
                for (V2TIMGroupListener onGroupDismissed : V2TIMManagerImpl.this.mGroupListenerList) {
                    onGroupDismissed.onGroupDismissed(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            public void onGroupInfoChanged(String str, List<GroupInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupInfoChangeItem groupInfoChangeItem : list) {
                    V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
                    v2TIMGroupChangeInfo.setGroupInfoChangeItem(groupInfoChangeItem);
                    arrayList.add(v2TIMGroupChangeInfo);
                }
                List unmodifiableList = Collections.unmodifiableList(arrayList);
                for (V2TIMGroupListener onGroupInfoChanged : V2TIMManagerImpl.this.mGroupListenerList) {
                    onGroupInfoChanged.onGroupInfoChanged(str, unmodifiableList);
                }
            }

            public void onGroupRecycled(String str, GroupMemberInfo groupMemberInfo) {
                for (V2TIMGroupListener onGroupRecycled : V2TIMManagerImpl.this.mGroupListenerList) {
                    onGroupRecycled.onGroupRecycled(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            public void onMemberEnter(String str, List<GroupMemberInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener onMemberEnter : V2TIMManagerImpl.this.mGroupListenerList) {
                    onMemberEnter.onMemberEnter(str, unmodifiableList);
                }
            }

            public void onMemberInfoChanged(String str, List<GroupMemberInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMemberInfoChangeItem groupMemberInfoChangeItem : list) {
                    V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
                    v2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(groupMemberInfoChangeItem);
                    arrayList.add(v2TIMGroupMemberChangeInfo);
                }
                List unmodifiableList = Collections.unmodifiableList(arrayList);
                for (V2TIMGroupListener onMemberInfoChanged : V2TIMManagerImpl.this.mGroupListenerList) {
                    onMemberInfoChanged.onMemberInfoChanged(str, unmodifiableList);
                }
            }

            public void onMemberInvited(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener onMemberInvited : V2TIMManagerImpl.this.mGroupListenerList) {
                    onMemberInvited.onMemberInvited(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            public void onMemberKicked(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener onMemberKicked : V2TIMManagerImpl.this.mGroupListenerList) {
                    onMemberKicked.onMemberKicked(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            public void onMemberLeave(String str, GroupMemberInfo groupMemberInfo) {
                for (V2TIMGroupListener onMemberLeave : V2TIMManagerImpl.this.mGroupListenerList) {
                    onMemberLeave.onMemberLeave(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            public void onQuitFromGroup(String str) {
                for (V2TIMGroupListener onQuitFromGroup : V2TIMManagerImpl.this.mGroupListenerList) {
                    onQuitFromGroup.onQuitFromGroup(str);
                }
            }

            public void onReceiveInviteApplication(String str, int i11, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list, String str2) {
                if (GroupApplication.REQUEST_TYPE_INVITE_TO_ADMIN == i11) {
                    for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                        for (GroupMemberInfo convertToV2GroupMemberInfo : list) {
                            v2TIMGroupListener.onReceiveJoinApplication(str, convertToV2GroupMemberInfo(convertToV2GroupMemberInfo), str2);
                        }
                    }
                }
            }

            public void onReceiveJoinApplication(String str, GroupMemberInfo groupMemberInfo, String str2) {
                for (V2TIMGroupListener onReceiveJoinApplication : V2TIMManagerImpl.this.mGroupListenerList) {
                    onReceiveJoinApplication.onReceiveJoinApplication(str, convertToV2GroupMemberInfo(groupMemberInfo), str2);
                }
            }

            public void onReceiveRESTCustomData(String str, byte[] bArr) {
                for (V2TIMGroupListener onReceiveRESTCustomData : V2TIMManagerImpl.this.mGroupListenerList) {
                    onReceiveRESTCustomData.onReceiveRESTCustomData(str, (byte[]) bArr.clone());
                }
            }

            public void onRevokeAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                for (V2TIMGroupListener onRevokeAdministrator : V2TIMManagerImpl.this.mGroupListenerList) {
                    onRevokeAdministrator.onRevokeAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            public void onTopicCreated(String str, String str2) {
                for (V2TIMGroupListener onTopicCreated : V2TIMManagerImpl.this.mGroupListenerList) {
                    onTopicCreated.onTopicCreated(str, str2);
                }
            }

            public void onTopicDeleted(String str, List<String> list) {
                for (V2TIMGroupListener onTopicDeleted : V2TIMManagerImpl.this.mGroupListenerList) {
                    onTopicDeleted.onTopicDeleted(str, list);
                }
            }

            public void onTopicInfoChanged(String str, TopicInfo topicInfo) {
                V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
                v2TIMTopicInfo.setTopicInfo(topicInfo);
                for (V2TIMGroupListener onTopicInfoChanged : V2TIMManagerImpl.this.mGroupListenerList) {
                    onTopicInfoChanged.onTopicInfoChanged(str, v2TIMTopicInfo);
                }
            }
        };
        GroupManager.getInstance().setGroupListener(this.mGroupInternalListener);
    }

    private void initLocalStorage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid userID");
        } else {
            BaseManager.getInstance().initLocalStorage(str, new IMCallback(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    private void initMessageListener() {
        this.mMessageInternalListener = new MessageListener() {
            public void onReceiveC2CMessageReceipt(List<C2CMessageReceipt> list) {
            }

            public void onReceiveGroupMessageReceipt(List<GroupMessageReceipt> list) {
            }

            public void onReceiveMessageModified(List<Message> list) {
            }

            public void onReceiveMessageRevoked(List<MessageKey> list) {
            }

            public void onReceiveNewMessage(List<Message> list) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo;
                if (list != null && !list.isEmpty()) {
                    for (Message next : list) {
                        int messageType = next.getMessageType();
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(next);
                        int elemType = v2TIMMessage.getElemType();
                        V2TIMUserInfo v2TIMUserInfo = null;
                        if (messageType == Message.MESSAGE_TYPE_C2C) {
                            V2TIMUserInfo v2TIMUserInfo2 = new V2TIMUserInfo();
                            v2TIMUserInfo2.setUserID(v2TIMMessage.getSender());
                            v2TIMUserInfo2.setNickName(v2TIMMessage.getNickName());
                            v2TIMUserInfo2.setFaceUrl(v2TIMMessage.getFaceUrl());
                            v2TIMUserInfo = v2TIMUserInfo2;
                            v2TIMGroupMemberInfo = null;
                        } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                            v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                            GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                            groupMemberInfo.setGroupID(next.getGroupID());
                            groupMemberInfo.setUserID(next.getSenderUserID());
                            groupMemberInfo.setNickname(next.getNickName());
                            groupMemberInfo.setNameCard(next.getNameCard());
                            groupMemberInfo.setFaceUrl(next.getFaceUrl());
                            groupMemberInfo.setFriendRemark(next.getFriendRemark());
                            v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                        } else {
                            v2TIMGroupMemberInfo = null;
                        }
                        if (elemType == 1) {
                            V2TIMTextElem textElem = v2TIMMessage.getTextElem();
                            synchronized (V2TIMManagerImpl.this.mLockObject) {
                                for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                    if (messageType == Message.MESSAGE_TYPE_C2C) {
                                        v2TIMSimpleMsgListener.onRecvC2CTextMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, textElem.getText());
                                    } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                        v2TIMSimpleMsgListener.onRecvGroupTextMessage(v2TIMMessage.getMsgID(), next.getGroupID(), v2TIMGroupMemberInfo, textElem.getText());
                                    }
                                }
                            }
                        } else if (elemType == 2) {
                            V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
                            synchronized (V2TIMManagerImpl.this.mLockObject) {
                                for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener2 : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                    if (messageType == Message.MESSAGE_TYPE_C2C) {
                                        v2TIMSimpleMsgListener2.onRecvC2CCustomMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, customElem.getData());
                                    } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                        v2TIMSimpleMsgListener2.onRecvGroupCustomMessage(v2TIMMessage.getMsgID(), v2TIMMessage.getGroupID(), v2TIMGroupMemberInfo, customElem.getData());
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageInternalListener);
    }

    private void isCommercialAbilityEnabled(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof Long)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not int");
        } else {
            BaseManager.getInstance().isCommercialAbilityEnabled(((Long) obj).longValue(), new IMCallback<Object>(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    private void sendTRTCCustomData(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof byte[])) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not byte array");
            return;
        }
        BaseManager.getInstance().sendTRTCCustomData((byte[]) obj, new IMCallback(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private void setBuildInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("buildBrand");
            String optString2 = jSONObject.optString("buildManufacturer");
            String optString3 = jSONObject.optString("buildModel");
            String optString4 = jSONObject.optString("buildVersionRelease");
            int optInt = jSONObject.optInt("buildVersionSDKInt");
            SystemUtil.setBuildBrand(optString);
            SystemUtil.setBuildManufacturer(optString2);
            SystemUtil.setBuildModel(optString3);
            SystemUtil.setBuildVersionRelease(optString4);
            SystemUtil.setBuildVersionSDKInt(optInt);
            callbackOnSuccess(v2TIMValueCallback, (Object) null);
        } catch (JSONException e11) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
            e11.printStackTrace();
        }
    }

    private void setCosSaveRegion(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(TUIConstants.TUIChat.CONVERSATION_ID);
            String optString2 = jSONObject.optString("cosSaveRegion");
            if (!TextUtils.isEmpty(optString)) {
                if (!TextUtils.isEmpty(optString2)) {
                    ConversationManager.getInstance().setCosSaveRegionForConversation(V2TIMConversationManagerImpl.getInstance().getConversationKey(optString), optString2, new IMCallback(v2TIMValueCallback) {
                        public void fail(int i11, String str) {
                            super.fail(i11, str);
                        }

                        public void success(Object obj) {
                            super.success(obj);
                        }
                    });
                    return;
                }
            }
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    private void setCustomServerInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        CustomServerInfo customServerInfo = new CustomServerInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("longconnectionAddressList");
            if (optJSONArray != null) {
                if (optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                        CustomServerInfo.ServerAddress serverAddress = new CustomServerInfo.ServerAddress();
                        serverAddress.f70349ip = jSONObject2.optString("ip");
                        serverAddress.port = jSONObject2.optInt(XGServerInfo.TAG_PORT);
                        serverAddress.isIPv6 = jSONObject2.has("isIPv6") ? jSONObject2.optBoolean("isIPv6") : false;
                        serverAddress.isQuic = jSONObject2.has("isQuic") ? jSONObject2.optBoolean("isQuic") : false;
                        arrayList.add(serverAddress);
                    }
                    customServerInfo.longconnectionAddressList = arrayList;
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shortconnectionAddressList");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i12);
                    CustomServerInfo.ServerAddress serverAddress2 = new CustomServerInfo.ServerAddress();
                    serverAddress2.f70349ip = jSONObject3.optString("ip");
                    serverAddress2.port = jSONObject3.optInt(XGServerInfo.TAG_PORT);
                    serverAddress2.isIPv6 = jSONObject3.has("isIPv6") ? jSONObject3.optBoolean("isIPv6") : false;
                    arrayList2.add(serverAddress2);
                }
                customServerInfo.shortconnectionAddressList = arrayList2;
            }
            customServerInfo.serverPublicKey = jSONObject.optString("serverPublicKey");
            BaseManager.getInstance().setCustomServerInfo(customServerInfo);
            callbackOnSuccess(v2TIMValueCallback, (Object) null);
        } catch (JSONException e11) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
            e11.printStackTrace();
        }
    }

    private void setDatabaseEncryptInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("encryptType")) {
                if (jSONObject.has("encryptKey")) {
                    SDKConfig.DatabaseEncryptInfo databaseEncryptInfo = new SDKConfig.DatabaseEncryptInfo();
                    databaseEncryptInfo.encryptType = jSONObject.optInt("encryptType");
                    databaseEncryptInfo.encryptKey = jSONObject.optString("encryptKey");
                    BaseManager.getInstance().setDatabaseEncryptInfo(databaseEncryptInfo);
                    callbackOnSuccess(v2TIMValueCallback, (Object) null);
                    return;
                }
            }
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "encryptType and encryptKey must be set");
        } catch (JSONException e11) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
            e11.printStackTrace();
        }
    }

    private void setIPv6Prior(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setIPv6Prior(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, (Object) null);
    }

    private void setLibraryPath(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        if (BaseManager.getInstance().setLibraryPath((String) obj)) {
            callbackOnSuccess(v2TIMValueCallback, (Object) null);
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "system load so library failed");
        }
    }

    private void setMessageExtensionsBySequence(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        String str2 = "";
        long j11 = 0;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString(InnerShareParams.GROPU_ID);
            j11 = jSONObject.optLong("messageSequence");
            JSONArray optJSONArray = jSONObject.optJSONArray("messageExtensionList");
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                MessageExtension messageExtension = new MessageExtension();
                messageExtension.setExtensionKey(jSONObject2.optString("extensionKey"));
                messageExtension.setExtensionValue(jSONObject2.optString("extensionValue"));
                arrayList.add(messageExtension);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        AnonymousClass27 r92 = new V2TIMValueCallback<List<MessageExtensionResult>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<MessageExtensionResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (MessageExtensionResult messageExtensionResult : list) {
                        V2TIMMessageExtensionResult v2TIMMessageExtensionResult = new V2TIMMessageExtensionResult();
                        v2TIMMessageExtensionResult.setMessageExtensionResult(messageExtensionResult);
                        arrayList.add(v2TIMMessageExtensionResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        };
        Message message = new Message();
        message.setMessageStatus(2);
        message.setSupportMessageExtension(true);
        message.addElement(new TextElement());
        message.setMessageType(2);
        message.setGroupID(str2);
        message.setSeq(j11);
        MessageCenter.getInstance().setMessageExtensions(message, arrayList, new IMCallback<List<MessageExtensionResult>>(r92) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<MessageExtensionResult> list) {
                super.success(list);
            }
        });
    }

    private void setOfflinePushState(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof Integer)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not int");
            return;
        }
        OfflinePushConfig offlinePushConfig = new OfflinePushConfig();
        offlinePushConfig.setOpenOfflinePush(((Integer) obj).intValue());
        OfflinePushManager.getInstance().setOfflinePushConfig(offlinePushConfig, new IMCallback(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private void setPacketRetryInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            SDKConfig.PacketRetryInfo packetRetryInfo = new SDKConfig.PacketRetryInfo();
            if (jSONObject.has("maxRetryCount")) {
                packetRetryInfo.maxRetryCount = jSONObject.optInt("maxRetryCount");
            }
            if (jSONObject.has("packetRequestTimeout")) {
                packetRetryInfo.packetRequestTimeout = jSONObject.optInt("packetRequestTimeout");
            }
            BaseManager.getInstance().setPacketRetryInfo(packetRetryInfo);
            callbackOnSuccess(v2TIMValueCallback, (Object) null);
        } catch (JSONException e11) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
            e11.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r5.has("proxyPort") != false) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setProxyInfo(java.lang.Object r8, com.tencent.imsdk.v2.V2TIMValueCallback<java.lang.Object> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "proxyPassword"
            java.lang.String r1 = "proxyUsername"
            java.lang.String r2 = "proxyType"
            java.lang.String r3 = "proxyHost"
            r4 = 6017(0x1781, float:8.432E-42)
            if (r8 == 0) goto L_0x00a2
            boolean r5 = r8 instanceof java.lang.String
            if (r5 != 0) goto L_0x0012
            goto L_0x00a2
        L_0x0012:
            java.lang.String r8 = (java.lang.String) r8
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 == 0) goto L_0x0020
            java.lang.String r8 = "param is empty"
            r7.callbackOnError(r9, r4, r8)
            return
        L_0x0020:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0098 }
            r5.<init>(r8)     // Catch:{ JSONException -> 0x0098 }
            boolean r8 = r5.has(r2)     // Catch:{ JSONException -> 0x0098 }
            if (r8 != 0) goto L_0x0031
            java.lang.String r8 = "proxyType must be set"
            r7.callbackOnError(r9, r4, r8)     // Catch:{ JSONException -> 0x0098 }
            return
        L_0x0031:
            boolean r8 = r5.has(r3)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r6 = "proxyPort"
            if (r8 == 0) goto L_0x003f
            boolean r8 = r5.has(r6)     // Catch:{ JSONException -> 0x0098 }
            if (r8 == 0) goto L_0x004b
        L_0x003f:
            boolean r8 = r5.has(r3)     // Catch:{ JSONException -> 0x0098 }
            if (r8 != 0) goto L_0x0051
            boolean r8 = r5.has(r6)     // Catch:{ JSONException -> 0x0098 }
            if (r8 == 0) goto L_0x0051
        L_0x004b:
            java.lang.String r8 = "proxyHost and proxyPort must be set together if need"
            r7.callbackOnError(r9, r4, r8)     // Catch:{ JSONException -> 0x0098 }
            return
        L_0x0051:
            com.tencent.imsdk.manager.SDKConfig$ProxyInfo r8 = new com.tencent.imsdk.manager.SDKConfig$ProxyInfo     // Catch:{ JSONException -> 0x0098 }
            r8.<init>()     // Catch:{ JSONException -> 0x0098 }
            int r2 = r5.optInt(r2)     // Catch:{ JSONException -> 0x0098 }
            r8.proxyType = r2     // Catch:{ JSONException -> 0x0098 }
            boolean r2 = r5.has(r3)     // Catch:{ JSONException -> 0x0098 }
            if (r2 == 0) goto L_0x0074
            boolean r2 = r5.has(r6)     // Catch:{ JSONException -> 0x0098 }
            if (r2 == 0) goto L_0x0074
            java.lang.String r2 = r5.optString(r3)     // Catch:{ JSONException -> 0x0098 }
            r8.proxyHost = r2     // Catch:{ JSONException -> 0x0098 }
            int r2 = r5.optInt(r6)     // Catch:{ JSONException -> 0x0098 }
            r8.proxyPort = r2     // Catch:{ JSONException -> 0x0098 }
        L_0x0074:
            boolean r2 = r5.has(r1)     // Catch:{ JSONException -> 0x0098 }
            if (r2 == 0) goto L_0x0080
            java.lang.String r1 = r5.optString(r1)     // Catch:{ JSONException -> 0x0098 }
            r8.proxyUsername = r1     // Catch:{ JSONException -> 0x0098 }
        L_0x0080:
            boolean r1 = r5.has(r0)     // Catch:{ JSONException -> 0x0098 }
            if (r1 == 0) goto L_0x008c
            java.lang.String r0 = r5.optString(r0)     // Catch:{ JSONException -> 0x0098 }
            r8.proxyPassword = r0     // Catch:{ JSONException -> 0x0098 }
        L_0x008c:
            com.tencent.imsdk.manager.BaseManager r0 = com.tencent.imsdk.manager.BaseManager.getInstance()     // Catch:{ JSONException -> 0x0098 }
            r0.setProxyInfo(r8)     // Catch:{ JSONException -> 0x0098 }
            r8 = 0
            r7.callbackOnSuccess(r9, r8)     // Catch:{ JSONException -> 0x0098 }
            goto L_0x00a1
        L_0x0098:
            r8 = move-exception
            java.lang.String r0 = "convert param to json failed"
            r7.callbackOnError(r9, r4, r0)
            r8.printStackTrace()
        L_0x00a1:
            return
        L_0x00a2:
            java.lang.String r8 = "param is not string"
            r7.callbackOnError(r9, r4, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.v2.V2TIMManagerImpl.setProxyInfo(java.lang.Object, com.tencent.imsdk.v2.V2TIMValueCallback):void");
    }

    private void setQuicChannelInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        try {
            BaseManager.getInstance().setForceUseQuicChannel(new JSONObject(str).optBoolean("forceUseQuicChannel"));
            callbackOnSuccess(v2TIMValueCallback, (Object) null);
        } catch (JSONException e11) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
            e11.printStackTrace();
        }
    }

    private void setSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.remove(V2TIMManagerImpl.this.mIMSDKListener);
                }
                if (v2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
                }
                V2TIMSDKListener unused = V2TIMManagerImpl.this.mIMSDKListener = v2TIMSDKListener;
            }
        });
    }

    private void setTestEnvironment(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setTestEnvironment(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, (Object) null);
    }

    private void setUIPlatform(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is null");
            return;
        }
        int i11 = 0;
        String str = "";
        if (obj instanceof String) {
            str = (String) obj;
        } else if (obj instanceof Integer) {
            i11 = ((Integer) obj).intValue();
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is invalid");
        }
        BaseManager.getInstance().setCustomUIPlatform(str, i11);
        callbackOnSuccess(v2TIMValueCallback, (Object) null);
    }

    private void writeLog(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("logLevel");
            String optString = jSONObject.optString("logContent");
            String optString2 = jSONObject.optString("fileName");
            if (optInt == 2) {
                IMLog.v(optString2, optString);
            } else if (optInt == 3) {
                IMLog.d(optString2, optString);
            } else if (optInt == 4) {
                IMLog.i(optString2, optString);
            } else if (optInt == 5) {
                IMLog.w(optString2, optString);
            } else if (optInt != 6) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid logLevel");
                return;
            } else {
                IMLog.e(optString2, optString);
            }
            callbackOnSuccess(v2TIMValueCallback, (Object) null);
        } catch (JSONException e11) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
            e11.printStackTrace();
        }
    }

    public void addGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    if (!V2TIMManagerImpl.this.mGroupListenerList.contains(v2TIMGroupListener)) {
                        V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
                    }
                }
            });
        }
    }

    public void addIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    if (!V2TIMManagerImpl.this.mIMSDKListenerList.contains(v2TIMSDKListener)) {
                        V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
                    }
                }
            });
        }
    }

    public void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener != null) {
            synchronized (this.mLockObject) {
                if (!this.mV2TIMSimpleMsgListenerList.contains(v2TIMSimpleMsgListener)) {
                    this.mV2TIMSimpleMsgListenerList.add(v2TIMSimpleMsgListener);
                }
            }
        }
    }

    public void callExperimentalAPI(String str, Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid api");
        } else if (str.equals("setCustomServerInfo")) {
            setCustomServerInfo(obj, v2TIMValueCallback);
        } else if (str.equals("setQuicChannelInfo")) {
            setQuicChannelInfo(obj, v2TIMValueCallback);
        } else if (str.equals("setProxyInfo")) {
            setProxyInfo(obj, v2TIMValueCallback);
        } else if (str.equals("setLibraryPath")) {
            setLibraryPath(obj, v2TIMValueCallback);
        } else if (str.equals("initLocalStorage")) {
            initLocalStorage(obj, v2TIMValueCallback);
        } else if (str.equals("setTestEnvironment")) {
            setTestEnvironment(obj, v2TIMValueCallback);
        } else if (str.equals("setIPv6Prior")) {
            setIPv6Prior(obj, v2TIMValueCallback);
        } else if (str.equals("setCosSaveRegionForConversation")) {
            setCosSaveRegion(obj, v2TIMValueCallback);
        } else if (str.equals("setUIPlatform")) {
            setUIPlatform(obj, v2TIMValueCallback);
        } else if (str.equals("setBuildInfo")) {
            setBuildInfo(obj, v2TIMValueCallback);
        } else if (str.equals("setDatabaseEncryptInfo")) {
            setDatabaseEncryptInfo(obj, v2TIMValueCallback);
        } else if (str.equals("isCommercialAbilityEnabled")) {
            isCommercialAbilityEnabled(obj, v2TIMValueCallback);
        } else if (str.equals("setPacketRetryInfo")) {
            setPacketRetryInfo(obj, v2TIMValueCallback);
        } else if (str.equals("setOfflinePushState")) {
            setOfflinePushState(obj, v2TIMValueCallback);
        } else if (str.equals("getOfflinePushState")) {
            getOfflinePushState(v2TIMValueCallback);
        } else if (str.equals("getMessageRevoker")) {
            getMessageRevoker(obj, v2TIMValueCallback);
        } else if (str.equals("writeLog")) {
            writeLog(obj, v2TIMValueCallback);
        } else if (str.equals("getAIDenoiseSignature")) {
            getAIDenoiseSignature(v2TIMValueCallback);
        } else if (str.equals("sendTRTCCustomData")) {
            sendTRTCCustomData(obj, v2TIMValueCallback);
        } else if (str.equals("setMessageExtensionsBySequence")) {
            setMessageExtensionsBySequence(obj, v2TIMValueCallback);
        } else if (str.equals("getMessageExtensionsBySequence")) {
            getMessageExtensionsBySequence(obj, v2TIMValueCallback);
        } else if (str.equals("clearLocalHistoryMessage")) {
            clearLocalHistoryMessage(obj, v2TIMValueCallback);
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "unsupported api");
        }
    }

    public void createGroup(String str, String str2, String str3, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupType is empty");
            }
        } else if (!TextUtils.isEmpty(str3)) {
            if (!str.equalsIgnoreCase("Work")) {
                if (!str.equalsIgnoreCase("Meeting")) {
                    if (!str.equalsIgnoreCase("Private")) {
                        if (!str.equalsIgnoreCase("ChatRoom")) {
                            if (str.equalsIgnoreCase("Public")) {
                                str = "Public";
                            } else if (str.equalsIgnoreCase("AVChatRoom")) {
                                str = "AVChatRoom";
                            }
                            GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) {
                                public void fail(int i11, String str) {
                                    super.fail(i11, str);
                                }

                                public void success(String str) {
                                    super.success(str);
                                }
                            });
                        }
                    }
                }
                str = "ChatRoom";
                GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) {
                    public void fail(int i11, String str) {
                        super.fail(i11, str);
                    }

                    public void success(String str) {
                        super.success(str);
                    }
                });
            }
            str = "Private";
            GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(String str) {
                    super.success(str);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
        }
    }

    public void dismissGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().dismissGroup(str, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    public int getLoginStatus() {
        return BaseManager.getInstance().getLoginStatus();
    }

    public String getLoginUser() {
        return BaseManager.getInstance().getLoginUser();
    }

    public long getServerTime() {
        return BaseManager.getInstance().getServerTime();
    }

    public void getUserStatus(List<String> list, final V2TIMValueCallback<List<V2TIMUserStatus>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUserStatus(list, new IMCallback<List<UserStatus>>(new V2TIMValueCallback<List<UserStatus>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<UserStatus> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserStatus userStatus : list) {
                            V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
                            v2TIMUserStatus.setUserStatus(userStatus);
                            arrayList.add(v2TIMUserStatus);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<UserStatus> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    public void getUsersInfo(List<String> list, final V2TIMValueCallback<List<V2TIMUserFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUsersInfo(list, new IMCallback<List<UserInfo>>(new V2TIMValueCallback<List<UserInfo>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<UserInfo> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserInfo userInfo : list) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            arrayList.add(v2TIMUserFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<UserInfo> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    public String getVersion() {
        return BaseManager.getInstance().getVersion();
    }

    public boolean initSDK(Context context, int i11, V2TIMSDKConfig v2TIMSDKConfig) {
        return initSDK(context, i11, v2TIMSDKConfig, (V2TIMSDKListener) null);
    }

    public void joinGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().joinGroup(str, str2, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    public void login(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID or userSig is empty");
            return;
        }
        BaseManager.getInstance().login(str, str2, new IMCallback(new V2TIMCallback() {
            public void onError(int i11, String str) {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i11, str);
                }
            }

            public void onSuccess() {
                V2TIMCallback v2TIMCallback = v2TIMCallback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void logout(V2TIMCallback v2TIMCallback) {
        BaseManager.getInstance().logout(new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void quitGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().quitGroup(str, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    public void removeGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    V2TIMManagerImpl.this.mGroupListenerList.remove(v2TIMGroupListener);
                }
            });
        }
    }

    public void removeIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    V2TIMManagerImpl.this.mIMSDKListenerList.remove(v2TIMSDKListener);
                }
            });
        }
    }

    public void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener != null) {
            synchronized (this.mLockObject) {
                this.mV2TIMSimpleMsgListenerList.remove(v2TIMSimpleMsgListener);
            }
        }
    }

    public String sendC2CCustomMessage(byte[] bArr, String str, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "customData is null");
            }
            return null;
        } else if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return null;
        } else {
            V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
            V2TIMMessage v2TIMMessage = createCustomMessage;
            String str2 = str;
            V2TIMMessageManager.getInstance().sendMessage(v2TIMMessage, str2, (String) null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onProgress(int i11) {
                }

                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createCustomMessage.getMsgID();
        }
    }

    public String sendC2CTextMessage(String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "text is null");
            }
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userID is empty");
            }
            return null;
        } else {
            V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
            V2TIMMessage v2TIMMessage = createTextMessage;
            String str3 = str2;
            V2TIMMessageManager.getInstance().sendMessage(v2TIMMessage, str3, (String) null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onProgress(int i11) {
                }

                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createTextMessage.getMsgID();
        }
    }

    public String sendGroupCustomMessage(byte[] bArr, String str, int i11, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback == null) {
                return null;
            }
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "customData is null");
            return null;
        } else if (!TextUtils.isEmpty(str)) {
            V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
            V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, (String) null, str, (i11 != 0 && (i11 == 1 || i11 == 3)) ? i11 : 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onProgress(int i11) {
                }

                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createCustomMessage.getMsgID();
        } else if (v2TIMValueCallback == null) {
            return "";
        } else {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            return "";
        }
    }

    public String sendGroupTextMessage(String str, String str2, int i11, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback == null) {
                return null;
            }
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "text is null");
            return null;
        } else if (!TextUtils.isEmpty(str2)) {
            V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
            V2TIMMessageManager.getInstance().sendMessage(createTextMessage, (String) null, str2, (i11 != 0 && (i11 == 1 || i11 == 3)) ? i11 : 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onProgress(int i11) {
                }

                public void onSuccess(V2TIMMessage v2TIMMessage) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(v2TIMMessage);
                    }
                }
            });
            return createTextMessage.getMsgID();
        } else if (v2TIMValueCallback == null) {
            return "";
        } else {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            return "";
        }
    }

    public void setGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            public void run() {
                if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.remove(V2TIMManagerImpl.this.mV2TIMGroupListener);
                }
                if (v2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
                }
                V2TIMGroupListener unused = V2TIMManagerImpl.this.mV2TIMGroupListener = v2TIMGroupListener;
            }
        });
    }

    public void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserFullInfo != null) {
            HashMap<String, Object> modifyParams = v2TIMUserFullInfo.getModifyParams();
            if (modifyParams != null && !modifyParams.isEmpty()) {
                RelationshipManager.getInstance().setSelfInfo(v2TIMUserFullInfo.getModifyParams(), new IMCallback(v2TIMCallback) {
                    public void fail(int i11, String str) {
                        super.fail(i11, str);
                    }

                    public void success(Object obj) {
                        super.success(obj);
                    }
                });
            } else if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "no changed info");
            }
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid params");
        }
    }

    public void setSelfStatus(V2TIMUserStatus v2TIMUserStatus, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserStatus != null) {
            UserStatus userStatus = v2TIMUserStatus.getUserStatus();
            if (userStatus == null && v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "no userStatus");
            }
            RelationshipManager.getInstance().setSelfStatus(userStatus, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid params");
        }
    }

    public void subscribeUserStatus(List<String> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().subscribeUserStatus(list, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid userIDList");
        }
    }

    public void unInitSDK() {
        this.mIMSDKListener = null;
        BaseManager.getInstance().unInitSDK();
        V2TIMSignalingManagerImpl.getInstance().unInit();
    }

    public void unsubscribeUserStatus(List<String> list, V2TIMCallback v2TIMCallback) {
        RelationshipManager.getInstance().unsubscribeUserStatus(list, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public boolean initSDK(Context context, int i11, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKConfig == null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
        }
        final V2TIMLogListener logListener = v2TIMSDKConfig.getLogListener();
        boolean z11 = logListener != null;
        SDKConfig sDKConfig = new SDKConfig();
        sDKConfig.sdkAppId = (long) i11;
        sDKConfig.logSetting.logLevel = v2TIMSDKConfig.getLogLevel();
        setSDKListener(v2TIMSDKListener);
        return BaseManager.getInstance().initSDK(context, sDKConfig, z11, new SDKListener() {
            public void onConnectFailed(final int i11, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        for (V2TIMSDKListener onConnectFailed : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            onConnectFailed.onConnectFailed(i11, str);
                        }
                    }
                });
            }

            public void onConnectSuccess() {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        for (V2TIMSDKListener onConnectSuccess : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            onConnectSuccess.onConnectSuccess();
                        }
                    }
                });
            }

            public void onConnecting() {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        for (V2TIMSDKListener onConnecting : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            onConnecting.onConnecting();
                        }
                    }
                });
            }

            public void onKickedOffline() {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        for (V2TIMSDKListener onKickedOffline : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            onKickedOffline.onKickedOffline();
                        }
                    }
                });
            }

            public void onLog(final int i11, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        V2TIMLogListener v2TIMLogListener = logListener;
                        if (v2TIMLogListener != null) {
                            v2TIMLogListener.onLog(i11, str);
                        }
                    }
                });
            }

            public void onSelfInfoUpdated(final UserInfo userInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        for (V2TIMSDKListener onSelfInfoUpdated : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            onSelfInfoUpdated.onSelfInfoUpdated(v2TIMUserFullInfo);
                        }
                    }
                });
            }

            public void onUserSigExpired() {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        for (V2TIMSDKListener onUserSigExpired : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            onUserSigExpired.onUserSigExpired();
                        }
                    }
                });
            }

            public void onUserStatusChanged(final List<UserStatus> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() {
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            ArrayList arrayList = new ArrayList();
                            for (UserStatus userStatus : list) {
                                V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
                                v2TIMUserStatus.setUserStatus(userStatus);
                                arrayList.add(v2TIMUserStatus);
                            }
                            v2TIMSDKListener.onUserStatusChanged(arrayList);
                        }
                    }
                });
            }
        });
    }
}
