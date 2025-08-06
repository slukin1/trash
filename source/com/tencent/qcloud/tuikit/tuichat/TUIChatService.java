package com.tencent.qcloud.tuikit.tuichat;

import android.content.Context;
import android.text.TextUtils;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMFriendshipListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.TUIServiceCallback;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomEvaluationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomOrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.LocationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MessageTypingBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextAtMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CallingMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomEvaluationMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomLinkMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomOrderMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FaceMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ImageMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.LocationMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MergeMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ReplyMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.SoundMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.TextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.TipsMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.VideoMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender;
import com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import zy.b;

public class TUIChatService extends ServiceInitializer implements ITUIChatService {
    public static final String TAG = TUIChatService.class.getSimpleName();
    private static TUIChatConfigs chatConfig;
    private static TUIChatService instance;
    private final List<WeakReference<C2CChatEventListener>> c2CChatEventListenerList = new ArrayList();
    /* access modifiers changed from: private */
    public final List<WeakReference<NetworkConnectionListener>> connectListenerList = new ArrayList();
    private final Map<String, Class<? extends TUIMessageBean>> customMessageMap = new HashMap();
    private final List<WeakReference<GroupChatEventListener>> groupChatEventListenerList = new ArrayList();
    private RxDataStore<Preferences> mChatDataStore = null;
    private WeakReference<IBaseMessageSender> messageSender;
    private final Map<Integer, Class<? extends MessageBaseHolder>> messageViewHolderMap = new HashMap();
    private final Map<Class<? extends TUIMessageBean>, Integer> messageViewTypeMap = new HashMap();
    private final List<WeakReference<TotalUnreadCountListener>> unreadCountListenerList = new ArrayList();
    private int viewType = 0;

    private void addDefaultMessageType(Class<? extends TUIMessageBean> cls, Class<? extends MessageBaseHolder> cls2) {
        int i11 = this.viewType + 1;
        this.viewType = i11;
        this.messageViewTypeMap.put(cls, Integer.valueOf(i11));
        this.messageViewHolderMap.put(Integer.valueOf(this.viewType), cls2);
    }

    /* access modifiers changed from: private */
    public List<C2CChatEventListener> getC2CChatEventListenerList() {
        ArrayList arrayList = new ArrayList();
        ListIterator<WeakReference<C2CChatEventListener>> listIterator = this.c2CChatEventListenerList.listIterator();
        while (listIterator.hasNext()) {
            C2CChatEventListener c2CChatEventListener = (C2CChatEventListener) listIterator.next().get();
            if (c2CChatEventListener == null) {
                listIterator.remove();
            } else {
                arrayList.add(c2CChatEventListener);
            }
        }
        return arrayList;
    }

    public static TUIChatConfigs getChatConfig() {
        if (chatConfig == null) {
            chatConfig = TUIChatConfigs.getConfigs();
        }
        return chatConfig;
    }

    /* access modifiers changed from: private */
    public List<GroupChatEventListener> getGroupChatEventListenerList() {
        ArrayList arrayList = new ArrayList();
        ListIterator<WeakReference<GroupChatEventListener>> listIterator = this.groupChatEventListenerList.listIterator();
        while (listIterator.hasNext()) {
            GroupChatEventListener groupChatEventListener = (GroupChatEventListener) listIterator.next().get();
            if (groupChatEventListener == null) {
                listIterator.remove();
            } else {
                arrayList.add(groupChatEventListener);
            }
        }
        return arrayList;
    }

    public static TUIChatService getInstance() {
        return instance;
    }

    private IBaseMessageSender getMessageSender() {
        WeakReference<IBaseMessageSender> weakReference = this.messageSender;
        if (weakReference != null) {
            return (IBaseMessageSender) weakReference.get();
        }
        return null;
    }

