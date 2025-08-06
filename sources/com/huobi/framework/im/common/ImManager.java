package com.huobi.framework.im.common;

import android.content.Context;
import android.os.Bundle;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationListener;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMSimpleMsgListener;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks;
import com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.d0;

public final class ImManager {
    public static final ImManager INSTANCE = new ImManager();
    private static final String TAG = ImManager.class.getSimpleName();
    public static Context appContext;

    private ImManager() {
    }

    private final String parseConversationID(boolean z11, String str) {
        if (z11) {
            d0 d0Var = d0.f56774a;
            return String.format("group_%s", Arrays.copyOf(new Object[]{str}, 1));
        }
        d0 d0Var2 = d0.f56774a;
        return String.format("c2c_%s", Arrays.copyOf(new Object[]{str}, 1));
    }

    private final void startActivity(String str, Bundle bundle) {
        TUICore.startActivity(str, bundle);
    }

    private final void startCall(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUICalling.SENDER, str);
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_CALLMODEL, str2);
        TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_START_CALL, hashMap);
    }

    public final void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        V2TIMManager.getMessageManager().addAdvancedMsgListener(v2TIMAdvancedMsgListener);
    }

    public final void addConversationListener(V2TIMConversationListener v2TIMConversationListener) {
        V2TIMManager.getConversationManager().addConversationListener(v2TIMConversationListener);
    }

    public final void addIMSDKListener(V2TIMSDKListener v2TIMSDKListener) {
        V2TIMManager.getInstance().addIMSDKListener(v2TIMSDKListener);
    }

    public final void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        V2TIMManager.getInstance().addSimpleMsgListener(v2TIMSimpleMsgListener);
    }

    public final void deleteConversation(String str, boolean z11, V2TIMCallback v2TIMCallback) {
        V2TIMManager.getConversationManager().deleteConversation(parseConversationID(z11, str), v2TIMCallback);
    }

    public final Context getAppContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        return null;
    }

    public final HbBarrageManager getBarrageManager() {
        return HbBarrageManager.getInstance();
    }

    public final void getC2CLastMessage(String str, OnGetLastMessageListener onGetLastMessageListener) {
        V2TIMManager.getMessageManager().getC2CHistoryMessageList(str, 1, (V2TIMMessage) null, new ImManager$getC2CLastMessage$1(onGetLastMessageListener));
    }

    public final void getC2CLastTextMessage(String str, OnGetLastTextListener onGetLastTextListener) {
        V2TIMManager.getMessageManager().getC2CHistoryMessageList(str, 1, (V2TIMMessage) null, new ImManager$getC2CLastTextMessage$1(onGetLastTextListener));
    }

    public final void getC2cUnReadCount(String str, OnGetUnreadCountListener onGetUnreadCountListener) {
        V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
        d0 d0Var = d0.f56774a;
        conversationManager.getConversation(String.format("c2c_%s", Arrays.copyOf(new Object[]{str}, 1)), new ImManager$getC2cUnReadCount$1(onGetUnreadCountListener));
    }

    public final void getConversation(String str, boolean z11, V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback) {
        V2TIMManager.getConversationManager().getConversation(parseConversationID(z11, str), v2TIMValueCallback);
    }

    public final void getConversationList(long j11, int i11, V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        V2TIMManager.getConversationManager().getConversationList(j11, i11, v2TIMValueCallback);
    }

    public final HbGroupChatManager getGroupChatManager() {
        return HbGroupChatManager.getInstance();
    }

    public final void getGroupLastMessage(String str, OnGetLastMessageListener onGetLastMessageListener) {
        V2TIMManager.getMessageManager().getGroupHistoryMessageList(str, 1, (V2TIMMessage) null, new ImManager$getGroupLastMessage$1(onGetLastMessageListener));
    }

    public final void getGroupLastTextMessage(String str, OnGetLastTextListener onGetLastTextListener) {
        V2TIMManager.getMessageManager().getGroupHistoryMessageList(str, 1, (V2TIMMessage) null, new ImManager$getGroupLastTextMessage$1(onGetLastTextListener));
    }

    public final void getGroupUnReadCount(String str, OnGetUnreadCountListener onGetUnreadCountListener) {
        V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
        d0 d0Var = d0.f56774a;
        conversationManager.getConversation(String.format("group_%s", Arrays.copyOf(new Object[]{str}, 1)), new ImManager$getGroupUnReadCount$1(onGetUnreadCountListener));
    }

    public final String getTAG() {
        return TAG;
    }

    public final boolean init(Context context, int i11, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener) {
        setAppContext(context.getApplicationContext());
        return TUILogin.init(context, i11, v2TIMSDKConfig, v2TIMSDKListener);
    }

    public final void initContext(Context context, int i11) {
        setAppContext(context.getApplicationContext());
        TUILogin.initContext(context, i11);
    }

    public final boolean isUserLogined() {
        return TUILogin.isUserLogined();
    }

    public final void joinChatGroup(String str) {
        joinChatGroup(str, (ImCommonCallback) null);
    }

    public final void login(String str, String str2, ImCommonCallback imCommonCallback) {
        TUILogin.login(str, str2, new ImManager$login$1(imCommonCallback));
    }

    public final void logout(ImCommonCallback imCommonCallback) {
        TUILogin.logout((V2TIMCallback) new ImManager$logout$1(imCommonCallback));
    }

    public final void markAllMessageAsRead(ImCommonCallback imCommonCallback) {
        V2TIMManager.getMessageManager().markAllMessageAsRead(new ImManager$markAllMessageAsRead$1(imCommonCallback));
    }

    public final void pinConversation(String str, boolean z11, boolean z12, V2TIMCallback v2TIMCallback) {
        V2TIMManager.getConversationManager().pinConversation(parseConversationID(z11, str), z12, v2TIMCallback);
    }

    public final void quitChatGroup(String str) {
        V2TIMManager.getInstance().quitGroup(str, new ImManager$quitChatGroup$1());
    }

    public final void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        V2TIMManager.getMessageManager().removeAdvancedMsgListener(v2TIMAdvancedMsgListener);
    }

    public final void removeConversationListener(V2TIMConversationListener v2TIMConversationListener) {
        V2TIMManager.getConversationManager().removeConversationListener(v2TIMConversationListener);
    }

    public final void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        V2TIMManager.getInstance().removeSimpleMsgListener(v2TIMSimpleMsgListener);
    }

    public final void setActivityActionListener(BusinessCallbacks.ActivityActionListener activityActionListener) {
        BusinessCallbacks.activityActionWeakReference = new WeakReference<>(activityActionListener);
    }

    public final void setAppContext(Context context) {
        appContext = context;
    }

    public final void setGroupTrackListener(BusinessCallbacks.ImGroupTrackListener imGroupTrackListener) {
        BusinessCallbacks.trackListenerWeakReference = new WeakReference<>(imGroupTrackListener);
    }

    public final void startC2CChat(String str, String str2) {
        startChat(str, str2, 1);
    }

    public final void startChat(String str, String str2, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString("chatId", str);
        bundle.putString(TUIConstants.TUIChat.CHAT_NAME, str2);
        bundle.putInt(TUIConstants.TUIChat.CHAT_TYPE, i11);
        if (i11 == 1) {
            TUICore.startActivity(TUIConstants.TUIChat.C2C_CHAT_ACTIVITY_NAME, bundle);
        } else if (i11 == 2) {
            TUICore.startActivity(TUIConstants.TUIChat.GROUP_CHAT_ACTIVITY_NAME, bundle);
        }
    }

    public final void startGroupChat(String str, String str2) {
        if (str != null) {
            INSTANCE.joinChatGroup(str);
        }
        startChat(str, str2, 2);
    }

    public final void unInit() {
        TUILogin.unInit();
    }

    public final void joinChatGroup(String str, ImCommonCallback imCommonCallback) {
        V2TIMManager.getInstance().joinGroup(str, "", new ImManager$joinChatGroup$1(imCommonCallback));
    }
}
