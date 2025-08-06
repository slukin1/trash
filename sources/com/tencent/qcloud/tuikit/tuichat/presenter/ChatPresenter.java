package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageListGetOption;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.timcommon.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageContainerBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflinePushInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.UserStatusBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.model.AIDenoiseSignatureManager;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.OfflinePushInfoUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIGroupUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public abstract class ChatPresenter {
    private static final int FORWARD_C2C_INTERVAL = 50;
    private static final int FORWARD_GROUP_INTERVAL = 90;
    public static final int MSG_PAGE_COUNT = 20;
    private static final int READ_REPORT_INTERVAL = 1000;
    /* access modifiers changed from: private */
    public static final String TAG = "ChatPresenter";
    private IBaseMessageSender baseMessageSender;
    /* access modifiers changed from: private */
    public boolean canReadReport = true;
    public WeakReference<ChatNotifyHandler> chatNotifyHandler;
    private int currentChatUnreadCount = 0;
    private boolean isChatFragmentShow = false;
    public boolean isHaveMoreNewMessage = true;
    public boolean isHaveMoreOldMessage = true;
    public boolean isLoading = false;
    public boolean isNeedShowTranslation = true;
    /* access modifiers changed from: private */
    public long lastReadReportTime = 0;
    /* access modifiers changed from: private */
    public final Handler loadApplyHandler = new Handler();
    public List<TUIMessageBean> loadedMessageInfoList = new ArrayList();
    private TUIMessageBean locateMessage;
    private TUIMessageBean mCacheNewMessage = null;
    public IMessageAdapter messageListAdapter;
    private IMessageRecyclerView messageRecyclerView;
    public final ChatProvider provider;
    private final MessageReadReportHandler readReportHandler = new MessageReadReportHandler();

    public interface ChatNotifyHandler {
        void addMessageAfterPreProcess(TUIMessageBean tUIMessageBean);

        void clearMessage();

        void clearMessageAndReLoad();

        void onApplied(int i11);

        void onExitChat(String str);

        void onFriendFaceUrlChanged(String str);

        void onFriendNameChanged(String str);

        void onGroupFaceUrlChanged(String str);

        void onGroupForceExit();

        void onGroupNameChanged(String str);

        void onReceiveCustomMessage(TUIMessageBean tUIMessageBean);

        void resetCurrentChatUnreadCount();

        void updateAdapter(int i11, int i12);

        void updateAdapter(int i11, TUIMessageBean tUIMessageBean);
    }

    public class LoadApplyListRunnable implements Runnable {
        private static final int TRY_DELAY = 500;
        /* access modifiers changed from: private */
        public IUIKitCallback<List<GroupApplyInfo>> callback;

        public LoadApplyListRunnable() {
        }

        public void run() {
            ChatPresenter.this.provider.loadApplyInfo(new IUIKitCallback<List<GroupApplyInfo>>() {
                public void onError(String str, int i11, String str2) {
                    if (i11 == 6015) {
                        ChatPresenter.this.loadApplyHandler.removeCallbacksAndMessages((Object) null);
                        ChatPresenter.this.loadApplyHandler.postDelayed(LoadApplyListRunnable.this, 500);
                    }
                    TUIChatUtils.callbackOnError(LoadApplyListRunnable.this.callback, str, i11, str2);
                }

                public void onSuccess(List<GroupApplyInfo> list) {
                    if (ChatPresenter.this.getChatInfo() instanceof GroupInfo) {
                        String id2 = ChatPresenter.this.getChatInfo().getId();
                        ArrayList arrayList = new ArrayList();
                        for (int i11 = 0; i11 < list.size(); i11++) {
                            GroupApplyInfo groupApplyInfo = list.get(i11);
                            if (id2.equals(groupApplyInfo.getGroupApplication().getGroupID()) && !groupApplyInfo.isStatusHandled()) {
                                arrayList.add(groupApplyInfo);
                            }
                        }
                        TUIChatUtils.callbackOnSuccess(LoadApplyListRunnable.this.callback, arrayList);
                    }
                }
            });
        }
    }

    public static class MessageReadReportHandler extends Handler {
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    public interface TypingListener {
        void onTyping(int i11);
    }

    public ChatPresenter() {
        TUIChatLog.i(TAG, "ChatPresenter Init");
        this.provider = ChatProvider.getInstance();
        AIDenoiseSignatureManager.getInstance().updateSignature();
    }

    /* access modifiers changed from: private */
    public void addMessageAfterPreProcess(TUIMessageBean tUIMessageBean) {
        WeakReference<ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatNotifyHandler) this.chatNotifyHandler.get()).addMessageAfterPreProcess(tUIMessageBean);
        }
    }

    /* access modifiers changed from: private */
    public void filterGroupMessageReceipt(TUIMessageBean tUIMessageBean, String str) {
        if (TUIChatUtils.isCommunityGroup(str)) {
            tUIMessageBean.setNeedReadReceipt(false);
        }
    }

    /* access modifiers changed from: private */
    public void getReadReceiptAndRefresh(final TUIMessageBean tUIMessageBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        getMessageReadReceipt((List<TUIMessageBean>) arrayList, (IUIKitCallback<List<MessageReceiptInfo>>) new IUIKitCallback<List<MessageReceiptInfo>>() {
            public void onError(String str, int i11, String str2) {
                ChatPresenter.this.refreshData(tUIMessageBean);
            }

            public void onSuccess(List<MessageReceiptInfo> list) {
                tUIMessageBean.setMessageReceiptInfo(list.get(0));
                ChatPresenter.this.refreshData(tUIMessageBean);
            }
        });
    }

    private void loadToWayMessageAsync(String str, boolean z11, int i11, int i12, TUIMessageBean tUIMessageBean, IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        TUIMessageBean tUIMessageBean2 = tUIMessageBean;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(tUIMessageBean2);
        this.locateMessage = tUIMessageBean2;
        CountDownLatch countDownLatch = new CountDownLatch(2);
        boolean[] zArr = {false};
        final String str2 = str;
        final boolean z12 = z11;
        final int i13 = i12;
        final TUIMessageBean tUIMessageBean3 = tUIMessageBean;
        final ArrayList arrayList3 = arrayList;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback2 = iUIKitCallback;
        final boolean[] zArr2 = zArr;
        AnonymousClass5 r02 = new Runnable() {
            public void run() {
                ChatPresenter.this.provider.loadHistoryMessageList(str2, z12, i13 / 2, tUIMessageBean3, 1, new IUIKitCallback<List<TUIMessageBean>>() {
                    public void onError(String str, int i11, String str2) {
                        TUIChatUtils.callbackOnError(iUIKitCallback2, i11, str2);
                        AnonymousClass5 r22 = AnonymousClass5.this;
                        zArr2[0] = true;
                        countDownLatch2.countDown();
                    }

                    public void onSuccess(List<TUIMessageBean> list) {
                        int size = list.size();
                        AnonymousClass5 r12 = AnonymousClass5.this;
                        if (size >= i13 / 2) {
                            ChatPresenter.this.isHaveMoreNewMessage = true;
                        } else {
                            ChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                        arrayList3.addAll(list);
                        countDownLatch2.countDown();
                    }
                });
            }
        };
        final ArrayList arrayList4 = arrayList2;
        final boolean[] zArr3 = zArr;
        AnonymousClass6 r03 = new Runnable() {
            public void run() {
                ChatPresenter.this.provider.loadHistoryMessageList(str2, z12, i13 / 2, tUIMessageBean3, 0, new IUIKitCallback<List<TUIMessageBean>>() {
                    public void onError(String str, int i11, String str2) {
                        AnonymousClass6 r22 = AnonymousClass6.this;
                        zArr3[0] = true;
                        countDownLatch2.countDown();
                    }

                    public void onSuccess(List<TUIMessageBean> list) {
                        int size = list.size();
                        AnonymousClass6 r12 = AnonymousClass6.this;
                        if (size < i13 / 2) {
                            ChatPresenter.this.isHaveMoreOldMessage = false;
                        }
                        arrayList4.addAll(list);
                        countDownLatch2.countDown();
                    }
                });
            }
        };
        final CountDownLatch countDownLatch3 = countDownLatch;
        final boolean[] zArr4 = zArr;
        final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback3 = iUIKitCallback;
        final ArrayList arrayList5 = arrayList;
        final int i14 = i11;
        AnonymousClass7 r04 = new Runnable() {
            public void run() {
                try {
                    countDownLatch3.await();
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                }
                if (zArr4[0]) {
                    TUIChatUtils.callbackOnError(iUIKitCallback3, -1, "load failed");
                    return;
                }
                Collections.reverse(arrayList5);
                arrayList4.addAll(0, arrayList5);
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        AnonymousClass7 r02 = AnonymousClass7.this;
                        ChatPresenter.this.onMessageLoadCompleted(arrayList4, i14);
                    }
                });
                TUIChatUtils.callbackOnSuccess(iUIKitCallback3, arrayList4);
            }
        };
        ThreadUtils.execute(r02);
        ThreadUtils.execute(r03);
        ThreadUtils.execute(r04);
    }

    private void notifyConversationInfo(ChatInfo chatInfo) {
        String str;
        if (2 == chatInfo.getType()) {
            str = "group_" + chatInfo.getId();
        } else {
            str = "c2c_" + chatInfo.getId();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUIConversation.CONVERSATION_ID, str);
        TUICore.notifyEvent(TUIConstants.TUIConversation.EVENT_KEY_MESSAGE_SEND_FOR_CONVERSATION, TUIConstants.TUIConversation.EVENT_SUB_KEY_MESSAGE_SEND_FOR_CONVERSATION, hashMap);
    }

    private void notifyTyping() {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "notifyTyping unSafetyCall");
        }
    }

    /* access modifiers changed from: private */
    public void onLoadedMessageProcessed(List<TUIMessageBean> list, int i11) {
        boolean z11 = i11 == 0;
        boolean z12 = i11 == 2;
        boolean z13 = i11 == 3;
        boolean z14 = i11 == 4;
        if (z11 || z12 || z13) {
            Collections.reverse(list);
        }
        if (z14) {
            removeDuplication(list);
            this.loadedMessageInfoList = list;
            updateAdapter(1, list.size());
        } else if (z11 || z12 || z13) {
            removeDuplication(list);
            this.loadedMessageInfoList.addAll(0, list);
            if (z11) {
                if (this.loadedMessageInfoList.size() == list.size()) {
                    updateAdapter(1, list.size());
                } else {
                    updateAdapter(2, list.size());
                }
            } else if (z12) {
                updateAdapter(7, this.locateMessage);
            } else {
                updateAdapter(10, this.locateMessage);
            }
        } else {
            removeDuplication(list);
            this.loadedMessageInfoList.addAll(list);
            updateAdapter(3, list.size());
        }
        for (TUIMessageBean next : list) {
            if (next.getStatus() == 1) {
                sendMessage(next, true, (IUIKitCallback<TUIMessageBean>) null);
            }
        }
        this.isLoading = false;
    }

    private void onMessageDeleted(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean != null) {
            ListIterator<TUIMessageBean> listIterator = this.loadedMessageInfoList.listIterator();
            while (listIterator.hasNext()) {
                TUIMessageBean next = listIterator.next();
                if (TextUtils.equals(next.getId(), tUIMessageBean.getId())) {
                    int indexOf = this.loadedMessageInfoList.indexOf(next);
                    listIterator.remove();
                    updateAdapter(5, indexOf);
                    return;
                }
            }
        }
    }

    private void onMessageListDeleted(List<TUIMessageBean> list) {
        if (list != null && !list.isEmpty()) {
            for (TUIMessageBean onMessageDeleted : list) {
                onMessageDeleted(onMessageDeleted);
            }
        }
    }

    private void preProcessMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        preProcessMessage((List<TUIMessageBean>) arrayList, (IUIKitCallback<List<TUIMessageBean>>) new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, "preProcessReplyMessage failed");
            }

            public void onSuccess(List<TUIMessageBean> list) {
                if (list == null || list.size() != 1) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "preProcessReplyMessage failed");
                } else {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void readReport(String str, boolean z11) {
        if (!z11) {
            String str2 = TAG;
            TUIChatLog.i(str2, "C2C message ReadReport userId is " + str);
            c2cReadReport(str);
            return;
        }
        String str3 = TAG;
        TUIChatLog.i(str3, "Group message ReadReport groupId is " + str);
        groupReadReport(str);
    }

    /* access modifiers changed from: private */
    public void refreshData(TUIMessageBean tUIMessageBean) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onViewNeedRefresh(4, tUIMessageBean);
        }
    }

    private void removeDuplication(List<TUIMessageBean> list) {
        onMessageListDeleted(list);
    }

    private void resendMessageInfo(TUIMessageBean tUIMessageBean) {
        onMessageDeleted(tUIMessageBean);
        addMessageInfo(tUIMessageBean);
    }

    public void addCustomViewType(String str, Class<? extends TUIMessageBean> cls, Class<? extends MessageBaseHolder> cls2) {
        if (TUIChatService.getInstance().getMessageBeanClass(str) == null && TUIChatService.getInstance().getViewType(cls) == 0) {
            TUIChatService.getInstance().addCustomMessageType(str, cls, false, cls2);
        }
    }

    public void addMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "addMessage unSafetyCall");
        } else {
            preProcessMessage(tUIMessageBean, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
                public void onError(String str, int i11, String str2) {
                    ChatPresenter.this.addMessageAfterPreProcess(tUIMessageBean);
                }

                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    ChatPresenter.this.addMessageAfterPreProcess(tUIMessageBean);
                }
            });
        }
    }

    public void addMessageInfo(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean != null && !checkExist(tUIMessageBean)) {
            this.loadedMessageInfoList.add(tUIMessageBean);
            updateAdapter(8, 1);
        }
    }

    public void assembleGroupMessage(TUIMessageBean tUIMessageBean) {
    }

    public void c2cReadReport(String str) {
        this.provider.c2cReadReport(str);
    }

    public boolean checkExist(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean == null) {
            return false;
        }
        String id2 = tUIMessageBean.getId();
        for (int size = this.loadedMessageInfoList.size() - 1; size >= 0; size--) {
            if (this.loadedMessageInfoList.get(size).getId().equals(id2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        if (!safetyCall() || list == null || list.isEmpty()) {
            TUIChatLog.w(TAG, "checkFailedMessagesById unSafetyCall");
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (this.provider.checkFailedMessageInfo(list.get(i11))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFailedMessages(List<Integer> list) {
        if (!safetyCall() || list == null || list.isEmpty()) {
            TUIChatLog.w(TAG, "checkFailedMessages unSafetyCall");
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (this.provider.checkFailedMessageInfo(this.loadedMessageInfoList.get(list.get(i11).intValue()))) {
                return true;
            }
        }
        return false;
    }

    public void clearMessage() {
        this.loadedMessageInfoList.clear();
        this.messageListAdapter.onViewNeedRefresh(0, 0);
    }

    public void clearMessageAndReLoad() {
        WeakReference<ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatNotifyHandler) this.chatNotifyHandler.get()).clearMessageAndReLoad();
        }
    }

    public void deleteMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "deleteMessage unSafetyCall");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.provider.deleteMessages(arrayList, new IUIKitCallback<Void>() {
            public void onError(String str, int i11, String str2) {
                String access$100 = ChatPresenter.TAG;
                Log.e(access$100, "delete message failed, errCode " + i11 + ", " + str2);
            }

            public void onSuccess(Void voidR) {
                int indexOf = ChatPresenter.this.loadedMessageInfoList.indexOf(tUIMessageBean);
                ChatPresenter.this.loadedMessageInfoList.remove(tUIMessageBean);
                ChatPresenter.this.updateAdapter(5, indexOf);
            }
        });
    }

    public void deleteMessageInfos(final List<TUIMessageBean> list) {
        if (!safetyCall() || list == null || list.isEmpty()) {
            TUIChatLog.w(TAG, "deleteMessages unSafetyCall");
        } else {
            this.provider.deleteMessages(list, new IUIKitCallback<Void>() {
                public void onError(String str, int i11, String str2) {
                }

                public void onSuccess(Void voidR) {
                    for (int size = ChatPresenter.this.loadedMessageInfoList.size() - 1; size >= 0; size--) {
                        int size2 = list.size() - 1;
                        while (true) {
                            if (size2 < 0) {
                                break;
                            } else if (ChatPresenter.this.loadedMessageInfoList.get(size).getId().equals(((TUIMessageBean) list.get(size2)).getId())) {
                                ChatPresenter.this.loadedMessageInfoList.remove(size);
                                ChatPresenter.this.updateAdapter(5, size);
                                break;
                            } else {
                                size2--;
                            }
                        }
                    }
                }
            });
        }
    }

    public void deleteMessages(final List<Integer> list) {
        if (!safetyCall() || list == null || list.isEmpty()) {
            TUIChatLog.w(TAG, "deleteMessages unSafetyCall");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(this.loadedMessageInfoList.get(list.get(i11).intValue()));
        }
        this.provider.deleteMessages(arrayList, new IUIKitCallback<Void>() {
            public void onError(String str, int i11, String str2) {
            }

            public void onSuccess(Void voidR) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ChatPresenter.this.loadedMessageInfoList.remove(list.get(size));
                    ChatPresenter.this.updateAdapter(5, size);
                }
            }
        });
    }

    public void findMessage(String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        for (TUIMessageBean next : this.loadedMessageInfoList) {
            if (TextUtils.equals(str, next.getId())) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, next);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.provider.findMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(List<TUIMessageBean> list) {
                if (list == null || list.isEmpty()) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, 0, "");
                } else {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
                }
            }
        });
    }

    public void forwardMessage(List<TUIMessageBean> list, boolean z11, String str, String str2, int i11, boolean z12, IUIKitCallback iUIKitCallback) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "sendMessage unSafetyCall");
            return;
        }
        for (TUIMessageBean next : list) {
            if (next instanceof TextMessageBean) {
                String str3 = TAG;
                TUIChatLog.d(str3, "chatprensetor forwardMessage onTextSelected selectedText = " + ((TextMessageBean) next).getSelectText());
            }
        }
        if (i11 == 0) {
            forwardMessageOneByOne(list, z11, str, str2, z12, iUIKitCallback);
        } else if (i11 == 1) {
            forwardMessageMerge(list, z11, str, str2, z12, iUIKitCallback);
        } else {
            TUIChatLog.d(TAG, "invalid forwardMode");
        }
    }

    public void forwardMessageInternal(final TUIMessageBean tUIMessageBean, boolean z11, String str, OfflinePushInfo offlinePushInfo, final IUIKitCallback iUIKitCallback) {
        if (tUIMessageBean == null) {
            TUIChatLog.e(TAG, "forwardMessageInternal null message!");
            return;
        }
        String sendMessage = this.provider.sendMessage(tUIMessageBean, z11, str, offlinePushInfo, new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                String access$100 = ChatPresenter.TAG;
                TUIChatLog.v(access$100, "sendMessage fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                tUIMessageBean.setStatus(3);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean, 4);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
                tUIMessageBean.setStatus(2);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean, 4);
                HashMap hashMap = new HashMap();
                hashMap.put("messageBean", tUIMessageBean);
                TUICore.notifyEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, hashMap);
            }
        });
        String str2 = TAG;
        TUIChatLog.i(str2, "sendMessage msgID:" + sendMessage);
        tUIMessageBean.setId(sendMessage);
        tUIMessageBean.setStatus(1);
    }

    public void forwardMessageMerge(List<TUIMessageBean> list, boolean z11, String str, String str2, boolean z12, IUIKitCallback iUIKitCallback) {
        if (list != null && !list.isEmpty()) {
            Context appContext = ServiceInitializer.getAppContext();
            if (appContext == null) {
                TUIChatLog.d(TAG, "context == null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (i11 < list.size() && i11 < 3) {
                TUIMessageBean tUIMessageBean = list.get(i11);
                String displayName = ChatMessageParser.getDisplayName(tUIMessageBean.getV2TIMMessage());
                if (!(tUIMessageBean instanceof TipsMessageBean)) {
                    if (tUIMessageBean instanceof TextMessageBean) {
                        arrayList.add(displayName + ":" + tUIMessageBean.getExtra());
                    } else if (tUIMessageBean instanceof FaceMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.custom_emoji));
                    } else if (tUIMessageBean instanceof SoundMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.audio_extra));
                    } else if (tUIMessageBean instanceof ImageMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.picture_extra));
                    } else if (tUIMessageBean instanceof VideoMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.video_extra));
                    } else if (tUIMessageBean instanceof FileMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.file_extra));
                    } else if (tUIMessageBean instanceof MergeMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.forward_extra));
                    } else {
                        arrayList.add(displayName + ":" + tUIMessageBean.getExtra());
                    }
                }
                i11++;
            }
            TUIMessageBean buildMergeMessage = ChatMessageBuilder.buildMergeMessage(list, str2, arrayList, ServiceInitializer.getAppContext().getString(R.string.forward_compatible_text));
            if (z12) {
                sendMessage(buildMergeMessage, false, (IUIKitCallback<TUIMessageBean>) iUIKitCallback);
                return;
            }
            if (z11) {
                filterGroupMessageReceipt(buildMergeMessage, str);
            }
            buildMergeMessage.setRead(true);
            assembleGroupMessage(buildMergeMessage);
            OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
            OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
            offlineMessageBean.content = buildMergeMessage.getExtra().toString();
            offlineMessageBean.sender = buildMergeMessage.getSender();
            offlineMessageBean.nickname = TUIConfig.getSelfNickName();
            offlineMessageBean.faceUrl = TUIConfig.getSelfFaceUrl();
            offlineMessageContainerBean.entity = offlineMessageBean;
            if (z11) {
                offlineMessageBean.chatType = 2;
                offlineMessageBean.sender = str;
            }
            OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
            offlinePushInfo.setExtension(new Gson().toJson((Object) offlineMessageContainerBean).getBytes());
            offlinePushInfo.setDescription(str2);
            offlinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
            if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
                offlinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
            }
            forwardMessageInternal(buildMergeMessage, z11, str, offlinePushInfo, iUIKitCallback);
        }
    }

    public void forwardMessageOneByOne(List<TUIMessageBean> list, boolean z11, String str, String str2, boolean z12, IUIKitCallback iUIKitCallback) {
        if (list != null && !list.isEmpty()) {
            final boolean z13 = z11;
            final List<TUIMessageBean> list2 = list;
            final boolean z14 = z12;
            final IUIKitCallback iUIKitCallback2 = iUIKitCallback;
            final String str3 = str;
            final String str4 = str2;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    int i11 = z13 ? 90 : 50;
                    for (int i12 = 0; i12 < list2.size(); i12++) {
                        TUIMessageBean buildForwardMessage = ChatMessageBuilder.buildForwardMessage(((TUIMessageBean) list2.get(i12)).getV2TIMMessage());
                        if (z14) {
                            ChatPresenter.this.sendMessage(buildForwardMessage, false, (IUIKitCallback<TUIMessageBean>) iUIKitCallback2);
                            try {
                                Thread.sleep((long) i11);
                            } catch (InterruptedException e11) {
                                e11.printStackTrace();
                            }
                        } else if (!(buildForwardMessage == null || buildForwardMessage.getStatus() == 1)) {
                            buildForwardMessage.setRead(true);
                            ChatPresenter.this.assembleGroupMessage(buildForwardMessage);
                            if (z13) {
                                ChatPresenter.this.filterGroupMessageReceipt(buildForwardMessage, str3);
                            }
                            OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
                            OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
                            offlineMessageBean.content = buildForwardMessage.getExtra().toString();
                            offlineMessageBean.sender = buildForwardMessage.getSender();
                            offlineMessageBean.nickname = TUIConfig.getSelfNickName();
                            offlineMessageBean.faceUrl = TUIConfig.getSelfFaceUrl();
                            offlineMessageContainerBean.entity = offlineMessageBean;
                            if (z13) {
                                offlineMessageBean.chatType = 2;
                                offlineMessageBean.sender = str3;
                            }
                            OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
                            offlinePushInfo.setExtension(new Gson().toJson((Object) offlineMessageContainerBean).getBytes());
                            offlinePushInfo.setDescription(str4);
                            offlinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
                            if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
                                offlinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
                            }
                            ChatPresenter.this.forwardMessageInternal(buildForwardMessage, z13, str3, offlinePushInfo, iUIKitCallback2);
                            try {
                                Thread.sleep((long) i11);
                            } catch (InterruptedException e12) {
                                e12.printStackTrace();
                            }
                        }
                    }
                }
            });
            thread.setName("ForwardMessageThread");
            ThreadUtils.execute(thread);
        }
    }

    public List<TUIMessageBean> forwardTextMessageForSelected(List<TUIMessageBean> list) {
        if (list != null && list.size() > 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        TUIMessageBean tUIMessageBean = list.get(0);
        if (!(tUIMessageBean instanceof TextMessageBean)) {
            return list;
        }
        TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
        if (textMessageBean.getText().equals(textMessageBean.getSelectText())) {
            return list;
        }
        arrayList.add(ChatMessageBuilder.buildTextMessage(textMessageBean.getSelectText()));
        return arrayList;
    }

    public void getChatFaceUrl(String str, IUIKitCallback<List<Object>> iUIKitCallback) {
    }

    public ChatInfo getChatInfo() {
        return null;
    }

    public void getChatName(String str, IUIKitCallback<String> iUIKitCallback) {
    }

    public void getConversationLastMessage(String str, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        this.provider.getConversationLastMessage(str, iUIKitCallback);
    }

    public void getGroupInfo(String str, final IUIKitCallback<GroupInfo> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.provider.getGroupInfo(arrayList, new IUIKitCallback<List<GroupInfo>>() {
            public void onError(String str, int i11, String str2) {
                TUIGroupUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(List<GroupInfo> list) {
                if (!list.isEmpty()) {
                    TUIGroupUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
                }
                String access$100 = ChatPresenter.TAG;
                Log.i(access$100, "getGroupInfo  onSuccess: data.size() = " + list.size());
            }
        });
    }

    public List<TUIMessageBean> getLoadedMessageInfoList() {
        return this.loadedMessageInfoList;
    }

    public void getMessageReadReceipt(final List<TUIMessageBean> list, final int i11) {
        getMessageReadReceipt(list, (IUIKitCallback<List<MessageReceiptInfo>>) new IUIKitCallback<List<MessageReceiptInfo>>() {
            public void onError(String str, int i11, String str2) {
                ChatPresenter.this.processLoadedMessage(list, i11);
            }

            public void onSuccess(List<MessageReceiptInfo> list) {
                for (MessageReceiptInfo next : list) {
                    for (TUIMessageBean tUIMessageBean : list) {
                        if (TextUtils.equals(tUIMessageBean.getId(), next.getMsgID())) {
                            tUIMessageBean.setMessageReceiptInfo(next);
                        }
                    }
                }
                ChatPresenter.this.processLoadedMessage(list, i11);
            }
        });
    }

    public RecyclerView getMessageRecyclerView() {
        return (RecyclerView) this.messageRecyclerView;
    }

    public void getReactUserBean(Set<String> set, final IUIKitCallback<Map<String, ReactUserBean>> iUIKitCallback) {
        final HashMap hashMap = new HashMap();
        for (String put : set) {
            hashMap.put(put, (Object) null);
        }
        ChatInfo chatInfo = getChatInfo();
        if (chatInfo instanceof GroupInfo) {
            this.provider.getGroupMembersInfo(chatInfo.getId(), new ArrayList(set), new IUIKitCallback<List<GroupMemberInfo>>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(List<GroupMemberInfo> list) {
                    for (GroupMemberInfo next : list) {
                        ReactUserBean reactUserBean = new ReactUserBean();
                        reactUserBean.setUserId(next.getAccount());
                        reactUserBean.setFriendRemark(next.getFriendRemark());
                        reactUserBean.setNameCard(next.getNameCard());
                        reactUserBean.setNikeName(next.getNickName());
                        reactUserBean.setFaceUrl(next.getIconUrl());
                        hashMap.put(reactUserBean.getUserId(), reactUserBean);
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, hashMap);
                }
            });
        } else {
            this.provider.getReactUserBean(new ArrayList(set), new IUIKitCallback<List<ReactUserBean>>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(List<ReactUserBean> list) {
                    for (ReactUserBean next : list) {
                        hashMap.put(next.getUserId(), next);
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, hashMap);
                }
            });
        }
    }

    public Set<String> getReactUserNames(List<TUIMessageBean> list) {
        Map<String, Set<String>> reacts;
        HashSet hashSet = new HashSet();
        for (TUIMessageBean messageReactBean : list) {
            MessageReactBean messageReactBean2 = messageReactBean.getMessageReactBean();
            if (!(messageReactBean2 == null || (reacts = messageReactBean2.getReacts()) == null)) {
                for (Set<String> addAll : reacts.values()) {
                    hashSet.addAll(addAll);
                }
            }
        }
        return hashSet;
    }

    public Set<String> getReplyUserNames(List<TUIMessageBean> list) {
        HashSet hashSet = new HashSet();
        for (TUIMessageBean messageRepliesBean : list) {
            MessageRepliesBean messageRepliesBean2 = messageRepliesBean.getMessageRepliesBean();
            if (messageRepliesBean2 != null && messageRepliesBean2.getRepliesSize() > 0) {
                for (MessageRepliesBean.ReplyBean messageSender : messageRepliesBean2.getReplies()) {
                    hashSet.add(messageSender.getMessageSender());
                }
            }
        }
        return hashSet;
    }

    public List<TUIMessageBean> getSelectPositionMessage(List<Integer> list) {
        if (!safetyCall() || list == null || list.isEmpty()) {
            TUIChatLog.w(TAG, "getSelectPositionMessage unSafetyCall");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11).intValue() < this.loadedMessageInfoList.size()) {
                arrayList.add(this.loadedMessageInfoList.get(list.get(i11).intValue()));
            } else {
                TUIChatLog.d(TAG, "mCurrentProvider not include SelectPosition ");
            }
        }
        return arrayList;
    }

    public List<TUIMessageBean> getSelectPositionMessageById(List<String> list) {
        ArrayList arrayList = null;
        if (!safetyCall() || list == null || list.isEmpty()) {
            TUIChatLog.w(TAG, "getSelectPositionMessageById unSafetyCall");
            return null;
        }
        List<TUIMessageBean> list2 = this.loadedMessageInfoList;
        if (list2 != null && list2.size() > 0) {
            arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                int i12 = 0;
                while (true) {
                    if (i12 >= list2.size()) {
                        break;
                    } else if (list.get(i11).equals(list2.get(i12).getId())) {
                        arrayList.add(list2.get(i12));
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        return arrayList;
    }

    public void groupReadReport(String str) {
        this.provider.groupReadReport(str);
    }

    public void handleRevoke(String str) {
        IMessageRecyclerView iMessageRecyclerView;
        boolean z11;
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "handleInvoke unSafetyCall");
            return;
        }
        TUIChatLog.i(TAG, "handleInvoke msgID = " + str);
        for (int i11 = 0; i11 < this.loadedMessageInfoList.size(); i11++) {
            TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i11);
            if (tUIMessageBean.getId().equals(str)) {
                tUIMessageBean.setStatus(TUIMessageBean.MSG_STATUS_REVOKE);
                updateAdapter(4, i11);
                if (isChatFragmentShow() && (iMessageRecyclerView = this.messageRecyclerView) != null && iMessageRecyclerView.isDisplayJumpMessageLayout() && tUIMessageBean.getStatus() == 275) {
                    int i12 = this.currentChatUnreadCount - 1;
                    this.currentChatUnreadCount = i12;
                    if (i12 <= 0) {
                        this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                        this.mCacheNewMessage = null;
                        this.currentChatUnreadCount = 0;
                    } else {
                        ChatInfo chatInfo = getChatInfo();
                        if (chatInfo == null || (chatInfo.getType() != 2 ? tUIMessageBean.getV2TIMMessage().getTimestamp() > this.mCacheNewMessage.getV2TIMMessage().getTimestamp() : tUIMessageBean.getV2TIMMessage().getSeq() > this.mCacheNewMessage.getV2TIMMessage().getSeq())) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (!z11) {
                            this.messageRecyclerView.displayBackToNewMessage(true, this.mCacheNewMessage.getId(), this.currentChatUnreadCount);
                            return;
                        }
                        int i13 = i11 + 1;
                        if (i13 < this.loadedMessageInfoList.size()) {
                            TUIMessageBean tUIMessageBean2 = this.loadedMessageInfoList.get(i13);
                            this.mCacheNewMessage = tUIMessageBean2;
                            this.messageRecyclerView.displayBackToNewMessage(true, tUIMessageBean2.getId(), this.currentChatUnreadCount);
                        } else {
                            this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                            this.mCacheNewMessage = null;
                        }
                    }
                }
            }
        }
    }

    public void initMessageSender() {
        this.baseMessageSender = new IBaseMessageSender() {
            public String sendMessage(TUIMessageBean tUIMessageBean, String str, boolean z11) {
                return ChatPresenter.this.sendMessage(tUIMessageBean, str, z11);
            }
        };
        TUIChatService.getInstance().setMessageSender(this.baseMessageSender);
    }

    public boolean isChatFragmentShow() {
        return this.isChatFragmentShow;
    }

    public boolean isNeedShowTranslation() {
        return this.isNeedShowTranslation;
    }

    public boolean isSupportTyping(long j11) {
        return false;
    }

    public void limitReadReport(final String str, final boolean z11) {
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = currentTimeMillis - this.lastReadReportTime;
        if (j11 >= 1000) {
            readReport(str, z11);
            this.lastReadReportTime = currentTimeMillis;
        } else if (!this.canReadReport) {
            TUIChatLog.d(TAG, "limitReadReport : Reporting , please wait.");
        } else {
            long j12 = 1000 - j11;
            String str2 = TAG;
            TUIChatLog.d(str2, "limitReadReport : Please retry after " + j12 + " ms.");
            this.canReadReport = false;
            this.readReportHandler.postDelayed(new Runnable() {
                public void run() {
                    ChatPresenter.this.readReport(str, z11);
                    long unused = ChatPresenter.this.lastReadReportTime = System.currentTimeMillis();
                    boolean unused2 = ChatPresenter.this.canReadReport = true;
                }
            }, j12);
        }
    }

    public void loadApplyList(IUIKitCallback<List<GroupApplyInfo>> iUIKitCallback) {
        this.loadApplyHandler.removeCallbacksAndMessages((Object) null);
        LoadApplyListRunnable loadApplyListRunnable = new LoadApplyListRunnable();
        IUIKitCallback unused = loadApplyListRunnable.callback = iUIKitCallback;
        this.loadApplyHandler.post(loadApplyListRunnable);
    }

    public void loadAtMessage(long j11, String str) {
        if (!TextUtils.isEmpty(str)) {
            V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
            v2TIMMessageListGetOption.setGroupID(str);
            v2TIMMessageListGetOption.setCount(20);
            v2TIMMessageListGetOption.setGetType(1);
            v2TIMMessageListGetOption.setLastMsgSeq(j11);
            V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() {
                public void onError(int i11, String str) {
                    String access$100 = ChatPresenter.TAG;
                    TUIChatLog.e(access$100, "loadChatMessages getC2CHistoryMessageList failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
                }

                public void onSuccess(List<V2TIMMessage> list) {
                    ChatPresenter.this.onLoadedMessageProcessed(ChatMessageParser.parseMessageList(list), 4);
                }
            });
        }
    }

    public void loadHistoryMessageList(String str, boolean z11, final int i11, final int i12, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        if (i11 == 2 || i11 == 3) {
            loadToWayMessageAsync(str, z11, i11, i12, tUIMessageBean, iUIKitCallback);
            return;
        }
        this.provider.loadHistoryMessageList(str, z11, i12, tUIMessageBean, i11, new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(List<TUIMessageBean> list) {
                if (i11 == 1) {
                    if (list.size() >= i12) {
                        ChatPresenter.this.isHaveMoreNewMessage = true;
                    } else {
                        ChatPresenter.this.isHaveMoreNewMessage = false;
                    }
                }
                ChatPresenter.this.onMessageLoadCompleted(list, i11);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
            }
        });
    }

    public void loadMessage(int i11, TUIMessageBean tUIMessageBean) {
        if (i11 == 1 && !this.isHaveMoreNewMessage) {
            updateAdapter(3, 0);
        } else if (i11 != 0 || this.isHaveMoreOldMessage) {
            loadMessage(i11, tUIMessageBean, (IUIKitCallback<List<TUIMessageBean>>) null);
        } else {
            updateAdapter(2, 0);
        }
    }

    public void loadMessage(int i11, TUIMessageBean tUIMessageBean, IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
    }

    public void loadUserStatus(List<String> list, IUIKitCallback<Map<String, UserStatusBean>> iUIKitCallback) {
        this.provider.loadUserStatus(list, iUIKitCallback);
    }

    public void locateMessage(String str, final IUIKitCallback<Void> iUIKitCallback) {
        for (TUIMessageBean next : this.loadedMessageInfoList) {
            if (TextUtils.equals(str, next.getId())) {
                if (next.getStatus() == 275) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                    return;
                } else {
                    updateAdapter(9, next);
                    return;
                }
            }
        }
        findMessage(str, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean.getStatus() == 275) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                    return;
                }
                ChatPresenter.this.loadedMessageInfoList.clear();
                ChatPresenter.this.updateAdapter(0, 0);
                ChatPresenter.this.loadMessage(3, tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() {
                    public void onError(String str, int i11, String str2) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                    }

                    public void onSuccess(List<TUIMessageBean> list) {
                    }
                });
            }
        });
    }

    public void locateMessageBySeq(String str, final long j11, final IUIKitCallback<Void> iUIKitCallback) {
        if (j11 < 0) {
            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "invalid param");
        } else {
            this.provider.getGroupMessageBySeq(str, j11, new IUIKitCallback<List<TUIMessageBean>>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(List<TUIMessageBean> list) {
                    if (list == null || list.size() == 0) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, -1, "null message");
                        return;
                    }
                    TUIMessageBean tUIMessageBean = list.get(0);
                    if (tUIMessageBean.getMsgSeq() != j11) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, -1, "can't find origin message");
                    } else if (tUIMessageBean.getStatus() == 275) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                    } else {
                        ChatPresenter.this.locateMessage(tUIMessageBean.getId(), new IUIKitCallback<Void>() {
                            public void onError(String str, int i11, String str2) {
                                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                            }

                            public void onSuccess(Void voidR) {
                            }
                        });
                    }
                }
            });
        }
    }

    public void markCallingMsgRead(List<CallingMessageBean> list) {
        for (CallingMessageBean next : list) {
            if (next.isShowUnreadPoint()) {
                next.setShowUnreadPoint(false);
                next.getV2TIMMessage().setLocalCustomInt(1);
            }
        }
    }

    public void markMessageAsRead(ChatInfo chatInfo) {
        if (chatInfo == null) {
            TUIChatLog.i(TAG, "markMessageAsRead() chatInfo is null");
            return;
        }
        boolean z11 = true;
        if (chatInfo.getType() == 1) {
            z11 = false;
        }
        String id2 = chatInfo.getId();
        if (z11) {
            groupReadReport(id2);
        } else {
            c2cReadReport(id2);
        }
    }

    public void modifyMessage(TUIMessageBean tUIMessageBean) {
        this.provider.modifyMessage(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() {
            public void onError(int i11, String str, TUIMessageBean tUIMessageBean) {
                ToastUtil.toastShortMessage("modify failed code=" + i11 + " msg=" + str);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                ChatPresenter.this.onRecvMessageModified(tUIMessageBean);
            }
        });
    }

    public void modifyRootMessageToAddReplyInfo(final ReplyMessageBean replyMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        findMessage(replyMessageBean.getMsgRootId(), (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                ChatPresenter.this.modifyRootMessageToAddReplyInfo(tUIMessageBean, replyMessageBean);
            }
        });
    }

    public void modifyRootMessageToRemoveReplyInfo(final ReplyMessageBean replyMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        findMessage(replyMessageBean.getMsgRootId(), (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                ChatPresenter.this.modifyRootMessageToRemoveReplyInfo(tUIMessageBean, replyMessageBean);
            }
        });
    }

    public void onExitChat(String str) {
        WeakReference<ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatNotifyHandler) this.chatNotifyHandler.get()).onExitChat(str);
        }
    }

    public void onMessageLoadCompleted(List<TUIMessageBean> list, int i11) {
    }

    public void onMessageReadReceiptUpdated(List<TUIMessageBean> list, List<MessageReceiptInfo> list2) {
        for (MessageReceiptInfo next : list2) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i11);
                if (TextUtils.equals(tUIMessageBean.getId(), next.getMsgID())) {
                    tUIMessageBean.setMessageReceiptInfo(next);
                    updateAdapter(4, i11);
                }
            }
        }
    }

    public void onReadReport(List<MessageReceiptInfo> list) {
        String str = TAG;
        TUIChatLog.i(str, "onReadReport:" + list.size());
        if (!safetyCall()) {
            TUIChatLog.w(str, "onReadReport unSafetyCall");
        } else if (list.size() != 0) {
            MessageReceiptInfo messageReceiptInfo = list.get(0);
            for (MessageReceiptInfo next : list) {
                if (TextUtils.equals(next.getUserID(), getChatInfo().getId()) && messageReceiptInfo.getTimestamp() < next.getTimestamp()) {
                    messageReceiptInfo = next;
                }
            }
            for (int i11 = 0; i11 < this.loadedMessageInfoList.size(); i11++) {
                TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i11);
                if (TextUtils.equals(tUIMessageBean.getUserId(), messageReceiptInfo.getUserID())) {
                    if (tUIMessageBean.getMessageTime() > messageReceiptInfo.getTimestamp()) {
                        tUIMessageBean.setPeerRead(false);
                    } else if (!tUIMessageBean.isPeerRead()) {
                        tUIMessageBean.setPeerRead(true);
                        updateAdapter(4, i11);
                    }
                }
            }
        }
    }

    public void onReceiveCustomMessage(TUIMessageBean tUIMessageBean) {
    }

    public void onRecvMessageModified(final TUIMessageBean tUIMessageBean) {
        int size = this.loadedMessageInfoList.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            } else if (TextUtils.equals(this.loadedMessageInfoList.get(i11).getId(), tUIMessageBean.getId())) {
                this.loadedMessageInfoList.set(i11, tUIMessageBean);
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            preProcessMessage(tUIMessageBean, (IUIKitCallback<TUIMessageBean>) new IUIKitCallback<TUIMessageBean>() {
                public void onError(String str, int i11, String str2) {
                    ChatPresenter.this.getReadReceiptAndRefresh(tUIMessageBean);
                }

                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    ChatPresenter.this.getReadReceiptAndRefresh(tUIMessageBean);
                }
            });
        }
    }

    public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
        String str = TAG;
        TUIChatLog.i(str, "onRecvNewMessage msgID:" + tUIMessageBean.getId());
        if (tUIMessageBean.getV2TIMMessage().getElemType() == 2) {
            onReceiveCustomMessage(tUIMessageBean);
        } else if (!this.isHaveMoreNewMessage) {
            addMessage(tUIMessageBean);
        }
    }

    public void processLoadedMessage(final List<TUIMessageBean> list, final int i11) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            TUIMessageBean tUIMessageBean = list.get(i12);
            if (!checkExist(tUIMessageBean)) {
                arrayList.add(tUIMessageBean);
            }
        }
        preProcessMessage((List<TUIMessageBean>) arrayList, (IUIKitCallback<List<TUIMessageBean>>) new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                ChatPresenter.this.onLoadedMessageProcessed(list, i11);
            }

            public void onSuccess(List<TUIMessageBean> list) {
                ChatPresenter.this.onLoadedMessageProcessed(list, i11);
            }
        });
    }

    public void quitGroup(String str, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getInstance().quitGroup(str, new V2TIMCallback() {
            public void onError(int i11, String str) {
                TUIGroupUtils.callbackOnError(iUIKitCallback, ChatPresenter.TAG, i11, str);
            }

            public void onSuccess() {
                TUIGroupUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void reactMessage(final String str, TUIMessageBean tUIMessageBean) {
        ChatModifyMessageHelper.enqueueTask(new ChatModifyMessageHelper.ModifyMessageTask(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                ToastUtil.toastShortMessage("reactMessage failed code=" + i11 + " msg=" + str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
            }
        }) {
            public TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean) {
                MessageReactBean messageReactBean = tUIMessageBean.getMessageReactBean();
                if (messageReactBean == null) {
                    messageReactBean = new MessageReactBean();
                }
                messageReactBean.operateUser(str, TUILogin.getLoginUser());
                tUIMessageBean.setMessageReactBean(messageReactBean);
                return tUIMessageBean;
            }
        });
    }

    public void release() {
        this.loadedMessageInfoList.clear();
        this.locateMessage = null;
    }

    public void resetCurrentChatUnreadCount() {
        WeakReference<ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatNotifyHandler) this.chatNotifyHandler.get()).resetCurrentChatUnreadCount();
        }
    }

    public void resetNewMessageCount() {
        this.currentChatUnreadCount = 0;
        this.mCacheNewMessage = null;
    }

    public void revokeMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "revokeMessage unSafetyCall");
        } else {
            this.provider.revokeMessage(tUIMessageBean, new IUIKitCallback<Void>() {
                public void onError(String str, int i11, String str2) {
                    if (i11 == 6223 || i11 == 10031 || i11 == 20016) {
                        ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.send_two_mins));
                        return;
                    }
                    ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.revoke_fail) + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                }

                public void onSuccess(Void voidR) {
                    if (!ChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(ChatPresenter.TAG, "revokeMessage unSafetyCall");
                    } else {
                        ChatPresenter.this.updateMessageRevoked(tUIMessageBean.getId());
                    }
                }
            });
        }
    }

    public boolean safetyCall() {
        return getChatInfo() != null;
    }

    public void scrollToNewestMessage() {
        if (!this.isHaveMoreNewMessage) {
            this.messageListAdapter.onScrollToEnd();
            return;
        }
        this.loadedMessageInfoList.clear();
        this.messageListAdapter.onViewNeedRefresh(0, 0);
        this.isHaveMoreOldMessage = true;
        loadMessage(0, (TUIMessageBean) null);
    }

    public String sendMessage(TUIMessageBean tUIMessageBean, String str, boolean z11) {
        if (TextUtils.isEmpty(str) || (TextUtils.equals(getChatInfo().getId(), str) && z11 == TUIChatUtils.isGroupChat(getChatInfo().getType()))) {
            return sendMessage(tUIMessageBean, false, (IUIKitCallback<TUIMessageBean>) null);
        }
        return null;
    }

    public void sendMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean next : list) {
            if (next.isNeedReadReceipt()) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.provider.sendMessageReadReceipt(arrayList, new IUIKitCallback<Void>() {
                public void onError(String str, int i11, String str2) {
                    String access$100 = ChatPresenter.TAG;
                    TUIChatLog.e(access$100, "sendMessageReadReceipt failed, errCode " + i11 + " errMsg " + str2);
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(Void voidR) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
                }
            });
        }
    }

    public void sendTypingStatusMessage(TUIMessageBean tUIMessageBean, String str, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
    }

    public void setChatFragmentShow(boolean z11) {
        this.isChatFragmentShow = z11;
    }

    public void setChatNotifyHandler(ChatNotifyHandler chatNotifyHandler2) {
        this.chatNotifyHandler = new WeakReference<>(chatNotifyHandler2);
    }

    public void setDraft(String str) {
        ChatInfo chatInfo = getChatInfo();
        if (chatInfo != null) {
            this.provider.setDraft(TUIChatUtils.getConversationIdByUserId(chatInfo.getId(), TUIChatUtils.isGroupChat(chatInfo.getType())), str);
        }
    }

    public void setMessageListAdapter(IMessageAdapter iMessageAdapter) {
        this.messageListAdapter = iMessageAdapter;
    }

    public void setMessageRecycleView(IMessageRecyclerView iMessageRecyclerView) {
        this.messageRecyclerView = iMessageRecyclerView;
        this.currentChatUnreadCount = 0;
        this.mCacheNewMessage = null;
    }

    public void setMessageReplyBean(MessageRepliesBean messageRepliesBean, Map<String, ReactUserBean> map) {
        List<MessageRepliesBean.ReplyBean> replies = messageRepliesBean.getReplies();
        if (replies != null && replies.size() > 0) {
            for (MessageRepliesBean.ReplyBean next : replies) {
                ReactUserBean reactUserBean = map.get(next.getMessageSender());
                if (reactUserBean != null) {
                    next.setSenderFaceUrl(reactUserBean.getFaceUrl());
                    next.setSenderShowName(reactUserBean.getDisplayString());
                }
            }
        }
    }

    public void setNeedShowTranslation(boolean z11) {
        this.isNeedShowTranslation = z11;
    }

    public void updateAdapter(int i11, int i12) {
        WeakReference<ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatNotifyHandler) this.chatNotifyHandler.get()).updateAdapter(i11, i12);
        }
    }

    public void updateMessageInfo(TUIMessageBean tUIMessageBean, int i11) {
        for (int i12 = 0; i12 < this.loadedMessageInfoList.size(); i12++) {
            if (this.loadedMessageInfoList.get(i12) != null && this.loadedMessageInfoList.get(i12).getId().equals(tUIMessageBean.getId())) {
                this.loadedMessageInfoList.set(i12, tUIMessageBean);
                updateAdapter(i11, tUIMessageBean);
                return;
            }
        }
    }

    public boolean updateMessageRevoked(String str) {
        for (int i11 = 0; i11 < this.loadedMessageInfoList.size(); i11++) {
            TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i11);
            if (tUIMessageBean.getId().equals(str)) {
                tUIMessageBean.setStatus(TUIMessageBean.MSG_STATUS_REVOKE);
                updateAdapter(4, i11);
            }
        }
        return false;
    }

    public void getMessageReadReceipt(List<TUIMessageBean> list, IUIKitCallback<List<MessageReceiptInfo>> iUIKitCallback) {
        this.provider.getMessageReadReceipt(list, iUIKitCallback);
    }

    /* access modifiers changed from: private */
    public void modifyRootMessageToAddReplyInfo(final TUIMessageBean tUIMessageBean, final ReplyMessageBean replyMessageBean) {
        ChatModifyMessageHelper.enqueueTask(new ChatModifyMessageHelper.ModifyMessageTask(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                ToastUtil.toastShortMessage("modifyRootMessageAddReply failed code=" + i11 + " msg=" + str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", tUIMessageBean.getGroupId());
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_REPLY_MESSAGE_SUCCESS, hashMap);
            }
        }) {
            public TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean) {
                MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
                if (messageRepliesBean == null) {
                    messageRepliesBean = new MessageRepliesBean();
                }
                messageRepliesBean.addReplyMessage(replyMessageBean.getId(), replyMessageBean.getContentMessageBean().getExtra(), replyMessageBean.getSender());
                tUIMessageBean.setMessageRepliesBean(messageRepliesBean);
                return tUIMessageBean;
            }
        });
    }

    /* access modifiers changed from: private */
    public void modifyRootMessageToRemoveReplyInfo(TUIMessageBean tUIMessageBean, final ReplyMessageBean replyMessageBean) {
        ChatModifyMessageHelper.enqueueTask(new ChatModifyMessageHelper.ModifyMessageTask(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                ToastUtil.toastShortMessage("modifyRootMessageRemoveReply failed code=" + i11 + " msg=" + str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
            }
        }) {
            public TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean) {
                MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
                if (messageRepliesBean == null) {
                    return tUIMessageBean;
                }
                messageRepliesBean.removeReplyMessage(replyMessageBean.getId());
                tUIMessageBean.setMessageRepliesBean(messageRepliesBean);
                return tUIMessageBean;
            }
        });
    }

    public void updateAdapter(int i11, TUIMessageBean tUIMessageBean) {
        WeakReference<ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatNotifyHandler) this.chatNotifyHandler.get()).updateAdapter(i11, tUIMessageBean);
        }
    }

    public void preProcessMessage(final List<TUIMessageBean> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        for (TUIMessageBean next : list) {
            if (next instanceof ReplyMessageBean) {
                arrayList.add(((ReplyMessageBean) next).getOriginMsgId());
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadUtils.execute(new Runnable() {
            public void run() {
                if (arrayList.isEmpty()) {
                    countDownLatch.countDown();
                } else {
                    ChatPresenter.this.findMessage((List<String>) arrayList, (IUIKitCallback<List<TUIMessageBean>>) new IUIKitCallback<List<TUIMessageBean>>() {
                        public void onError(String str, int i11, String str2) {
                            countDownLatch.countDown();
                        }

                        public void onSuccess(List<TUIMessageBean> list) {
                            for (int i11 = 0; i11 < list.size(); i11++) {
                                TUIMessageBean tUIMessageBean = list.get(i11);
                                if (tUIMessageBean != null) {
                                    for (TUIMessageBean tUIMessageBean2 : list) {
                                        if (tUIMessageBean2 instanceof ReplyMessageBean) {
                                            ReplyMessageBean replyMessageBean = (ReplyMessageBean) tUIMessageBean2;
                                            if (TextUtils.equals(replyMessageBean.getOriginMsgId(), tUIMessageBean.getId())) {
                                                replyMessageBean.setOriginMessageBean(tUIMessageBean);
                                            }
                                        }
                                    }
                                }
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
            }
        });
        ThreadUtils.execute(new Runnable() {
            public void run() {
                Set<String> reactUserNames = ChatPresenter.this.getReactUserNames(list);
                reactUserNames.addAll(ChatPresenter.this.getReplyUserNames(list));
                if (reactUserNames.isEmpty()) {
                    countDownLatch.countDown();
                } else {
                    ChatPresenter.this.getReactUserBean(reactUserNames, new IUIKitCallback<Map<String, ReactUserBean>>() {
                        public void onError(String str, int i11, String str2) {
                            countDownLatch.countDown();
                        }

                        public void onSuccess(Map<String, ReactUserBean> map) {
                            for (TUIMessageBean tUIMessageBean : list) {
                                MessageReactBean messageReactBean = tUIMessageBean.getMessageReactBean();
                                if (messageReactBean != null) {
                                    messageReactBean.setReactUserBeanMap(map);
                                }
                                MessageRepliesBean messageRepliesBean = tUIMessageBean.getMessageRepliesBean();
                                if (messageRepliesBean != null) {
                                    ChatPresenter.this.setMessageReplyBean(messageRepliesBean, map);
                                }
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
            }
        });
        ThreadUtils.execute(new Runnable() {
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e11) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "mergeRunnable error");
                    e11.printStackTrace();
                }
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        AnonymousClass14 r02 = AnonymousClass14.this;
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                    }
                });
            }
        });
    }

    public String sendMessage(final TUIMessageBean tUIMessageBean, boolean z11, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "sendMessage unSafetyCall");
            return null;
        } else if (tUIMessageBean == null || tUIMessageBean.getStatus() == 1) {
            return null;
        } else {
            tUIMessageBean.setRead(true);
            assembleGroupMessage(tUIMessageBean);
            notifyConversationInfo(getChatInfo());
            String sendMessage = this.provider.sendMessage(tUIMessageBean, getChatInfo(), new IUIKitCallback<TUIMessageBean>() {
                public void onError(String str, int i11, String str2) {
                    String access$100 = ChatPresenter.TAG;
                    TUIChatLog.v(access$100, "sendMessage fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                    if (!ChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                        return;
                    }
                    TUIChatUtils.callbackOnError(iUIKitCallback, ChatPresenter.TAG, i11, str2);
                    tUIMessageBean.setStatus(3);
                    ChatPresenter.this.updateMessageInfo(tUIMessageBean, 4);
                }

                public void onProgress(Object obj) {
                    TUIChatUtils.callbackOnProgress(iUIKitCallback, obj);
                }

                public void onSuccess(TUIMessageBean tUIMessageBean) {
                    String access$100 = ChatPresenter.TAG;
                    TUIChatLog.v(access$100, "sendMessage onSuccess:" + tUIMessageBean.getId());
                    if (!ChatPresenter.this.safetyCall()) {
                        TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                        return;
                    }
                    tUIMessageBean.setStatus(2);
                    TUIMessageBean tUIMessageBean2 = tUIMessageBean;
                    if (tUIMessageBean2 instanceof FileMessageBean) {
                        tUIMessageBean2.setDownloadStatus(6);
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
                    ChatPresenter.this.updateMessageInfo(tUIMessageBean, 4);
                    HashMap hashMap = new HashMap();
                    hashMap.put("messageBean", tUIMessageBean);
                    TUICore.notifyEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, hashMap);
                }
            });
            String str = TAG;
            TUIChatLog.i(str, "sendMessage msgID:" + sendMessage);
            tUIMessageBean.setId(sendMessage);
            tUIMessageBean.setStatus(1);
            if (z11) {
                resendMessageInfo(tUIMessageBean);
            } else {
                addMessageInfo(tUIMessageBean);
            }
            return sendMessage;
        }
    }

    public void findMessage(List<String> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        this.provider.findMessage(list, new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
            }

            public void onSuccess(List<TUIMessageBean> list) {
                if (list == null || list.isEmpty()) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, 0, "");
                } else {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                }
            }
        });
    }
}