    private Object getOrDefault(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r2 = r2.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T getOrDefault(java.util.Map r2, java.lang.Object r3, T r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0010
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0009
            goto L_0x0010
        L_0x0009:
            java.lang.Object r2 = r2.get(r3)
            if (r2 == 0) goto L_0x0010
            return r2
        L_0x0010:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.TUIChatService.getOrDefault(java.util.Map, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private List<TotalUnreadCountListener> getUnreadCountListenerList() {
        ArrayList arrayList = new ArrayList();
        ListIterator<WeakReference<TotalUnreadCountListener>> listIterator = this.unreadCountListenerList.listIterator();
        while (listIterator.hasNext()) {
            TotalUnreadCountListener totalUnreadCountListener = (TotalUnreadCountListener) listIterator.next().get();
            if (totalUnreadCountListener == null) {
                listIterator.remove();
            } else {
                arrayList.add(totalUnreadCountListener);
            }
        }
        return arrayList;
    }

    private void initDataStore() {
        if (this.mChatDataStore == null) {
            this.mChatDataStore = new RxPreferenceDataStoreBuilder(ServiceInitializer.getAppContext(), TUIChatConstants.DataStore.DATA_STORE_NAME).a();
        }
        DataStoreUtil.getInstance().setDataStore(this.mChatDataStore);
    }

    private void initDefaultMessageType() {
        Class<TextMessageHolder> cls = TextMessageHolder.class;
        addDefaultMessageType(FaceMessageBean.class, FaceMessageHolder.class);
        addDefaultMessageType(FileMessageBean.class, FileMessageHolder.class);
        addDefaultMessageType(ImageMessageBean.class, ImageMessageHolder.class);
        addDefaultMessageType(LocationMessageBean.class, LocationMessageHolder.class);
        addDefaultMessageType(MergeMessageBean.class, MergeMessageHolder.class);
        addDefaultMessageType(SoundMessageBean.class, SoundMessageHolder.class);
        addDefaultMessageType(TextAtMessageBean.class, cls);
        addDefaultMessageType(TextMessageBean.class, cls);
        addDefaultMessageType(TipsMessageBean.class, TipsMessageHolder.class);
        addDefaultMessageType(VideoMessageBean.class, VideoMessageHolder.class);
        addDefaultMessageType(ReplyMessageBean.class, ReplyMessageHolder.class);
        addDefaultMessageType(CallingMessageBean.class, CallingMessageHolder.class);
    }

    private void initEvent() {
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_INFO_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_EXIT_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_MEMBER_KICKED_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_DISMISS, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_JOIN_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_INVITED_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_RECYCLE, this);
        TUICore.registerEvent(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED, TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_CLEAR_MESSAGE, this);
        TUICore.registerEvent(TUIConstants.TUIContact.EVENT_USER, TUIConstants.TUIContact.EVENT_SUB_KEY_CLEAR_MESSAGE, this);
        TUICore.registerEvent(TUIConstants.TUIConversation.EVENT_UNREAD, TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, this);
        TUICore.registerEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, this);
        TUICore.registerEvent(TUIChatConstants.EVENT_KEY_OFFLINE_MESSAGE_PRIVATE_RING, TUIChatConstants.EVENT_SUB_KEY_OFFLINE_MESSAGE_PRIVATE_RING, this);
        TUICore.registerEvent(TUIConstants.TUITranslation.EVENT_KEY_TRANSLATION_EVENT, TUIConstants.TUITranslation.EVENT_SUB_KEY_TRANSLATION_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.Event.GroupApplication.KEY_GROUP_APPLICATION, TUIConstants.TUIGroup.Event.GroupApplication.SUB_KEY_GROUP_APPLICATION_NUM_CHANGED, this);
    }

    private void initIMListener() {
        V2TIMManager.getMessageManager().addAdvancedMsgListener(new V2TIMAdvancedMsgListener() {
            public void onRecvMessageModified(V2TIMMessage v2TIMMessage) {
                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
                if (parseMessage != null) {
                    for (C2CChatEventListener onRecvMessageModified : TUIChatService.getInstance().getC2CChatEventListenerList()) {
                        onRecvMessageModified.onRecvMessageModified(parseMessage);
                    }
                    for (GroupChatEventListener onRecvMessageModified2 : TUIChatService.getInstance().getGroupChatEventListenerList()) {
                        onRecvMessageModified2.onRecvMessageModified(parseMessage);
                    }
                    String str = TUIChatService.TAG;
                    TUIChatLog.i(str, "onRecvMessageModified msgID:" + v2TIMMessage.getMsgID());
                }
            }

            public void onRecvMessageReadReceipts(List<V2TIMMessageReceipt> list) {
                List<C2CChatEventListener> access$000 = TUIChatService.getInstance().getC2CChatEventListenerList();
                List<GroupChatEventListener> access$100 = TUIChatService.getInstance().getGroupChatEventListenerList();
                ArrayList arrayList = new ArrayList();
                for (V2TIMMessageReceipt messageReceipt : list) {
                    MessageReceiptInfo messageReceiptInfo = new MessageReceiptInfo();
                    messageReceiptInfo.setMessageReceipt(messageReceipt);
                    arrayList.add(messageReceiptInfo);
                }
                for (GroupChatEventListener onReadReport : access$100) {
                    onReadReport.onReadReport(arrayList);
                }
                for (C2CChatEventListener onReadReport2 : access$000) {
                    onReadReport2.onReadReport(arrayList);
                }
            }

            public void onRecvMessageRevoked(String str) {
                for (C2CChatEventListener handleRevoke : TUIChatService.getInstance().getC2CChatEventListenerList()) {
                    handleRevoke.handleRevoke(str);
                }
                for (GroupChatEventListener handleRevoke2 : TUIChatService.getInstance().getGroupChatEventListenerList()) {
                    handleRevoke2.handleRevoke(str);
                }
            }

            public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
                String str;
                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
                if (parseMessage != null) {
                    HashMap hashMap = new HashMap();
                    if (TextUtils.isEmpty(v2TIMMessage.getGroupID())) {
                        for (C2CChatEventListener onRecvNewMessage : TUIChatService.getInstance().getC2CChatEventListenerList()) {
                            onRecvNewMessage.onRecvNewMessage(parseMessage);
                        }
                        str = "c2c_" + v2TIMMessage.getUserID();
                        if (parseMessage instanceof MessageTypingBean) {
                            hashMap.put(TUIConstants.TUIChat.IS_TYPING_MESSAGE, Boolean.TRUE);
                        } else {
                            hashMap.put(TUIConstants.TUIChat.IS_TYPING_MESSAGE, Boolean.FALSE);
                        }
                    } else {
                        for (GroupChatEventListener onRecvNewMessage2 : TUIChatService.getInstance().getGroupChatEventListenerList()) {
                            onRecvNewMessage2.onRecvNewMessage(parseMessage);
                        }
                        str = "group_" + v2TIMMessage.getGroupID();
                    }
                    hashMap.put(TUIConstants.TUIChat.CONVERSATION_ID, str);
                    TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_RECEIVE_MESSAGE, TUIConstants.TUIChat.EVENT_SUB_KEY_CONVERSATION_ID, hashMap);
                }
            }
        });
        V2TIMManager.getFriendshipManager().addFriendListener(new V2TIMFriendshipListener() {
            public void onFriendInfoChanged(List<V2TIMFriendInfo> list) {
                for (C2CChatEventListener c2CChatEventListener : TUIChatService.getInstance().getC2CChatEventListenerList()) {
                    for (V2TIMFriendInfo next : list) {
                        if (TextUtils.isEmpty(next.getFriendRemark())) {
                            String nickName = next.getUserProfile().getNickName();
                            if (TextUtils.isEmpty(nickName)) {
                                c2CChatEventListener.onFriendNameChanged(next.getUserID(), next.getUserID());
                            } else {
                                c2CChatEventListener.onFriendNameChanged(next.getUserID(), nickName);
                            }
                        } else {
                            c2CChatEventListener.onFriendNameChanged(next.getUserID(), next.getFriendRemark());
                        }
                        c2CChatEventListener.onFriendFaceUrlChanged(next.getUserID(), next.getUserProfile().getFaceUrl());
                    }
                }
            }
        });
        V2TIMManager.getInstance().addIMSDKListener(new V2TIMSDKListener() {
            public void onConnectSuccess() {
                for (WeakReference weakReference : TUIChatService.this.connectListenerList) {
                    NetworkConnectionListener networkConnectionListener = (NetworkConnectionListener) weakReference.get();
                    if (networkConnectionListener != null) {
                        networkConnectionListener.onConnected();
                    }
                }
            }
        });
    }

    private void initMessageType() {
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_HELLO, CustomLinkMessageBean.class, true, CustomLinkMessageHolder.class);
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_EVALUATION, CustomEvaluationMessageBean.class, true, CustomEvaluationMessageHolder.class);
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, CustomOrderMessageBean.class, true, CustomOrderMessageHolder.class);
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_TYPING, MessageTypingBean.class, true, (Class<? extends MessageBaseHolder>) null);
    }

    private void initService() {
        TUICore.registerService("TUIChatService", this);
    }

    private void onGroupApplicationEvent(String str, Map<String, Object> map) {
        if (TextUtils.equals(str, TUIConstants.TUIGroup.Event.GroupApplication.SUB_KEY_GROUP_APPLICATION_NUM_CHANGED)) {
            for (GroupChatEventListener onApplied : getGroupChatEventListenerList()) {
                onApplied.onApplied(0);
            }
        }
    }

    public void addC2CChatEventListener(C2CChatEventListener c2CChatEventListener) {
        if (c2CChatEventListener != null) {
            for (WeakReference<C2CChatEventListener> weakReference : this.c2CChatEventListenerList) {
                if (weakReference.get() == c2CChatEventListener) {
                    return;
                }
            }
            this.c2CChatEventListenerList.add(new WeakReference(c2CChatEventListener));
        }
    }

    public void addCustomMessageType(String str, Class<? extends TUIMessageBean> cls, boolean z11, Class<? extends MessageBaseHolder> cls2) {
        this.viewType++;
        this.customMessageMap.put(str, cls);
        this.messageViewTypeMap.put(cls, Integer.valueOf(this.viewType));
        this.messageViewHolderMap.put(Integer.valueOf(this.viewType), cls2);
    }

    public void addGroupChatEventListener(GroupChatEventListener groupChatEventListener) {
        if (groupChatEventListener != null) {
            for (WeakReference<GroupChatEventListener> weakReference : this.groupChatEventListenerList) {
                if (weakReference.get() == groupChatEventListener) {
                    return;
                }
            }
            this.groupChatEventListenerList.add(new WeakReference(groupChatEventListener));
        }
    }

    public void addUnreadCountListener(TotalUnreadCountListener totalUnreadCountListener) {
        if (totalUnreadCountListener != null) {
            for (WeakReference<TotalUnreadCountListener> weakReference : this.unreadCountListenerList) {
                if (weakReference.get() == totalUnreadCountListener) {
                    return;
                }
            }
            this.unreadCountListenerList.add(new WeakReference(totalUnreadCountListener));
        }
    }

    public RxDataStore<Preferences> getChatDataStore() {
        return this.mChatDataStore;
    }

    public Class<? extends TUIMessageBean> getMessageBeanClass(String str) {
        if (str.equals("huobi_group_notification")) {
            str = "hb_group_notice_text";
        }
        return this.customMessageMap.get(str);
    }

    public Class<? extends MessageBaseHolder> getMessageViewHolderClass(int i11) {
        return this.messageViewHolderMap.get(Integer.valueOf(i11));
    }

    public int getViewType(Class<? extends TUIMessageBean> cls) {
        Integer num = this.messageViewTypeMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void init(Context context) {
        instance = this;
        initDefaultMessageType();
        initMessageType();
        initService();
        initEvent();
        initIMListener();
        initDataStore();
    }

    public Object onCall(String str, Map<String, Object> map) {
        V2TIMMessage v2TIMMessage;
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_SEND_MESSAGE, str)) {
            String str2 = (String) map.get("chatId");
            int intValue = ((Integer) getOrDefault(map.get(TUIConstants.TUIChat.CHAT_TYPE), 0)).intValue();
            String str3 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_CONTENT), "");
            String str4 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_DESCRIPTION), "");
            String str5 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_EXTENSION), "");
            IBaseMessageSender messageSender2 = getMessageSender();
            if (messageSender2 != null) {
                return messageSender2.sendMessage(ChatMessageBuilder.buildCustomMessage(str3, str4, str5.getBytes()), str2, TUIChatUtils.isGroupChat(intValue));
            }
            return null;
        } else if (TextUtils.equals(TUIConstants.TUIChat.METHOD_EXIT_CHAT, str)) {
            String str6 = (String) map.get("chatId");
            if (((Boolean) map.get(TUIConstants.TUIChat.IS_GROUP_CHAT)).booleanValue()) {
                for (GroupChatEventListener exitGroupChat : getGroupChatEventListenerList()) {
                    exitGroupChat.exitGroupChat(str6);
                }
                return null;
            }
            for (C2CChatEventListener exitC2CChat : getC2CChatEventListenerList()) {
                exitC2CChat.exitC2CChat(str6);
            }
            return null;
        } else if (TextUtils.equals(TUIConstants.TUIChat.METHOD_GET_DISPLAY_STRING, str)) {
            if (map == null || (v2TIMMessage = (V2TIMMessage) map.get(TUIConstants.TUIChat.V2TIMMESSAGE)) == null) {
                return null;
            }
            return ChatMessageParser.getDisplayString(v2TIMMessage);
        } else if (TextUtils.equals(TUIConstants.TUIChat.METHOD_ADD_MESSAGE_TO_CHAT, str)) {
            TUIMessageBean tUIMessageBean = (TUIMessageBean) map.get("messageBean");
            String str7 = (String) map.get("chatId");
            if (((Boolean) map.get(TUIConstants.TUIChat.IS_GROUP_CHAT)).booleanValue()) {
                for (GroupChatEventListener addMessage : getGroupChatEventListenerList()) {
                    addMessage.addMessage(tUIMessageBean, str7);
                }
                return null;
            }
            for (C2CChatEventListener addMessage2 : getC2CChatEventListenerList()) {
                addMessage2.addMessage(tUIMessageBean, str7);
            }
            return null;
        } else if (TextUtils.equals(TUIConstants.TUIChat.METHOD_UPDATE_DATA_STORE_CHAT_URI, str)) {
            String str8 = (String) map.get(TUIConstants.TUIChat.CHAT_BACKGROUND_URI);
            String str9 = (String) map.get("chatId");
            if (TextUtils.isEmpty(str8)) {
                return null;
            }
            DataStoreUtil.getInstance().putValue(str9, str8);
            return null;
        } else if (!TextUtils.equals(TUIConstants.TUIChat.METHOD_SET_CHAT_EXTENSION, str)) {
            return null;
        } else {
            for (Map.Entry next : map.entrySet()) {
                String str10 = (String) next.getKey();
                Object value = next.getValue();
                if (TextUtils.equals(str10, TUIConstants.TUIChat.ENABLE_VIDEO_CALL)) {
                    TUIChatConfigs.getConfigs().getGeneralConfig().setEnableVideoCall(((Boolean) value).booleanValue());
                } else if (TextUtils.equals(str10, TUIConstants.TUIChat.ENABLE_AUDIO_CALL)) {
                    TUIChatConfigs.getConfigs().getGeneralConfig().setEnableVoiceCall(((Boolean) value).booleanValue());
                } else if (TextUtils.equals(str10, TUIConstants.TUIChat.ENABLE_LINK)) {
                    TUIChatConfigs.getConfigs().getGeneralConfig().setEnableWelcomeCustomMessage(((Boolean) value).booleanValue());
                }
            }
            return null;
        }
    }

    public /* synthetic */ Object onCall(String str, Map map, TUIServiceCallback tUIServiceCallback) {
        return b.b(this, str, map, tUIServiceCallback);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNotifyEvent(java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r3 = this;
            java.lang.String r0 = "eventGroup"
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0135
            java.lang.String r4 = "eventExitGroup"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            r0 = 0
            java.lang.String r2 = "groupId"
            if (r4 != 0) goto L_0x0110
            java.lang.String r4 = "eventMemberGroupDismiss"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 != 0) goto L_0x0110
            java.lang.String r4 = "eventMemberGroupRecycle"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x0027
            goto L_0x0110
        L_0x0027:
            java.lang.String r4 = "eventSubKeyGroupInfoChanged"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x0097
            if (r6 != 0) goto L_0x0032
            return
        L_0x0032:
            java.lang.String r4 = "groupName"
            java.lang.Object r4 = r6.get(r4)
            java.lang.Object r4 = r3.getOrDefault(r4, r0)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r6.get(r2)
            java.lang.Object r5 = r3.getOrDefault(r5, r1)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r1 = "groupFaceUrl"
            java.lang.Object r6 = r6.get(r1)
            java.lang.Object r6 = r3.getOrDefault(r6, r0)
            java.lang.String r6 = (java.lang.String) r6
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x005b
            return
        L_0x005b:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0079
            java.util.List r0 = r3.getGroupChatEventListenerList()
            java.util.Iterator r0 = r0.iterator()
        L_0x0069:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r0.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener r1 = (com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener) r1
            r1.onGroupNameChanged(r5, r4)
            goto L_0x0069
        L_0x0079:
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 != 0) goto L_0x031a
            java.util.List r4 = r3.getGroupChatEventListenerList()
            java.util.Iterator r4 = r4.iterator()
        L_0x0087:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x031a
            java.lang.Object r0 = r4.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener r0 = (com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener) r0
            r0.onGroupFaceUrlChanged(r5, r6)
            goto L_0x0087
        L_0x0097:
            java.lang.String r4 = "eventMemberKickedGroup"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x00e6
            if (r6 != 0) goto L_0x00a2
            return
        L_0x00a2:
            java.lang.Object r4 = r6.get(r2)
            java.lang.Object r4 = r3.getOrDefault(r4, r1)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "groupMemberIdList"
            java.lang.Object r5 = r6.get(r5)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x00e5
            if (r5 == 0) goto L_0x00e5
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x00c3
            goto L_0x00e5
        L_0x00c3:
            java.lang.String r6 = com.tencent.qcloud.tuicore.TUILogin.getLoginUser()
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x031a
            java.util.List r5 = r3.getGroupChatEventListenerList()
            java.util.Iterator r5 = r5.iterator()
        L_0x00d5:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x031a
            java.lang.Object r6 = r5.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener r6 = (com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener) r6
            r6.onGroupForceExit(r4)
            goto L_0x00d5
        L_0x00e5:
            return
        L_0x00e6:
            java.lang.String r4 = "eventSubKeyGroupClearMessage"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x031a
            java.lang.Object r4 = r6.get(r2)
            java.lang.Object r4 = r3.getOrDefault(r4, r1)
            java.lang.String r4 = (java.lang.String) r4
            java.util.List r5 = r3.getGroupChatEventListenerList()
            java.util.Iterator r5 = r5.iterator()
        L_0x0100:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x031a
            java.lang.Object r6 = r5.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener r6 = (com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener) r6
            r6.clearGroupMessage(r4)
            goto L_0x0100
        L_0x0110:
            java.util.List r4 = r3.getGroupChatEventListenerList()
            if (r6 == 0) goto L_0x0121
            java.lang.Object r5 = r6.get(r2)
            java.lang.Object r5 = r3.getOrDefault(r5, r1)
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0
        L_0x0121:
            java.util.Iterator r4 = r4.iterator()
        L_0x0125:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x031a
            java.lang.Object r5 = r4.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener r5 = (com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener) r5
            r5.onGroupForceExit(r0)
            goto L_0x0125
        L_0x0135:
            java.lang.String r0 = "eventUser"
            boolean r0 = r4.equals(r0)
            java.lang.String r2 = "friendId"
            if (r0 == 0) goto L_0x0173
            java.lang.String r4 = "eventSubKeyC2CClearMessage"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x031a
            if (r6 == 0) goto L_0x0172
            boolean r4 = r6.isEmpty()
            if (r4 == 0) goto L_0x0150
            goto L_0x0172
        L_0x0150:
            java.lang.Object r4 = r6.get(r2)
            java.lang.Object r4 = r3.getOrDefault(r4, r1)
            java.lang.String r4 = (java.lang.String) r4
            java.util.List r5 = r3.getC2CChatEventListenerList()
            java.util.Iterator r5 = r5.iterator()
        L_0x0162:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x031a
            java.lang.Object r6 = r5.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener r6 = (com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener) r6
            r6.clearC2CMessage(r4)
            goto L_0x0162
        L_0x0172:
            return
        L_0x0173:
            java.lang.String r0 = "eventFriendInfoChanged"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x01b3
            java.lang.String r4 = "eventFriendRemarkChanged"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x031a
            if (r6 == 0) goto L_0x01b2
            boolean r4 = r6.isEmpty()
            if (r4 == 0) goto L_0x018c
            goto L_0x01b2
        L_0x018c:
            java.lang.Object r4 = r6.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "friendRemark"
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.util.List r6 = r3.getC2CChatEventListenerList()
            java.util.Iterator r6 = r6.iterator()
        L_0x01a2:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x031a
            java.lang.Object r0 = r6.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener r0 = (com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener) r0
            r0.onFriendNameChanged(r4, r5)
            goto L_0x01a2
        L_0x01b2:
            return
        L_0x01b3:
            java.lang.String r0 = "eventTotalUnreadCount"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x01e7
            java.lang.String r4 = "unreadCountChanged"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x031a
            java.lang.String r4 = "totalUnreadCount"
            java.lang.Object r4 = r6.get(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            java.util.List r6 = r3.getUnreadCountListenerList()
            java.util.Iterator r6 = r6.iterator()
        L_0x01d7:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x031a
            java.lang.Object r0 = r6.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener r0 = (com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener) r0
            r0.onTotalUnreadCountChanged(r4)
            goto L_0x01d7
        L_0x01e7:
            java.lang.String r0 = "eventLoginStateChanged"
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            if (r0 == 0) goto L_0x023c
            java.lang.String r4 = "eventSubKeyUserLoginSuccess"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x031a
            com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager.loadEmojis()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs r5 = com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs.getConfigs()
            com.tencent.qcloud.tuikit.tuichat.config.GeneralConfig r5 = r5.getGeneralConfig()
            boolean r5 = r5.isEnableFloatWindowForCall()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r6 = "enableFloatWindow"
            r4.put(r6, r5)
            java.lang.String r5 = "TUICallingService"
            java.lang.String r6 = "methodEnableFloatWindow"
            com.tencent.qcloud.tuicore.TUICore.callService(r5, r6, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs r6 = com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs.getConfigs()
            com.tencent.qcloud.tuikit.tuichat.config.GeneralConfig r6 = r6.getGeneralConfig()
            boolean r6 = r6.isEnableMultiDeviceForCall()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.String r0 = "enableMultiDeviceAbility"
            r4.put(r0, r6)
            java.lang.String r6 = "methodEnableMultiDeviceAbility"
            com.tencent.qcloud.tuicore.TUICore.callService(r5, r6, r4)
            goto L_0x031a
        L_0x023c:
            java.lang.String r0 = "eventKeyMessageStatusChanged"
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            java.lang.String r1 = "messageBean"
            if (r0 == 0) goto L_0x028d
            java.lang.String r4 = "eventSubKeyMessageSend"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x031a
            java.lang.Object r4 = r6.get(r1)
            boolean r5 = r4 instanceof com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean
            if (r5 == 0) goto L_0x031a
            java.util.List r5 = r3.getGroupChatEventListenerList()
            java.util.Iterator r5 = r5.iterator()
        L_0x025e:
            boolean r6 = r5.hasNext()
            r0 = 4
            if (r6 == 0) goto L_0x0272
            java.lang.Object r6 = r5.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener r6 = (com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener) r6
            r1 = r4
            com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r1 = (com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean) r1
            r6.onMessageChanged(r1, r0)
            goto L_0x025e
        L_0x0272:
            java.util.List r5 = r3.getC2CChatEventListenerList()
            java.util.Iterator r5 = r5.iterator()
        L_0x027a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x031a
            java.lang.Object r6 = r5.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener r6 = (com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener) r6
            r1 = r4
            com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r1 = (com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean) r1
            r6.onMessageChanged(r1, r0)
            goto L_0x027a
        L_0x028d:
            java.lang.String r0 = "eventKeyOfflineMessagePrivteRing"
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            if (r0 == 0) goto L_0x02b5
            java.lang.String r4 = "eventSubKeyOfflineMessagePrivteRing"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x031a
            java.lang.String r4 = "offlineMessagePrivateRing"
            java.lang.Object r4 = r6.get(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs r5 = com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs.getConfigs()
            com.tencent.qcloud.tuikit.tuichat.config.GeneralConfig r5 = r5.getGeneralConfig()
            boolean r4 = r4.booleanValue()
            r5.setAndroidPrivateRing(r4)
            goto L_0x031a
        L_0x02b5:
            java.lang.String r0 = "eventKeyTranslationEvent"
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            if (r0 == 0) goto L_0x030f
            java.lang.String r4 = "eventSubKeyTranslationChanged"
            boolean r4 = android.text.TextUtils.equals(r5, r4)
            if (r4 == 0) goto L_0x031a
            java.lang.Object r4 = r6.get(r1)
            com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean r4 = (com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean) r4
            java.lang.String r5 = "dataChangeType"
            java.lang.Object r5 = r6.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            com.tencent.qcloud.tuikit.tuichat.TUIChatService r6 = getInstance()
            java.util.List r6 = r6.getC2CChatEventListenerList()
            java.util.Iterator r6 = r6.iterator()
        L_0x02e3:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x02f3
            java.lang.Object r0 = r6.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener r0 = (com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener) r0
            r0.onMessageChanged(r4, r5)
            goto L_0x02e3
        L_0x02f3:
            com.tencent.qcloud.tuikit.tuichat.TUIChatService r6 = getInstance()
            java.util.List r6 = r6.getGroupChatEventListenerList()
            java.util.Iterator r6 = r6.iterator()
        L_0x02ff:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x031a
            java.lang.Object r0 = r6.next()
            com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener r0 = (com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener) r0
            r0.onMessageChanged(r4, r5)
            goto L_0x02ff
        L_0x030f:
            java.lang.String r0 = "groupApplication"
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 == 0) goto L_0x031a
            r3.onGroupApplicationEvent(r5, r6)
        L_0x031a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.TUIChatService.onNotifyEvent(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public void registerNetworkListener(NetworkConnectionListener networkConnectionListener) {
        if (networkConnectionListener != null) {
            for (WeakReference<NetworkConnectionListener> weakReference : this.connectListenerList) {
                if (((NetworkConnectionListener) weakReference.get()) == networkConnectionListener) {
                    return;
                }
            }
            this.connectListenerList.add(new WeakReference(networkConnectionListener));
        }
    }

    public void setMessageSender(IBaseMessageSender iBaseMessageSender) {
        this.messageSender = new WeakReference<>(iBaseMessageSender);
    }
}
